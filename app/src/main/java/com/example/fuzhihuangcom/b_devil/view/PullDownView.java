package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.utils.AndroidUtils;

import static com.example.fuzhihuangcom.b_devil.utils.AndroidUtils.dip2px;

/**
 * Created by fuzhihuang on 2017/7/25.
 * 下拉提问的自定义view
 */

public class PullDownView extends View {
    // 回调用的接口（下拉到底部监听）
    private PullDownView.PullDownListener mPullDownListener;
    // 上下文
    private Context mContext;
    // 绘制图片
    private Paint mPaint1;
    // 图片Y轴坐标
    public float y;
    // Y坐标的开始位置
    private float mStartY;
    // Y坐标移动到点的位置
    private float mMoveY;
    // true为快速提问，false为指名提问
    private boolean mFlag;
    // 一张初始图，6张不同的图片
    private Bitmap mBitmap;
    private Bitmap mBitmap1;
    private Bitmap mBitmap2;
    private Bitmap mBitmap3;
    private Bitmap mBitmap4;
    private Bitmap mBitmap5;
    private Bitmap mBitmap6;
    // 下拉的最大位置
    private int downMax;

    public PullDownView(Context context) {
        this(context, null);
    }

    public PullDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PullDownView);
        mFlag = ta.getBoolean(R.styleable.PullDownView_view_status, false);
        ta.recycle();
        showView(mFlag);
        init(context);
    }

    /**
     * 展示快速提问还是指名提问
     * @param flag true为快速提问，false为指名提问
     */
    public void showView(boolean flag) {
        mFlag = flag;
        if (flag) {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fast_question_down_tint);
        } else {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_down_tint);
        }
    }

    private void init(Context context) {
        mContext = context;
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);       // 抗锯齿
        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_down_tint);
        mBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.fast_question_down_tint);
        mBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_down_dark);
        mBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.fast_question_down_dark);
        mBitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.fast_question_up_dark);
        mBitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.point_question_up_dark);

        downMax = dip2px(mContext, (int) 60.5);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(AndroidUtils.dip2px(mContext, 66), dip2px(mContext, 140));
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(dip2px(mContext, 66), heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, dip2px(mContext, 140));
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
                if (y > 0 && y < downMax) {                                                         // 还未拉到最底下
                    // 设置为下拉切换
                    mPullDownListener.pullNoDown();
                    if (mFlag) {                                                                    // true 当前界面为快速提问，图变为快速提问深色down
                        mBitmap = mBitmap4;
                    } else {                                                                        // false 当前界面为指名提问,图变为指名提问深色down
                        mBitmap = mBitmap3;
                    }
                    invalidate();
                } else if (y >= downMax) {                                                          // 拉到最底下
                    // 设置为松开跳转
                    mPullDownListener.pullDownBottom();
                    if (mFlag) {                                                                    // true  当前界面为快速提问，图变为快速提问深色up
                        mBitmap = mBitmap5;
                    } else {                                                                        // false 当前界面为指名提问,图变为指名提问深色up
                        mBitmap = mBitmap6;
                    }
                    y = downMax;
                    invalidate();
                }
                break;

            case MotionEvent.ACTION_UP:
                if (event.getY() - mStartY >= downMax) {                                            // 拉到底下弹回
//                    Toast.makeText(mContext, "拉到最底下了", Toast.LENGTH_SHORT).show();
                    if (mFlag) {                                                                    // false 快速提问变指名提问，并且颜色变tink，down, 并且flag为true
                        mBitmap = mBitmap1;
                    } else {                                                                        // false 指名提问变快速提问，并且颜色变tink，down, 并且flag为true
                        mBitmap = mBitmap2;
                    }
                    mPullDownListener.switchView(mFlag);
                    mFlag = !mFlag;
                    y = 0;
                    invalidate();
                } else if (event.getY() - mStartY >= 0 && event.getY() - mStartY < downMax) {       // 未拉到最底下弹回
//                    Toast.makeText(mContext, "还没拉到最底下", Toast.LENGTH_SHORT).show();
                    if (mFlag) {                                                                    // false 快速提问还是快速提问题，颜色变浅，down, flag不变
                        mBitmap = mBitmap2;
                    } else {                                                                        // false 指名提问还是指名提问题，颜色变浅，down, flag不变
                        mBitmap = mBitmap1;
                    }
                    y = 0;
                    invalidate();
                }
                break;
        }
        return true;
    }



    public interface PullDownListener {
        /**
         * 未拉到最下方，设置背景图片为下拉切换
         */
        void pullNoDown();

        /**
         * 已拉到最下方，设置背景图片为松开跳转
         */
        void pullDownBottom();

        /**
         * 切换界面操作
         *
         * @param flag true为快速提问，false为指名提问
         */
        void switchView(boolean flag);
    }

    public void setPullDownListener(PullDownListener listener) {
        this.mPullDownListener = listener;
    }
}
