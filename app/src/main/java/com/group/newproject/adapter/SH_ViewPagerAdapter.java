package com.group.newproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.group.newproject.entity.SH_Entity;
import com.group.newproject.utils.MBitmapHolder;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by lee_yting on 2016/7/28.
 */
public class SH_ViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imgviews;
    private BitmapUtils mBitmapUtils;
    private List<SH_Entity.Activities2Bean> datas;
    public SH_ViewPagerAdapter(Context context, List<ImageView> imgviews, List<SH_Entity.Activities2Bean> datas) {
        super();
        this.imgviews = imgviews;
        mBitmapUtils = MBitmapHolder.getBitmapUtils(context);
        this.datas = datas;
    }
    @Override
    public int getCount() {
        return imgviews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = imgviews.get(position);
        if(view.getParent() == null){
            container.addView(view);
            mBitmapUtils.display(view, datas.get(position).img);
        }
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = imgviews.get(position);
        		container.removeView(view);
    }
}