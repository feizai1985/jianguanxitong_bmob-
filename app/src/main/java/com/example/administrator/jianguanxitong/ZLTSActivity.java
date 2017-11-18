package com.example.administrator.jianguanxitong;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.jianguanxitong.zlts.FXJCDActivity;
import com.example.administrator.jianguanxitong.zlts.JDJCActivity;

public class ZLTSActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button zlts_bt_fxjcd;
    private Button zlts_bt_jdjc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlts);
        mContext = this;

        findView();
        zlts_bt_fxjcd.setOnClickListener(this);
        zlts_bt_jdjc.setOnClickListener(this);
    }

    private void findView() {
        zlts_bt_fxjcd = (Button) findViewById(R.id.zlts_bt_fxjcd);
        zlts_bt_jdjc = (Button) findViewById(R.id.zlts_bt_jdjc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zlts_bt_fxjcd :

                 startActivity(new Intent(mContext, FXJCDActivity.class));
                break;
            case R.id.zlts_bt_jdjc:

                startActivity(new Intent(mContext, JDJCActivity.class));
                break;
            default:
                break;
        }
    }
}
