package com.study.dh.theyear.application;

import android.app.Application;
import android.content.Context;
import android.os.Parcelable;
import android.widget.Toast;

import com.txznet.sdk.TXZConfigManager;

import java.io.Serializable;

/**
 * Created by dh on 2017/3/21.
 */

public class MyApplication extends Application {

    private static Context context;

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
    }

    public static Context getContext() {
        return context;
    }

}
