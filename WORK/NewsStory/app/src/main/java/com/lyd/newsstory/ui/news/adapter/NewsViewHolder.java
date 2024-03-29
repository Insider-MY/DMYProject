package com.lyd.newsstory.ui.news.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyd.newsstory.R;
import com.lyd.newsstory.bean.NewsGson;
import com.lyd.newsstory.util.PictureUtil;

public class NewsViewHolder extends BaseViewHolder<NewsGson.NewslistBean> {

    private TextView mTv_name;
    private ImageView mImg_face;
    private TextView mTv_sign;

    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_recycler_item);
        mTv_name = $(R.id.person_name);
        mTv_sign = $(R.id.person_sign);
        mImg_face = $(R.id.person_face);
    }

    @Override
    public void setData(NewsGson.NewslistBean data) {
        mTv_name.setText(data.getTitle());
        mTv_sign.setText(data.getCtime());
        PictureUtil.showImage(mImg_face,getContext(),data.getPicUrl());
    }
}
