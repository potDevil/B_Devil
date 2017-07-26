package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by fuzhihuang on 2017/7/25.
 * http://www.jianshu.com/p/f69873371763
 * 下拉提问的自定义view
 */

public class PullDownView extends View {
    private Context mContext;
    // 绘制图片
    private Paint mPaint1;
    // 绘制矩形
    private Paint mPaint2;
    // 绘制文字
    private Paint mPaint3;
    public float y;
    // Y坐标的开始位置
    private float mStartY;
    // Y坐标移动到点的位置
    private float mMoveY;
    // true为快速提问，false为指名提问
    private boolean flag = false;
    // 一张初始图，4张不同的图片
    public Bitmap mBitmap;
    private Bitmap mBitmap1;
    private Bitmap mBitmap2;
    private Bitmap mBitmap3;
    private Bitmap mBitmap4;
    // 矩形的4个位置
    float mLeft;
    float mTop;
    float mRight;
    float mBottom;
    // 文本的X轴的开始位置，文本的Y轴结束位置
    float mTextStartX;
    float mTextEndY = -10;

    public PullDownView(Context context) {
        this(context, null);
    }

    public PullDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_down);
        mContext = context;
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);       // 抗锯齿
        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_down);
        mBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_up);
        mBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.fast_question_down);
        mBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.fast_question_up);
        mLeft = dip2px(context, (float) 15.5);
        mRight = dip2px(context, 52);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(dip2px(mContext, 66), dip2px(mContext, 200));
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(dip2px(mContext, 66), heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, dip2px(mContext, 200));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制图片
        canvas.drawBitmap(mBitmap, 0, y, mPaint1);
        if (mBitmap != null && mBitmap.isRecycled()) {
            mBitmap.recycle();
        }
        // 绘制矩形
        mPaint2.setColor(Color.parseColor("#e24534"));
        Rect rect = new Rect((int) mLeft, (int) mTop, (int) mRight, (int) mBottom);
        canvas.drawRect(rect, mPaint2);
        // 画文本
        mPaint3.setColor(Color.parseColor("#fdfdfd"));
        mPaint3.setTextSize(dip2px(mContext, 11));
        mTextStartX = (float) (dip2px(mContext, (int) 28.5));
        canvas.drawText("开", mTextStartX, mTextEndY, mPaint3);
//        dip2px(mContext, 11)
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartY = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                mMoveY = event.getY();
                y = mMoveY - mStartY;
                if (y > 0 && y < dip2px(mContext, 70)) {
                    mBitmap = mBitmap1;
                    mBottom = y + dip2px(mContext, 2);
                    invalidate();
                } else if (y >= dip2px(mContext, 70)) {
                    y = dip2px(mContext, 70);
                    mBitmap = mBitmap2;
                    mBottom = y + dip2px(mContext, 2);
                    invalidate();
                }
                break;

            case MotionEvent.ACTION_UP:
                if (event.getY() >= dip2px(mContext, 70)) {
                    mBitmap = mBitmap3;
                    restore();
                    invalidate();
                } else {
                    restore();
                    invalidate();
                }
                break;
        }
        return true;
    }

    /**
     * 矩形、图形回到初始位置
     */
    private void restore() {
        mBottom = 0;
        y = 0;
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
