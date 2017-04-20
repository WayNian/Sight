package com.sight.waynian.sight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.video.MediaItem;
import com.sight.waynian.sight.uitils.Utils;

import java.util.List;

/**
 * Created by waynian on 2017/4/20.
 * 视频列表
 */

public class VideoPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MediaItem> mediaItems;
    private Context context;
    private LayoutInflater inflater;

    private OnItemClickListener onItemClickLinserter;
    private OnItemLongClickListener onItemLongClickLinserter;

    public VideoPagerAdapter(List<MediaItem> mediaItems, Context context) {
        this.mediaItems = mediaItems;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(inflater.inflate(R.layout.list_video_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Utils utils = new Utils();
        MediaItem mediaItem = mediaItems.get(position);
        XLog.d(mediaItem.toString());
        if (holder instanceof VideoViewHolder){
            ((VideoViewHolder) holder).tv_name.setText(mediaItem.getName());
            if (mediaItem.getSize() >0){
                ((VideoViewHolder) holder).tv_size.setText(android.text.format.Formatter.formatFileSize(context,mediaItem.getSize()));
            }
                ((VideoViewHolder) holder).tv_time.setText(utils.stringForTime((int) mediaItem.getDuration()));
        }

        if (onItemClickLinserter != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLinserter.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mediaItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_time;
        TextView tv_size;

        public VideoViewHolder(View itemView) {
            super(itemView);
            itemView.setBackgroundResource(R.drawable.recycler_bg);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_size = (TextView) itemView.findViewById(R.id.tv_size);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.onItemClickLinserter = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.onItemLongClickLinserter = mOnItemLongClickListener;
    }

}
