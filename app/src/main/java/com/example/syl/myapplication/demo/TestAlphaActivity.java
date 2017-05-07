package com.example.syl.myapplication.demo;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.syl.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * {@link ColorDrawable#setAlpha(int)} 是基于当前颜色的alpha值进行计算的，
 * 所以如果在布局文件中设置透明度为00，再通过setAlpha更新则无效
 */
public class TestAlphaActivity extends AppCompatActivity {

    @BindView(R.id.layout1)
    RelativeLayout mLayout1;

    @BindView(R.id.layout2)
    RelativeLayout mLayout2;

    @BindView(R.id.button1)
    Button mPlusButton;

    @BindView(R.id.button2)
    Button mMinusButton;

    private int mAlpha = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_alpha);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void plus() {
        mAlpha += 50;
        if (mAlpha >= 255) {
            mAlpha = 255;
        }
        mLayout1.getBackground().mutate().setAlpha(mAlpha);
//        mLayout2.getBackground().mutate().setAlpha(mAlpha);
        setAlpha(mLayout2, mAlpha);
    }

    @OnClick(R.id.button2)
    public void minus() {
        mAlpha -= 50;
        if (mAlpha <= 0) {
            mAlpha = 0;
        }
        mLayout1.getBackground().mutate().setAlpha(mAlpha);
//        mLayout2.getBackground().mutate().setAlpha(mAlpha);
        setAlpha(mLayout2, mAlpha);
    }

    private void setAlpha(View view, int alpha) {
        //make sure alpha 0-255
        Drawable drawable = view.getBackground();
        if (drawable instanceof ColorDrawable) {
            int baseColor = ((ColorDrawable) drawable).getColor();
            int color = (baseColor << 8 >>> 8) | (alpha << 24);//clear top 8 bit
            view.setBackgroundColor(color);
        }
    }

}
