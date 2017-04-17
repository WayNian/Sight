package com.sight.waynian.sight.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sight.waynian.sight.R;
import com.sight.waynian.sight.bean.zhihu.NewsTimeLine;

import java.util.List;

/**
 * Created by waynian on 2017/4/17.
 */

public class QuickAdapter extends BaseQuickAdapter<NewsTimeLine.StoriesBean, BaseViewHolder> {

    public QuickAdapter(List<NewsTimeLine.StoriesBean> list) {
        super(R.layout.list_item, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsTimeLine.StoriesBean item) {
        helper.setText(R.id.question_title, item.getTitle());
        String url = item.getImages().get(0);

    }
}