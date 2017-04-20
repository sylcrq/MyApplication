package com.example.syl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 测试WebView打开sdcard上的html文件
 */
public class TestWebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebView;

    @OnClick(R.id.webview)
    void loadHtml() {
        mWebView.loadUrl("file:///sdcard/index.html");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_view);
    }
}
