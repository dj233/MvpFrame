package com.market.healthy.fragment;

import android.os.Bundle;

import com.market.healthy.activity.DetailActivity;
import com.market.healthy.adapter.DetailAdapter;
import com.market.healthy.entity.Detail;
import com.market.healthy.presenter.cateList.NewInfoListPresenter;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;

public class NewInfoListFragment extends BaseListFragment  implements RecyclerAdapter.OnItemClickListener<Detail>,BaseListContract.IView{

    public static NewInfoListFragment newInstance(){
        Bundle args = new Bundle();
        NewInfoListFragment newInfoListFragment = new NewInfoListFragment();
        newInfoListFragment.setArguments(args);
        return newInfoListFragment;
    }

    @Override
    protected void getIntentValue(Bundle bundle) {

    }

    @Override
    protected RecyclerAdapter initAdapter() {
        return new DetailAdapter(getContext());
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new NewInfoListPresenter(this);
    }

    @Override
    public void onItemClick(Detail item, int pos) {
        DetailActivity.toDetailPage(getContext(),item);
    }
}
