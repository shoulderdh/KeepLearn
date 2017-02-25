package com.study.dh.keeplearn.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.EntryActivity;
import com.study.dh.keeplearn.R;
import com.study.dh.keeplearn.Util.CompareFile;
import com.study.dh.keeplearn.entry.DownloadFile;
import com.study.dh.keeplearn.entry.UploadFile;
import com.study.dh.keeplearn.network.ApiService;
import com.study.dh.keeplearn.network.UrlManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class SplashActivity extends Activity {
    @Bind(R.id.startimg_iv)
    ImageView startimg_iv;

    private String[]  strings={"http://ww4.sinaimg.cn/large/610dc034gw1fbfwwsjh3zj20u00u00w1.jpg","http://ww3.sinaimg.cn/large/610dc034jw1fbd818kkwjj20u011hjup.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg","http://ww2.sinaimg.cn/large/610dc034jw1fawx09uje2j20u00mh43f.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","http://ww4.sinaimg.cn/large/610dc034gw1fac4t2zhwsj20sg0izahf.jpg"};

    private List<String>  downloadStrings=new ArrayList<>();
    private List<String>  uploadStrings=new ArrayList<>();

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


         getDownloadData();

    }

    private void getDownloadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlManager.localhostdownloadFile)
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器

                .build();
        ApiService apiManager = retrofit.create(ApiService.class);
        apiManager.getDownloadFile().enqueue(new Callback<DownloadFile>() {
            @Override
            public void onResponse(Call<DownloadFile> call, Response<DownloadFile> response) {
                    for (DownloadFile.DigitCodesBean digitCodesBean  : response.body().getDigitCodes()){
                        downloadStrings.add(digitCodesBean.getMealerCode());
                    }
                getUploadData();

            }

            @Override
            public void onFailure(Call<DownloadFile> call, Throwable t) {

            }

        });


//        apiManager.getDownloadFile()
//                .subscribeOn(Schedulers.newThread())
//                .


    }

    private void getUploadData() {

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(UrlManager.localhostdownloadFile)
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .build();
        ApiService apiManager1 = retrofit1.create(ApiService.class);
        apiManager1.getUploadFile().enqueue(new Callback<UploadFile>() {
            @Override
            public void onResponse(Call<UploadFile> call, Response<UploadFile> response) {
                for (UploadFile.MealersBean mealersBean  : response.body().getMealers()){
                    uploadStrings.add(mealersBean.getMealerCode());
                }

                CompareFile compareFile =new CompareFile();
                Log.i("compare",compareFile.CompareFile(uploadStrings,downloadStrings).toString());


            }

            @Override
            public void onFailure(Call<UploadFile> call, Throwable t) {

            }

        });
    }


}
