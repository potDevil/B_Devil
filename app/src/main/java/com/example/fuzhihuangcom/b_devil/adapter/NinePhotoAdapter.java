package com.example.fuzhihuangcom.b_devil.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.bean.NinePhotoInfo;

import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/15.
 */

public class NinePhotoAdapter extends BaseQuickAdapter<NinePhotoInfo, BaseViewHolder> {
    public NinePhotoAdapter(@Nullable List<NinePhotoInfo> data) {
        super(R.layout.item_moment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NinePhotoInfo item) {

    }
}
