package com.group.newproject.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group.newproject.adapter.DetailsAdapter;
import com.group.newproject.entity.CookMethod;
import com.group.newproject.entity.ResponseCookStep.CookStep;
import com.group.newproject.entity.ResponseCookStuff;
import com.group.newproject.entity.ResponseCookStuff.FuLiao;
import com.group.newproject.entity.ResponseCookStuff.ZhuLiao;
import com.group.newproject.entity.ResponseMeunDetails;
import com.group.newproject.entity.ResponseMeunDetails.ObjBean.RelBean;
import com.group.newproject.utils.AppTool;
import com.group.newproject.utils.BitmapHandler;
import com.group.newproject.utils.MBitmapHolder;
import com.group.newproject.utils.MHttpHolder;
import com.group.newproject.utils.UnicodeDecode;
import com.group.tastyfoods.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends Activity {
	DetailsAdapter mDetailsAdapter;
	HttpUtils httpUtils;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	public BitmapUtils mBitmapUtils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_activity);
		getHeadView();
		getFootView();
		initViews();
		mBitmapUtils = MBitmapHolder.getBitmapUtils(this);
		listView_step.addHeaderView(headView);
		listView_step.addFooterView(footView);
		List<CookStep>listSteps = new ArrayList<CookStep>();
		mDetailsAdapter = new DetailsAdapter(DetailsActivity.this, listSteps);
		listView_step.setAdapter(mDetailsAdapter);
		loadDatas();
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
	}

	private void loadDatas() {
//		String url = UrlHandler.handlUrl(Contants.RECIPE_NEWS  ,  );
		String url = "http://api101.meishi.cc/v5/recipe_news.php?source=android&format=json&time=1469516265&from_home_like=0&id=1646040&vk=1d7882c70fac20aabcf11455937e35fd";
		httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {

			public void onFailure(HttpException e, String arg0) {
				Toast.makeText(DetailsActivity.this, "访问网络失败", Toast.LENGTH_SHORT).show();
			}
			public void onSuccess(ResponseInfo<String> responseInfo) {
				Toast.makeText(DetailsActivity.this, "访问网络成功", Toast.LENGTH_SHORT).show();
				String content = responseInfo.result;
				ResponseMeunDetails responseMeunDetails = new Gson().fromJson(content, ResponseMeunDetails.class);
				stepNums = Integer.parseInt(responseMeunDetails.getObj().getDetail().getStep());
				String zuofaContent = responseMeunDetails.getObj().getDetail().getZuofa();
				List<CookStep> listSteps = new Gson().fromJson(zuofaContent, new TypeToken<ArrayList<CookStep>>() {
				}.getType());
				mDetailsAdapter.addDatas(listSteps);
				String liaosJson = responseMeunDetails.getObj().getDetail().getLiaos();
				ResponseCookStuff responseCookStuff = new Gson().fromJson(liaosJson, ResponseCookStuff.class);
				loadHeaderDatas(responseMeunDetails,responseCookStuff);
				loadFooterDatas(responseMeunDetails);
			}
		});
	}
	public void loadHeaderDatas(ResponseMeunDetails responseMeunDetails, ResponseCookStuff responseCookStuff) {
		ResponseMeunDetails.ObjBean.DetailBean detailsHeader = responseMeunDetails.getObj().getDetail();
		mBitmapUtils.display(titlePictureImg,detailsHeader.getTitlepic());
		int rateNum = Integer.parseInt(detailsHeader.getRate());
		xingrateRBar.setRating((float) rateNum);
		collection_classidTV.setText(detailsHeader.getClassid());
		browse_onclickTV.setText(detailsHeader.getOnclick());
		String strImg = detailsHeader.getAuthor().getAvatar();
		mBitmapUtils.display(userAvatarImg, detailsHeader.getAuthor().getAvatar(), new BitmapLoadCallBack<ImageView>() {
			@Override
			public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
				Bitmap bitmap2 = BitmapHandler.createCircleBitmap(bitmap);
				imageView.setImageBitmap(bitmap2);
			}
			@Override
			public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {
			}
		});
		userNameTV.setText(detailsHeader.getAuthor().getUser_name());
		String str = AppTool.decrypt(detailsHeader.getSmalltext());
		str = UnicodeDecode.uncodeToUtf_8(str);
		try {
			str = URLDecoder.decode(str,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		introductionOfFood_smalltextTV.setText(str);
		gongyiTV.setText(detailsHeader.getGongyi());
		kouweiTV.setText(detailsHeader.getKouwei());
		time_make_timeTV.setText(detailsHeader.getMake_time());
		List<ZhuLiao>listM = responseCookStuff.getList();
		LinearLayout zhuliaoLayout = (LinearLayout) headView.findViewById(R.id.zhuliaoLayout);
		for(int i=0;i<listM.size();i++ ){
			View view = getLoadingLayout();
			zhuliaoLayout.addView(view);
			TextView whatzhuliaoTV = (TextView) view.findViewById(R.id.whatLiao);
			TextView zhuliaoMG = (TextView) view.findViewById(R.id.liao_mg);
			whatzhuliaoTV.setText(listM.get(i).getTitle());
			zhuliaoMG.setText(listM.get(i).getNum());
		}
		List<FuLiao>listF = responseCookStuff.getList_f();
		LinearLayout fuliaoLayout = (LinearLayout) headView.findViewById(R.id.fuliaoLayout);
		for(int i=0;i<listF.size();i++ ){
			View view = getLoadingLayout();
			TextView whatfuliaoTV = (TextView) view.findViewById(R.id.whatLiao);
			TextView fuliaoMG = (TextView) view.findViewById(R.id.liao_mg);
			fuliaoLayout.addView(view);
			whatfuliaoTV.setText(listF.get(i).getTitle());
			fuliaoMG.setText(listF.get(i).getUnit());
		}
	}
	public void loadFooterDatas(ResponseMeunDetails responseMeunDetails) {

		String tips = responseMeunDetails.getObj().getDetail().getTips();
		List<CookMethod> list = new Gson().fromJson(tips, new TypeToken<ArrayList<CookMethod>>() {
		}.getType());
		dongtaiLayoutPR = (LinearLayout) footView.findViewById(R.id.dongtaiLayoutPR);
		TextView jiqiaoTV = (TextView) footView.findViewById(R.id.text_tips);
//		ImageView redpointImg = (ImageView) footView.findViewById(R.id.red_point);
		for (int i=0;i<list.size();i++){
			if(i==1){
				jiqiaoTV.setText(list.get(i).getD());
			}
		}

		RelBean relBean = responseMeunDetails.getObj().getRel();
		all_numTV.setText(relBean.getAll_num()+"");
		have_img_numTV.setText(relBean.getHave_img_num()+"");
		help_numTV.setText(relBean.getHelp_num()+"");
		comment_numTV.setText(relBean.getComment_num()+"");
		fav_numTV.setText(relBean.getFav_num()+"");
		share_numTV.setText(relBean.getShare_num()+"");
		List<RelBean.CommentsBean> comments = relBean.getComments();
		for(int i=0;i<comments.size();i++){
			View view = getUserInfo();
			ImageView avatarImg = (ImageView) view.findViewById(R.id.user_avatar);
			TextView userName = (TextView) view.findViewById(R.id.userName);
			TextView userSpeak = (TextView) view.findViewById(R.id.userSpeak);
			TextView userKind = (TextView) view.findViewById(R.id.userKind);
			TextView userTime = (TextView) view.findViewById(R.id.user_standardTimes);
			TextView userZannum = (TextView) view.findViewById(R.id.userzanCounts);
			TextView userpingliunnum = (TextView) view.findViewById(R.id.userpinglunCounts);
			userDongtaiLayout.addView(view);
			mBitmapUtils.display(avatarImg, comments.get(i).getUser_info().getAvatar(), new BitmapLoadCallBack<ImageView>() {
				@Override
				public void onLoadCompleted(ImageView imageView, String s, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom) {
					Bitmap circleBitmap = BitmapHandler.createCircleBitmap(bitmap);
					imageView.setImageBitmap(circleBitmap);
				}
				@Override
				public void onLoadFailed(ImageView imageView, String s, Drawable drawable) {

				}
			});
			userName.setText(comments.get(i).getUser_info().getUser_name());
			userSpeak.setText(comments.get(i).getUser_info().getSignature());
			userTime.setText(comments.get(i).getCreate_time());
			userZannum.setText(comments.get(i).getZan_num()+"");
			userpingliunnum.setText(comments.get(i).getImg_num()+"");
		}
	}
	public View getLoadingLayout(){
		View view = LayoutInflater.from(this).inflate(R.layout.layout_dongtai_loading, null);
		return view;
	}
//	public View getLoadingPR(){
//		View view = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.dongtai_loading_layout,null);
//		return view;
//	}
	public View getUserInfo(){
		View view = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.dongtai_layout_pinglun,null);
		return view;
	}

	ImageView backImg, menuImg;
	ListView listView_step;

	//头部视图
	LinearLayout dynamicLoading_mainThingsLayout;
	LinearLayout dynamicLoading_assistThingsLayout;
	TextView vagetableBasketTV, addToListTV;
	TextView introductionOfFood_smalltextTV;
	ImageView titlePictureImg, userAvatarImg;
	TextView titleOfFoodTV, collection_classidTV, browse_onclickTV, userNameTV, gongyiTV, kouweiTV, time_make_timeTV;
	RatingBar xingrateRBar;

	//脚步视图
	LinearLayout dongtaiLayoutPR;
	//	LinearLayout weixinhaoyou,weixinpengyouquan,xinlangweibo,quanbupinglunTV;
	TextView all_numTV,have_img_numTV,help_numTV;
	LinearLayout userDongtaiLayout;
	ImageView userAvatar;
	TextView comment_numTV,fav_numTV,share_numTV;

	public int stepNums;

	public View headView;
	public View footView;
	private void initViews() {
		backImg = (ImageView) findViewById(R.id.backImg);
		menuImg = (ImageView) findViewById(R.id.menu);
		listView_step = (ListView) findViewById(R.id.listView_details_step);
		httpUtils = MHttpHolder.getHttpUtils();
		httpUtils.configCurrentHttpCacheExpiry(0);
		httpUtils.configSoTimeout(4000);
		httpUtils.configTimeout(4000);
		httpUtils.configRequestThreadPoolSize(1);

		introductionOfFood_smalltextTV = (TextView) headView.findViewById(R.id.introductionOfFood_smalltext);
		titlePictureImg = (ImageView) headView.findViewById(R.id.titlePicture);
		userAvatarImg = (ImageView) headView.findViewById(R.id.userAvatar);
		titleOfFoodTV = (TextView) headView.findViewById(R.id.titleOfFood);
		collection_classidTV = (TextView) headView.findViewById(R.id.collection_classid);
		browse_onclickTV = (TextView) headView.findViewById(R.id.browse_onclick);
		userNameTV = (TextView) headView.findViewById(R.id.userName);
		gongyiTV = (TextView) headView.findViewById(R.id.gongyi);
		kouweiTV = (TextView) headView.findViewById(R.id.kouwei_delicious);
		time_make_timeTV = (TextView) headView.findViewById(R.id.time_make_time);
		xingrateRBar = (RatingBar) headView.findViewById(R.id.xingxing_rate);
		dynamicLoading_mainThingsLayout = (LinearLayout) headView.findViewById(R.id.dynamicLoading_mainThings);
		dynamicLoading_assistThingsLayout = (LinearLayout) headView.findViewById(R.id.dynamicLoading_assistThings);
		vagetableBasketTV = (TextView) headView.findViewById(R.id.vagetableBasket);
		addToListTV = (TextView) headView.findViewById(R.id.addToList);

		all_numTV = (TextView) footView.findViewById(R.id.quanbuCounts);
		have_img_numTV = (TextView) footView.findViewById(R.id.youtucounts);
		help_numTV = (TextView) footView.findViewById(R.id.tiwenCounts);

		userDongtaiLayout = (LinearLayout) footView.findViewById(R.id.userDongtaiLayout);
		comment_numTV = (TextView) footView.findViewById(R.id.jitiaoPL);
		fav_numTV = (TextView) footView.findViewById(R.id.jigerenSC);
		share_numTV = (TextView) footView.findViewById(R.id.jiciFX);
	}

	public View getHeadView() {
		headView = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.header_of_details_step, null);
		return headView;
	}

	public View getFootView() {
		footView = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.footer_of_details_step,null);
		return footView;
	}
}
