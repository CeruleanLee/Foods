package com.group.newproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.group.tastyfoods.R;

public class PlayVideoActivity extends Activity {

    private WebView mWbv;
    private ImageView mimg_back;
    String vurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        mWbv = (WebView) findViewById(R.id.play_video_wbv);
        mimg_back = (ImageView) findViewById(R.id.webview_back);
        vurl = getIntent().getStringExtra("vurl");
        mimg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mWbv.loadUrl(vurl);
    }
}
