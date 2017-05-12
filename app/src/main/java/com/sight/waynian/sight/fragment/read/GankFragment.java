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
import com.sight.waynian.sight.adapter.GankAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.gank.Data;
import com.sight.waynian.sight.http.HttpMethods;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by waynian on 2017/4/4.
 */

public class GankFragment extends BaseFragment {
    private static final String TAG = GankFragment.class.getCanonicalName();

    private XRecyclerView mRecyclerView;
    private List<Data.ResultsBean> listData;

    private GankAdapter gankDetialAdapter;

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_gank, null);
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
                        page = 1;
                        getGankData(page);
                    }
                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                page = page + 1;
                                getGankData(page);
                                gankDetialAdapter.notifyDataSetChanged();
                            }
                        }, 1200);
                    }
                }, 1000);
            }
        });

        listData = new ArrayList<>();
        gankDetialAdapter = new GankAdapter(mContext, listData);
        mRecyclerView.setAdapter(gankDetialAdapter);
        mRecyclerView.refresh();
    }

    private void getGankData(int page) {
        HttpMethods.getInstance().getGankContent(new Subscriber<Data>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Data data) {
                for (Data.ResultsBean item : data.getResults()) {
                    listData.add(item);
                }
//                XLog.d(data.getResults().toString());
                gankDetialAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        }, page);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
        } else {
        }
    }
}
