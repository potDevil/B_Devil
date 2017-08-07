package com.example.fuzhihuangcom.b_devil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuzhihuangcom.b_devil.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        init();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("加减号按钮");
        list.add("自定义圆");
        list.add("下拉刷新自定义横幅");
        list.add("水波纹效果");
        list.add("音频条形图");
        list.add("自定义组合控件");
        list.add("条形动画");
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.lv);
        mListView.setAdapter(new MyAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, AddAndMinusActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, DrawCircleActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, PullDownActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, RippleActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, BandRectActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                  /*  Intent intent = new Intent(MainActivity.this, BasicViewGroupActivity.class);
                    startActivity(intent);*/
                    Toast.makeText(MainActivity.this, "还未完成", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Intent intent = new Intent(MainActivity.this, RectAnimationActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
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
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.activity_listview_item, null);
                holder.tv = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv.setText(list.get(position));
            return convertView;
        }
    }

    class ViewHolder {
        TextView tv;
    }
}
