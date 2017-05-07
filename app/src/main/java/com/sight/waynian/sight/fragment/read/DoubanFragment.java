package com.sight.waynian.sight.fragment.read;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.GankAdapter;
import com.sight.waynian.sight.api.DoubanApiService;
import com.sight.waynian.sight.base.BaseFragment;

import retrofit2.Retrofit;

/**
 * Created by waynian on 2017/4/4.
 */

public class DoubanFragment extends BaseFragment {
    private static final long DEFAULT_TIMEOUT = 5;
    private XRecyclerView mRecyclerView;
    private GankAdapter gankAdapter;
    private int times = 0;

    private Retrofit retrofit;

    private DoubanApiService doubanApiService;

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
