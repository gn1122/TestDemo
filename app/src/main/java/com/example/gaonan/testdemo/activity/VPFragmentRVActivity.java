package com.example.gaonan.testdemo.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gaonan.testdemo.R;
import com.example.gaonan.testdemo.adapter.MyAdapter;
import com.example.gaonan.testdemo.fragment.MyFragment;

import java.util.ArrayList;

public class VPFragmentRVActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView[] tvTitles;
    private MyFragment fragment1;
    private MyFragment fragment2;
    private MyFragment fragment3;
    private ArrayList<Fragment> fragments;
    private TextView[] tvIndicateLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpfragment_rv);
        initVariable();
        initView();
        initEvent();
    }


    /**
     * 初始化变量
     */
    private void initVariable() {
        tvTitles = new TextView[3];
        tvIndicateLine = new TextView[3];
        fragment1 = new MyFragment().instance("No.1: fragment_1");
        fragment2 = new MyFragment().instance("No.2: fragment_2");
        fragment3 = new MyFragment().instance("No.3: fragment_3");
    }


    /**
     * 初始化界面
     */
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        initTabView();
        initViewPager();
        initIndicateLine();

    }

    /**
     * 初始化指示器
     */
    private void initIndicateLine() {
        LinearLayout llIndicate
                = findViewById(R.id.ll_indicate_con);
        for (int i = 0; i < tvTitles.length; i++) {
            TextView textView = (TextView) llIndicate.getChildAt(i);
            tvIndicateLine[i] = textView;
            tvIndicateLine[i].setEnabled(true);
            tvIndicateLine[i].setBackgroundColor(Color.BLACK);
            tvIndicateLine[i].setTag(i);
            tvIndicateLine[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem((Integer) v.getTag());
                }
            });
        }
        //默认选中第一个
        tvIndicateLine[0].setEnabled(false);
        tvIndicateLine[0].setBackgroundColor(Color.BLUE);
    }

    /**
     * 初始化事件
     */
    private void initEvent() {

    }

    /**
     * 初始化tab
     */
    private void initTabView() {
        LinearLayout llTitlesCon = (LinearLayout) findViewById(R.id.ll_titles_con);
        for (int i = 0; i < tvTitles.length; i++) {
            TextView textView = (TextView) llTitlesCon.getChildAt(i);
            tvTitles[i] = textView;
            tvTitles[i].setEnabled(true);
            tvTitles[i].setTextColor(Color.BLACK);
            tvTitles[i].setTag(i);
            tvTitles[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem((Integer) v.getTag());
                }
            });
        }
        //默认选中第一个
        tvTitles[0].setEnabled(false);
        tvTitles[0].setTextColor(Color.BLUE);

    }


    /**
     *
     */
    private void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < tvTitles.length; i++) {
                    tvTitles[i].setEnabled(true);
                    tvTitles[i].setTextColor(Color.BLACK);
                    tvIndicateLine[i].setBackgroundColor(Color.BLACK);
                }
                tvTitles[position].setEnabled(false);
                tvTitles[position].setTextColor(Color.BLUE);
                tvIndicateLine[position].setBackgroundColor(Color.BLUE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);
    }
}
