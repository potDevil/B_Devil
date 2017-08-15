//package com.example.fuzhihuangcom.b_devil.view.NinePhotoView.holder;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.fuzhihuangcom.b_devil.view.NinePhotoView.helper.BGAViewHolderHelper;
//
///**
// * Created by fuzhihuang on 2017/8/15.
// */
//
//public class BGAAdapterViewHolder {
//    protected View mConvertView;
//    protected BGAViewHolderHelper mViewHolderHelper;
//
//    private BGAAdapterViewHolder(ViewGroup parent, int layoutId) {
//        mConvertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
//        mConvertView.setTag(this);
//        mViewHolderHelper = new BGAViewHolderHelper(parent, mConvertView);
//    }
//
//    /**
//     * 拿到一个可重用的ViewHolder对象
//     *
//     * @param convertView
//     * @param parent
//     * @param layoutId
//     * @return
//     */
//    public static BGAAdapterViewHolder dequeueReusableAdapterViewHolder(View convertView, ViewGroup parent, int layoutId) {
//        if (convertView == null) {
//            return new BGAAdapterViewHolder(parent, layoutId);
//        }
//        return (BGAAdapterViewHolder) convertView.getTag();
//    }
//
//    public BGAViewHolderHelper getViewHolderHelper() {
//        return mViewHolderHelper;
//    }
//
//    public View getConvertView() {
//        return mConvertView;
//    }
//
//}
