package com.sight.waynian.sight.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.elvishew.xlog.XLog;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.GankAdapter;
import com.sight.waynian.sight.adapter.GankDetialAdapter;
import com.sight.waynian.sight.bean.gank.Gank;
import com.sight.waynian.sight.bean.gank.GankData;
import com.sight.waynian.sight.fragment.read.GankFragment;
import com.sight.waynian.sight.http.HttpMethods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import rx.Subscriber;

public class GankActivity extends AppCompatActivity {

    private static final String TAG = GankFragment.class.getCanonicalName();

    private static final String DATE = "date";

    private XRecyclerView mRecyclerView;
    private List<Gank> listData;

    private GankDetialAdapter gankAdapter;

    private int year;
    private int month;
    private int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        parseIntent();
        initUI();
    }

    private void initUI() {
        mRecyclerView = (XRecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
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
                        getGankDetial(year, month, day);
                    }
                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {

            }
        });

        listData = new ArrayList<>();
        gankAdapter = new GankDetialAdapter(this, listData);
        mRecyclerView.setAdapter(gankAdapter);
        mRecyclerView.refresh();
    }

    private void getGankDetial(int year, int month, int day) {
        HttpMethods.getInstance().getGankDetial(new Subscriber<GankData>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(GankData data) {
                listData.addAll(data.results.getAllResults());
                XLog.d(data.toString());
                gankAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }
        }, year, month, day);
    }

    public static Intent newIntent(Context context, long date) {
        Intent intent = new Intent(context, GankActivity.class);
        intent.putExtra(GankActivity.DATE, date);
        return intent;
    }

    private void parseIntent() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getIntent().getLongExtra(DATE, 0));
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        XLog.d("时间" + year + month + day);
    }

}
