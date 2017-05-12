package com.sight.waynian.sight.http;

import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.api.DoubanApiService;
import com.sight.waynian.sight.api.GankApiService;
import com.sight.waynian.sight.api.NetVideoService;
import com.sight.waynian.sight.api.ZhihuApiService;
import com.sight.waynian.sight.bean.douban.DoubanDetialBean;
import com.sight.waynian.sight.bean.douban.DoubanListBean;
import com.sight.waynian.sight.bean.gank.Data;
import com.sight.waynian.sight.bean.gank.GankData;
import com.sight.waynian.sight.bean.gank.Meizhi;
import com.sight.waynian.sight.bean.gank.Video;
import com.sight.waynian.sight.bean.video.NetVideoBean;
import com.sight.waynian.sight.bean.zhihu.News;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.constants.UrlAddress;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by waynian on 2017/4/13.
 */

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 5;

    private ZhihuApiService zhihuApiService;

    private GankApiService gankApiService;

    private DoubanApiService doubanApiService;

    private NetVideoService netVideoService;

    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                XLog.d("OkHttp====Message:" + message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }

    //构造方法
    public HttpMethods() {
        //手动创建一盒盒OKHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        Retrofit zhihuRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(UrlAddress.ZHIHU_BASE_URL)
                .build();

        zhihuApiService = zhihuRetrofit.create(ZhihuApiService.class);

        //干货集中营
        Retrofit gankRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(UrlAddress.GANK_BASE_URL)
                .build();

        gankApiService = gankRetrofit.create(GankApiService.class);

        //豆瓣一刻
        Retrofit doubanRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(UrlAddress.DOUBAN_MOMENT)
                .build();

        doubanApiService = doubanRetrofit.create(DoubanApiService.class);

        //视频
        Retrofit netVideoRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(UrlAddress.VIDEO_URL)
                .build();

        netVideoService = netVideoRetrofit.create(NetVideoService.class);
    }

    //再访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //*******************************************知乎***********************************************

    /**
     * 获取知乎最新的信息
     *
     * @param subscriber 由调用者传过来的观察者对象
     */
    public void getLatestNews(Subscriber<ZhihuBean> subscriber) {
        zhihuApiService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取知乎详情
     *
     * @param subscriber
     * @param id
     */
    public void getDetailNews(Subscriber<News> subscriber, String id) {
        zhihuApiService.getDetailNews(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取知乎历史信息
     *
     * @param subscriber
     * @param time
     */
    public void getHistoryNews(Subscriber<ZhihuBean> subscriber, String time) {
        zhihuApiService.getBeforetNews(time)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //**************************************干货集中营**********************************************

    /**
     * 获取干货集中营最新的信息
     *
     * @param subscriber 由调用者传过来的观察者对象
     */
    public void getGankLatestNews(Subscriber<Meizhi> subscriber, int page) {
        gankApiService.getMeizhiData(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getGankContent(Subscriber<Data> subscriber, int page) {
        gankApiService.getContentData(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getGankLatestVideo(Subscriber<Video> subscriber, int page) {
        gankApiService.getVideoData(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public void getGankDetial(Subscriber<GankData> subscriber, int year, int month, int day) {
        gankApiService.getGankData(year, month, day)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //**************************************豆瓣一刻***********************************************

    /**
     * 列表
     * @param subscriber
     * @param date
     */
    public void getDoubanList(Subscriber<DoubanListBean> subscriber, String date) {
        doubanApiService.getDoubanList(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 详情
     * @param subscriber
     * @param id
     */
    public void getDoubanDetial(Subscriber<DoubanDetialBean> subscriber, String id) {
        doubanApiService.getDetailNews(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //*************************************视频*******************************************
    /**
     * 视频列表
     * @param subscriber
     * @param pageIndex
     */
    public void getVideoList(Subscriber<NetVideoBean> subscriber, int pageIndex) {
        netVideoService.getVideoList(pageIndex)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
