package com.group.newproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.newproject.entity.SH_Entity;
import com.group.newproject.utils.BitmapHandler;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.views.MyCheckTextView;
import com.group.newproject.views.MyNineGridLayout;
import com.group.newproject.views.MyTextView;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class SH_ListviewAdapter extends BaseAdapter {
    List<SH_Entity.HotTopicBean> list;
    LayoutInflater inflater;
    BitmapUtils bitmapUtils;
    Context context;
    HttpUtils httpUtils;
    public SH_ListviewAdapter(List<SH_Entity.HotTopicBean> list, Context context) {
        super();
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        bitmapUtils = MBitmapHolder.getBitmapUtils(context);
        this.context = context;
        httpUtils = MHttpHolder.getHttpUtils();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public SH_Entity.HotTopicBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /**点赞状态**/
    boolean isZanChecked;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_shlistview, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.sh_userImg);
            holder.userName = (TextView) convertView.findViewById(R.id.sh_userName);
            holder.userContent = (TextView) convertView.findViewById(R.id.sh_userContent);
            holder.realseTime = (TextView) convertView.findViewById(R.id.sh_releaseTime);
            holder.usergridview= (MyNineGridLayout ) convertView.findViewById(R.id.sh_usergridview);
            holder.fromWhere= (TextView) convertView.findViewById(R.id.sh_fromWhere);
            holder.tv_zan = (MyCheckTextView ) convertView.findViewById(R.id.sh_zan);
            holder.tv_comment = (MyTextView ) convertView.findViewById(R.id.sh_comment);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SH_Entity.HotTopicBean item = getItem(position);
        final SH_Entity.HotTopicBean.UserInfoBean user = item.user_info;
        /**来自：餐桌时光   **/
        SH_Entity.HotTopicBean.RecipeInfoBean recipe_info = item.recipe_info;


        bitmapUtils.display(holder.img, user.avatar, new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
               Bitmap bitmap2= BitmapHandler.createCircleBitmap(bitmap);
                imageView.setImageBitmap(bitmap2);
            }

            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });

        holder.userName.setText(user.user_name);
        holder.userContent.setText(item.summary);//设置圈子内容

        List<SH_Entity.HotTopicBean.ImgsBean> imgs = item.imgs;
        List<String> imgUrlList=new ArrayList<String>();
        for (int i=0;i<imgs.size();i++){
            imgUrlList.add(i,imgs.get(i).small);
        }
        holder.usergridview.setUrlList(imgUrlList);
        holder.realseTime.setText(item.time+" 来自 ");
        holder.fromWhere.setText(recipe_info.title);
        String ding_num = item.ding_num;
        zanNum = Integer.parseInt(ding_num);
        holder.tv_zan.setText(ding_num);


        //点赞监听
        //TODO  这里 要补充对登录状态的判断  没有登录时无法操作的
        holder.tv_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isZanChecked){
                    holder.tv_zan.setChecked(true);
                    zanNum++;
                    holder.tv_zan.setText(zanNum+"");
                }else{
                    holder.tv_zan.setChecked(false);
                    zanNum--;
                    holder.tv_zan.setText(zanNum+"");
                }
                isZanChecked=!isZanChecked;

            }
        });
        commentNum = item.comment_num;
        holder.tv_comment.setText(commentNum+"");
        //评论监听
        holder.tv_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //没登陆时要求登录 跳转到登录界面   登录后跳转到编辑评论界面   提交成功后textview+1
                if (isLogin){
//                    context.startActivity(new Intent(context,SH_CommentActivity.class));
                    commentNum++;
                    holder.tv_comment.setText(commentNum+"");
                }
            }
        });
        return convertView;
    }
   boolean isLogin;
    int zanNum,commentNum;
    /**更新数据源**/
    public void addDatas(List<SH_Entity.HotTopicBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void clearDatas() {
        this.list.clear();
        notifyDataSetChanged();
    }
    class ViewHolder {
        ImageView img;
        TextView userName, userContent, realseTime, fromWhere;
        MyTextView tv_comment;
        MyCheckTextView   tv_zan;
        MyNineGridLayout  usergridview;
    }
}

