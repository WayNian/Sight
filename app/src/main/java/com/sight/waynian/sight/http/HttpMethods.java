package com.sight.waynian.sight.http;

import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.api.ZhihuApiService;
import com.sight.waynian.sight.bean.zhihuw.News;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;

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
    private static final String ZHIHU_BASE_URL = "http://news-at.zhihu.com/api/4/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private ZhihuApiService zhihuApiService;


    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                XLog.d("OkHttp====Message:"+message);
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

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ZHIHU_BASE_URL)
                .build();

        zhihuApiService = retrofit.create(ZhihuApiService.class);
    }

    //再访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取知乎最新的信息
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
     * 获取知乎详情
     * @param subscriber
     * @param id
     */
    public void getHistoryNews(Subscriber<ZhihuBean> subscriber, String time) {
        zhihuApiService.getBeforetNews(time)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
