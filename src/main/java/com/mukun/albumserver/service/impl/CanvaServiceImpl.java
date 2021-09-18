package com.mukun.albumserver.service.impl;

import com.mukun.albumserver.bean.Pictures;
import com.mukun.albumserver.dao.CanvaMapper;
import com.mukun.albumserver.service.CanvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanvaServiceImpl implements CanvaService {

    @Autowired
    private CanvaMapper canvaMapper;

    //查询笔记（一张图片的笔记）
    @Override
    public Pictures findNote(int pic_id) {
        Pictures picture = canvaMapper.findNote(pic_id);
        return picture;
    }

    //修改笔记
    @Override
    public void updateNote(Pictures picture) {
        canvaMapper.updateNote(picture);
    }
}
