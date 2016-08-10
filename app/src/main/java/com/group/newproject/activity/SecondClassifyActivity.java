package com.group.newproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.group.newproject.adapter.SecondFenLeiGridViewAdapter;
import com.group.newproject.entity.CateCateEntities;
import com.group.newproject.views.MyGridView;
import com.group.tastyfoods.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gt72 on 2016-08-02.
 */

public class SecondClassifyActivity extends Activity implements View.OnClickListener {
    @ViewInject(R.id.erji_fenlei_back)
    private ImageView back;
    @ViewInject(R.id.erji_fenlei_title)
    private TextView mTitle;
    private Intent intent;
    private String title1;
    private List<CateCateEntities> ds;
    @ViewInject(R.id.erji_fenlei_container)
    private LinearLayout container;
    private String fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shicai_erji_fenlei);
        intent = getIntent();
        title1 = intent.getStringExtra("title");
        ds = (List<CateCateEntities>) intent.getSerializableExtra("ds");
        fruit = intent.getStringExtra("fruit");
        initViews();
        initDatas();
    }

    private void initDatas() {

        initGridViewDatas();

    }

    private TextView mTitleTv;
    private MyGridView mGridView;
    private SecondFenLeiGridViewAdapter secondFenLeiGridViewAdapter;
    private List<Integer> hs;
    //初始化二级分类
    private void initGridViewDatas() {
        hs = new ArrayList<Integer>();
        LogUtils.d(ds.size()+"size");
        if(fruit.equals("水果")){
            View view = LayoutInflater.from(this).inflate(R.layout.erji_fenlei_item, null);
            mGridView = (MyGridView) view.findViewById(R.id.erji_fenlei_gridview);
            mGridView.setNumColumns(4);
            mTitleTv = (TextView) view.findViewById(R.id.erji_fenlei_item_titleTv);
            mTitleTv.setVisibility(View.GONE);
            final List<String> list = new ArrayList<String>();
            for (int j = 0; j < ds.size(); j++) {
                String d2 = ds.get(j).getT();
                list.add(d2);
                if("1".equals(ds.get(j).getH())){
                    hs.add(j);
                }
            }
            secondFenLeiGridViewAdapter = new SecondFenLeiGridViewAdapter(list, this);
            secondFenLeiGridViewAdapter.setHS(hs);
            mGridView.setAdapter(secondFenLeiGridViewAdapter);
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(SecondClassifyActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
                    //TODO 跳转
                }
            });

            container.addView(view);
        }else if(fruit.equals("五谷")){
            for (int i = 0; i <ds.size(); i++) {
                final List<String> list = ds.get(i).getD();
                View view = LayoutInflater.from(this).inflate(R.layout.erji_fenlei_item, null);
                mGridView = (MyGridView) view.findViewById(R.id.erji_fenlei_gridview);
                mGridView.setNumColumns(4);
                mTitleTv = (TextView) view.findViewById(R.id.erji_fenlei_item_titleTv);
                mTitleTv.setVisibility(View.GONE);
                secondFenLeiGridViewAdapter = new SecondFenLeiGridViewAdapter(list, this);
                mGridView.setAdapter(secondFenLeiGridViewAdapter);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(SecondClassifyActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
                        //TODO 跳转
                    }
                });
                container.addView(view);
            }

        } else {
            for (int i = 0; i <ds.size(); i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.erji_fenlei_item, null);
                mTitleTv = (TextView) view.findViewById(R.id.erji_fenlei_item_titleTv);
                mTitleTv.setVisibility(View.VISIBLE);
                mGridView = (MyGridView) view.findViewById(R.id.erji_fenlei_gridview);
                mGridView.setNumColumns(3);
                final String t = ds.get(i).getT();
                final List<String> list = ds.get(i).getD();
                mTitleTv.setText(t);
                secondFenLeiGridViewAdapter = new SecondFenLeiGridViewAdapter(list,this);
                mGridView.setAdapter(secondFenLeiGridViewAdapter);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(SecondClassifyActivity.this,list.get(position),Toast.LENGTH_SHORT).show();
                        //TODO 跳转
                    }
                });
                container.addView(view);
            }

        }

    }

    private void initViews() {
        ViewUtils.inject(this);
        back.setOnClickListener(this);
        Toast.makeText(this,title1,Toast.LENGTH_SHORT).show();
        mTitle.setText(title1);

    }

    @Override
    public void onClick(View v) {
        if(v==back){
            finish();
        }
    }
}
