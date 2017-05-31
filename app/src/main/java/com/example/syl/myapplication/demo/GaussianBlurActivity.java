package com.example.syl.myapplication.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.syl.myapplication.R;
import com.example.syl.myapplication.utils.ImageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GaussianBlurActivity extends AppCompatActivity {

    @BindView(R.id.blur_image)
    ImageView mImage;
    @BindView(R.id.java_blur_button)
    Button mJavaBlurBtn;
    @BindView(R.id.rs_blur_button)
    Button mRsBlurBtn;
    @BindView(R.id.reset_button)
    Button mResetBtn;

    Bitmap mSrcBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaussian_blur);
        ButterKnife.bind(this);

        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.your_name);
        mImage.setImageBitmap(mSrcBitmap);
    }

    @OnClick(R.id.java_blur_button)
    public void blur() {
        Log.d("shenyunlong", "start Java Blur...");
        long start = System.currentTimeMillis();
        Bitmap bitmap = ImageUtil.fastblur(mSrcBitmap, 1.0f, 30);
        long end = System.currentTimeMillis();
        Log.d("shenyunlong", "Java Blur >>> " + (end - start) + "ms");
        mImage.setImageBitmap(bitmap);
    }

    @OnClick(R.id.rs_blur_button)
    public void blur_rs() {
        Log.d("shenyunlong", "start RenderScript Blur...");
        long start = System.currentTimeMillis();
        Bitmap bitmap = ImageUtil.blur(getApplicationContext(), mSrcBitmap, 20);
        long end = System.currentTimeMillis();
        Log.d("shenyunlong", "RenderScript Blur >>> " + (end - start) + "ms");
        mImage.setImageBitmap(bitmap);
    }

    @OnClick(R.id.reset_button)
    public void reset() {
        mImage.setImageBitmap(mSrcBitmap);
    }
}
