package com.group.newproject.entity;

import java.util.List;

/**
 * Created by lee on 2016/7/29.
 */
public class SH_Entity {
    public String code;
    public String sort;
    public String earn_price;
    public String promo_code;
    public List<ColumnBean> column;
    public List<Activities2Bean> activities2;
    public List<HotTopicBean> hot_topic;
    /**head2 **/
    public static class ColumnBean {
        public String gid;
        public String type;
        public String name;
        public String img;
    }
    public static class Activities2Bean {
        public String hid;
        public String type;
        public String huodong_type;
        public String img;
    }
    public static class HotTopicBean {
        public UserInfoBean user_info;
        public String gid;
        public String tid;
        public RecipeInfoBean recipe_info;
        public int img_num;
        public String summary;
        public String time;
        public int comment_num;
        public String is_ding;
        public String is_cai;
        public String ding_num;
        public String cai_num;
        public String zhiding;
        public String sourceType;

        public List<ImgsBean> imgs;
        public List<?> recipes;
        public static class UserInfoBean {
            public String user_id;
            public String user_name;
            public String avatar;
            public String signature;
            public String if_v;

        }

        public static class RecipeInfoBean {
            public String title;

            public FromBean from;
            public static class FromBean {
                public String class_name;

                public PropertyBean property;

                public static class PropertyBean {
                    public String gid;
                    public String type;
                }
            }
        }
        public static class ImgsBean {
            public String small;
            public String width;
            public String height;
        }
    }
}
