package com.study.dh.keeplearn.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.EntryActivity;
import com.study.dh.keeplearn.R;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SplashActivity extends Activity {
    @Bind(R.id.startimg_iv)
    ImageView startimg_iv;

    private String[]  strings={"http://ww4.sinaimg.cn/large/610dc034gw1fbfwwsjh3zj20u00u00w1.jpg","http://ww3.sinaimg.cn/large/610dc034jw1fbd818kkwjj20u011hjup.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg","http://ww2.sinaimg.cn/large/610dc034jw1fawx09uje2j20u00mh43f.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","http://ww4.sinaimg.cn/large/610dc034gw1fac4t2zhwsj20sg0izahf.jpg"};
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

         Random  random=new Random();
         int i=random.nextInt(5);

        Picasso.with(SplashActivity.this) .load(strings[i])
                .into(startimg_iv);

    }

}
