package com.market.healthy.presenter.cateList;

import com.market.healthy.entity.Info;
import com.market.healthy.entity.ListData;
import com.market.healthy.entity.Rsp;
import com.market.healthy.net.HealthReq;

import market.lib.ui.presenter.BaseListContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HealthListFragmentPresenter implements BaseListContract.IPresenter{

    private String cateId;
    private BaseListContract.IView view;

    public HealthListFragmentPresenter(String cateId, BaseListContract.IView view) {
        this.cateId = cateId;
        this.view = view;
    }

    @Override
    public void refresh(int pageSize) {
        HealthReq.$().listInfo(cateId,"0",pageSize+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rsp<ListData<Info>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(Rsp<ListData<Info>> listDataRsp) {
                        view.onRefresh(listDataRsp.getResult().getData());
                    }
                });
    }

    @Override
    public void add(int page, int pageSize) {
        HealthReq.$().listInfo(cateId,page+"",pageSize+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rsp<ListData<Info>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(Rsp<ListData<Info>> listDataRsp) {
                        view.onAdd(listDataRsp.getResult().getData());
                    }
                });
    }
}
