package com.study.dh.lockapp.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.study.dh.lockapp.MainActivity;
import com.study.dh.lockapp.R;
import com.study.dh.lockapp.application.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dh on 2017/3/11.
 */

public class LockService extends Service {

    private final static  String TAG = "LockService";
    private static long cycleTime = 1000;

    private HandlerThread handler=null;

    private ArrayList<String> lockName = new ArrayList<>();
    private HashMap<String,Boolean> booleanState = MyApplication.getBooleanStates();
    private String status;


    private MyBinder  myBinder=new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() executed");

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("My notification")
                .setContentText("hello world!");

        Intent resultIntent = new Intent(this,MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                this,
                0,
                resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        //设置点击行为，和Notification相关联起来
        mBuilder.setContentIntent(resultPendingIntent);

        //设置ID为001？
        int mNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
       //要在setContentIntent之后完成
        mNotifyMgr.notify(mNotificationId,mBuilder.build());

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         handler=new HandlerThread("count_thread");
        handler.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                  //start   task
            }
        }).start();

        lockName=intent.getStringArrayListExtra("lockListName");

        Log.d(TAG, "onStartCommand() executed");

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return myBinder;
    }

   public class  MyBinder  extends Binder{
          public  void   startDownload(){
            Log.d(TAG, "startDownload() executed");

              new Thread(new Runnable() {
                  @Override
                  public void run() {
                         //start   detail  download  task
                  }
              }).start();
        }

    }

}
