package com.group.newproject.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.group.tastyfoods.R;

/**
 * Created by lee_yting on 2016/7/31.
 * 置顶用
 */
public class GoToTopScrollView  extends ScrollView implements View.OnClickListener {
    private ImageView goTopBtn;
    private ImageView trackBtn;

    private int screenHeight;

    public GoToTopScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setScrollListener(ImageView goTopBtn)
    {
        this.goTopBtn = goTopBtn;
        this.goTopBtn.setOnClickListener(this);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt)
    {
        super.onScrollChanged(l, t, oldl, oldt);
        /**
         * 滑动距离超过500px,出现向上按钮,可以做为自定义属性
         */
        if (t >= 500)
        {
            goTopBtn.setVisibility(View.VISIBLE);
            trackBtn.setVisibility(View.VISIBLE);
        }
        else
        {
            goTopBtn.setVisibility(View.GONE);
            trackBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.shihuaFrag_goToTop)
        {
            this.smoothScrollTo(0, 0);
        }
    }
}
