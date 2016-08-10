package com.group.newproject.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

abstract class LazyLoadFragment extends Fragment{
   protected boolean isPrepared;
   @Override
   public void setUserVisibleHint(boolean isVisibleToUser) {
       super.setUserVisibleHint(isVisibleToUser);
       if(getUserVisibleHint()){
           onVisible();
       }else{
           onInVisible();
       }
   }
   protected  void onVisible(){
       if(!isPrepared){
           lazyLoad();
           isPrepared = true;
       }else{
           awaysLoad();
       }
   }

    /***
     * 懒加载
     */
   protected abstract void lazyLoad();

    /**
     * 勤加载
     */
   protected void awaysLoad(){

   }
   protected void onInVisible(){

   }
   protected View findViewById(int id) {
       return getView().findViewById(id);
   }

}
