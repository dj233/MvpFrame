package com.nabt.cook.fragment;

import com.nabt.cook.adapter.TabAdapter;
import com.nabt.cook.net.Req;
import com.nabt.cook.net.po.Data;
import com.nabt.cook.net.po.Result;
import com.nabt.cook.net.po.Tab;

import java.util.List;

import market.lib.ui.fragment.BaseTabPagerFragment;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by 14k on 2017/7/26.
 */

public class TabPagerFragment extends BaseTabPagerFragment<Tab> {

    @Override
    protected void reqTabs() {
        Observable<Result<List<Tab>>> ob = Req.$().tabs();
        ob.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Result<List<Tab>>>() {
            @Override
            public void call(Result<List<Tab>> dataResult) {
                List<Tab> tabs = dataResult.getResult();
                setTabPagerAdapter(new TabAdapter(getFragmentManager(),tabs));
            }
        });
    }
}
