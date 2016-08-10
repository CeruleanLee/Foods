package com.group.newproject.activity;


import com.group.newproject.utils.AppSharedPreference;
import com.group.tastyfoods.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity{
	private boolean isFinish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		new Thread(){
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(isFinish){
					return;
				}
				if(isFirstRun()){
					startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
				}else{
					startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
				}
				finish();
			};
		}.start();
	}
	
	/**是否第一次运行**/
	private boolean isFirstRun(){
		boolean isFirstRun = AppSharedPreference.getValue(getApplicationContext(), "app", "is_first_run", true);
		if(isFirstRun){
			AppSharedPreference.putValue(getApplicationContext(), "app", "is_first_run", false);
		}
		return isFirstRun;
	}
	
	
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		isFinish = true;
	}
}
