package com.example.syl.myapplication.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.syl.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 运行在独立进程中的Activity
 */
public class RemoteActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button2)
    Button mButton2;

    @OnClick(R.id.button)
    void startService() {
        Intent intent = new Intent(this, TransService.class);
        intent.putExtra("key", "hello world");
        this.startService(intent);
    }

    @OnClick(R.id.button2)
    void startIntentService() {
        MyIntentService.startActionFoo(this, "hello", "service");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        ButterKnife.bind(this);
    }
}
