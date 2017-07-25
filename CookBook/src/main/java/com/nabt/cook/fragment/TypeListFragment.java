package com.nabt.cook.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nabt.cook.adapter.TypeAdapter;
import com.nabt.cook.dao.entity.Type;
import com.nabt.cook.net.po.Tab;
import com.nabt.cook.presenter.TypeListPresenter;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;

/**
 * Created by 14k on 2017/7/26.
 */

public class TypeListFragment extends BaseListFragment<Type> implements RecyclerAdapter.OnItemClickListener<Type>{

    private Tab mTab;

    public static TypeListFragment $(Tab tab){
        TypeListFragment frag = new TypeListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Tab",tab);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    protected void getIntentValue(Bundle bundle) {
        mTab = (Tab) bundle.getSerializable("Tab");
    }

    @Override
    protected RecyclerAdapter<Type> initAdapter() {
        TypeAdapter adapter = new TypeAdapter(getContext());
        adapter.setOnItemClickListener(this);
        return adapter;
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new TypeListPresenter(this,mTab);
    }

    @Override
    protected RecyclerView.LayoutManager initLayoutManager() {
        return new GridLayoutManager(getContext(),3);
    }

    @Override
    protected void initRefreshAdapter() {

    }

    @Override
    public void onItemClick(Type item, int pos) {

    }
}
