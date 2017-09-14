package com.example.fuzhihuangcom.b_devil.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by fuzhihuang on 2017/9/14.
 */

public class BaseActivity extends Activity {

    private Toast mToast;

    public void startActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(BaseActivity.this, activity);
        startActivity(intent);
    }

    public void showToast(String s) {
        if (TextUtils.isEmpty(s))
            return;
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
