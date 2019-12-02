package com.lyd.newsstory.constant;

public class TypeUrl {

    public static String getTypeUrl(int type){
        switch (type){
            case 0:
                return "social";
            case 1:
                return "guonei"; //国内
            case 2:
                return "world";//国际
            case 3:
                return "huabian";//娱乐
            case 4:
                return "tiyu";//体育
            case 5:
                return "keji";//科技
            case 6:
                return "health";//健康
                default:
                    return "social";
        }
    }

}
