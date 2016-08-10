package com.group.newproject.ui;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 自定义的一个V
 * Created by yp on 2016/7/28.iewPager
 */
public class MyViewPager extends ViewPager{

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(listener != null){
            listener.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public interface OnScrollChangedListener{
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }
    private OnScrollChangedListener listener;
    public void setOnScrollChangedListener(OnScrollChangedListener listener){
        this.listener = listener;
    }
}
