package com.example.administrator.jianguanxitong.spxg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.ShiPingXiangGuanActivity;
import com.example.administrator.jianguanxitong.bean.SPXGBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class SPXGAddActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText spxg_et_name;
    private EditText spxg_et_adress1;
    private EditText spxg_et_adress2;
    private EditText spxg_et_frdb;
    private EditText spxg_et_lxr;
    private EditText spxg_et_zw;
    private EditText spxg_et_telephone;
    private EditText spxg_et_cpmc;

    private EditText spxg_et_cpfl;
    private EditText spxg_et_jd;
    private EditText spxg_et_sczk;
    private EditText spxg_et_bate;
    private Button spxg_bt_save;
    private Button spxg_bt_cancle;
    private EditText spxg_et_cpbz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spxgadd);
        mContext = this;

        findview();
        spxg_bt_save.setOnClickListener(this);
        spxg_bt_cancle.setOnClickListener(this);

    }

    private void findview() {
        spxg_et_name = (EditText) findViewById(R.id.spxg_et_name);
        spxg_et_adress1 = (EditText) findViewById(R.id.spxg_et_adress1);
        spxg_et_adress2 = (EditText) findViewById(R.id.spxg_et_adress2);
        spxg_et_frdb = (EditText) findViewById(R.id.spxg_et_frdb);
        spxg_et_lxr = (EditText) findViewById(R.id.spxg_et_lxr);
        spxg_et_zw = (EditText) findViewById(R.id.spxg_et_zw);
        spxg_et_telephone = (EditText) findViewById(R.id.spxg_et_telephone);
        spxg_et_cpmc = (EditText) findViewById(R.id.spxg_et_cpmc);
        spxg_et_cpbz = (EditText) findViewById(R.id.spxg_et_cpbz);
        spxg_et_cpfl = (EditText) findViewById(R.id.spxg_et_cpfl);
        spxg_et_jd = (EditText) findViewById(R.id.spxg_et_jd);
        spxg_et_sczk = (EditText) findViewById(R.id.spxg_et_sczk);
        spxg_et_bate = (EditText) findViewById(R.id.spxg_et_bate);
        spxg_bt_save = (Button) findViewById(R.id.spxg_bt_save);
        spxg_bt_cancle = (Button) findViewById(R.id.spxg_bt_cancle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.spxg_bt_cancle:
                finish();

                break;
            case R.id.spxg_bt_save:
                SPXGBean bean = new SPXGBean();
                bean.setName(spxg_et_name.getText().toString());
                bean.setAdress1(spxg_et_adress1.getText().toString());
                bean.setAdress2(spxg_et_adress2.getText().toString());
                bean.setFrdb(spxg_et_frdb.getText().toString());
                bean.setLxr(spxg_et_lxr.getText().toString());
                bean.setZw(spxg_et_zw.getText().toString());
                bean.setTelephone(spxg_et_telephone.getText().toString());
                bean.setCpmc(spxg_et_cpmc.getText().toString());
                bean.setCpbz(spxg_et_cpbz.getText().toString());
                bean.setCpfl(spxg_et_cpfl.getText().toString());
                bean.setJd(spxg_et_jd.getText().toString());
                bean.setSczk(spxg_et_sczk.getText().toString());
                bean.setBate(spxg_et_bate.getText().toString());
                bean.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e!=null){
                            Toast.makeText(mContext,"添加数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(mContext,"成功添加数据",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();
                startActivity(new Intent(this, ShiPingXiangGuanActivity.class));
                break;

            default:
                break;
        }
    }
}


