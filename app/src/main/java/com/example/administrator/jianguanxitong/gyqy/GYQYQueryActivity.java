package com.example.administrator.jianguanxitong.gyqy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jianguanxitong.GYQYActivity;
import com.example.administrator.jianguanxitong.R;
import com.example.administrator.jianguanxitong.bean.GYQYBean;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class GYQYQueryActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    private Button gyqyquery_bt_query;
    private ListView gyqyquery_lv_query;
    private Context mContext;
    private EditText gyqyquery_et_query;
    private static List<GYQYBean> list;
    private EditText gyqyquery_et_querycpmc;
    private Button gyqyquery_bt_querycpmc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyqyquery2);
        mContext = this;
        findView();

        gyqyquery_bt_query.setOnClickListener(this);
        gyqyquery_bt_querycpmc.setOnClickListener(this);
        gyqyquery_lv_query.setOnItemClickListener(this);
    }

    private void findView() {

        gyqyquery_bt_query = (Button) findViewById(R.id.gyqyquery_bt_query);
        gyqyquery_lv_query = (ListView) findViewById(R.id.gyqyquery_lv_query);
        gyqyquery_et_query = (EditText) findViewById(R.id.gyqyquery_et_query);
        gyqyquery_et_querycpmc = (EditText) findViewById(R.id.gyqyquery_et_querycpmc);
        gyqyquery_bt_querycpmc = (Button) findViewById(R.id.gyqyquery_bt_querycpmc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.gyqyquery_bt_query:
                if(gyqyquery_et_query.getText().toString().trim()!=""){
                    BmobQuery<GYQYBean> bmobQuery=new BmobQuery<>();
                    bmobQuery.addWhereEqualTo("adress1", gyqyquery_et_query.getText().toString().trim());
                    bmobQuery.setLimit(499);
                    bmobQuery.findObjects(new FindListener<GYQYBean>() {
                        @Override
                        public void done(List<GYQYBean> list, BmobException e) {
                            if(e!=null){
                                Toast.makeText(mContext,"查询数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                            }else {
                                GYQYQueryActivity.list=list;

                                gyqyquery_lv_query.setAdapter(new MyHZQEAdapter(list));
                            }
                        }
                    });
                }
                break;
            case R.id.gyqyquery_bt_querycpmc:
                if(gyqyquery_et_querycpmc.getText().toString().trim()!=""){
                    BmobQuery<GYQYBean> bmobQuery=new BmobQuery<>();
                    bmobQuery.addWhereEqualTo("cpmc", gyqyquery_et_querycpmc.getText().toString().trim());
                    bmobQuery.setLimit(50);
                    bmobQuery.findObjects(new FindListener<GYQYBean>() {
                        @Override
                        public void done(List<GYQYBean> list, BmobException e) {
                            if(e!=null){
                                Toast.makeText(mContext,"查询数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                            }else {
                                GYQYQueryActivity.list=list;
                                gyqyquery_lv_query.setAdapter(new MyHZQEAdapter(list));
                            }
                        }
                    });


                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(mContext, GYQYAlertActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("xinxi",list.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
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
