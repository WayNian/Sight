package com.sight.waynian.sight.bean.douban;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by waynian on 2017/5/12.
 */

public class DoubanDetialBean {

    /**
     * display_style : 10002
     * short_url : https://dou.bz/1By7xD
     * abstract : 为了帮我做男同性恋调查，小波由“线人”带着去男厕所，结果经历了一个令他很失落的情形。他刚一进去，每个隔间都探出一个头来。
     * app_css : 7
     * like_count : 671
     * thumbs : [{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t110043.jpg","width":460,"height":684},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t110043.jpg","width":460,"height":684},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t110043.jpg","width":320,"height":475},"id":110043}]
     * created_time : 2015-09-05 21:41:16
     * id : 124434
     * is_editor_choice : false
     * original_url :
     * content :
     * share_pic_url : https://moment.douban.com/share_pic/post/124434.jpg
     * type : 1001
     * is_liked : false
     * photos : [{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/227836.jpg","width":440,"height":383},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/227836.jpg","width":440,"height":383},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/227836.jpg","width":320,"height":278},"id":227836},{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/227837.jpg","width":550,"height":533},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/raw/public/227837.jpg","width":550,"height":533},"tag_name":"img_2","small":{"url":"https://img1.doubanio.com/view/presto/small/public/227837.jpg","width":320,"height":310},"id":227837},{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/227838.jpg","width":400,"height":315},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/227838.jpg","width":400,"height":315},"tag_name":"img_3","small":{"url":"https://img1.doubanio.com/view/presto/small/public/227838.jpg","width":320,"height":252},"id":227838},{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/227839.jpg","width":460,"height":258},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/227839.jpg","width":460,"height":258},"tag_name":"img_4","small":{"url":"https://img1.doubanio.com/view/presto/small/public/227839.jpg","width":320,"height":179},"id":227839},{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/227840.jpg","width":460,"height":817},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/227840.jpg","width":460,"height":817},"tag_name":"img_5","small":{"url":"https://img3.doubanio.com/view/presto/small/public/227840.jpg","width":320,"height":568},"id":227840},{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/227842.jpg","width":460,"height":684},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/227842.jpg","width":460,"height":684},"tag_name":"img_6","small":{"url":"https://img3.doubanio.com/view/presto/small/public/227842.jpg","width":320,"height":475},"id":227842}]
     * published_time : 2015-09-06 22:00:00
     * url : https://moment.douban.com/post/124434/?douban_rec=1
     * column : 洗洗睡
     * comments_count : 64
     * title : 洗洗睡｜青山本不老，为雪到白头
     */

    private int display_style;
    private String short_url;
    @SerializedName("abstract")
    private String abstractX;
    private int app_css;
    private int like_count;
    private String created_time;
    private int id;
    private boolean is_editor_choice;
    private String original_url;
    private String content;
    private String share_pic_url;
    private String type;
    private boolean is_liked;
    private String published_time;
    private String url;
    private String column;
    private int comments_count;
    private String title;
    private List<ThumbsBean> thumbs;
    private List<PhotosBean> photos;

    public int getDisplay_style() {
        return display_style;
    }

    public void setDisplay_style(int display_style) {
        this.display_style = display_style;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public int getApp_css() {
        return app_css;
    }

    public void setApp_css(int app_css) {
        this.app_css = app_css;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_editor_choice() {
        return is_editor_choice;
    }

    public void setIs_editor_choice(boolean is_editor_choice) {
        this.is_editor_choice = is_editor_choice;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShare_pic_url() {
        return share_pic_url;
    }

    public void setShare_pic_url(String share_pic_url) {
        this.share_pic_url = share_pic_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIs_liked() {
        return is_liked;
    }

    public void setIs_liked(boolean is_liked) {
        this.is_liked = is_liked;
    }

    public String getPublished_time() {
        return published_time;
    }

    public void setPublished_time(String published_time) {
        this.published_time = published_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ThumbsBean> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<ThumbsBean> thumbs) {
        this.thumbs = thumbs;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public static class ThumbsBean {
        /**
         * medium : {"url":"https://img3.doubanio.com/view/presto/medium/public/t110043.jpg","width":460,"height":684}
         * description :
         * large : {"url":"https://img3.doubanio.com/view/presto/large/public/t110043.jpg","width":460,"height":684}
         * tag_name : img_1
         * small : {"url":"https://img3.doubanio.com/view/presto/small/public/t110043.jpg","width":320,"height":475}
         * id : 110043
         */

        private MediumBean medium;
        private String description;
        private LargeBean large;
        private String tag_name;
        private SmallBean small;
        private int id;

        public MediumBean getMedium() {
            return medium;
        }

        public void setMedium(MediumBean medium) {
            this.medium = medium;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LargeBean getLarge() {
            return large;
        }

        public void setLarge(LargeBean large) {
            this.large = large;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        public SmallBean getSmall() {
            return small;
        }

        public void setSmall(SmallBean small) {
            this.small = small;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static class MediumBean {
            /**
             * url : https://img3.doubanio.com/view/presto/medium/public/t110043.jpg
             * width : 460
             * height : 684
             */

            private String url;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public static class LargeBean {
            /**
             * url : https://img3.doubanio.com/view/presto/large/public/t110043.jpg
             * width : 460
             * height : 684
             */

            private String url;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public static class SmallBean {
            /**
             * url : https://img3.doubanio.com/view/presto/small/public/t110043.jpg
             * width : 320
             * height : 475
             */

            private String url;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }

    public static class PhotosBean {
        /**
         * medium : {"url":"https://img3.doubanio.com/view/presto/medium/public/227836.jpg","width":440,"height":383}
         * description :
         * large : {"url":"https://img3.doubanio.com/view/presto/large/public/227836.jpg","width":440,"height":383}
         * tag_name : img_1
         * small : {"url":"https://img3.doubanio.com/view/presto/small/public/227836.jpg","width":320,"height":278}
         * id : 227836
         */

        private MediumBeanX medium;
        private String description;
        private LargeBeanX large;
        private String tag_name;
        private SmallBeanX small;
        private int id;

        public MediumBeanX getMedium() {
            return medium;
        }

        public void setMedium(MediumBeanX medium) {
            this.medium = medium;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LargeBeanX getLarge() {
            return large;
        }

        public void setLarge(LargeBeanX large) {
            this.large = large;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        public SmallBeanX getSmall() {
            return small;
        }

        public void setSmall(SmallBeanX small) {
            this.small = small;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static class MediumBeanX {
            /**
             * url : https://img3.doubanio.com/view/presto/medium/public/227836.jpg
             * width : 440
             * height : 383
             */

            private String url;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public static class LargeBeanX {
            /**
             * url : https://img3.doubanio.com/view/presto/large/public/227836.jpg
             * width : 440
             * height : 383
             */

            private String url;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public static class SmallBeanX {
            /**
             * url : https://img3.doubanio.com/view/presto/small/public/227836.jpg
             * width : 320
             * height : 278
             */

            private String url;
            private int width;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }

    @Override
    public String toString() {
        return "DoubanDetialBean{" +
                "display_style=" + display_style +
                ", short_url='" + short_url + '\'' +
                ", abstractX='" + abstractX + '\'' +
                ", app_css=" + app_css +
                ", like_count=" + like_count +
                ", created_time='" + created_time + '\'' +
                ", id=" + id +
                ", is_editor_choice=" + is_editor_choice +
                ", original_url='" + original_url + '\'' +
                ", content='" + content + '\'' +
                ", share_pic_url='" + share_pic_url + '\'' +
                ", type='" + type + '\'' +
                ", is_liked=" + is_liked +
                ", published_time='" + published_time + '\'' +
                ", url='" + url + '\'' +
                ", column='" + column + '\'' +
                ", comments_count=" + comments_count +
                ", title='" + title + '\'' +
                ", thumbs=" + thumbs +
                ", photos=" + photos +
                '}';
    }
}
