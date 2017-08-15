package com.example.fuzhihuangcom.b_devil.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.adapter.NinePhotoAdapter;
import com.example.fuzhihuangcom.b_devil.bean.NinePhotoInfo;

import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/15.
 */

public class NinePhotoActivity extends Activity {

    private RecyclerView mRv_nine_photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_photo);
        mRv_nine_photo = (RecyclerView) findViewById(R.id.rv_nine_photo);

        initRecycleView();
    }

    private void initRecycleView() {
        mRv_nine_photo.setLayoutManager(new LinearLayoutManager(this));
        NinePhotoAdapter ta = new NinePhotoAdapter(getData());
        mRv_nine_photo.setAdapter(ta);
    }

    private List<NinePhotoInfo> getData() {
        return null;
    }
}
