package com.mukun.albumserver.bean;

import java.util.Date;

public class Pictures {                 //图片实体类
    private int pic_id;                 //图片id
    private String pic_name;            //图片名字
    private Date pic_date;              //图片上传时间
    private String note;                //图片笔记
    private int album_id;               //所属相册id

    public Pictures(int pic_id, String pic_name, Date pic_date, String note, int album_id) {
        this.pic_id = pic_id;
        this.pic_name = pic_name;
        this.pic_date = pic_date;
        this.note = note;
        this.album_id = album_id;
    }

    public Pictures() {
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public Date getPic_date() {
        return pic_date;
    }

    public void setPic_date(Date pic_date) {
        this.pic_date = pic_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pic_id=" + pic_id +
                ", pic_name='" + pic_name + '\'' +
                ", pic_date=" + pic_date +
                ", note='" + note + '\'' +
                ", album_id=" + album_id +
                '}';
    }
}
