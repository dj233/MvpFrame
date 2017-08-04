package com.nabt.healthy.fragment;

import android.os.Bundle;

import com.nabt.healthy.adapter.CateTabPagerAdapter;
import com.nabt.healthy.entity.Cate;
import com.nabt.healthy.presenter.cateTab.CateTabPagerPresenter;

import java.util.List;

import market.lib.ui.adapter.TabPageAdapter;
import market.lib.ui.fragment.BaseTabPagerFragment;
import market.lib.ui.presenter.BaseTabContract;

public class CateTabPagerFragment extends BaseTabPagerFragment<Cate> implements BaseTabContract.IView<Cate>{

    private BaseTabContract.IPresenter presenter;

    public static CateTabPagerFragment newInstance(){
        Bundle args = new Bundle();
        CateTabPagerFragment cateTabPagerFragment = new CateTabPagerFragment();
        cateTabPagerFragment.setArguments(args);
        return cateTabPagerFragment;
    }

    @Override
    protected BaseTabContract.IPresenter getPresenter() {
        return new CateTabPagerPresenter(this);
    }

    @Override
    protected TabPageAdapter<Cate> getTabPagerAdapter(List<Cate> tabs) {
        return new CateTabPagerAdapter(getFragmentManager(),tabs);
    }

    @Override
    public void onTabLoad(List<Cate> tabs) {
        setTabPagerAdapter(new CateTabPagerAdapter(getFragmentManager(),tabs));
    }

    @Override
    public void onError(Throwable e) {

    }
}
