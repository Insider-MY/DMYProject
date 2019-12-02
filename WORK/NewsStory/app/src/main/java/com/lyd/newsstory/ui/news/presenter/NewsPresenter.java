package com.lyd.newsstory.ui.news.presenter;

import android.content.Context;

import com.lyd.newsstory.bean.NewsGson;
import com.lyd.newsstory.ui.news.contrant.NewsContract;
import com.lyd.newsstory.ui.news.model.NewsModel;
import com.lyd.newsstory.util.NetWorkUtil;

import java.util.List;

public class NewsPresenter implements NewsContract.Presenter ,NewsContract.OnLoadFirstDataListener {

    private NewsContract.View view;
    private NewsContract.Model model;
    private Context context;

    public NewsPresenter (NewsContract.View view,Context context){
        this.view =view;
        this.model =new NewsModel();
        this.context =context;
    }

    @Override
    public void onSuccess(List<NewsGson.NewslistBean> list) {
        view.returnData(list);
    }

    @Override
    public void onFailure(String str, Throwable throwable) {
        NetWorkUtil.checkNetworkState(context);
    }

    @Override
    public void loadData(int type, int page) {
        model.loadData(type,this,page);
    }
}
