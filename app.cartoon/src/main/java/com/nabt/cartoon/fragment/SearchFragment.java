package com.nabt.cartoon.fragment;

import android.os.Bundle;

import com.nabt.cartoon.BookAdapter;
import com.nabt.cartoon.R;
import com.nabt.cartoon.activity.ChapterListActvity;
import com.nabt.cartoon.entity.Book;
import com.nabt.cartoon.entity.BookListResult;
import com.nabt.cartoon.entity.Rsp;
import com.nabt.cartoon.net.CartoonReq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseFragment;
import market.lib.ui.fragment.BaseSearchListFragment;
import market.lib.ui.presenter.BaseSearchListContract;
import market.lib.ui.presenter.BaseSearchListPresenter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchFragment extends BaseSearchListFragment<Book> implements RecyclerAdapter.OnItemClickListener<Book>{

    private SimpleDateFormat sdf2Date = new SimpleDateFormat("yyyymmdd");
    private SimpleDateFormat sdf2Str = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    protected void getIntentValue(Bundle bundle) {

    }

    @Override
    protected RecyclerAdapter<Book> initAdapter() {
        RecyclerAdapter<Book> adapter = new BookAdapter(getContext());
        adapter.setOnItemClickListener(this);
        return adapter;
    }

    @Override
    protected BaseSearchListContract.IPresenter initPresenter() {
        return new BaseSearchListPresenter(this) {
            @Override
            public void refresh(String keyword, int pageSize) {
                CartoonReq.$().listBook(keyword,"","",1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Rsp<BookListResult>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<BookListResult> bookListResultRsp) {
                                view.onRefresh(bookListResultRsp.getResult().getBookList());
                            }
                        });
            }

            @Override
            public void add(String keyword, int page, int pageSize) {
                CartoonReq.$().listBook(keyword,"",((page - 1) * pageSize) + "",1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Rsp<BookListResult>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<BookListResult> bookListResultRsp) {
                                view.onAdd(bookListResultRsp.getResult().getBookList());
                            }
                        });
            }
        };
    }

    @Override
    public void onItemClick(Book item, int pos) {
        ChapterListActvity.access(getContext(),item.getName());
    }
}
