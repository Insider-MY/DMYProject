package com.lyd.newsstory.ui.pictrues.presenter;

import android.content.Context;

import com.lyd.newsstory.bean.MeiNvGson;
import com.lyd.newsstory.ui.pictrues.contrant.MeiNvContract;
import com.lyd.newsstory.ui.pictrues.model.MeiNvModel;

import java.util.List;

public class MeiNvPresenter implements MeiNvContract.Presenter, MeiNvContract.OnLoadFirstDataListener {
    private MeiNvContract.View view;
    private MeiNvContract.Model model;
    private Context context;

    public MeiNvPresenter(MeiNvContract.View view, Context context) {
        this.view = view;
        this.model = new MeiNvModel();
        this.context =context;
    }



    @Override
    public void loadData(int page) {
        model.loadData(this,page);
    }


    @Override
    public void onSuccess(List<MeiNvGson.NewslistBean> list) {

        view.returnData(list);
    }

    @Override
    public void onFailure(String str, Exception e) {
    }


}
