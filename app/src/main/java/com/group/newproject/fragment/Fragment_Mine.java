package com.group.newproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group.newproject.activity.LoginAndRegisterActivity;
import com.group.newproject.activity.SerchActivity;
import com.group.tastyfoods.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class Fragment_Mine extends Fragment{
//@ViewInject(R.id.fragment_mine_title)
private View mTitleLayout;//顶部容器
//	@ViewInject(R.id.fragment_mine_messge_notes)
	private View mImgButn;//临时用来跳转搜索页面
//	@OnClick({R.id.fragment_mine_title,R.id.fragment_mine_messge_notes})
//	public void onClick(View view){
//		if (view == mTitleLayout){
//			startActivity(new Intent(getActivity(), LoginAndRegisterActivity.class));
//		}else if(view == mImgButn){
//			startActivity(new Intent(getActivity(), SerchActivity.class));
//		}
//	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_mine, null);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ViewUtils.inject(this,getView());


	}
	
	
	
}
