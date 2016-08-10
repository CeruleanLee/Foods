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
 * 登录与注册.LYW
 * Created by Administrator on 2016/7/29.
 */
public class LoginAndRegisterActivity extends Activity {
    @ViewInject(R.id.login_back)
    private View mCancleView;//取消
    @ViewInject(R.id.login_password_img)
    private ImageView mPassWordImg;//密码栏里的图标
    @OnClick({R.id.login_back,R.id.login_password_img})
    public void onClick(View view){
        if (view == mCancleView){
            onBackPressed();
        }else if(view == mPassWordImg){

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        ViewUtils.inject(this);
        getIntent();

    }
}
