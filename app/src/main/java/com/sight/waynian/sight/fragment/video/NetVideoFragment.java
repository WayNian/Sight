package com.sight.waynian.sight.fragment.video;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.NetVideoAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.video.NetVideoBean;
import com.sight.waynian.sight.http.HttpMethods;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by waynian on 2017/4/20.
 * 在线视频
 */

public class NetVideoFragment extends BaseFragment {

    private XRecyclerView mRecyclerView;
    private List<NetVideoBean.V9LG4CHORBean> listData;

    private NetVideoAdapter netVideoAdapter;

    private int pageIndex = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_net_video, null);
            initUI();
        }
        return rootView;
    }

    private void initUI() {
        mRecyclerView = (XRecyclerView) rootView.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.xlistview_arrow);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        listData.clear();
                        pageIndex = 0;
                        getVideoList(pageIndex);
                    }
                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ++pageIndex;
                        getVideoList(pageIndex * 10);
                        netVideoAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });

        listData = new ArrayList<>();
        netVideoAdapter = new NetVideoAdapter(mContext, listData);
        mRecyclerView.setAdapter(netVideoAdapter);
        mRecyclerView.refresh();
        getVideoList(pageIndex);
    }

    private void getVideoList(int pageIndex) {
        HttpMethods.getInstance().getVideoList(new Subscriber<NetVideoBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(NetVideoBean netVideoBean) {
                for (NetVideoBean.V9LG4CHORBean item : netVideoBean.getTag()) {
                    listData.add(item);
                }
                netVideoAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        }, pageIndex);
    }
}
