package com.market.healthy.presenter.cateList;

import com.market.healthy.entity.Info;
import com.market.healthy.entity.ListData;
import com.market.healthy.entity.Rsp;
import com.market.healthy.net.HealthReq;

import market.lib.ui.presenter.BaseListContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class SavedInfoListPresenter implements BaseListContract.IPresenter {

    private BaseListContract.IView view;

    public SavedInfoListPresenter(BaseListContract.IView view) {
        this.view = view;
    }

    @Override
    public void refresh(int pageSize) {
        //TODO 从数据库读取已关注的
    }

    @Override
    public void add(int page, int pageSize) {

    }
}
