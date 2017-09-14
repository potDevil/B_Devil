package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.greendao.DaoMaster;

/**
 * Created by fuzhihuang on 2017/9/14.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(LoginActivity.this, "1", null);
    }
}
