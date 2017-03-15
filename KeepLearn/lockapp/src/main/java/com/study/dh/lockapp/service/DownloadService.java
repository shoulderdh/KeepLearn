package com.study.dh.lockapp.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.study.dh.lockapp.R;
import com.study.dh.lockapp.activity.LoginActivity;
import com.study.dh.lockapp.myinterface.DonwloadListener;
import com.study.dh.lockapp.tools.DownloadTask;

import java.io.File;

/**
 * Created by dh on 2017/3/14.
 */

public class DownloadService extends Service {
    private DownloadTask  downloadTask;
    private String downloadUrl;
    private DonwloadListener  donwloadListener=new DonwloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1,getNotification("下载中……",progress));
        }

        @Override
        public void onSuccess() {
            //下载成功，前台服务关闭，创建一个下载成功的通知
            downloadTask=null;
            stopForeground(true);
            getNotificationManager().notify(1,getNotification("下载成功",-1));
            Toast.makeText(DownloadService.this,"download  success",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure() {
            downloadTask=null;
            stopForeground(true);
            getNotificationManager().notify(1,getNotification("下载失败",-1));
            Toast.makeText(DownloadService.this,"download  failure",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
           downloadTask=null;
            Toast.makeText(DownloadService.this,"download  暂停",Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCanceled() {
            downloadTask=null;
            stopForeground(true);
            Toast.makeText(DownloadService.this,"download  failure",Toast.LENGTH_SHORT).show();
        }
    };
    private DownloadBinder  downloadBinder=new DownloadBinder();

  public   class  DownloadBinder extends Binder{
         public void  startDownload(String url){
             if (downloadTask==null){
                 downloadUrl=url;
                 downloadTask=new DownloadTask(donwloadListener);
                 downloadTask.execute(downloadUrl);
                 startForeground(1,getNotification("开始下载……",0));
                 Toast.makeText(DownloadService.this,"download  start……",Toast.LENGTH_SHORT).show();

             }
         }
        public void pauseDownload(){
            if (downloadTask!=null){
                downloadTask.pauseDownload();
            }
        }

      public void  cancelDownload(){
          if (downloadTask!=null){
              downloadTask.cancelDownload();
          }else {
              if (downloadUrl!=null){
                  //取消下载，文件删除，通知关闭
                  String fileName=downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                  String directory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                  File  file=new File(directory+fileName);
                  if (file.exists()){
                      file.delete();
                  }
                  getNotificationManager().cancel(1);
                  stopForeground(true);
                  Toast.makeText(DownloadService.this,"download  cancel",Toast.LENGTH_SHORT).show();
              }
          }

      }

  }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }


    private NotificationManager getNotificationManager(){
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    private Notification  getNotification(String title,int progress){
         Intent  intent=new Intent(this, LoginActivity.class);
        PendingIntent  pi=PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentIntent(pi);
        builder.setContentTitle(title);
        if (progress>0){
            builder.setContentText(progress+"%");
            builder.setProgress(100,progress,false);
        }
        return builder.build();
    }
}
