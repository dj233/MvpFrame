package com.nabt.healthy.presenter.cateList;

import com.nabt.healthy.entity.Detail;
import com.nabt.healthy.entity.ListData;
import com.nabt.healthy.entity.Rsp;
import com.nabt.healthy.net.HealthReq;

import market.lib.ui.presenter.BaseListContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NewInfoListPresenter implements BaseListContract.IPresenter {

    private BaseListContract.IView view;

    public NewInfoListPresenter(BaseListContract.IView view) {
        this.view = view;
    }

    @Override
    public void refresh(int pageSize) {
        HealthReq.$().listNewInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rsp<ListData<Detail>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.onError(e);
                    }

                    @Override
                    public void onNext(Rsp<ListData<Detail>> listDataRsp) {
                        view.onRefresh(listDataRsp.getResult().getData());
                    }
                });
    }

    @Override
    public void add(int page, int pageSize) {

    }
}
