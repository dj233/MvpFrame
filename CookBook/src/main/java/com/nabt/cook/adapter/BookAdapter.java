package com.nabt.cook.adapter;

import android.content.Context;

import com.nabt.cook.R;
import com.nabt.cook.dao.entity.Book;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.viewholder.BaseViewHolder;

/**
 * Created by 14k on 2017/7/26.
 */

public class BookAdapter extends RecyclerAdapter<Book> {

    public BookAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_book;
    }

    @Override
    public void bindData(int viewType, BaseViewHolder holder, Book item) {
        holder.setImageUrl(R.id.iv_item_book_img,item.getAlbum());
        holder.setText(R.id.tv_item_book_name,item.getTitle());
    }
}
