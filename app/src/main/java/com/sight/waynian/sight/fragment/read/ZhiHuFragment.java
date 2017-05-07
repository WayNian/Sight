package com.sight.waynian.sight.fragment.read;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.ZhihuAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.http.HttpMethods;
import com.sight.waynian.sight.uitils.DateFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import rx.Subscriber;

/**
 * Created by waynian on 2017/4/4.
 */

public class ZhiHuFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = DoubanFragment.class.getCanonicalName();
    private XRecyclerView mRecyclerView;
    private List<ZhihuBean.StoriesBean> listData;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    private ZhihuAdapter zhihuAdapter;

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
        mRecyclerView = (XRecyclerView) rootView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.ic_battery_0);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        listData.clear();
                        getLatestNews();
                    }
                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        final Calendar c = Calendar.getInstance();
                        c.set(mYear, mMonth, --mDay);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getHistoryNews(DateFormatter.ZhihuDailyDateFormat(c.getTimeInMillis()));
                                zhihuAdapter.notifyDataSetChanged();
                            }
                        }, 1200);
                    }
                }, 1000);
            }
        });

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        listData = new ArrayList<>();
        zhihuAdapter = new ZhihuAdapter(mContext, listData);
        mRecyclerView.setAdapter(zhihuAdapter);
        mRecyclerView.refresh();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
        } else {
        }
    }

    private void getLatestNews() {
        HttpMethods.getInstance().getLatestNews(new Subscriber<ZhihuBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ZhihuBean zhihuBean) {
                for (ZhihuBean.StoriesBean item : zhihuBean.getStories()) {
                    listData.add(item);
                }
                zhihuAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        });
    }

    private void getHistoryNews(String time) {
        HttpMethods.getInstance().getHistoryNews(new Subscriber<ZhihuBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ZhihuBean zhihuBean) {
                for (ZhihuBean.StoriesBean item : zhihuBean.getStories()) {
                    listData.add(item);
                }
                zhihuAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        }, time);
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
