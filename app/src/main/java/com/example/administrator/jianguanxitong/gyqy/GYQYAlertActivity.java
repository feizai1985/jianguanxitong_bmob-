package com.example.administrator.jianguanxitong.gyqy;

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
import com.example.administrator.jianguanxitong.bean.GYQYBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class GYQYAlertActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText gyqyalert_et_name;
    private EditText gyqyalert_et_adress1;
    private EditText gyqyalert_et_adress2;
    private EditText gyqyalert_et_frdb;
    private EditText gyqyalert_et_lxr;
    private EditText gyqyalert_et_zw;
    private EditText gyqyalert_et_telephone;
    private EditText gyqyalert_et_cpmc;
    private EditText gyqyalert_et_cpbz;
    private EditText gyqyalert_et_cpfl;
    private EditText gyqyalert_et_jd;
    private EditText gyqyalert_et_sczk;
    private EditText gyqyalert_et_bate;
    private Button gyqyalert_bt_save;

    private Button gyqyalert_bt_delete;
    private GYQYBean bean;
    private Button gyqyalert_bt_cancle;
    private String objectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyqyalert);
        mContext = this;
        findView();
        huoQeIntent();
        gyqyalert_bt_save.setOnClickListener(this);
        gyqyalert_bt_cancle.setOnClickListener(this);
        gyqyalert_bt_delete.setOnClickListener(this);

    }

    private void huoQeIntent() {
        bean = (GYQYBean) getIntent().getSerializableExtra("xinxi");
        objectId = bean.getObjectId();
        gyqyalert_et_name.setText(bean.getName());
        gyqyalert_et_adress1.setText(bean.getAdress1());
        gyqyalert_et_adress2.setText(bean.getAdress2());
        gyqyalert_et_frdb.setText(bean.getFrdb());
        gyqyalert_et_lxr.setText(bean.getLxr());
        gyqyalert_et_zw.setText(bean.getZw());
        gyqyalert_et_telephone.setText(bean.getTelephone());
        gyqyalert_et_cpmc.setText(bean.getCpmc());
        gyqyalert_et_cpbz.setText(bean.getCpbz());
        gyqyalert_et_cpfl.setText(bean.getCpfl());
        gyqyalert_et_jd.setText(bean.getJd());
        gyqyalert_et_sczk.setText(bean.getSczk());
        gyqyalert_et_bate.setText(bean.getBate());

    }

    private void findView() {
        gyqyalert_et_name = (EditText) findViewById(R.id.gyqyalert_et_name);
        gyqyalert_et_adress1 = (EditText) findViewById(R.id.gyqyalert_et_adress1);
        gyqyalert_et_adress2 = (EditText) findViewById(R.id.gyqyalert_et_adress2);
        gyqyalert_et_frdb = (EditText) findViewById(R.id.gyqyalert_et_frdb);
        gyqyalert_et_lxr = (EditText) findViewById(R.id.gyqyalert_et_lxr);
        gyqyalert_et_zw = (EditText) findViewById(R.id.gyqyalert_et_zw);
        gyqyalert_et_telephone = (EditText) findViewById(R.id.gyqyalert_et_telephone);
        gyqyalert_et_cpmc = (EditText) findViewById(R.id.gyqyalert_et_cpmc);
        gyqyalert_et_cpbz = (EditText) findViewById(R.id.gyqyalert_et_cpbz);
        gyqyalert_et_cpfl = (EditText) findViewById(R.id.gyqyalert_et_cpfl);
        gyqyalert_et_jd = (EditText) findViewById(R.id.gyqyalert_et_jd);
        gyqyalert_et_sczk = (EditText) findViewById(R.id.gyqyalert_et_sczk);
        gyqyalert_et_bate = (EditText) findViewById(R.id.gyqyalert_et_bate);
        gyqyalert_bt_save = (Button) findViewById(R.id.gyqyalert_bt_save);
        gyqyalert_bt_cancle = (Button) findViewById(R.id.gyqyalert_bt_cancle);
        gyqyalert_bt_delete = (Button) findViewById(R.id.gyqyalert_bt_delete);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gyqyalert_bt_save:

                ContentValues values = new ContentValues();
                bean.setName(gyqyalert_et_name.getText().toString());
                bean.setAdress1(gyqyalert_et_adress1.getText().toString());
                bean.setAdress2(gyqyalert_et_adress2.getText().toString());
                bean.setFrdb(gyqyalert_et_frdb.getText().toString());
                bean.setLxr(gyqyalert_et_lxr.getText().toString());
                bean.setZw(gyqyalert_et_zw.getText().toString());
                bean.setTelephone(gyqyalert_et_telephone.getText().toString());
                bean.setCpmc(gyqyalert_et_cpmc.getText().toString());
                bean.setCpbz(gyqyalert_et_cpbz.getText().toString());
                bean.setCpfl(gyqyalert_et_cpfl.getText().toString());
                bean.setJd(gyqyalert_et_jd.getText().toString());
                bean.setSczk(gyqyalert_et_sczk.getText().toString());
                bean.setBate(gyqyalert_et_bate.getText().toString());
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
                startActivity(new Intent(GYQYAlertActivity.this, GYQYActivity.class));
                break;
            case R.id.gyqyalert_bt_cancle:
                finish();

                break;
            case R.id.gyqyalert_bt_delete:
                new AlertDialog.Builder(this)
                        .setTitle("确定删除吗")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                GYQYBean bean1=new GYQYBean();
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
                                startActivity(new Intent(GYQYAlertActivity.this, GYQYActivity.class));
                            }

                        }).show();

                break;
            default:
                break;
        }
    }
}

