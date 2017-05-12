package com.sight.waynian.sight.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.douban.DoubanDetialBean;
import com.sight.waynian.sight.bean.zhihu.News;
import com.sight.waynian.sight.http.HttpMethods;

import java.util.List;

import rx.Subscriber;

public class WebActivity extends AppCompatActivity {

    ImageView imageView;
    WebView webView;
    SwipeRefreshLayout refreshLayout;
    NestedScrollView scrollView;
    Toolbar toolbar;
    CollapsingToolbarLayout toolbarLayout;


    private DoubanDetialBean doubanDetialBean;

    private String type;
    private String id;
    private String title;
    private String coverUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        type = getIntent().getStringExtra("type");
        if ("知乎".equals(type)) {
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
        } else if ("豆瓣".equals(type)) {
            doubanDetialBean = new DoubanDetialBean();
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            coverUrl = getIntent().getStringExtra("coverUrl");
        }
        initView();
        getDetailNews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void getDetailNews() {
        if ("知乎".equals(type)) {
            HttpMethods.getInstance().getDetailNews(new Subscriber<News>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    refreshLayout.setRefreshing(false);
                }

                @Override
                public void onNext(News news) {
                    refreshLayout.setRefreshing(false);
                    setWebView(news);
                }
            }, id);
        } else if ("豆瓣".equals(type)) {
            HttpMethods.getInstance().getDoubanDetial(new Subscriber<DoubanDetialBean>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    refreshLayout.setRefreshing(false);
                }

                @Override
                public void onNext(DoubanDetialBean doubanDetialBean) {
                    refreshLayout.setRefreshing(false);
//                    XLog.d(doubanDetialBean.toString());
                    List<DoubanDetialBean.PhotosBean> imageList = doubanDetialBean.getPhotos();
                    setDoubanWebView(doubanDetialBean.getContent(), imageList);
                    Glide.with(WebActivity.this).load(coverUrl).centerCrop().into(imageView);
                }
            }, id);
        }

    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        imageView = (ImageView) findViewById(R.id.image_view);
        webView = (WebView) findViewById(R.id.web_view);
        scrollView = (NestedScrollView) findViewById(R.id.scrollView);
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.smoothScrollTo(0, 0);
            }
        });
        //设置下拉刷新的按钮的颜色
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDetailNews();
            }
        });
        toolbarLayout.setTitle(title);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    private void setWebView(News news) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        String head = "<head>\n" +
                "\t<link rel=\"stylesheet\" href=\"" + news.getCss()[0] + "\"/>\n" +
                "</head>";
        String img = "<div class=\"headline\">";
        String html = head + news.getBody().replace(img, " ");
        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        webView.setScrollbarFadingEnabled(true);
        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
        Glide.with(this).load(news.getImage()).centerCrop().into(imageView);
    }

    private void setDoubanWebView(String content, List<DoubanDetialBean.PhotosBean> imageList) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

//        if (doubanDetialBean.getContent() == null) {
//            return;
//        }
        String css;
        if ((this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES) {
            css = "<link rel=\"stylesheet\" href=\"file:///android_asset/douban_dark.css\" type=\"text/css\">";
        } else {
            css = "<link rel=\"stylesheet\" href=\"file:///android_asset/douban_light.css\" type=\"text/css\">";
        }

        for (int i = 0; i < imageList.size(); i++) {
            String old = "<img id=\"" + imageList.get(i).getTag_name() + "\" />";
            String newStr = "<img id=\"" + imageList.get(i).getTag_name() + "\" "
                    + "src=\"" + imageList.get(i).getSmall().getUrl() + "\"/>";
            content = content.replace(old, newStr);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n");
        builder.append("<html lang=\"ZH-CN\" xmlns=\"http://www.w3.org/1999/xhtml\">\n");
        builder.append("<head>\n<meta charset=\"utf-8\" />\n");
        builder.append(css);
        builder.append("\n</head>\n<body>\n");
        builder.append("<div class=\"container bs-docs-container\">\n");
        builder.append("<div class=\"post-container\">\n");
        builder.append(content);
        builder.append("</div>\n</div>\n</body>\n</html>");
        XLog.d("builder" + builder.toString());
        webView.loadDataWithBaseURL("x-data://base", builder.toString(), "text/html", "utf-8", null);
        webView.setScrollbarFadingEnabled(true);
        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
        Glide.with(this).load(coverUrl).centerCrop().into(imageView);
    }

//    private String convertDoubanContent(String content) {
//
//        XLog.d("内容" + builder.toString());
//
//        return builder.toString();
//    }
}
