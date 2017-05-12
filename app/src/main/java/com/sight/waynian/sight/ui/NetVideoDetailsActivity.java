package com.sight.waynian.sight.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.sight.waynian.sight.R;

import llf.videomodel.VideoPlayer;

public class NetVideoDetailsActivity extends AppCompatActivity {

    private VideoPlayer mViewPager;

    private String url;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_net_video_details);

        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        initUI();
    }

    private void initUI() {
        mViewPager = (VideoPlayer) findViewById(R.id.video_player);
        mViewPager.playVideo(url, title);
    }

    @Override
    protected void onDestroy() {
        //一定要记得销毁View
        if (mViewPager != null) {
            mViewPager.destroyVideo();
            mViewPager = null;
        }
        super.onDestroy();
    }

}
