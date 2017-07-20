package com.market.healthy.adapter;

import android.content.Context;

import com.market.healthy.R;
import com.market.healthy.entity.Info;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.viewholder.BaseViewHolder;

public class InfoAdapter extends RecyclerAdapter<Info>{

    public InfoAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_health_info;
    }

    @Override
    public void bindData(int viewType, BaseViewHolder holder, Info item) {
        holder.setText(R.id.tv_item_health_title,item.getTitle());
        holder.setText(R.id.tv_item_health_description,item.getDescription());
        holder.setImageUrl(R.id.iv_item_health_img,item.getImg());
    }
}
