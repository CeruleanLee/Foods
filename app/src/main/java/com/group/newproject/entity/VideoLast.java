package com.group.newproject.entity;

import java.util.List;

/**
 * 最新和最热-视频-一样的o(∩_∩)o 哈哈
 * 接口： public static String VEDIO_LAST = "http://api105.meishi.cc/v5/video_recipe.php?format=json&sort=1&page=1&source=android";
 * Created by yp on 2016/7/29.
 */
public class VideoLast {

    /**
     * ad : [{"photo":"http://site.meishij.net/article/video_img/20160729/20160729103402_986.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2920&udid=&user_id=0&vid=XMTY1MjY4NTg4MA==\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160728/20160728095443_127.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2914&udid=&user_id=0&vid=XMTYyNTM4MjM2NA==\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160727/20160727101036_956.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2917&udid=&user_id=0&vid=XMTYwMDY5NTA3Ng==\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160726/20160726113344_684.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2904&udid=&user_id=0&vid=XOTMzODk2MDQw\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160722/20160722182015_977.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2895&udid=&user_id=0&vid=XMTY1MjY2MTAxMg==\",\"goodsSource\":\"\"}}"}]
     * video_recommend : {"title":"推荐的美食家","data":[{"img":"http://site.meishij.net/article/video_img/20160517124438146346027897823.jpg","name":"味蕾时光","id":"10"},{"img":"http://site.meishij.net/article/video_img/20160516163203146338752389891.jpg","name":"日食记","id":"2"},{"img":"http://site.meishij.net/article/video_img/20160518145417146355445738241.jpg","name":"咕噜减脂餐","id":"19"},{"img":"http://site.meishij.net/article/video_img/20160620/20160620173605_584.png","name":"日日煮","id":"4"},{"img":"http://site.meishij.net/article/video_img/20160620/20160620175436_534.png","name":"厨娘物语","id":"5"}]}
     * video_list : [{"describtion":"咸蛋抱糯米","play_times":"21次播放 / 1'00\"","time_length":"1'00\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729103840_245.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1OTg3MDg2OA==&sid=2921&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160629/20160629115054_553.jpg","name":"太阳猫早餐","id":"41"},{"describtion":"还买什么冰棍啊 自己拿水果做啊","play_times":"48次播放 / 2'40\"","time_length":"2'40\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729103347_108.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1MjY4NTg4MA==&sid=2920&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160620/20160620173215_913.png","name":"微在涨姿势","id":"1"},{"describtion":"Hello kitty牛奶布丁","play_times":"34次播放 / 2'01\"","time_length":"2'01\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729102207_224.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY2MDAxMDYxMg==&sid=2919&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160718/20160718104223_886.jpg","name":"膳小姐","id":"43"},{"describtion":"原来啤酒还能这么喝","play_times":"35次播放 / 1'53\"","time_length":"1'53\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729101747_253.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTYzOTQ3MDA5Mg==&sid=2918&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725122216_885.png","name":"一杯","id":"50"},{"describtion":"黄金虾仁炒饭","play_times":"1376次播放 / 2'42\"","time_length":"2'42\"","img_video":"http://site.meishij.net/article/video_img/20160726/20160726104544_144.jpg","time":"07-28更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTQ5NzQyMTgwOA==&sid=2898&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725102002_255.png","name":"最美的味道TV","id":"49"},{"describtion":"蒜蓉粉丝蒸扇贝","play_times":"1743次播放 / 6'41\"","time_length":"6'41\"","img_video":"http://site.meishij.net/article/video_img/20160726/20160726141803_185.jpg","time":"07-28更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTYyNTM4MjM2NA==&sid=2914&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725103957_612.jpg","name":"Freesiaa Made","id":"44"},{"describtion":"小黄人奶昔","play_times":"996次播放 / 1'59\"","time_length":"1'59\"","img_video":"http://site.meishij.net/article/video_img/20160727/20160727095127_496.jpg","time":"07-28更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTI4ODM1NTQ2OA==&sid=2916&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725101021_493.png","name":"食色记","id":"46"},{"describtion":"正宗台式三杯鸡","play_times":"2913次播放 / 2'27\"","time_length":"2'27\"","img_video":"http://site.meishij.net/article/video_img/20160727/20160727100818_291.jpg","time":"07-27更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTYwMDY5NTA3Ng==&sid=2917&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725105652_809.png","name":"美食的秘密","id":"47"},{"describtion":"意大利红烩海鲜锅","play_times":"977次播放 / 6'00\"","time_length":"6'00\"","img_video":"http://site.meishij.net/article/video_img/20160727/20160727094523_928.jpg","time":"07-27更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTI4Mjg0MTg0MA==&sid=2915&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725101744_233.png","name":"小辛的环球美食","id":"48"},{"describtion":"石斛苦瓜炖鲍鱼","play_times":"602次播放 / 3'00\"","time_length":"3'00\"","img_video":"http://site.meishij.net/article/video_img/20160722/20160722174910_813.jpg","time":"07-27更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1MTAwNTc3Mg==&sid=2893&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160620/20160620181519_862.png","name":"美食台","id":"7"}]
     */

    private ObjBean obj;
    /**
     * obj : {"ad":[{"photo":"http://site.meishij.net/article/video_img/20160729/20160729103402_986.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2920&udid=&user_id=0&vid=XMTY1MjY4NTg4MA==\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160728/20160728095443_127.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2914&udid=&user_id=0&vid=XMTYyNTM4MjM2NA==\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160727/20160727101036_956.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2917&udid=&user_id=0&vid=XMTYwMDY5NTA3Ng==\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160726/20160726113344_684.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2904&udid=&user_id=0&vid=XOTMzODk2MDQw\",\"goodsSource\":\"\"}}"},{"photo":"http://site.meishij.net/article/video_img/20160722/20160722182015_977.jpg","click_type":4,"click_obj":"","pv_trackingURL":"","click_trackingURL":"","is_recipe":"0","sft":"0","jump":"{\"type\":\"4\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"http:\\/\\/api.meishi.cc\\/v5\\/ykPlayer.php?sid=2895&udid=&user_id=0&vid=XMTY1MjY2MTAxMg==\",\"goodsSource\":\"\"}}"}],"video_recommend":{"title":"推荐的美食家","data":[{"img":"http://site.meishij.net/article/video_img/20160517124438146346027897823.jpg","name":"味蕾时光","id":"10"},{"img":"http://site.meishij.net/article/video_img/20160516163203146338752389891.jpg","name":"日食记","id":"2"},{"img":"http://site.meishij.net/article/video_img/20160518145417146355445738241.jpg","name":"咕噜减脂餐","id":"19"},{"img":"http://site.meishij.net/article/video_img/20160620/20160620173605_584.png","name":"日日煮","id":"4"},{"img":"http://site.meishij.net/article/video_img/20160620/20160620175436_534.png","name":"厨娘物语","id":"5"}]},"video_list":[{"describtion":"咸蛋抱糯米","play_times":"21次播放 / 1'00\"","time_length":"1'00\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729103840_245.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1OTg3MDg2OA==&sid=2921&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160629/20160629115054_553.jpg","name":"太阳猫早餐","id":"41"},{"describtion":"还买什么冰棍啊 自己拿水果做啊","play_times":"48次播放 / 2'40\"","time_length":"2'40\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729103347_108.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1MjY4NTg4MA==&sid=2920&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160620/20160620173215_913.png","name":"微在涨姿势","id":"1"},{"describtion":"Hello kitty牛奶布丁","play_times":"34次播放 / 2'01\"","time_length":"2'01\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729102207_224.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY2MDAxMDYxMg==&sid=2919&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160718/20160718104223_886.jpg","name":"膳小姐","id":"43"},{"describtion":"原来啤酒还能这么喝","play_times":"35次播放 / 1'53\"","time_length":"1'53\"","img_video":"http://site.meishij.net/article/video_img/20160729/20160729101747_253.jpg","time":"07-29更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTYzOTQ3MDA5Mg==&sid=2918&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725122216_885.png","name":"一杯","id":"50"},{"describtion":"黄金虾仁炒饭","play_times":"1376次播放 / 2'42\"","time_length":"2'42\"","img_video":"http://site.meishij.net/article/video_img/20160726/20160726104544_144.jpg","time":"07-28更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTQ5NzQyMTgwOA==&sid=2898&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725102002_255.png","name":"最美的味道TV","id":"49"},{"describtion":"蒜蓉粉丝蒸扇贝","play_times":"1743次播放 / 6'41\"","time_length":"6'41\"","img_video":"http://site.meishij.net/article/video_img/20160726/20160726141803_185.jpg","time":"07-28更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTYyNTM4MjM2NA==&sid=2914&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725103957_612.jpg","name":"Freesiaa Made","id":"44"},{"describtion":"小黄人奶昔","play_times":"996次播放 / 1'59\"","time_length":"1'59\"","img_video":"http://site.meishij.net/article/video_img/20160727/20160727095127_496.jpg","time":"07-28更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTI4ODM1NTQ2OA==&sid=2916&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725101021_493.png","name":"食色记","id":"46"},{"describtion":"正宗台式三杯鸡","play_times":"2913次播放 / 2'27\"","time_length":"2'27\"","img_video":"http://site.meishij.net/article/video_img/20160727/20160727100818_291.jpg","time":"07-27更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTYwMDY5NTA3Ng==&sid=2917&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725105652_809.png","name":"美食的秘密","id":"47"},{"describtion":"意大利红烩海鲜锅","play_times":"977次播放 / 6'00\"","time_length":"6'00\"","img_video":"http://site.meishij.net/article/video_img/20160727/20160727094523_928.jpg","time":"07-27更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTI4Mjg0MTg0MA==&sid=2915&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160725/20160725101744_233.png","name":"小辛的环球美食","id":"48"},{"describtion":"石斛苦瓜炖鲍鱼","play_times":"602次播放 / 3'00\"","time_length":"3'00\"","img_video":"http://site.meishij.net/article/video_img/20160722/20160722174910_813.jpg","time":"07-27更新","show_type":"1","vurl":"http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1MTAwNTc3Mg==&sid=2893&udid=&user_id=0","img":"http://site.meishij.net/article/video_img/20160620/20160620181519_862.png","name":"美食台","id":"7"}]}
     * code : 1
     * msg : 成功
     */

    private String code;
    private String msg;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class ObjBean {
        /**
         * title : 推荐的美食家
         * data : [{"img":"http://site.meishij.net/article/video_img/20160517124438146346027897823.jpg","name":"味蕾时光","id":"10"},{"img":"http://site.meishij.net/article/video_img/20160516163203146338752389891.jpg","name":"日食记","id":"2"},{"img":"http://site.meishij.net/article/video_img/20160518145417146355445738241.jpg","name":"咕噜减脂餐","id":"19"},{"img":"http://site.meishij.net/article/video_img/20160620/20160620173605_584.png","name":"日日煮","id":"4"},{"img":"http://site.meishij.net/article/video_img/20160620/20160620175436_534.png","name":"厨娘物语","id":"5"}]
         */

        private VideoRecommendBean video_recommend;
        /**
         * photo : http://site.meishij.net/article/video_img/20160729/20160729103402_986.jpg
         * click_type : 4
         * click_obj :
         * pv_trackingURL :
         * click_trackingURL :
         * is_recipe : 0
         * sft : 0
         * jump : {"type":"4","class_name":"MSJWebAdvViewController","property":{"urlString":"http:\/\/api.meishi.cc\/v5\/ykPlayer.php?sid=2920&udid=&user_id=0&vid=XMTY1MjY4NTg4MA==","goodsSource":""}}
         */

        private List<AdBean> ad;
        /**
         * describtion : 咸蛋抱糯米
         * play_times : 21次播放 / 1'00"
         * time_length : 1'00"
         * img_video : http://site.meishij.net/article/video_img/20160729/20160729103840_245.jpg
         * time : 07-29更新
         * show_type : 1
         * vurl : http://api.meishi.cc/v5/ykPlayer.php?vid=XMTY1OTg3MDg2OA==&sid=2921&udid=&user_id=0
         * img : http://site.meishij.net/article/video_img/20160629/20160629115054_553.jpg
         * name : 太阳猫早餐
         * id : 41
         */

        private List<VideoListBean> video_list;

        public VideoRecommendBean getVideo_recommend() {
            return video_recommend;
        }

        public void setVideo_recommend(VideoRecommendBean video_recommend) {
            this.video_recommend = video_recommend;
        }

        public List<AdBean> getAd() {
            return ad;
        }

        public void setAd(List<AdBean> ad) {
            this.ad = ad;
        }

        public List<VideoListBean> getVideo_list() {
            return video_list;
        }

        public void setVideo_list(List<VideoListBean> video_list) {
            this.video_list = video_list;
        }

        public static class VideoRecommendBean {
            private String title;
            /**
             * img : http://site.meishij.net/article/video_img/20160517124438146346027897823.jpg
             * name : 味蕾时光
             * id : 10
             */

            private List<DataBean> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                private String img;
                private String name;
                private String id;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class AdBean {
            private String photo;
            private int click_type;
            private String click_obj;
            private String pv_trackingURL;
            private String click_trackingURL;
            private String is_recipe;
            private String sft;
            private String jump;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getClick_type() {
                return click_type;
            }

            public void setClick_type(int click_type) {
                this.click_type = click_type;
            }

            public String getClick_obj() {
                return click_obj;
            }

            public void setClick_obj(String click_obj) {
                this.click_obj = click_obj;
            }

            public String getPv_trackingURL() {
                return pv_trackingURL;
            }

            public void setPv_trackingURL(String pv_trackingURL) {
                this.pv_trackingURL = pv_trackingURL;
            }

            public String getClick_trackingURL() {
                return click_trackingURL;
            }

            public void setClick_trackingURL(String click_trackingURL) {
                this.click_trackingURL = click_trackingURL;
            }

            public String getIs_recipe() {
                return is_recipe;
            }

            public void setIs_recipe(String is_recipe) {
                this.is_recipe = is_recipe;
            }

            public String getSft() {
                return sft;
            }

            public void setSft(String sft) {
                this.sft = sft;
            }

            public String getJump() {
                return jump;
            }

            public void setJump(String jump) {
                this.jump = jump;
            }
        }

        public static class VideoListBean {
            private String describtion;
            private String play_times;
            private String time_length;
            private String img_video;
            private String time;
            private String show_type;
            private String vurl;
            private String img;
            private String name;
            private String id;

            public String getDescribtion() {
                return describtion;
            }

            public void setDescribtion(String describtion) {
                this.describtion = describtion;
            }

            public String getPlay_times() {
                return play_times;
            }

            public void setPlay_times(String play_times) {
                this.play_times = play_times;
            }

            public String getTime_length() {
                return time_length;
            }

            public void setTime_length(String time_length) {
                this.time_length = time_length;
            }

            public String getImg_video() {
                return img_video;
            }

            public void setImg_video(String img_video) {
                this.img_video = img_video;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getShow_type() {
                return show_type;
            }

            public void setShow_type(String show_type) {
                this.show_type = show_type;
            }

            public String getVurl() {
                return vurl;
            }

            public void setVurl(String vurl) {
                this.vurl = vurl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
