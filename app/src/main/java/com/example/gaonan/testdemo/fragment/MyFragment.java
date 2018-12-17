package com.example.gaonan.testdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaonan.testdemo.R;

/**
 * Description:
 * Data：2018/12/17-2:40 PM
 * Author: haiyue
 */
public class MyFragment extends Fragment {
    private String data;
    private String defaultData = "default_value";

    public MyFragment instance(String info) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data_msg", info);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            data = defaultData;
        } else {
            data = arguments.getString("data_msg");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        TextView tvData = (TextView) view.findViewById(R.id.tv_data);
        tvData.setText(data);
        return view;

    }
}
