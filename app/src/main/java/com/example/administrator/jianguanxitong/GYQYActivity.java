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

import com.example.administrator.jianguanxitong.bean.GYQYBean;
import com.example.administrator.jianguanxitong.gyqy.GYQYAddActivity;
import com.example.administrator.jianguanxitong.gyqy.GYQYAlertActivity;
import com.example.administrator.jianguanxitong.gyqy.GYQYQueryActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class GYQYActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Context mContext;
    private ListView gyqy_lv_item;
    private Button gyqy_bt_add;
    private Button gyqy_bt_query;

    private static List<GYQYBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyqy);
        mContext = this;
        findview();
        gyqy_bt_add.setOnClickListener(this);
        gyqy_lv_item.setOnItemClickListener(this);
        gyqy_bt_query.setOnClickListener(this);

        showItem();
    }

    private void showItem() {
        BmobQuery<GYQYBean> bmobQuery=new BmobQuery<>();
        bmobQuery.setLimit(499);
        bmobQuery.findObjects(new FindListener<GYQYBean>() {
            @Override
            public void done(List<GYQYBean> list, BmobException e) {
                if(e!=null){

                    Toast.makeText(mContext,"加载数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    
                    gyqy_lv_item.setAdapter(new MyHZQEAdapter(list));

                    GYQYActivity.list=list;
                }

            }
        });
    }

    private void findview() {
        gyqy_lv_item = (ListView) findViewById(R.id.gyqy_lv_item);
        gyqy_bt_add = (Button) findViewById(R.id.gyqy_bt_add);
        gyqy_bt_query = (Button) findViewById(R.id.gyqy_bt_query);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//       添加企业
            case R.id.gyqy_bt_add:
                Intent intent=new Intent(this, GYQYAddActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.gyqy_bt_query:
                Intent intent2=new Intent(this, GYQYQueryActivity.class);
                startActivity(intent2);

                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(GYQYActivity.this, GYQYAlertActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("xinxi",list.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    class MyHZQEAdapter extends BaseAdapter {


        private final List<GYQYBean> list;

        public MyHZQEAdapter(List<GYQYBean> list)  {
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
