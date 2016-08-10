package com.group.newproject.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.group.newproject.activity.FindCityActivity;

public class LettersView extends View {
	private final String LETTERS = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Paint mPaint;
	public LettersView(Context context) {
		super(context);
		inviPaint();
	}

	public LettersView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inviPaint();
	}

	public LettersView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inviPaint();
	}
	private void inviPaint() {
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setTextSize(26);
	}
	float height;
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(0xffffffff);
		float width = getWidth();
		height = getHeight()/LETTERS.length();
		RectF rect = new RectF(0, 0, width, height);
		Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
		float baseline = (rect.bottom+rect.top - fontMetrics.top-fontMetrics.bottom)/2;
		for (int i = 0; i < LETTERS.length(); i++) {
			String text = LETTERS.charAt(i)+"";
			float x = (width-mPaint.measureText(text))/2;
			if (currentIndex == i) {
				mPaint.setColor(Color.BLUE);
			}else{
				mPaint.setColor(Color.RED);
			}
			canvas.drawText(text, x, baseline+i*height, mPaint);
		}
		super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int index = (int) (event.getY()/height);
		if (index<0||index>LETTERS.length()-1) {
			return true;
		}

		if (currentIndex!=index) {
			currentIndex = index;
			invalidate();
			if (listener != null) {
				listener.onLettersSelectChange(index, LETTERS.charAt(index)+"");
			}
		}
		return true;
	}
	private int currentIndex = -1;

	public void changeLetter(String letter) {
		for (int i = 0; i < LETTERS.length(); i++) {
			if(letter.equals(LETTERS.charAt(i)+"")){
				if(currentIndex != i){
					currentIndex = i;
					invalidate();
				}
				return;
			}
		}
	}


	public interface OnLettersSelectChangeListener{
		void onLettersSelectChange(int index, String letter);
	}
	private OnLettersSelectChangeListener listener;
	public void setOnLettersSelectChangeListener(OnLettersSelectChangeListener listener){
		this.listener = listener;
	}
}

