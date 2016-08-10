package com.group.newproject.views;

import java.text.SimpleDateFormat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.TextView;

public class CountDownTextView extends TextView{

	public CountDownTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private CountDownTimer countDownTimer;
	private SimpleDateFormat dateFormat;
	private String patternMinute = "s";
	public void getCountDownTime(long totalTime,long period) {
		if(countDownTimer == null) {
			countDownTimer = new CountDownTimer(totalTime, period) {

				@Override
				public void onTick(long millisUntilFinished) {
					dateFormat = new SimpleDateFormat(patternMinute);
					String format = dateFormat.format(millisUntilFinished);
					setText(format);
					//					setText(dateFormat.format(millisUntilFinished+3600000*16));

				}

				@Override
				public void onFinish() {
					setText(dateFormat.format(0));
					if(listener!=null) {
						listener.onFinish();
					}
					stopCount();
				}
			};
			countDownTimer.start();
		}
	}
	private onCountFinishListener listener;
	public void setOnCountFinishListener(onCountFinishListener listener) {
		this.listener = listener;
	}
	public interface onCountFinishListener{
		void onFinish();
	}
	private void stopCount() {
		if(countDownTimer!=null) {
			countDownTimer.cancel();
			countDownTimer = null;
		}
	}
}
