package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.CircleView;

/**
 * Created by fuzhihuang on 2017/7/5.
 * 自定义固定圆
 */

public class DrawCircleActivity extends AppCompatActivity {

    private CircleView mCv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_circle);
        mCv = (CircleView) findViewById(R.id.cv);
        mCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCv.smoothScrollTo(-350, 0);
            }
        });

    }
}
