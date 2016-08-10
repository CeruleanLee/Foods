package com.group.newproject.entity;

import java.util.List;

/**
 * Created by gt72 on 2016-07-30.
 */
public class Guess {

    /**
     * code : 1
     * obj : {"customized":{"title":"猜你喜欢","time":"14:58为您更新","total":2,"data":[{"id":"1629872","title":"春意盎然蛋糕卷","titlepic":"http://site.meishij.net/r/37/91/3960287/a3960287_143014614814846.jpg","is_recipe":1},{"id":"612274","title":"酸辣土豆丝","titlepic":"http://site.meishij.net/r/211/151/2850461/a2850461_97417.jpg","is_recipe":1},{"id":"1675721","title":"香草新奥尔良煎牛","titlepic":"http://site.meishij.net/r/37/123/4218287/a4218287_146212054510863.jpg","is_recipe":1},{"id":"1678726","title":"鲜虾蔬菜饼","titlepic":"http://site.meishij.net/r/241/90/6147741/a6147741_146337652793209.jpg","is_recipe":1},{"id":"1616102","title":"鱼香排骨蒸南瓜","titlepic":"http://site.meishij.net/r/28/38/3197028/a3197028_27061.jpg","is_recipe":1},{"id":"1675703","title":"五彩缤纷酸奶杯","titlepic":"http://site.meishij.net/r/95/144/5286095/a5286095_146211652762770.jpg","is_recipe":1},{"id":"615445","title":"红烧肉","titlepic":"http://site.meishij.net/r/153/33/3070903/a3070903_35379.jpg","is_recipe":1},{"id":"1676072","title":"日式茶碗蒸","titlepic":"http://site.meishij.net/r/161/96/5149161/a5149161_146233410054686.jpg","is_recipe":1},{"id":"1682487","title":"花开蒜泥白肉","titlepic":"http://site.meishij.net/r/06/129/5469756/a5469756_146442316924535.jpg","is_recipe":1},{"id":"1675647","title":"水果蛋糕","titlepic":"http://site.meishij.net/r/141/205/4176391/a4176391_146209428941191.jpg","is_recipe":1},{"id":"1676172","title":"香草烤羊腩肉串","titlepic":"http://site.meishij.net/r/114/34/1258614/a1258614_146236351955533.jpg","is_recipe":1},{"id":"1675674","title":"＃苏泊尔·真磨醇","titlepic":"http://site.meishij.net/r/164/50/4700164/a4700164_146211347965594.jpg","is_recipe":1},{"id":"611546","title":"牛肉千层饼","titlepic":"http://site.meishij.net/r/13/237/2059263/a2059263_27565.jpg","is_recipe":1},{"id":"1657935","title":"清汤牛肉面","titlepic":"http://site.meishij.net/r/115/13/2253365/a2253365_145042012843007.jpg","is_recipe":1},{"id":"1615296","title":"蒜香烤肋排","titlepic":"http://site.meishij.net/r/41/203/113291/a113291_75761.jpg","is_recipe":1},{"id":"1642892","title":"天津蒸饼","titlepic":"http://site.meishij.net/r/225/38/3259725/a3259725_143875047081623.jpg","is_recipe":1},{"id":"1615501","title":"肉末雪里蕻","titlepic":"http://site.meishij.net/r/41/203/113291/a113291_50109.jpg","is_recipe":1},{"id":"1658228","title":"圣诞杯子蛋糕","titlepic":"http://site.meishij.net/r/23/28/69523/a69523_145068579184254.jpg","is_recipe":1},{"id":"1657951","title":"鸡汁百叶包肉","titlepic":"http://site.meishij.net/r/164/169/5042414/a5042414_145042176534685.jpg","is_recipe":1},{"id":"615177","title":"蜂蜜柠檬茶","titlepic":"http://site.meishij.net/r/202/30/2945202/a2945202_89195.jpg","is_recipe":1},{"id":"1642702","title":"天津麻酱面","titlepic":"http://site.meishij.net/r/225/38/3259725/a3259725_143865458726022.jpg","is_recipe":1},{"id":"611731","title":"奶香紫薯吐司","titlepic":"http://site.meishij.net/r/23/237/621773/a621773_98743.jpg","is_recipe":1},{"id":"1676003","title":"蒜蓉蒸丝瓜","titlepic":"http://site.meishij.net/r/245/13/2378495/a2378495_146227768104225.jpg","is_recipe":1},{"id":"1676148","title":"桂花红薯香芋百合","titlepic":"http://site.meishij.net/r/155/28/5882155/a5882155_146235415199347.jpg","is_recipe":1},{"id":"1643567","title":"油泼辣子羊肉云吞","titlepic":"http://site.meishij.net/r/15/201/3050265/a3050265_143912250846972.jpg","is_recipe":1},{"id":"1665425","title":"土耳其沙玛威（烤","titlepic":"http://site.meishij.net/r/203/57/5639453/a5639453_145621600044829.jpg","is_recipe":1},{"id":"1658267","title":"红糖核桃枣香包","titlepic":"http://site.meishij.net/r/105/225/1306355/a1306355_145070126157552.jpg","is_recipe":1},{"id":"1632147","title":"爆炒螺蛳","titlepic":"http://site.meishij.net/r/246/109/4089996/a4089996_143178207466519.jpg","is_recipe":1},{"id":"1615173","title":"双夹超级热狗","titlepic":"http://site.meishij.net/r/40/99/2087290/a2087290_81524.jpg","is_recipe":1},{"id":"1678725","title":"香蕉戚风蛋糕","titlepic":"http://site.meishij.net/r/232/49/6199982/a6199982_146337649296090.jpg","is_recipe":1},{"id":"611793","title":"广式香肠炒饭便当","titlepic":"http://site.meishij.net/r/191/59/2702441/a2702441_16408.jpg","is_recipe":1},{"id":"1675739","title":"黄瓜树","titlepic":"http://site.meishij.net/r/228/33/5570978/a5570978_146216219868619.jpg","is_recipe":1},{"id":"1642185","title":"青柠罂粟籽马芬","titlepic":"http://site.meishij.net/r/66/59/2764816/a2764816_143660371455955.jpg","is_recipe":1},{"id":"1675702","title":"外脆里嫩的炸牛奶","titlepic":"http://site.meishij.net/r/35/150/5537535/a5537535_146211847124279.jpg","is_recipe":1},{"id":"1675993","title":"不爱吃菠菜的宝宝","titlepic":"http://site.meishij.net/r/178/85/5833928/a5833928_146227454240628.jpg","is_recipe":1},{"id":"1682900","title":"梅豆炖土豆辣椒","titlepic":"http://site.meishij.net/r/137/154/2413637/a2413637_146460863281009.jpg","is_recipe":1},{"id":"1643556","title":"小炒腊猪耳","titlepic":"http://site.meishij.net/r/180/228/494680/a494680_143917779826950.jpg","is_recipe":1},{"id":"1637817","title":"炼乳鸡蛋吐司","titlepic":"http://site.meishij.net/r/85/125/4406335/a4406335_143521252919768.jpg","is_recipe":1},{"id":"1678793","title":"韩式辣酱鸡爪","titlepic":"http://site.meishij.net/r/174/213/2303424/a2303424_146338834565693.jpg","is_recipe":1},{"id":"1678251","title":"糍粑","titlepic":"http://site.meishij.net/r/184/229/5557434/a5557434_146314998309461.jpg","is_recipe":1}],"time_app":"1469861887"},"like_mem_key":"88a43e68a29d5283fd4ee39fad2704eb"}
     */

    private String code;
    /**
     * customized : {"title":"猜你喜欢","time":"14:58为您更新","total":2,"data":[{"id":"1629872","title":"春意盎然蛋糕卷","titlepic":"http://site.meishij.net/r/37/91/3960287/a3960287_143014614814846.jpg","is_recipe":1},{"id":"612274","title":"酸辣土豆丝","titlepic":"http://site.meishij.net/r/211/151/2850461/a2850461_97417.jpg","is_recipe":1},{"id":"1675721","title":"香草新奥尔良煎牛","titlepic":"http://site.meishij.net/r/37/123/4218287/a4218287_146212054510863.jpg","is_recipe":1},{"id":"1678726","title":"鲜虾蔬菜饼","titlepic":"http://site.meishij.net/r/241/90/6147741/a6147741_146337652793209.jpg","is_recipe":1},{"id":"1616102","title":"鱼香排骨蒸南瓜","titlepic":"http://site.meishij.net/r/28/38/3197028/a3197028_27061.jpg","is_recipe":1},{"id":"1675703","title":"五彩缤纷酸奶杯","titlepic":"http://site.meishij.net/r/95/144/5286095/a5286095_146211652762770.jpg","is_recipe":1},{"id":"615445","title":"红烧肉","titlepic":"http://site.meishij.net/r/153/33/3070903/a3070903_35379.jpg","is_recipe":1},{"id":"1676072","title":"日式茶碗蒸","titlepic":"http://site.meishij.net/r/161/96/5149161/a5149161_146233410054686.jpg","is_recipe":1},{"id":"1682487","title":"花开蒜泥白肉","titlepic":"http://site.meishij.net/r/06/129/5469756/a5469756_146442316924535.jpg","is_recipe":1},{"id":"1675647","title":"水果蛋糕","titlepic":"http://site.meishij.net/r/141/205/4176391/a4176391_146209428941191.jpg","is_recipe":1},{"id":"1676172","title":"香草烤羊腩肉串","titlepic":"http://site.meishij.net/r/114/34/1258614/a1258614_146236351955533.jpg","is_recipe":1},{"id":"1675674","title":"＃苏泊尔·真磨醇","titlepic":"http://site.meishij.net/r/164/50/4700164/a4700164_146211347965594.jpg","is_recipe":1},{"id":"611546","title":"牛肉千层饼","titlepic":"http://site.meishij.net/r/13/237/2059263/a2059263_27565.jpg","is_recipe":1},{"id":"1657935","title":"清汤牛肉面","titlepic":"http://site.meishij.net/r/115/13/2253365/a2253365_145042012843007.jpg","is_recipe":1},{"id":"1615296","title":"蒜香烤肋排","titlepic":"http://site.meishij.net/r/41/203/113291/a113291_75761.jpg","is_recipe":1},{"id":"1642892","title":"天津蒸饼","titlepic":"http://site.meishij.net/r/225/38/3259725/a3259725_143875047081623.jpg","is_recipe":1},{"id":"1615501","title":"肉末雪里蕻","titlepic":"http://site.meishij.net/r/41/203/113291/a113291_50109.jpg","is_recipe":1},{"id":"1658228","title":"圣诞杯子蛋糕","titlepic":"http://site.meishij.net/r/23/28/69523/a69523_145068579184254.jpg","is_recipe":1},{"id":"1657951","title":"鸡汁百叶包肉","titlepic":"http://site.meishij.net/r/164/169/5042414/a5042414_145042176534685.jpg","is_recipe":1},{"id":"615177","title":"蜂蜜柠檬茶","titlepic":"http://site.meishij.net/r/202/30/2945202/a2945202_89195.jpg","is_recipe":1},{"id":"1642702","title":"天津麻酱面","titlepic":"http://site.meishij.net/r/225/38/3259725/a3259725_143865458726022.jpg","is_recipe":1},{"id":"611731","title":"奶香紫薯吐司","titlepic":"http://site.meishij.net/r/23/237/621773/a621773_98743.jpg","is_recipe":1},{"id":"1676003","title":"蒜蓉蒸丝瓜","titlepic":"http://site.meishij.net/r/245/13/2378495/a2378495_146227768104225.jpg","is_recipe":1},{"id":"1676148","title":"桂花红薯香芋百合","titlepic":"http://site.meishij.net/r/155/28/5882155/a5882155_146235415199347.jpg","is_recipe":1},{"id":"1643567","title":"油泼辣子羊肉云吞","titlepic":"http://site.meishij.net/r/15/201/3050265/a3050265_143912250846972.jpg","is_recipe":1},{"id":"1665425","title":"土耳其沙玛威（烤","titlepic":"http://site.meishij.net/r/203/57/5639453/a5639453_145621600044829.jpg","is_recipe":1},{"id":"1658267","title":"红糖核桃枣香包","titlepic":"http://site.meishij.net/r/105/225/1306355/a1306355_145070126157552.jpg","is_recipe":1},{"id":"1632147","title":"爆炒螺蛳","titlepic":"http://site.meishij.net/r/246/109/4089996/a4089996_143178207466519.jpg","is_recipe":1},{"id":"1615173","title":"双夹超级热狗","titlepic":"http://site.meishij.net/r/40/99/2087290/a2087290_81524.jpg","is_recipe":1},{"id":"1678725","title":"香蕉戚风蛋糕","titlepic":"http://site.meishij.net/r/232/49/6199982/a6199982_146337649296090.jpg","is_recipe":1},{"id":"611793","title":"广式香肠炒饭便当","titlepic":"http://site.meishij.net/r/191/59/2702441/a2702441_16408.jpg","is_recipe":1},{"id":"1675739","title":"黄瓜树","titlepic":"http://site.meishij.net/r/228/33/5570978/a5570978_146216219868619.jpg","is_recipe":1},{"id":"1642185","title":"青柠罂粟籽马芬","titlepic":"http://site.meishij.net/r/66/59/2764816/a2764816_143660371455955.jpg","is_recipe":1},{"id":"1675702","title":"外脆里嫩的炸牛奶","titlepic":"http://site.meishij.net/r/35/150/5537535/a5537535_146211847124279.jpg","is_recipe":1},{"id":"1675993","title":"不爱吃菠菜的宝宝","titlepic":"http://site.meishij.net/r/178/85/5833928/a5833928_146227454240628.jpg","is_recipe":1},{"id":"1682900","title":"梅豆炖土豆辣椒","titlepic":"http://site.meishij.net/r/137/154/2413637/a2413637_146460863281009.jpg","is_recipe":1},{"id":"1643556","title":"小炒腊猪耳","titlepic":"http://site.meishij.net/r/180/228/494680/a494680_143917779826950.jpg","is_recipe":1},{"id":"1637817","title":"炼乳鸡蛋吐司","titlepic":"http://site.meishij.net/r/85/125/4406335/a4406335_143521252919768.jpg","is_recipe":1},{"id":"1678793","title":"韩式辣酱鸡爪","titlepic":"http://site.meishij.net/r/174/213/2303424/a2303424_146338834565693.jpg","is_recipe":1},{"id":"1678251","title":"糍粑","titlepic":"http://site.meishij.net/r/184/229/5557434/a5557434_146314998309461.jpg","is_recipe":1}],"time_app":"1469861887"}
     * like_mem_key : 88a43e68a29d5283fd4ee39fad2704eb
     */

    private ObjBean obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * title : 猜你喜欢
         * time : 14:58为您更新
         * total : 2
         * data : [{"id":"1629872","title":"春意盎然蛋糕卷","titlepic":"http://site.meishij.net/r/37/91/3960287/a3960287_143014614814846.jpg","is_recipe":1},{"id":"612274","title":"酸辣土豆丝","titlepic":"http://site.meishij.net/r/211/151/2850461/a2850461_97417.jpg","is_recipe":1},{"id":"1675721","title":"香草新奥尔良煎牛","titlepic":"http://site.meishij.net/r/37/123/4218287/a4218287_146212054510863.jpg","is_recipe":1},{"id":"1678726","title":"鲜虾蔬菜饼","titlepic":"http://site.meishij.net/r/241/90/6147741/a6147741_146337652793209.jpg","is_recipe":1},{"id":"1616102","title":"鱼香排骨蒸南瓜","titlepic":"http://site.meishij.net/r/28/38/3197028/a3197028_27061.jpg","is_recipe":1},{"id":"1675703","title":"五彩缤纷酸奶杯","titlepic":"http://site.meishij.net/r/95/144/5286095/a5286095_146211652762770.jpg","is_recipe":1},{"id":"615445","title":"红烧肉","titlepic":"http://site.meishij.net/r/153/33/3070903/a3070903_35379.jpg","is_recipe":1},{"id":"1676072","title":"日式茶碗蒸","titlepic":"http://site.meishij.net/r/161/96/5149161/a5149161_146233410054686.jpg","is_recipe":1},{"id":"1682487","title":"花开蒜泥白肉","titlepic":"http://site.meishij.net/r/06/129/5469756/a5469756_146442316924535.jpg","is_recipe":1},{"id":"1675647","title":"水果蛋糕","titlepic":"http://site.meishij.net/r/141/205/4176391/a4176391_146209428941191.jpg","is_recipe":1},{"id":"1676172","title":"香草烤羊腩肉串","titlepic":"http://site.meishij.net/r/114/34/1258614/a1258614_146236351955533.jpg","is_recipe":1},{"id":"1675674","title":"＃苏泊尔·真磨醇","titlepic":"http://site.meishij.net/r/164/50/4700164/a4700164_146211347965594.jpg","is_recipe":1},{"id":"611546","title":"牛肉千层饼","titlepic":"http://site.meishij.net/r/13/237/2059263/a2059263_27565.jpg","is_recipe":1},{"id":"1657935","title":"清汤牛肉面","titlepic":"http://site.meishij.net/r/115/13/2253365/a2253365_145042012843007.jpg","is_recipe":1},{"id":"1615296","title":"蒜香烤肋排","titlepic":"http://site.meishij.net/r/41/203/113291/a113291_75761.jpg","is_recipe":1},{"id":"1642892","title":"天津蒸饼","titlepic":"http://site.meishij.net/r/225/38/3259725/a3259725_143875047081623.jpg","is_recipe":1},{"id":"1615501","title":"肉末雪里蕻","titlepic":"http://site.meishij.net/r/41/203/113291/a113291_50109.jpg","is_recipe":1},{"id":"1658228","title":"圣诞杯子蛋糕","titlepic":"http://site.meishij.net/r/23/28/69523/a69523_145068579184254.jpg","is_recipe":1},{"id":"1657951","title":"鸡汁百叶包肉","titlepic":"http://site.meishij.net/r/164/169/5042414/a5042414_145042176534685.jpg","is_recipe":1},{"id":"615177","title":"蜂蜜柠檬茶","titlepic":"http://site.meishij.net/r/202/30/2945202/a2945202_89195.jpg","is_recipe":1},{"id":"1642702","title":"天津麻酱面","titlepic":"http://site.meishij.net/r/225/38/3259725/a3259725_143865458726022.jpg","is_recipe":1},{"id":"611731","title":"奶香紫薯吐司","titlepic":"http://site.meishij.net/r/23/237/621773/a621773_98743.jpg","is_recipe":1},{"id":"1676003","title":"蒜蓉蒸丝瓜","titlepic":"http://site.meishij.net/r/245/13/2378495/a2378495_146227768104225.jpg","is_recipe":1},{"id":"1676148","title":"桂花红薯香芋百合","titlepic":"http://site.meishij.net/r/155/28/5882155/a5882155_146235415199347.jpg","is_recipe":1},{"id":"1643567","title":"油泼辣子羊肉云吞","titlepic":"http://site.meishij.net/r/15/201/3050265/a3050265_143912250846972.jpg","is_recipe":1},{"id":"1665425","title":"土耳其沙玛威（烤","titlepic":"http://site.meishij.net/r/203/57/5639453/a5639453_145621600044829.jpg","is_recipe":1},{"id":"1658267","title":"红糖核桃枣香包","titlepic":"http://site.meishij.net/r/105/225/1306355/a1306355_145070126157552.jpg","is_recipe":1},{"id":"1632147","title":"爆炒螺蛳","titlepic":"http://site.meishij.net/r/246/109/4089996/a4089996_143178207466519.jpg","is_recipe":1},{"id":"1615173","title":"双夹超级热狗","titlepic":"http://site.meishij.net/r/40/99/2087290/a2087290_81524.jpg","is_recipe":1},{"id":"1678725","title":"香蕉戚风蛋糕","titlepic":"http://site.meishij.net/r/232/49/6199982/a6199982_146337649296090.jpg","is_recipe":1},{"id":"611793","title":"广式香肠炒饭便当","titlepic":"http://site.meishij.net/r/191/59/2702441/a2702441_16408.jpg","is_recipe":1},{"id":"1675739","title":"黄瓜树","titlepic":"http://site.meishij.net/r/228/33/5570978/a5570978_146216219868619.jpg","is_recipe":1},{"id":"1642185","title":"青柠罂粟籽马芬","titlepic":"http://site.meishij.net/r/66/59/2764816/a2764816_143660371455955.jpg","is_recipe":1},{"id":"1675702","title":"外脆里嫩的炸牛奶","titlepic":"http://site.meishij.net/r/35/150/5537535/a5537535_146211847124279.jpg","is_recipe":1},{"id":"1675993","title":"不爱吃菠菜的宝宝","titlepic":"http://site.meishij.net/r/178/85/5833928/a5833928_146227454240628.jpg","is_recipe":1},{"id":"1682900","title":"梅豆炖土豆辣椒","titlepic":"http://site.meishij.net/r/137/154/2413637/a2413637_146460863281009.jpg","is_recipe":1},{"id":"1643556","title":"小炒腊猪耳","titlepic":"http://site.meishij.net/r/180/228/494680/a494680_143917779826950.jpg","is_recipe":1},{"id":"1637817","title":"炼乳鸡蛋吐司","titlepic":"http://site.meishij.net/r/85/125/4406335/a4406335_143521252919768.jpg","is_recipe":1},{"id":"1678793","title":"韩式辣酱鸡爪","titlepic":"http://site.meishij.net/r/174/213/2303424/a2303424_146338834565693.jpg","is_recipe":1},{"id":"1678251","title":"糍粑","titlepic":"http://site.meishij.net/r/184/229/5557434/a5557434_146314998309461.jpg","is_recipe":1}]
         * time_app : 1469861887
         */

        private CustomizedBean customized;
        private String like_mem_key;

        public CustomizedBean getCustomized() {
            return customized;
        }

        public void setCustomized(CustomizedBean customized) {
            this.customized = customized;
        }

        public String getLike_mem_key() {
            return like_mem_key;
        }

        public void setLike_mem_key(String like_mem_key) {
            this.like_mem_key = like_mem_key;
        }

        public static class CustomizedBean {
            private String title;
            private String time;
            private int total;
            private String time_app;
            /**
             * id : 1629872
             * title : 春意盎然蛋糕卷
             * titlepic : http://site.meishij.net/r/37/91/3960287/a3960287_143014614814846.jpg
             * is_recipe : 1
             */

            private List<DataBean> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public String getTime_app() {
                return time_app;
            }

            public void setTime_app(String time_app) {
                this.time_app = time_app;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                private String id;
                private String title;
                private String titlepic;
                private int is_recipe;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTitlepic() {
                    return titlepic;
                }

                public void setTitlepic(String titlepic) {
                    this.titlepic = titlepic;
                }

                public int getIs_recipe() {
                    return is_recipe;
                }

                public void setIs_recipe(int is_recipe) {
                    this.is_recipe = is_recipe;
                }
            }
        }
    }
}
