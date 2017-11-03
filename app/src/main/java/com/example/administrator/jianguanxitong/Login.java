package com.example.administrator.jianguanxitong;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText et_username;
    private EditText et_password;
    private CheckBox cb_ifrem;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findview();
        bt_login.setOnClickListener(this);
//        判断是否以前记录密码
        iflogin();
    }

    private void iflogin() {
        SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
        String username = preferences.getString("username", "");
        String password = preferences.getString("password", "0");
        if(username!="" && password!="0"){
            et_username.setText(username);
            et_password.setText(password);
        }

    }

    private void findview() {
        mContext = this;
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_ifrem = (CheckBox) findViewById(R.id.cb_ifrem);
        bt_login = (Button) findViewById(R.id.bt_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                login();
                break;

            default:
                break;
        }

    }



    //点击事件方法
    private void login() {
        String str_username = et_username.getText().toString();
        String str_password = et_password.getText().toString();
        if(str_username.equals(getString(R.string.username))&&str_password.equals(getString(R.string.password))){
            Intent intent = new Intent(mContext,DaoHangActivity.class);
            startActivity(intent);
            cbifrem(str_username,str_password);
            finish();
        }else {
            Toast.makeText(mContext,"用户名或密码输入错误",Toast.LENGTH_SHORT).show();
        }
    }

    private void cbifrem(String str_username, String str_password) {
        if(cb_ifrem.isChecked()){
            SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString("username",str_username);
            edit.putString("password",str_password);
            edit.commit();
        }
    }
}
