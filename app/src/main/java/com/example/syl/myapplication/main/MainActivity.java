package com.example.syl.myapplication.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.syl.myapplication.R;
import com.example.syl.myapplication.demo.GaussianBlurActivity;
import com.example.syl.myapplication.demo.TestAlphaActivity;
import com.example.syl.myapplication.demo.TestDrawableActivity;
import com.example.syl.myapplication.demo.TestLayoutActivity;
import com.example.syl.myapplication.demo.TestServiceActivity;
import com.example.syl.myapplication.demo.TestWebViewActivity;
import com.example.syl.myapplication.demo.RemoteActivity;
import com.example.syl.myapplication.demo.ViewPagerActivity;

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
        mDemoMap.put("测试设置背景alpha", TestAlphaActivity.class);
        mDemoMap.put("测试ViewPager", ViewPagerActivity.class);
        mDemoMap.put("测试高斯模糊", GaussianBlurActivity.class);
        mDemoMap.put("测试Drawable", TestDrawableActivity.class);
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
//        mRecyclerView.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //分割线
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        //Add header
        View header = LayoutInflater.from(this).inflate(R.layout.activity_main_header, mRecyclerView, false);
        mAdapter.setHeaderView(header);

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
//                mRecyclerView.smoothScrollToPosition(2);
//                mRecyclerView.scrollToPosition(2);

//                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
//                    ((LinearLayoutManager) mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(2, 100);
//                }
//                mRecyclerView.scrollBy(0, 200);
            }
        }, 1000);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("shenyunlong", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int xx = mRecyclerView.getChildAt(0).getBottom();
                Log.d("shenyunlong", ">>> onScrolled " + dx + "," + dy + "," + xx);
            }
        });
    }


}
