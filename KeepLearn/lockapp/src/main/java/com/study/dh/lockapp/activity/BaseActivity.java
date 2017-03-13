package com.study.dh.lockapp.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.study.dh.lockapp.tools.ActivityCollector;

/**
 * Created by dh on 2017/3/14.
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver  forceOfflineReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter  intentFilter=new IntentFilter();
        intentFilter.addAction("com.dh.lockapp.forceofflinebroadcast");
        forceOfflineReceiver=new ForceOfflineReceiver();
        registerReceiver(forceOfflineReceiver,intentFilter);


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (forceOfflineReceiver!=null){
            unregisterReceiver(forceOfflineReceiver);
            forceOfflineReceiver=null;
        }
    }

    class   ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("warmming")
                    .setMessage("强制下线，重新登陆")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCollector.finishAll();    //结束掉所有活动，并跳转至登陆界面
                            Intent  intent1=new Intent(context,LoginActivity.class);
                            startActivity(intent1);
                        }
                    })
                    .setCancelable(false);
            builder.show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
