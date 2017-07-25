package com.nabt.cook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.nabt.cook.net.po.Tab;

import java.util.List;

import market.lib.ui.adapter.TabPageAdapter;

/**
 * Created by 14k on 2017/7/26.
 */

public class TabAdapter extends TabPageAdapter<Tab> {

    public TabAdapter(FragmentManager fm, List<Tab> dataList) {
        super(fm, dataList);
    }

    @Override
    protected Fragment buildPage(int pos, Tab item) {
        return null;
    }

    @Override
    protected String getTabName(int pos, Tab item) {
        return item.getName();
    }
}
