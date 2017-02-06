package com.study.dh.keeplearn.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.MainActivity;
import com.study.dh.keeplearn.R;
import com.study.dh.keeplearn.network.UrlManager;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SplashActivity extends Activity {
    @Bind(R.id.startimg_iv)
    ImageView startimg_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        requestdata();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);     //去掉跳转动画实现视觉无缝隙
                finish();
            }
        },1500);



    }


    private void requestdata() {
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(UrlManager.getSplashUrl(),new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(int i, String s) {
                super.onSuccess(i, s);
                Log.i("sss",s);
                try {
                    JSONObject object=new JSONObject(s);
                    String imgurl=object.getString("img");
                    Picasso.with(SplashActivity.this) .load(imgurl)
                            .into(startimg_iv);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Throwable throwable, String s) {
                super.onFailure(throwable, s);
            }
        });
    }
}
