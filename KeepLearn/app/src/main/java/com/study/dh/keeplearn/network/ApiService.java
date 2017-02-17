package com.study.dh.keeplearn.network;


import com.study.dh.keeplearn.entry.DownloadFile;
import com.study.dh.keeplearn.entry.UploadFile;
import com.study.dh.keeplearn.zhihuDaily.adapter.TitleInfoGson;

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
    /*
        方法一：

        1.完整路径： http://op.juhe.cn/onebox/weather/query?cityname=深圳&key=您申请的KEY
        2.retrofit基本路径：    .baseUrl("http://op.juhe.cn/")
        3.接口中拼接写法：   关键字Query
        @GET("onebox/weather/query?cityname=深圳")
        Call<WeatherDataBean> getWeather(@Query("key") String key);

        方法二：
         @GET("onebox/weather/query?")
         Call<WeatherDataBean> getWeather(@QueryMap Map<String, String> params);

         使用时：
         Map<String, String> params = new HashMap<>();
         params.put("cityname", "深圳");
         params.put("key", "4ea58de8a7573377cec0046f5e2469d5");
         api.getWeather(params).

     */

    //图片 路径获取   此处不需要key之类的名字，直接传参数 ，使用关键字 path    http://gank.io/api/data/Android/10/1
    @GET("api/data/福利/10/{page}")
    retrofit2.Call<PicInformationGson> getPictureData(@Path("page") int page);

    //   http://news-at.zhihu.com/api/4/news/latest
    // http://news-at.zhihu.com/api
    @GET("4/news/latest")
    retrofit2.Call<TitleInfoGson> getTitleInfo();

    @GET("downloadFile")
    retrofit2.Call<DownloadFile> getDownloadFile();

    @GET("uploadFile")
    retrofit2.Call<UploadFile> getUploadFile();

}
