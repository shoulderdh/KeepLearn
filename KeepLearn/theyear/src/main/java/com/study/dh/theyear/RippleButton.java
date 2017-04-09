package com.study.dh.theyear;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by dh on 2017/4/7.
 */

public class RippleButton extends Button {
    private RippleDrawable  mrippleDrawable;

    public RippleButton(Context context) {
        this(context,null);
    }

    public RippleButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }


    public RippleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //setBackground(new RippleDrawable());     //方法一：   直接在此处设置自定义的drawable
        mrippleDrawable=new RippleDrawable();    //方法二：复写onDraw，设置
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制自己的drawable
        mrippleDrawable.draw(canvas);    //此处  super.onDraw(canvas);位置上下导致按钮字是否显示，原因：绘制时最后面绘制显示在最上面

    }
}
