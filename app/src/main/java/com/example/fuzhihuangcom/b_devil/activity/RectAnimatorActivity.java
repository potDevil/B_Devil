package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.RectAnimatorViewGroup;

/**
 * Created by fuzhihuang on 2017/8/4.
 */

public class RectAnimatorActivity extends AppCompatActivity {

    private Button mBt;
    private RectAnimatorViewGroup mRavg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect_animator);

        mRavg = (RectAnimatorViewGroup) findViewById(R.id.ravg);
        mBt = (Button) findViewById(R.id.bt);

        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RectAnimatorActivity.this, "123", Toast.LENGTH_SHORT).show();
                mRavg.startAnimation();
            }
        });

    }
}
