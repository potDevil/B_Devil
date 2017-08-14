package com.example.fuzhihuangcom.b_devil.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by BigDevil on 2017/8/6.
 */

// view动画

//public class RectAnimationViewGroup extends RelativeLayout {
//
//    private RectAnimationView mRectAnimationView;
//    private Context mContext;
//    private View mView;
//    private TranslateAnimation mAnimation;
//
//    public RectAnimationViewGroup(Context context) {
//        this(context, null);
//    }
//
//    public RectAnimationViewGroup(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public RectAnimationViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        mContext = context;
//        initView();
//        init();
//    }
//
//    private void initView() {
//        mView = inflate(mContext, R.layout.viewgroup_rect_animation, this);
//        // 获取控件
//        mRectAnimationView = (RectAnimationView) mView.findViewById(R.id.rav);
//    }
//
//    private void init() {
//        // 获取屏幕宽
//        DisplayMetrics dm = getResources().getDisplayMetrics();
//        int width = dm.widthPixels;
//        // 获取控件的宽
//        int viewWidth = mRectAnimationView.getWidth();
//        // 设置动画
//        mAnimation = new TranslateAnimation(width + viewWidth + 150, -200, 0, 0);
//        mAnimation.setDuration(300);//设置动画持续时间
//        mAnimation.setRepeatCount(0);//设置重复次数
//
//        mAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                mRectAnimationView.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//    }
//
//    /**
//     * 开启动画
//     */
//    public void startAnimation() {
//        if (mAnimation != null) {
//            mRectAnimationView.setVisibility(View.VISIBLE);
//            mRectAnimationView.setAnimation(mAnimation);
//            mAnimation.start();
//        }
//    }
//
//    /**
//     * 设置长条颜色 红色代表涨 绿色代表跌
//     * @param flag  true绿   false红
//     */
//    public void setRectColor(boolean flag) {
//        mRectAnimationView.setPaintColor(flag);
//    }
//}


// 属性动画
public class RectAnimationViewGroup extends RelativeLayout {

    private RectAnimationView mRectAnimationView;
    private Context mContext;
    private View mView;
    private ValueAnimator mAnimation;

    public RectAnimationViewGroup(Context context) {
        this(context, null);
    }

    public RectAnimationViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectAnimationViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        init();
    }

    private void initView() {
        mView = inflate(mContext, R.layout.viewgroup_rect_animation, this);
        // 获取控件
        mRectAnimationView = (RectAnimationView) mView.findViewById(R.id.rav);
    }

    private void init() {
        // 获取屏幕宽
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        // 获取控件的宽
        int viewWidth = mRectAnimationView.getWidth();
        // 设置动画
        mAnimation = ValueAnimator.ofInt(width + viewWidth + 190, -200);
        mAnimation.setDuration(400);
        mAnimation.setInterpolator(new LinearInterpolator());//线性效果变化
        mAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer integer = (Integer) mAnimation.getAnimatedValue();
                mRectAnimationView.setTranslationX(integer);
            }
        });
        mAnimation.start();
//        mAnimation = new TranslateAnimation(width + viewWidth + 190, -200, 0, 0);
//        mAnimation.setDuration(400);    // 设置动画持续时间
//        mAnimation.setRepeatCount(0);   // 设置重复次数

        /*mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mRectAnimationView.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
    }

    /**
     * 开启动画
     */
    public void startAnimation() {
        if (mAnimation != null) {
            mRectAnimationView.setVisibility(View.VISIBLE);
//            mRectAnimationView.setAnimation(mAnimation);
            mAnimation.start();
        }
    }

    public void clearAnimation() {
        mRectAnimationView.clearAnimation();
    }

    /**
     * 设置长条颜色 红色代表涨 绿色代表跌
     *
     * @param flag true绿   false红
     */
    public void setRectColor(boolean flag) {
        mRectAnimationView.setPaintColor(flag);
    }
}