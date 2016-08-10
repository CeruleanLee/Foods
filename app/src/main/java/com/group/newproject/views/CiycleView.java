package com.group.newproject.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author fhbianling--- A little learning is a dangerous thing.
 * @mail fhbianling@163.com
 * @time 2016-6-24下午1:52:23s
 */
public class CiycleView extends ImageView {
	private Bitmap bitmap;
	private Paint mPaint;
	private int viewWidth;
	private int viewHeight;
	private int centerX;
	private int centerY;
	private int basicLayerRadius;
	private PorterDuffXfermode xfermode;
	private PorterDuffXfermode xfermode2;
	private PorterDuffXfermode xfermode3;

	private void init() {
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		xfermode = new PorterDuffXfermode(Mode.DST_OUT);
		xfermode2 = new PorterDuffXfermode(Mode.DST_ATOP);
		xfermode3 = new PorterDuffXfermode(Mode.DARKEN);
	}

	public CiycleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CiycleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CiycleView(Context context) {
		super(context);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (viewWidth == 0) {
			viewWidth = getWidth();
			viewHeight = getHeight();
			//centerX,centerY分别为圆心的横纵坐标
			centerX = viewWidth / 2;
			centerY = viewHeight / 2;
			//圆形头像的半径
			basicLayerRadius = Math.min(getWidth(), getHeight()) / 2 ;
		}
		if (bitmap != null) {
			//绘制一个填满view的颜色为父容器背景色的矩形,Color.TRANSPARENT就是透明色
			mPaint.setStyle(Style.FILL_AND_STROKE);
			mPaint.setColor(Color.TRANSPARENT);
			canvas.drawRect(0, 0, viewWidth, viewHeight, mPaint);

			//从矩形中扣出一个圆来
			//xfermode为Mode.DST_OUT，代表绘制下层图层中与上层图层的非交集部分
			mPaint.setXfermode(xfermode);
			mPaint.setColor(Color.RED);
			canvas.drawCircle(centerX, centerY, basicLayerRadius, mPaint);

			//在矩形中扣出的圆中放入bitmap
			//实际上的绘制原理是xfermode2为Mode.DST_ATOP，代表绘制上层非交集部分以及下层交集部分
			mPaint.setXfermode(xfermode2);
			canvas.drawBitmap(bitmap, (viewWidth - bitmap.getWidth()) / 2,
					(viewHeight - bitmap.getHeight()) / 2, mPaint);

			//为圆形头像绘制边界，用于在背景色和图片边界颜色相同时区分
			//xfermode3为Mode.DARKEN,代表上下两层全部绘制，并加深交集区域颜色
			mPaint.setXfermode(xfermode3);
			mPaint.setStyle(Style.STROKE);
			//由于这里只需要圆形头像有一个明确的边界，因此并不需要设置StorkeWidth大于0
			mPaint.setColor(Color.BLACK);
			canvas.drawCircle(centerX, centerY, basicLayerRadius, mPaint);
		}
	}
	
	/**
	 * 这个方法会被BitmapUtils.display(...)调用
	 * 而在这之前，由于view已经被创建，所以viewWidth和viewHeight已经在onDraw中获得到了
	 */
	@Override
	public void setImageBitmap(Bitmap bm) {
		this.bitmap = bm;
		if (bitmap.getWidth() < viewWidth||bitmap.getHeight()<viewHeight) {
			//当bitmap较小时，放大bitmap
			bitmap = Bitmap.createScaledBitmap(bitmap, viewWidth,
					viewHeight, true);
		}
		invalidate();
	}
}
