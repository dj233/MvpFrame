package com.market.healthy.presenter.detail;

import com.market.healthy.entity.Detail;
import com.market.healthy.entity.Rsp;
import com.market.healthy.net.HealthReq;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailPresenter implements DetailContract.IPresenter {
    private DetailContract.IView view;

    public DetailPresenter(DetailContract.IView view) {
        this.view = view;
    }

    @Override
    public void reqDetail(String id) {
        HealthReq.$().detail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rsp<Detail>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Rsp<Detail> detailRsp) {
                        view.onDataLoad(detailRsp.getResult());
                    }
                });
    }
}
