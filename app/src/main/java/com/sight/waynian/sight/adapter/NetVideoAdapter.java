package com.sight.waynian.sight.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.video.NetVideoBean;
import com.sight.waynian.sight.ui.NetVideoDetailsActivity;

import java.util.List;

/**
 * Created by waynian on 2017/4/17.
 */

public class NetVideoAdapter extends RecyclerView.Adapter<NetVideoAdapter.ViewHolder> {
    private List<NetVideoBean.TrailersBean> list = null;
    private Context context;

    public NetVideoAdapter(Context context, List<NetVideoBean.TrailersBean> list) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public NetVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_net_video_item, viewGroup, false);
        return new NetVideoAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        (holder).tvTitle.setText(list.get(position).getMovieName());
        Glide.with(context).load(list.get(position).getCoverImg()).into((holder).ivZhihu);
        (holder).cvNewsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, NetVideoDetailsActivity.class)
                        .putExtra("url", list.get(position).getHightUrl())
                        .putExtra("title", list.get(position).getVideoTitle()));
            }
        });

    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvNewsList;
        ImageView ivZhihu;
        TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            cvNewsList = (CardView) itemView.findViewById(R.id.news_list_card_view);
            ivZhihu = (ImageView) itemView.findViewById(R.id.thumbnail_image);
            tvTitle = (TextView) itemView.findViewById(R.id.question_title);
        }
    }
}
