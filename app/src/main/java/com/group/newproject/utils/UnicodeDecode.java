package com.group.newproject.utils;

/**
 * Created by Administrator on 2016/7/29.
 */
public class UnicodeDecode {
    public static String uncodeToUtf_8(String text){

        try {
            if (text!=null) {
                byte[] content = text.getBytes("UTF-8");
                String string = new String(content, "UTF-8");
                return string;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
