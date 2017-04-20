package com.sight.waynian.sight.ui;

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
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.zhihuw.News;
import com.sight.waynian.sight.http.HttpMethods;

import butterknife.ButterKnife;
import rx.Subscriber;

public class WebActivity extends AppCompatActivity {

    ImageView imageView;
    WebView webView;
    SwipeRefreshLayout refreshLayout;
    NestedScrollView scrollView;
    Toolbar toolbar;
    CollapsingToolbarLayout toolbarLayout;

    /**
     * 知乎传递的值
     */
    private String id;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        initView();
        getDetailNews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void getDetailNews() {
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
        if (item.getItemId() == android.R.id.home){
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
}
