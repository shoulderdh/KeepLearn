package com.study.dh.theyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.study.dh.theyear.adapter.FruitAdapter;
import com.study.dh.theyear.entry.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView  fruit_rv;
    private List<Fruit>  fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        fruit_rv= (RecyclerView) findViewById(R.id.fruit_rv);
        StaggeredGridLayoutManager  staggeredGridLayoutManager=new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

    //    LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(this);
     //   linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);   //横向滚动
        fruit_rv.setLayoutManager(staggeredGridLayoutManager);
        FruitAdapter  fruitAdapter=new FruitAdapter(fruitList);
        fruit_rv.setAdapter(fruitAdapter);

    }

    private void initFruit() {

        for (int i=0;i<20;i++){
            Fruit  fruit=new Fruit();
            fruit.setImgId(R.mipmap.ic_launcher);
            fruit.setName("moon"+i*10000000);
            fruitList.add(fruit);
        }

    }


}
