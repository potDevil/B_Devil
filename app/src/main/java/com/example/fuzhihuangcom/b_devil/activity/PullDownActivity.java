package com.example.fuzhihuangcom.b_devil.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.PullDownView;

/**
 * Created by fuzhihuang on 2017/7/25.
 * 下拉横幅刷新控件
 */

public class PullDownActivity extends Activity implements View.OnTouchListener {

    private PullDownView mPdv;
    private TextView mTv;
//    private int bitmapWidth;
//    private int bitmapHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_down);
        mPdv = (PullDownView) findViewById(R.id.pdv);
        mTv = (TextView) findViewById(R.id.tv);
        mPdv.showView(false);
//        mPdv.setOnTouchListener(this);
        mPdv.setPullDownListener(new PullDownView.PullDownListener() {
            @Override
            public void pullDownBottom() {
                mTv.setBackgroundResource(R.drawable.skip_rect);
            }

            @Override
            public void pullNoDown() {
                mTv.setBackgroundResource(R.drawable.pull_down_rect);
            }

            public void switchView(boolean flag){
                // 切换页面
                if(flag) {

                } else {

                }
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        mPdv.x = event.getX() - bitmapWidth / 2;
//        mPdv.y = event.getY() - bitmapHeight / 2;
//        mPdv.invalidate();
        return false;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        bitmapWidth = mPdv.mBitmap.getWidth();
//        bitmapHeight = mPdv.mBitmap.getHeight();
    }
}
