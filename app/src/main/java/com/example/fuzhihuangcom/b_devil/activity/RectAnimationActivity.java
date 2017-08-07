package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.RectAnimationViewGroup;

/**
 * Created by fuzhihuang on 2017/8/4.
 */

public class RectAnimationActivity extends AppCompatActivity {

    private RectAnimationViewGroup mRavg;
    private Button mBt1;
    private Button mBt2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect_animator);

        mRavg = (RectAnimationViewGroup) findViewById(R.id.ravg);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt2 = (Button) findViewById(R.id.bt2);

        mBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RectAnimationActivity.this, "按钮1", Toast.LENGTH_SHORT).show();
                mRavg.setRectColor(false);
                mRavg.startAnimation();

            }
        });

        mBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RectAnimationActivity.this, "按钮2", Toast.LENGTH_SHORT).show();
                mRavg.setRectColor(true);
                mRavg.startAnimation();
            }
        });
    }
}
