package com.mukun.albumserver.service;

import com.mukun.albumserver.bean.Pictures;

import java.util.List;

public interface PicturesService {
    //查询一个相册的全部图片
    List<Pictures> findPictures(int alb_id);

    //查询一张图片
    Pictures findOnePicture(int pic_id);

    //上传图片
    void addPicture(Pictures picture);

    //删除图片
    void deletePicture(int pic_id);
}
