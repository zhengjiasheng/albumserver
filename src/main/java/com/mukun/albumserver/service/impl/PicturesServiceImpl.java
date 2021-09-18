package com.mukun.albumserver.service.impl;

import com.mukun.albumserver.bean.Pictures;
import com.mukun.albumserver.dao.PicturesMapper;
import com.mukun.albumserver.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicturesServiceImpl implements PicturesService {

    @Autowired
    private PicturesMapper picturesMapper;

    //查询一个相册的全部图片
    @Override
    public List<Pictures> findPictures(int alb_id) {
        List<Pictures> list = picturesMapper.findPictures(alb_id);
        return list;
    }

    //查询一张图片
    @Override
    public Pictures findOnePicture(int pic_id) {
        Pictures onePicture = picturesMapper.findOnePicture(pic_id);
        return onePicture;
    }

    //上传图片
    @Override
    public void addPicture(Pictures picture) {
        picturesMapper.addPicture(picture);
    }

    //删除图片
    @Override
    public void deletePicture(int pic_id) {
        picturesMapper.deletePicture(pic_id);
    }
}
