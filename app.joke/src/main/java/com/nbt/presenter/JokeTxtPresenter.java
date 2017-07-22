package com.nbt.presenter;

import com.nbt.entity.JokeData;
import com.nbt.entity.JokeRsp;
import com.nbt.net.JokeReq;

import market.lib.ui.presenter.BaseListContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class JokeTxtPresenter implements BaseListContract.IPresenter {

    BaseListContract.IView view;

    public JokeTxtPresenter(BaseListContract.IView view) {
        this.view = view;
    }

    @Override
    public void refresh(int pageSize) {
        JokeReq.$().newTxt(1,pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeRsp<JokeData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(JokeRsp<JokeData> jokeRsp) {
                        view.onRefresh(jokeRsp.getResult().getData());
                    }
                });
    }

    @Override
    public void add(int page,int pageSize) {
        JokeReq.$().newTxt(page,pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeRsp<JokeData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(JokeRsp<JokeData> jokeRsp) {
                        view.onAdd(jokeRsp.getResult().getData());
                    }
                });
    }
}
