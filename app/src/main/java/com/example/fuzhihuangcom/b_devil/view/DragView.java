package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by fuzhihuang on 2017/8/7.
 */

public class DragView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public DragView(Context context) {
        super(context);
        ininView(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView(context);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView(context);
    }

    private void ininView(Context context) {
        setBackgroundColor(Color.GRAY);
        // 初始化Scroller
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        // 判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY());
            // 通过重绘来不断调用computeScroll
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getX();
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;

//                Log.i("devil" , "offsetX:" + offsetX);
//                Log.i("devil" , "offsetY:" + offsetY);

                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                // 手指离开时，执行滑动过程
                View viewGroup = ((View) getParent());
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY());

//                Log.i("devil" , "viewGroup.getScrollX():" + viewGroup.getScrollX());
//                Log.i("devil" , "viewGroup.getScrollY():" + viewGroup.getScrollY());

                invalidate();
                break;
        }
        return true;
    }
}
