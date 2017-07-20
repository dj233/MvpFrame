package com.market.healthy.presenter.detail;

public class DetailPresenter implements DetailContract.IPresenter {
    private DetailContract.IView view;

    public DetailPresenter(DetailContract.IView view) {
        this.view = view;
    }

    @Override
    public void reqDetail(String id) {

    }
}
