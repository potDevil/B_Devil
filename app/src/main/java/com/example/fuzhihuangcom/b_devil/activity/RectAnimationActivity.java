package com.example.fuzhihuangcom.b_devil.activity;

import android.content.Intent;
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

public class RectAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private RectAnimationViewGroup mRavg;
    private Button mBt1;
    private Button mBt2;
    private Button mBt3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect_animation);

        mRavg = (RectAnimationViewGroup) findViewById(R.id.ravg);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt3 = (Button) findViewById(R.id.bt3);

        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
        mBt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                Toast.makeText(RectAnimationActivity.this, "按钮1", Toast.LENGTH_SHORT).show();
                mRavg.setRectColor(false);
                mRavg.startAnimation();
                break;

            case R.id.bt2:
                Toast.makeText(RectAnimationActivity.this, "按钮2", Toast.LENGTH_SHORT).show();
                mRavg.setRectColor(true);
                mRavg.startAnimation();
                break;

            case R.id.bt3:
                Intent intent = new Intent(RectAnimationActivity.this, RecycleviewAnimationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
