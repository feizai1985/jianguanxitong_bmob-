package com.example.administrator.jianguanxitong.hzqe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.jianguanxitong.HuoZhengActivity;
import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.bean.HZQEBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class HZQEAddActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText hzqe_et_name;
    private EditText hzqe_et_adress;
    private EditText hzqe_et_frdb;
    private EditText hzqe_et_lxr;
    private EditText hzqe_et_zw;
    private EditText hzqe_et_telephone;
    private EditText hzqe_et_cpmc;
    private EditText hzqe_et_cpbz;
    private EditText hzqe_et_hzsj;
    private EditText hzqe_et_dqsj;
    private EditText hzqe_et_sczk;
    private EditText hzqe_et_bate;
    private Button hzqe_bt_save;
    private Button hzqe_bt_cancle;
    private EditText hzqe_et_zh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hzqeadd);
        mContext = this;

        findview();
        hzqe_bt_save.setOnClickListener(this);
        hzqe_bt_cancle.setOnClickListener(this);

    }

    private void findview() {
        hzqe_et_name = (EditText) findViewById(R.id.hzqe_et_name);
        hzqe_et_adress = (EditText) findViewById(R.id.hzqe_et_adress);
        hzqe_et_frdb = (EditText) findViewById(R.id.hzqe_et_frdb);
        hzqe_et_lxr = (EditText) findViewById(R.id.hzqe_et_lxr);
        hzqe_et_zw = (EditText) findViewById(R.id.hzqe_et_zw);
        hzqe_et_telephone = (EditText) findViewById(R.id.hzqe_et_telephone);
        hzqe_et_cpmc = (EditText) findViewById(R.id.hzqe_et_cpmc);
        hzqe_et_cpbz = (EditText) findViewById(R.id.hzqe_et_cpbz);
        hzqe_et_zh = (EditText) findViewById(R.id.hzqe_et_zh);
        hzqe_et_hzsj = (EditText) findViewById(R.id.hzqe_et_hzsj);
        hzqe_et_dqsj = (EditText) findViewById(R.id.hzqe_et_dqsj);
        hzqe_et_sczk = (EditText) findViewById(R.id.hzqe_et_sczk);
        hzqe_et_bate = (EditText) findViewById(R.id.hzqe_et_bate);

        hzqe_bt_save = (Button) findViewById(R.id.hzqe_bt_save);
        hzqe_bt_cancle = (Button) findViewById(R.id.hzqe_bt_cancle);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hzqe_bt_cancle:
                finish();
                break;
            case R.id.hzqe_bt_save:
                HZQEBean bean = new HZQEBean();
                bean.setName(hzqe_et_name.getText().toString());
                bean.setAdress(hzqe_et_adress.getText().toString());
                bean.setFrdb(hzqe_et_frdb.getText().toString());
                bean.setLxr(hzqe_et_lxr.getText().toString());
                bean.setZw(hzqe_et_zw.getText().toString());
                bean.setTelephone(hzqe_et_telephone.getText().toString());
                bean.setCpmc(hzqe_et_cpmc.getText().toString());
                bean.setCpbz(hzqe_et_cpbz.getText().toString());
                bean.setZh(hzqe_et_zh.getText().toString());
                bean.setHzsj(hzqe_et_hzsj.getText().toString());
                bean.setDqsj(hzqe_et_dqsj.getText().toString());
                bean.setSczk(hzqe_et_sczk.getText().toString());
                bean.setBate(hzqe_et_bate.getText().toString());
                bean.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e!=null){
                            Toast.makeText(mContext,"添加企业失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(mContext,"添加成功",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();

                break;
            case R.id.gyqy_bt_query:

                break;
            default:
                break;
        }
    }
}