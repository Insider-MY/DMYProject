package com.lyd.newsstory.ui.pictrues.adapter;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lyd.newsstory.bean.MeiNvGson;

import static java.security.AccessController.getContext;

public class ImageViewHolder extends BaseViewHolder<MeiNvGson.NewslistBean> {
    ImageView imgPicture;

    public ImageViewHolder(ViewGroup parent) {
        super(new ImageView(parent.getContext()));
        imgPicture = (ImageView) itemView;
        imgPicture.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void setData(MeiNvGson.NewslistBean data) {
        final DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
        Glide.with(getContext())
                .load(data.getPicUrl())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                          @Override
                          public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                              int width = dm.widthPixels / 3 - 6;//宽度为屏幕宽度一半
                              int height = bitmap.getHeight() * width / bitmap.getWidth();//计算View的高度
                              //获取bitmap信息，可赋值给外部变量操作，也可在此时行操作。
                              ViewGroup.LayoutParams params = imgPicture.getLayoutParams();
                              params.height = height;
                              params.width = width;
                              imgPicture.setLayoutParams(params);
                              // imgPicture.setScaleType(ImageView.ScaleType.FIT_XY);
                              imgPicture.setImageBitmap(bitmap);

                          }
                      }
                );
    }
}
