package com.example.fuzhihuangcom.b_devil.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.RectAnimationView;

/**
 * Created by fuzhihuang on 2017/8/11.
 */

public class RectActivity extends BaseActivity {

    private RectAnimationView mRav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect);
        mRav = (RectAnimationView) findViewById(R.id.rav);

        final ValueAnimator animator = ValueAnimator.ofInt(1, 100);
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());//线性效果变化
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer integer = (Integer) animator.getAnimatedValue();
                mRav.setTranslationX(integer);
            }
        });
        animator.start();
    }
}
