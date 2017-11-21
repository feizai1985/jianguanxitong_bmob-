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

import com.example.administrator.jianguanxitong.bean.HZQEBean;
import com.example.administrator.jianguanxitong.hzqe.HZQEAddActivity;
import com.example.administrator.jianguanxitong.hzqe.HZQEAlertActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class HuoZhengActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Context mConotext;
    private ListView hzqe_lv_item;
    private Button hzqe_bt_add;
    public static List<HZQEBean> list;
    private Button hzqe_bt_fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_zheng);

        mConotext = this;
        findview();
        hzqe_bt_add.setOnClickListener(this);
        showItem();

        hzqe_lv_item.setOnItemClickListener(this);

//        传递Bomb返回的list数据

    }



    private void showItem() {
      BmobQuery<HZQEBean> bmobQuery=new BmobQuery<>();

        bmobQuery.findObjects(new FindListener<HZQEBean>() {
            @Override
            public void done(List<HZQEBean> list, BmobException e) {
                if(e!=null){
                    Toast.makeText(mConotext,"加载数据失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    hzqe_lv_item.setAdapter(new MyHZQEAdapter(list));

                    HuoZhengActivity.list=list;
                }

            }
        });


    }

    private void findview() {
        hzqe_lv_item = (ListView) findViewById(R.id.hzqe_lv_item);
        hzqe_bt_add = (Button) findViewById(R.id.hzqe_bt_add);

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
//       添加企业
        case R.id.hzqe_bt_add:
            Intent intent=new Intent(this, HZQEAddActivity.class);
            startActivity(intent);
            finish();
            break;

        default:
            break;
    }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Intent intent=new Intent(HuoZhengActivity.this, HZQEAlertActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("xinxi",list.get(position));
        intent.putExtras(bundle);
        finish();
        startActivity(intent);

    }

    class MyHZQEAdapter extends BaseAdapter{


        private final List<HZQEBean> list;

        public MyHZQEAdapter(List<HZQEBean> list)  {
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
                view=new TextView(mConotext);
            }
            view.setText(list.get(position).getName());
            view.setTextSize(25);


            return view;
        }
    }


}
