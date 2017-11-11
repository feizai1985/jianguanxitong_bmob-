package com.example.administrator.jianguanxitong.bean;

import java.io.Serializable;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/11/7.
 */
public class HZQEBean extends BmobObject implements  Serializable {

    public String name;
    public String adress;
    public String frdb;
    public String lxr;
    public String zw;
    public String telephone;
    public String cpmc;
    public String cpbz;
    public String hzsj;
    public String dqsj;
    public String sczk;
    public String bate;

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String zh;



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

    public String getCpmc() {
        return cpmc;
    }

    public void setCpmc(String cpmc) {
        this.cpmc = cpmc;
    }

    public String getBate() {
        return bate;
    }

    public void setBate(String bate) {
        this.bate = bate;
    }

    public String getCpbz() {
        return cpbz;
    }

    public void setCpbz(String cpbz) {
        this.cpbz = cpbz;
    }

    public String getHzsj() {
        return hzsj;
    }

    public void setHzsj(String hzsj) {
        this.hzsj = hzsj;
    }

    public String getDqsj() {
        return dqsj;
    }

    public void setDqsj(String dqsj) {
        this.dqsj = dqsj;
    }

    public String getSczk() {
        return sczk;
    }

    public void setSczk(String sczk) {
        this.sczk = sczk;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }



}
