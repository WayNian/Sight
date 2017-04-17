package com.sight.waynian.sight.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.sight.waynian.sight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends Activity {

    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        String ZHIHU_NEWS = "http://news-at.zhihu.com/api/4/news/";
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        //设置下拉刷新的按钮的颜色
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);

        webView = (WebView) findViewById(R.id.web_view);
        webView.setScrollbarFadingEnabled(true);

        imageView = (ImageView) findViewById(R.id.image_view);
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

//        webView.loadDataWithBaseURL("x-data://base",result,"text/html","utf-8",null);
        webView.loadUrl(ZHIHU_NEWS + id);
        //能够和js交互
        webView.getSettings().setJavaScriptEnabled(true);
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        webView.getSettings().setBuiltInZoomControls(false);
        //缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //开启DOM storage API功能
        webView.getSettings().setDomStorageEnabled(true);
        //开启application Cache功能
        webView.getSettings().setAppCacheEnabled(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
    }
}
