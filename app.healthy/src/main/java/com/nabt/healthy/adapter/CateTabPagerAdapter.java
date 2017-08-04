package com.nabt.healthy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.nabt.healthy.entity.Cate;
import com.nabt.healthy.fragment.InfoListFragment;

import java.util.List;

import market.lib.ui.adapter.TabPageAdapter;

public class CateTabPagerAdapter extends TabPageAdapter<Cate> {

    public CateTabPagerAdapter(FragmentManager fm, List<Cate> dataList) {
        super(fm, dataList);
    }

    @Override
    protected Fragment buildPage(int pos, Cate item) {
        return InfoListFragment.newInstance(item.getId()+"");
    }

    @Override
    protected String getTabName(int pos, Cate item) {
        return item.getName();
    }
}
