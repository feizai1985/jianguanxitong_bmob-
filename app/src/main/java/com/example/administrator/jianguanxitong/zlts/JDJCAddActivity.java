package com.example.administrator.jianguanxitong.zlts;

import android.content.Context;
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
import cn.bmob.v3.listener.SaveListener;

public class JDJCAddActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private EditText jdjcadd_et_date;
    private EditText jdjcadd_et_name;
    private EditText jdjcadd_et_peitong;
    private EditText jdjcadd_et_telephone;
    private EditText jdjcadd_et_content;
    private Button jdjcadd_bt_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdjcadd);
        mContext = this;

        findView();
        jdjcadd_bt_add.setOnClickListener(this);

    }

    private void findView() {
        jdjcadd_et_date = (EditText) findViewById(R.id.jdjcadd_et_date);
        jdjcadd_et_name = (EditText) findViewById(R.id.jdjcadd_et_name);
        jdjcadd_et_peitong = (EditText) findViewById(R.id.jdjcadd_et_peitong);
        jdjcadd_et_telephone = (EditText) findViewById(R.id.jdjcadd_et_telephone);
        jdjcadd_et_content = (EditText) findViewById(R.id.jdjcadd_et_content);

        jdjcadd_bt_add = (Button) findViewById(R.id.jdjcadd_bt_add);
    }

    @Override
    public void onClick(View v) {
        JDJCBean bean = new JDJCBean();
        bean.setDate(jdjcadd_et_date.getText().toString());
        bean.setName(jdjcadd_et_name.getText().toString());
        bean.setPeitong(jdjcadd_et_peitong.getText().toString());
        bean.setTelephone(jdjcadd_et_telephone.getText().toString());
        bean.setContent(jdjcadd_et_content.getText().toString());


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
