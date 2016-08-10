package com.group.newproject.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/**
 * 主框架中 不能滑动的ViewPager
 * @author Administrator
 *
 */
public class UnslideViewpager extends ViewPager {

    public UnslideViewpager(Context context) {
        super(context);
    }

    public UnslideViewpager(Context context, AttributeSet atts) {
        super(context, atts);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return false;
    }
    @Override
    public void scrollTo(int x, int y) {
        // TODO Auto-generated method stub
        super.scrollTo(x, y);
    }
    @Override
    public void setCurrentItem(int item) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item);
    }
}
