package com.sight.waynian.sight.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.gank.Gank;

import java.util.List;

/**
 * Created by waynian on 2017/4/17.
 */

public class GankDetialAdapter extends RecyclerView.Adapter<GankDetialAdapter.ViewHolder> {
    private List<Gank> list = null;
    private static Context context;

    public GankDetialAdapter(Context context, List<Gank> list) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public GankDetialAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gank_list, viewGroup, false);
        return new GankDetialAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.bindItem(list.get(position));

    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_gank;
        ImageView iv_type;
        TextView tv_type;
        TextView tv_desc;
        TextView tv_who;
        ImageView iv_type_bg;

        public ViewHolder(View view) {
            super(view);
            card_gank = (CardView) itemView.findViewById(R.id.card_gank);
            iv_type = (ImageView) itemView.findViewById(R.id.iv_type);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            tv_who = (TextView) itemView.findViewById(R.id.tv_who);
            iv_type_bg = (ImageView) itemView.findViewById(R.id.iv_type_bg);
        }

        public void bindItem(Gank gank) {
            switch (gank.getType()) {
                case "Android":
                    Glide.with(context).load(R.drawable.android).centerCrop().into(iv_type);
                    iv_type_bg.setBackgroundResource(R.color.android);
                    break;
                case "iOS":
                    Glide.with(context).load(R.drawable.ios).centerCrop().into(iv_type);
                    iv_type_bg.setBackgroundResource(R.color.ios);
                    break;
                case "休息视频":
                    Glide.with(context).load(R.drawable.video).centerCrop().into(iv_type);
                    iv_type_bg.setBackgroundResource(R.color.休息视频);
                    break;
                case "前端":
                    Glide.with(context).load(R.drawable.web).centerCrop().into(iv_type);
                    iv_type_bg.setBackgroundResource(R.color.前端);
                    break;
                case "拓展资源":
                    Glide.with(context).load(R.drawable.tuozhan).centerCrop().into(iv_type);
                    iv_type_bg.setBackgroundResource(R.color.拓展资源);
                    break;
                case "瞎推荐":
                    Glide.with(context).load(R.drawable.tuijian).centerCrop().into(iv_type);
                    iv_type_bg.setBackgroundResource(R.color.瞎推荐);
                    break;
            }

            tv_type.setText("来自话题 : " + gank.getType());
            tv_desc.setText(gank.getDesc());
            tv_who.setText("via : " + gank.getWho());

        }
    }
}
