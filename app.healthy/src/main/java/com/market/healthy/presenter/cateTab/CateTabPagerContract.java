package com.market.healthy.presenter.cateTab;

import com.market.healthy.entity.Cate;

import java.util.List;

public class CateTabPagerContract {
    public interface IView{
        void onCateLoad(List<Cate> cateList);
        void onError(Throwable e);
    }
    public interface IPresenter{
        void reqCateList();
    }
}
