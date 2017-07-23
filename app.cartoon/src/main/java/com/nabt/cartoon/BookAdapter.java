package com.nabt.cartoon;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.nabt.cartoon.entity.Book;
import com.nabt.db.wrapper.DbMaster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class BookAdapter extends RecyclerAdapter<Book> {
    private SimpleDateFormat sdf2Date = new SimpleDateFormat("yyyymmdd");
    private SimpleDateFormat sdf2Str = new SimpleDateFormat("yyyy-mm-dd");

    public BookAdapter(Context mContext) {
        super(mContext);
    }


    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_book;
    }

    @Override
    public void bindData(int viewType, BaseViewHolder holder, final Book item) {
        holder.setImageUrl(R.id.iv_item_book_src, item.getCoverImg());
        holder.setText(R.id.tv_item_book_name, item.getName());
        holder.setText(R.id.tv_item_book_des, item.getDes());
        holder.setText(R.id.tv_item_book_type, mContext.getString(R.string.area_type_end, item.getArea(), item.getType(), item.isFinish() ? "已完结" : "连载中"));
        try {
            Date date = sdf2Date.parse("" + item.getLastUpdate());
            holder.setText(R.id.tv_item_book_time, mContext.getString(R.string.last_update_time, sdf2Str.format(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.setOnClick(R.id.tv_item_book_save, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBookIntoDb(item);
            }
        });
    }

    private void saveBookIntoDb(final Book book){
        Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                subscriber.onNext(DbMaster.$().$Book().add(book));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(mContext,"收藏失败",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if(aBoolean){
                            Toast.makeText(mContext,"收藏成功，可在收藏页面查看",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext,"该书已收藏",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
