package com.nabt.cartoon.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nabt.cartoon.BookAdapter;
import com.nabt.cartoon.R;
import com.nabt.cartoon.activity.ChapterListActvity;
import com.nabt.cartoon.entity.Book;
import com.nabt.cartoon.entity.BookListResult;
import com.nabt.cartoon.entity.Rsp;
import com.nabt.cartoon.net.CartoonReq;
import com.nabt.db.wrapper.DbMaster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class BookListFragment extends BaseListFragment<Book> implements
        RecyclerAdapter.OnItemClickListener<Book>{
    private String typeName;

    public static BookListFragment $(String typeName){
        BookListFragment frag = new BookListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("typeName",typeName);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    protected void getIntentValue(Bundle bundle) {
        typeName = bundle.getString("typeName");
    }

    @Override
    protected void initRefreshAdapter() {
        refreshView.setBaseFooterAdapter();
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
                CartoonReq.$().listBook("",typeName,"",1)
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
            public void add(int page, int pageSize) {
                CartoonReq.$().listBook("",typeName,((page - 1) * pageSize) + "",1)
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
