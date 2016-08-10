package com.group.newproject.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SoftKeyboardTool {
	/**
	 * ΪEdieText���õ��������
	 * @param et
	 */
	public static void showSoftKeyboard(EditText et){
		InputMethodManager imm=(InputMethodManager)et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(et,InputMethodManager.RESULT_SHOWN);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
	}
	//�ر������  
	public static void closeKeyboard(EditText et) {  
		InputMethodManager imm = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);  
		imm.hideSoftInputFromWindow(et.getWindowToken(), 0); 
	} 
}
