package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by BigDevil on 2017/8/6.
 */

public class RectAnimatorViewGroup extends RelativeLayout {

    private RectAnimatorView mRectAnimatorView;
    private Button mBt;
    private Context mContext;
    private View mView;

    public RectAnimatorViewGroup(Context context) {
        this(context, null);
    }

    public RectAnimatorViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectAnimatorViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mView = inflate(context, R.layout.rect_animator_viewgroup, null);
        mContext = context;
        // 获取控件
        mRectAnimatorView = (RectAnimatorView) mView.findViewById(R.id.rav);
        mBt = (Button) mView.findViewById(R.id.bt);
        init();
    }

    private void init() {
        // 获取屏幕宽
        DisplayMetrics dm2 = getResources().getDisplayMetrics();
        int width = dm2.widthPixels;
        // 获取控件的宽
        int viewWidth = mRectAnimatorView.getWidth();
        // 设置动画
        final TranslateAnimation animation = new TranslateAnimation(width + viewWidth, -200, 0, 0);
        animation.setDuration(1000);//设置动画持续时间
        animation.setRepeatCount(0);//设置重复次数

        animation.setAnimationListener(new Animation.AnimationListener() {
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

        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRectAnimatorView.setVisibility(View.VISIBLE);
                mRectAnimatorView.setAnimation(animation);
                animation.start();
            }
        });
    }
}
