package com.example.fuzhihuangcom.b_devil.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.adapter.TestAdapter;
import com.example.fuzhihuangcom.b_devil.bean.StockInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzhihuang on 2017/8/8.
 */

public class RecycleviewAnimationActivity extends Activity {

    private RecyclerView mRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_animation);

        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        TestAdapter ta = new TestAdapter(getStockInfo());
        mRv.setAdapter(ta);
    }

    private List<StockInfo> getStockInfo() {
        List<StockInfo> stockInfos = new ArrayList<>();
        for (int i = 0; i < 99999; i++) {
            StockInfo stockInfo = new StockInfo();
            if (i % 5 == 0) {
                stockInfo.setStockName("万达集团");
                stockInfo.setStockCode("0000001");
            } else if (i % 5 == 1) {
                stockInfo.setStockName("阿里巴巴");
                stockInfo.setStockCode("0000002");
            } else if (i % 5 == 2) {
                stockInfo.setStockName("腾讯集团");
                stockInfo.setStockCode("0000003");
            } else if (i % 5 == 3) {
                stockInfo.setStockName("百度集团");
                stockInfo.setStockCode("0000004");
            } else if (i % 5 == 4) {
                stockInfo.setStockName("网易集团");
                stockInfo.setStockCode("0000005");
            }
            stockInfo.setCurrentPrice(i + "");
            stockInfo.setUpDownPrice(i + "%");
            stockInfos.add(stockInfo);
        }
        return stockInfos;
    }
}
