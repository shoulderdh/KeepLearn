package com.study.dh.keeplearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.study.dh.keeplearn.Activity.DetailActivity;
import com.study.dh.keeplearn.EasyRecycle.Content;
import com.study.dh.keeplearn.EasyRecycle.ContentListAdapter;
import com.study.dh.keeplearn.Util.PixUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.listName_ER)
    EasyRecyclerView  easyRecyclerView;
    private ContentListAdapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Content  content=new Content();
          content.setName("多一次");
          content.setTime("12:00");

        Content  content1=new Content();
        content1.setName("多二次");
        content1.setTime("13:00");



        adapter=new ContentListAdapter(this);
        adapter.add(content);
        adapter.add(content1);

        easyRecyclerView.setAdapter(adapter);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //添加边框
        SpaceDecoration itemDecoration = new SpaceDecoration((int) PixUtil.convertDpToPixel(8, this));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        easyRecyclerView.addItemDecoration(itemDecoration);

        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                Log.i("fff","moreshow");
                adapter.stopMore();


            }

            @Override
            public void onMoreClick() {
                Log.i("fff","moreclick");
                adapter.stopMore();

            }
        });


        //刷新
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                easyRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        Content  content=new Content();
                        content.setName("多三次");
                        content.setTime("14:00");

                        Content  content1=new Content();
                        content1.setName("多四次");
                        content1.setTime("15:00");

                        adapter.add(content);
                        adapter.add(content1);
                    }
                },1000);
            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,
                        "item: "+position+"  onclick, content is "+adapter.getAllData().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
                ArrayList<String>  data=new ArrayList<String>();
                 data.add(adapter.getAllData().get(position).getName());
                data.add(adapter.getAllData().get(position).getTime());

                Bundle  bundle=new Bundle();      //bundle  携带数据
                bundle.putStringArrayList("data",data);
                Intent  intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);     //打开之后，按下返回键回到桌面，再打开，并不会再看到启动页
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     //除非你手动清了该应用，后台或者被系统 kill 了），实现方法
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
