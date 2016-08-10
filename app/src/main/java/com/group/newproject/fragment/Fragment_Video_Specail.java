package com.group.newproject.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.adapter.VideoSpecailFragmentAdapter;
import com.group.newproject.entity.VideoSpecail;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.views.LoadmoreGridView;
import com.group.tastyfoods.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * 视频专辑界面
 * Created by yp on 2016/7/28.
 */
public class Fragment_Video_Specail extends LazyLoadFragment{

    private HttpUtils mHttpUtils;
    private View contentView;
    @ViewInject(R.id.vedio_special_geridview)
    private LoadmoreGridView mGridView;
    private VideoSpecailFragmentAdapter mAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        contentView = LayoutInflater.from(activity).inflate(R.layout.fragment_vedio_special, null);
        mHttpUtils = MHttpHolder.getHttpUtils();
        initViews();
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        ViewUtils.inject(this, contentView);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),mAdapter.getItem(position).getId(),Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return contentView;
    }

    @Override
    protected void lazyLoad() {
        initData();
    }

    private String url = Contants.VEDIO_SPECIAL;
    private boolean isLoading;
    /**
     * 加载数据
     */
    protected void initData() {
        if(isLoading){
            return;
        }
        isLoading = true;
        mHttpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                VideoSpecail specail = new Gson().fromJson(result,VideoSpecail.class);
                List<VideoSpecail.ObjBean.RecommendListBean> list
                        = specail.getObj().getRecommend_list();
                mAdapter = new VideoSpecailFragmentAdapter(list,getActivity());
                mGridView.showFooterView();
                mGridView.setAdapter(mAdapter);
                mGridView.setNoMore();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                mGridView.loadFailed();
                Toast.makeText(getActivity(),"吃得太撑了，歇一歇吧~",Toast.LENGTH_LONG).show();
                isLoading = false;
            }
        });
    }
}
