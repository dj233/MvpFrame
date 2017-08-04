package com.nbt.fragment;


import android.os.Bundle;

import com.nbt.adapter.JokeAdapter;
import com.nbt.entity.Joke;
import com.nbt.presenter.JokePicPresenter;
import com.nbt.presenter.JokeTxtPresenter;
import com.nbt.uitls.SpfUtils;
import com.sak.ultilviewlib.interfaces.OnFooterRefreshListener;
import com.sak.ultilviewlib.interfaces.OnHeaderRefreshListener;

import java.util.List;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;

public class JokePicFragment extends BaseListFragment<Joke> implements
        OnFooterRefreshListener,OnHeaderRefreshListener,BaseListContract.IView<Joke>{
    @Override
    protected RecyclerAdapter<Joke> initAdapter() {
        return new JokeAdapter(getContext());
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new JokePicPresenter(this);
    }

    @Override
    protected void overrideParentValue() {
        super.overrideParentValue();
        page = SpfUtils.$().getPicJokeLastPage();
    }

    @Override
    public void onRefresh(List<Joke> data) {
        super.onRefresh(data);
    }

    @Override
    public void onAdd(List<Joke> data) {
        super.onAdd(data);
        SpfUtils.$().savePicJokeLastPage(page);
    }

    @Override
    protected void getIntentValue(Bundle bundle) {

    }
}
