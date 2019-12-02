package com.lyd.newsstory.ui.pictrues.model;

import com.lyd.newsstory.bean.MeiNvGson;
import com.lyd.newsstory.constant.AppConfig;
import com.lyd.newsstory.retortfit.ApiService;
import com.lyd.newsstory.retortfit.RetrofitWrapper;
import com.lyd.newsstory.ui.pictrues.contrant.MeiNvContract;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MeiNvModel implements MeiNvContract.Model {
    @Override
    public void loadData(final MeiNvContract.OnLoadFirstDataListener listener, int page) {
        ApiService apiManager = RetrofitWrapper.getInstance().create(ApiService.class);//这里采用的是Java的动态代理模式
        apiManager.getPictureData(AppConfig.APIKEY, "6", page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<MeiNvGson, List<MeiNvGson.NewslistBean>>() {
                    @Override
                    public List<MeiNvGson.NewslistBean> call(MeiNvGson meiNvGson) {
                        List<MeiNvGson.NewslistBean> meiNvList = new ArrayList<>();

                        for (MeiNvGson.NewslistBean newslistBean : meiNvGson.getNewslist()) {
                            MeiNvGson.NewslistBean m1 = new MeiNvGson.NewslistBean();
                            m1.setTitle(newslistBean.getTitle());
                            m1.setCtime(newslistBean.getCtime());
                            m1.setDescription(newslistBean.getDescription());
                            m1.setPicUrl(newslistBean.getPicUrl());
                            m1.setUrl(newslistBean.getUrl());
                            meiNvList.add(m1);
                        }
                        return meiNvList; // 返回类型
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MeiNvGson.NewslistBean>>() {
                    @Override
                    public void onNext(List<MeiNvGson.NewslistBean> meiNvList) {
                        listener.onSuccess(meiNvList);
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
