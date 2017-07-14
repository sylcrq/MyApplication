package com.example.syl.myapplication.utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Shen YunLong on 2017/07/13.
 */
public class UIUtils {

    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    /**
     * dip转px值
     */
    public static int dip2px(float dipValue) {
        float scale;
        if (sContext != null) {
            scale = sContext.getResources().getDisplayMetrics().density;
        } else {
            scale = Resources.getSystem().getDisplayMetrics().density;
        }

        return (int) (dipValue * scale + 0.5f);
    }

}
