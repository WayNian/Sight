package com.sight.waynian.sight.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import com.sight.waynian.sight.bean.douban.DoubanListBean;
import com.sight.waynian.sight.bean.douban.DoubanDetialBean;

import rx.Observable;

/**
 * Created by waynian on 2017/4/16.
 */

public interface DoubanApiService {

    //article.json?retrieve_type=by_since&category=all&limit=25&ad=1
    @GET("stream/date/{date}")
    Observable<DoubanListBean> getDoubanList(@Path("date") String date);

    @GET("post/{id}")
    Observable<DoubanDetialBean> getDetailNews(@Path("id") String id);
}
