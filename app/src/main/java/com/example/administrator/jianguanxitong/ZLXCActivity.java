package com.example.administrator.jianguanxitong;

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

import java.util.ArrayList;
import java.util.List;

public class ZLXCActivity extends AppCompatActivity {

    private Context mContext;
    private List<String> list;
    private List<String> list2;
    private ListView fvfg_lv_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_lv_fa_gui);

        mContext = this;
//list 与list2为一一对应关系

        list = new ArrayList<>();
        list2 = new ArrayList<>();
//        加载数据：0产品质量安全法、

        list.add("产品质量安全法");    list2.add("cpzlaqf");
        list.add("工业产品生产许可证管理条例");   list2.add("gycpgltl");
        list.add("工业产品生产许可证管理条例实施办法");   list2.add("gycpgltlssbf");
        list.add("工业产品生产许可证目录");   list2.add("ml");
        list.add("产品质量监督抽查管理办法");    list2.add("jdccglbf");
        list.add("行政强制法");   list2.add("xzqzf");
        list.add("行政处罚法");   list2.add("xzcff");
        list.add("行政诉讼法");    list2.add("xzsof");


        fvfg_lv_item = (ListView) findViewById(R.id.fvfg_lv_item);
        fvfg_lv_item.setAdapter(new myAdapter());
        fvfg_lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(mContext, ShowItemActivity.class);
                intent.putExtra("txtName", list2.get(position));
                startActivity(intent);
            }
        });

    }

    class myAdapter extends BaseAdapter {


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
            view.setTextSize(23);

            return view;
        }
    }
}



