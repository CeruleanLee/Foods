package com.group.newproject.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.group.newproject.fragment.Fragment_Recommend;
import com.group.newproject.fragment.Fragment_Find;
import com.group.newproject.fragment.Fragment_Shop;
import com.group.newproject.fragment.Fragment_Talking;
import com.group.newproject.fragment.Fragment_Mine;
import com.group.newproject.views.UnslideViewpager;
import com.group.tastyfoods.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MainActivity extends  BaseActivity {
	@ViewInject(R.id.mainAct_viewPager)
	private UnslideViewpager  mViewPager;
	private List<Fragment> fragments;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogUtils.d("进入主界面onCreate");
	}	
	@Override
	protected int getContentViewID() {
		return R.layout.tab_activity;
	}
	@Override
	protected void beforeInitView() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void initView(Bundle savedInstanceState) {
		LogUtils.d("进入主界面initViews");
		ViewUtils.inject(this);

		ViewGroup tabContainer = (ViewGroup) findViewById(R.id.bottom_tab);
		fragments = new ArrayList<Fragment>();
		fragments.add(new Fragment_Recommend());
		fragments.add(new Fragment_Find());
		fragments.add(new Fragment_Shop());
		fragments.add(new Fragment_Talking());
		fragments.add(new Fragment_Mine());
		int[][] res = { { R.drawable.tab_recomment_5, R.drawable.tab_recomment2_5 },{ R.drawable.tab_discover_5, R.drawable.tab_discover2_5 },
				{ R.drawable.tab_shop_5, R.drawable.tab_shop2_5 },{ R.drawable.tab_topic_5, R.drawable.tab_topic2_5 },{ R.drawable.tab_wode_5, R.drawable.tab_wode2_5 } };
		int[] textColors = {getResources().getColor(R.color.tab_text),getResources().getColor(R.color.tab_text_selected)};
		
		init(mViewPager,tabContainer, fragments,res,textColors );
		switchTab(0);
	}

	public void  switchToVideo(){
		switchTab(2);
	}
	@Override
	protected void initData() {

	}
	@Override
	protected void onViewClick(View v) {

	}

}
