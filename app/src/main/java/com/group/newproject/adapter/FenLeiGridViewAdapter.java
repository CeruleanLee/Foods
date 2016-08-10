package com.group.newproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.newproject.entity.CateEntities;
import com.group.newproject.utils.MBitmapHolder;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by gt72 on 2016-08-02.
 */
public class FenLeiGridViewAdapter extends BaseAdapter{
    private List<CateEntities> datas;
    private LayoutInflater inflater;
    private BitmapUtils bitmapUtils;
    private String t;
    public FenLeiGridViewAdapter(List<CateEntities> datas, Context context, String t) {
        this.datas = datas;
        this.t = t;
        bitmapUtils = MBitmapHolder.getBitmapUtils(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CateEntities getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            convertView =  inflater.inflate(R.layout.fenlei_item,null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.fenleititle_tv);
            holder.img = (ImageView) convertView.findViewById(R.id.fenlei_img);
            holder.title2 = (TextView) convertView.findViewById(R.id.fenlei_title2);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        CateEntities item = getItem(position);

        if("工艺".equals(t)||"时间".equals(t)||"口味".equals(t)){
            holder.title2.setVisibility(View.VISIBLE);
            holder.title.setVisibility(View.GONE);
            holder.img.setVisibility(View.GONE);
            holder.title2.setText(item.getT());
        }else{
            holder.title2.setVisibility(View.GONE);
            holder.title.setVisibility(View.VISIBLE);
            holder.img.setVisibility(View.VISIBLE);
            bitmapUtils.display(holder.img,item.getI());
            holder.title.setText(item.getT());
        }

        return convertView;
    }

    public List<CateEntities> getList(){
        return datas;
    }

    class ViewHolder{
        ImageView img;
        TextView title,title2;

    }
}
