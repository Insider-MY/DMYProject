package com.lyd.newsstory.retortfit;

import android.content.Context;

import com.lyd.newsstory.constant.AppConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitWrapper {
    private static RetrofitWrapper instance;
    private Context mContext;
    private Retrofit retrofit;

    private RetrofitWrapper(){
        //创建Retrofit对象
        retrofit =new Retrofit.Builder().baseUrl(Constant.BASEURL) //定义访问的主机地址
                .addConverterFactory(GsonConverterFactory.create())    //解析方法
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())   //添加RxJAVA 适配器
                .build();
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static RetrofitWrapper getInstance(){
        if (instance == null){
            synchronized (RetrofitWrapper.class){
                if (instance ==null){
                    instance =new RetrofitWrapper();
                }
            }
        }
        return instance;
    }

    public <T> T create(final Class<T> service){
        return retrofit.create(service);
    }

    static class Constant {
        public static  String BASEURL = AppConfig.BASE_URL; //服务器地址
        public static String APIKEY = AppConfig.APIKEY;
    }
}
