package com.example.fuzhihuangcom.b_devil.bean;

/**
 * Created by fuzhihuang on 2017/8/8.
 */

public class StockInfo {
    private String stockName;
    private String stockCode;
    private String currentPrice;
    private String upDownPrice;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getUpDownPrice() {
        return upDownPrice;
    }

    public void setUpDownPrice(String upDownPrice) {
        this.upDownPrice = upDownPrice;
    }
}
