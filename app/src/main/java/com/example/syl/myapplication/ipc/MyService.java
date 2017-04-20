package com.example.syl.myapplication.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

/**
 * Created by Shen YunLong on 2017/04/10.
 */
public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    private IMyService.Stub mBinder = new IMyService.Stub() {
        @Override
        public List<Student> getStudents() throws RemoteException {
            return null;
        }

        @Override
        public void addStudent(Student student) throws RemoteException {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
