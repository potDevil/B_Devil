package com.example.fuzhihuangcom.b_devil.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.bean.NineGridTestInfo;
import com.example.fuzhihuangcom.b_devil.view.NineGridTestLayout;

import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/17.
 */

public class NineGridAdapter extends BaseQuickAdapter<NineGridTestInfo, BaseViewHolder> {
    public NineGridAdapter(@Nullable List<NineGridTestInfo> data) {
        super(R.layout.item_nine_photo_grid, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NineGridTestInfo item) {
        NineGridTestLayout layout = helper.getView(R.id.layout_nine_grid);
        layout.setIsShowAll(item.isShowAll);
        layout.setUrlList(item.urlList);
    }
}
