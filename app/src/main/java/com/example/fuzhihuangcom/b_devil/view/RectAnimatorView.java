package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fuzhihuang on 2017/8/4.
 */

public class RectAnimatorView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);// 抗锯齿
    private Context mContext;

    public RectAnimatorView(Context context) {
        this(context, null);
    }

    public RectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        mPaint.setColor(Color.parseColor("#17b03e"));
        mPaint.setAlpha(12);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(PullDownView.dip2px(mContext, 240), PullDownView.dip2px(mContext, 50));
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(PullDownView.dip2px(mContext, 240), heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, PullDownView.dip2px(mContext, 50));
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
        canvas.drawRect(0, 0, PullDownView.dip2px(mContext, 240), height, mPaint);
        mPaint.setAlpha(15);
        canvas.drawRect(PullDownView.dip2px(mContext, 20), 0, PullDownView.dip2px(mContext, 240) - PullDownView.dip2px(mContext, 20), height, mPaint);
        mPaint.setAlpha(25);
        canvas.drawRect(PullDownView.dip2px(mContext, 40), 0, PullDownView.dip2px(mContext, 240) - PullDownView.dip2px(mContext, 40), height, mPaint);
        mPaint.setAlpha(30);
        canvas.drawRect(PullDownView.dip2px(mContext, 60), 0, PullDownView.dip2px(mContext, 240) - PullDownView.dip2px(mContext, 60), height, mPaint);
        mPaint.setAlpha(35);
        canvas.drawRect(PullDownView.dip2px(mContext, 80), 0, PullDownView.dip2px(mContext, 240) - PullDownView.dip2px(mContext, 80), height, mPaint);
    }
}
