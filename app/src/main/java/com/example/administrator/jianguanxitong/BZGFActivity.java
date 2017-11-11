package com.example.administrator.jianguanxitong;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.bzgf.CPBZActivity;
import com.example.administrator.jianguanxitong.bzgf.JDCCActivity;
import com.example.administrator.jianguanxitong.bzgf.XCActivity;

public class BZGFActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button bzgf_bt_cpbz;
    private Button bzgf_bt_xc;
    private Button bzgf_bt_jdcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bzgf);
        mContext = this;

        findView();
        bzgf_bt_cpbz.setOnClickListener(this);
        bzgf_bt_xc.setOnClickListener(this);
        bzgf_bt_jdcc.setOnClickListener(this);
    }

    private void findView() {
        bzgf_bt_cpbz = (Button) findViewById(R.id.bzgf_bt_cpbz);
        bzgf_bt_xc = (Button) findViewById(R.id.bzgf_bt_xc);
        bzgf_bt_jdcc = (Button) findViewById(R.id.bzgf_bt_jdcc);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bzgf_bt_cpbz:
startActivity(new Intent(mContext, CPBZActivity.class));
                break;
            case R.id.bzgf_bt_xc:
                startActivity(new Intent(mContext, XCActivity.class));
                break;
            case R.id.bzgf_bt_jdcc:
                startActivity(new Intent(mContext, JDCCActivity.class));
                break;
            default:
                break;
        }
    }
}
