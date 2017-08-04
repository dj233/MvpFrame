package com.nabt.healthy.presenter.detail;

import com.nabt.healthy.entity.Detail;

public class DetailContract {
    public interface IView{
        void onDataLoad(Detail detail);
    }

    public interface IPresenter{
        void reqDetail(String id);
    }
}
