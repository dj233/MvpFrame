package com.market.healthy.fragment;

import android.os.Bundle;

import com.market.healthy.activity.DetailActivity;
import com.market.healthy.adapter.InfoAdapter;
import com.market.healthy.entity.Detail;
import com.market.healthy.entity.Info;
import com.market.healthy.presenter.cateList.HealthListFragmentPresenter;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;

public class InfoListFragment extends BaseListFragment implements RecyclerAdapter.OnItemClickListener<Info>,BaseListContract.IView{
    private static final String KV_CategoryId = "CategoryId";

    private String cateId;

    @Override
    protected void getIntentValue(Bundle bundle) {
        cateId = bundle.getString(KV_CategoryId);
    }

    public static InfoListFragment newInstance(String cateId){
        Bundle args = new Bundle();
        InfoListFragment cateFragment = new InfoListFragment();
        args.putString(KV_CategoryId, cateId);
        cateFragment.setArguments(args);
        return cateFragment;
    }

    @Override
    protected void overrideParentValue() {
        pageSize = 20;
    }

    @Override
    protected RecyclerAdapter initAdapter() {
        InfoAdapter infoAdapter = new InfoAdapter(getContext());
        infoAdapter.setOnItemClickListener(this);
        return infoAdapter;
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new HealthListFragmentPresenter(cateId,this);
    }

    @Override
    public void onItemClick(Info item, int pos) {
        DetailActivity.toDetailPage(getContext(),item.getId()+"");
    }
}
