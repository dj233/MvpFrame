package com.nabt.cartoon.net;

import com.nabt.cartoon.entity.BookListResult;
import com.nabt.cartoon.entity.Cartoon;
import com.nabt.cartoon.entity.CartoonListResult;
import com.nabt.cartoon.entity.ChapterListResult;
import com.nabt.cartoon.entity.Rsp;

import lib.data.BaseReq;
import rx.Observable;


public class CartoonReq extends BaseReq {

    private static CartoonReq _ins;
    private CartoonApi api;
    private CartoonReq(){
        api = mRetrofit.create(CartoonApi.class);
    }

    @Override
    protected String baseUrl() {
        return CartoonApi.URL;
    }

    public static CartoonReq $(){
        if(_ins == null){
            synchronized (CartoonReq.class){
                _ins = new CartoonReq();
            }
        }
        return _ins;
    }

    public Observable<Rsp<BookListResult>> listBook(String keyword,String type,String skip,int isFinish){
        return api.listBook(CartoonApi.AppKey,keyword,type,skip,isFinish);
    }

    public Observable<Rsp<ChapterListResult>> listChapter(String bookName,String skip){
        return api.listChapter(CartoonApi.AppKey,bookName,skip);
    }

    public Observable<Rsp<CartoonListResult>> listCartoon(String bookName,int chapterId){
        return api.listCartoon(CartoonApi.AppKey,bookName,chapterId);
    }
}
