package com.study.dh.keeplearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener{
     @Bind(R.id.lookPic_btn)
    Button  lookPic_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        ButterKnife.bind(this);

        lookPic_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.lookPic_btn:
                  startActivity(new Intent(EntryActivity.this,MainActivity.class));
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
