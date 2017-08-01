package com.nabt.healthy.presenter.cateList;

import market.lib.ui.presenter.BaseListContract;


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
