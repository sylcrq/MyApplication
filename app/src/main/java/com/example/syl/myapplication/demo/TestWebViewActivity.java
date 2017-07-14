package com.example.syl.myapplication.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.syl.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 测试WebView打开sdcard上的html文件
 */
public class TestWebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebView;

    void loadHtmlFromAsset() {
//        mWebView.loadUrl("file:///sdcard/index.html");
        mWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_view);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHtmlFromAsset();
    }
}
