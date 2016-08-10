package com.group.newproject.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.activity.ClassifyActivity;
import com.group.newproject.adapter.GuessGridViewAdapter;
import com.group.newproject.adapter.TJHeadViewAdapter;
import com.group.newproject.adapter.Top3ViewPagerAdapter;
import com.group.newproject.adapter.Top4ViewPagerAdapter;
import com.group.newproject.entity.Guess;
import com.group.newproject.entity.Home;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.views.AutoScrollViewPager;
import com.group.newproject.views.GridViewWithHeaderAndFooter;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
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

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Fragment_Recommend extends Fragment implements ViewPager.OnPageChangeListener, AbsListView.OnScrollListener {

    @ViewInject(R.id.recipe_Category_img)
    ImageView recipeCategoryImg;
    @ViewInject(R.id.home_column_layout1)
    LinearLayout homeColumnLayout1;
    @ViewInject(R.id.recipe_media_img)
    ImageView recipeMediaImg;
    @ViewInject(R.id.home_column_layout2)
    LinearLayout homeColumnLayout2;
    @ViewInject(R.id.recipe_brea_img)
    ImageView recipeBreaImg;
    @ViewInject(R.id.home_column_layout3)
    LinearLayout homeColumnLayout3;
    @ViewInject(R.id.recipe_surrounding_img)
    ImageView recipeSurroundingImg;
    @ViewInject(R.id.home_column_layout4)
    LinearLayout homeColumnLayout4;
    @ViewInject(R.id.tj_top)
    ImageView tjTop;
    @ViewInject(R.id.tj_zucai)
    ImageView tjZucai;
    @ViewInject(R.id.recipe_text)
    TextView recipeText;
    @ViewInject(R.id.media_text)
    TextView mediaText;
    @ViewInject(R.id.brea_text)
    TextView breaText;
    @ViewInject(R.id.surrounding_text)
    TextView surroundingText;
    @ViewInject(R.id.tj_hot_viewpager)
    AutoScrollViewPager tjHotViewpager;
    @ViewInject(R.id.tj_got_width)
    ImageView tjGotWidth;
    @ViewInject(R.id.tj_hot_left_img1)
    ImageView tjHotLeftImg1;
    @ViewInject(R.id.tj_hot_left_tv1)
    TextView tjHotLeftTv1;
    @ViewInject(R.id.tj_hot_left_price1)
    TextView tjHotLeftPrice1;
    @ViewInject(R.id.tj_hot_left_layout1)
    RelativeLayout tjHotLeftLayout1;
    @ViewInject(R.id.tj_hot_left_img2)
    ImageView tjHotLeftImg2;
    @ViewInject(R.id.tj_hot_left_tv2)
    TextView tjHotLeftTv2;
    @ViewInject(R.id.tj_hot_left_price2)
    TextView tjHotLeftPrice2;
    @ViewInject(R.id.tj_hot_left_layout2)
    RelativeLayout tjHotLeftLayout2;
    @ViewInject(R.id.tj_hot_right_img1)
    ImageView tjHotRightImg1;
    @ViewInject(R.id.tj_hot_right_tv1)
    TextView tjHotRightTv1;
    @ViewInject(R.id.tj_hot_right_price1)
    TextView tjHotRightPrice1;
    @ViewInject(R.id.tj_hot_right_layout1)
    RelativeLayout tjHotRightLayout1;
    @ViewInject(R.id.tj_hot_right_img2)
    ImageView tjHotRightImg2;
    @ViewInject(R.id.tj_hot_right_tv2)
    TextView tjHotRightTv2;
    @ViewInject(R.id.tj_hot_right_price2)
    TextView tjHotRightPrice2;
    @ViewInject(R.id.tj_hot_right_layout2)
    RelativeLayout tjHotRightLayout2;
    @ViewInject(R.id.tj_today_dialog)
    ImageView tjTodayDialog;
    @ViewInject(R.id.today_img1)
    ImageView todayImg1;
    @ViewInject(R.id.today_img_layout1)
    RelativeLayout todayImgLayout1;
    @ViewInject(R.id.today_img2)
    ImageView todayImg2;
    @ViewInject(R.id.today_img_layout2)
    RelativeLayout todayImgLayout2;
    @ViewInject(R.id.today_img3)
    ImageView todayImg3;
    @ViewInject(R.id.today_img_layout3)
    RelativeLayout todayImgLayout3;
    @ViewInject(R.id.tj_today_viewpager)
    AutoScrollViewPager tjTodayViewpager;
    @ViewInject(R.id.tj_today_indiacateConrainer)
    LinearLayout tjTodayIndiacateConrainer;
    @ViewInject(R.id.tj_msg)
    private ImageView tj_msg;
    @ViewInject(R.id.searh_cancel)
    private TextView tj_searh_cancel;
    @ViewInject(R.id.tj_serch_del)
    private ImageView tj_serch_del;
    @ViewInject(R.id.tj_edittext)
    private EditText tj_edittext;
    @ViewInject(R.id.recommend_menu_tab)
    private ImageView tj_recommend_menu_tab;
    @ViewInject(R.id.tj_grideview)
    private ListView mGridView;
    @ViewInject(R.id.back_top)
    private ImageView back_top;
    @ViewInject(R.id.guess_update_tv)
    private TextView tj_guess_update_tv;
    private BitmapUtils bitmapUtils;
    private HttpUtils httpUtils;
    private PopupWindow popupWindow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, null);
//        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        httpUtils = MHttpHolder.getHttpUtils();
        bitmapUtils = MBitmapHolder.getBitmapUtils(getActivity());
        initView();
        initDatas();
    }

    /**
     * 初始化数据
     **/
    private void initDatas() {
        //初始化gridview 数据
        initListViewDatas();

        //请求网络数据 获取Home头部等的数据
        httpUtils.send(HttpRequest.HttpMethod.GET, Contants.HOME, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                try {
                    if (!TextUtils.isEmpty(responseInfo.result)) {
                        String result = responseInfo.result;
                        Home.ObjBean objBean = new Gson().fromJson(result, Home.class).getObj();
                        Toast.makeText(getActivity(), "网络请求成功", Toast.LENGTH_SHORT).show();
                        initRepastDatas(objBean);
                        initColumnImageDatas(objBean);
                        initHotViewDatas(objBean);
                        initTodayDatas(objBean);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(), "网络请求失败", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private GuessGridViewAdapter guessGridViewAdapter;
    private void initListViewDatas() {
        httpUtils.send(HttpRequest.HttpMethod.GET, Contants.HOME2, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                try {
                    if(!TextUtils.isEmpty(responseInfo.result)){
                        Guess.ObjBean.CustomizedBean guess = new Gson().fromJson(responseInfo.result, Guess.class).getObj().getCustomized();
                        List<Guess.ObjBean.CustomizedBean.DataBean> dataBeen = guess.getData();
                        tj_guess_update_tv.setText(guess.getTime());
//                        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, lists);
                        guessGridViewAdapter = new GuessGridViewAdapter(dataBeen,getActivity());
                        mGridView.setAdapter(guessGridViewAdapter);
                        mGridView.setOnScrollListener(Fragment_Recommend.this);
                    }


                }catch (Exception e){
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
//        List<String> lists = new ArrayList<String>();
//        for (int i = 0; i < 50; i++) {
//            lists.add("测试" + i);
//        }

    }


    /**
     * 初始化viewpager数据
     */


    private TJHeadViewAdapter myHeaderViewPagerAdapter;
    private List<View> viewGroup;

    //初始化获取首页viewpager数据
    private void initRepastDatas(Home.ObjBean objBean) {
        List<Home.ObjBean.SanCanBean> datas = objBean.getSan_can();
        List<Home.ObjBean.SanCanTitlesBean> datas2 = objBean.getSan_can_titles();
        viewGroup = new ArrayList<View>();
        for (int i = 0; i < datas2.size(); i++) {
            View layout = LayoutInflater.from(getActivity()).inflate(R.layout.head_viewpager_breakfast, null);
            View view = layout.findViewById(R.id.home_head_viewpager_layout);
            LogUtils.d("加载view视图");
            viewGroup.add(view);
        }
        myHeaderViewPagerAdapter = new TJHeadViewAdapter(viewGroup, datas, getActivity(), datas2);
        mViewPager.setAdapter(myHeaderViewPagerAdapter);
        mViewPager.setOnPageChangeListener(this);
        initIndicateContainer(datas2.size());
        Toast.makeText(getActivity(), "setadap成功", Toast.LENGTH_SHORT).show();
    }


    /**
     * 初始化fragment_reconmmend控件
     **/
    private void initView() {
        initPopupWindow();
        ViewUtils.inject(this, getView());
        //mgridview添加第一个头部（viewpager）
        mGridView.addHeaderView(getHeaderViewPager());
        //mgridview添加第二个头部（菜谱分类等）
        mGridView.addHeaderView(getColumnView());
        //mgridview添加第三个头部（最热商品等）
        mGridView.addHeaderView(getHotView());
        //mgridview添加第四个头部（猜你喜欢等）
        mGridView.addHeaderView(getTodayView());
        //mgridview添加脚部（反馈）
        mGridView.addFooterView(getFooterView());
        //设置edittext不可编辑
        tj_edittext.setFocusable(false);
        tj_edittext.setFocusableInTouchMode(false);
        //设置edittext可编辑
//		tj_edittext.setFocusable(true);
//		tj_edittext.setFocusableInTouchMode(true);


    }

    private void initPopupWindow() {

    }

    @ViewInject(R.id.tellUsReason)
    private TextView tellUs;
    private View getFooterView() {
       View view =  LayoutInflater.from(getActivity()).inflate(R.layout.home_footer,null);
        ViewUtils.inject(this,view);
        return view;
    }


    private int curentIndex = 0;
    private ImageView[] mIndicators;

    private void initIndicateContainer(int size) {
        mIndicators = new ImageView[size];

        getIndiacators(size,indicateContainer,mIndicators);

    }

    private void getIndiacators(int size,ViewGroup indicateContainer,ImageView[] mIndicators) {

        if(size==1){
            return;
        }
        for (int i = 0; i < size; i++) {
            mIndicators[i] = new ImageView(getActivity());
            mIndicators[i].setImageResource(R.drawable.guide_indicator_unselected);
            indicateContainer.addView(mIndicators[i]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 10;
            params.height = 10;
            params.width = 10;
            mIndicators[i].setLayoutParams(params);
            //得到指示器的宽
//			tabWidth = mIndicators[i].getWidth();
//			LinearLayout.LayoutParams params =  (LinearLayout.LayoutParams) mline.getLayoutParams();
//			params.width = tabWidth;
//			mline.setLayoutParams(params);
        }
//		mIndicators[i].setImageResource(R.drawable.guide_indicator_selected);
        //得到viewpager一页的宽
//		myViewPagerWidth = mViewPager.getWidth();
        //原指示器设置图片切换
        mIndicators[0].setImageResource(R.drawable.guide_indicator_selected);
    }


    private int tabWidth;
    private int myViewPagerWidth;

    @ViewInject(R.id.indicateContainer)
    private LinearLayout indicateContainer;
    @ViewInject(R.id.home_head_viewPager)
    private ViewPager mViewPager;

    /**
     * 加载主视图头部切割图viewpager布局
     **/
    private View getHeaderViewPager() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_head_viewpager, null);
        ViewUtils.inject(this, view);
        return view;

    }

    private int currentIndex;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//		int myTabScrollX = l*(mTabs_container.getWidth()-mHScrollView.getWidth())/(myViewPagerWidth*3);
//		int lineScrollX = -l*tabWidth/myViewPagerWidth;
//		lineScrollX = lineScrollX+myTabScrollX;
//		mIndicators[5].scrollTo(lineScrollX, 0);


    }

    @Override
    public void onPageSelected(int position) {
        mIndicators[currentIndex].setImageResource(R.drawable.guide_indicator_unselected);
        mIndicators[position].setImageResource(R.drawable.guide_indicator_selected);
        currentIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    //得到第二个头部视图（菜谱分类...）
    public View getColumnView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_column, null);
        ViewUtils.inject(this, view);
        return view;
    }

    //初始化菜谱分类、视频菜谱、早餐、附近数据
    private void initColumnImageDatas(Home.ObjBean objBean) {
        List<Home.ObjBean.FenleiBean> fenleiBean = objBean.getFenlei();
        Home.ObjBean.Func1Bean func1Bean = objBean.getFunc1();
        Home.ObjBean.Func2Bean func2Bean = objBean.getFunc2();
        recipeText.setText(fenleiBean.get(0).getTitle());
        mediaText.setText(fenleiBean.get(1).getTitle());
        breaText.setText(fenleiBean.get(2).getTitle());
        surroundingText.setText(fenleiBean.get(3).getTitle());
        bitmapUtils.display(recipeCategoryImg, fenleiBean.get(0).getImage());
        bitmapUtils.display(recipeMediaImg, fenleiBean.get(1).getImage());
        bitmapUtils.display(recipeBreaImg, fenleiBean.get(2).getImage());
        bitmapUtils.display(recipeSurroundingImg, fenleiBean.get(3).getImage());
        bitmapUtils.display(tjTop, func1Bean.getImage());
        bitmapUtils.display(tjZucai, func2Bean.getImage());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //主页click监听

    @com.lidroid.xutils.view.annotation.event.OnClick({R.id.tj_got_width, R.id.tj_hot_left_layout1, R.id.tj_hot_left_layout2, R.id.tj_hot_right_layout1
            , R.id.tj_hot_right_layout2, R.id.home_column_layout1, R.id.home_column_layout2, R.id.home_column_layout3
            , R.id.home_column_layout4, R.id.tj_top, R.id.tj_zucai,R.id.today_img_layout1, R.id.today_img_layout2
            , R.id.today_img_layout3,R.id.tellUsReason,R.id.back_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_column_layout1:
                Intent intent = new Intent(getActivity(), ClassifyActivity.class);
                startActivity(intent);
                break;
            case R.id.home_column_layout2:
                break;
            case R.id.home_column_layout3:
                break;
            case R.id.home_column_layout4:
                break;
            case R.id.tj_top:
                break;
            case R.id.tj_zucai:
                break;
            case R.id.tj_got_width:
                break;
            case R.id.tj_hot_left_layout1:
                break;
            case R.id.tj_hot_left_layout2:
                break;
            case R.id.tj_hot_right_layout1:
                break;
            case R.id.tj_hot_right_layout2:
                break;
            case R.id.today_img_layout1:
                break;
            case R.id.today_img_layout2:
                break;
            case R.id.today_img_layout3:
                break;
            case R.id.tellUsReason:
                break;
            case R.id.back_top:
                mGridView.setSelection(0);
                back_top.setVisibility(View.GONE);
                break;
        }
    }

    //得到hotview
    public View getHotView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hot, null);
        ViewUtils.inject(this, view);
        return view;
    }

    //初始化hotview数据
    private void initHotViewDatas(Home.ObjBean objBean) {
        List<Home.ObjBean.Top3Bean> top3Been = objBean.getTop3();
        List<Home.ObjBean.ShopsBean> shopsBeen = objBean.getShops();

        initTop3Data(top3Been);
        bitmapUtils.display(tjHotLeftImg1, shopsBeen.get(0).getImage());
        bitmapUtils.display(tjHotLeftImg2, shopsBeen.get(2).getImage());
        bitmapUtils.display(tjHotRightImg1, shopsBeen.get(1).getImage());
        bitmapUtils.display(tjHotRightImg2, shopsBeen.get(3).getImage());
        tjHotLeftTv1.setText(shopsBeen.get(0).getTitle());
        tjHotLeftPrice1.setText("￥" + shopsBeen.get(0).getPrice() + "/" + shopsBeen.get(0).getGuige());
        tjHotLeftTv2.setText(shopsBeen.get(2).getTitle());
        tjHotLeftPrice2.setText("￥" + shopsBeen.get(2).getPrice() + "/" + shopsBeen.get(2).getGuige());
        tjHotRightTv1.setText(shopsBeen.get(1).getTitle());
        tjHotRightPrice1.setText("￥" + shopsBeen.get(1).getPrice() + "/" + shopsBeen.get(1).getGuige());
        tjHotRightTv2.setText(shopsBeen.get(3).getTitle());
        tjHotRightPrice2.setText("￥" + shopsBeen.get(3).getPrice() + "/" + shopsBeen.get(3).getGuige());
    }

    private int currentIndexTop3;
    private Top3ViewPagerAdapter top3ViewPagerAdapter;
    //初始化top3 viewpager的数据
    private void initTop3Data(List<Home.ObjBean.Top3Bean> top3Been) {
        List<ImageView> views = new ArrayList<ImageView>();
        for (int i = 0; i < top3Been.size(); i++) {
            ImageView view = new ImageView(getActivity());
            views.add(view);
        }
        top3ViewPagerAdapter = new Top3ViewPagerAdapter(views,getActivity(),top3Been);
        tjHotViewpager.setAdapter(top3ViewPagerAdapter);
        tjHotViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                top3Indiacators[currentIndexTop3].setImageResource(R.drawable.guide_indicator_unselected);
                top3Indiacators[position].setImageResource(R.drawable.guide_indicator_selected);
                currentIndexTop3 = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        iniTop3Indiacate(top3Been.size());

    }

    private ImageView[] top3Indiacators;
    //top3指示器
    @ViewInject(R.id.tj_got_indiacateConrainer)
    private LinearLayout tj_got_indiacateConrainer;
    private void iniTop3Indiacate(int size) {
        top3Indiacators = new ImageView[size];
        getIndiacators(size,tj_got_indiacateConrainer,top3Indiacators);
    }
    //top4指示器
    private ImageView[] top4Indiacators;
    @ViewInject(R.id.tj_today_indiacateConrainer)
    private LinearLayout tj_today_indiacateConrainer;
    private void iniTop4Indiacate(int size) {
        top4Indiacators = new ImageView[size];
        getIndiacators(size,tj_today_indiacateConrainer,top4Indiacators);
    }

    //得到今日推荐view
    public View getTodayView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tj_today, null);
        ViewUtils.inject(this, view);
        return view;
    }

    //初始化today view数据
    private void initTodayDatas(Home.ObjBean objBean) {
        List<Home.ObjBean.Top4Bean> top4Been  = objBean.getTop4();
        List<Home.ObjBean.ZtBean> ztBeen = objBean.getZt();
        initTop4Data(top4Been);

        bitmapUtils.display(todayImg1,ztBeen.get(0).getPhoto());
        bitmapUtils.display(todayImg2,ztBeen.get(1).getPhoto());
        bitmapUtils.display(todayImg3,ztBeen.get(2).getPhoto());

    }

    private Top4ViewPagerAdapter top4ViewPagerAdapter;
    //初始化top4 viewpager的数据

    private int currentIndexTop4;
    private void initTop4Data(List<Home.ObjBean.Top4Bean> top4Been) {
        List<ImageView> views = new ArrayList<ImageView>();
        for (int i = 0; i < top4Been.size(); i++) {
            ImageView view = new ImageView(getActivity());
            views.add(view);
        }
        top4ViewPagerAdapter = new Top4ViewPagerAdapter(views,getActivity(),top4Been);
        tjTodayViewpager.setAdapter(top4ViewPagerAdapter);
        tjTodayViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                top4Indiacators[currentIndexTop4].setImageResource(R.drawable.guide_indicator_unselected);
                top4Indiacators[position].setImageResource(R.drawable.guide_indicator_selected);
                currentIndexTop4 = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        iniTop4Indiacate(top4Been.size());

    }

    private int lastPosition;
    //监听gridview的滚动
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        LogUtils.d(firstVisibleItem+"  ,"+lastPosition);
        if(firstVisibleItem<lastPosition){
            if(firstVisibleItem==0){
                back_top.setVisibility(View.GONE);

                lastPosition = firstVisibleItem;
                return;
            }
            if(firstVisibleItem!=lastPosition){

                AnimationSet set = new AnimationSet(true);
                TranslateAnimation animation1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0
                        ,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,1.5f);
                set.addAnimation(animation1);
                set.setDuration(500);
                back_top.startAnimation(set);
                back_top.setVisibility(View.VISIBLE);
            }

        }else if(firstVisibleItem>lastPosition){
            if(firstVisibleItem!=lastPosition){

//                AnimationSet set = new AnimationSet(true);
//                TranslateAnimation animation1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0
//                        ,Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,0f);
//                set.addAnimation(animation1);
//                set.setDuration(1000);
//                back_top.startAnimation(set);
            }
            back_top.setVisibility(View.GONE);
        }
        lastPosition = firstVisibleItem;
    }
}