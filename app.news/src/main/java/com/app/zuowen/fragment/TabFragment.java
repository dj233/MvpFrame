package com.app.zuowen.fragment;

import android.support.v4.app.Fragment;

import com.app.zuowen.data.NewsReq;
import com.app.zuowen.entity.Rsp;

import java.util.List;

import market.lib.ui.adapter.TabPageAdapter;
import market.lib.ui.fragment.BaseTabPagerFragment;
import market.lib.ui.presenter.BaseTabContract;
import market.lib.ui.presenter.BaseTabPresenter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TabFragment extends BaseTabPagerFragment<String> {

    @Override
    protected BaseTabContract.IPresenter getPresenter() {
        return new BaseTabPresenter(this) {
            @Override
            public void reqTabs() {
                NewsReq.$().getChannel()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Rsp<List<String>>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<List<String>> listRsp) {
                                view.onTabLoad(listRsp.getResult());
                            }
                        });
            }
        };
    }

    @Override
    protected TabPageAdapter<String> getTabPagerAdapter(List<String> tabs) {
        return new TabPageAdapter<String>(getFragmentManager(),tabs) {
            @Override
            protected Fragment buildPage(int pos, String item) {
                return NewsListFragment.instance(getContext(),item);
            }

            @Override
            protected String getTabName(int pos, String item) {
                return item;
            }
        };
    }
}
