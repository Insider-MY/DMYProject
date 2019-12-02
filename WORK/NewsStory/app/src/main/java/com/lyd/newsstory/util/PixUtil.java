package com.lyd.newsstory.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PixUtil {

    public static float convertDpToPixel(float dp, Context context){
        Resources resource =context.getResources();
        DisplayMetrics metrics =resource.getDisplayMetrics();
        float px = dp*(metrics.densityDpi /160f);
        return px;

    }
}
