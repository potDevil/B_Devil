package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by fuzhihuang on 2017/10/20.
 */

public class InputBoxActivity extends BaseActivity {

    private EditText mEt_input_box;
    private TextView mTv_input_box;
    private int max = 500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_box);
        initView();
    }

    private void initView() {
        mEt_input_box = (EditText) findViewById(R.id.et_input_box);
        mTv_input_box = (TextView) findViewById(R.id.tv_input_box);

        mEt_input_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTv_input_box.setText("剩余字数:" + (500 - s.length()));
            }
        });
    }
}
