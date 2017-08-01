package com.nabt.healthy.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.dao.wrapper.DbMaster;
import com.nabt.healthy.entity.Detail;

import java.util.List;

import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SavedInfoListFragment extends NewInfoListFragment {

    public static SavedInfoListFragment newInstance(){
        Bundle args = new Bundle();
        SavedInfoListFragment savedInfoListFragment = new SavedInfoListFragment();
        savedInfoListFragment.setArguments(args);
        return savedInfoListFragment;
    }

    @Override
    protected void getIntentValue(Bundle bundle) {

    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new BaseListPresenter(this) {
            @Override
            public void refresh(int pageSize) {
                Observable.create(new Observable.OnSubscribe<List<Detail>>() {
                    @Override
                    public void call(Subscriber<? super List<Detail>> subscriber) {
                        subscriber.onNext(DbMaster.$().detailDao().list());
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Detail>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.onError(e);
                            }

                            @Override
                            public void onNext(List<Detail> details) {
                                view.onRefresh(details);

                                Toast.makeText(getContext(),"收藏夹为空，点击“√”号图标加入收藏",Toast.LENGTH_SHORT).show();
                            }
                        });
            }

            @Override
            public void add(int page, int pageSize) {

            }
        };
    }

    @Override
    protected void initRefreshAdapter() {

    }
}
