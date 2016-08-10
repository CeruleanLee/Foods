package com.group.newproject.utils;

import com.group.newproject.entity.CityGuide;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class CityLetterSort {
    public static void getSortList(List<CityGuide.CityAllBean> list ){
        Collections.sort(list, new Comparator<CityGuide.CityAllBean>() {
            @Override
            public int compare(CityGuide.CityAllBean t1, CityGuide.CityAllBean t2) {
                return t1.getPinyin().charAt(0)-t2.getPinyin().charAt(0);
            }
        });
    }
}
