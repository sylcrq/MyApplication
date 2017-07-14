package com.example.syl.myapplication.demo;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.syl.myapplication.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestDrawableActivity extends AppCompatActivity {

    private static final String TAG = "TestDrawableActivity";

    @BindView(R.id.image_1)
    ImageView mImage1;
    @BindView(R.id.image_2)
    ImageView mImage2;
    @BindView(R.id.image_3)
    SimpleDraweeView mImage3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drawable);
        ButterKnife.bind(this);

        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                .path(String.valueOf(R.drawable.movie_poster))
                .build();
        mImage3.setImageURI(uri);
        onNewIntent(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        String action = intent.getAction();
        String data = intent.getDataString();
        Log.d(TAG, "" + data);
    }

    @OnClick(R.id.button)
    public void changeColor() {
        int color = getResources().getColor(R.color.colorAccent);
//        ((GradientDrawable) mImage1.getDrawable()).setColor(color);
        ((GradientDrawable) mImage1.getBackground().mutate()).setColor(color);
//        GradientDrawable drawable = (GradientDrawable) mImage1.getDrawable().getConstantState().newDrawable();
//        drawable.setColor(color);
//        mImage1.setImageDrawable(drawable);
    }
}
