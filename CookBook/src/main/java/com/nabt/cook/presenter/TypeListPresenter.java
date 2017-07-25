package com.nabt.cook.presenter;

import com.nabt.cook.net.po.Tab;

import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;

/**
 * Created by 14k on 2017/7/26.
 */

public class TypeListPresenter extends BaseListPresenter {

    private Tab mTab;

    public TypeListPresenter(BaseListContract.IView view, Tab mTab) {
        super(view);
        this.mTab = mTab;
    }

    @Override
    public void refresh(int pageSize) {
        view.onRefresh(mTab.getList());
    }

    @Override
    public void add(int page, int pageSize) {

    }
}
