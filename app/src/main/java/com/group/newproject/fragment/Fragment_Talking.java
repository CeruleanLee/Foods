package com.group.newproject.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.adapter.SH_ListviewAdapter;
import com.group.newproject.adapter.SH_ViewPagerAdapter;
import com.group.newproject.entity.PopItemForSH;
import com.group.newproject.entity.SH_Entity;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.views.AutoScrollViewPager;
import com.group.newproject.views.GoToTopScrollView;
import com.group.newproject.views.LoadMoreListView;
import com.group.newproject.views.PopWindowForSH;
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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Fragment_食话
 **/
public class Fragment_Talking extends Fragment implements View.OnClickListener{
    @Bind(R.id.shihuaFrag_add)
    ImageView add;
    @Bind(R.id.shihuaFrag_person)
    ImageView person;
    @Bind(R.id.shihuaFrag_search)
    ImageView search;
    @Bind(R.id.shihuaFrag_Listview)
    LoadMoreListView listView;
    @Bind(R.id.shihuaFrag_goToTop)
    ImageView goToTop;
    @Bind(R.id.shihuaFrag_track)
    ImageView track;
//    @Bind(R.id.shihuaFrag_scrollView)
//    GoToTopScrollView scrollView;
    //head1
//    @Bind(R.id.shihuaFrag_viewPager)
    @ViewInject(R.id.shihuaFrag_viewPager)
    AutoScrollViewPager viewpager;
    SH_ListviewAdapter adapter;
    //    @Bind(R.id.shihuaFrag_indicatorContainer)
    @ViewInject(R.id.shihuaFrag_indicatorContainer)
    LinearLayout headIndicatorContainer;//指示器小圆点
    //head2
//    @Bind(R.id.sh_head2_shiguang)
    @ViewInject(R.id.sh_head2_shiguang)
    TextView shiguang;
    //    @Bind(R.id.sh_head2_hongbei)
    @ViewInject(R.id.sh_head2_hongbei)
    TextView hongbei;
    //    @Bind(R.id.sh_head2_ketang)
    @ViewInject(R.id.sh_head2_ketang)
    TextView ketang;
    //    @Bind(R.id.sh_head2_zuiIn)
    @ViewInject(R.id.sh_head2_zuiIn)
    TextView zuiIn;
    @ViewInject(R.id.sh_head2_shiguangImg)
    ImageView shiguangImg;
    @ViewInject(R.id.sh_head2_hongbeiImg)
    ImageView hongbeiImg;
    @ViewInject(R.id.sh_head2_ketangImg)
    ImageView ketangImg;
    @ViewInject(R.id.sh_head2_zuiInImg)
    ImageView zuiInImg;
    //    @Bind(R.id.sh_head2_viewContainer)
    @ViewInject(R.id.sh_head2_viewContainer)
    LinearLayout viewContainer;
    //    @Bind(R.id.shihuaFrag_newestTv)
    @ViewInject(R.id.shihuaFrag_newestTv)
    CheckedTextView newest;
    //    @Bind(R.id.shihuaFrag_hotestTv)
    @ViewInject(R.id.shihuaFrag_hotestTv)
    CheckedTextView hotest;

    private HttpUtils httpUtils;
    List<SH_Entity.HotTopicBean> list;
    private ImageView[] indicators;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talking, null);
        ButterKnife.bind(this, view);
        ViewUtils.inject(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewUtils.inject(getActivity());
        httpUtils = MHttpHolder.getHttpUtils();
        viewpager = (AutoScrollViewPager) getActivity().findViewById(R.id.shihuaFrag_viewPager);
        initView();
        initDatas();
    }

    private void initDatas() {
        if (isLoading) return;
        loadData();
        initPopWindowData();
    }


    BitmapUtils bitmapUtils;

    private void initView() {
        viewpager = (AutoScrollViewPager) getActivity().findViewById(R.id.shihuaFrag_viewPager);
        ViewUtils.inject(getActivity());
        bitmapUtils = MBitmapHolder.getBitmapUtils(getActivity());
        if (listView == null) {
            Toast.makeText(getActivity(), "listview空", Toast.LENGTH_SHORT).show();
            LogUtils.d("listview空");
        } else {
            listView.addHeaderView(getHeader(R.layout.head_shihua1_viewpager));
            listView.addHeaderView(getHeader(R.layout.head_shihua2_icons));
            list = new ArrayList<SH_Entity.HotTopicBean>();
            adapter = new SH_ListviewAdapter(list, getActivity());
            listView.setAdapter(adapter);

            listView.setOnLoadingMoreListener(onLoadingMoreListener);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //TODO 跳转到食话详情
//				Intent intent = new Intent(getActivity(), SH_DetailActivity.class);
//				startActivity(intent);
                }
            });
//            listView.setScrollListener(goToTop);
            add.setOnClickListener(this);
            search.setOnClickListener(this);
            person.setOnClickListener(this);
            shiguang.setOnClickListener(this);
            hongbei.setOnClickListener(this);
            ketang.setOnClickListener(this);
            zuiIn.setOnClickListener(this);
            newest.setOnClickListener(this);
            hongbei.setOnClickListener(this);

            initPopWindow();
//            scrollView.setScrollListener(goToTop);
//            listView.setons
        }
    }
    ViewTreeObserver.OnScrollChangedListener scrollChangedListener=new ViewTreeObserver.OnScrollChangedListener() {
        @Override
        public void onScrollChanged() {

        }
    };

    PopWindowForSH pop;

    /**
     * 初始化PopWionw
     **/
    private void initPopWindow() {
        pop = new PopWindowForSH(getActivity(), ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        add.setOnClickListener(this);
    }

    /**
     * 初始化PopWionw数据
     **/
    private void initPopWindowData() {
        pop.addAction(new PopItemForSH(getActivity(), "发食话", R.drawable.sh_send_topic));
        pop.addAction(new PopItemForSH(getActivity(), "晒作品", R.drawable.sh_show_pic));
        pop.addAction(new PopItemForSH(getActivity(), "赚奖品", R.drawable.sh_zjp));
        pop.addAction(new PopItemForSH(getActivity(), "优惠码", R.drawable.sh_yhm));

    }

    LoadMoreListView.OnLoadingMoreListener onLoadingMoreListener = new LoadMoreListView.OnLoadingMoreListener() {
        @Override
        public void loadMore() {
            loadData();
        }

        @Override
        public void retryMore() {
            loadData();
        }
    };

    /**
     * 获取头部视图
     **/
    private View getHeader(int id) {
        View view = LayoutInflater.from(getActivity()).inflate(id, null);
        ViewUtils.inject(this, view);
        return view;
    }

    int nextpage;

    /**
     * 按键点击监听
     **/
    @Override
    public void onClick(View v) {
        if (v == add) {
            pop.show(v);
        } else if (v == search) {
            //TODO 跳转到搜索页
        } else if (v == person) {
            //TODO 跳转到搜索用户页
        } else if (v == shiguang) {
            Toast.makeText(getActivity(), "跳转到最新最热", Toast.LENGTH_SHORT).show();
        } else if (v == newest) {
            newest.setChecked(true);
            hotest.setChecked(false);
            nextpage = 1;
            adapter.clearDatas();
            loadData();
        } else if (v == hotest) {
            Toast.makeText(getActivity(), "最热", Toast.LENGTH_SHORT).show();
            hotest.setChecked(true);
            newest.setChecked(false);
            nextpage = 1;
        } else {
            for (int i = 0; i < tabs.size(); i++) {
                if (tabs.get(i) == v) {
                    Toast.makeText(getActivity(), "点击了 " + i, Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(this, SHhead2ItemActivity.class);
//                    intent.putExtra("Id", );
//                    intent.putExtra("title", );
//                    startActivity(intent);
                }
            }

        }
    }

    List<String> imgUrlList;

    private void setPagerData(List<SH_Entity.Activities2Bean> imgUrlList) {
        List<ImageView> imgviewList = new ArrayList<ImageView>();
        for (int i = 0; i < imgUrlList.size(); i++) {
            ImageView img = new ImageView(getActivity());
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgviewList.add(img);
        }
        SH_ViewPagerAdapter viewpagerAdapter = new SH_ViewPagerAdapter(getActivity(), imgviewList, imgUrlList);
        viewpager.setAdapter(viewpagerAdapter);
        indicators = new ImageView[imgUrlList.size()];
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getActivity());
            indicators[i].setImageResource(R.drawable.guide_indicator_unselected);
            indicators[i].setPadding(5, 5, 5, 5);
            headIndicatorContainer.addView(indicators[i]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 12;

            indicators[i].setLayoutParams(params);
        }
        indicators[0].setImageResource(R.drawable.guide_indicator_selected);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                indicators[curentPosition].setImageResource(R.drawable.guide_indicator_unselected);
                indicators[position].setImageResource(R.drawable.guide_indicator_selected);
                curentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    int curentPosition;
    boolean isLoading;

    /**
     * 加载第一页数据
     **/
    private void loadData() {
        if (isLoading) {
            return;
        }
        isLoading = true;
        String url = Contants.SHIHUA_QUANZI;
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onFailure(HttpException arg0, String arg1) {
                LogUtils.d("-------------------------------------------------------------------------------------------onFailure");
                listView.loadFailed();
//				if(nextPage == 1){//如果是获取第一页数据失败，就隐藏 正在加载 视图
//					if(!isNoNetwork){
//						mLoadingView.loadFailed();
//					}
//				}
                isLoading = false;
            }

            @Override
            public void onSuccess(ResponseInfo<String> arg0) {
                LogUtils.d("---------------------------------------------------------------------------onSuccess");
                String content = arg0.result;
                LogUtils.d("---------------------------------------------------------------------------onSuccess" + content);
                SH_Entity sh_root = new Gson().fromJson(content, SH_Entity.class);
                List<SH_Entity.Activities2Bean> activities2 = sh_root.activities2;
                setPagerData(activities2);
                List<SH_Entity.ColumnBean> column = sh_root.column;
                setHead2Data(column);
                List<SH_Entity.HotTopicBean> hot_topic = sh_root.hot_topic;
                adapter.addDatas(hot_topic);
                isLoading = false;
//				}
            }
        });
    }

    /**
     * 设置第二个头的数据
     **/
    private void setHead2Data(List<SH_Entity.ColumnBean> column) {
        initHead2Data(viewContainer, column);
    }

    List<View> tabs;
    ImageView[] imgs;
    TextView[] textViews;

    protected void initHead2Data(ViewGroup tabContainer, List<SH_Entity.ColumnBean> column) {
        tabs = new ArrayList<View>();
        imgs = new ImageView[]{shiguangImg, hongbeiImg, ketangImg, zuiInImg};
        textViews = new TextView[]{shiguang, hongbei, ketang, zuiIn};
        for (int i = 0; i < tabContainer.getChildCount(); i++) {
            ViewGroup viewGroup = (ViewGroup) tabContainer.getChildAt(i);
            for (int j = 0; j < viewGroup.getChildCount(); j++) {
                if (viewGroup.getChildAt(j) instanceof ImageView) {
                    if (imgs[i] == null) {
                        LogUtils.d("--------------------------------------------img[]空" + i);
                    } else {
                        LogUtils.d("-------------------------------------------column.get(i).img" + column.get(i).img);
                        bitmapUtils.display(imgs[i], column.get(i).img);
                    }
                }
                if (viewGroup.getChildAt(j) instanceof TextView) {
                    textViews[i].setText(column.get(i).name);
                }
            }
            tabs.add(viewGroup);
            tabs.get(i).setOnClickListener(this);
        }
    }

    public synchronized Drawable byteToDrawable(String icon) {

        byte[] img = Base64.decode(icon.getBytes(), Base64.DEFAULT);
        Bitmap bitmap;
        if (img != null) {


            bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bitmap);

            return drawable;
        }
        return null;

    }

    public synchronized String drawableToByte(Drawable drawable) {

        if (drawable != null) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            int size = bitmap.getWidth() * bitmap.getHeight() * 4;

            // 创建一个字节数组输出流,流的大小为size
            ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
            // 设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            // 将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();

            String icon = Base64.encodeToString(imagedata, Base64.DEFAULT);
            return icon;
        }
        return null;
    }

    @Override
    public void onPause() {
        super.onPause();
        viewpager.stopTask();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}