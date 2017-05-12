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
import com.elvishew.xlog.XLog;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.douban.DoubanListBean;
import com.sight.waynian.sight.bean.zhihu.ZhihuBean;
import com.sight.waynian.sight.ui.WebActivity;

import java.util.List;

/**
 * Created by waynian on 2017/4/17.
 */

public class DoubanAdapter extends RecyclerView.Adapter<DoubanAdapter.ViewHolder> {
    private List<DoubanListBean.PostsBean> list = null;
    private Context context;

    public DoubanAdapter(Context context, List<DoubanListBean.PostsBean> list) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public DoubanAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new DoubanAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final String id = list.get(position).getId() + "";
        final String title = list.get(position).getTitle();
        (holder).tvTitle.setText(title);
        if (null != list.get(position).getThumbs() && (list.get(position).getThumbs().size() > 0)) {
            Glide.with(context).load(list.get(position).getThumbs().get(0).getMedium().getUrl()).into((holder).ivZhihu);
        }
        (holder).cvNewsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("title",title);
                intent.putExtra("type", "豆瓣");
                if (list.get(position).getThumbs().size() == 0) {
                    intent.putExtra("coverUrl", "");
                } else {
                    intent.putExtra("coverUrl", list.get(position).getThumbs().get(0).getMedium().getUrl());
                }
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
