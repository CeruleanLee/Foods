package com.group.newproject;

public interface Contants {

    public static String HOME = "http://api.meishi.cc/v5/index5.php?format=json&source=android";
    public static String HOME2 = "http://api.meishi.cc/v5/index5.php?format=json&source=android&page=2";
    //    public static String RECIPE_DETAIL = "http://123.56.145.151:8080/Recipes/recipe-detail?id={0}";
    public static String GET_REGION_CODE = "http://api.meishi.cc/v5/get_region_code.php?format=json";
    public static String FAXIAN = "http://api.meishi.cc/v5/faxian_new.php?format={0}&rid={1}";
    public static String FOOT_DETAIL = "http://api.meishi.cc/v5/index5.php?format=json&app_liketime=1469635300&source=android&page=2";
    public static String RECIPE_NEWS = "http://api101.meishi.cc/v5/recipe_news.php?source=android&format=json&time=1469516265&from_home_like=0&id=1646040&vk=1d7882c70fac20aabcf11455937e35fd";
//要删除的  没上传Fragment 暂用
//食话 圈子
public static String SHIHUA_QUANZI="http://api.meishi.cc/v5/meishiquan_index4.php?format=json";
    public static String SHIHUA_QUANZI2="http://api.meishi.cc/v5/hot_topic_more3.php?format=json&page={0}";;
    //http://api.meishi.cc/v5/topic.php?format=json&&tid=1147021&&page=1&&gid=20
    public static String SHIHUA_DETAIL="http://api.meishi.cc/v5/topic.php?format=json&&tid={0}&&page=1&&gid=20";
//    http://api.meishi.cc/v5/hot_topic_more3.php?format=json&page=3


//食话 圈子
    /**食话 一进去  实际上是按最新排序的**/
    public static String SH_NEWEST_PAGE1="http://api.meishi.cc/v5/meishiquan_index4.php?format=json";
    /**食话第二页及之后**/
    public static String SH_NEWEST_MORE="http://api.meishi.cc/v5/hot_topic_more3.php?format=json&sort=time&page={0}";
    /**最热 第一页**/
    public static String SH_HOTST_PAGE1="http://api.meishi.cc/v5/meishiquan_index4.php?format=json&sort=hot&page=1";/**最热 加载更多**/
    public static String SH_HOTST_MORE="http://api.meishi.cc/v5/hot_topic_more3.php?format=json&sort=hot&page={0}";
    /**食话详情 第一页**/
    public static String SH_XQ_PAGE1="http://api.meishi.cc/v5/topic.php?format=json&&tid={0}&&page={1}&&gid={2}";
    /**食话详情第二页**/
    public static String SH_XQ_MORE="http://api.meishi.cc/v5/topic.php?format=json&tid={0}&page={1}&gid={2}";
    /**餐桌时光：最热**/
    public static String SH_CZSG_ZR_PAGE1="http://api.meishi.cc/v5/topic_list3.php?format=json&gid={0}&order=hot&page={1}";
    /**餐桌时光：最新**/
    public static String SH_CZSG_ZX_PAGE1="http://api.meishi.cc/v5/topic_list3.php?format=json&gid={0}&order=new&page={1}";
    /**最In活动**/
    public static String SH_ZIHD="http://api.meishi.cc/v5/huodong_list2.php?format=json&page={0}";
    /**最In活动详情**/
    public static String SH_ZIHD_XQ="http://api.meishi.cc/v5/huodong_topic_list2.php?format=json&order=new&hid={0}&page={1}";


    public static String CITY_ALL = "http://api.meishi.cc/v5/get_region_code.php?format={0}";
    /**视频最新接口**/
    public static String VEDIO_LAST = "http://api105.meishi.cc/v5/video_recipe.php?format" +
            "=json&sort=1&page={0}&source=android";
    /**视频最热接口**/
    public static String VEDIO_HOST = "http://api105.meishi.cc/v5/video_recipe.php?format=" +
            "json&sort=2&page=1&source=android";
    /**视频专辑接口**/
    public static String VEDIO_SPECIAL = "http://api105.meishi.cc/v5/video_recipe.php?format" +
            "=json&sort=3&page=1&source=android";
}
