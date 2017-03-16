package com.study.dh.lockapp.myview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.study.dh.lockapp.R;

/**
 * Created by dh on 2017/3/16.
 */

public class MyTitle  extends LinearLayout {

    private TextView  title_tv;

    public MyTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mytitle,this);
        findViewById(R.id.back_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
        findViewById(R.id.setting_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        title_tv= (TextView) findViewById(R.id.title_tv);
    }

    public void setTitle(String titleTxt){
             title_tv.setText(titleTxt);
    }

}
