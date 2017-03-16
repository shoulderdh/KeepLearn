package com.study.dh.lockapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.dh.lockapp.R;

/**
 * Created by dh on 2017/3/16.
 */

public class NewsContentFragment  extends Fragment {
    private View  view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refresh(String  title,String content){
          View visiblity_layout=view.findViewById(R.id.visiblity_layout);
        visiblity_layout.setVisibility(View.VISIBLE);
        TextView  newsTitle_tv= (TextView) view.findViewById(R.id.newsTitle_tv);
        TextView  newsContent_tv= (TextView) view.findViewById(R.id.newsContent_tv);
        newsTitle_tv.setText(title);
        newsContent_tv.setText(content);

    }

}
