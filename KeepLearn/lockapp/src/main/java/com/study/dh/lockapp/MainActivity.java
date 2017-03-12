package com.study.dh.lockapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.study.dh.lockapp.service.LockService;
import com.study.dh.lockapp.tools.LockUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.pwd_et)
    EditText   pwd_et;

    @Bind(R.id.startService_btn)
    Button  startService_btn;
    @Bind(R.id.stopService_btn)
    Button  stopService_btn;
    @Bind(R.id.bindService_btn)
    Button  bindService_btn;
    @Bind(R.id.unbindService_btn)
    Button  unbindService_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LockUtils  lockUtils=new LockUtils();
        Log.i("names",lockUtils.getHomes(this).toString());


        startService_btn.setOnClickListener(this);
        stopService_btn.setOnClickListener(this);
        bindService_btn.setOnClickListener(this);
        unbindService_btn.setOnClickListener(this);


    }

    private LockService.MyBinder  myBinder;
    private ServiceConnection   connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                      myBinder= (LockService.MyBinder) iBinder;
                      myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onClick(View view) {
        Intent  intent=new Intent(this, LockService.class);
        switch (view.getId()){
                case R.id.startService_btn:
                    startService(intent);
                    break;
                case R.id.stopService_btn:
                    stopService(intent);
                    break;
                case R.id.bindService_btn:
                    bindService(intent,connection,BIND_AUTO_CREATE);
                    break;
                case R.id.unbindService_btn:
                    unbindService(connection);
                    break;
            }
    }
}
