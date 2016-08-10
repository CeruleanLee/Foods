package com.group.newproject.entity;

import java.util.List;

/**
 * Created by gt72 on 2016-07-27.
 */
public class RecipeDetailResponse {
    /**
     * code : 0
     * result : {"id":1,"title":"面包机版草莓冰激凌","tips":"俺的面包机，配了冰激凌桶，双剑合璧，功能很强大，用它做了冰激凌，效果很好，刚刚做好就是那种软的冰激凌，如果在冷冻一下，就会硬一点，但依然是非常适口，很赞的，而且自己做的绝对没有防腐剂添加剂之类的，奶油也是用的好的，从口感到质量都没的说哦。这款冰激凌也没有用鸡蛋，用了大量的淡奶油，所以做法简单，奶香味更足。","gongyi":"冻","nandu":"新手尝试","renshu":"5人份","kouwei":"奶香味","zhunbeiTime":"数小时","cookingTime":"<30分钟","zhuliao":[{"title":"淡奶油","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431128.jpg","count":"130克"},{"title":"酸奶","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431160.jpg","count":"80克"},{"title":"草莓酱","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431234.jpg","count":"60克"}],"fuliao":[{"title":"冰糖粉","count":"30克"}],"steps":[{"title":"先将冰激凌桶洗净，然后用保鲜袋装好放入冰箱冷冻室，-18冷冻15小时以上，我是冻了一整天","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431370.jpg"},{"title":"淡奶油打发，不打发也可以，搅拌到浓稠就行。我是刚好打发的淡奶油多，就直接用了","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431396.jpg"},{"title":"加入酸奶和冰糖粉","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431418.jpg"},{"title":"搅拌均匀","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431442.jpg"},{"title":"加入草莓果酱","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431462.jpg"},{"title":"搅拌均匀","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431484.jpg"},{"title":"拌好的冰激凌糊如果温度过高，放入冰箱冷藏室降温，待温度降到5--10度，取出","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431505.jpg"},{"title":"此时把冰激凌桶从冷冻室取出，安装到柏翠面包机里，把冰激凌糊倒入桶里","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431525.jpg"},{"title":"开iMix功能键，也就是功能11的键，默认是20分钟，因为量不大，20分钟就可以了，如果冰激凌糊温度稍高的话，则可以加5--10分钟","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431544.jpg"},{"title":"面包机搅拌过程中我拍了一张图，这是一件搅拌了13分钟了","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431564.jpg"},{"title":"20分钟后，冰激凌就完成了，可以立即吃，吃不完的放保鲜盒冷冻起来即可","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431584.jpg"}],"endImgs":["http://123.56.145.151:8080/recipe/recipes_img/1469570431606.jpg","http://123.56.145.151:8080/recipe/recipes_img/1469570431630.jpg","http://123.56.145.151:8080/recipe/recipes_img/1469570431652.jpg","http://123.56.145.151:8080/recipe/recipes_img/1469570431673.jpg"],"cookingSkill":"我喜欢用冰糖粉，也就是冰糖自己研磨的粉，也可以用等量的白糖。因为草莓酱也是甜的，所以糖的量不需要太多","collectedNum":293,"browseNum":170,"sharedNum":2780,"commentNum":14,"author":{"id":0,"name":"万山红","img":"http://site.meishij.net/user/114/34/t1258614_59132.jpg","recipeCount":381,"guanzhuCount":17,"fensiCount":5130},"publishTime":"1441223656711"}
     */

    private int code;
    /**
     * id : 1
     * title : 面包机版草莓冰激凌
     * tips : 俺的面包机，配了冰激凌桶，双剑合璧，功能很强大，用它做了冰激凌，效果很好，刚刚做好就是那种软的冰激凌，如果在冷冻一下，就会硬一点，但依然是非常适口，很赞的，而且自己做的绝对没有防腐剂添加剂之类的，奶油也是用的好的，从口感到质量都没的说哦。这款冰激凌也没有用鸡蛋，用了大量的淡奶油，所以做法简单，奶香味更足。
     * gongyi : 冻
     * nandu : 新手尝试
     * renshu : 5人份
     * kouwei : 奶香味
     * zhunbeiTime : 数小时
     * cookingTime : <30分钟
     * zhuliao : [{"title":"淡奶油","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431128.jpg","count":"130克"},{"title":"酸奶","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431160.jpg","count":"80克"},{"title":"草莓酱","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431234.jpg","count":"60克"}]
     * fuliao : [{"title":"冰糖粉","count":"30克"}]
     * steps : [{"title":"先将冰激凌桶洗净，然后用保鲜袋装好放入冰箱冷冻室，-18冷冻15小时以上，我是冻了一整天","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431370.jpg"},{"title":"淡奶油打发，不打发也可以，搅拌到浓稠就行。我是刚好打发的淡奶油多，就直接用了","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431396.jpg"},{"title":"加入酸奶和冰糖粉","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431418.jpg"},{"title":"搅拌均匀","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431442.jpg"},{"title":"加入草莓果酱","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431462.jpg"},{"title":"搅拌均匀","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431484.jpg"},{"title":"拌好的冰激凌糊如果温度过高，放入冰箱冷藏室降温，待温度降到5--10度，取出","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431505.jpg"},{"title":"此时把冰激凌桶从冷冻室取出，安装到柏翠面包机里，把冰激凌糊倒入桶里","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431525.jpg"},{"title":"开iMix功能键，也就是功能11的键，默认是20分钟，因为量不大，20分钟就可以了，如果冰激凌糊温度稍高的话，则可以加5--10分钟","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431544.jpg"},{"title":"面包机搅拌过程中我拍了一张图，这是一件搅拌了13分钟了","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431564.jpg"},{"title":"20分钟后，冰激凌就完成了，可以立即吃，吃不完的放保鲜盒冷冻起来即可","img":"http://123.56.145.151:8080/recipe/recipes_img/1469570431584.jpg"}]
     * endImgs : ["http://123.56.145.151:8080/recipe/recipes_img/1469570431606.jpg","http://123.56.145.151:8080/recipe/recipes_img/1469570431630.jpg","http://123.56.145.151:8080/recipe/recipes_img/1469570431652.jpg","http://123.56.145.151:8080/recipe/recipes_img/1469570431673.jpg"]
     * cookingSkill : 我喜欢用冰糖粉，也就是冰糖自己研磨的粉，也可以用等量的白糖。因为草莓酱也是甜的，所以糖的量不需要太多
     * collectedNum : 293
     * browseNum : 170
     * sharedNum : 2780
     * commentNum : 14
     * author : {"id":0,"name":"万山红","img":"http://site.meishij.net/user/114/34/t1258614_59132.jpg","recipeCount":381,"guanzhuCount":17,"fensiCount":5130}
     * publishTime : 1441223656711
     */

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
        private int id;
        private String title;
        private String tips;
        private String gongyi;
        private String nandu;
        private String renshu;
        private String kouwei;
        private String zhunbeiTime;
        private String cookingTime;
        private String cookingSkill;
        private int collectedNum;
        private int browseNum;
        private int sharedNum;
        private int commentNum;
        /**
         * id : 0
         * name : 万山红
         * img : http://site.meishij.net/user/114/34/t1258614_59132.jpg
         * recipeCount : 381
         * guanzhuCount : 17
         * fensiCount : 5130
         */

        private AuthorBean author;
        private String publishTime;
        /**
         * title : 淡奶油
         * img : http://123.56.145.151:8080/recipe/recipes_img/1469570431128.jpg
         * count : 130克
         */

        private List<ZhuliaoBean> zhuliao;
        /**
         * title : 冰糖粉
         * count : 30克
         */

        private List<FuliaoBean> fuliao;
        /**
         * title : 先将冰激凌桶洗净，然后用保鲜袋装好放入冰箱冷冻室，-18冷冻15小时以上，我是冻了一整天
         * img : http://123.56.145.151:8080/recipe/recipes_img/1469570431370.jpg
         */

        private List<StepsBean> steps;
        private List<String> endImgs;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getGongyi() {
            return gongyi;
        }

        public void setGongyi(String gongyi) {
            this.gongyi = gongyi;
        }

        public String getNandu() {
            return nandu;
        }

        public void setNandu(String nandu) {
            this.nandu = nandu;
        }

        public String getRenshu() {
            return renshu;
        }

        public void setRenshu(String renshu) {
            this.renshu = renshu;
        }

        public String getKouwei() {
            return kouwei;
        }

        public void setKouwei(String kouwei) {
            this.kouwei = kouwei;
        }

        public String getZhunbeiTime() {
            return zhunbeiTime;
        }

        public void setZhunbeiTime(String zhunbeiTime) {
            this.zhunbeiTime = zhunbeiTime;
        }

        public String getCookingTime() {
            return cookingTime;
        }

        public void setCookingTime(String cookingTime) {
            this.cookingTime = cookingTime;
        }

        public String getCookingSkill() {
            return cookingSkill;
        }

        public void setCookingSkill(String cookingSkill) {
            this.cookingSkill = cookingSkill;
        }

        public int getCollectedNum() {
            return collectedNum;
        }

        public void setCollectedNum(int collectedNum) {
            this.collectedNum = collectedNum;
        }

        public int getBrowseNum() {
            return browseNum;
        }

        public void setBrowseNum(int browseNum) {
            this.browseNum = browseNum;
        }

        public int getSharedNum() {
            return sharedNum;
        }

        public void setSharedNum(int sharedNum) {
            this.sharedNum = sharedNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public List<ZhuliaoBean> getZhuliao() {
            return zhuliao;
        }

        public void setZhuliao(List<ZhuliaoBean> zhuliao) {
            this.zhuliao = zhuliao;
        }

        public List<FuliaoBean> getFuliao() {
            return fuliao;
        }

        public void setFuliao(List<FuliaoBean> fuliao) {
            this.fuliao = fuliao;
        }

        public List<StepsBean> getSteps() {
            return steps;
        }

        public void setSteps(List<StepsBean> steps) {
            this.steps = steps;
        }

        public List<String> getEndImgs() {
            return endImgs;
        }

        public void setEndImgs(List<String> endImgs) {
            this.endImgs = endImgs;
        }

        public static class AuthorBean {
            private int id;
            private String name;
            private String img;
            private int recipeCount;
            private int guanzhuCount;
            private int fensiCount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getRecipeCount() {
                return recipeCount;
            }

            public void setRecipeCount(int recipeCount) {
                this.recipeCount = recipeCount;
            }

            public int getGuanzhuCount() {
                return guanzhuCount;
            }

            public void setGuanzhuCount(int guanzhuCount) {
                this.guanzhuCount = guanzhuCount;
            }

            public int getFensiCount() {
                return fensiCount;
            }

            public void setFensiCount(int fensiCount) {
                this.fensiCount = fensiCount;
            }
        }

        public static class ZhuliaoBean {
            private String title;
            private String img;
            private String count;

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

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }
        }

        public static class FuliaoBean {
            private String title;
            private String count;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }
        }

        public static class StepsBean {
            private String title;
            private String img;

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
        }
    }
}
