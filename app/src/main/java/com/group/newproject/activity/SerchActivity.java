package com.group.newproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.group.tastyfoods.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * 搜索页面，LYW
 * Created by Administrator on 2016/7/29.
 */
public class SerchActivity extends Activity {
    @ViewInject(R.id.serch_red_back)
    private ImageView mBackImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);
        ViewUtils.inject(this);
        getIntent();
    }
    @OnClick(R.id.serch_red_back)
    public void onClick(View view){
        if (view == mBackImg){
            onBackPressed();
        }
    }
}
