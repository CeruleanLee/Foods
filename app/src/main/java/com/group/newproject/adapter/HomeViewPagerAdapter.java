package com.group.newproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.group.newproject.entity.VideoLast;
import com.group.newproject.utils.MBitmapHolder;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

public class HomeViewPagerAdapter extends PagerAdapter{
	private List<ImageView> imgviews;
	private BitmapUtils mBitmapUtils;
	private List<VideoLast.ObjBean.AdBean> datas;
	public HomeViewPagerAdapter(Context context,List<ImageView> imgviews,List<VideoLast.ObjBean.AdBean> datas) {
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
			mBitmapUtils.display(view, datas.get(position).getPhoto());
		}
		return view;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//		View view = imgviews.get(position);
		//		container.removeView(view);
	}
}
