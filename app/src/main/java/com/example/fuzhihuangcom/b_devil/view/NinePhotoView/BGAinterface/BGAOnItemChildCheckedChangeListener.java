package com.example.fuzhihuangcom.b_devil.view.NinePhotoView.BGAinterface;

import android.view.ViewGroup;
import android.widget.CompoundButton;

/**
 * Created by fuzhihuang on 2017/8/15.
 */

public interface BGAOnItemChildCheckedChangeListener {
    void onItemChildCheckedChanged(ViewGroup parent, CompoundButton childView, int position, boolean isChecked);
}