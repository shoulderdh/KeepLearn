package com.study.dh.theyear.widget;

import android.graphics.Canvas;
import android.graphics.Rect;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dh on 2017/4/9.
 */

public class MyItemDacoration extends RecyclerView.ItemDecoration {


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top=10;
        outRect.right=5;
        outRect.left=5;
    }
}
