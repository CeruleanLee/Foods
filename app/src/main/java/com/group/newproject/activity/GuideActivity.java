package com.group.newproject.activity;



		import java.util.ArrayList;
		import java.util.List;

		import com.group.newproject.adapter.MyPagerAdapter;
		import com.group.tastyfoods.R;
		import com.lidroid.xutils.ViewUtils;
		import com.lidroid.xutils.util.LogUtils;
		import com.lidroid.xutils.view.annotation.ViewInject;

		import android.app.Activity;
		import android.content.Intent;
		import android.os.Bundle;
		import android.support.v4.view.ViewPager;
		import android.support.v4.view.ViewPager.OnPageChangeListener;
		import android.view.LayoutInflater;
		import android.view.View;
		import android.widget.Button;
		import android.widget.ImageView;
		import android.widget.LinearLayout;
		import android.widget.LinearLayout.LayoutParams;
		import android.widget.Toast;

public class GuideActivity extends Activity implements OnPageChangeListener{
	@ViewInject(R.id.guid_viewPager)
	ViewPager viewPager;
	@ViewInject(R.id.guid_enterBt)
	Button enterBt;
	MyPagerAdapter adapter;
	List<View> views;
	@ViewInject(R.id.guid_inditorsLyout)
	LinearLayout indicatorLayout;
	ImageView[] indicators;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		LogUtils.d("__进入onCreat___");
		ViewUtils.inject(this);
		views = getViewList();
		adapter = new MyPagerAdapter(views);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
		initIndicators(views.size()-1);
	}

	/**初始化底部的指示点**/
	private void initIndicators(int i) {
		indicators = new ImageView[i];
		for (int j = 0; j < indicators.length; j++) {
			indicators[j] = new ImageView(this);
			indicators[j].setImageResource(R.drawable.guide_indicator_unselected);
			indicatorLayout.addView(indicators[j]);
			LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutParams.rightMargin = 25;
			indicators[j].setLayoutParams(layoutParams);

		}
		indicators[0].setImageResource(R.drawable.guide_indicator_selected);
	}
	View view3;
	/**获得view对象**/
	private List<View> getViewList() {
		List<View> views = new ArrayList<View>();
		LayoutInflater inflater = LayoutInflater.from(this);
		views.add(inflater.inflate(R.layout.guid_page1, null));
		views.add(inflater.inflate(R.layout.guid_page2, null));
		view3 = inflater.inflate(R.layout.guid_page3,null);
		views.add(inflater.inflate(R.layout.guid_page3, null));
		views.add(new View(this));
		ViewUtils.inject(this,view3);
		return views;
	}
	int currentPosition;
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {
		// 在有跳转页和空白页的时候 隐藏圆点
		if (position >= views.size() - 2) {
			indicatorLayout.setVisibility(View.GONE);
		} else {
			indicatorLayout.setVisibility(View.VISIBLE);
			indicators[currentPosition].setImageResource(R.drawable.guide_indicator_unselected);
			indicators[position].setImageResource(R.drawable.guide_indicator_selected);
			currentPosition = position;
		}
		if (position == adapter.getCount()-1) {
			gotoMain(enterBt);
		}
	}
	public void gotoMain(View view){
//		Toast.makeText(GuideActivity.this, "去主页", 0).show();
		LogUtils.d("去主页");

		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

}

