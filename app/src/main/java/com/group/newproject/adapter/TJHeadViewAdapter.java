package com.group.newproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.group.newproject.entity.Home;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.views.IrregularBitmapHandler;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.factory.BitmapFactory;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gt72 on 2016-07-27.
 */
public class TJHeadViewAdapter extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private List<View> views;
    private Activity aty;
    private List<Home.ObjBean.SanCanBean> datas;
    private BitmapUtils bitmapUtils;
    private LayoutInflater inflater;
    private List<Home.ObjBean.SanCanTitlesBean> datas2;
    private Typeface tf;
    private ViewHolder holder;
    private Bitmap bitmapBg;
    public TJHeadViewAdapter(List<View> views, List<Home.ObjBean.SanCanBean> datas, Context context, List<Home.ObjBean.SanCanTitlesBean> datas2) {
        this.views = views;
        this.datas = datas;
        this.context = context;
        aty = (Activity) context;
        this.datas2 = datas2;
        inflater = LayoutInflater.from(context);
        bitmapUtils = MBitmapHolder.getBitmapUtils(context);
        tf = Typeface.createFromAsset(context.getAssets(),"FZXiHei-YS01.ttf");

    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    @ViewInject(R.id.imageview1)
    private ImageView imageview1;
    @ViewInject(R.id.imageview2)
    private ImageView imageview2;
    @ViewInject(R.id.imageview3)
    private ImageView imageview3;
    @ViewInject(R.id.title1)
    private TextView title1;
    @ViewInject(R.id.title2)
    private TextView title2;
    @ViewInject(R.id.title3)
    private TextView title3;
    @ViewInject(R.id.tips1)
    private TextView tips1;
    @ViewInject(R.id.tips2)
    private TextView tips2;
    @ViewInject(R.id.tips3)
    private TextView tips3;
    @ViewInject(R.id.mainTitle)
    private TextView mainTitle;
    @ViewInject(R.id.mainTips)
    private TextView mainTips;
    private int index1;
    private int index2;
    private int index3;
    @ViewInject(R.id.layout1)
    private View layout1;
    @ViewInject(R.id.layout2)
    private View layout2;
    @ViewInject(R.id.layout3)
    private View layout3;

    @ViewInject(R.id.imageview_bg1)
    private ImageView imageView_bg1;
    @ViewInject(R.id.imageview_bg2)
    private ImageView imageView_bg2;
    @ViewInject(R.id.imageview_bg3)
    private ImageView imageView_bg3;
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        index1 = position*3;
        index2 = position*3+1;
        index3 = position*3+2;

        holder = new ViewHolder();
        View view = views.get(position);
        ViewUtils.inject(this,view);

        bitmapBg = android.graphics.BitmapFactory.decodeResource(context.getResources(),R.drawable.tj_recipe_mask);
        title1.setText(datas.get(index1).getTitle());
        tips1.setText(datas.get(index1).getDescr());
        title1.setTypeface(tf);
        tips1.setTypeface(tf);
        imageView_bg1.setImageBitmap(IrregularBitmapHandler.createRoundBitmap(IrregularBitmapHandler.getbitmap(imageView_bg1,bitmapBg,0,16,context)));
        imageView_bg2.setImageBitmap(IrregularBitmapHandler.getbitmap(imageView_bg2,bitmapBg,1,16,context));
        imageView_bg3.setImageBitmap(IrregularBitmapHandler.createRoundBitmap(IrregularBitmapHandler.getbitmap(imageView_bg3,bitmapBg,2,16,context)));


        title2.setText(datas.get(index2).getTitle());
        tips2.setText(datas.get(index2).getDescr());
        title2.setTypeface(tf);
        tips2.setTypeface(tf);

        title3.setText(datas.get(index3).getTitle());
        tips3.setText(datas.get(index3).getDescr());
        title3.setTypeface(tf);
        tips3.setTypeface(tf);
        bitmapUtils.display(imageview1, datas.get(index1).getTitlepic(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                imageView.setImageBitmap(IrregularBitmapHandler.createRoundBitmap(IrregularBitmapHandler.getbitmap(imageview1,bitmap,0,16,context)));
            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });

        bitmapUtils.display(imageview2, datas.get(index2).getTitlepic(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                imageView.setImageBitmap(IrregularBitmapHandler.getbitmap(imageview2,bitmap,1,16,context));
            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        bitmapUtils.display(imageview3, datas.get(index3).getTitlepic(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
//                imageview3.setImageBitmap(HandleImageview.createRoundBitmap(HandleImageview.getBitmap(imageview3,bitmap,2,context)));
                imageView.setImageBitmap(IrregularBitmapHandler.createRoundBitmap(IrregularBitmapHandler.getbitmap(imageview3,bitmap,2,16,context)));
//                imageview3.setImageBitmap(imageview3.setImageBitmap(bitmap,3));
            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        LogUtils.d(datas.get(index1).getTitlepic());
        LogUtils.d(datas.get(index2).getTitlepic());
        LogUtils.d(datas.get(index3).getTitlepic());
//        bitmapUtils.display(imageview1, datas.get(index1).getTitlepic());
//        bitmapUtils.display(imageview2, datas.get(index2).getTitlepic());
//        bitmapUtils.display(imageview3, datas.get(index3).getTitlepic());
        mainTips.setText(datas2.get(position).getSub_title());
        mainTitle.setText(datas2.get(position).getTitle());
        mainTitle.setTypeface(tf);
        mainTips.setTypeface(tf);
        //添加到容器

        container.addView(view);

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,datas.get(position*3).getId()+","+position+","+datas.get(position*3).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,datas.get(position*3+1).getId()+","+position+","+datas.get(position*3+1).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,datas.get(position*3+2).getId()+","+position+","+datas.get(position*3+2).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position);
        container.removeView(view);
    }


    @Override
    public void onClick(View v) {
//        if(v==holder.layout1){
//            Toast.makeText(context,datas.get(index1).getId()+","+datas.get(index1).getTitle(),Toast.LENGTH_SHORT).show();
//        }else if(v==holder.layout2){
//            Toast.makeText(context,datas.get(index2).getId()+","+datas.get(index2).getTitle(),Toast.LENGTH_SHORT).show();
//        }else if(v==holder.layout3){
//            Toast.makeText(context,datas.get(index3).getId()+","+datas.get(index3).getTitle(),Toast.LENGTH_SHORT).show();
//        }
    }
    class ViewHolder {
        View layout1,layout2,layout3;
    }

}
