package com.nbt.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.nbt.R;
import com.nbt.entity.Joke;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.viewholder.BaseViewHolder;


public class JokeAdapter extends RecyclerAdapter<Joke> {
    private static final int TYPE_TXT = 1;
    private static final int TYPE_PIC = 2;

    public JokeAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemLayout(int viewType) {
        if(viewType == TYPE_PIC){
            return R.layout.item_pic;
        }else{
            return R.layout.item_text;
        }
    }

    @Override
    protected int getViewType(Joke item, int position) {
        if(TextUtils.isEmpty(item.getUrl())){
            return TYPE_TXT;
        }else{
            return TYPE_PIC;
        }
    }

    @Override
    public void bindData(int viewType, BaseViewHolder holder, Joke item) {
        holder.setText(R.id.tv_item_joke_txt,item.getContent());
        holder.setText(R.id.tv_item_joke_time,item.getUpdatetime());
        if(viewType == TYPE_PIC){
            holder.setImageUrl(R.id.iv_item_joke_pic,item.getUrl());
        }
    }

}
