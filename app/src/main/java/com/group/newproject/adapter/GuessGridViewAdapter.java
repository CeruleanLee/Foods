package com.group.newproject.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.group.newproject.entity.Guess;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.views.RoundedCornerImageView;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by gt72 on 2016-07-30.
 */
public class GuessGridViewAdapter extends BaseAdapter implements View.OnClickListener {
    private List<Guess.ObjBean.CustomizedBean.DataBean> datas;
    private BitmapUtils bitmapUtils;
    private LayoutInflater inflater;
    private Typeface tf;
    private Context contex;
    public GuessGridViewAdapter(List<Guess.ObjBean.CustomizedBean.DataBean> datas, Context context) {
        this.datas = datas;
        bitmapUtils = MBitmapHolder.getBitmapUtils(context);
        inflater = LayoutInflater.from(context);
        this.contex = context;
        tf = Typeface.createFromAsset(context.getAssets(),"FZXiHei-YS01.ttf");
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Guess.ObjBean.CustomizedBean.DataBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.guess_gridview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        int index1 = position*2;
        int index2 = position*2+1;
        if(index2>=datas.size()){
            return convertView;
        }
        holder.guessItem1.setTag(index1);
        holder.guessItem2.setTag(index2);
        Guess.ObjBean.CustomizedBean.DataBean dataBean1 =  getItem(index1);
        Guess.ObjBean.CustomizedBean.DataBean dataBean2 =  getItem(index2);
        holder.guessItemTv1.setText(dataBean1.getTitle());
        holder.guessItemTv1.setTypeface(tf);
        holder.guessItemTv2.setText(dataBean2.getTitle());
        holder.guessItemTv2.setTypeface(tf);
        bitmapUtils.display(holder.guessItemImg1,dataBean1.getTitlepic());
        bitmapUtils.display(holder.guessItemImg2,dataBean2.getTitlepic());
        holder.guessItem1.setOnClickListener(this);
        holder.guessItem2.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        int index = (Integer) v.getTag();
        Toast.makeText(contex,datas.get(index).getTitle(),Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder {
        @ViewInject(R.id.guess_item_img1)
        ImageView guessItemImg1;
        @ViewInject(R.id.guess_item_tv1)
        TextView guessItemTv1;
        @ViewInject(R.id.guess_item_img2)
        ImageView guessItemImg2;
        @ViewInject(R.id.guess_item_tv2)
        TextView guessItemTv2;
        @ViewInject(R.id.guess_item1)
        View guessItem1;
        @ViewInject(R.id.guess_item2)
        View guessItem2;

        ViewHolder(View view) {
            ViewUtils.inject(this, view);
        }
    }
}
