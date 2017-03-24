package com.study.dh.keeplearn.socket;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.study.dh.keeplearn.MainActivity;
import com.study.dh.keeplearn.R;

import java.io.IOException;

public class SocketActivity extends AppCompatActivity {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ChatServer.SERVER_TAG:
                    Bundle bundle = msg.getData();
                    Toast.makeText(SocketActivity.this, bundle.getString(ChatServer.MSG_KEY), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main);
        launchServer();
        launchClient();
    }

    private void launchServer() {
        //启动服务器端
        try {
            ChatServer
                    chatServer = new ChatServer(handler);
            chatServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动客户端
     */
    private void launchClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ChatClient client = null;
                try {
                    client = new ChatClient(null, ChatServer.PORT);
                    client.sendMsg("客户端给服务器端，发了一条信息");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}