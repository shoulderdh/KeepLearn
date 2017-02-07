package com.study.dh.keeplearn.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DetailActivity extends Activity {
    @Bind(R.id.big_iv)
    ImageView  big_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Bundle  bundle=this.getIntent().getExtras();
        ArrayList<String>  data=bundle.getStringArrayList("data");
        Log.i("bundle", data.get(0));
        Log.i("bundle", data.get(1));
        Picasso.with(this).load(data.get(2)).into(big_iv);


    }
}
