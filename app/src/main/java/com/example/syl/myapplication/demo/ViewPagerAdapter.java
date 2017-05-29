package com.example.syl.myapplication.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen YunLong on 2017/05/10.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mFragmentList.add(ViewPagerFragment.newInstance(i));
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d("shen", "instantiateItem#" + position);
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        Log.d("shen", "destroyItem#" + position);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("shen", "getItem#" + position);
//        return ViewPagerFragment.newInstance(position);
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
//        return 5;
        return mFragmentList.size();
    }
}
