package com.study.dh.lockapp.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.study.dh.lockapp.R;
import com.study.dh.lockapp.broadcast.NetworkChangeReceiver;
import com.study.dh.lockapp.tools.ActivityCollector;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SecondActivity extends AppCompatActivity {
    @Bind(R.id.sendMsg_btn) Button sendMsg_btn;

    private NetworkChangeReceiver  networkChangeReceiver;
    private IntentFilter  intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.i("baseactiivty",getClass().getSimpleName());

        if (savedInstanceState!=null){
            String tempdata=savedInstanceState.getString("data_key");
        }


        ButterKnife.bind(this);
        sendMsg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));

            }
        });


        ActivityCollector.addActivity(this);


        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        ActivityCollector.removeActivity(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String  tempData="something you want to save";
        outState.putString("data_key",tempData);

    }
}
