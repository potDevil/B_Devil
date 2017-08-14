package com.example.fuzhihuangcom.b_devil.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.fuzhihuangcom.b_devil.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/14.
 */

public class GridAdapter extends BaseAdapter {

    List<Integer> mList = new ArrayList<>();

    public GridAdapter(List list) {
        this.mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.item_grid, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(mList.get(position));
        return view;
    }
}
