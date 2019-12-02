package com.lyd.newsstory.ui.pictrues.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.lyd.newsstory.bean.MeiNvGson;

public class ImageAdapter extends RecyclerArrayAdapter<MeiNvGson.NewslistBean> {

    public ImageAdapter(Context context){
        super(context);

    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(parent);
    }
}
