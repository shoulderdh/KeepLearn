package com.study.dh.keeplearn.playvideo;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.study.dh.keeplearn.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlayVideoActivity extends AppCompatActivity {
     @Bind(R.id.videoview)
    VideoView  videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        ButterKnife.bind(this);

        //本地视频播放
     //   videoview.setVideoPath("");

        //网络播放
        videoview.setVideoURI(Uri.parse("http://192.168.99.145:8080/myvideo/first.flv"));

        MediaController  controller=new MediaController(this);
        videoview.setMediaController(controller);   //播放控制设置关联  相互的
        controller.setMediaPlayer(videoview);

    }


    //监听屏幕方向的改变
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
