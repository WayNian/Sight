package com.sight.waynian.sight.fragment.read;

import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.base.BaseFragment;

/**
 * Created by waynian on 2017/4/4.
 */

public class GankFragment extends BaseFragment {
    private static final String TAG = GankFragment.class.getCanonicalName();

    @Override
    protected View initView() {
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

    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
            XLog.d("代码可见");
        } else {
            XLog.d("代码不可见");
        }
    }
}
