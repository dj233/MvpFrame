package com.nabt.cartoon.presenter;

import com.nabt.cartoon.entity.CartoonListResult;
import com.nabt.cartoon.entity.Rsp;
import com.nabt.cartoon.net.CartoonReq;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CartoonPagerPresenter implements CartoonPageContract.IPresenter{
    CartoonPageContract.IView view;

    public CartoonPagerPresenter(CartoonPageContract.IView view) {
        this.view = view;
    }

    @Override
    public void reqCartoonList(String bookName, int chapterId) {
        CartoonReq.$().listCartoon(bookName,chapterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rsp<CartoonListResult>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Rsp<CartoonListResult> cartoonListResultRsp) {
                        view.onCartoonListLoad(cartoonListResultRsp.getResult().getImageList());
                    }
                });
    }
}
