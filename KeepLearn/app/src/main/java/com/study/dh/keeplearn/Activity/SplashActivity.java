package com.study.dh.keeplearn.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.EntryActivity;
import com.study.dh.keeplearn.R;


import butterknife.Bind;
import butterknife.ButterKnife;


public class SplashActivity extends Activity {
    @Bind(R.id.startimg_iv)
    ImageView startimg_iv;

    private String  imgurl="http://pic3.zhimg.com/da1fcaf6a02d1223d130d5b106e828b9.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, EntryActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);     //去掉跳转动画实现视觉无缝隙
                finish();
            }
        },1500);

        Picasso.with(SplashActivity.this) .load(imgurl)
                .into(startimg_iv);

    }

}
