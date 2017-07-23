package com.nabt.cartoon.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.nabt.cartoon.R;
import com.nabt.cartoon.entity.Cartoon;
import com.nabt.cartoon.entity.CartoonListResult;
import com.nabt.cartoon.entity.Chapter;
import com.nabt.cartoon.entity.ChapterListResult;
import com.nabt.cartoon.entity.Rsp;
import com.nabt.cartoon.net.CartoonReq;

import market.lib.ui.activity.BaseListActivity;
import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.presenter.BaseListContract;
import market.lib.ui.presenter.BaseListPresenter;
import market.lib.ui.viewholder.BaseViewHolder;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CartoonListActvity extends BaseListActivity<Cartoon> {

    String bookName;
    int chapterId;

    public static void access(Context context, String bookName,int chapterId){
        Intent intent = new Intent(context,CartoonListActvity.class);
        intent.putExtra("bookName",bookName);
        intent.putExtra("chapterId",chapterId);
        context.startActivity(intent);
    }

    @Override
    protected void getIntentData(Bundle bundle) {
        bookName = bundle.getString("bookName");
        chapterId = bundle.getInt("chapterId");
    }

    @Override
    protected void initRefreshAdapter() {

    }

    @Override
    protected RecyclerAdapter<Cartoon> initAdapter() {
        return new RecyclerAdapter<Cartoon>(this) {
            @Override
            public int getItemLayout(int viewType) {
                return R.layout.item_cartoon;
            }

            @Override
            public void bindData(int viewType, BaseViewHolder holder, Cartoon item) {
                holder.setImageUrl(R.id.iv_item_cartoon,item.getImageUrl());
            }
        };
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return new BaseListPresenter(this) {
            @Override
            public void refresh(int pageSize) {
                CartoonReq.$().listCartoon(bookName,chapterId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Rsp<CartoonListResult>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.onError(e);
                            }

                            @Override
                            public void onNext(Rsp<CartoonListResult> cartoonListResultRsp) {
                                view.onRefresh(cartoonListResultRsp.getResult().getImageList());
                            }
                        });
            }

            @Override
            public void add(int page, int pageSize) {

            }
        };
    }
}
