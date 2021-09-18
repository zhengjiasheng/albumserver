package com.mukun.albumserver.service;

import com.mukun.albumserver.bean.Pictures;

public interface CanvaService {
    //查询笔记（一张图片的笔记）
    Pictures findNote(int pic_id);

    //修改笔记
    void updateNote(Pictures picture);
}
