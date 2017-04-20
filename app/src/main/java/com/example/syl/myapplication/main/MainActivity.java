package com.example.syl.myapplication.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.syl.myapplication.R;
import com.example.syl.myapplication.TestLayoutActivity;
import com.example.syl.myapplication.TestServiceActivity;
import com.example.syl.myapplication.TestWebViewActivity;
import com.example.syl.myapplication.demo.RemoteActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 各种Example测试入口Activity
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private MainAdapter mAdapter;
    private List<MainItem> mExamples = new ArrayList<>();
    private HashMap<String, Class> mDemoMap = new HashMap<>();

    private void initMap() {
        mDemoMap.put("测试WebView打开sdcard上的html文件", TestWebViewActivity.class);
        mDemoMap.put("测试Service", TestServiceActivity.class);
        mDemoMap.put("运行在独立进程中的Activity", RemoteActivity.class);
        mDemoMap.put("测试Layout布局", TestLayoutActivity.class);
        //Add New Demo Here !
    }

    private void initExamples() {
        for (Map.Entry<String, Class> entry : mDemoMap.entrySet()) {
            String title = entry.getKey();
            Class clazz = entry.getValue();
            MainItem demo = new MainItem(title, clazz);
            mExamples.add(demo);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initMap();
        initExamples();

        mAdapter = new MainAdapter(this, mExamples);
        mAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Context context = MainActivity.this;
                Toast.makeText(context, "click + " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, mExamples.get(position).mClazz);
                context.startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
