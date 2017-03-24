package com.study.dh.theyear.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.study.dh.theyear.application.MyApplication;

/**
 * Created by dh on 2017/3/21.
 */

public class LongRunningService  extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                  //执行具体逻辑

            }
        }).start();

        AlarmManager manager= (AlarmManager) getSystemService(MyApplication.getContext().ALARM_SERVICE);
        int anhour=60*60*1000;
        long triggerAtTime= SystemClock.elapsedRealtime()+anhour;
        Intent  intent1=new Intent(this,LongRunningService.class);
        PendingIntent  pi=PendingIntent.getService(this,0,intent1,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
