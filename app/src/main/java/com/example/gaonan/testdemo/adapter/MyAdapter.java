package com.example.gaonan.testdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Description:
 * Data：2018/12/17-3:24 PM
 * Author: haiyue
 */
public class MyAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public MyAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
