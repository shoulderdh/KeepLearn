package com.study.dh.keeplearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.study.dh.keeplearn.Activity.DetailActivity;
import com.study.dh.keeplearn.EasyRecycle.ContentListAdapter;
import com.study.dh.keeplearn.Util.PixUtil;
import com.study.dh.keeplearn.network.ApiService;
import com.study.dh.keeplearn.network.PicInfo;
import com.study.dh.keeplearn.network.PicInformationGson;
import com.study.dh.keeplearn.network.UrlManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    @Bind(R.id.listName_ER)
    EasyRecyclerView  easyRecyclerView;
    private ContentListAdapter  adapter;
    private   int page=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter=new ContentListAdapter(this);
        easyRecyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        easyRecyclerView.setLayoutManager(layoutManager);

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
                page=page+1;
                addData();
            }

            @Override
            public void onMoreClick() {
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
                        page=1;
                        adapter.clear();
                        addData();

                    }
                },1000);
            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,
                        "item: "+position+"  onclick, content is "+adapter.getAllData().get(position).getPicTitle(),
                        Toast.LENGTH_SHORT).show();
                ArrayList<String>  data=new ArrayList<String>();
                data.add(adapter.getAllData().get(position).getCreTime());
                data.add(adapter.getAllData().get(position).getPicTitle());
                data.add(adapter.getAllData().get(position).getPicUrl());

                Bundle  bundle=new Bundle();      //bundle  携带数据
                bundle.putStringArrayList("data",data);
                Intent  intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        addData();
    }

    private void addData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlManager.beautyurl)
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                //    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .build();
        ApiService apiManager = retrofit.create(ApiService.class);
        apiManager.getPictureData(page).enqueue(new Callback<PicInformationGson>() {
            @Override
            public void onResponse(Call<PicInformationGson> call, Response<PicInformationGson> response) {
                List<PicInfo> meiNvList = new ArrayList<PicInfo>();
                        for (PicInformationGson.ResultsBean newslistBean : response.body().getResults()) {
                            PicInfo m1 = new PicInfo();
                            m1.setPicUrl(newslistBean.getUrl());
                            m1.setCreTime(newslistBean.getCreatedAt());
                            m1.setPicTitle(newslistBean.getDesc());
                            meiNvList.add(m1);
                        }
                adapter.addAll(meiNvList);
            }

            @Override
            public void onFailure(Call<PicInformationGson> call, Throwable t) {

            }
        });


    }

}
