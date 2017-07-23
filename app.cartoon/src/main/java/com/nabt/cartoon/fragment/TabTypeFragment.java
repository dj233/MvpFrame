package com.nabt.cartoon.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import market.lib.ui.adapter.TabPageAdapter;
import market.lib.ui.fragment.BaseTabPagerFragment;
import market.lib.ui.presenter.BaseTabContract;
import market.lib.ui.presenter.BaseTabPresenter;

public class TabTypeFragment extends BaseTabPagerFragment<String>
{

    @Override
    public int getTabMode() {
        return TabLayout.MODE_FIXED;
    }

    @Override
    protected boolean hideFloatActionBar() {
        return true;
    }

    @Override
    protected BaseTabContract.IPresenter getPresenter() {
        return new BaseTabPresenter(this) {
            @Override
            public void reqTabs() {
                List<String> tabNames = new ArrayList<>();
                tabNames.add("少年漫画");
                tabNames.add("青年漫画");
                tabNames.add("少女漫画");
                tabNames.add("耽美漫画");
                view.onTabLoad(tabNames);
            }
        };
    }

    @Override
    public void onTabLoad(List<String> tabs) {
        setTabPagerAdapter(getTabPagerAdapter(tabs));
    }

    @Override
    protected TabPageAdapter<String> getTabPagerAdapter(List<String> tabs) {
        return new TabPageAdapter<String>(getFragmentManager(),tabs) {
            @Override
            protected Fragment buildPage(int pos, String item) {
                return BookListFragment.$(item);
            }

            @Override
            protected String getTabName(int pos, String item) {
                return item;
            }
        };
    }
}
