package com.nabt.cartoon.presenter;

import com.nabt.cartoon.entity.Cartoon;

import java.util.List;

public class CartoonPageContract {

    public interface IView{
        void onCartoonListLoad(List<Cartoon> list);
    }

    public interface IPresenter{
        void reqCartoonList(String bookName,int chapterId);
    }
}
