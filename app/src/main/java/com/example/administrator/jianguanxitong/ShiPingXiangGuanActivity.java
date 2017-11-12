package com.example.administrator.jianguanxitong;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jianguanxitong.bean.SPXGBean;
import com.example.administrator.jianguanxitong.spxg.SPXGAddActivity;
import com.example.administrator.jianguanxitong.spxg.SPXGAlertActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ShiPingXiangGuanActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static List<SPXGBean> list;
    private ListView spxg_lv_item;
    private Button spxg_bt_add;

    private Button spxg_bt_fanhui;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_ping_xiang_guan);
        mContext = this;
        findview();
        spxg_bt_add.setOnClickListener(this);
        spxg_lv_item.setOnItemClickListener(this);

        spxg_bt_fanhui.setOnClickListener(this);
        showItem();
    }

    private void showItem() {
        BmobQuery<SPXGBean> bmobQuery=new BmobQuery<>();

        bmobQuery.findObjects(new FindListener<SPXGBean>() {
            @Override
            public void done(List<SPXGBean> list, BmobException e) {
                if(e!=null){
                    Toast.makeText(mContext,"加载数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    spxg_lv_item.setAdapter(new MyHZQEAdapter(list));

                    ShiPingXiangGuanActivity.list=list;
                }

            }
        });
    }

    private void findview() {
        spxg_lv_item = (ListView) findViewById(R.id.spxg_lv_item);
        spxg_bt_add = (Button) findViewById(R.id.spxg_bt_add);

        spxg_bt_fanhui = (Button) findViewById(R.id.spxg_bt_fanhui);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//       添加企业
            case R.id.spxg_bt_add:
                Intent intent=new Intent(this, SPXGAddActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.spxg_bt_fanhui:
                Intent intent1=new Intent(this, DaoHangActivity.class);
                startActivity(intent1);
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(ShiPingXiangGuanActivity.this, SPXGAlertActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("xinxi",list.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    class MyHZQEAdapter extends BaseAdapter {


        private final List<SPXGBean> list;

        public MyHZQEAdapter(List<SPXGBean> list)  {
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size() ;
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
            TextView view =null;
            if(convertView!=null){
                view= (TextView) convertView;
            }else {
                view=new TextView(mContext);
            }
            view.setText(list.get(position).getName());
            view.setTextSize(20);

            return view;
        }
    }
}

