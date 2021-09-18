package com.mukun.albumserver.controller;

import com.mukun.albumserver.bean.Pictures;
import com.mukun.albumserver.service.CanvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/CanvaController")
public class CanvaController {

    @Autowired
    private CanvaService canvaService;

    //保存笔记
    //获取请求中的图片id（img_id)和请求体中的图片笔记(note)
    @PostMapping("/saveNote")
    public String saveNote(int img_id,@RequestBody String note) {
//        System.out.println(img_id);
//        System.out.println(note);
//        把数据封装到picture对象中
        Pictures picture = new Pictures();
        picture.setPic_id(img_id);
        picture.setNote(note);
        //保存笔记
        canvaService.updateNote(picture);
        return "保存笔记成功";
    }

    //查询笔记
    //获取请求中的参数id：图片id，用于查询该图片的笔记
    @RequestMapping("/findNote")
    public String findNote(int id) {
//        System.out.println(id);
        //从数据库中查询笔记
        String note = canvaService.findNote(id).getNote();
        if (note==null) {
            note = "[]";
        }
        System.out.println(note);
        //将笔记写入到响应体中，返回给前端页面
        return note;
    }
}
