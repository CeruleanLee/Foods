package com.group.newproject.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedCornerImageView extends ImageView{
	public RoundedCornerImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	@Override
	public void setImageBitmap(Bitmap bm) {
		super.setImageBitmap(createRoundBitmap(bm));
	}
	
	/**
	 * 矩形圆角Bitmap
	 * @param srcBitmap
	 * @return
	 */
	public static Bitmap createRoundBitmap(Bitmap srcBitmap){
		if(srcBitmap == null){
			return srcBitmap;
		}
		int bmWidth = srcBitmap.getWidth();
		int bmHeight = srcBitmap.getHeight();
		int min = bmWidth < bmHeight ? bmWidth : bmHeight;
		Bitmap bitmap = Bitmap.createBitmap(min, min, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		RectF rect = new RectF(0, 0, min, min);
		canvas.drawRoundRect(rect , 20, 20, paint);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));  
		canvas.drawBitmap(srcBitmap, 0, 0, paint);  
		return bitmap;
	}
	private Bitmap bitmap;
	@Override
	protected void onDraw(Canvas canvas) {
		//
		if(bitmap == null && getDrawable() != null){
			if(getDrawable() instanceof BitmapDrawable){
				BitmapDrawable bd = (BitmapDrawable) getDrawable();
				bitmap = bd.getBitmap();
				setImageBitmap(bitmap);
			}
		}
		super.onDraw(canvas);
	}


}
