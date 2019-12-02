package com.lyd.newsstory.ui.news.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lyd.newsstory.R;
import com.lyd.newsstory.ui.base.BaseFragent;
import com.lyd.newsstory.ui.base.TabPagerAdapter;

import butterknife.ButterKnife;

public class NewsFragment extends BaseFragent implements ViewPager.OnPageChangeListener {

    private Toolbar toolbar;
    private TabLayout mTabs;
    private ViewPager mViewPager;
    private FloatingActionButton fab;

    private String[] mTitles ;
    private NewsClassFragment[] mFragments;
    private TabPagerAdapter mAdapter;
    private int mCurrentPos = 0;

    public static NewsFragment newInstance(){
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.fragment_news,container,false);
        ButterKnife.bind(this,view);
        toolbar =view.findViewById(R.id.toolbar);
        mTabs =view.findViewById(R.id.tab_layout);
        mViewPager =view.findViewById(R.id.viewPager);
        fab = view.findViewById(R.id.fab);
        mTitles =getResources().getStringArray(R.array.main_titles);


        mFragments =new NewsClassFragment[mTitles.length];
        for (int i= 0; i<mFragments.length;i++){
            mFragments[i] =NewsClassFragment.newInstance(i);
        }

        //设置标题模式
        mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        mAdapter =new TabPagerAdapter(getChildFragmentManager(),mFragments);
        mAdapter.setTabTitles(mTitles);
        mViewPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog(getContext());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("是否前去github给个start?");
        builder.setMessage("给作者一个start表示鼓励");
        builder.setPositiveButton("前去", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse("https://github.com/HuRuWo/YiLan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        builder.show();
    }
}
