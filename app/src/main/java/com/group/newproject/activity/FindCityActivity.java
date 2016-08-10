package com.group.newproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.group.newproject.Contants;
import com.group.newproject.adapter.CityAtyAdapter;
import com.group.newproject.entity.CityGuide;
import com.group.newproject.utils.CityLetterSort;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.utils.UnicodeDecode;
import com.group.newproject.utils.UrlHandler;
import com.group.newproject.views.LettersView;
import com.group.tastyfoods.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
public class FindCityActivity extends Activity implements  AdapterView.OnItemClickListener, LettersView.OnLettersSelectChangeListener, AbsListView.OnScrollListener {
    private ListView mListView;
    private HttpUtils mHttpUtils;
    private CityAtyAdapter mAdapter;
    private LettersView mLettersVeiw;
    private  List<CityGuide.CityAllBean> city_all;
    private TextView mOverlayTv;
    private ViewGroup mLayoutOverlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcity);
        mListView = (ListView) findViewById(R.id.city_lv);
        mLettersVeiw = (LettersView) findViewById(R.id.city_letterview);
        mOverlayTv = (TextView) findViewById(R.id.ovry);
        mLettersVeiw.setOnLettersSelectChangeListener(this);
        mLayoutOverlay = (ViewGroup) findViewById(R.id.linearlayout_ovry);
        List<CityGuide.CityAllBean> datas = new ArrayList<CityGuide.CityAllBean>();
        List<String>  letters = new ArrayList<String>();
        mAdapter = new CityAtyAdapter(datas,this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        mListView.setOnScrollListener(this);
        mHttpUtils = MHttpHolder.getHttpUtils();
        initDatas();
    }
    private void initDatas(){
        String url = UrlHandler.handlUrl(Contants.CITY_ALL,"json");
        mHttpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                String result = responseInfo.result;
                Log.d("ff", UnicodeDecode.uncodeToUtf_8(result));

                CityGuide cityGuide = new Gson().fromJson(result, CityGuide.class);
                city_all = cityGuide.getCity_all();
                CityLetterSort.getSortList(city_all);

                mAdapter.addDatas(city_all);
            }
            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }


    //监听Item的点击
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onLettersSelectChange(int index, String letter) {

        mListView.setSelection(getPositonFromLettersView(letter));
    }

    private int getPositonFromLettersView(String letter) {
        for (int i = 0; i < city_all.size(); i++) {
            if (letter.equals(city_all.get(i).getPinyin())){
                return i;
            }
        }
        return -1;
    }

    //listView 滑动
    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

        if (city_all!=null) {
            String letter = city_all.get(i).getPinyin();
            Log.d("letter",letter);
            mLettersVeiw.changeLetter(letter);

            int nextPosition = i + 1;
            //下一个item所在的分组
            String title = getSelectionFromPosition(nextPosition);
            if(getPositonFromLettersView(title) == nextPosition){
                View v = mListView.getChildAt(0);
                int offsetY = v.getBottom()-mOverlayTv.getHeight();
                if(offsetY < 0){
                    mLayoutOverlay.setPadding(0, offsetY, 0, 0);
                }else{
                    mLayoutOverlay.setPadding(0, 0, 0, 0);
                }
            }else{
                mLayoutOverlay.setPadding(0, 0, 0, 0);
            }
            mOverlayTv.setText(letter+"");
        }
    }
    private String getSelectionFromPosition(int position){
        return city_all.get(position).getPinyin();
    }
}

