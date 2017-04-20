package com.example.syl.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 测试Layout布局
 */
public class TestLayoutActivity extends AppCompatActivity {

    @BindView(R.id.image1)
    SimpleDraweeView mImage1;

    @BindView(R.id.image2)
    SimpleDraweeView mImage2;

    @BindView(R.id.image3)
    SimpleDraweeView mImage3;

    @BindView(R.id.image4)
    SimpleDraweeView mImage4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        ButterKnife.bind(this);

        final String url = "http://m.qiyipic.com/common/lego/20170419/f5f80a82c75742299212e6efa14b768a.jpg";
        mImage1.setImageURI(Uri.parse(url));
        mImage2.setImageURI(Uri.parse(url));
        mImage3.setImageURI(Uri.parse(url));
        mImage4.setImageURI(Uri.parse(url));
    }
}
