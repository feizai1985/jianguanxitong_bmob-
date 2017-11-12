package com.example.administrator.jianguanxitong.spxg;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.jianguanxitong.GYQYActivity;
import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.ShiPingXiangGuanActivity;
import com.example.administrator.jianguanxitong.bean.GYQYBean;
import com.example.administrator.jianguanxitong.bean.SPXGBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class SPXGAlertActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText spxgalert_et_name;
    private EditText spxgalert_et_adress1;
    private EditText spxgalert_et_adress2;
    private EditText spxgalert_et_frdb;
    private EditText spxgalert_et_lxr;
    private EditText spxgalert_et_zw;
    private EditText spxgalert_et_telephone;
    private EditText spxgalert_et_cpmc;
    private EditText spxgalert_et_cpbz;
    private EditText spxgalert_et_cpfl;
    private EditText spxgalert_et_jd;
    private EditText spxgalert_et_sczk;
    private EditText spxgalert_et_bate;
    private Button spxgalert_bt_save;
    private Button spxgalert_bt_cancle;
    private Button spxgalert_bt_delete;
    private SPXGBean bean;
    private String objectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spxgalert);
        mContext = this;
        findView();
        huoQeIntent();
        spxgalert_bt_save.setOnClickListener(this);
        spxgalert_bt_cancle.setOnClickListener(this);
        spxgalert_bt_delete.setOnClickListener(this);

    }

    private void huoQeIntent() {
        bean = (SPXGBean) getIntent().getSerializableExtra("xinxi");
        objectId = bean.getObjectId();
        spxgalert_et_name.setText(bean.getName());
        spxgalert_et_adress1.setText(bean.getAdress1());
        spxgalert_et_adress2.setText(bean.getAdress2());
        spxgalert_et_frdb.setText(bean.getFrdb());
        spxgalert_et_lxr.setText(bean.getLxr());
        spxgalert_et_zw.setText(bean.getZw());
        spxgalert_et_telephone.setText(bean.getTelephone());
        spxgalert_et_cpmc.setText(bean.getCpmc());
        spxgalert_et_cpbz.setText(bean.getCpbz());
        spxgalert_et_cpfl.setText(bean.getCpfl());
        spxgalert_et_jd.setText(bean.getJd());
        spxgalert_et_sczk.setText(bean.getSczk());
        spxgalert_et_bate.setText(bean.getBate());

    }

    private void findView() {
        spxgalert_et_name = (EditText) findViewById(R.id.spxgalert_et_name);
        spxgalert_et_adress1 = (EditText) findViewById(R.id.spxgalert_et_adress1);
        spxgalert_et_adress2 = (EditText) findViewById(R.id.spxgalert_et_adress2);
        spxgalert_et_frdb = (EditText) findViewById(R.id.spxgalert_et_frdb);
        spxgalert_et_lxr = (EditText) findViewById(R.id.spxgalert_et_lxr);
        spxgalert_et_zw = (EditText) findViewById(R.id.spxgalert_et_zw);
        spxgalert_et_telephone = (EditText) findViewById(R.id.spxgalert_et_telephone);
        spxgalert_et_cpmc = (EditText) findViewById(R.id.spxgalert_et_cpmc);
        spxgalert_et_cpbz = (EditText) findViewById(R.id.spxgalert_et_cpbz);
        spxgalert_et_cpfl = (EditText) findViewById(R.id.spxgalert_et_cpfl);
        spxgalert_et_jd = (EditText) findViewById(R.id.spxgalert_et_jd);
        spxgalert_et_sczk = (EditText) findViewById(R.id.spxgalert_et_sczk);
        spxgalert_et_bate = (EditText) findViewById(R.id.spxgalert_et_bate);
        spxgalert_bt_save = (Button) findViewById(R.id.spxgalert_bt_save);
        spxgalert_bt_cancle = (Button) findViewById(R.id.spxgalert_bt_cancle);
        spxgalert_bt_delete = (Button) findViewById(R.id.spxgalert_bt_delete);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.spxgalert_bt_save:

                ContentValues values = new ContentValues();
                bean.setName(spxgalert_et_name.getText().toString());
                bean.setAdress1(spxgalert_et_adress1.getText().toString());
                bean.setAdress2(spxgalert_et_adress2.getText().toString());
                bean.setFrdb(spxgalert_et_frdb.getText().toString());
                bean.setLxr(spxgalert_et_lxr.getText().toString());
                bean.setZw(spxgalert_et_zw.getText().toString());
                bean.setTelephone(spxgalert_et_telephone.getText().toString());
                bean.setCpmc(spxgalert_et_cpmc.getText().toString());
                bean.setCpbz(spxgalert_et_cpbz.getText().toString());
                bean.setCpfl(spxgalert_et_cpfl.getText().toString());
                bean.setJd(spxgalert_et_jd.getText().toString());
                bean.setSczk(spxgalert_et_sczk.getText().toString());
                bean.setBate(spxgalert_et_bate.getText().toString());
                bean.update(objectId, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e!=null){
                            Toast.makeText(mContext,"保存失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(mContext,"成功保存",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();
                startActivity(new Intent(SPXGAlertActivity.this,ShiPingXiangGuanActivity.class));
                break;
            case R.id.spxgalert_bt_cancle:
                finish();

                break;
            case R.id.spxgalert_bt_delete:
                new AlertDialog.Builder(this)
                        .setTitle("确定删除吗")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                SPXGBean bean1= new SPXGBean();
                                bean1.setObjectId(objectId);
                                bean1.delete(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if(e!=null){
                                            Toast.makeText(mContext,"删除数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                                        }else {
                                            Toast.makeText(mContext,"删除成功",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                finish();
                                startActivity(new Intent(SPXGAlertActivity.this, ShiPingXiangGuanActivity.class));
                            }

                        }).show();

                break;
            default:
                break;
        }
    }
}

