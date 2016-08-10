package com.group.newproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group.newproject.adapter.FenLeiGridViewAdapter;
import com.group.newproject.adapter.FenLeiListViewAdapter;
import com.group.newproject.entity.CateCateEntities;
import com.group.newproject.entity.CateEntities;
import com.group.newproject.entity.CategotyRoot;
import com.group.tastyfoods.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gt72 on 2016-08-02.
 */
public class ClassifyActivity extends Activity implements FenLeiListViewAdapter.OnCheckedListener, AdapterView.OnItemClickListener, View.OnClickListener {

    @ViewInject(R.id.fenlei_gridview)
    private GridView gridView;
    @ViewInject(R.id.recipe_fenlei_listview)
    private ListView listView;
    @ViewInject(R.id.fenlei_back)
    private ImageView back;
    @ViewInject(R.id.fenlei_edittext)
    private EditText search;
    private String json;
    private FenLeiListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_fenlei);
        initMainView();
        initMainDatas();
    }

    private void initMainDatas() {
        BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.category)));

        String line ;

        StringBuffer sb = new StringBuffer();

        try {
            while ((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            json = sb.toString();
//            LogUtils.d(json);
//            List<CategotyRoot> categotyRoots = JSON.parseArray(json, (Class<CategotyRoot>) new TypeToken<List<CategotyRoot>>() {
//            }.getType());

            List<CategotyRoot> categotyRoot = new Gson().fromJson(json, new TypeToken<List<CategotyRoot>>() {}.getType());
            List<CateEntities> d = categotyRoot.get(3).getD();
            String t = categotyRoot.get(3).getT();
            listViewAdapter = new FenLeiListViewAdapter(categotyRoot,this);
            listViewAdapter.setIsCheckedPosition(3);
            initGridViewDatas(d, t);
            listView.setAdapter(listViewAdapter);
            listViewAdapter.setOnCheckedlistener(this);
            listView.setOnItemClickListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initMainView() {
        ViewUtils.inject(this);
        back.setOnClickListener(this);


        //TODO 设置edittext不可编辑(设置搜索监听)
        search.setFocusable(false);
        search.setFocusableInTouchMode(false);
        //设置edittext可编辑
//		tj_edittext.setFocusable(true);
//		tj_edittext.setFocusableInTouchMode(true);


    }


    //ListViewAdapter的回调
    @Override
    public void onChecked(int position, List<CateEntities> lists, View parent) {
        //TODO   刚进去和滚动刷新的时候会调用
    }

    private FenLeiGridViewAdapter gridViewAdapter;
    //初始化、加载分类grideview数据
    private void initGridViewDatas(List<CateEntities> lists, String t) {
        gridViewAdapter = new FenLeiGridViewAdapter(lists,this,t);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(onItem);
    }

    //gridview item点击监听
    public AdapterView.OnItemClickListener onItem = new AdapterView.OnItemClickListener() {

        private String t;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            List<CateEntities> list = gridViewAdapter.getList();
            t = list.get(position).getT();
            if(list.get(position).getDt()==2){
                List<CateCateEntities> ds = list.get(position).getDs();
                Intent intent = new Intent(ClassifyActivity.this,SecondClassifyActivity.class);
                intent.putExtra("title", t);
                intent.putExtra("ds", (Serializable) ds);
                intent.putExtra("fruit",t);
                ClassifyActivity.this.startActivity(intent);

            }else{
                Toast.makeText(ClassifyActivity.this,t,Toast.LENGTH_SHORT).show();
                //TODO 跳转
            }
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        List<CateEntities> lists = listViewAdapter.getDatas().get(position).getD();
        String t = listViewAdapter.getDatas().get(position).getT();
        listViewAdapter.setIsCheckedPosition(position);
        initGridViewDatas(lists,t);
    }

    @Override
    public void onClick(View v) {
        if(v==back){
            finish();
        }
    }
}
