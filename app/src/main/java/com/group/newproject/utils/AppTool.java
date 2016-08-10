package com.group.newproject.utils;

import android.text.TextUtils;

public class AppTool {
	/**
	 * 解密菜谱详情中的smalltext
	 * @param str
	 * @return
	 */
	public static String decrypt(String str){
		if(TextUtils.isEmpty(str)){
			return "";
		}
		return str.replace("@", "4").replace("$", "E").replace("!", "B").replace("&", "C");
	}
	
}
