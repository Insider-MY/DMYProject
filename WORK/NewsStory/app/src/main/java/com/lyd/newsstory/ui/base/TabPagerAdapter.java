package com.lyd.newsstory.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[];
    private Fragment[] fragments;

    public TabPagerAdapter(FragmentManager fm,Fragment[] fragments) {
        super(fm);
        this.fragments =fragments;
    }

    public void setTabTitles(String[] tabTitles) {
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position % fragments.length];
    }

    @Override
    public int getCount() {
        if (fragments == null || fragments.length == 0)
            return 0;
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (tabTitles ==null){
            return "";
        }
        return tabTitles[position];
    }
}
