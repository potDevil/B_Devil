package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.adapter.GridAdapter;
import com.example.fuzhihuangcom.b_devil.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/11.
 */

public class GridViewActivity extends BaseActivity {

    private GridView mGrid;
    private List<Integer> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        getData();
        initView();
    }

    private List getData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mList.add(R.drawable.fe_recomand);
        }
        return mList;
    }

    private void initView() {
        mGrid = (GridView) findViewById(R.id.grid);
        mGrid.setNumColumns(3);                                      // 一排3个
        mGrid.setVerticalSpacing(AndroidUtils.dip2px(this, 10));     // 列间距
        mGrid.setHorizontalSpacing(AndroidUtils.dip2px(this, 0));    // 行间距
        GridAdapter gridAdapter = new GridAdapter(getData());
        mGrid.setAdapter(gridAdapter);
    }
}
