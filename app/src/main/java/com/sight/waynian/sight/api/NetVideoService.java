package com.sight.waynian.sight.api;

import com.sight.waynian.sight.bean.video.NetVideoBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by waynian on 2017/4/16.
 */

public interface NetVideoService {

//    @GET("nc/video/list/V9LG4B3A0/n/{pageIndex}-10.html")
//    Observable<NetVideoBean> getVideoList(@Path("pageIndex") int pageIndex);

    @GET("TrailerList.api")
    Observable<NetVideoBean> getVideoList();
}
