package com.mukun.albumserver.dao;

import com.mukun.albumserver.bean.Pictures;

public interface CanvaMapper {
    //查询笔记（一张图片的笔记）
    Pictures findNote(int pic_id);

    //修改笔记
    void updateNote(Pictures picture);
}
