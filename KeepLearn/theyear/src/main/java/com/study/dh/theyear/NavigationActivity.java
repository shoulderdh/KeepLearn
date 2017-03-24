package com.study.dh.theyear;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.study.dh.theyear.application.MyApplication;
import com.study.dh.theyear.entry.Person;
import com.study.dh.theyear.entry.Song;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout  mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView  navigationView= (NavigationView) mDrawerLayout.findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_bike:
                        Toast.makeText(NavigationActivity.this,"bike",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_call:
                        Toast.makeText(NavigationActivity.this,"call",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_eat:
                        Toast.makeText(NavigationActivity.this,"eat",Toast.LENGTH_SHORT).show();

                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });


//        Person   person=new Person();
//        person.setName("huazai");
//        person.setAge(18);
//
//        Intent  intent=new Intent();
//        intent.putExtra("persong_data",person);
//
//        Song  song=new Song();
//        song.setName("隐形人");
//        song.setName("孙燕姿");
//        Intent  intent=new Intent();
//        intent.putExtra("songInfo",person);
//
//        Song  song1=(Song) getIntent().getParcelableExtra("songInfo");


    }
}
