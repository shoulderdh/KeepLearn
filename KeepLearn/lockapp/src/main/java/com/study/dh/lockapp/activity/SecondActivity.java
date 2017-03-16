package com.study.dh.lockapp.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.study.dh.lockapp.R;
import com.study.dh.lockapp.fragment.AnotherRightFragment;
import com.study.dh.lockapp.fragment.RightFragment;


import butterknife.Bind;
import butterknife.ButterKnife;



public class SecondActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.leftfragment_btn)  Button  leftfragment_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        leftfragment_btn.setOnClickListener(this);
        replaceFragment(new RightFragment());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.leftfragment_btn:
                replaceFragment(new AnotherRightFragment());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager  fragmentManager=getSupportFragmentManager();
        FragmentTransaction  transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);
        transaction.addToBackStack(null);    //碎片中模拟返回栈
        transaction.commit();
    }
}
