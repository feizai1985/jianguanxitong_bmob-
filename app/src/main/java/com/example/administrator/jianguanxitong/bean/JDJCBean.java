package com.example.administrator.jianguanxitong.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by feizai1985 on 2017/11/18.
 */
public class JDJCBean extends BmobObject implements Serializable {
    public String date;
    public String name;
    public String peitong;
    public String telephone;
    public String content;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeitong() {
        return peitong;
    }

    public void setPeitong(String peitong) {
        this.peitong = peitong;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
