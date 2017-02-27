package com.study.dh.keeplearn.network;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dh on 2017/2/25.
 *
 * OkHttpClient必须是单例的，所以这里我们需要使用到单例设计模式,私有化构造函数，提供一个方法给外界获取OkHttpUtils实例对象
 */

public class OkHttpUtils {

    enum  HttpMethodType{
        GET, POST,
    }

    private static  OkHttpUtils  mInstance;
    private OkHttpClient  mHttpClient;

    public OkHttpUtils() {
    }

    public static OkHttpUtils getmInstance() {
        return mInstance;
    }


    public  void doRequest(final Request  request){
               mHttpClient.newCall(request).equals(new Callback(){
                   @Override
                   public void onFailure(Call call, IOException e) {

                   }

                   @Override
                   public void onResponse(Call call, Response response) throws IOException {

                   }
               });
    }
     public  class   BaseCallback{
            //   public abstract  void onBeforeRequest(Request  request);
        // public abstract  void onFailure(Request request, Exception e) ;


         /**
          *请求成功时调用此方法
          * @param response
          */
   //      public abstract  void onResponse(Response response);
     }

    public  void get(String url,BaseCallback  baseCallback){
         Request  request=buildRequest(url,HttpMethodType.GET,null);
          doRequest(request);

    }
    public  void  post(String url , Map< String,Object >  param){
             Request  request=buildRequest(url,HttpMethodType.POST,param);
       //      doRequest(request,callback);



    }
    private  Request buildRequest(String url,HttpMethodType methodType,Map<String,Object> params){

        Request.Builder builder = new Request.Builder()
                .url(url);

        if (methodType == HttpMethodType.POST){

            RequestBody body = builderFormData(params);

            builder.post(body);
        }
        else if(methodType == HttpMethodType.GET){



            builder.get();
        }


        return builder.build();

    }

    private RequestBody builderFormData(Map<String,Object> params){
        FormBody.Builder builder =  new FormBody.Builder();

        if(params!=null){
            for(Map.Entry<String,Object> entry:params.entrySet()){
                builder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return builder.build();
    }
}
