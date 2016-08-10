package com.group.newproject.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by lee_yting on 2016/7/31.
 * 食話頁 popwindow 內部文字和图片
 */
public class PopItemForSH {
    // 图片
    public Drawable mDrawable;
    // 文本
    public String mTitle;

    public PopItemForSH(Drawable drawable, String title) {
        this.mDrawable = drawable;
        this.mTitle = title;
    }

    public PopItemForSH(Context context, int titleId, int drawableId) {
        this.mTitle = (String) context.getResources().getText(titleId);
        this.mDrawable = context.getResources().getDrawable(drawableId);
    }

    public PopItemForSH(Context context, String title, int drawableId) {
        this.mTitle = title;
        this.mDrawable = context.getResources().getDrawable(drawableId);
    }


}
