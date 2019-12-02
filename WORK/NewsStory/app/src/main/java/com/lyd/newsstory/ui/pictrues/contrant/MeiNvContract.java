package com.lyd.newsstory.ui.pictrues.contrant;

import com.lyd.newsstory.bean.MeiNvGson;

import java.util.List;

public interface MeiNvContract {
    interface View{
        void returnData(List<MeiNvGson.NewslistBean> datas);
    }

    interface OnLoadFirstDataListener{
        void onSuccess(List<MeiNvGson.NewslistBean> list);
        void onFailure(String str,Exception e);
    }

    interface Presenter{
        void loadData(int page);
    }

    interface Model{
        void loadData(OnLoadFirstDataListener listener ,int page);
    }
}
