package com.nabt.cartoon.fragment;


import android.os.Bundle;

import com.nabt.cartoon.BookAdapter;
import com.nabt.cartoon.R;
import com.nabt.cartoon.activity.ChapterListActvity;
import com.nabt.cartoon.entity.Book;
import com.nabt.db.wrapper.DbMaster;

import java.util.List;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseFragment;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.fragment.BaseTitleListFragment;
import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FaviorFragment extends BaseListFragment<Book> implements RecyclerAdapter.OnItemClickListener<Book> {

    @Override
    protected void getIntentValue(Bundle bundle) {

    }

    @Override
    protected void initRefreshAdapter() {

    }

    @Override
    protected RecyclerAdapter<Book> initAdapter() {
        RecyclerAdapter<Book> adapter = new BookAdapter(getContext());
        adapter.setOnItemClickListener(this);
        return adapter;
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new BaseListPresenter(this) {
            @Override
            public void refresh(int pageSize) {
                Observable.create(new Observable.OnSubscribe<List<Book>>() {
                    @Override
                    public void call(Subscriber<? super List<Book>> subscriber) {
                        subscriber.onNext(DbMaster.$().$Book().list());
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Book>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.onError(e);
                            }

                            @Override
                            public void onNext(List<Book> books) {
                                view.onRefresh(books);
                            }
                        });
            }

            @Override
            public void add(int page, int pageSize) {

            }
        };
    }

    @Override
    public void onItemClick(Book item, int pos) {
        ChapterListActvity.access(getContext(),item.getName());
    }
}
