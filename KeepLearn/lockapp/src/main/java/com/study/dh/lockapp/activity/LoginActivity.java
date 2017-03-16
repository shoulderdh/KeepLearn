package com.study.dh.lockapp.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.study.dh.lockapp.R;
import com.study.dh.lockapp.myview.MyTitle;
import com.study.dh.lockapp.service.DownloadService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class LoginActivity extends BaseActivity {

    private DownloadService.DownloadBinder  downloadBinder;
    private ServiceConnection  connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    downloadBinder= (DownloadService.DownloadBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("failure",componentName.toString()+"//");
        }
    };

    private MyTitle  title_mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        title_mt= (MyTitle) findViewById(R.id.title_mt);
        title_mt.setTitle("登陆界面");

        Intent  intent=new Intent(this,DownloadService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
        Log.i("failure",bindService(intent,connection,BIND_AUTO_CREATE)+"");
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(LoginActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(LoginActivity.this,SecondActivity.class));
            }
        });

        findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (downloadBinder==null){
                    return;
                }
                String  url="http://192.168.1.101:8080/myvoice/lalala.mp3";
                downloadBinder.startDownload(url);

            }
        });



        findViewById(R.id.pause_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadBinder.pauseDownload();
            }
        });

        findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadBinder.cancelDownload();

              //  readContacts();
            }
        });

    }

    private void readContacts() {
        Cursor  cursor=null;
        try {
            cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            if (cursor!=null){
                while (cursor.moveToNext()){
                    String  name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String  phonenumber=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    //listdatas.add(name"/n"+phonenumber);
                }
                //adapter.notifyDataSetChanged();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
               if (cursor!=null){
                   cursor.close();
               }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){

                }

                Toast.makeText(LoginActivity.this,"premission  failure",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
        String a="";
        saveTxt(a);


        getTxt();

      SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name","dh");
        editor.putInt("age",25);
        editor.apply();

        SharedPreferences  sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        String  name=sharedPreferences.getString("name","");
        int age=sharedPreferences.getInt("age",0);

    }

    private String  getTxt() {
        FileInputStream  inputStream=null;
        BufferedReader  reader=null;
        StringBuilder  content=new StringBuilder();
        try {
           inputStream=openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  content.toString();
    }

    private void saveTxt(String a) {
        FileOutputStream  out=null;
        BufferedWriter  writer=null;
        try {
            out=openFileOutput("data", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(a);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
             if (writer!=null){
                 try {
                     writer.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }

    }
}
