package com.mukun.albumserver.controller;

import com.mukun.albumserver.bean.Pictures;
import com.mukun.albumserver.service.AlbumsService;
import com.mukun.albumserver.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/PicturesController")
public class PicturesController {

    @Autowired
    private PicturesService picturesService;
    @Autowired
    private AlbumsService albumsService;

    //查询一个相册的全部图片
    @RequestMapping("/findPictures")
    public List<Pictures> findPictures(int id) {
        System.out.println(id);
        List<Pictures> list = picturesService.findPictures(id);
        return list;
    }

    //上传图片（把图片上传到指定文件夹images，同时向数据库中添加该图片，同时还要修改相册封面）
    @PostMapping("/addPicture")
    public void addPicture(HttpServletRequest request, int id, @RequestParam("img") MultipartFile file) {//file:接收上传的图片
        //1.将文件上传到指定文件夹
        //获取文件名字
        String filename = file.getOriginalFilename();
        //为文件名加上UUID，防止文件重名被覆盖(将UUID转化为String类型，然后和文件名拼接）
        String uuid = UUID.randomUUID().toString();
        filename = uuid+filename;
        //获取images的真实路径
        String path = request.getServletContext().getRealPath("images");
//      System.out.println(path);
        //在该路径（images）下创建一个新文件就叫filename
        File file1 = new File(path, filename);
        //将上传的文件复制到这个新文件中
        try {
            file.transferTo(file1);
            //文件上传成功

            //2.向数据库中插入该图片
            String pic_name = filename;
            Date pic_date = new Date();
            Pictures picture = new Pictures();
            picture.setPic_name(pic_name);
            picture.setPic_date(pic_date);
            picture.setAlbum_id(id);
            picturesService.addPicture(picture);

            //3.修改相册封面
            albumsService.updateAlbum(picture);
            System.out.println("图片添加成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除图片(删除数据库中图片的数据，同时要删除images中的图片,还要修改相册封面）
    @RequestMapping("/deletePicture")
    public String deletePicture(HttpServletRequest request,int id,String name) {
        //查询该图片所在的相册的id
        Pictures onePicture = picturesService.findOnePicture(id);
        int album_id = onePicture.getAlbum_id();

        /*删除images中的图片*/
        //1.获取图片路径
        String path = request.getServletContext().getRealPath("images")+"\\"+name;
        //2.获取文件
        File file = new File(path);
        //3.删除文件
        if (file.exists()){
            file.delete();
            System.out.println("图片删除成功");
        }else{
            System.out.println("图片不存在");
        }

        /*删除数据库中的数据*/
        picturesService.deletePicture(id);

        /*修改相册封面*/
        //查询该相册的全部图片：如果不为空，就将相册封面修改为时间最晚的图片，否则将封面修改为默认封面（default.jpg)
        List<Pictures> pictures = picturesService.findPictures(album_id);
        if (pictures.size()!=0){//如果该相册不为空
            Pictures picture = pictures.get(0);//时间最晚的图片
            System.out.println(picture);
            //修改相册封面
            albumsService.updateAlbum(picture);
        }else {//相册为空，把相册封面修改为默认图片（default.jpg)
            Pictures default_picture = new Pictures();
            default_picture.setAlbum_id(album_id);
            default_picture.setPic_name("default.jpg");
            albumsService.updateAlbum(default_picture);
        }
        return "删除图片成功";
    }
}
