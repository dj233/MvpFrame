package com.market.healthy.presenter.detail;

import com.market.healthy.entity.Detail;

public class DetailContract {
    public interface IView{
        void onDataLoad(Detail detail);
    }

    public interface IPresenter{
        void reqDetail(String id);
    }
}
