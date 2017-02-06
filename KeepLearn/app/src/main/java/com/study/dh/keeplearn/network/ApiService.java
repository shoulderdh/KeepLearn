package com.study.dh.keeplearn.network;


import okhttp3.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static android.R.attr.path;

/**
 * Created by Administrator on 2016/10/23.
 */

public interface ApiService {
    @GET("social/")
    Observable <String> getString(@Query("key") String key, @Query("num") String num, @Query("page") int page);

//    @GET("social/")
//    Observable <NewsGson> getNewsData(@Query("key") String key, @Query("num") String num, @Query("page") int page);


    //图片 路径获取
    @GET("api/data/福利/10/{page}")
    retrofit2.Call<PicInformationGson> getPictureData(@Path("page") int page);

    @GET("/4/start-image/1080*1776")
    retrofit2.Call<String> getSplashPic();
}
