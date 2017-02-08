package com.study.dh.keeplearn.zhihuDaily.adapter;

import java.util.List;

/**
 * Created by dh on 2017/2/8.
 */

public class TitleInfoGson  {


    /**
     * date : 20170207
     * stories : [{"images":["http://pic3.zhimg.com/72975109d1c390eb98ab27a4e192c826.jpg"],"type":0,"id":9199932,"ga_prefix":"020713","title":"苹果带着纬创在印度开厂，富士康和国产手机们要小心了"},{"images":["http://pic3.zhimg.com/e4d6566bf56d4cabfb1818d4555a4cc2.jpg"],"type":0,"id":9201919,"ga_prefix":"020712","title":"大误 · 新年就靠这个兼职赚钱！"},{"title":"十分钟煲出广式靓粥的技能，适合节后厌倦大鱼大肉的你","ga_prefix":"020711","images":["http://pic4.zhimg.com/6c484e19550c933ad59a4135a1b7de97.jpg"],"multipic":true,"type":0,"id":9201958},{"images":["http://pic2.zhimg.com/1498abb541ba0ff04411c05b78068415.jpg"],"type":0,"id":9201288,"ga_prefix":"020710","title":"动物界有谁是在修炼《葵花宝典》的？"},{"images":["http://pic1.zhimg.com/87a6e4b179e9cc1a38ae96b69fc01e94.jpg"],"type":0,"id":9192663,"ga_prefix":"020709","title":"吵架的时候请认真一点，这样大家都省时间"},{"images":["http://pic4.zhimg.com/22809a0d821c2b790a51b5009445a097.jpg"],"type":0,"id":9201057,"ga_prefix":"020708","title":"这是一种可以造成癌症的病毒，但并不需要做任何治疗"},{"images":["http://pic1.zhimg.com/de4d97d56498915acb69b40f5ebeca68.jpg"],"type":0,"id":9201253,"ga_prefix":"020707","title":"单词我都认识，可整个句子为什么就是看不懂啊"},{"title":"开春了，教你用基本款的卫衣穿出无数种变美的可能性","ga_prefix":"020707","images":["http://pic4.zhimg.com/355e0099dfc2c9ce4936e15e5d19b853.jpg"],"multipic":true,"type":0,"id":9201112},{"images":["http://pic1.zhimg.com/3d8b33c74302870e98d31e19f6e78884.jpg"],"type":0,"id":9200071,"ga_prefix":"020707","title":"上门美甲保洁做饭的 O2O 服务，去年差不多都死了"},{"images":["http://pic2.zhimg.com/1dc9cf1556c7b0b1527c18476698c5cd.jpg"],"type":0,"id":9195072,"ga_prefix":"020706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/58ab5fceb14d9448b812e78350cb6b76.jpg","type":0,"id":9199932,"ga_prefix":"020713","title":"苹果带着纬创在印度开厂，富士康和国产手机们要小心了"},{"image":"http://pic4.zhimg.com/17089f8120a602040333ecb07a72444b.jpg","type":0,"id":9201958,"ga_prefix":"020711","title":"十分钟煲出广式靓粥的技能，适合节后厌倦大鱼大肉的你"},{"image":"http://pic2.zhimg.com/552373ccd73d9d61a87c1917194bcf55.jpg","type":0,"id":9200071,"ga_prefix":"020707","title":"上门美甲保洁做饭的 O2O 服务，去年差不多都死了"},{"image":"http://pic4.zhimg.com/c4a2e9b56dd8faf3771df05c3878d9ef.jpg","type":0,"id":9201112,"ga_prefix":"020707","title":"开春了，教你用基本款的卫衣穿出无数种变美的可能性"},{"image":"http://pic3.zhimg.com/8b0070c99a0663d5d3ab7291aabe501e.jpg","type":0,"id":9200385,"ga_prefix":"020619","title":"今天起，体育史上的最强逆转属于这场比赛"}]
     */

    private String date;
    /**
     * images : ["http://pic3.zhimg.com/72975109d1c390eb98ab27a4e192c826.jpg"]
     * type : 0
     * id : 9199932
     * ga_prefix : 020713
     * title : 苹果带着纬创在印度开厂，富士康和国产手机们要小心了
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic3.zhimg.com/58ab5fceb14d9448b812e78350cb6b76.jpg
     * type : 0
     * id : 9199932
     * ga_prefix : 020713
     * title : 苹果带着纬创在印度开厂，富士康和国产手机们要小心了
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
