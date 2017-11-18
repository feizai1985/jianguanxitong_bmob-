package com.example.administrator.jianguanxitong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.jianguanxitong.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShowItemActivity extends AppCompatActivity {

    private TextView bzgf_tx_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        bzgf_tx_item = (TextView) findViewById(R.id.bzgf_tx_item);
        Intent intent = getIntent();
        String txtName = intent.getStringExtra("txtName");
//        读取assets资源来显示文本
        reanAssets(txtName);

    }

    private void reanAssets(String txtName) {
        try {
            InputStream is = getAssets().open(txtName+".txt");
            String text = readTextFromSDcard(is);
            bzgf_tx_item.setText(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
