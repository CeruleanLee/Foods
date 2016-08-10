package com.group.newproject.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.activity.PlayVideoActivity;
import com.group.newproject.adapter.HomeViewPagerAdapter;
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

/**视频最新界面
 * Created by yp on 2016/7/28.
 */
public class Fragment_Video_Last extends LazyLoadFragment{

    private View contentView;
    private HttpUtils mHttpUtils;
    @ViewInject(R.id.vedio_last_geridview)
    private LoadmoreGridView mGridView;
    @ViewInject(R.id.header_viewPager)
    private ViewPager mHeadViewPager;
    @ViewInject(R.id.goods_header_indicatorContainer)
    private LinearLayout mHeadIndicatorContainer;
    private VideoPlayFragmentAdapter mAdapter;
    private List<VideoLast.ObjBean.VideoListBean> mlist;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        contentView = LayoutInflater.from(activity).inflate(R.layout.fragment_vedio_last, null);
        mHttpUtils = MHttpHolder.getHttpUtils();
        initViews();
    }

    private void initViews() {
        ViewUtils.inject(this, contentView);
//        mGridView = (LoadmoreGridView) getView().findViewById(R.id.vedio_last_geridview);
//        mProgressBar = (ViewGroup) findViewById(R.id.last_progressBar);
//        mHeadViewPager = (AutoScrollViewPager) getView().findViewById(R.id.video_last_header_viewPager);
        mlist = new ArrayList<VideoLast.ObjBean.VideoListBean>();
        mAdapter = new VideoPlayFragmentAdapter(mlist,getActivity());
        mGridView.setAdapter(mAdapter);
        mGridView.addHeaderView(getHeader1());
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlayVideoActivity.class);
                intent.putExtra("vurl",mAdapter.getItem(position).getVurl());
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return contentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    String urls = Contants.VEDIO_LAST;
    /**
     * 加载数据
     */
    private void initHeadViewPagerDatas() {
        LogUtils.d(nextPage+"进来了-------");
        if(isLoading){
            return;
        }
        isLoading = true;
        String url = UrlHandler.handlUrl(urls, nextPage);
        LogUtils.d(url+"-------");

        mHttpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> arg0) {
                String content = arg0.result;
                //加载主要数据
                VideoLast last = new Gson().fromJson(content,VideoLast.class);
                List<VideoLast.ObjBean.VideoListBean> list = last.getObj().getVideo_list();
                LogUtils.d(list.toString());
                mAdapter.addDatas(list);
                if(nextPage == 1){
//                    setHeaderViewPagerDatas(content);//加载头部数据
                    mGridView.showFooterView();
                }
                nextPage++;
                mGridView.loadSuccess();
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

    /**作为指示器的那些小圆点**/
    private ImageView[] mIndicators;
    private int mCurPos;
    /**
     * 用数据来填充ViewPager
     * @param content
     */
    protected void setHeaderViewPagerDatas(String content) {
        VideoLast last = new Gson().fromJson(content,VideoLast.class);
        List<VideoLast.ObjBean.AdBean> ad = last.getObj().getAd();
        List<ImageView> imgviewList = new ArrayList<ImageView>();
        for (int i = 0; i < ad.size(); i++) {
            ImageView imgView = new ImageView(getActivity());
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgviewList.add(imgView);
        }
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getActivity(), imgviewList, ad);
//        mHeadViewPager.setAdapter(adapter);
        mIndicators = new ImageView[ad.size()];
        for (int i = 0; i < mIndicators.length; i++) {
            mIndicators[i] = new ImageView(getActivity());
            mIndicators[i].setImageResource(R.drawable.guide_indicator_unselected);
            mHeadIndicatorContainer.addView(mIndicators[i]);
            //布局参数，在使用的时候要根据父容器的类型来选择对应的LayoutParams
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            //TODO  params.rightMargin = 12;
            mIndicators[i].setLayoutParams(params);
        }
        //默认让第一个ImageView选中
        mIndicators[0].setImageResource(R.drawable.guide_indicator_selected);
        mHeadViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicators[mCurPos].setImageResource(R.drawable.guide_indicator_unselected);
                mIndicators[position].setImageResource(R.drawable.guide_indicator_selected);
                mCurPos = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /***
     * 获取第一个头部视图
     * @return
     */
    public View getHeader1() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.v_video_last_header, null);
        ViewUtils.inject(this, view);//初始化头部视图里的控件
        return view;
    }
}