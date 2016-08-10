package com.group.newproject.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/1.
 */
public class PriceView extends TextView{
    private Paint mPaint;
    public PriceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PriceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,getHeight()/2,getWidth(),getHeight()/2,mPaint);
    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(0xffff0000);
        mPaint.setAntiAlias(true);
    }
}
