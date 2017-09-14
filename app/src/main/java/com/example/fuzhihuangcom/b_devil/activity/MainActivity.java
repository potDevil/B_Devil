package com.example.fuzhihuangcom.b_devil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.R;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

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
        list.add("拖拽控件");
        list.add("矩形模式");
        list.add("GridView");
        list.add("Nine_Photo");
        list.add("文字渐变效果");
        list.add("测试A");
        list.add("测试B");
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.lv);
        mListView.setAdapter(new MyAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(AddAndMinusActivity.class);
                } else if (position == 1) {
                   startActivity(DrawCircleActivity.class);
                } else if (position == 2) {
                    startActivity(PullDownActivity.class);
                } else if (position == 3) {
                  startActivity(RippleActivity.class);
                } else if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, BandRectActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                  /*  Intent intent = new Intent(MainActivity.this, BasicViewGroupActivity.class);
                    startActivity(intent);*/
                    showToast("还未完成");
                } else if (position == 6) {
                    startActivity(RectAnimationActivity.class);
                } else if (position == 7) {
                    startActivity(DragActivity.class);
                } else if (position == 8) {
                    startActivity(RectActivity.class);
                } else if (position == 9) {
                    startActivity(GridViewActivity.class);
                } else if(position == 10) {
                    startActivity(NinePhotoActivity.class);
                } else if(position == 11) {
//                    Intent intent = new Intent(MainActivity.this, TextColorChangeActvity.class);
//                    startActivity(intent);
                    showToast("还未完成");
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
