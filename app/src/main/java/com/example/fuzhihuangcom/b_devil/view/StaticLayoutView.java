package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fuzhihuang on 2017/9/30.
 */

public class StaticLayoutView extends View {
    TextPaint textPaint = null;
    StaticLayout staticLayout = null;
    Paint paint = null;
    int width = 50;
    int height = 0;
    String txt = null;
    boolean running = false;

    public StaticLayoutView(Context context) {
        this(context, null);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(12);
        txt = "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈";
        staticLayout = new StaticLayout(txt, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
        height = staticLayout.getHeight();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                running = !running;
                if (running) {
                    new Thread() {
                        public void run() {
                            while (running) {
                                width++;
                                staticLayout = new StaticLayout(txt, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
                                height = staticLayout.getHeight();
                                postInvalidate();
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                if (width >= 300) {
                                    width = 50;
                                }
                            }
                        }

                        ;
                    }.start();
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        canvas.translate(20, 20);
        staticLayout.draw(canvas);
        canvas.drawRect(0, 0, width, height, paint);
        super.onDraw(canvas);
    }

}

