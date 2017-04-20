package com.example.syl.myapplication;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.syl.myapplication.ipc.IMyService;
import com.example.syl.myapplication.ipc.Student;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TestServiceActivity extends AppCompatActivity {

    @BindView(R.id.bind_remote_service)
    Button mBindBtn;

    private IMyService mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IMyService.Stub.asInterface(service);
            try {
                List<Student> xx = mService.getStudents();
                Log.d("MyService", xx.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };


    @OnClick(R.id.bind_remote_service)
    void bindRemoteService() {
//        TestServiceActivity.this.bindService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
    }

}
