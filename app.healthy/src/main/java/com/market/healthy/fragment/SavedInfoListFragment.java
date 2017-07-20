package com.market.healthy.fragment;

import android.os.Bundle;

import com.market.healthy.presenter.cateList.NewInfoListPresenter;

import market.lib.ui.presenter.BaseListContract;

public class SavedInfoListFragment extends InfoListFragment {

    public static SavedInfoListFragment newInstance(){
        Bundle args = new Bundle();
        SavedInfoListFragment savedInfoListFragment = new SavedInfoListFragment();
        savedInfoListFragment.setArguments(args);
        return savedInfoListFragment;
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new NewInfoListPresenter(this);
    }

    @Override
    protected void initRefreshAdapter() {
        refreshView.setBaseHeaderAdapter();
    }
}
