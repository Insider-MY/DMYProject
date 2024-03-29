package com.lyd.newsstory.ui.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.lyd.newsstory.R;
import com.lyd.newsstory.activity.NewsDetailsActivity;
import com.lyd.newsstory.bean.NewsGson;
import com.lyd.newsstory.ui.base.BaseFragent;
import com.lyd.newsstory.ui.news.adapter.NewsAdapter;
import com.lyd.newsstory.ui.news.contrant.NewsContract;
import com.lyd.newsstory.ui.news.presenter.NewsPresenter;
import com.lyd.newsstory.util.PixUtil;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import static java.security.AccessController.getContext;

public class NewsClassFragment extends BaseFragent implements NewsContract.View {

    private NewsAdapter adapter ;
    private NewsContract.Presenter mPresenter;

    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据
    private int type;


    public static NewsClassFragment newInstance(int type){

        Bundle bundle =new Bundle();
        NewsClassFragment fragment =new NewsClassFragment();
        bundle.putInt("type",type);
        //设置参数
        fragment.setArguments(bundle);
        return fragment;
    }

    //@BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    private int pageIndex = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type =getArguments().getInt("type");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_type , container,false);
        //ButterKnife.bind(this,view);
        recyclerView = view.findViewById(R.id.recyclerView);
        mPresenter =new NewsPresenter(this, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsAdapter(getActivity());
        recyclerView.setAdapter(adapter);


        //添加边框
        SpaceDecoration itemDecoration =new SpaceDecoration((int) PixUtil.convertDpToPixel(8,getContext()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);

        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                Log.e("更多","更多");
                mPresenter.loadData(type,pageIndex);
                pageIndex =pageIndex +1 ;
            }
            @Override
            public void onMoreClick() {
            }
        });

        //写刷新事件
       recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               recyclerView.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       adapter.clear();
                       pageIndex =0;
                       mPresenter.loadData(type,pageIndex);
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
                Intent intent =new Intent(getActivity(), NewsDetailsActivity.class);
                //用Bundle携带数据
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("data",data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        isViewPrepared =true;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void returnData(List<NewsGson.NewslistBean> datas) {
        adapter.addAll(datas);
        Log.e("adapter",adapter.getAllData().size()+"");
    }


    private void lazyFetchDataIfPrepared() {
        Log.e("data",type+""+isViewPrepared+"&&&"+hasFetchData);
        if (isViewPrepared && getUserVisibleHint() && !hasFetchData){
            lazyFetchData();
            hasFetchData = true;
        }
    }

    private void lazyFetchData() {
        mPresenter.loadData(type,pageIndex);
        pageIndex =pageIndex+1;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i("-----<----->", "onResume: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //视图销毁,数据设置为空
        hasFetchData =false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData =false;
        isViewPrepared =false;
    }
}
