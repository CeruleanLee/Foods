package com.group.newproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.group.newproject.entity.Home;
import com.group.newproject.utils.MBitmapHolder;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by gt72 on 2016-07-30.
 */
public class Top3ViewPagerAdapter extends PagerAdapter {

    private List<ImageView> views;
    private List<Home.ObjBean.Top3Bean> datas;
    private BitmapUtils bitmapUtils;
    public Top3ViewPagerAdapter(List<ImageView> views, Context contex, List<Home.ObjBean.Top3Bean> datas) {
        this.views = views;
        this.datas = datas;
        bitmapUtils = MBitmapHolder.getBitmapUtils(contex);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view = views.get(position);
        container.addView(view);
        bitmapUtils.display(view,datas.get(position).getPhoto());
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView view = views.get(position);
        container.removeView(view);
    }
}
