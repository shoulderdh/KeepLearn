package com.study.dh.lockapp.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Toast;

import com.study.dh.lockapp.R;

public class ThirdActivity extends BaseActivity {
    private IntentFilter  intentFilter;
    private LocalReceiver  localReceiver;
    private LocalBroadcastManager  localBroadcastManager;

    class  LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"local broadcast",Toast.LENGTH_SHORT).show();

        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        localBroadcastManager= LocalBroadcastManager.getInstance(this);

        findViewById(R.id.sendbroadcast_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent("com.dh.lockapp.MyBroadcastReceiver");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        intentFilter=new IntentFilter();
        intentFilter.addAction("com.dh.lockapp.MyBroadcastReceiver");
        localReceiver=new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);


        findViewById(R.id.forceoffline_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent  intent=new Intent("com.dh.lockapp.forceofflinebroadcast");
                    sendBroadcast(intent);
            }
        });
    }
}
