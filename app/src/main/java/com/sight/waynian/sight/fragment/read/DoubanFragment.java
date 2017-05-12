package com.sight.waynian.sight.fragment.read;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.DoubanAdapter;
import com.sight.waynian.sight.adapter.ZhihuAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.douban.DoubanListBean;
import com.sight.waynian.sight.bean.gank.Data;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.http.HttpMethods;
import com.sight.waynian.sight.uitils.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rx.Subscriber;

/**
 * Created by waynian on 2017/4/4.
 */

public class DoubanFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final long DEFAULT_TIMEOUT = 5;
    private XRecyclerView mRecyclerView;
    private List<DoubanListBean.PostsBean> listData;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    private DoubanAdapter doubanAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_douban, null);
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
                        getLatestNews(DoubanDateFormat(Calendar.getInstance().getTimeInMillis()));
                    }
                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Calendar c = Calendar.getInstance();
                        c.set(mYear, mMonth, --mDay);
                        getLatestNews(DoubanDateFormat(c.getTimeInMillis()));
//                        getLatestNews(DoubanDateFormat(Calendar.getInstance().getTimeInMillis()));
                        XLog.d(DoubanDateFormat(c.getTimeInMillis()));
                    }
                }, 1200);
            }
        });

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        listData = new ArrayList<>();
        doubanAdapter = new DoubanAdapter(mContext, listData);
        mRecyclerView.setAdapter(doubanAdapter);
        mRecyclerView.refresh();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
        } else {
        }
    }

    private void getLatestNews(String time) {
        HttpMethods.getInstance().getDoubanList(new Subscriber<DoubanListBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(DoubanListBean doubanListBean) {
                for (DoubanListBean.PostsBean item : doubanListBean.getPosts()) {
                    listData.add(item);
                }
                doubanAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        },time);
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
                getLatestNews(DoubanDateFormat(Calendar.getInstance().getTimeInMillis()));
            }
        }, 1200);
    }

    private String DoubanDateFormat(long date) {
        String sDate;
        Date d = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        sDate = format.format(d);

        return sDate;
    }
}
