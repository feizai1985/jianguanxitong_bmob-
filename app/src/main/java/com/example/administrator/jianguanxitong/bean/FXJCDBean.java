package com.example.administrator.jianguanxitong.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by feizai1985 on 2017/11/18.
 */
public class FXJCDBean extends BmobObject implements Serializable {

    public String name;
    public String adress;
    public String lxr;
    public String lxrtelephone;
    public String jcyname1;
    public String jcytelephone1;
    public String jcyname2;
    public String jcytelephone2;
    public String jcyname3;
    public String jcytelephone3;
    public String bate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxrtelephone() {
        return lxrtelephone;
    }

    public void setLxrtelephone(String lxrtelephone) {
        this.lxrtelephone = lxrtelephone;
    }

    public String getJcyname1() {
        return jcyname1;
    }

    public void setJcyname1(String jcyname1) {
        this.jcyname1 = jcyname1;
    }

    public String getJcytelephone1() {
        return jcytelephone1;
    }

    public void setJcytelephone1(String jcytelephone1) {
        this.jcytelephone1 = jcytelephone1;
    }

    public String getJcyname2() {
        return jcyname2;
    }

    public void setJcyname2(String jcyname2) {
        this.jcyname2 = jcyname2;
    }

    public String getJcytelephone2() {
        return jcytelephone2;
    }

    public void setJcytelephone2(String jcytelephone2) {
        this.jcytelephone2 = jcytelephone2;
    }

    public String getJcyname3() {
        return jcyname3;
    }

    public void setJcyname3(String jcyname3) {
        this.jcyname3 = jcyname3;
    }

    public String getJcytelephone3() {
        return jcytelephone3;
    }

    public void setJcytelephone3(String jcytelephone3) {
        this.jcytelephone3 = jcytelephone3;
    }

    public String getBate() {
        return bate;
    }

    public void setBate(String bate) {
        this.bate = bate;
    }




}
