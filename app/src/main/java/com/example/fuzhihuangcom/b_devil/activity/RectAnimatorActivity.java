package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.RectAnimatorView;

/**
 * Created by fuzhihuang on 2017/8/4.
 */

public class RectAnimatorActivity extends AppCompatActivity {

    private RectAnimatorView mRectAnimatorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect_animator);
        // 获取控件
        mRectAnimatorView = (RectAnimatorView) findViewById(R.id.rav);
        // 获取屏幕宽
        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        // 获取控件的宽
        int viewWidth = mRectAnimatorView.getWidth();
        // 设置动画
        TranslateAnimation animation = new TranslateAnimation(width + viewWidth, -200, 0, 0);
        animation.setDuration(1000);//设置动画持续时间
        animation.setRepeatCount(1);//设置重复次数
        mRectAnimatorView.setAnimation(animation);
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
    }
}
