package com.group.newproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.newproject.activity.DetailsActivity;
import com.group.newproject.entity.ResponseCookStep;
import com.group.newproject.entity.ResponseCookStep.CookStep;
import com.group.newproject.utils.MBitmapHolder;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.util.LogUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class DetailsAdapter extends BaseAdapter{

    LayoutInflater inflater;
    List<CookStep> list;
    BitmapUtils mBitmapUtils;
    DetailsActivity detailsActivity;
    public DetailsAdapter(Context context , List<CookStep> list) {
        super();
        this.list = list;
        inflater = LayoutInflater.from(context);
        mBitmapUtils = MBitmapHolder.getBitmapUtils(context);
        detailsActivity = (DetailsActivity) context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public CookStep getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    boolean isFirst = true;
    @Override
    public View getView(int position, View contentView, ViewGroup arg2) {
        ViewHolder holder = null;
        if(contentView == null){
            contentView = inflater.inflate(R.layout.item_details_step_listview, null);
            holder = new ViewHolder();
            holder.stepNum = (TextView) contentView.findViewById(R.id.stepNum);
            holder.stepImg = (ImageView) contentView.findViewById(R.id.stepImg);
            holder.stepExplain = (TextView) contentView.findViewById(R.id.stepExplain);
            contentView.setTag(holder);
        }else{
            holder = (ViewHolder) contentView.getTag();
        }
        CookStep item = getItem(position);
        int step = Integer.parseInt(item.getStep());
        //根据dt属性判断是图片还是解释，根据showNum判断是否显示第几步
        int dt = Integer.parseInt(item.getDt());
        int showNum = Integer.parseInt(item.getShowNum());
        String strD = item.getD();

        if(showNum==1){
            holder.stepNum.setVisibility(View.VISIBLE);
            holder.stepNum.setText("-第"+step+"步-");
        }else if(showNum==0){
            holder.stepNum.setVisibility(View.GONE);
        }
        if(dt==1){
            holder.stepImg.setVisibility(View.VISIBLE);
            holder.stepExplain.setVisibility(View.GONE);
            mBitmapUtils.display(holder.stepImg ,strD);
        }else if(dt==0){
            holder.stepImg.setVisibility(View.GONE);
            holder.stepExplain.setVisibility(View.VISIBLE);
            holder.stepExplain.setText(strD);
        }
        LogUtils.d("----------"+step+"*****"+strD);
        return contentView;
    }

    public void addDatas(List<CookStep> listSteps) {
        this.list.addAll(listSteps);
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView stepNum,stepExplain;
        ImageView stepImg;
    }
}

