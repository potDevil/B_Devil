package com.example.fuzhihuangcom.b_devil.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.bean.StockInfo;
import com.example.fuzhihuangcom.b_devil.view.RectAnimationViewGroup;

import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/8.
 */

public class TestAdapter extends BaseQuickAdapter<StockInfo, BaseViewHolder> {

    private RectAnimationViewGroup mRavg;

    public TestAdapter(@Nullable List<StockInfo> data) {
        super(R.layout.item_test_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StockInfo item) {
        mRavg = (RectAnimationViewGroup) helper.getConvertView().findViewById(R.id.ravg);
        helper.setText(R.id.tv_stock_name, item.getStockName())
                .setText(R.id.tv_stock_code, item.getStockCode())
                .setText(R.id.tv_current_price, "¥ " + item.getCurrentPrice())
                .setText(R.id.tv_up_down, item.getUpDownPrice());

        mRavg.setRectColor(false);
        mRavg.startAnimation();

    }
}
