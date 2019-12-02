package com.lyd.newsstory.ui.news.contrant;

import com.lyd.newsstory.bean.NewsGson;

import java.util.List;

/**
 * 头条默契类
 * MVP 模式
 */
public interface NewsContract {

    interface View{
        void returnData(List<NewsGson.NewslistBean> datas);
    }

    interface OnLoadFirstDataListener{
        void onSuccess(List<NewsGson.NewslistBean> list);
        void  onFailure(String str, Throwable throwable);
    }

    interface Presenter{
        void loadData(int type , int page);
    }

    interface Model{
        void loadData(int type,OnLoadFirstDataListener listener ,int page);
    }
}
