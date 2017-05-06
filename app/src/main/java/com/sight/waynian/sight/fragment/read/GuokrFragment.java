package com.sight.waynian.sight.fragment.read;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.MyAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.http.HttpMethods;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by waynian on 2017/4/4.
 */

public class GuokrFragment extends BaseFragment {
    private static final String TAG = GuokrFragment.class.getCanonicalName();
    private XRecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<ZhihuBean.StoriesBean> listData;
    private int times = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_guokr, null);
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
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        listData.clear();
                        getLatestNews();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
//                            for (int i = 0; i < 15; i++) {
//                                listData.add("item" + (1 + listData.size()));
//                            }
//                            mRecyclerView.loadMoreComplete();
//                            mAdapter.notifyDataSetChanged();
                            getLatestNews();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
//                            for (int i = 0; i < 9; i++) {
//                                listData.add("item" + (1 + listData.size()));
//                            }
                            getLatestNews();
//                            mRecyclerView.setNoMore(true);
//                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times++;
            }
        });

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        listData = new ArrayList<>();
        mAdapter = new MyAdapter(mContext,listData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.refresh();
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
//                listData.add((ZhihuBean.StoriesBean) zhihuBean.getStories());
                for (ZhihuBean.StoriesBean item : zhihuBean.getStories()) {
                    listData.add(item);
                }
                mAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        });
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
            XLog.d("知乎可见");
        } else {
            XLog.d("知乎不可见");
        }
    }
}
