package com.group.newproject.activity;

import java.util.ArrayList;
import java.util.List;

import com.group.newproject.utils.AppManager;
import com.group.newproject.views.UnslideViewpager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Administrator on 2016/7/26 .
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener, OnPageChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getContentViewID() != -1) {
			setContentView(getContentViewID());

		}		
		beforeInitView();

		AppManager.getInstance().addActivity(this);

		initView(savedInstanceState);

		initData();
	}

	/**
	 * 不用强转的findviewbyid
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T findViewByIdNoCast(int id) {
		return (T) super.findViewById(id);
	}

	/**
	 * 设置layout
	 */
	protected abstract int getContentViewID();

	/**
	 * 初始化view之前
	 */
	protected abstract void beforeInitView();

	/**
	 * 初始化view
	 */
	protected abstract void initView(Bundle savedInstanceState);

	/**
	 * 初始化data
	 */
	protected abstract void initData();

	/**
	 * onclick事件
	 */
	protected abstract void onViewClick(View v);

	/**
	 * 根据id设置点击事件
	 *
	 * @param ids
	 */
	protected void setOnClick(int... ids) {

		for (int id : ids) {
			findViewById(id).setOnClickListener(this);
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		AppManager.getInstance().remove(this);
	}

	@Override
	public void onClick(View v) {
		onViewClick(v);
	}

	/**
	 * 本段代码用来处理如果输入法还显示的话就消失掉输入键盘
	 */
	protected void dismissSoftKeyboard(Activity activity) {
		try {
			InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			inputMethodManage.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示键盘
	 *
	 * @param view
	 */
	protected void showKeyboard(View view) {
		try {
			InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			inputMethodManage.showSoftInput(view, InputMethodManager.SHOW_FORCED);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Dialog dialog;
	private AnimationDrawable animationDrawable;
	/**
	 * 显示加载的对话框
	 */
//	public void showLoadingDialog() {
//		if(dialog == null){
//			dialog = new Dialog(this,R.style.dialog);
//			View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_progressbar, null);
//			dialog.setContentView(dialogView );
//			ImageView mLoadingImg = (ImageView) dialogView.findViewById(R.id.img_loading);
//			animationDrawable = (AnimationDrawable) mLoadingImg.getDrawable();
//		}
//		animationDrawable.start();
//		dialog.show();
//	}

	public void dismissLoadingDialog() {
		if (dialog != null && dialog.isShowing())
			animationDrawable.stop();
		dialog.dismiss();
	}
	/**
	 * 判断是否有网络
	 * @param context
	 * @return
	 */
//	public boolean isNetWork( Context context) {
//		ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
//		return connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable();
//	}

	/**
	 * 检测是否处于wifi下
	 * @param context
	 * @return
	 */
//	public boolean isWifiActive(final Context context) {
//		boolean b = false;
//		final ConnectivityManager connectivityManager = (ConnectivityManager)context.getApplicationContext().getSystemService("connectivity");
//		if (connectivityManager != null) {
//			final NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
//			if (allNetworkInfo != null) {
//				for (int i = 0; i < allNetworkInfo.length; ++i) {
//					if (allNetworkInfo[i].getTypeName().equals("WIFI") && allNetworkInfo[i].isConnected()) {
//						b = true;
//						break;
//					}
//				}
//			}
//		}
//		return b;
//	}

	/**
	 * 获取状态栏高度
	 * @param activity
	 * @return
	 */
	public int getStatusHeight(final Activity activity) {
		final Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		int n = rect.top;
		if (n != 0) {
			return n;
		}
		try {
			final Class<?> forName = Class.forName("com.android.internal.R$dimen");
			n = activity.getResources().getDimensionPixelSize(Integer.parseInt(forName.getField("status_bar_height").get(forName.newInstance()).toString()));
			return n;
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return n;
		}catch (IllegalAccessException ex2) {
			ex2.printStackTrace();
			return n;
		}catch (InstantiationException ex3) {
			ex3.printStackTrace();
			return n;
		}catch (NumberFormatException ex4) {
			ex4.printStackTrace();
			return n;
		}catch (IllegalArgumentException ex5) {
			ex5.printStackTrace();
			return n;
		}catch (SecurityException ex6) {
			ex6.printStackTrace();
			return n;
		}catch (NoSuchFieldException ex7) {
			ex7.printStackTrace();
			return n;
		}
	}
	
	
	/**
	 * 适用于项目主框架：
	 * 由ViewPager+底部切换(ImageView+TextView)
	 *
	 */
	
	private UnslideViewpager  viewPager;
	private List<View> tabs;
	private int[][] drawableResIdsColors;
	private int[] textColors;
	private ImageView[] imgs;
	private TextView[] textViews;
	/**
	 * 初始化
	 * @param tabContainer
	 * @param fragments
	 */
	protected void init(UnslideViewpager  viewPager,ViewGroup tabContainer,List<Fragment> fragments,int[][] drawableResIdsColors,int[] textColors){
		this.viewPager = viewPager;
		this.drawableResIdsColors = drawableResIdsColors;
		this.textColors = textColors;
		tabs = new ArrayList<View>();
		imgs = new ImageView[tabContainer.getChildCount()];
		textViews = new TextView[tabContainer.getChildCount()];
		for (int i = 0; i < tabContainer.getChildCount(); i++) {
			ViewGroup viewGroup = (ViewGroup) tabContainer.getChildAt(i);
			for (int j = 0; j < viewGroup.getChildCount(); j++) {
				if(viewGroup.getChildAt(j) instanceof ImageView){
					imgs[i] = (ImageView) viewGroup.getChildAt(j);
					imgs[i].setImageResource(drawableResIdsColors[i][0]);
				}
				if(viewGroup.getChildAt(j) instanceof TextView){
					textViews[i] = (TextView) viewGroup.getChildAt(j);
					textViews[i].setTextColor(textColors[0]);
				}
			}
			tabs.add(viewGroup);
			tabs.get(i).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					for (int i = 0; i < tabs.size(); i++) {
						if(tabs.get(i) == v){
							if(i == curIndex){
								return;
							}
							switchTab(i);
							break;
						}
					}
					
				}
			});
		}
		viewPager.setOnPageChangeListener(this);
		viewPager.setAdapter(new MainPagerFragmentAdapter(getSupportFragmentManager(), fragments));
	}
	private int curIndex = -1;
//	@Override
	/**
	 * 切换tab项
	 * @param index
	 */
	protected void switchTab(int index) {
		if(index == curIndex){
			return;
		}
		imgs[index].setImageResource(drawableResIdsColors[index][1]);
		textViews[index].setTextColor(textColors[1]);
		if(curIndex != -1){
			imgs[curIndex].setImageResource(drawableResIdsColors[curIndex][0]);
			textViews[curIndex].setTextColor(textColors[0]);
		}
		curIndex = index;
		viewPager.setCurrentItem(index,false);
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}
	@Override
	public void onPageSelected(int arg0) {
//		switchTab(arg0);
	}
	public class MainPagerFragmentAdapter extends FragmentPagerAdapter{
		private List<Fragment> fragments;
		public MainPagerFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}
		@Override
		public Fragment getItem(int arg0) {
			return fragments.get(arg0);
		}
		@Override
		public int getCount() {
			return fragments.size();
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
		}
	}
	
	
}