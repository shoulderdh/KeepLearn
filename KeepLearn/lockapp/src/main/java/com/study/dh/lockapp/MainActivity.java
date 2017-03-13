package com.study.dh.lockapp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.study.dh.lockapp.activity.SecondActivity;
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
    @Bind(R.id.sendMsg_btn)
    Button  sendMsg_btn;
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
        sendMsg_btn.setOnClickListener(this);





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
            case R.id.sendMsg_btn:
                Intent  intent1=new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent1,1);



                break;
            }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    Log.i("buy",data.getStringExtra("data_return"));
                      Toast.makeText(MainActivity.this, data.getStringExtra("data_return"),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
