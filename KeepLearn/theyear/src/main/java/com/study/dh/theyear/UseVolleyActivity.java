package com.study.dh.theyear;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.study.dh.theyear.application.MyApplication;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class UseVolleyActivity extends AppCompatActivity {
    public ProgressBar progressBar = null;
    public int time = 0;

    private BluetoothAdapter  mbluetoothAdapter;
    private static final int  REQUEST_TAG=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_volley);

        findViewById(R.id.startDownload_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (time<100){
                            time += 15;
                            EventBus.getDefault().post(new TestEvent(time));
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        EventBus.getDefault().register(this);

         //获取本地蓝牙适配器
        mbluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        //判断蓝牙功能是否存在
        if(mbluetoothAdapter==null){
            showToast("该设备不支持蓝牙");
            return;
        }

        findViewById(R.id.openBluetooth_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //判断是否打开蓝牙了
                if(mbluetoothAdapter.isEnabled()){
                        showToast("蓝牙已经打开");
                }else {

                    //  boolean isOpen=mbluetoothAdapter.enable();    //强制打开
                    Intent open=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(open,REQUEST_TAG);
                     // showToast("蓝牙状态："+isOpen);
                }
            }
        });

  Log.i("i=",   test()+"??/");


    }
    int test() {
        int i = 1;
        try {
            return ++i;
        } finally {
            System.out.println("finally is executed...");
            return ++i;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_TAG){
              if (resultCode==RESULT_CANCELED){
                  showToast("请求失败");
              }else {
                  showToast("请求成功"+mbluetoothAdapter.getAddress()+"///"+mbluetoothAdapter.getName());

              }
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TestEvent event){
        progressBar.setProgress(event.getMsg());
    }

    /**
     * Request.Method.GET 指定请求方法，如果不输入，默认为Get方法
     *  new Response.Listener <String> 请求成功回调接口
     *   new Response.ErrorListener() 请求失败回到接口
     * @param url 要请求的网址
     */
    private void sendRequest(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //这里得到我们请求成功的结果
                Log.d("TAG", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //这里得到我们请求请求失败的信息
                Log.e("TAG", error.getMessage());
            }
        });
        //将stringRequest添加到RequestQueue中
        MyApplication.getVolleyRequestQueue().add(stringRequest);
    }
}
