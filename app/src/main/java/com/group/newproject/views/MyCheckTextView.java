package com.group.newproject.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/**
 * Created by lee_yting on 2016/7/30.
 * 控制drawable显示位置的CheckedTextView
 */
public class MyCheckTextView extends CheckedTextView{
    public MyCheckTextView(Context context) {
        super(context);
    }

    public MyCheckTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCheckTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean isChecked() {
        return super.isChecked();
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
    }

    @Override
    public void setCheckMarkDrawable(int resid) {
        super.setCheckMarkDrawable(resid);
    }

    @Override
    public void setCheckMarkDrawable(Drawable d) {
        super.setCheckMarkDrawable(d);
    }

    @Override
    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop();
    }

    @Override
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        left.setBounds(0,0, (int) (left.getMinimumWidth()/1.5), (int) (left.getMinimumHeight()/1.5));
        super.setCompoundDrawables(left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setHeight(int pixels) {
        super.setHeight(pixels);
    }
}
