package com.example.administrator.jianguanxitong.hzqe;

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
import com.example.administrator.jianguanxitong.HuoZhengActivity;
import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.bean.GYQYBean;
import com.example.administrator.jianguanxitong.bean.HZQEBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class HZQEAlertActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText hzqealert_et_name;
    private EditText hzqealert_et_adress;
    private EditText hzqealert_et_frdb;
    private EditText hzqealert_et_lxr;
    private EditText hzqealert_et_zw;
    private EditText hzqealert_et_telephone;
    private EditText hzqealert_et_cpmc;
    private EditText hzqealert_et_cpbz;
    private EditText hzqealert_et_hzsj;
    private EditText hzqealert_et_dqsj;
    private EditText hzqealert_et_sczk;
    private EditText hzqealert_et_bate;
    private Button hzqealert_bt_save;
    private Button hzqealert_bt_fcancle;
    private HZQEBean bean;
    private Context mContext;
    private Button hzqealert_bt_delete;
    private EditText hzqealert_et_zh;
    private String objectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hzqealert);
        mContext = this;
        findView();
        huoQeIntent();
        hzqealert_bt_save.setOnClickListener(this);
        hzqealert_bt_fcancle.setOnClickListener(this);
        hzqealert_bt_delete.setOnClickListener(this);

    }

    private void huoQeIntent() {
        bean = (HZQEBean) getIntent().getSerializableExtra("xinxi");
        objectId = bean.getObjectId();
        hzqealert_et_name.setText(bean.getName());
        hzqealert_et_adress.setText(bean.getAdress());
        hzqealert_et_frdb.setText(bean.getFrdb());
        hzqealert_et_lxr.setText(bean.getLxr());
        hzqealert_et_zw.setText(bean.getZw());
        hzqealert_et_telephone.setText(bean.getTelephone());
        hzqealert_et_zh.setText(bean.getZh());
        hzqealert_et_cpmc.setText(bean.getCpmc());
        hzqealert_et_cpbz.setText(bean.getCpbz());
        hzqealert_et_hzsj.setText(bean.getHzsj());
        hzqealert_et_dqsj.setText(bean.getDqsj());
        hzqealert_et_sczk.setText(bean.getSczk());
        hzqealert_et_bate.setText(bean.getBate());

    }

    private void findView() {
        hzqealert_et_name = (EditText) findViewById(R.id.hzqealert_et_name);
        hzqealert_et_adress = (EditText) findViewById(R.id.hzqealert_et_adress);
        hzqealert_et_frdb = (EditText) findViewById(R.id.hzqealert_et_frdb);
        hzqealert_et_lxr = (EditText) findViewById(R.id.hzqealert_et_lxr);
        hzqealert_et_zw = (EditText) findViewById(R.id.hzqealert_et_zw);
        hzqealert_et_telephone = (EditText) findViewById(R.id.hzqealert_et_telephone);
        hzqealert_et_cpmc = (EditText) findViewById(R.id.hzqealert_et_cpmc);
        hzqealert_et_cpbz = (EditText) findViewById(R.id.hzqealert_et_cpbz);
        hzqealert_et_zh = (EditText) findViewById(R.id.hzqealert_et_zh);
        hzqealert_et_hzsj = (EditText) findViewById(R.id.hzqealert_et_hzsj);
        hzqealert_et_dqsj = (EditText) findViewById(R.id.hzqealert_et_dqsj);
        hzqealert_et_sczk = (EditText) findViewById(R.id.hzqealert_et_sczk);
        hzqealert_et_bate = (EditText) findViewById(R.id.hzqealert_et_bate);
        hzqealert_bt_save = (Button) findViewById(R.id.hzqealert_bt_save);
        hzqealert_bt_fcancle = (Button) findViewById(R.id.hzqealert_bt_cancle);
        hzqealert_bt_delete = (Button) findViewById(R.id.hzqealert_bt_delete);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hzqealert_bt_save:
                HZQEBean bean=new HZQEBean();

                bean.setName(hzqealert_et_name.getText().toString());
                bean.setAdress(hzqealert_et_adress.getText().toString());
                bean.setFrdb(hzqealert_et_frdb.getText().toString());
                bean.setLxr(hzqealert_et_lxr.getText().toString());
                bean.setZw(hzqealert_et_zw.getText().toString());
                bean.setTelephone(hzqealert_et_telephone.getText().toString());
                bean.setCpmc(hzqealert_et_cpmc.getText().toString());
                bean.setCpbz(hzqealert_et_cpbz.getText().toString());
                bean.setZh(hzqealert_et_zh.getText().toString());
                bean.setHzsj(hzqealert_et_hzsj.getText().toString());
                bean.setDqsj(hzqealert_et_dqsj.getText().toString());
                bean.setSczk(hzqealert_et_sczk.getText().toString());
                bean.setBate(hzqealert_et_bate.getText().toString());
                bean.update(objectId, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e!=null){
                            Toast.makeText(mContext,"更新数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();
                startActivity(new Intent(HZQEAlertActivity.this, HuoZhengActivity.class));
                break;
            case R.id.hzqealert_bt_cancle:
                finish();

                break;
            case R.id.hzqealert_bt_delete:

                new AlertDialog.Builder(this)
                        .setTitle("确定退出程序么")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                HZQEBean bean1=new HZQEBean();
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
                                startActivity(new Intent(HZQEAlertActivity.this, HuoZhengActivity.class));

                            }

                        }).show();









                break;
             default:
                 break;
        }
    }
}
