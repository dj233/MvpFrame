package com.app.zuowen.fragment;

import android.content.Context;
import android.os.Bundle;
import com.app.zuowen.data.NewsReq;
import com.app.zuowen.entity.Channel;
import com.app.zuowen.entity.News;
import com.app.zuowen.entity.Rsp;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsListFragment extends BaseListFragment<News>{

    private String channel;

    public static NewsListFragment instance(Context context,String channel){
        NewsListFragment newsListFragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putString("channel",channel);
        newsListFragment.setArguments(args);
        return newsListFragment;
    }

    @Override
    protected void getIntentValue(Bundle bundle) {
        channel = bundle.getString("channel","头条");
    }

    @Override
    protected RecyclerAdapter<News> initAdapter() {
        return new RecyclerAdapter<News>(getContext()) {
            @Override
            public int getItemLayout(int viewType) {
                return market.lib.R.layout.item_title_pic_content;
            }

            @Override
            public void bindData(int viewType, BaseViewHolder holder, News item) {

            }
        };
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new BaseListPresenter(this) {
            @Override
            public void refresh(int pageSize) {
                NewsReq.$().getNews(channel,0,pageSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Rsp<Channel<News>>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<Channel<News>> channelRsp) {
                                view.onRefresh(channelRsp.getResult().getList());
                            }
                        });
            }

            @Override
            public void add(int page, int pageSize) {
                NewsReq.$().getNews(channel,page,pageSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Rsp<Channel<News>>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<Channel<News>> channelRsp) {
                                view.onAdd(channelRsp.getResult().getList());
                            }
                        });
            }
        };
    }
}
