package com.nbt.fragment;

import android.os.Bundle;

import com.nbt.adapter.JokeAdapter;
import com.nbt.entity.Joke;
import com.nbt.presenter.JokePicPresenter;
import com.nbt.presenter.JokeTxtPresenter;
import com.nbt.presenter.RandPicPresenter;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;

public class RandPicFragment extends BaseListFragment {

    @Override
    protected RecyclerAdapter<Joke> initAdapter() {
        return new JokeAdapter(getContext());
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new RandPicPresenter(this);
    }

    @Override
    protected void initRefreshAdapter() {
        refreshView.setBaseHeaderAdapter();
    }

    @Override
    protected void getIntentValue(Bundle bundle) {

    }


}
