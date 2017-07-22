package com.nbt.presenter;

import com.nbt.entity.Joke;
import com.nbt.entity.JokeRsp;
import com.nbt.net.RandJokeReq;

import java.util.List;

import market.lib.ui.presenter.BaseListContract;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RandPicPresenter implements BaseListContract.IPresenter {

    BaseListContract.IView view;

    public RandPicPresenter(BaseListContract.IView view) {
        this.view = view;
    }

    @Override
    public void refresh(int pageSize) {
        RandJokeReq.$().rand("pic")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeRsp<List<Joke>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(JokeRsp<List<Joke>> jokeRsp) {
                        view.onRefresh(jokeRsp.getResult());
                    }
                });
    }

    @Override
    public void add(int page,int pageSize) {
        RandJokeReq.$().rand("pic")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeRsp<List<Joke>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(JokeRsp<List<Joke>> jokeRsp) {
                        view.onRefresh(jokeRsp.getResult());
                    }
                });
    }
}
