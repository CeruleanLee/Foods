package com.group.newproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

import com.group.tastyfoods.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gt72 on 2016-08-02.
 */
public class SecondFenLeiGridViewAdapter extends BaseAdapter {
    private List<String> datas;
    private LayoutInflater inflater;
    private List<Integer> hs;
    public SecondFenLeiGridViewAdapter(List<String> datas, Context context) {
        this.datas = datas;
        hs = new ArrayList<Integer>();
        inflater  = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(datas==null){
            return 0;
        }
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoleder holeder = null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.erji_fenlei_gridview_item,null);
            holeder = new ViewHoleder();
            holeder.t = (TextView) convertView.findViewById(R.id.erji_fenlei_recipename);
            convertView.setTag(holeder);
        }else{
            holeder = (ViewHoleder) convertView.getTag();
        }
//        ViewGroup.LayoutParams params = convertView.getLayoutParams();
//        params.height = holeder.t.getHeight();
//        params.width = holeder.t.getWidth();
        holeder.t.setText(getItem(position));
        if(hs.contains(position)){
            holeder.t.setTextColor(0xFFFF4E51);
        }else {
            holeder.t.setTextColor(0xFF000000);
        }
//        convertView.setLayoutParams(params);
        return convertView;
    }

    public void setHS(List<Integer> hs){
        this.hs = hs;
        notifyDataSetChanged();
    }
    class ViewHoleder{
        TextView t;
    }
}
