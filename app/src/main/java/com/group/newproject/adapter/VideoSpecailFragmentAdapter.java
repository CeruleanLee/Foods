package com.group.newproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.newproject.entity.VideoSpecail;
import com.group.newproject.utils.BitmapHandler;
import com.group.newproject.utils.MBitmapHolder;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by yp on 2016/8/1.
 */
public class VideoSpecailFragmentAdapter extends BaseAdapter{

    private List<VideoSpecail.ObjBean.RecommendListBean> list;
    private Context context;
    private BitmapUtils mBitmapUtils;
    private LayoutInflater inflater;

    public VideoSpecailFragmentAdapter(List<VideoSpecail.ObjBean.RecommendListBean> list,Context context) {
        super();
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        mBitmapUtils = MBitmapHolder.getBitmapUtils(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public VideoSpecail.ObjBean.RecommendListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_special,null);
            holder = new ViewHolder();
            holder.special_img_video = (ImageView) convertView.findViewById(R.id.special_img_video);
            holder.special_name = (TextView) convertView.findViewById(R.id.special_name);
            holder.special_play_amount = (TextView) convertView.findViewById(R.id.special_play_amount);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        VideoSpecail.ObjBean.RecommendListBean item = getItem(position);
        holder.special_name.setText(item.getName());
        holder.special_play_amount.setText(item.getPlay_amount());
        mBitmapUtils.display(holder.special_img_video, item.getImg_video(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView arg0, String s, Bitmap arg2, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                Bitmap bitmap = new BitmapHandler().createCircleBitmap(arg2);
                arg0.setImageBitmap(bitmap);
            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        return convertView;
    }

    private class ViewHolder{
        private ImageView special_img_video;
        private TextView special_name,special_play_amount;
    }
}
