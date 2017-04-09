package com.study.dh.theyear.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.study.dh.theyear.R;

/**
 * Created by dh on 2017/4/8.
 */

public class MyToolBar  extends Toolbar {

    private View  view;
    private LayoutInflater  mInflater;

    private EditText  mSearchview;
    private TextView  mTitleView;
    private ImageButton  mRightImageButton;


    public MyToolBar(Context context) {
        this(context,null);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {

        if (view==null){
            mInflater=LayoutInflater.from(getContext());
            view=mInflater.inflate(R.layout.toolbar,null);
            mRightImageButton= (ImageButton) view.findViewById(R.id.toolbar_rightButton);
            mSearchview= (EditText) view.findViewById(R.id.toolbar_searchview);
            mTitleView= (TextView) view.findViewById(R.id.toolbar_title);

            ViewGroup.LayoutParams  lp=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(view,lp);
        }

    }


    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
          initView();
        if (title!=null){
            mTitleView.setText(title);
            showTitleView();
        }
    }

    private void showTitleView() {
         if (mTitleView!=null){
             mTitleView.setVisibility(VISIBLE);
         }
    }
    private void HideTitleView() {
        if (mTitleView!=null){
            mTitleView.setVisibility(GONE);
        }
    }
    private void showSearchView() {
        if (mSearchview!=null){
            mSearchview.setVisibility(VISIBLE);
        }

    }
    private void HideSearchView() {
        if (mSearchview!=null){
            mSearchview.setVisibility(GONE );
        }

    }


}
