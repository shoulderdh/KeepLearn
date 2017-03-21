package com.study.dh.theyear;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.study.dh.theyear.adapter.MsgAdapter;
import com.study.dh.theyear.entry.Fruit;
import com.study.dh.theyear.entry.Msg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView  fruit_rv;
    @Bind(R.id.input_et)
    EditText   input_et;
    @Bind(R.id.sendmsg_btn)
    Button  sendmsg_btn;
    private List<Msg> msgs=new ArrayList<>();
    private  MsgAdapter  msgAdapter;


    private List<Fruit>  fruitList=new ArrayList<>();


    //remember password
    @Bind(R.id.username_et) EditText  username_et;
    @Bind(R.id.userpwd_et) EditText  userpwd_et;
    @Bind(R.id.rememberpwd_cb)  CheckBox  rememberpwd_cb ;
    @Bind(R.id.login_btn)   Button login_btn;

    private SharedPreferences  preferences;
    private SharedPreferences.Editor  editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean  isRemember = preferences.getBoolean("remember_pwd",false);
        if (isRemember){
            String account=preferences.getString("account","");
            String pwd=preferences.getString("pwd","");
            username_et.setText(account);
            userpwd_et.setText(pwd);
            rememberpwd_cb.setChecked(true);
        }
        login_btn.setOnClickListener(this);

        initMsg();

        fruit_rv= (RecyclerView) findViewById(R.id.fruit_rv);
        sendmsg_btn.setOnClickListener(this);

          msgAdapter=new MsgAdapter(msgs);


     //   initFruit();
    //    StaggeredGridLayoutManager  staggeredGridLayoutManager=new
  //                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(this);
     //   linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);   //横向滚动
       fruit_rv.setLayoutManager(linearLayoutManager);
//        FruitAdapter  fruitAdapter=new FruitAdapter(fruitList);
        fruit_rv.setAdapter(msgAdapter);

    }

    private void initMsg() {
          for (int i=0;i<5;i++){
              if (i%2==0){
                  Msg msg=new Msg("left"+i,Msg.TYPE_RECEIVED);
                  msgs.add(msg);
              }else {
                  Msg msg=new Msg("right"+i,Msg.TYPE_SEND);
                  msgs.add(msg);
              }
          }

    }

    private void initFruit() {

        for (int i=0;i<20;i++){
            Fruit  fruit=new Fruit();
            fruit.setImgId(R.mipmap.ic_launcher);
            fruit.setName("moon"+i*10000000);
            fruitList.add(fruit);
        }

    }


    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.sendmsg_btn:
                    String content=input_et.getText().toString();
                  if (!content.equals("")){
                      Random  random=new Random();
                      Msg msg=new Msg(content,random.nextInt(2));
                      msgs.add(msg);
                      msgAdapter.notifyItemInserted(msgs.size()-1);   //刷新新消息
                      fruit_rv.scrollToPosition(msgs.size()-1);    //将recycleview定位到最后一行
                      input_et.setText("");
                  }
                  break;
              case R.id.login_btn:
                  String account=username_et.getText().toString();
                  String pwd=userpwd_et.getText().toString();
                  if (account.equals("11")&&pwd.equals("22")){
                      editor=preferences.edit();
                      if (rememberpwd_cb.isChecked()){
                          editor.putString("account",account);
                          editor.putString("pwd",pwd);
                          editor.putBoolean("remember_pwd", true);
                      }else {
                          editor.clear();
                      }
                      editor.apply();

                      Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                  }
                  break;
          }
    }
}
