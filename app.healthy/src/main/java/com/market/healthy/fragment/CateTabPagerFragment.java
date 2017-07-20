package com.market.healthy.fragment;

import android.os.Bundle;

import com.market.healthy.activity.CateTabPagerAdapter;
import com.market.healthy.entity.Cate;
import com.market.healthy.presenter.cateTab.CateTabPagerContract;
import com.market.healthy.presenter.cateTab.CateTabPagerPresenter;

import java.util.List;

import market.lib.ui.fragment.BaseTabPagerFragment;

public class CateTabPagerFragment extends BaseTabPagerFragment<Cate> implements CateTabPagerContract.IView{

    private CateTabPagerContract.IPresenter presenter;

    public static CateTabPagerFragment newInstance(){
        Bundle args = new Bundle();
        CateTabPagerFragment cateTabPagerFragment = new CateTabPagerFragment();
        cateTabPagerFragment.setArguments(args);
        return cateTabPagerFragment;
    }

    @Override
    protected void reqTabs() {
        presenter = new CateTabPagerPresenter(this);
        presenter.reqCateList();
    }

    @Override
    public void onCateLoad(List<Cate> cateList) {
        setTabPagerAdapter(new CateTabPagerAdapter(getFragmentManager(),cateList));
    }

    @Override
    public void onError(Throwable e) {

    }
}
