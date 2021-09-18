package com.mukun.albumserver.controller;
/*
* 配置虚拟路径：为上传的文件配置虚拟路径
* 前端文件上传到本地磁盘，为本地磁盘的该路径配置虚拟路径，那么上传的这个文件就可以在前端直接访问了
* 类似于项目目录webapp,可以被前端直接访问（http://localhost:8887/images/图片名）
* 配置虚拟路径：本地：file:C:/JAVAWORK/UploadFile/UploadImages/  虚拟路径：/upload/**
* （项目url:localhost:8887）浏览器访问：http://localhost:8887/upload/ce.jpg
* */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/JAVAWORK/UploadFile/UploadImages/");
    }

}
