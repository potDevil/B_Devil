package com.example.fuzhihuangcom.b_devil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by fuzhihuang on 2017/9/14.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (isLauncherStart()) {
            return;
        }

        jump2main();
    }

    private void jump2main() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(LoginActivity.class);
                finish();
            }
        }, 2500);
    }

    private boolean isLauncherStart() {
        if (!this.isTaskRoot()) {
            Intent mainIntent = getIntent();
            String action = mainIntent.getAction();
            if (mainIntent.hasCategory(Intent.CATEGORY_LAUNCHER) && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return true;
            }
        }
        return false;
    }
}
