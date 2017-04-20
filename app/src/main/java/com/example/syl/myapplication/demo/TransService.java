package com.example.syl.myapplication.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TransService extends Service {

    public static final String TAG = TransService.class.getSimpleName();

    public TransService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        String value = intent.getStringExtra("key");

        Thread thread = Thread.currentThread();
        Log.d("shenyunlong", thread.getName() + "[" + thread.getId() + "] # " + value);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
