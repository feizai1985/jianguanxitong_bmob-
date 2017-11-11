package com.example.administrator.jianguanxitong.gyqy;

import android.content.Context;
import android.content.Intent;
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
import cn.bmob.v3.listener.SaveListener;

public class GYQYAddActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText gyqy_et_name;
    private EditText gyqy_et_adress1;
    private EditText gyqy_et_adress2;
    private EditText gyqy_et_frdb;
    private EditText gyqy_et_lxr;
    private EditText gyqy_et_zw;
    private EditText gyqy_et_telephone;
    private EditText gyqy_et_cpmc;
    private EditText gyqy_et_cpbz;
    private EditText gyqy_et_cpfl;
    private EditText gyqy_et_jd;
    private EditText gyqy_et_sczk;
    private EditText gyqy_et_bate;
    private Button gyqy_bt_save;
    private Button gyqy_bt_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyqyadd);
        mContext = this;

        findview();
        gyqy_bt_save.setOnClickListener(this);
        gyqy_bt_cancle.setOnClickListener(this);

    }

    private void findview() {
        gyqy_et_name = (EditText) findViewById(R.id.gyqy_et_name);
        gyqy_et_adress1 = (EditText) findViewById(R.id.gyqy_et_adress1);
        gyqy_et_adress2 = (EditText) findViewById(R.id.gyqy_et_adress2);
        gyqy_et_frdb = (EditText) findViewById(R.id.gyqy_et_frdb);
        gyqy_et_lxr = (EditText) findViewById(R.id.gyqy_et_lxr);
        gyqy_et_zw = (EditText) findViewById(R.id.gyqy_et_zw);
        gyqy_et_telephone = (EditText) findViewById(R.id.gyqy_et_telephone);
        gyqy_et_cpmc = (EditText) findViewById(R.id.gyqy_et_cpmc);
        gyqy_et_cpbz = (EditText) findViewById(R.id.gyqy_et_cpbz);
        gyqy_et_cpfl = (EditText) findViewById(R.id.gyqy_et_cpfl);
        gyqy_et_jd = (EditText) findViewById(R.id.gyqy_et_jd);
        gyqy_et_sczk = (EditText) findViewById(R.id.gyqy_et_sczk);
        gyqy_et_bate = (EditText) findViewById(R.id.gyqy_et_bate);
        gyqy_bt_save = (Button) findViewById(R.id.gyqy_bt_save);
        gyqy_bt_cancle = (Button) findViewById(R.id.gyqy_bt_cancle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gyqy_bt_cancle:
                finish();

                break;
            case R.id.gyqy_bt_save:
                GYQYBean bean = new GYQYBean();
                bean.setName(gyqy_et_name.getText().toString());
                bean.setAdress1(gyqy_et_adress1.getText().toString());
                bean.setAdress2(gyqy_et_adress2.getText().toString());
                bean.setFrdb(gyqy_et_frdb.getText().toString());
                bean.setLxr(gyqy_et_lxr.getText().toString());
                bean.setZw(gyqy_et_zw.getText().toString());
                bean.setTelephone(gyqy_et_telephone.getText().toString());
                bean.setCpmc(gyqy_et_cpmc.getText().toString());
                bean.setCpbz(gyqy_et_cpbz.getText().toString());
                bean.setCpfl(gyqy_et_cpfl.getText().toString());
                bean.setJd(gyqy_et_jd.getText().toString());
                bean.setSczk(gyqy_et_sczk.getText().toString());
                bean.setBate(gyqy_et_bate.getText().toString());
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
                startActivity(new Intent(this, GYQYActivity.class));
                break;

            default:
                break;
        }
    }
}


