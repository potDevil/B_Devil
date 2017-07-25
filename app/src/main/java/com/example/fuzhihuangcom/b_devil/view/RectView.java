package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fuzhihuang on 2017/7/25.
 * 下拉提问的自定义view
 */

public class RectView extends View {

    private Paint mPaint1;

    public RectView(Context context) {
        this(context, null);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);       // 抗锯齿
        // mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);       // 抗锯齿
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, 400);
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 400);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        final int paddingRight = getPaddingRight();
        final int paddingLeft = getPaddingLeft();

        int width = getWidth() - paddingRight - paddingLeft;
        int height = getHeight() - paddingTop - paddingBottom;
        mPaint1.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint1.setColor(Color.RED);
        /*int radius = Math.min(width, height) / 2;
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, mPaint1);*/
        // 画顶部的矩形
        canvas.drawRect(0, 0, width, height, mPaint1);
        // 画矩形中的三角形
        mPaint1.setColor(Color.WHITE);
        Path path = new Path();
        path.moveTo(width/2 - 10, height/2 - 5);
        path.lineTo(width/2 + 10, height/2 - 5);
        path.lineTo(width/2, height/2 + 5);
        path.close();
        canvas.drawPath(path, mPaint1);
    }
}
