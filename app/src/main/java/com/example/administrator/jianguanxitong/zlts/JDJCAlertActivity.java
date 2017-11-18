package com.example.administrator.jianguanxitong.zlts;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.bean.FXJCDBean;
import com.example.administrator.jianguanxitong.bean.JDJCBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class JDJCAlertActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText jdjcalert_et_content;
    private EditText jdjcalert_et_date;
    private EditText jdjcalert_et_name;
    private EditText jdjcalert_et_peitong;
    private EditText jdjcalert_et_telephone;
    private Button jdjcalert_bt_save;
    private Button jdjcalert_bt_delete;
    private String objectId;
    private JDJCBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdjcalert);
        mContext = this;

        findView();
        huoQeIntent();
        jdjcalert_bt_save.setOnClickListener(this);
        jdjcalert_bt_delete.setOnClickListener(this);
    }

    private void findView() {


        jdjcalert_et_date = (EditText) findViewById(R.id.jdjcalert_et_date);
        jdjcalert_et_name = (EditText)  findViewById(R.id.jdjcalert_et_name);
        jdjcalert_et_peitong = (EditText)  findViewById(R.id.jdjcalert_et_peitong);
        jdjcalert_et_telephone = (EditText)  findViewById(R.id.jdjcalert_et_telephone);
        jdjcalert_et_content = (EditText) findViewById(R.id.jdjcalert_et_content);

        jdjcalert_bt_save = (Button) findViewById(R.id.jdjcalert_bt_save);
        jdjcalert_bt_delete = (Button) findViewById(R.id.jdjcalert_bt_delete);
    }
    private void huoQeIntent() {
        bean = (JDJCBean) getIntent().getSerializableExtra("xinxi");
        objectId = bean.getObjectId();
        jdjcalert_et_date.setText(bean.getDate());
        jdjcalert_et_name.setText(bean.getName());
        jdjcalert_et_peitong.setText(bean.getPeitong());
        jdjcalert_et_telephone.setText(bean.getTelephone());
        jdjcalert_et_content.setText(bean.getContent());


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jdjcalert_bt_save:

                bean.setDate(jdjcalert_et_date.getText().toString());
                bean.setName(jdjcalert_et_name.getText().toString());
                bean.setPeitong(jdjcalert_et_peitong.getText().toString());
                bean.setTelephone(jdjcalert_et_telephone.getText().toString());
                bean.setContent(jdjcalert_et_content.getText().toString());

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

            case R.id.jdjcalert_bt_delete:
                new AlertDialog.Builder(this)
                        .setTitle("确定删除吗")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                JDJCBean bean1=new JDJCBean();
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
