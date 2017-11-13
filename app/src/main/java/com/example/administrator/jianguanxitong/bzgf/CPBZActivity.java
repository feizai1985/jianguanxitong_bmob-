package com.example.administrator.jianguanxitong.bzgf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.jianguanxitong.R;

import java.util.ArrayList;
import java.util.List;

public class CPBZActivity extends AppCompatActivity {

    private Context mContext;
    private List<String> list;
    private ListView bzgf_lv_cpbz;
    private List<String> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpbz);
        mContext = this;
//list 与list2为一一对应关系
        list = new ArrayList<>();
        list2 = new ArrayList<>();
//        加载数据：0产品质量安全法、

        list.add("产品质量安全法");
        list2.add("cpzlaqf");
        bzgf_lv_cpbz = (ListView) findViewById(R.id.bzgf_lv_cpbz);
        bzgf_lv_cpbz.setAdapter(new myAdapter());
        bzgf_lv_cpbz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(mContext, ShowItemActivity.class);
                intent.putExtra("txtName",list2.get(position));
                startActivity(intent);
            }
        });

    }

    class myAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           TextView view=null;
            if(convertView!=null){
                view= (TextView) convertView;
            }else {
                view=new TextView(mContext);
            }
            view.setText(list.get(position));

            return view;
        }
    }
}