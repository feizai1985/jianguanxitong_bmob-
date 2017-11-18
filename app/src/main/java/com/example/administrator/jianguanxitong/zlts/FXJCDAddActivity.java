package com.example.administrator.jianguanxitong.zlts;

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
import com.example.administrator.jianguanxitong.bean.FXJCDBean;
import com.example.administrator.jianguanxitong.bean.HZQEBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class FXJCDAddActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button fxjcdadd_bt_add;
    private EditText fxjcdadd_et_name;
    private EditText fxjcdadd_et_adress;
    private EditText fxjcdadd_et_lxr;
    private EditText fxjcdadd_et_lxrtelephone;
    private EditText fxjcdadd_et_jcyname1;
    private EditText fxjcdadd_et_jcytelephone1;
    private EditText fxjcdadd_et_jcyname2;
    private EditText fxjcdadd_et_jcytelephone2;
    private EditText fxjcdadd_et_jcyname3;
    private EditText fxjcdadd_et_jcytelephone3;
    private EditText fxjcdadd_et_bate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fxjcdadd2);
        mContext = this;

        findView();
        fxjcdadd_bt_add.setOnClickListener(this);

    }

    private void findView() {
        fxjcdadd_et_name = (EditText) findViewById(R.id.fxjcdadd_et_name);
        fxjcdadd_et_adress = (EditText) findViewById(R.id.fxjcdadd_et_adress);
        fxjcdadd_et_lxr = (EditText) findViewById(R.id.fxjcdadd_et_lxr);
        fxjcdadd_et_lxrtelephone = (EditText) findViewById(R.id.fxjcdadd_et_lxrtelephone);
        fxjcdadd_et_jcyname1 = (EditText) findViewById(R.id.fxjcdadd_et_jcyname1);
        fxjcdadd_et_jcytelephone1 = (EditText) findViewById(R.id.fxjcdadd_et_jcytelephone1);
        fxjcdadd_et_jcyname2 = (EditText) findViewById(R.id.fxjcdadd_et_jcyname2);
        fxjcdadd_et_jcytelephone2 = (EditText) findViewById(R.id.fxjcdadd_et_jcytelephone2);
        fxjcdadd_et_jcyname3 = (EditText) findViewById(R.id.fxjcdadd_et_jcyname3);
        fxjcdadd_et_jcytelephone3 = (EditText) findViewById(R.id.fxjcdadd_et_jcytelephone3);
        fxjcdadd_et_bate = (EditText) findViewById(R.id.fxjcdadd_et_bate);
        fxjcdadd_bt_add = (Button) findViewById(R.id.fxjcdadd_bt_add);
    }

    @Override
    public void onClick(View v) {
        FXJCDBean bean = new FXJCDBean();
        bean.setName(fxjcdadd_et_name.getText().toString());
        bean.setAdress(fxjcdadd_et_adress.getText().toString());
        bean.setLxr(fxjcdadd_et_lxr.getText().toString());
        bean.setLxrtelephone(fxjcdadd_et_lxrtelephone.getText().toString());
        bean.setJcyname1(fxjcdadd_et_jcyname1.getText().toString());
        bean.setJcytelephone1(fxjcdadd_et_jcytelephone1.getText().toString());
        bean.setJcyname2(fxjcdadd_et_jcyname2.getText().toString());
        bean.setJcytelephone2(fxjcdadd_et_jcytelephone2.getText().toString());
        bean.setJcyname3(fxjcdadd_et_jcyname3.getText().toString());
        bean.setJcytelephone3(fxjcdadd_et_jcytelephone3.getText().toString());
        bean.setBate(fxjcdadd_et_bate.getText().toString());

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


    }
}
