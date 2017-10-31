package com.example.syl.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.syl.myapplication.R;

/**
 * Created by Shen YunLong on 2017/10/09.
 */
public class SkinView extends RelativeLayout implements ISkinView {

    private TextView mSkinTv;

    public SkinView(Context context) {
        super(context);
        init(context);
    }

    public SkinView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SkinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SkinView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.skin_view_layout, this);
        mSkinTv = (TextView) findViewById(R.id.skin_txt);
    }

    @Override
    public void apply() {
        mSkinTv.setTextColor(Color.BLUE);
    }

    @Override
    public void unApply() {
        mSkinTv.setTextColor(Color.BLACK);
    }
}
