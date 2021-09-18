package com.mukun.albumserver.dao;

import com.mukun.albumserver.bean.Albums;
import com.mukun.albumserver.bean.Pictures;

import java.util.List;

public interface AlbumsMapper {
    //查询全部相册
    List<Albums> findAllAllbums();

    //查询一个相册（通过相册id）
    Albums findOneAlbum(int alb_id);

    //修改相册封面图片（default_picture)
    void updateAlbum(Pictures picture);

    //添加相册
    void addAlbum(Albums albums);

    //删除相册
    void deleteAlbum(int alb_id);


}
