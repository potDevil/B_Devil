package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by fuzhihuang on 2017/7/25.
 * 下拉提问的自定义view
 */

public class PullDownView extends View {

    private Paint mPaint1;
    private Context mContext;
    private Canvas mCanvas;
    private Bitmap mBitmap;
    private float mStartY;
    private float mMoveY;
    private float mUpY;

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
        mContext = context;
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);       // 抗锯齿
        mCanvas = new Canvas();
        // mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);       // 抗锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pulldown1);
        canvas.drawBitmap(mBitmap, dip2px(mContext, 305), 0, mPaint1);
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mMoveY = event.getY();
                if (mMoveY - mStartY > 0) {
                    mCanvas.drawBitmap(mBitmap, dip2px(mContext, 305), dip2px(mContext, mMoveY - mStartY), mPaint1);
                }
                break;
            case MotionEvent.ACTION_UP:
                mUpY = event.getY();
                break;
        }
        return true;
    }
}
