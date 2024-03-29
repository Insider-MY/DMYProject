package com.lyd.newsstory.util;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

public class NetWorkUtil {
    /**
     * 检测网络是否连接
     * @return
     */
    public static boolean checkNetworkState(Context context){
        boolean flag =false;
        //得到网络连接信息
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null){
            flag = manager.getActiveNetworkInfo().isAvailable();
            Log.i("@@@-->", "checkNetworkState: flag ="+flag);
        }
        if (!flag){
            setNetwork(context);
        }else {
            //isNetworkAvailable(manager);
        }
        return flag;
    }

    /**
     * 网络未连接时，调用设置方法
     */
    public static void setNetwork(final Context context){
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle("网络提示信息");
        builder.setMessage("网络不可用，如果继续，请先设置网络！");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =null;
                /**
                 * 判断手机系统的版本！如果API大于10 就是3.0+
                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
                 */
                if (Build.VERSION.SDK_INT > 10){
                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                }else {
                    intent =new Intent();
                    ComponentName componentName =new ComponentName(
                            "com.android.settings",
                            "com.android.settings.WirelessSettings");
                    intent.setComponent(componentName);
                    intent.setAction("android.intent.action.VIEW");
                }
                context.startActivity(intent);
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
    /**
     * 网络已经连接，然后去判断是wifi连接还是GPRS连接
     * 设置一些自己的逻辑调用
     */
    public static  void isNetworkAvailable(ConnectivityManager manager){
        NetworkInfo.State gprs =manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();

        if (gprs == NetworkInfo.State.CONNECTED || gprs == NetworkInfo.State.CONNECTING){
            //....
        }
        //判断为wifi状态下才加载广告，如果是GPRS手机网络则不加载！
        if(wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING){

        }
    }

}
