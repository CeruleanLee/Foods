package com.group.newproject.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment{
	protected boolean isInitData;
	protected abstract void initData();
	protected abstract void initViews();
	protected View findViewById(int id) {
		return getView().findViewById(id);
	}
}
