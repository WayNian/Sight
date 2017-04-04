package com.sight.waynian.sight.fragment;

import android.view.View;

import com.sight.waynian.sight.R;
import com.sight.waynian.sight.base.BaseFragment;

/**
 * Created by waynian on 2017/4/4.
 */

public class VideoFragment extends BaseFragment {
    private View view;
    @Override
    protected View initView() {
        view = View.inflate(mContext, R.layout.fragment_video, null);
        initUI();
        return view;
    }

    private void initUI() {

    }
}
