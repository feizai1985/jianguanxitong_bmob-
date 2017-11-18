package com.example.administrator.jianguanxitong.zlts;

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
import com.example.administrator.jianguanxitong.bean.FXJCDBean;
import com.example.administrator.jianguanxitong.bean.GYQYBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class FXJCDAllertActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText fxjcd_et_name;
    private EditText fxjcd_et_adress;
    private EditText fxjcd_et_lxr;
    private EditText fxjcd_et_lxrtelephone;
    private EditText fxjcd_et_jcyname1;
    private EditText fxjcd_et_jcytelephone1;
    private EditText fxjcd_et_jcyname2;
    private EditText fxjcd_et_jcytelephone2;
    private EditText fxjcd_et_jcyname3;
    private EditText fxjcd_et_jcytelephone3;
    private EditText fxjcd_et_bate;
    private Button fxjcd_bt_save;
    private Button fxjcd_bt_delete;
    private String objectId;
    private FXJCDBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fxjcd);
        mContext = this;

        findView();
        huoQeIntent();
        fxjcd_bt_save.setOnClickListener(this);
                fxjcd_bt_delete.setOnClickListener(this);
    }

    private void findView() {
        fxjcd_et_name = (EditText) findViewById(R.id.fxjcd_et_name);
        fxjcd_et_adress = (EditText) findViewById(R.id.fxjcd_et_adress);
        fxjcd_et_lxr = (EditText) findViewById(R.id.fxjcd_et_lxr);
        fxjcd_et_lxrtelephone = (EditText) findViewById(R.id.fxjcd_et_lxrtelephone);
        fxjcd_et_jcyname1 = (EditText) findViewById(R.id.fxjcd_et_jcyname1);
        fxjcd_et_jcytelephone1 = (EditText) findViewById(R.id.fxjcd_et_jcytelephone1);
        fxjcd_et_jcyname2 = (EditText) findViewById(R.id.fxjcd_et_jcyname2);
        fxjcd_et_jcytelephone2 = (EditText) findViewById(R.id.fxjcd_et_jcytelephone2);
        fxjcd_et_jcyname3 = (EditText) findViewById(R.id.fxjcd_et_jcyname3);
        fxjcd_et_jcytelephone3 = (EditText) findViewById(R.id.fxjcd_et_jcytelephone3);
        fxjcd_et_bate = (EditText) findViewById(R.id.fxjcd_et_bate);
        fxjcd_bt_save = (Button) findViewById(R.id.fxjcd_bt_save);
        fxjcd_bt_delete = (Button) findViewById(R.id.fxjcd_bt_delete);
    }


    private void huoQeIntent() {
        bean = (FXJCDBean) getIntent().getSerializableExtra("xinxi");
        objectId = bean.getObjectId();
        fxjcd_et_name.setText(bean.getName());
        fxjcd_et_adress.setText(bean.getAdress());
        fxjcd_et_lxr.setText(bean.getLxr());
        fxjcd_et_lxrtelephone.setText(bean.getLxrtelephone());
        fxjcd_et_jcyname1.setText(bean.getJcyname1());
        fxjcd_et_jcytelephone1.setText(bean.getJcytelephone1());
        fxjcd_et_jcyname2.setText(bean.getJcyname2());
        fxjcd_et_jcytelephone2.setText(bean.getJcytelephone2());
        fxjcd_et_jcyname3.setText(bean.getJcyname3());
        fxjcd_et_jcytelephone3.setText(bean.getJcytelephone3());
        fxjcd_et_bate.setText(bean.getBate());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fxjcd_bt_save:

                bean.setName(fxjcd_et_name.getText().toString());
                bean.setAdress(fxjcd_et_adress.getText().toString());
                bean.setLxr(fxjcd_et_lxr.getText().toString());
                bean.setLxrtelephone(fxjcd_et_lxrtelephone.getText().toString());
                bean.setJcyname1(fxjcd_et_jcyname1.getText().toString());
                bean.setJcytelephone1(fxjcd_et_jcytelephone1.getText().toString());
                bean.setJcyname2(fxjcd_et_jcyname2.getText().toString());
                bean.setJcytelephone2(fxjcd_et_jcytelephone2.getText().toString());
                bean.setJcyname3(fxjcd_et_jcyname3.getText().toString());
                bean.setJcytelephone3(fxjcd_et_jcytelephone3.getText().toString());
                bean.setBate(fxjcd_et_bate.getText().toString());

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

                break;

            case R.id.fxjcd_bt_delete:
                new AlertDialog.Builder(this)
                        .setTitle("确定删除吗")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                FXJCDBean bean1=new FXJCDBean();
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

                            }

                        }).show();

                break;
            default:
                break;
        }
    }
    }

