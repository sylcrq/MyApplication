package com.example.syl.myapplication.demo;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.syl.myapplication.R;
import com.example.syl.myapplication.view.SkinView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SkinActivity extends AppCompatActivity {

    @BindView(R.id.skin_view)
    SkinView mSkinView;
    @BindView(R.id.search_button)
    RelativeLayout mSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.apply_btn)
    void apply() {
        mSkinView.apply();
        LayerDrawable layer = (LayerDrawable) mSearchBtn.getBackground().mutate();
        GradientDrawable drawable = (GradientDrawable) layer.getDrawable(0).mutate();
//        drawable.setStroke(2, Color.BLACK);
        drawable.setStroke(2, 0x00000000);
    }

    @OnClick(R.id.unapply_btn)
    void unapply() {
        mSkinView.unApply();
//        mSearchBtn.setBackgroundResource(R.drawable.search_button_bg);
        mSearchBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.search_button_bg));
    }
}
