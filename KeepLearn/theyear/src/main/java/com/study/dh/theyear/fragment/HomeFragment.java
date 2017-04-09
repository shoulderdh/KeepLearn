package com.study.dh.theyear.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.study.dh.theyear.R;
import com.study.dh.theyear.adapter.GoodsNameAdapter;
import com.study.dh.theyear.application.MyApplication;
import com.study.dh.theyear.entry.HomeCategory;
import com.study.dh.theyear.widget.MyItemDacoration;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private SliderLayout  sliderShow;
//    private PagerIndicator custom_indicator;

    private RecyclerView  mygoods_rc;
    private List<HomeCategory>  goodNames=new ArrayList<>();
    private GoodsNameAdapter  goodsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fragment_home, container, false);
         sliderShow = (SliderLayout) view.findViewById(R.id.slider);
  //      custom_indicator= (PagerIndicator) view.findViewById(R.id.custom_indicator);

        initData();

        mygoods_rc= (RecyclerView) view.findViewById(R.id.mygoods_rc);
        goodsAdapter=new GoodsNameAdapter(goodNames);
        mygoods_rc.setAdapter(goodsAdapter);
        mygoods_rc.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));

        mygoods_rc.addItemDecoration(new MyItemDacoration());
        mygoods_rc.setItemAnimator(new DefaultItemAnimator());   //默认动画效果

        goodsAdapter.setMyOnItemClickListener(new GoodsNameAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, String city) {
                Toast.makeText(MyApplication.getContext(),"ff//"+position,Toast.LENGTH_SHORT).show();
                goodsAdapter.removeData(position);
                mygoods_rc.scrollToPosition(0);
            }
        });

        initView();

         return view;
    }

    private void initData() {
          for (int i=0;i<10;i++){
            HomeCategory  homeCategory=new HomeCategory("name"+i,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
              goodNames.add(homeCategory);
          }


    }

    private void initView() {

        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView.description("first")
                      .image("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-08-17126216_1253875034703554_7520300169779216384_n.jpg");

          textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
              @Override
              public void onSliderClick(BaseSliderView slider) {
                  Toast.makeText(HomeFragment.this.getActivity(),"first",Toast.LENGTH_SHORT).show();
              }
          });

        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .description("second")
                .image("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-08-17126216_1253875034703554_7520300169779216384_n.jpg");

        textSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"second",Toast.LENGTH_SHORT).show();

            }
        });


        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView1);

        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        //sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateUp);     //切换动画

        //sliderShow.setCustomIndicator(custom_indicator);

        sliderShow.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("pagechange","onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("pagechange","onPageSelected");

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("pagechange","onPageScrollStateChanged");
            }
        });

    }


    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();

    }
}
