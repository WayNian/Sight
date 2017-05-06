package com.sight.waynian.sight.api;

import com.sight.waynian.sight.bean.guokr.GuokrItemBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by waynian on 2017/4/16.
 */

public interface GuokrApiService {

    //article.json?retrieve_type=by_since&category=all&limit=25&ad=1
    @GET("article.json")
    Observable<GuokrItemBean> getLatestNews();

    @GET("news/{id}")
    Observable<GuokrItemBean> getDetailNews(@Path("id") String id);
}
