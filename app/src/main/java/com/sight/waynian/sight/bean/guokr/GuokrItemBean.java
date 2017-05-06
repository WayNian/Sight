package com.sight.waynian.sight.bean.guokr;

import java.util.List;

/**
 * Created by waynian on 2017/5/6.
 */

public class GuokrItemBean {

    private String now;
    private boolean ok;
    private List<ResultBean> result;

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * link_v2_sync_img : http://jingxuan.guokr.com/pick/v2/83114/sync/
         * source_name : 天了噜！
         * video_url :
         * current_user_has_collected : false
         * likings_count : 9
         * images : ["http://3.im.guokr.com/-qsREZBN8_A9a0iuxvadu7pf1UFF6kP4QB94rfaZtjurAAAAtwAAAFBO.png","http://2.im.guokr.com/Ne4kmjf--m5vmNVfzklR2hib_hjTG4T5Un3PuzDbKWSkAgAA0AEAAFBO.png?imageView2/1/w/480/h/329","http://1.im.guokr.com/aXR5hGt5UqrFfwKZ2ov4tZXrRDFeFHh9FCq8WAoU2g9XAgAAvAEAAFBO.png?imageView2/1/w/480/h/355","http://2.im.guokr.com/EeaPuoA2BWf8oWIDuunICwQnfHMk9uVox-Vipj6ZuLyUAAAArwAAAFBO.png","http://1.im.guokr.com/gM9bIXBkisJeC1KZhCvnoVB00HsWl176j1X9E4wP5xcgAwAA4AEAAEpQ.jpg?imageView2/1/w/480/h/288","http://3.im.guokr.com/SaRYPTBkDq1gU7vO3xz1CrQfewP61WFdxDDCUtIVN9VsAgAAXQEAAEpQ.jpg?imageView2/1/w/480/h/270","http://2.im.guokr.com/TwH_2Vs7xA4D7dbBAJmPGAEM1799EXJFfXKrnRGjoa8ABQAA0AIAAEpQ.jpg?imageView2/1/w/480/h/270","http://3.im.guokr.com/quei_9uG_6C0WafkDq5VjIPeXA6sv9ZxQL5KgHZL-pZYAgAASgEAAEpQ.jpg?imageView2/1/w/480/h/264","http://1.im.guokr.com/_iIRD_AFK543eWJPI9rlei0QA8O2dZ0IG5LHWxxwTg5pAQAA1AEAAFBO.png","http://3.im.guokr.com/OlzAzhSL0il9HNWDsQWwDFmSV5QOPtxZMpa3XjHVO_KyAgAAGwEAAEpQ.jpg?imageView2/1/w/480/h/196"]
         * video_duration : null
         * id : 83114
         * category : learning
         * style : article
         * title : 你数学是体育老师教的？更有可能是语文老师教的
         * source_data : {"image":"http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160","summary":"吸走你的无聊时间！","id":52,"key":"天了噜！","title":"天了噜！"}
         * headline_img_tb : http://2.im.guokr.com/TwH_2Vs7xA4D7dbBAJmPGAEM1799EXJFfXKrnRGjoa8ABQAA0AIAAEpQ.jpg?imageView2/1/w/288/h/162
         * link_v2 : http://jingxuan.guokr.com/pick/v2/83114/
         * date_picked : 1494043320
         * is_top : false
         * link : http://jingxuan.guokr.com/pick/83114/
         * headline_img : http://2.im.guokr.com/TwH_2Vs7xA4D7dbBAJmPGAEM1799EXJFfXKrnRGjoa8ABQAA0AIAAEpQ.jpg?imageView2/1/w/640/h/480
         * replies_count : 1
         * current_user_has_liked : false
         * page_source : http://jingxuan.guokr.com/pick/83114/?ad=1
         * author : jessiejessie
         * summary : 当你点开这篇文章的时候，你会有意无意地想到现在几点、你年纪多大、银行账户余额、体重多少这些（伤感的）话题。我们习以为常的生活是被数
         * source : group
         * reply_root_id : 786940
         * date_created : 1493894193
         */

        private String link_v2_sync_img;
        private String source_name;
        private String video_url;
        private boolean current_user_has_collected;
        private int likings_count;
        private Object video_duration;
        private int id;
        private String category;
        private String style;
        private String title;
        private SourceDataBean source_data;
        private String headline_img_tb;
        private String link_v2;
        private int date_picked;
        private boolean is_top;
        private String link;
        private String headline_img;
        private int replies_count;
        private boolean current_user_has_liked;
        private String page_source;
        private String author;
        private String summary;
        private String source;
        private int reply_root_id;
        private int date_created;
        private List<String> images;

        public String getLink_v2_sync_img() {
            return link_v2_sync_img;
        }

        public void setLink_v2_sync_img(String link_v2_sync_img) {
            this.link_v2_sync_img = link_v2_sync_img;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public boolean isCurrent_user_has_collected() {
            return current_user_has_collected;
        }

        public void setCurrent_user_has_collected(boolean current_user_has_collected) {
            this.current_user_has_collected = current_user_has_collected;
        }

        public int getLikings_count() {
            return likings_count;
        }

        public void setLikings_count(int likings_count) {
            this.likings_count = likings_count;
        }

        public Object getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(Object video_duration) {
            this.video_duration = video_duration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public SourceDataBean getSource_data() {
            return source_data;
        }

        public void setSource_data(SourceDataBean source_data) {
            this.source_data = source_data;
        }

        public String getHeadline_img_tb() {
            return headline_img_tb;
        }

        public void setHeadline_img_tb(String headline_img_tb) {
            this.headline_img_tb = headline_img_tb;
        }

        public String getLink_v2() {
            return link_v2;
        }

        public void setLink_v2(String link_v2) {
            this.link_v2 = link_v2;
        }

        public int getDate_picked() {
            return date_picked;
        }

        public void setDate_picked(int date_picked) {
            this.date_picked = date_picked;
        }

        public boolean isIs_top() {
            return is_top;
        }

        public void setIs_top(boolean is_top) {
            this.is_top = is_top;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getHeadline_img() {
            return headline_img;
        }

        public void setHeadline_img(String headline_img) {
            this.headline_img = headline_img;
        }

        public int getReplies_count() {
            return replies_count;
        }

        public void setReplies_count(int replies_count) {
            this.replies_count = replies_count;
        }

        public boolean isCurrent_user_has_liked() {
            return current_user_has_liked;
        }

        public void setCurrent_user_has_liked(boolean current_user_has_liked) {
            this.current_user_has_liked = current_user_has_liked;
        }

        public String getPage_source() {
            return page_source;
        }

        public void setPage_source(String page_source) {
            this.page_source = page_source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getReply_root_id() {
            return reply_root_id;
        }

        public void setReply_root_id(int reply_root_id) {
            this.reply_root_id = reply_root_id;
        }

        public int getDate_created() {
            return date_created;
        }

        public void setDate_created(int date_created) {
            this.date_created = date_created;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public static class SourceDataBean {
            /**
             * image : http://2.im.guokr.com/r8PINb_RG_niPP_rsxxvHLK7HmQE9i1NZD6pWV_0VDKgAAAAoAAAAFBO.png?imageView2/1/w/160/h/160
             * summary : 吸走你的无聊时间！
             * id : 52
             * key : 天了噜！
             * title : 天了噜！
             */

            private String image;
            private String summary;
            private int id;
            private String key;
            private String title;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
