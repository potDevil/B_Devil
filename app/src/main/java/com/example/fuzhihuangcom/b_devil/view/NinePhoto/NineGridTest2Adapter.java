package com.example.fuzhihuangcom.b_devil.view.NinePhoto;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fuzhihuangcom.b_devil.R;

import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/17.
 */

public class NineGridTest2Adapter extends BaseQuickAdapter<NineGridTestModel, BaseViewHolder> {
    public NineGridTest2Adapter(@Nullable List<NineGridTestModel> data) {
        super(R.layout.item_nine_photo_grid, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NineGridTestModel item) {
        NineGridTestLayout layout = helper.getView(R.id.layout_nine_grid);
        layout.setIsShowAll(item.isShowAll);
        layout.setUrlList(item.urlList);
    }
}
