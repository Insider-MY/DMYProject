package com.lyd.newsstory.ui.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.lyd.newsstory.R;
import com.lyd.newsstory.activity.PictureDescribeActivity;
import com.lyd.newsstory.bean.MeiNvGson;
import com.lyd.newsstory.ui.base.BaseFragent;
import com.lyd.newsstory.ui.pictrues.adapter.ImageAdapter;
import com.lyd.newsstory.ui.pictrues.contrant.MeiNvContract;
import com.lyd.newsstory.ui.pictrues.presenter.MeiNvPresenter;
import com.lyd.newsstory.util.PixUtil;

import java.util.ArrayList;
import java.util.List;

public class MeiNvFragment extends BaseFragent implements MeiNvContract.View {

    private ImageAdapter adapter;
    private int page =1;
    private MeiNvPresenter mMeiNvPresenter;
    private boolean isViewPrepared; //标识fragment视图已经初始化完毕
    private boolean hasFetchData; //标识已经触发过懒加载数据
    private EasyRecyclerView recyclerView;

    public static MeiNvFragment newInstance(){
        MeiNvFragment fragment =new MeiNvFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.meinv_fragemt,container,false);
        recyclerView =view.findViewById(R.id.recyclerView);
        mMeiNvPresenter =new MeiNvPresenter(this,getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)); //垂直分布
        recyclerView.setAdapter(adapter = new ImageAdapter(getActivity()));

        //添加边框
        SpaceDecoration itemDecoration = new SpaceDecoration((int) PixUtil.convertDpToPixel(10, getContext()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);

        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                Log.e("更多","更多");
                mMeiNvPresenter.loadData(page);
                page=page+1;
            }

            @Override
            public void onMoreClick() {

            }
        });
        adapter.setNoMore(R.layout.view_nomore);

        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page =1;
                        adapter.clear();
                        Log.e("刷新", "刷新");
                        mMeiNvPresenter.loadData(page);
                    }
                },1000);
            }
        });

        //点击事件
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> data =new ArrayList<>();
                data.add(adapter.getAllData().get(position).getPicUrl());
                data.add(adapter.getAllData().get(position).getUrl());
                Intent intent =new Intent(getActivity(), PictureDescribeActivity.class);
                //用Bundle携带数据
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        isViewPrepared = true;
        return view;
    }
    @Override
    public void returnData(List<MeiNvGson.NewslistBean> datas) {
        adapter.addAll(datas);
    }

    public void onResume() {
        super.onResume();
    }

    private void lazyFetchDataIfPrepared() {
        if (isViewPrepared && getUserVisibleHint() && !hasFetchData) {
            lazyFetchData();
            hasFetchData = true;
        }
    }

    protected void lazyFetchData() {
        mMeiNvPresenter.loadData(page);
        page=page+1;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //视图销毁 数据设置为空
        hasFetchData=false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData = false;
        isViewPrepared = false;
    }
}
