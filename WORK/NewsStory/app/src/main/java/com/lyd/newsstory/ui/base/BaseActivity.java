package com.lyd.newsstory.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {
    String TAG =getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.e(TAG,TAG+"创建");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,TAG+"销毁");

    }
}
