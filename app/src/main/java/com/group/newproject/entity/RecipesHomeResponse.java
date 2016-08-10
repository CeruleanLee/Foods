package com.group.newproject.entity;

import java.util.List;

/**
 * Created by gt72 on 2016-07-27.
 */
public class RecipesHomeResponse {
    /**
     * code : 0
     * result : {"mealList":[{"title":"早餐","tips":"传说中别人家的早餐","list":[{"title":"小鸡烧果子","img":"http://123.56.145.151:8080/recipe/every_meal/zaocan/388319664.jpg","recipeId":1,"tips":"小鸡替你啄走床气，护你周全"},{"title":"原味华夫饼","img":"http://123.56.145.151:8080/recipe/every_meal/zaocan/1597576137.jpg","recipeId":1,"tips":"香甜松软简单易做，起床有了新动力"},{"title":"培根吐司","img":"http://123.56.145.151:8080/recipe/every_meal/zaocan/2036454219.jpg","recipeId":1,"tips":"看上去更高级的早晨，远没你想的难做"}]},{"title":"午餐","tips":"听说卷着吃能提高幸福指数","list":[{"title":"北京烤鸭","img":"http://123.56.145.151:8080/recipe/every_meal/wucan/413414088.jpg","recipeId":1,"tips":"要我说，北京瘫配烤鸭才对得起这个夏天"},{"title":"喷香金针卷","img":"http://123.56.145.151:8080/recipe/every_meal/wucan/903522550.jpg","recipeId":1,"tips":"卷一下，就收获了一加一大于二的效果"},{"title":"京酱肉丝","img":"http://123.56.145.151:8080/recipe/every_meal/wucan/118571060.jpg","recipeId":1,"tips":"就算你吃得再饱，也抵抗不了这盘诱惑"}]},{"title":"下午茶","tips":"冰品在手，整个夏天全都有","list":[{"title":"蓝色海洋","img":"http://123.56.145.151:8080/recipe/every_meal/xiawucha/957551299.jpg","recipeId":1,"tips":"听说这杯酒发到朋友圈引起了一片惊呼"},{"title":"脆顶冰糕","img":"http://123.56.145.151:8080/recipe/every_meal/xiawucha/463292317.jpg","recipeId":1,"tips":"毫无疑问，冰棒还是自己做的好吃"},{"title":"蜜桃多多","img":"http://123.56.145.151:8080/recipe/every_meal/xiawucha/878790698.jpg","recipeId":1,"tips":"世界太复杂，桃子也能有一百种吃法"}]},{"title":"晚餐","tips":"打破无肉不欢的偏见","list":[{"title":"微波炉烧茄子","img":"http://123.56.145.151:8080/recipe/every_meal/wancan/825723016.jpg","recipeId":1,"tips":"晚餐犯懒怕麻烦？用微波炉做啊！"},{"title":"创意烤香肠土豆","img":"http://123.56.145.151:8080/recipe/every_meal/wancan/899855784.jpg","recipeId":1,"tips":"香肠和土豆，请对我的口水负责！"},{"title":"脆皮杏鲍菇","img":"http://123.56.145.151:8080/recipe/every_meal/wancan/1718258400.jpg","recipeId":1,"tips":"鸡米花的邪恶外形，却又一颗善良的心"}]},{"title":"夜宵","tips":"如何如不虚度一个夜晚？来自制吧","list":[{"title":"老干妈肉丁酱","img":"http://123.56.145.151:8080/recipe/every_meal/yexiao/1771070625.jpg","recipeId":1,"tips":"信奉老干妈的人，来膜拜吧"},{"title":"无添加味精","img":"http://123.56.145.151:8080/recipe/every_meal/yexiao/1578513491.jpg","recipeId":1,"tips":"无添加更鲜想，现在就想试"},{"title":"自制蜜红豆","img":"http://123.56.145.151:8080/recipe/every_meal/yexiao/576467998.jpg","recipeId":1,"tips":"制造甜美其实很简单，只需5步"}]}],"recommends":[{"img":"http://123.56.145.151:8080/recipe/today_recommend/img/20160726021412001.jpg","html":"http://123.56.145.151:8080/recipe/today_recommend/htmls/1.html"},{"img":"http://123.56.145.151:8080/recipe/today_recommend/img/20160726021412002.jpg","html":"http://123.56.145.151:8080/recipe/today_recommend/htmls/2.html"},{"img":"http://123.56.145.151:8080/recipe/today_recommend/img/20160726021412003.jpg","html":"http://123.56.145.151:8080/recipe/today_recommend/htmls/3.html"}]}
     */

    private int code;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * title : 早餐
         * tips : 传说中别人家的早餐
         * list : [{"title":"小鸡烧果子","img":"http://123.56.145.151:8080/recipe/every_meal/zaocan/388319664.jpg","recipeId":1,"tips":"小鸡替你啄走床气，护你周全"},{"title":"原味华夫饼","img":"http://123.56.145.151:8080/recipe/every_meal/zaocan/1597576137.jpg","recipeId":1,"tips":"香甜松软简单易做，起床有了新动力"},{"title":"培根吐司","img":"http://123.56.145.151:8080/recipe/every_meal/zaocan/2036454219.jpg","recipeId":1,"tips":"看上去更高级的早晨，远没你想的难做"}]
         */

        private List<MealListBean> mealList;
        /**
         * img : http://123.56.145.151:8080/recipe/today_recommend/img/20160726021412001.jpg
         * html : http://123.56.145.151:8080/recipe/today_recommend/htmls/1.html
         */

        private List<RecommendsBean> recommends;

        public List<MealListBean> getMealList() {
            return mealList;
        }

        public void setMealList(List<MealListBean> mealList) {
            this.mealList = mealList;
        }

        public List<RecommendsBean> getRecommends() {
            return recommends;
        }

        public void setRecommends(List<RecommendsBean> recommends) {
            this.recommends = recommends;
        }

        public static class MealListBean {
            private String title;
            private String tips;
            /**
             * title : 小鸡烧果子
             * img : http://123.56.145.151:8080/recipe/every_meal/zaocan/388319664.jpg
             * recipeId : 1
             * tips : 小鸡替你啄走床气，护你周全
             */

            private List<ListBean> list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String title;
                private String img;
                private int recipeId;
                private String tips;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public int getRecipeId() {
                    return recipeId;
                }

                public void setRecipeId(int recipeId) {
                    this.recipeId = recipeId;
                }

                public String getTips() {
                    return tips;
                }

                public void setTips(String tips) {
                    this.tips = tips;
                }
            }
        }

        public static class RecommendsBean {
            private String img;
            private String html;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }
        }
    }
}
