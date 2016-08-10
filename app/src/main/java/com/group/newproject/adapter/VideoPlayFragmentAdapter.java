package com.group.newproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.group.newproject.activity.PlayVideoActivity;
import com.group.newproject.entity.VideoLast;
import com.group.newproject.utils.BitmapHandler;
import com.group.newproject.utils.MBitmapHolder;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by yp on 2016/7/29.
 */
public class VideoPlayFragmentAdapter extends BaseAdapter{

    private List<VideoLast.ObjBean.VideoListBean> list;
    private BitmapUtils mBitmapUtils;
    private LayoutInflater inflater;
    private Context context;

    public VideoPlayFragmentAdapter(List<VideoLast.ObjBean.VideoListBean> list, Context context) {
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
    public VideoLast.ObjBean.VideoListBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_video,null);
            holder = new ViewHolder();
            holder.video_list_img = (ImageView) convertView.findViewById(R.id.video_list_img);
            holder.img_video = (ImageView) convertView.findViewById(R.id.img_video);
            holder.video_list_name = (TextView) convertView.findViewById(R.id.video_list_name);
            holder.video_list_time = (TextView) convertView.findViewById(R.id.video_list_time);
            holder.describtion = (TextView) convertView.findViewById(R.id.describtion);
            holder.play_times = (TextView) convertView.findViewById(R.id.play_times);
            holder.play_video = (ImageView) convertView.findViewById(R.id.play_video);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        final VideoLast.ObjBean.VideoListBean item = getItem(position);
        holder.video_list_name.setText(item.getName());
        holder.video_list_time.setText(item.getTime());
        holder.describtion.setText(item.getDescribtion());
        holder.play_times.setText(item.getPlay_times());
        //点击分类小图标
        holder.video_list_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,item.getName(),Toast.LENGTH_LONG).show();
            }
        });
        //点击播放图标
        holder.play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
                intent.putExtra("url",item.getImg_video());

            }
        });
        mBitmapUtils.display( holder.video_list_img,item.getImg());
        mBitmapUtils.display(holder.img_video, item.getImg_video());
        //设置内容
        return convertView;
    }

    private class ViewHolder{
        private ImageView img_video,video_list_img,play_video;
        private TextView video_list_name,video_list_time,describtion,play_times;
    }

    /**
     * 封装了一个向数据源中添加数据的方法
     */
    public void addDatas(List<VideoLast.ObjBean.VideoListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
