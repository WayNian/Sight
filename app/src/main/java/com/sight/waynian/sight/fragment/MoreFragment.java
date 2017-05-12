package com.sight.waynian.sight.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sight.waynian.sight.R;
import com.sight.waynian.sight.base.BaseFragment;

/**
 * Created by waynian on 2017/4/4.
 */

public class MoreFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_github;

    private TextView tv_blog;

    public CollapsingToolbarLayout collapsingToolbarLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_more, null);
            initUI();
        }
        return rootView;
    }

    private void initUI() {
        tv_github = (TextView) rootView.findViewById(R.id.tv_github);
        tv_blog = (TextView) rootView.findViewById(R.id.tv_blog);
        collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("很高兴你能看到这里");
        tv_github.setOnClickListener(this);
        tv_blog.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_github:
                Intent it1 = new Intent(Intent.ACTION_VIEW);
                it1.setData(Uri.parse(tv_github.getText().toString()));
                startActivity(it1);
                break;
            case R.id.tv_blog:
                Intent it2 = new Intent(Intent.ACTION_VIEW);
                it2.setData(Uri.parse(tv_blog.getText().toString()));
                startActivity(it2);
                break;
        }
    }
}
