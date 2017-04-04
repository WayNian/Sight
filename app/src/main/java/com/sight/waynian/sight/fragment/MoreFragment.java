package com.sight.waynian.sight.fragment;

import android.view.View;

import com.sight.waynian.sight.R;
import com.sight.waynian.sight.base.BaseFragment;

/**
 * Created by waynian on 2017/4/4.
 */

public class MoreFragment extends BaseFragment {
    private View view;
    @Override
    protected View initView() {
        view = View.inflate(mContext, R.layout.fragment_more, null);
        initUI();
        return view;
    }

    private void initUI() {

    }
}
