package com.sight.waynian.sight.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.adapter.AudioPagerAdapter;
import com.sight.waynian.sight.base.BaseFragment;
import com.sight.waynian.sight.bean.video.MediaItem;
import com.sight.waynian.sight.service.MusicPlayerService;
import com.sight.waynian.sight.ui.AudioPlayerActivity;

import java.util.ArrayList;

/**
 * Created by waynian on 2017/4/4.
 */

public class AudioFragment extends BaseFragment {
    private static final String TAG = AudioFragment.class.getCanonicalName();

    private RecyclerView recyclerView;
    private TextView tv_nomedia;
    private ProgressBar pb_loading;

    boolean isLoading;

    private AudioPagerAdapter audioPagerAdapter;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mediaItems != null && mediaItems.size() > 0) {
                //有数据
                //设置适配器
                audioPagerAdapter = new AudioPagerAdapter(mediaItems, mContext);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(audioPagerAdapter);
                //把文本隐藏
                tv_nomedia.setVisibility(View.GONE);
                //设置RecyclerView的Item的点击事件
                audioPagerAdapter.setOnItemClickListener(new AudioPagerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(mContext,AudioPlayerActivity.class);
                        intent.putExtra("position",position);
                        mContext.startActivity(intent);
                    }
                });
            } else {
                //没有数据
                //文本显示
                tv_nomedia.setVisibility(View.VISIBLE);
                tv_nomedia.setText("没有发现音频....");
            }


            //ProgressBar隐藏
            pb_loading.setVisibility(View.GONE);
        }
    };

    /**
     * 装数据集合
     */
    private ArrayList<MediaItem> mediaItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = View.inflate(mContext, R.layout.fragment_audio, null);
            initUI();
        }
        return rootView;
    }

    private void initUI() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tv_nomedia = (TextView) rootView.findViewById(R.id.tv_nomedia);
        pb_loading = (ProgressBar) rootView.findViewById(R.id.pb_loading);
    }


    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
            if (!isLoading){
                getDataFromLocal();
                isLoading = true;
            }
        } else {
            isLoading = true;
        }
    }

    /**
     * 从本地的sdcard得到数据
     * //1.遍历sdcard,后缀名
     * //2.从内容提供者里面获取视频
     * //3.如果是6.0的系统，动态获取读取sdcard的权限
     */
    private void getDataFromLocal() {

        new Thread() {
            @Override
            public void run() {
                super.run();
                mediaItems = new ArrayList<>();
                ContentResolver resolver = mContext.getContentResolver();
                Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Audio.Media.DISPLAY_NAME,//视频文件在sdcard的名称
                        MediaStore.Audio.Media.DURATION,//视频总时长
                        MediaStore.Audio.Media.SIZE,//视频的文件大小
                        MediaStore.Audio.Media.DATA,//视频的绝对地址
                        MediaStore.Audio.Media.ARTIST,//歌曲的演唱者
                        MediaStore.Audio.Media.ALBUM,//歌曲的演唱者
                        MediaStore.Audio.Media.ALBUM_ID

                };
                Cursor cursor = resolver.query(uri, objs, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {

                        MediaItem mediaItem = new MediaItem();

                        mediaItems.add(mediaItem);//写在上面

                        String name = cursor.getString(0);//视频的名称
                        mediaItem.setName(name);

                        long duration = cursor.getLong(1);//视频的时长
                        mediaItem.setDuration(duration);

                        long size = cursor.getLong(2);//视频的文件大小
                        mediaItem.setSize(size);

                        String data = cursor.getString(3);//视频的播放地址
                        mediaItem.setData(data);

                        String artist = cursor.getString(4);//艺术家
                        mediaItem.setArtist(artist);

                        String album = cursor.getString(5);//专辑
                        mediaItem.setAlbum(album);
                    }
                    cursor.close();
                }
                //Handler发消息
                handler.sendEmptyMessage(10);
            }
        }.start();
    }

    /**
     * 解决安卓6.0以上版本不能读取外部存储权限的问题
     * @param activity
     * @return
     */
    public static boolean isGrantExternalRW(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity.checkSelfPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            activity.requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);

            return false;
        }

        return true;
    }
}
