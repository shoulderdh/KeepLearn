package com.study.dh.theyear.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.dh.theyear.R;

/**
 * Created by dh on 2017/4/8.
 */

public class FourthFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  view=inflater.inflate(R.layout.fragment_fourth,container,false);
        return view;

    }
}
