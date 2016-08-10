package com.group.newproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group.newproject.entity.CityGuide;
import com.group.newproject.utils.UnicodeDecode;
import com.group.tastyfoods.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class CityAtyAdapter extends BaseAdapter {
    private List<CityGuide.CityAllBean> datas;
    private LayoutInflater inflater;

    public CityAtyAdapter(List<CityGuide.CityAllBean> datas, Context context) {
        this.datas = datas;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CityGuide.CityAllBean getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.item_city,null);
            holder = new ViewHolder();
            holder.mGroupTv= (TextView) convertView.findViewById(R.id.city_lv_groupTv);
            holder.mTitleTv = (TextView) convertView.findViewById(R.id.city_lv_titleTv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        CityGuide.CityAllBean item = getItem(i);
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getRegion()));
        if (i!=0){
            if (UnicodeDecode.uncodeToUtf_8(item.getPinyin()).equals(UnicodeDecode.uncodeToUtf_8(getItem(i-1).getPinyin()))) {
                holder.mGroupTv.setVisibility(View.GONE);
            }else{
                holder.mGroupTv.setVisibility(View.VISIBLE);
                holder.mGroupTv.setText(UnicodeDecode.uncodeToUtf_8(item.getPinyin()));
            }
        }else{
            holder.mGroupTv.setVisibility(View.VISIBLE);
            holder.mGroupTv.setText(UnicodeDecode.uncodeToUtf_8(item.getPinyin()));
        }

        return convertView;
    }
    private class ViewHolder{
        TextView mGroupTv;
        TextView mTitleTv;
    }
    public void addDatas(List<CityGuide.CityAllBean> list){
        this.datas.addAll(list);
        notifyDataSetChanged();
    }
}
