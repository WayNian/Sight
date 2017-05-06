package com.sight.waynian.sight.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.Adapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.fragment.read.ZhiHuFragment;
import com.sight.waynian.sight.fragment.video.LocalVideoFragment;

/**
 * Created by waynian on 2017/4/4.
 */

public class VideoFragment extends BaseFragment {

    private ViewPager viewPager;
    private int page = 0;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setCurrentItem(page);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_video, null);
            initUI();
        }
        return rootView;
    }

    private void initUI() {
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
            viewPager.setOffscreenPageLimit(2);
        }

        final TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new ZhiHuFragment(), "在线视频");
        adapter.addFragment(new LocalVideoFragment(), "本地视频");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {

        } else {

        }
    }
}
