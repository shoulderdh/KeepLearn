package com.study.dh.keeplearn.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.study.dh.keeplearn.R;
import com.study.dh.keeplearn.db.LoveDao;
import com.study.dh.keeplearn.db.Shop;
import com.study.dh.keeplearn.db.ShopListAdapter;
import com.study.dh.keeplearn.eventBus.MainEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class HandleDbActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button bt_add, bt_delete, bt_update, bt_query,eventBusAnother_btn,AsyncEventAnother_btn,PostingEventAnother_btn,BackgroundEventAnother_btn;
    private ListView lv_content;
    private ShopListAdapter adapter;
    private List<Shop> shops;
    private static int i = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_db);

        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_query = (Button) findViewById(R.id.bt_query);
        lv_content = (ListView) findViewById(R.id.lv_content);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);

        eventBusAnother_btn= (Button) findViewById(R.id.MainEventAnother_btn);
        AsyncEventAnother_btn= (Button) findViewById(R.id.AsyncEventAnother_btn);
        PostingEventAnother_btn= (Button) findViewById(R.id.PostingEventAnother_btn);
        BackgroundEventAnother_btn= (Button) findViewById(R.id.BackgroundEventAnother_btn);
        eventBusAnother_btn.setOnClickListener(this);
        AsyncEventAnother_btn.setOnClickListener(this);
        PostingEventAnother_btn.setOnClickListener(this);
        BackgroundEventAnother_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                addDate();
                break;
            case R.id.bt_delete:
                deleteDate();
                break;
            case R.id.bt_update:
                updateDate();
                break;
            case R.id.bt_query:
                queryDate();
                break;
            case R.id.MainEventAnother_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new MainEvent("just  do  it main!!"));
                    }
                }).start();
                break;
            case R.id.AsyncEventAnother_btn:
                EventBus.getDefault().post(new MainEvent("just  do  it async!!"));
                break;
            case R.id.PostingEventAnother_btn:
                EventBus.getDefault().post(new MainEvent("just  do  it posting!!"));

                break;
            case R.id.BackgroundEventAnother_btn:
                EventBus.getDefault().post(new MainEvent("just  do  it background!!"));

                break;
        }
    }
    private void deleteDate() {
        if (!shops.isEmpty()) {
            LoveDao.deleteLove(shops.get(0).getId());
            queryDate();
        }
    }

    private void queryDate() {
        shops = new ArrayList<>();
        shops = LoveDao.queryLove();
        adapter = new ShopListAdapter(this, shops);
        lv_content.setAdapter(adapter);
    }

    private void addDate() {
        Shop shop = new Shop();
        shop.setType(Shop.TYPE_LOVE);
        shop.setAddress("广东深圳");
        shop.setImage_url("http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg");
        shop.setPrice("19.40");
        shop.setSell_num(666);
        shop.setName("on my way  " + i++);
        LoveDao.insertLove(shop);
        queryDate();
    }

    private void updateDate() {
        if (!shops.isEmpty()) {
            Shop shop = shops.get(0);
            shop.setName("have  changed name");
            LoveDao.updateLove(shop);
            queryDate();
        }
    }
}
