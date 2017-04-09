package com.study.dh.theyear;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.study.dh.theyear.fragment.FifthFragment;
import com.study.dh.theyear.fragment.FourthFragment;
import com.study.dh.theyear.fragment.HomeFragment;
import com.study.dh.theyear.fragment.SecondFragment;
import com.study.dh.theyear.fragment.Tab;
import com.study.dh.theyear.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private FragmentTabHost  mTabhost;
    private LayoutInflater  mLayoutinflater;
    private List<Tab>  tabs=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initTab();

    }

    private void initTab() {
        Tab  tab=new Tab(R.string.home,R.drawable.selector_icon_home,HomeFragment.class);
        Tab  tab1=new Tab(R.string.second,R.drawable.selector_icon_home,SecondFragment.class);
        Tab  tab2=new Tab(R.string.third,R.drawable.selector_icon_home,ThirdFragment.class);
        Tab  tab3=new Tab(R.string.fourth,R.drawable.selector_icon_home,FourthFragment.class);
        Tab  tab4=new Tab(R.string.fifth,R.drawable.selector_icon_home,FifthFragment.class);

        tabs.add(tab);
        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(tab3);
        tabs.add(tab4);

        mLayoutinflater=LayoutInflater.from(this);
        mTabhost= (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.tabcontent);

        for (Tab  mTab :tabs){
            TabHost.TabSpec  tabSpec=mTabhost.newTabSpec(getString(mTab.getTitle()));
            tabSpec.setIndicator(buildIndicator(mTab));
            mTabhost.addTab(tabSpec,mTab.getFrag(),null);
        }

        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);   //去掉底部按钮间隔线
        mTabhost.setCurrentTab(0);

    }

    private View buildIndicator(Tab tab) {
        View  view= mLayoutinflater.inflate(R.layout.tab_indicator,null);
        ImageView  img= (ImageView) view.findViewById(R.id.tab_iv);
        TextView tv= (TextView) view.findViewById(R.id.tab_tv);

        img.setBackgroundResource(tab.getIcon());
        tv.setText(getString(tab.getTitle()));
        return view;
    }
}
