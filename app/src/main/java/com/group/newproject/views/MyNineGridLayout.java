package com.group.newproject.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.group.newproject.utils.BitmapHandler;
import com.group.newproject.utils.MBitmapHolder;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by lee_yting on 2016/7/31.
 */
public class MyNineGridLayout  extends NineGridLayout{
    protected static final int MAX_W_H_RATIO = 3;
    BitmapUtils  bitmapUtils;
    public MyNineGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmapUtils = MBitmapHolder.getBitmapUtils(context);
    }

    public MyNineGridLayout(Context context) {
        super(context);
        bitmapUtils = MBitmapHolder.getBitmapUtils(context);
    }

    @Override
    protected boolean displayOneImage(RatioImageView imageView, String url, int parentWidth) {
        bitmapUtils.display(imageView,url, new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView view, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                Bitmap bitmap2= BitmapHandler.createRoundBitmap(bitmap);
                view.setImageBitmap(bitmap2);
            }

            @Override
            public void onLoadFailed(ImageView view, String s, Drawable drawable) {

            }
        });

        return false;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        bitmapUtils.display(imageView,url, new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView view, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                Bitmap bitmap2= BitmapHandler.createRoundBitmap(bitmap);
                view.setImageBitmap(bitmap2);
            }

            @Override
            public void onLoadFailed(ImageView view, String s, Drawable drawable) {

            }
        });

    }

    @Override
    protected void onClickImage(int position, String url, List<String> urlList) {
        Toast.makeText(mContext, "点击了图片" + position, Toast.LENGTH_SHORT).show();
    }
}
