package com.group.newproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.newproject.entity.CateCateEntities;
import com.group.newproject.entity.CateEntities;
import com.group.newproject.entity.CategotyRoot;
import com.group.newproject.utils.MBitmapHolder;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by gt72 on 2016-08-02.
 */
public class FenLeiListViewAdapter extends BaseAdapter {

    private List<CategotyRoot> datas;
    private LayoutInflater inflater;
    private int[] imgsId;
    public FenLeiListViewAdapter(List<CategotyRoot> datas, Context context) {
        this.datas = datas;
        imgsId = new int[]{R.drawable.cate_fenlei_5,R.drawable.cate_sancan_5,R.drawable.cate_zhushi_5,R.drawable.cate_jiachang_5,R.drawable.cate_zhonghua_5
                ,R.drawable.cate_xiaochi_5,R.drawable.cate_waiguo_5,R.drawable.cate_hongbei_5,R.drawable.cate_renqun_5,R.drawable.cate_shicai_5
                ,R.drawable.cate_cuju_5,R.drawable.cate_changjing_5,R.drawable.cate_jibing_5,R.drawable.cate_zhangfu_5,R.drawable.cate_gongneng_5
                ,R.drawable.cate_gongyi_5,R.drawable.cate_shijian_5,R.drawable.cate_kouwei_5};
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CategotyRoot getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView =  inflater.inflate(R.layout.fenlei_listview_item,null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.fenlei_img);
            holder.title = (TextView) convertView.findViewById(R.id.fenlei_listview_Tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        CategotyRoot item = getItem(position);
        if(isCheckedPosition==position){
            convertView.setBackgroundColor(0x55cccccc);
            if(listener!=null){
                listener.onChecked(position,item.getD(),convertView);
            }
        }else {
            convertView.setBackgroundColor(0x00000000);
        }
        holder.title.setText(item.getT());
        holder.img.setImageResource(imgsId[position]);
        return convertView;
    }

    private int isCheckedPosition = -1;
    class ViewHolder{
        TextView title;
        ImageView img;
    }

    public void setIsCheckedPosition(int position){
        isCheckedPosition = position;
        notifyDataSetChanged();
    }

    public List<CategotyRoot> getDatas(){
        return datas;
    }
    public interface OnCheckedListener{
        void onChecked(int position, List<CateEntities> lists,View parent);
    }
    private OnCheckedListener listener;
    public void setOnCheckedlistener(OnCheckedListener listener){
        this.listener = listener;
    }
}
