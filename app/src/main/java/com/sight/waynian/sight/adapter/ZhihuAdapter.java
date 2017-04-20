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
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.ui.WebActivity;

import java.util.List;

/**
 * Created by waynian on 2017/4/17.
 */

public class ZhihuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ZhihuBean.StoriesBean> list;
    private Context context;
    private LayoutInflater inflater;

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;

    public ZhihuAdapter(List<ZhihuBean.StoriesBean> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                return new NormalViewHolder(inflater.inflate(R.layout.list_item, parent, false));
            case TYPE_FOOTER:
                return new FooterViewHolder(inflater.inflate(R.layout.list_footer, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalViewHolder) {

            ((NormalViewHolder) holder).tvTitle.setText(list.get(position).getTitle());
            final String id = list.get(position).getId() + "";
            final String title = list.get(position).getTitle();
            Glide.with(context).load(list.get(position).getImages().get(0)).into(((NormalViewHolder) holder).ivZhihu);
            ((NormalViewHolder) holder).cvNewsList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, WebActivity.class)
                            .putExtra("id", id)
                            .putExtra("title", title));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) {
            return ZhihuAdapter.TYPE_FOOTER;
        }
        return ZhihuAdapter.TYPE_NORMAL;
    }

    static class NormalViewHolder extends RecyclerView.ViewHolder {
        CardView cvNewsList;
        ImageView ivZhihu;
        TextView tvTitle;

        public NormalViewHolder(View itemView) {
            super(itemView);
            cvNewsList = (CardView) itemView.findViewById(R.id.news_list_card_view);
            ivZhihu = (ImageView) itemView.findViewById(R.id.thumbnail_image);
            tvTitle = (TextView) itemView.findViewById(R.id.question_title);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }

    }
}
