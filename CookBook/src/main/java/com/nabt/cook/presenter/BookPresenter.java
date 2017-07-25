package com.nabt.cook.presenter;

import com.nabt.cook.dao.entity.Book;
import com.nabt.cook.net.Req;
import com.nabt.cook.net.po.Data;
import com.nabt.cook.net.po.Result;

import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 14k on 2017/7/26.
 */

public class BookPresenter extends BaseListPresenter{
    private String typeId;

    public BookPresenter(BaseListContract.IView view, String typeId) {
        super(view);
        this.typeId = typeId;
    }

    @Override
    public void refresh(int pageSize) {
        Observable<Result<Data<Book>>> ob = Req.$().byType(typeId,0,pageSize);
        ob.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result<Data<Book>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.onError(e);
            }

            @Override
            public void onNext(Result<Data<Book>> dataResult) {
                view.onRefresh(dataResult.getResult().getData());
            }
        });
    }

    @Override
    public void add(int page, int pageSize) {
        Observable<Result<Data<Book>>> ob = Req.$().byType(typeId,page,pageSize);
        ob.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result<Data<Book>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.onError(e);
            }

            @Override
            public void onNext(Result<Data<Book>> dataResult) {
                view.onAdd(dataResult.getResult().getData());
            }
        });
    }
}
