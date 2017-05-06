package com.sight.waynian.sight.bean.gank;

import java.util.Date;
import java.util.List;

/**
 * Created by waynian on 2017/5/6.
 */

public class Data {


    /**
     * error : false
     * results : [{"_id":"590bf7ee421aa90c7a8b2ac1","content":" ","created_at":"2017-05-05T11:56:30.134Z","publishedAt":"2017-05-05T11:55:00.0Z","rand_id":"153c52a6-d6aa-43ff-8cde-c7f42fe06911","title":"今日力推：Android 室内场景构建 / Android自定义动画酷炫的提交按钮 / Fake Wifi 攻击","updated_at":"2017-05-05T11:56:30.134Z"},{"_id":"590aa356421aa90c7a8b2aba","content":" ","created_at":"2017-05-04T11:43:18.282Z","publishedAt":"2017-05-04T11:42:00.0Z","rand_id":"7a5ed10a-ab77-4224-b779-3ae496b88202","title":"今日力推：深入理解 MessageQueue / iOS 用某个库之前，快速的在 Playground 里测试一下吧","updated_at":"2017-05-04T11:43:18.282Z"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 590bf7ee421aa90c7a8b2ac1
         * content :
         * created_at : 2017-05-05T11:56:30.134Z
         * publishedAt : 2017-05-05T11:55:00.0Z
         * rand_id : 153c52a6-d6aa-43ff-8cde-c7f42fe06911
         * title : 今日力推：Android 室内场景构建 / Android自定义动画酷炫的提交按钮 / Fake Wifi 攻击
         * updated_at : 2017-05-05T11:56:30.134Z
         */

        private String _id;
        private String content;
        private String created_at;
        private Date publishedAt;
        private String rand_id;
        private String title;
        private String updated_at;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public Date getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(Date publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getRand_id() {
            return rand_id;
        }

        public void setRand_id(String rand_id) {
            this.rand_id = rand_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", content='" + content + '\'' +
                    ", created_at='" + created_at + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", rand_id='" + rand_id + '\'' +
                    ", title='" + title + '\'' +
                    ", updated_at='" + updated_at + '\'' +
                    '}';
        }
    }
}
