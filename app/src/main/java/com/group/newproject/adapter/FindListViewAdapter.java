package com.group.newproject.adapter;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.group.newproject.entity.FindResponse;
import com.group.newproject.entity.FindResponse.FaxianListBean;
import com.group.newproject.utils.BitmapHandler;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.utils.UnicodeDecode;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class FindListViewAdapter extends BaseAdapter{

    private List<FaxianListBean> datas;
    private LayoutInflater inflater;
    private BitmapUtils mBitmapUtils;
    private Context context;
    public FindListViewAdapter(List<FaxianListBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
        mBitmapUtils = MBitmapHolder.getBitmapUtils(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public FaxianListBean getItem(int i) {

        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        int viewType = getItemViewType(i);
        if (view==null) {
            holder = new ViewHolder();
            switch (viewType) {
                case 0:
                    view = inflater.inflate(R.layout.find_lv_item_type1,null);
                    holder.mStarContainer = (ViewGroup) view.findViewById(R.id.f_type1_starContainer);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type1_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type1_tag);
                    holder.mTpImg = (ImageView) view.findViewById(R.id.f_type1_titlepic);
                    holder.mTpTitleTv = (TextView) view.findViewById(R.id.f_type1_title1);
                    holder.mTp1StepTv = (TextView) view.findViewById(R.id.f_type1_step);
                    holder.mTp1KwTv = (TextView) view.findViewById(R.id.f_type1_kouwei);
                    holder.mStarContainer.setTag(i);
                    break;
                case 1:
                    view = inflater.inflate(R.layout.find_lv_item_type2,null);

                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type2_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type2_tag);
                    holder.mTpImg = (ImageView) view.findViewById(R.id.f_type2_titlepic);
                    holder.mTpTitleTv = (TextView) view.findViewById(R.id.f_type2_title1);
                    holder.mTp2Gx1Tv = (TextView) view.findViewById(R.id.f_type2_gongxiao1);
                    holder.mTp2Gx2Tv = (TextView) view.findViewById(R.id.f_type2_gongxiao2);
                    holder.mTp2htTv = (TextView) view.findViewById(R.id.f_type2_heat_word);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.find_lv_item_type3,null);
                    holder.mTpImg = (ImageView) view.findViewById(R.id.f_type3_img);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type3_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type3_tag);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.find_lv_item_type4,null);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type4_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type4_tag);
                    holder.mTpImg = (ImageView) view.findViewById(R.id.f_type4_titlepic);
                    holder.mTpTitleTv = (TextView) view.findViewById(R.id.f_type4_title1);
                    holder.mTp4MpTv = (TextView) view.findViewById(R.id.f_type4_market_price);
                    holder.mTp4PcTv = (TextView) view.findViewById(R.id.f_type4_price);
                    holder.mTp4TotalTv = (TextView) view.findViewById(R.id.f_type4_total_store);
                    break;
                case 4:
                    view = inflater.inflate(R.layout.find_lv_item_type5,null);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type5_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type5_tag);
                    holder.mTpImg = (ImageView) view.findViewById(R.id.f_type5_titlepic);
                    holder.mTpTitleTv = (TextView) view.findViewById(R.id.f_type5_title1);
                    holder.mTp5Content = (TextView) view.findViewById(R.id.f_type5_tv);
                    break;
                case 5:
                    view = inflater.inflate(R.layout.find_lv_item_type6,null);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type6_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type6_tag);
                    holder.mTp6Pic1 = (ImageView) view.findViewById(R.id.f_type6_img1);
                    holder.mTp6Pic2 = (ImageView) view.findViewById(R.id.f_type6_img2);
                    holder.mTp6Pic3 = (ImageView) view.findViewById(R.id.f_type6_img3);
                    holder.mTp6Tv1 = (TextView) view.findViewById(R.id.f_type6_tv1);
                    holder.mTp6Tv2 = (TextView) view.findViewById(R.id.f_type6_tv2);
                    holder.mTp6Tv3 = (TextView) view.findViewById(R.id.f_type6_tv3);
                    break;
                case 6:
                    view = inflater.inflate(R.layout.find_lv_item_type7,null);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type7_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type7_tag);
                    holder.mTp7Pic1 = (ImageView) view.findViewById(R.id.f_type7_img);
                    holder.mTp7Pic2 = (ImageView) view.findViewById(R.id.f_type7_img2);
                    holder.mTp7Pic3 = (ImageView) view.findViewById(R.id.f_type7_img3);

                    break;
                case 7:
                    view = inflater.inflate(R.layout.find_lv_item_type9,null);
                    holder.mTp9Img = (ImageView) view.findViewById(R.id.f_type9_img);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type9_title);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type9_tag);
                    holder.mTp9Tv1 = (TextView) view.findViewById(R.id.f_type9_tv1);
                    holder.mTp9Tv2 = (TextView) view.findViewById(R.id.f_type9_tv2);
                    break;
                case 8:
                    view = inflater.inflate(R.layout.find_lv_item_type11,null);
                    holder.mTitleTv = (TextView) view.findViewById(R.id.f_type11_title);
                    holder.mTpTitleTv = (TextView) view.findViewById(R.id.f_type11_title1);
                    holder.mTagTv = (TextView) view.findViewById(R.id.f_type11_tag);
                    holder.mTp11Tv1 = (TextView) view.findViewById(R.id.f_type11_userName);
                    holder.mTp11Img = (ImageView) view.findViewById(R.id.f_type11_avatar);
                    holder.mTp11Pic1 =(ImageView) view.findViewById(R.id.f_type11_pic1);
                    holder.mTp11Pic2 =(ImageView) view.findViewById(R.id.f_type11_pic2);
                    holder.mTp11Pic3  =(ImageView) view.findViewById(R.id.f_type11_pic3);
                    holder.mTp11Pic4 =(ImageView) view.findViewById(R.id.f_type11_pic4);
                    holder.mTp11Tv2 = (TextView) view.findViewById(R.id.f_type11_time);
                    holder.mTp11Tv3 = (TextView) view.findViewById(R.id.f_type11_zantimes);
                    holder.mTp11Tv4 = (TextView) view.findViewById(R.id.f_type11_pltimes);
                    break;
            }
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        final FaxianListBean item = getItem(i);
        switch (viewType) {
            case 0 :
                setlayout1(holder,item,i);
                break;
            case 1 :
                setlayout2(holder,item,view);
                break;
            case 2 :
                setlayout3(holder,item,view);
                break;
            case 3 :
                setlayout4(holder,item,view);
                break;
            case 4 :
                setlayout5(holder,item,view);
                break;
            case 5 :
                setlayout6(holder,item,view);
                break;
            case 6 :
                setlayout7(holder,item,view);
                break;
            case 7 :
                setlayout9(holder,item,view);
                break;
            case 8 :
                setlayout11(holder,item,view);
                break;

        }
        return view;
    }
    //TopicInfoBean
    private void setlayout11(ViewHolder holder, FaxianListBean item, View view) {
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        holder.mTpTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTopic_info().getSummary()));
        mBitmapUtils.display(holder.mTp11Img,item.getTopic_info().getUser_info().getAvatar());
        //需要根据评论中的具体有多少图片来设置(后续修改，未修改)
        mBitmapUtils.display(holder.mTp11Pic1,item.getTopic_info().getImgs().get(0).getSmall());
        mBitmapUtils.display(holder.mTp11Pic2,item.getTopic_info().getImgs().get(1).getSmall());
        mBitmapUtils.display(holder.mTp11Pic3,item.getTopic_info().getImgs().get(2).getSmall());
        mBitmapUtils.display(holder.mTp11Pic4,item.getTopic_info().getImgs().get(3).getSmall());

        holder.mTp11Tv1.setText(UnicodeDecode.uncodeToUtf_8(item.getTopic_info().getUser_info().getUser_name()));
        holder.mTp11Tv2.setText(UnicodeDecode.uncodeToUtf_8(item.getTopic_info().getTime()));
        holder.mTp11Tv3.setText(UnicodeDecode.uncodeToUtf_8(item.getTopic_info().getDing_num()));
        holder.mTp11Tv4.setText(UnicodeDecode.uncodeToUtf_8(item.getTopic_info().getComment_num()+""));
    }
    //ZtInfoBean
    private void setlayout9(ViewHolder holder, FaxianListBean item, View view) {
        mBitmapUtils.display(holder.mTp9Img,item.getZt_info().getPhoto());
        mBitmapUtils.display(holder.mTp9Img, item.getZt_info().getPhoto(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                final Bitmap roundBitmap = BitmapHandler.createRoundBitmap(bitmap);
                imageView.setImageBitmap(roundBitmap);
            }
            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        holder.mTp9Tv1.setText(UnicodeDecode.uncodeToUtf_8(item.getZt_info().getUser_info().getUser_name()));
        holder.mTp9Tv2.setText(UnicodeDecode.uncodeToUtf_8(item.getZt_info().getDescr()));
    }
    //CaidanInfoBean
    private void setlayout7(ViewHolder holder, FaxianListBean item, View view) {
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        mBitmapUtils.display(holder.mTp7Pic1,item.getCaidan_info().getPhotos().get(0));
        mBitmapUtils.display(holder.mTp7Pic2,item.getCaidan_info().getPhotos().get(1));
        mBitmapUtils.display(holder.mTp7Pic3,item.getCaidan_info().getPhotos().get(2));
    }
    //GongYiInfoBean
    private void setlayout6(ViewHolder holder, FaxianListBean item, View view) {
        mBitmapUtils.display(holder.mTp6Pic1,item.getGongyi_info().getRecipes().get(0).getTitlepic());
        holder.mTp6Tv1.setText(UnicodeDecode.uncodeToUtf_8(item.getGongyi_info().getRecipes().get(0).getTitle()));

        mBitmapUtils.display(holder.mTp6Pic2,item.getGongyi_info().getRecipes().get(1).getTitlepic());
        holder.mTp6Tv2.setText(UnicodeDecode.uncodeToUtf_8(item.getGongyi_info().getRecipes().get(1).getTitle()));

        mBitmapUtils.display(holder.mTp6Pic3,item.getGongyi_info().getRecipes().get(2).getTitlepic());
        holder.mTp6Tv3.setText(UnicodeDecode.uncodeToUtf_8(item.getGongyi_info().getRecipes().get(2).getTitle()));
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
    }
    //ArticleInfoBean
    private void setlayout5(ViewHolder holder, FaxianListBean item, View view) {
        mBitmapUtils.display(holder.mTpImg,item.getArticle_info().getTitlepic());
        mBitmapUtils.display(holder.mTpImg, item.getArticle_info().getTitlepic(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                final Bitmap roundBitmap = BitmapHandler.createRoundBitmap(bitmap);
                imageView.setImageBitmap(roundBitmap);
            }
            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        holder.mTpTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getArticle_info().getTitle()));
        holder.mTp5Content.setText(UnicodeDecode.uncodeToUtf_8(item.getArticle_info().getSmalltext()));
    }
    //GoodsInfoBean
    private void setlayout4(ViewHolder holder, FaxianListBean item, View view) {
//        mBitmapUtils.display(holder.mTpImg,item.getGoods_info().getImage());
        mBitmapUtils.display(holder.mTpImg, item.getGoods_info().getImage(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                final Bitmap roundBitmap = BitmapHandler.createRoundBitmap(bitmap);
                imageView.setImageBitmap(roundBitmap);
            }
            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });

        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        holder.mTpTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getGoods_info().getTitle()));
        holder.mTp4MpTv.setText(UnicodeDecode.uncodeToUtf_8("￥"+item.getGoods_info().getMarket_price()));
        holder.mTp4PcTv.setText(UnicodeDecode.uncodeToUtf_8("￥"+item.getGoods_info().getPrice()
                +"/"+item.getGoods_info().getGuige()));
        holder.mTp4TotalTv.setText(UnicodeDecode.uncodeToUtf_8("总销量"+item.getGoods_info().getTotal_store()));
    }
    //设置类型3的视图 活动
    private void setlayout3(ViewHolder holder, FaxianListBean item, View view) {
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        mBitmapUtils.display(holder.mTpImg, item.getHuodong().getImg().getSmall(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                final Bitmap roundBitmap = BitmapHandler.createRoundBitmap(bitmap);
                imageView.setImageBitmap(roundBitmap);
            }
            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
    }
    //设置类型2的视图 食材
    private void setlayout2(ViewHolder holder, FaxianListBean item, View view) {
        mBitmapUtils.display(holder.mTpImg, item.getShicai_info().getImage(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                final Bitmap roundBitmap = BitmapHandler.createRoundBitmap(bitmap);
                imageView.setImageBitmap(roundBitmap);
            }
            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        holder.mTpTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getShicai_info().getTitle()));
        holder.mTp2Gx1Tv.setText(UnicodeDecode.uncodeToUtf_8(item.getShicai_info().getGongxiao().get(0)));
        holder.mTp2Gx2Tv.setText(UnicodeDecode.uncodeToUtf_8(item.getShicai_info().getGongxiao().get(1)));
        holder.mTp2htTv.setText(UnicodeDecode.uncodeToUtf_8(item.getShicai_info().getHeat_word()));
    }
    //设置类型1的视图 食谱
    private void setlayout1(ViewHolder holder, FaxianListBean item, int i) {

        mBitmapUtils.display(holder.mTpImg, item.getRecipe_info().getTitlepic(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
                final Bitmap roundBitmap = BitmapHandler.createRoundBitmap(bitmap);
                imageView.setImageBitmap(roundBitmap);
            }
            @Override
            public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

            }
        });
        if (holder.mStarContainer.getChildCount()!=0) {
            holder.mStarContainer.removeAllViews();
            addStarToContainer(holder,item);
        }else{
            addStarToContainer(holder,item);
        }
        holder.mTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTitle()));
        holder.mTagTv.setText(UnicodeDecode.uncodeToUtf_8(item.getTag()));
        holder.mTpTitleTv.setText(UnicodeDecode.uncodeToUtf_8(item.getRecipe_info().getTitle()));
        holder.mTp1StepTv.setText(UnicodeDecode.uncodeToUtf_8(item.getRecipe_info().getStep()+"/<"+item.getRecipe_info().getMake_time()));
        holder.mTp1KwTv.setText(UnicodeDecode.uncodeToUtf_8(item.getRecipe_info().getKouwei()+"/"+item.getRecipe_info().getGongyi()));
    }

    private void addStarToContainer(ViewHolder holder, FaxianListBean item) {
        String s = UnicodeDecode.uncodeToUtf_8(item.getRecipe_info().getRate());
        int size = Integer.parseInt(s);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
        params.rightMargin = 3;
        ImageView[] imgs = new ImageView[5];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = new ImageView(context);
            imgs[i].setImageResource(R.drawable.dish_rate_full_empty);
            imgs[i].setLayoutParams(params);
            holder.mStarContainer.addView(imgs[i]);
        }
        for (int i = 0; i < size; i++) {
            imgs[i].setImageResource(R.drawable.dish_rate_full_fill);
        }
    }

    private class ViewHolder{
        TextView mTitleTv,mTagTv,mTpTitleTv,mTp1KwTv,mTp1StepTv,
                mTp2Gx1Tv,mTp2Gx2Tv,mTp2htTv,
                mTp4MpTv,mTp4PcTv,mTp4TotalTv,
                mTp5Content,mTp6Tv1,mTp6Tv2,mTp6Tv3,
                mTp9Tv1,mTp9Tv2,mTp11Tv1,mTp11Tv2,mTp11Tv3,mTp11Tv4;
        ;
        ViewGroup mStarContainer;
        ImageView mTpImg,mTp6Pic1,mTp6Pic2,mTp6Pic3,
                mTp7Pic1,mTp7Pic2,mTp7Pic3, mTp9Img,
                mTp11Img,mTp11Pic1,mTp11Pic2,mTp11Pic3,mTp11Pic4;
        ;
    }
    public void addDatas(List<FaxianListBean> list){
        this.datas.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int type = Integer.parseInt(UnicodeDecode.uncodeToUtf_8(getItem(position).getType()));
        switch (type) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 9:
                return 7;
            case 11:
                return 8;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 9;
    }
}
