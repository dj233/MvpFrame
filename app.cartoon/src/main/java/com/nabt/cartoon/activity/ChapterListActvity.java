package com.nabt.cartoon.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.nabt.cartoon.R;
import com.nabt.cartoon.entity.Chapter;
import com.nabt.cartoon.entity.ChapterListResult;
import com.nabt.cartoon.entity.Rsp;
import com.nabt.cartoon.net.CartoonReq;

import market.lib.ui.activity.BaseListActivity;
import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ChapterListActvity extends BaseListActivity<Chapter> implements RecyclerAdapter.OnItemClickListener<Chapter>{

    String bookName;

    public static void access(Context context, String bookName){
        Intent intent = new Intent(context,ChapterListActvity.class);
        intent.putExtra("bookName",bookName);
        context.startActivity(intent);
    }

    @Override
    protected void getIntentData(Bundle bundle) {
        bookName = bundle.getString("bookName");
    }

    @Override
    protected RecyclerAdapter<Chapter> initAdapter() {
        RecyclerAdapter<Chapter> adapter =  new RecyclerAdapter<Chapter>(this) {
            @Override
            public int getItemLayout(int viewType) {
                return R.layout.item_chapter;
            }

            @Override
            public void bindData(int viewType, BaseViewHolder holder, Chapter item) {
                holder.setText(R.id.tv_item_chapter_name,item.getName());
            }
        };
        adapter.setOnItemClickListener(this);
        return adapter;
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new BaseListPresenter(this) {
            @Override
            public void refresh(int pageSize) {
                CartoonReq.$().listChapter(bookName,(page - 1) * pageSize + "")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Rsp<ChapterListResult>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<ChapterListResult> chapterListResultRsp) {
                                view.onAdd(chapterListResultRsp.getResult().getChapterList());
                            }
                        });
            }

            @Override
            public void add(int page, int pageSize) {
                CartoonReq.$().listChapter(bookName,(page - 1) * pageSize + "")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Rsp<ChapterListResult>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<ChapterListResult> chapterListResultRsp) {
                                view.onAdd(chapterListResultRsp.getResult().getChapterList());
                            }
                        });
            }
        };
    }

    @Override
    public void onItemClick(Chapter item, int pos) {
        CartoonListActvity.access(this,bookName,item.getId());
    }
}
