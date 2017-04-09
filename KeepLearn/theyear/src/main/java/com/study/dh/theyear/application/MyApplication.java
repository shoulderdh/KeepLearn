package com.study.dh.theyear.application;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.txznet.sdk.TXZConfigManager;

/**
 * Created by dh on 2017/3/21.
 */

public class MyApplication extends Application {

    private static Context context;

    public  static RequestQueue  queue;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        TXZConfigManager.getInstance().initialize(this, new TXZConfigManager.InitParam("","")
                        .setWakeupKeywordsNew("haaa")
                        .setTtsType(TXZConfigManager.TtsEngineType.TTS_YUNZHISHENG)
                        .setAsrType(TXZConfigManager.AsrEngineType.ASR_YUNZHISHENG), new TXZConfigManager.InitListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(),"success",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(int i, String s) {
                        Toast.makeText(getContext(),"failure",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        queue= Volley.newRequestQueue(getApplicationContext());
    }

    public static  RequestQueue getVolleyRequestQueue(){
        return queue;
    }

    public static Context getContext() {
        return context;
    }

}
