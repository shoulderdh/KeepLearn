package com.study.dh.theyear;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by dh on 2017/4/7.
 */

public class RippleDrawable  extends Drawable {
    private int mAlpha=200;    //透明度  0-255
    private int mRippleColor=0;    //颜色


    private Paint  mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);  //画笔，抗锯齿
    private float mRipplePointX,mRipplePointY;   //圆心坐标
    private float mRippleRadius=200;   //半径


    public RippleDrawable() {
        mPaint.setAntiAlias(true);   //抗锯齿
        mPaint.setDither(true);   //防抖动   均为了界面更平滑
        setRippleColor(0x30000000);

    }


    public  void setRippleColor(int color){
        //mPaint.setColor(color);    //不建议
        mRippleColor=color;
        onColorOrAlphaChange();
    }


    @Override
    public void draw(Canvas canvas) {
        //   canvas.drawColor(Color.RED);
        canvas.drawCircle(mRipplePointX,mRipplePointY,mRippleRadius,mPaint);   //画一个圆
    }

    @Override
    public void setAlpha(int i) {
         mAlpha=i;    //动态改变透明度

        onColorOrAlphaChange();
    }

    private void onColorOrAlphaChange() {
         mPaint.setColor(mRippleColor);
        Log.i("color","old -color:"+mPaint.getColor());

        if (mAlpha!=255){
            int pAlpha=mPaint.getAlpha();   //得到颜色本身透明度
            int realAlpha= (int) (pAlpha*(mAlpha/255f));

            mPaint.setAlpha(realAlpha);

            Log.i("color","new _color:"+mPaint.getColor());
        }


    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
         //颜色滤镜
        if (mPaint.getColorFilter()!=colorFilter){
            mPaint.setColorFilter(colorFilter);
        }
    }

    @Override
    public int getOpacity() {
        int alpha=mPaint.getAlpha();
        if (alpha==255){
            return PixelFormat.OPAQUE;     //不透明

        }else if (alpha==0){
            return PixelFormat.TRANSPARENT;     //全透明

        }else {
            return PixelFormat.TRANSLUCENT;      //半透明

        }

    }
}
