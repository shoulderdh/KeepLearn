package com.study.dh.keeplearn.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.study.dh.keeplearn.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class handlerActivity extends AppCompatActivity  implements View.OnClickListener {
    @Bind(R.id.handler_btn)
    Button handler_btn;
    @Bind(R.id.handlerStop_btn)
    Button  handlerStop_btn;
    @Bind(R.id.handlerMsg_btn)
    Button handlerMsg_btn;

    @Bind(R.id.handler_Probar)
    ProgressBar handler_Probar;

    @Bind(R.id.eventBus_tv)
    TextView eventBus_tv;




    Handler handler=new Handler();
    Runnable update_thread=new Runnable() {
        @Override
        public void run() {
            eventBus_tv.append("\n updateThread...");
            handler.postDelayed(update_thread,1000);

        }
    };



    Handler  update_pb_handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.arg1==90){
                handler_Probar.setProgress(0);
                //update_pb_handler.removeCallbacks(update_pb_runnable);

            }
              handler_Probar.setProgress(msg.arg1);
              update_pb_handler.post(update_pb_runnable);
        }
    };
    Runnable  update_pb_runnable=new Runnable() {
        int i=0;
        @Override
        public void run() {
                i+=10;
            Message  msg=update_pb_handler.obtainMessage();
            msg.arg1=i;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            update_pb_handler.sendMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);

        handler_btn.setOnClickListener(this);
        handlerStop_btn.setOnClickListener(this);
        handlerMsg_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.handler_btn:
                handler.post(update_thread);     //将线程送入线程队列中
                break;
            case R.id.handlerStop_btn:
                handler.removeCallbacks(update_thread);     //将接口从线程队列中移除
                break;
            case R.id.handlerMsg_btn:
                 update_pb_handler.post(update_pb_runnable);
                break;
        }
    }
}
