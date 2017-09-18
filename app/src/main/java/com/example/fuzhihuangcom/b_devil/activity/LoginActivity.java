package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.Entity.User;
import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.greendao.UserDao;
import com.example.fuzhihuangcom.b_devil.utils.DaoManager;

import java.util.List;

/**
 * Created by fuzhihuang on 2017/9/14.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEt_un;
    private EditText mEt_pw;
    private TextView mTv_login;
    private TextView mTv_register;

    private UserDao mUserDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initGreenDao();
    }

    private void initView() {
        mEt_un = (EditText) findViewById(R.id.et_un);
        mEt_pw = (EditText) findViewById(R.id.et_pw);
        mTv_login = (TextView) findViewById(R.id.tv_login);
        mTv_register = (TextView) findViewById(R.id.tv_register);

        mTv_login.setOnClickListener(this);
        mTv_register.setOnClickListener(this);

        setEditText(mEt_un);
        setEditText(mEt_pw);
    }

    private void initGreenDao() {
        mUserDao = DaoManager.getInstance(this).getSession().getUserDao();
    }

    private void setEditText(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() >= 8) {
                    showToast("用户名或者密码不能超过8个字符");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)}); //最大输入长度
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance()); //设置为密码输入框
    }

    private void addUser() {
        User user = new User(null, "admin", "admin");
        mUserDao.insert(user);
        showToast("注册成功");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                if (TextUtils.isEmpty(mEt_un.getText()) || TextUtils.isEmpty(mEt_pw.getText())) {
                    showToast("用户名或密码不能为空");
                } else if(!TextUtils.isEmpty(mEt_un.getText()) && !TextUtils.isEmpty(mEt_pw.getText())){
                    List<User> listUserName = mUserDao.queryBuilder().where(UserDao.Properties.Username.eq(mEt_un.getText().toString().replace(" ", ""))).build().list();
                    List<User> listPassword = mUserDao.queryBuilder().where(UserDao.Properties.Password.eq(mEt_pw.getText().toString().replace(" ", ""))).build().list();
                    User findUserName = mUserDao.queryBuilder().where(UserDao.Properties.Username.eq(mEt_un.getText().toString().replace(" ", ""))).build().unique();
                    User findPassword = mUserDao.queryBuilder().where(UserDao.Properties.Password.eq(mEt_pw.getText().toString().replace(" ", ""))).build().unique();
                    if (findUserName != null && findPassword != null) {
                        startActivity(MainActivity.class);
                    } else {
                        showToast("用户名或密码错误");
                    }
                }
                break;
            case R.id.tv_register:
                addUser();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEt_un.setText(null);
        mEt_pw.setText(null);
    }
}
