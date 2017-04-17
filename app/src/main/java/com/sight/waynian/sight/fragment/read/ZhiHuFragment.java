package com.sight.waynian.sight.fragment.read;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.QuickAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.zhihu.NewsTimeLine;
import com.sight.waynian.sight.http.HttpMethods;

import rx.Subscriber;

/**
 * Created by waynian on 2017/4/4.
 */

public class ZhiHuFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = ZhiHuFragment.class.getCanonicalName();

    private RecyclerView contentList;
    private SwipeRefreshLayout swipeRefresh;
    private QuickAdapter adapter;

    private boolean isLoaded = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_zhihu, null);
            initUI();
        }
        return rootView;
    }

    private void initUI() {
        contentList = (RecyclerView) rootView.findViewById(R.id.content_list);
        swipeRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(
                R.color.blue,
                R.color.green,
                R.color.red,
                R.color.yellow
        );
        swipeRefresh.setOnRefreshListener(this);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
//            XLog.d("知乎可见");
            if (isLoaded) {
                getLatestNews();
                isLoaded = false;
            }
        } else {
            isLoaded = false;
        }
    }

    private void getLatestNews() {
        HttpMethods.getInstance().getTopMovie(new Subscriber<NewsTimeLine>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                swipeRefresh.setRefreshing(false);
            }

            @Override
            public void onNext(NewsTimeLine newsTimeLine) {
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getLatestNews();
            }
        }, 1200);
    }
}
