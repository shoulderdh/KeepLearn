package com.study.dh.keeplearn.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.study.dh.keeplearn.R;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle  bundle=this.getIntent().getExtras();
        ArrayList<String>  data=bundle.getStringArrayList("data");
          Log.i("bundle", data.get(0));
        Log.i("bundle", data.get(1));

    }
}
