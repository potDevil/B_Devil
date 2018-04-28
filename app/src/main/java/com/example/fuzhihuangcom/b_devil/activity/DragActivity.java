package com.example.fuzhihuangcom.b_devil.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by fuzhihuang on 2017/8/7.
 * 平移动画
 */

public class DragActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        final TextView tv_news = (TextView) findViewById(R.id.tv_news);
        Button bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 0);
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                tv_news.startAnimation(translateAnimation);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //清除动画
                        int left = tv_news.getLeft()+ 100;
                        int top = tv_news.getTop();
                        int width = tv_news.getWidth();
                        int height = tv_news.getHeight();
                        tv_news.clearAnimation();
                        tv_news.layout(left, top, left+width, top+height);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
        });

    }
}
