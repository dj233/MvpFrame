package com.nabt.cook.adapter;

import android.content.Context;

import com.nabt.cook.R;
import com.nabt.cook.dao.entity.Type;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.viewholder.BaseViewHolder;

/**
 * Created by 14k on 2017/7/26.
 */

public class TypeAdapter extends RecyclerAdapter<Type> {

    public TypeAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_type;
    }

    @Override
    public void bindData(int viewType, BaseViewHolder holder, Type item) {
        holder.setText(R.id.tv_item_type_name,item.getName());
    }
}
