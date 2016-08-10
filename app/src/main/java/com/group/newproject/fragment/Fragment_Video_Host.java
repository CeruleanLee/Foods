package com.group.newproject.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.activity.PlayVideoActivity;
import com.group.newproject.adapter.VideoPlayFragmentAdapter;
import com.group.newproject.entity.VideoLast;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.utils.UrlHandler;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yp on 2016/7/28.
 */
public class Fragment_Video_Host extends LazyLoadFragment {
    private View contentView;
    private HttpUtils mHttpUtils;
    private VideoPlayFragmentAdapter mAdapter;
    private List<VideoLast.ObjBean.VideoListBean> mlist;
    @ViewInject(R.id.vedio_host_geridview)
    private LoadmoreGridView mGridView;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        contentView = LayoutInflater.from(activity).inflate(R.layout.fragment_vedio_host, null);
        mHttpUtils = MHttpHolder.getHttpUtils();
        initViews();
    }

    private void initViews() {
        ViewUtils.inject(this, contentView);
        mlist = new ArrayList<VideoLast.ObjBean.VideoListBean>();
        mAdapter = new VideoPlayFragmentAdapter(mlist,getActivity());
        mGridView.setAdapter(mAdapter);
        mGridView.setOnLoadingMoreListener(onLoadingMoreListener);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlayVideoActivity.class);
                intent.putExtra("vurl",mAdapter.getItem(position).getVurl());
                startActivity(intent);
            }
        });
    }

    LoadmoreGridView.OnLoadingMoreListener onLoadingMoreListener = new LoadmoreGridView.OnLoadingMoreListener() {

        @Override
        public void retryMore() {
            initData();
        }

        @Override
        public void loadMore() {
            initData();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return contentView;
    }

    @Override
    protected void lazyLoad() {
        initData();
    }

    protected void initData() {
        initHeadViewPagerDatas();
    }

    private int nextPage = 1;
    private boolean isLoading;
    String urls = Contants.VEDIO_HOST;
    private void initHeadViewPagerDatas() {
        if(isLoading){
            return;
        }
        isLoading = true;
        String url = UrlHandler.handlUrl(urls, nextPage);
        mHttpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String content = responseInfo.result;
                //加载主要数据
                VideoLast last = new Gson().fromJson(content,VideoLast.class);
                List<VideoLast.ObjBean.VideoListBean> list = last.getObj().getVideo_list();
                mAdapter.addDatas(list);
                if(nextPage == 1){
                    mGridView.showFooterView();
                }
                nextPage++;
                mGridView.loadSuccess();
                LogUtils.d(nextPage+"我出去了-------");
                isLoading = false;
            }

            @Override
            public void onFailure(HttpException e, String s) {
                mGridView.loadFailed();
                LogUtils.d("第"+nextPage+"页加载失败");
                Toast.makeText(getActivity(),"吃得太撑了，歇一歇吧~",Toast.LENGTH_LONG).show();
                isLoading = false;
            }
        });
    }
}
