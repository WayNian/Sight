package com.sight.waynian.sight.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sight.waynian.sight.R;
import com.sight.waynian.sight.base.BaseFragment;

/**
 * Created by waynian on 2017/4/4.
 */

public class AudioFragment extends BaseFragment {
    private static final String TAG = AudioFragment.class.getCanonicalName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = View.inflate(mContext, R.layout.fragment_audio, null);
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
            //   do things when fragment is visible
            //    if (ListUtils.isEmpty(mDataList) && !isRefreshing()) {
            //        setRefresh(true);
            //        loadServiceData(false);
        } else {
            //        setRefresh(false);
        }
    }
}
