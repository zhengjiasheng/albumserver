package com.mukun.albumserver.service.impl;


import com.mukun.albumserver.bean.Albums;
import com.mukun.albumserver.bean.Pictures;
import com.mukun.albumserver.dao.AlbumsMapper;
import com.mukun.albumserver.service.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsServiceImpl implements AlbumsService {

    @Autowired
    private AlbumsMapper albumsMapper;

    //查询全部相册
    @Override
    public List<Albums> findAllAllbums() {
        List<Albums> list = albumsMapper.findAllAllbums();
        return list;
    }

    //查询一个相册（通过相册id）
    @Override
    public Albums findOneAlbum(int alb_id) {
        Albums oneAlbum = albumsMapper.findOneAlbum(alb_id);
        return oneAlbum;
    }

    //修改相册封面图片（default_picture)
    @Override
    public void updateAlbum(Pictures picture) {
        albumsMapper.updateAlbum(picture);
    }

    //添加相册
    @Override
    public void addAlbum(Albums albums) {
        albumsMapper.addAlbum(albums);
    }

    //删除相册
    @Override
    public void deleteAlbum(int alb_id) {
        albumsMapper.deleteAlbum(alb_id);
    }

}
