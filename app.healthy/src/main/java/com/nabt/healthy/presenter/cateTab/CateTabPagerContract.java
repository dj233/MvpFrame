package com.nabt.healthy.presenter.cateTab;

import com.nabt.healthy.entity.Cate;

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
