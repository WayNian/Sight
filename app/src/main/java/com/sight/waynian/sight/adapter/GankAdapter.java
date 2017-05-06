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

import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.gank.Data;
import com.sight.waynian.sight.ui.GankActivity;

import java.util.List;

/**
 * Created by waynian on 2017/4/17.
 */

public class GankAdapter extends RecyclerView.Adapter<GankAdapter.ViewHolder> {
    private List<Data.ResultsBean> list = null;
    private Context context;

    public GankAdapter(Context context, List<Data.ResultsBean> list) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public GankAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new GankAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        (holder).tvTitle.setText(list.get(position).getTitle());
        (holder).cvNewsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GankActivity.newIntent(context, list.get(position).getPublishedAt().getTime());
                context.startActivity(intent);
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
