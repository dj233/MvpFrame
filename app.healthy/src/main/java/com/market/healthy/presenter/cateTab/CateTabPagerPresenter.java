package com.market.healthy.presenter.cateTab;

import com.market.healthy.entity.Cate;
import com.market.healthy.entity.Rsp;
import com.market.healthy.net.HealthReq;

import java.util.List;

import market.lib.ui.fragment.BaseTabPagerFragment;
import market.lib.ui.presenter.BaseTabContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CateTabPagerPresenter implements BaseTabContract.IPresenter {

    BaseTabContract.IView view;

    public CateTabPagerPresenter(BaseTabContract.IView view) {
        this.view = view;
    }

    @Override
    public void reqTabs() {
        HealthReq.$().listCate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rsp<List<Cate>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(Rsp<List<Cate>> listRsp) {
                        view.onTabLoad(listRsp.getResult());
                    }
                });
    }
}
