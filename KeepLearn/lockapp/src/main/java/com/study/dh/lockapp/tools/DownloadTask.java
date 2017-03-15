package com.study.dh.lockapp.tools;

import android.os.AsyncTask;
import android.os.Environment;

import com.study.dh.lockapp.myinterface.DonwloadListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.string.ok;

/**
 * Created by dh on 2017/3/14.
 */

public class DownloadTask extends AsyncTask<String,Integer,Integer> {

    private static  final  int TYPE_SUCCESS=0;
    private static  final  int TYPE_FAILURE=1;
    private static  final  int TYPE_PAUSE=2;
    private static  final  int TYPE_CANCEL=3;

    private DonwloadListener  donwloadListener;

    private boolean  isCancled=false;
    private boolean  isPaused=false;

    private int lastProgress;

    public DownloadTask(DonwloadListener donwloadListener) {
        this.donwloadListener = donwloadListener;
    }



    @Override
    protected Integer doInBackground(String... strings) {
        InputStream  is=null;
        RandomAccessFile  savedFile=null;
        File  file=null;

        try {
            long downloadLength = 0;
            String downloadUrl = strings[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);
            if (file.exists()) {
                downloadLength = file.length();
            }
            long contentLength = getContentLength(downloadUrl);
            if (contentLength == 0) {
                return TYPE_FAILURE;
            } else if (contentLength == downloadLength) {
                return TYPE_SUCCESS;
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANG", "bytes=" + downloadLength + "-")
                    .url(downloadUrl)
                    .build();
            Response response = client.newCall(request).execute();
            if (request != null) {
                is = response.body().byteStream();
                savedFile = new RandomAccessFile(file, "rw");
                savedFile.seek(downloadLength);
                byte[] b=new byte[1024];
                int total=0;
                int len;
                while ((len=is.read())!=-1){
                     if (isCancled){
                         return TYPE_CANCEL;
                     }else if (isPaused){
                         return TYPE_PAUSE;
                     }else {
                         total+=len;
                         savedFile.write(b,0,len);

                         //计算已下载的百分比
                         int progress= (int) ((total+downloadLength)*100/contentLength);
                         publishProgress(progress);
                     }
                }
                response.body().close();
                return TYPE_SUCCESS;

            }

        }catch (Exception  o){
            o.printStackTrace();
        }finally {
            try {
                  if (is!=null){
                      is.close();
                  }
                if (savedFile!=null){
                    savedFile.close();
                }
                if (isCancled&&file!=null){
                    file.delete();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return TYPE_FAILURE;
    }

    private long getContentLength(String downloadUrl) throws IOException {
          OkHttpClient okHttpClient=new OkHttpClient();
          Request  request=new Request.Builder()
                   .url(downloadUrl)
                  .build();
          Response  response=okHttpClient.newCall(request).execute();
        if (response!=null&&response.isSuccessful()){
            long  contentLength=response.body().contentLength();
               response.body().close();
            return  contentLength;
        }
        return 0;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer){
            case TYPE_SUCCESS:
                donwloadListener.onSuccess();
             //   sendRequestWithHttpUrl();
                break;
            case TYPE_FAILURE:
                donwloadListener.onFailure();
                break;
            case TYPE_PAUSE:
                donwloadListener.onPaused();
                break;
            case TYPE_CANCEL:
                donwloadListener.onCanceled();
                break;


        }
    }

    public interface    HttpCallBackListener{
           void onFinish(String response);
           void onFailure(Exception e);
    }

    private void sendRequestWithHttpUrl(String url, final HttpCallBackListener  listener) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   HttpURLConnection  connection=null;
                   BufferedReader  reader=null;
                   try {
                       URL url=new URL("https://www.baidu.com");
                       connection= (HttpURLConnection) url.openConnection();
                       connection.setRequestMethod("GET");
                       connection.setConnectTimeout(8000);
                       connection.setReadTimeout(8000);
                       InputStream inputStream=connection.getInputStream();

                       //对获取到的输入流楷书读取
                       reader=new BufferedReader(new InputStreamReader(inputStream));
                       StringBuilder  response=new StringBuilder();
                       String line;
                       while ((line=reader.readLine())!=null){
                           response.append(line);
                       }

                       if (listener!=null){
                          listener.onFinish(line);
                       }

                       showResponse(line);


                   }catch (Exception  e){
                       e.printStackTrace();
                       listener.onFailure(e);
                   }finally {
                       if (reader!=null){
                           try {
                               reader.close();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                       if (connection!=null){
                           connection.disconnect();
                       }
                   }


               }
           }).start();

    }

    private void showResponse(String line) {
//        runOnUiThread(new Runnable(){
//            @Override
//            public void run() {
//                 //ui操作，结果显示到界面上
//            }
//        });


    }


    @Override
    protected void onProgressUpdate(Integer... values) {
         //进行UI操作
        int progress=values[0];
        if (progress>lastProgress){
            donwloadListener.onProgress(progress);
            lastProgress=progress;
        }
    }

     public  void pauseDownload(){
         isPaused=true;
     }
    public void cancelDownload(){
        isCancled=true;

    }


}
