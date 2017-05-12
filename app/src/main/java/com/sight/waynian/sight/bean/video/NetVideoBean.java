package com.sight.waynian.sight.bean.video;

import java.util.List;

/**
 * Created by llf on 2017/4/11.
 * 视频实体类
 */

public class NetVideoBean {
    private List<TrailersBean> trailers;

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public static class TrailersBean {
        /**
         * id : 65617
         * movieName : 《银翼杀手2049》新预告
         * coverImg : http://img5.mtime.cn/mg/2016/12/20/152243.84093718.jpg
         * movieId : 212468
         * url : http://vfx.mtime.cn/Video/2017/05/09/mp4/170509071709934167.mp4
         * hightUrl : http://vfx.mtime.cn/Video/2017/05/09/mp4/170509071709934167.mp4
         * videoTitle : 银翼杀手2049 剧场版预告片
         * videoLength : 141
         * rating : -1
         * type : ["科幻"]
         * summary : 瑞恩高斯林遇上哈里森福特
         */

        private int id;
        private String movieName;
        private String coverImg;
        private int movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private int videoLength;
        private float rating;
        private String summary;
        private List<String> type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(int videoLength) {
            this.videoLength = videoLength;
        }

        public float getRating() {
            return rating;
        }

        public void setRating(float rating) {
            this.rating = rating;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "TrailersBean{" +
                    "id=" + id +
                    ", movieName='" + movieName + '\'' +
                    ", coverImg='" + coverImg + '\'' +
                    ", movieId=" + movieId +
                    ", url='" + url + '\'' +
                    ", hightUrl='" + hightUrl + '\'' +
                    ", videoTitle='" + videoTitle + '\'' +
                    ", videoLength=" + videoLength +
                    ", rating=" + rating +
                    ", summary='" + summary + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NetVideoBean{" +
                "trailers=" + trailers +
                '}';
    }

    //    @SerializedName("V9LG4B3A0")
//    private List<V9LG4CHORBean> tag;
//
//    public List<V9LG4CHORBean> getTag() {
//        return tag;
//    }
//
//    public void setTag(List<V9LG4CHORBean> V9LG4B3A0) {
//        this.tag = V9LG4B3A0;
//    }
//
//    public static class V9LG4CHORBean {
//        /**
//         * topicImg : http://vimg1.ws.126.net/image/snapshot/2012/4/S/4/V7TFMDFS4.jpg
//         * videosource : 新媒体
//         * mp4Hd_url : http://flv2.bn.netease.com/videolib3/1504/18/NTZdt3793/HD/NTZdt3793-mobile.mp4
//         * topicDesc : 汇集最新的娱乐资讯，为您打造一个娱乐身心的平台。
//         * topicSid : V7TFMDFS0
//         * cover : http://vimg2.ws.126.net/image/snapshot/2015/4/6/J/VAMI2J76J.jpg
//         * title : 跑男2：范冰冰扑倒李晨猛撕名牌
//         * playCount : 442014
//         * replyBoard : variety_bbs
//         * sectiontitle :
//         * replyid : AMI2J76I008535RB
//         * description : 跑男2首播：范冰冰韩庚加盟，众星圣斗士星矢造型亮相，范冰冰扑倒李晨猛撕名牌。
//         * mp4_url : http://flv2.bn.netease.com/videolib3/1504/18/NTZdt3793/SD/NTZdt3793-mobile.mp4
//         * length : 115
//         * playersize : 0
//         * m3u8Hd_url : http://flv2.bn.netease.com/videolib3/1504/18/NTZdt3793/HD/movie_index.m3u8
//         * vid : VAMI2J76I
//         * m3u8_url : http://flv2.bn.netease.com/videolib3/1504/18/NTZdt3793/SD/movie_index.m3u8
//         * ptime : 2015-04-18 10:28:46
//         * topicName : 综艺最爆点
//         */
//
//        private String topicImg;
//        private String videosource;
//        private String mp4Hd_url;
//        private String topicDesc;
//        private String topicSid;
//        private String cover;
//        private String title;
//        private int playCount;
//        private String replyBoard;
//        private String sectiontitle;
//        private String replyid;
//        private String description;
//        private String mp4_url;
//        private int length;
//        private int playersize;
//        private String m3u8Hd_url;
//        private String vid;
//        private String m3u8_url;
//        private String ptime;
//        private String topicName;
//
//        public String getTopicImg() {
//            return topicImg;
//        }
//
//        public void setTopicImg(String topicImg) {
//            this.topicImg = topicImg;
//        }
//
//        public String getVideosource() {
//            return videosource;
//        }
//
//        public void setVideosource(String videosource) {
//            this.videosource = videosource;
//        }
//
//        public String getMp4Hd_url() {
//            return mp4Hd_url;
//        }
//
//        public void setMp4Hd_url(String mp4Hd_url) {
//            this.mp4Hd_url = mp4Hd_url;
//        }
//
//        public String getTopicDesc() {
//            return topicDesc;
//        }
//
//        public void setTopicDesc(String topicDesc) {
//            this.topicDesc = topicDesc;
//        }
//
//        public String getTopicSid() {
//            return topicSid;
//        }
//
//        public void setTopicSid(String topicSid) {
//            this.topicSid = topicSid;
//        }
//
//        public String getCover() {
//            return cover;
//        }
//
//        public void setCover(String cover) {
//            this.cover = cover;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public int getPlayCount() {
//            return playCount;
//        }
//
//        public void setPlayCount(int playCount) {
//            this.playCount = playCount;
//        }
//
//        public String getReplyBoard() {
//            return replyBoard;
//        }
//
//        public void setReplyBoard(String replyBoard) {
//            this.replyBoard = replyBoard;
//        }
//
//        public String getSectiontitle() {
//            return sectiontitle;
//        }
//
//        public void setSectiontitle(String sectiontitle) {
//            this.sectiontitle = sectiontitle;
//        }
//
//        public String getReplyid() {
//            return replyid;
//        }
//
//        public void setReplyid(String replyid) {
//            this.replyid = replyid;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public String getMp4_url() {
//            return mp4_url;
//        }
//
//        public void setMp4_url(String mp4_url) {
//            this.mp4_url = mp4_url;
//        }
//
//        public int getLength() {
//            return length;
//        }
//
//        public void setLength(int length) {
//            this.length = length;
//        }
//
//        public int getPlayersize() {
//            return playersize;
//        }
//
//        public void setPlayersize(int playersize) {
//            this.playersize = playersize;
//        }
//
//        public String getM3u8Hd_url() {
//            return m3u8Hd_url;
//        }
//
//        public void setM3u8Hd_url(String m3u8Hd_url) {
//            this.m3u8Hd_url = m3u8Hd_url;
//        }
//
//        public String getVid() {
//            return vid;
//        }
//
//        public void setVid(String vid) {
//            this.vid = vid;
//        }
//
//        public String getM3u8_url() {
//            return m3u8_url;
//        }
//
//        public void setM3u8_url(String m3u8_url) {
//            this.m3u8_url = m3u8_url;
//        }
//
//        public String getPtime() {
//            return ptime;
//        }
//
//        public void setPtime(String ptime) {
//            this.ptime = ptime;
//        }
//
//        public String getTopicName() {
//            return topicName;
//        }
//
//        public void setTopicName(String topicName) {
//            this.topicName = topicName;
//        }
//    }


}
