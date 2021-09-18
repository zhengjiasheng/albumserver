package com.mukun.albumserver.controller;

import com.mukun.albumserver.bean.Albums;
import com.mukun.albumserver.bean.Pictures;
import com.mukun.albumserver.service.AlbumsService;
import com.mukun.albumserver.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

//@RestController=@Controller+@ResponseBody
@RestController
@RequestMapping("/AlbumsController")
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;
    @Autowired
    private PicturesService picturesService;

    //查询全部相册
    @RequestMapping("/findAll")
    public List<Albums> findAll(){
        List<Albums> list = albumsService.findAllAllbums();
//        System.out.println(list);
        return list;
    }

    //查询一个相册
    public Albums findOneAlbum(int id){
        Albums oneAlbum = albumsService.findOneAlbum(id);
        return oneAlbum;
    }

    //添加相册
    @RequestMapping("/addAlbum")
    public void addAlbum(String name) {
//        System.out.println(name);
        Date date = new Date();
        Albums album = new Albums();
        album.setAlb_name(name);
        album.setAbl_date(date);
        album.setDefault_picture("default.jpg");
        albumsService.addAlbum(album);
    }

    //删除相册（会将该相册中的图片一并删除）（级联删除）
    @RequestMapping("/deleteAlbum")
    public String deleteAlbum(HttpServletRequest request,int id) {
//        System.out.println(id);
        //查询该相册的所有图片
        List<Pictures> pictures = picturesService.findPictures(id);
        //遍历集合pictures,将images文件夹中的该相册的图片全部删除
        for (Pictures picture : pictures){
            /*删除images中的图片*/
            //1.获取图片路径
            String path = request.getServletContext().getRealPath("images")+"\\"+picture.getPic_name();
            //2.获取文件
            File file = new File(path);
            //3.删除文件
            if (file.exists()){
                file.delete();
                System.out.println("图片删除成功");
            }else{
                System.out.println("图片不存在");
            }
        }
        albumsService.deleteAlbum(id);
        return "删除成功";
    }
}
