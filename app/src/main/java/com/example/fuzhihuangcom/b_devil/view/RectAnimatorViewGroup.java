package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by BigDevil on 2017/8/6.
 */

public class RectAnimatorViewGroup extends RelativeLayout {

    private RectAnimatorView mRectAnimatorView;
    private Context mContext;
    private View mView;
    private TranslateAnimation mAnimation;

    public RectAnimatorViewGroup(Context context) {
        this(context, null);
    }

    public RectAnimatorViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectAnimatorViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        init();
    }

    private void initView() {
        mView = inflate(mContext, R.layout.rect_animator_viewgroup, this);
        // 获取控件
        mRectAnimatorView = (RectAnimatorView) mView.findViewById(R.id.rav);
    }

    private void init() {
        // 获取屏幕宽
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        // 获取控件的宽
        int viewWidth = mRectAnimatorView.getWidth();
        // 设置动画
        mAnimation = new TranslateAnimation(width + viewWidth, -200, 0, 0);
        mAnimation.setDuration(500);//设置动画持续时间
        mAnimation.setRepeatCount(0);//设置重复次数

        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mRectAnimatorView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void startAnimation() {
        if (mAnimation != null)
            mRectAnimatorView.setVisibility(View.VISIBLE);
            mRectAnimatorView.setAnimation(mAnimation);
            mAnimation.start();
    }
}
