package com.group.newproject.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

import com.group.newproject.utils.DensityUtil;


public class IrregularBitmapHandler {
	private Context context;
	/**
	 * 需要设置margin+spc>0
	 * @param img 装图片的容器
	 * @param bitmap 图片的Bitmap
	 * @param style 0: 最上面    1: 中间  2:  下面
	 * @param spc spacing： 空白宽度
	 * @return
	 */
	@SuppressWarnings("unused")
	public static Bitmap getbitmap(ImageView img, Bitmap bitmap,int style,float spc,Context context) {
		int imgwidth=img.getWidth();
		int imgheight=img.getHeight();
		
		int bitmapw=bitmap.getWidth();
		int bitmaph=bitmap.getHeight();

		if(imgheight==0||imgwidth==0){
			return null;
		}
		Bitmap bitmapspc=Bitmap.createBitmap(imgwidth, imgheight, Config.ARGB_8888);
		Canvas  canvas=new Canvas(bitmapspc);
		Paint	paint=new Paint();
		paint.setAntiAlias(true);
		Path path=new Path();
		int offset= DensityUtil.dip2px(context, spc);
		int offset2 = DensityUtil.dip2px(context, 5);
		//画路径
		if(style==0){
			path.moveTo(0, 0);
			path.lineTo(imgwidth, 0);
			path.lineTo(imgwidth, imgheight-offset2);
			path.lineTo(0, imgheight-offset-offset2);
			path.close();
		}else if(style==1){
			path.moveTo(0, 0);
			path.lineTo(imgwidth, offset);
			path.lineTo(imgwidth, imgheight-offset);
			path.lineTo(0, imgheight);
			path.close();
		}else if(style==2){
			path.moveTo(0, offset+offset2);
			path.lineTo(imgwidth, offset2);
			path.lineTo(imgwidth, imgheight);
			path.lineTo(0, imgheight);
			path.close();
		}
		canvas.drawPath(path, paint);
		//设置model
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		Rect dst=new Rect(0, 0, imgwidth, imgheight);
		Rect src = null;
		if(1f*imgwidth/imgheight > 1f*bitmapw/bitmaph){
			//代表截图的图片的高度
			//	int finalHeight = height*bitmapw/width;
			//src = new Rect(0, (bitmaph-finalHeight)/2, bitmapw, bitmaph-(bitmaph-finalHeight)/2);
		}else{
			//代表截图的图片的宽度
			//	int finalWidth = width*bitmaph/height;
			//	src = new Rect((bitmapw-finalWidth)/2, 0, bitmapw-(bitmapw-finalWidth)/2, bitmaph);
		}

		canvas.drawBitmap(bitmap, src, dst, paint);
		return bitmapspc;

	}
	public static Bitmap createRoundBitmap(Bitmap srcBitmap){
		if(srcBitmap == null){
			return srcBitmap;
		}
		int bmWidth = srcBitmap.getWidth();
		int bmHeight = srcBitmap.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(bmWidth, bmHeight, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		RectF rect = new RectF(0, 0, bmWidth, bmHeight);
		canvas.drawRoundRect(rect , 10, 10, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));  
		canvas.drawBitmap(srcBitmap, 0, 0, paint);  
		return bitmap;
	}
}
