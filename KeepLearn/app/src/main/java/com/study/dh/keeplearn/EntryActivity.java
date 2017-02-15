package com.study.dh.keeplearn;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amitshekhar.utils.Constants;
import com.study.dh.keeplearn.Activity.HandleDbActivity;
import com.study.dh.keeplearn.eventBus.MainEvent;
import com.study.dh.keeplearn.zhihuDaily.zhihuDailyActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener{
     @Bind(R.id.lookPic_btn)
    Button  lookPic_btn;
    @Bind(R.id.handleDB_btn)
    Button  handleDB_btn;
    @Bind(R.id.zhihuDaily_btn)
    Button zhihuDaily_btn;
    @Bind(R.id.eventBus_btn)
    Button  eventBus_btn;

    @Bind(R.id.eventBus_tv)
    TextView  eventBus_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);   //eventBus  注册


        lookPic_btn.setOnClickListener(this);
        handleDB_btn.setOnClickListener(this);
        zhihuDaily_btn.setOnClickListener(this);

        callPhone();

    }

    private void callPhone() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        }else {
            doCallPhone();
        }


    }

    private void doCallPhone() {
        Intent  intent=new Intent(Intent.ACTION_CALL);
        Uri data=Uri.parse("tel:"+"10010");
        intent.setData(data);
        startActivity(intent);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else {
                    //提示用户权限未被授予

                }
                break;
        }
    }

    /**
     * 事件响应方法
     * 接收消息
     * @param event
     */

    /*
    ThreadMode.MAIN
    表示无论事件是在哪个线程发布出来的，该事件订阅方法onEvent都会在UI线程中执行，这个在Android中是非常有用的，
    因为在Android中只能在UI线程中更新UI，所有在此模式下的方法是不能执行耗时操作的。
     */
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 100)     //priority越大  优先级越高  越先接收事件
    public  void  onMainEvent(MainEvent event){
         String msg=event.getMessage();
         eventBus_tv.setText(msg);
        Log.i("MainEvent",event.getMessage());
    }


    /*
    ThreadMode.AYSNC：使用这个模式的订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程来执行订阅函数。
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public  void  onAsyncEvent(MainEvent event){
        Log.i("onAsyncEvent",event.getMessage());

    }


    /*
    ThreadMode.BACKGROUND：表示如果事件在UI线程中发布出来的，那么订阅函数onEvent就会在子线程中运行，
    如果事件本来就是在子线程中发布出来的，那么订阅函数直接在该子线程中执行。
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void  onBackgroundEvent(MainEvent event){
        Log.i("onBackgroundEvent",event.getMessage());

    }



    /*
    ThreadMode.POSTING：表示事件在哪个线程中发布出来的，事件订阅函数onEvent就会在这个线程中运行，也就是说发布事件和接收事件在同一个线程。
    使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
     public  void  onPostingEvent(MainEvent event){
        Log.i("onPostingEvent",event.getMessage());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.lookPic_btn:
                  startActivity(new Intent(EntryActivity.this,MainActivity.class));
                  break;
              case R.id.handleDB_btn:
                  startActivity(new Intent(EntryActivity.this,HandleDbActivity.class));
                  break;
              case R.id.zhihuDaily_btn:
                  startActivity(new Intent(EntryActivity.this,zhihuDailyActivity.class));
                  break;
              case R.id.eventBus_btn:
                  startActivity(new Intent(EntryActivity.this,HandleDbActivity.class));
                  break;
          }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);     //打开之后，按下返回键回到桌面，再打开，并不会再看到启动页
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     //除非你手动清了该应用，后台或者被系统 kill 了）
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }


}
