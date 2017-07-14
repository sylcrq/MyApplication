package com.example.syl.myapplication;

import android.app.Application;

import com.example.syl.myapplication.utils.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;

/**
 * Created by Shen YunLong on 2017/04/20.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        Stetho.initializeWithDefaults(this);
        UIUtils.init(this);
    }
}
