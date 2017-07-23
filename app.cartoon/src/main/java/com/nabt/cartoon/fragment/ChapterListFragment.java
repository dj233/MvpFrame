package com.nabt.cartoon.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.nabt.cartoon.R;
import com.nabt.cartoon.entity.ChapterListResult;
import com.nabt.cartoon.entity.Chapter;
import com.nabt.cartoon.entity.Rsp;
import com.nabt.cartoon.net.CartoonReq;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ChapterListFragment extends BaseListFragment<Chapter> {
    String bookName;

    @Override
    protected void getIntentValue(Bundle bundle) {
        bookName = bundle.getString("bookName");
    }

    @Override
    protected void initRefreshAdapter() {
        refreshView.setBaseFooterAdapter();
    }

    public static ChapterListFragment $(String bookName){
        ChapterListFragment frag = new ChapterListFragment();
        Bundle argu = new Bundle();
        argu.putString("bookName",bookName);
        frag.setArguments(argu);
        return frag;
    }

    @Override
    protected RecyclerAdapter initAdapter() {
        return new RecyclerAdapter<Chapter>(getContext()) {
            @Override
            public int getItemLayout(int viewType) {
                return R.layout.item_chapter;
            }

            @Override
            public void bindData(int viewType, BaseViewHolder holder, Chapter item) {
                holder.setText(R.id.tv_item_chapter_name,item.getName());
            }
        };
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
}
