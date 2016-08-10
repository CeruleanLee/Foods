package com.group.newproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.CheckedTextView;

import com.group.newproject.adapter.MyFragmentPagerAdapter;
import com.group.newproject.ui.MyViewPager;
import com.group.tastyfoods.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Shop extends Fragment implements
		MyViewPager.OnScrollChangedListener,
		ViewPager.OnPageChangeListener,
		View.OnClickListener
{
	private MyViewPager mViewPager;
	private List<Fragment> fragments;
	private CheckedTextView mLastTv;//最新
	private CheckedTextView mHostTv;//最热
	private CheckedTextView mSpecialTv;//专辑
	private View mLine;
	private ViewGroup mLineContainer;
	private ViewGroup mTabLayout;
	private CheckedTextView[] mCtvs;

	private MyFragmentPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_shop, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initFindview();
		initView();
	}

	private void initFindview() {
		mLastTv = (CheckedTextView) getView().findViewById(R.id.tv_last);
		mHostTv = (CheckedTextView) getView().findViewById(R.id.tv_host);
		mSpecialTv = (CheckedTextView) getView().findViewById(R.id.tv_special);
		mLine = getView().findViewById(R.id.vedio_line);
		mLineContainer = (ViewGroup) getView().findViewById(R.id.lineContainer);
		mTabLayout = (ViewGroup) getView().findViewById(R.id.layout_tab);

		getView().getViewTreeObserver().addOnGlobalLayoutListener(addOnGlobalLayoutListener);

	}
	private boolean hasFocousChanged = false;
	ViewTreeObserver.OnGlobalLayoutListener addOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {

		@Override
		public void onGlobalLayout() {
			if (!hasFocousChanged){
				mLastTv = (CheckedTextView) getView().findViewById(R.id.tv_last);
				mLine = getView().findViewById(R.id.vedio_line);
				mTabWidth = mLastTv.getWidth();
				LayoutParams params = mLine.getLayoutParams();
				params.width = mTabWidth;
				mLine.setLayoutParams(params);
				mViewPagerWidth = mViewPager.getWidth();
				hasFocousChanged = true;
			}
		}
	};
	/**
	 * 初始化控件
	 */
	private void initView() {
		mViewPager = (MyViewPager) getView().findViewById(R.id.viewPager);
		mCtvs = new CheckedTextView[mTabLayout.getChildCount()];
		for (int i = 0; i < mCtvs.length; i++) {
			mCtvs[i] = (CheckedTextView) mTabLayout.getChildAt(i);
			mCtvs[i].setOnClickListener(this);
		}
		fragments = new ArrayList<Fragment>();
		fragments.add(new Fragment_Video_Last());
		fragments.add(new Fragment_Video_Host());
		fragments.add(new Fragment_Video_Specail());
		adapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments);
		mViewPager.setAdapter(adapter);
		mViewPager.setOnScrollChangedListener(this);
		mViewPager.setOnPageChangeListener(this);
	}

	private int mTabWidth;
	private int mViewPagerWidth;
	@Override
	public void onScrollChanged(int l, int t, int oldl, int oldt) {
		//TODO
		int lineScrollX  = -l*mTabWidth/mViewPagerWidth;
		mLineContainer.scrollTo(lineScrollX, 0);
	}

	@Override
	public void onPageScrolled(int i, float v, int i1) {

	}

	@Override
	public void onPageSelected(int index) {
		for (int i = 0; i < mCtvs.length; i++) {
			if(i == index){
				mCtvs[i].setChecked(true);
			}else{
				mCtvs[i].setChecked(false);
			}
		}
	}

	@Override
	public void onPageScrollStateChanged(int i) {

	}

	@Override
	public void onClick(View v) {
		for (int i = 0; i < mCtvs.length; i++) {
			if(mCtvs[i] == v){
				mViewPager.setCurrentItem(i, true);
				return;
			}
		}
	}
}
