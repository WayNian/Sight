package com.sight.waynian.sight;

import android.app.Application;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

/**
 * Created by waynian on 2017/4/16.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        intLog();
    }

    private void intLog() {
//        XLog.init(BuildConfig.DEBUG ? LogLevel.ALL : LogLevel.NONE);
        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(BuildConfig.DEBUG ? LogLevel.ALL             // 指定日志级别，低于该级别的日志将不会被打印，默认为 LogLevel.ALL
                        : LogLevel.NONE)
                .tag("Sight")                                         // 指定 TAG，默认为 "X-LOG"
//                .t()                                                   // 允许打印线程信息，默认禁止
//                .st(2)                                                 // 允许打印深度为2的调用栈信息，默认禁止
                .b()                                                   // 允许打印日志边框，默认禁止
                .build();

        XLog.init(                                                 // 初始化 XLog
                config                                              // 指定日志配置，如果不指定，会默认使用 new LogConfiguration.Builder().build()
                // 添加任意多的打印器。如果没有添加任何打印器，会默认使用 AndroidPrinter(Android)/ConsolePrinter(java)
        );
    }

}
