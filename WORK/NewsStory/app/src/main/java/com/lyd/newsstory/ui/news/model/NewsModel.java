package com.lyd.newsstory.ui.news.model;

import android.util.Log;

import com.lyd.newsstory.bean.NewsGson;
import com.lyd.newsstory.constant.AppConfig;
import com.lyd.newsstory.constant.TypeUrl;
import com.lyd.newsstory.retortfit.ApiService;
import com.lyd.newsstory.retortfit.RetrofitWrapper;
import com.lyd.newsstory.ui.news.contrant.NewsContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class NewsModel implements NewsContract.Model {

    @Override
    public void loadData(int type, final NewsContract.OnLoadFirstDataListener listener, int page) {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService apiService = RetrofitWrapper.getInstance().create(ApiService.class); //采用的是Java的动态代理mos
        apiService.getNewsData(TypeUrl.getTypeUrl(type), AppConfig.APIKEY,"10",page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsGson, List<NewsGson.NewslistBean>>() {
                    @Override
                    public List<NewsGson.NewslistBean> call(NewsGson newsGson) {
                        List<NewsGson.NewslistBean> newslistBeans =new ArrayList<NewsGson.NewslistBean>();
                        for (NewsGson.NewslistBean newslistBean : newsGson.getNewslist()){
                            NewsGson.NewslistBean newslistBean1 =new NewsGson.NewslistBean();
                            newslistBean1.setTitle(newslistBean.getTitle());
                            newslistBean1.setCtime(newslistBean.getCtime());
                            newslistBean1.setDescription(newslistBean.getDescription());
                            newslistBean1.setPicUrl(newslistBean.getPicUrl());
                            newslistBean1.setUrl(newslistBean.getUrl());
                            newslistBeans.add(newslistBean1);
                        }
                        return newslistBeans; //返回类型
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsGson.NewslistBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e( "Error--->" ,e.getMessage());
                        listener.onFailure("请求失败!",e);
                    }

                    @Override
                    public void onNext(List<NewsGson.NewslistBean> list) {
                        listener.onSuccess(list);
                    }
                });
    }
}
