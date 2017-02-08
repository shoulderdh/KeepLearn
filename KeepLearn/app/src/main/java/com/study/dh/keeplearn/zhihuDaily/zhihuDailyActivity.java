package com.study.dh.keeplearn.zhihuDaily;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.squareup.picasso.Picasso;
import com.study.dh.keeplearn.MainActivity;
import com.study.dh.keeplearn.R;
import com.study.dh.keeplearn.network.ApiService;
import com.study.dh.keeplearn.network.PicInfo;
import com.study.dh.keeplearn.network.UrlManager;
import com.study.dh.keeplearn.zhihuDaily.adapter.TitleInfoAdapter;
import com.study.dh.keeplearn.zhihuDaily.adapter.TitleInfoGson;

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

public class zhihuDailyActivity extends AppCompatActivity {
    @Bind(R.id.topBanner)
    ConvenientBanner  topBanner;
    private List<String>  picInfos=new ArrayList<>();

     @Bind(R.id.zhihulastinfo_er)
    EasyRecyclerView  zhihulastinfo_er;

    private TitleInfoAdapter  adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu_daily);
        ButterKnife.bind(this);

        getLastInfo();

        adapter=new TitleInfoAdapter(this);
        zhihulastinfo_er.setAdapter(adapter);

        RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(this);
        zhihulastinfo_er.setLayoutManager(layoutManager);

        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
             //   getLastInfo();
            }

            @Override
            public void onMoreClick() {
                adapter.stopMore();
            }
        });


        topBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(zhihuDailyActivity.this,"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getLastInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlManager.zhihuDailybaseurl)
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                //    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .build();
        ApiService apiManager = retrofit.create(ApiService.class);
        apiManager.getTitleInfo().enqueue(new Callback<TitleInfoGson>() {
            @Override
            public void onResponse(Call<TitleInfoGson> call, Response<TitleInfoGson> response) {
                List<PicInfo> meiNvList = new ArrayList<PicInfo>();
                for (TitleInfoGson.StoriesBean newslistBean : response.body().getStories()) {
                    PicInfo m1 = new PicInfo();
                    m1.setPicUrl(newslistBean.getImages().get(0));
                    //m1.setCreTime(newslistBean.getId());
                    m1.setPicTitle(newslistBean.getTitle());
                    meiNvList.add(m1);
                }

                for (TitleInfoGson.TopStoriesBean newslistBean : response.body().getTop_stories()) {
                    picInfos.add(newslistBean.getImage());
                }
                topBanner.setPages( new CBViewHolderCreator<NetworkImageHolderView>() {

                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                },picInfos)
                        .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});

                adapter.addAll(meiNvList);
            }

            @Override
            public void onFailure(Call<TitleInfoGson> call, Throwable t) {

            }

        });

    }

    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
    public class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            imageView.setImageResource(R.mipmap.ic_launcher);
            Picasso.with(context).load(data).into(imageView);
        }
    }
    }
