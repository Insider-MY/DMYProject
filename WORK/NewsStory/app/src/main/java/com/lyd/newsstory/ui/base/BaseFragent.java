package com.lyd.newsstory.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragent extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        Log.e("NEWS", "ArrayListFragment **** onAttach...");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("NEWS", "ArrayListFragment **** onCreate...");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("NEWS", "ArrayListFragment **** onCreateView...");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("NEWS", "ArrayListFragment **** onActivityCreated...");
    }

    @Override
    public void onStart() {
        Log.e("HJJ", "ArrayListFragment **** onStart...");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("NEWS", "ArrayListFragment **** onResume...");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("NEWS", "ArrayListFragment **** onPause...");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("NEWS", "ArrayListFragment **** onStop...");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("HJJ", "ArrayListFragment **** onDestroyView...");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("NEWS", "ArrayListFragment **** onDestroy...");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("NEWS", "ArrayListFragment **** onDetach...");
        super.onDetach();
    }


}
