package com.sight.waynian.sight.api;

import com.sight.waynian.sight.bean.gank.GankData;
import com.sight.waynian.sight.bean.gank.Meizhi;
import com.sight.waynian.sight.bean.gank.Video;
import com.sight.waynian.sight.bean.gank.Data;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by waynian on 2017/4/16.
 */

public interface GankApiService {

    @GET("data/福利/10/{page}")
    Observable<Meizhi> getMeizhiData(@Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    @GET("data/休息视频/10/{page}")
    Observable<Video> getVideoData(@Path("page") int page);

    @GET("history/content/15/{page}")
    Observable<Data> getContentData(@Path("page") int page);
}
