package com.group.newproject.fragment;


import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.activity.FindCityActivity;
import com.group.newproject.adapter.FindListViewAdapter;
import com.group.newproject.entity.FindResponse;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.utils.UrlHandler;
import com.group.tastyfoods.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Find extends Fragment implements View.OnClickListener {
	private ListView mListView;
	private HttpUtils mHttpUtils;
	private FindListViewAdapter mListViewAdapter;
	private TextView mTv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_find, null);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
		initDatas();
	}

	private void initView() {
		mHttpUtils = MHttpHolder.getHttpUtils();
		mListView = (ListView) getActivity().findViewById(R.id.f_listView);
		mTv = (TextView) getActivity().findViewById(R.id.f_tv_city);
		mTv.setOnClickListener(this);
		List<FindResponse.FaxianListBean> datas = new ArrayList<FindResponse.FaxianListBean>();
		mListViewAdapter = new FindListViewAdapter(datas,getActivity());
		mListView.addHeaderView(getHeadView());
		mListView.setAdapter(mListViewAdapter);
	}

	//请求网络数据
	public void initDatas(){
		String url = UrlHandler.handlUrl(Contants.FAXIAN,"json",510100);

		mHttpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String content = responseInfo.result;

				FindResponse findResponse = new Gson().fromJson(content, FindResponse.class);
				mListViewAdapter.addDatas(findResponse.getFaxian_list());
			}

			@Override
			public void onFailure(HttpException e, String s) {

			}
		});
	}
	//加载一个头部视图
	public View getHeadView(){
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.find_lv_headitem,null);
		return view;
	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent(getActivity(), FindCityActivity.class);
		startActivity(intent);
	}
}
