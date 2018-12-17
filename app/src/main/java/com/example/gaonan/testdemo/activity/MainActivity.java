package com.example.gaonan.testdemo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gaonan.testdemo.R;
import com.example.gaonan.testdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBtnListenter1(new OnClickListener());
    }

    public class OnClickListener {
        public void onClickListenter1() {
            Intent intent = new Intent(MainActivity.this, VPFragmentRVActivity.class);
            startActivity(intent);
        }
    }
}
