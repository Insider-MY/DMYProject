package com.lyd.newsstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPage extends ViewPager {

    private boolean enabled ;


    /**
     * 代码调用的构造函数
     * @param context  上下文
     */
    public NoScrollViewPage(@NonNull Context context) {
        super(context);
        enabled =false ;
    }

    /**
     * 布局(xml)中引用的构造函数
     * @param context  上下文
     * @param attrs 属性
     */
    public NoScrollViewPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        enabled =false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //如果enabled为true,继续消费,否则停止
        if (enabled){
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //如果enabled为true,继续拦截,否则停止
        if (enabled){
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    /**
     * 设置分页启动
     * @param enabled 启动标志(true启动,false 关闭)
     */
    public void setPagingEnabled(boolean enabled){
        this.enabled =enabled ;
    }
}
