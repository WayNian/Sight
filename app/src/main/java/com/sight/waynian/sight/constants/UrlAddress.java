package com.sight.waynian.sight.constants;

/**
 * Created by waynian on 2017/5/6.
 */

public class UrlAddress {
    public static final String ZHIHU_BASE_URL = "http://news-at.zhihu.com/api/4/";

    // 获取果壳精选的文章列表,通过组合相应的参数成为完整的url
    // Guokr handpick articles. make complete url by combining params
    public static final String GUOKR_ARTICLES = "http://apis.guokr.com/handpick/";

    //干货集中营
    public static final String GANK_BASE_URL = "http://gank.io/api/";

    // 豆瓣一刻
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    public static final String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";


}
