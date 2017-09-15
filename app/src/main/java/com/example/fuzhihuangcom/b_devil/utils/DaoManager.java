package com.example.fuzhihuangcom.b_devil.utils;

import android.content.Context;

import com.example.fuzhihuangcom.b_devil.greendao.DaoMaster;
import com.example.fuzhihuangcom.b_devil.greendao.DaoSession;

/**
 * Created by fuzhihuang on 2017/9/14.
 */

public class DaoManager {
    private static DaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private DaoManager(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "login-db", null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public static DaoManager getInstance(Context context) {
        if(mInstance == null) {
            synchronized (DaoManager.class) {
                if(mInstance == null) {
                    mInstance = new DaoManager(context);
                }
            }
        }
        return mInstance;
    }
}
