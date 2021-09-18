package com.mukun.albumserver.bean;

import java.util.Date;

public class Albums {                  //相册实体类
    private int alb_id;                //相册id
    private String alb_name;           //相册名字
    private String default_picture;    //相册封面
    private Date abl_date;             //创建时间

    public Albums(int alb_id, String alb_name, String default_picture, Date abl_date) {
        this.alb_id = alb_id;
        this.alb_name = alb_name;
        this.default_picture = default_picture;
        this.abl_date = abl_date;
    }

    public Albums() {
    }

    public int getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(int alb_id) {
        this.alb_id = alb_id;
    }

    public String getAlb_name() {
        return alb_name;
    }

    public void setAlb_name(String alb_name) {
        this.alb_name = alb_name;
    }

    public String getDefault_picture() {
        return default_picture;
    }

    public void setDefault_picture(String default_picture) {
        this.default_picture = default_picture;
    }

    public Date getAbl_date() {
        return abl_date;
    }

    public void setAbl_date(Date abl_date) {
        this.abl_date = abl_date;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "alb_id=" + alb_id +
                ", alb_name='" + alb_name + '\'' +
                ", default_picture='" + default_picture + '\'' +
                ", abl_date=" + abl_date +
                '}';
    }
}
