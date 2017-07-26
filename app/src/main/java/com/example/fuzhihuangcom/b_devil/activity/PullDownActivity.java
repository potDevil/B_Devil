package com.example.fuzhihuangcom.b_devil.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.PullDownView;

/**
 * Created by fuzhihuang on 2017/7/25.
 */

public class PullDownActivity extends Activity implements View.OnTouchListener {

    private PullDownView mPdv;
//    private int bitmapWidth;
//    private int bitmapHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_down2);
        mPdv = (PullDownView) findViewById(R.id.pdv);
//        mPdv.setOnTouchListener(this);
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
