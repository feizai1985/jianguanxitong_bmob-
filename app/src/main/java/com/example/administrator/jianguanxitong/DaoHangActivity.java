package com.example.administrator.jianguanxitong;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;

public class DaoHangActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_hzqy;
    private Button bt_gyqy;
    private Button bt_spxg;
    private Button bt_flfg;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_hang);

        mContext = this;
//        初始化Bmob
        Bmob.initialize(this, "bc227182859550b1fc700846c8c6938e");
        findview();
        bt_flfg.setOnClickListener(this);
        bt_spxg.setOnClickListener(this);
        bt_gyqy.setOnClickListener(this);
        bt_hzqy.setOnClickListener(this);
    }

    private void findview() {
        bt_hzqy = (Button) findViewById(R.id.bt_hzqy);
        bt_gyqy = (Button) findViewById(R.id.bt_gyqy);
        bt_spxg = (Button) findViewById(R.id.bt_spxg);
        bt_flfg = (Button) findViewById(R.id.bt_flfg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_hzqy:
                startYeMian( R.id.bt_hzqy);
                break;
            case R.id.bt_gyqy:
                startYeMian( R.id.bt_gyqy);
                break;
            case R.id.bt_spxg:
                startYeMian( R.id.bt_spxg);
                break;
            case R.id.bt_flfg:
                startYeMian( R.id.bt_flfg);
                break;
            default:
                break;


        }
    }

    private void startYeMian(int id) {
        Intent intent = new Intent();
        switch (id){
            case R.id.bt_hzqy:
                intent.setClass(this,HuoZhengActivity.class);

                break;
            case R.id.bt_gyqy:
                intent.setClass(this,GYQYActivity.class );

                break;
            case R.id.bt_spxg:
                intent.setClass(this,ShiPingXiangGuanActivity.class);

                break;
            case R.id.bt_flfg:
                intent.setClass(this,FaLvFaGuiActivity.class);

                break;
            default:
                break;

        }
        startActivity(intent);

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0) {
            //详细的操作代码
            new AlertDialog.Builder(this)
                    .setTitle("确定退出程序么")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            finish();//
                            System.exit(0);
                        }

                    }).show();

            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
