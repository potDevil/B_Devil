package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.AddView;

/**
 * Created by fuzhihuang on 2017/7/3.
 * +or- acitivty
 */

public class AddAndMinusActivity extends AppCompatActivity {

    private AddView mAdd_view;
    private TextView mTest_view1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addandminus);
        mAdd_view = (AddView) findViewById(R.id.add_view);
        mTest_view1 = (TextView) findViewById(R.id.test_view1);

        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(115, View.MeasureSpec.EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(80, View.MeasureSpec.EXACTLY);
        mTest_view1.measure(widthMeasureSpec, heightMeasureSpec);
    }

    // 获取控件宽高的方法一：
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            int width = mTest_view1.getMeasuredWidth();
            int height = mTest_view1.getMeasuredHeight();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        // 获取控件宽高的方法二：
//        mTest_view1.post(new Runnable() {
//            @Override
//            public void run() {
//                int width = mTest_view1.getMeasuredWidth();
//                int height = mTest_view1.getMeasuredHeight();
//            }
//        });
        // 获取控件宽高方法三
        ViewTreeObserver observer = mTest_view1.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mTest_view1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width = mTest_view1.getMeasuredWidth();
                int height = mTest_view1.getMeasuredHeight();
            }
        });
    }


}
