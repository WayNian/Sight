package com.sight.waynian.sight.api;

import com.sight.waynian.sight.bean.zhihu.News;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.bean.zhihu.SplashImage;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by waynian on 2017/4/16.
 */

public interface ZhihuApiService {

    @GET("start-image/1080*1920")
    Observable<SplashImage> getSplashImage();

    @GET("news/latest")
    Observable<ZhihuBean> getLatestNews();

    @GET("news/before/{time}")
    Observable<ZhihuBean> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<News> getDetailNews(@Path("id") String id);
}
