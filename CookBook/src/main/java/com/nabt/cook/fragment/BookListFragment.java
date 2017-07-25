package com.nabt.cook.fragment;

import android.os.Bundle;

import com.nabt.cook.adapter.BookAdapter;
import com.nabt.cook.dao.entity.Book;
import com.nabt.cook.dao.entity.Type;

import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.fragment.BaseListFragment;
import market.lib.ui.presenter.BaseListContract;

/**
 * Created by 14k on 2017/7/26.
 */

public class BookListFragment extends BaseListFragment<Book> implements RecyclerAdapter.OnItemClickListener{

    private Type mType;

    public static BaseListFragment $(Type type){
        BookListFragment frag = new BookListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Type",type);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    protected void getIntentValue(Bundle bundle) {
        mType = (Type) bundle.getSerializable("Type");
    }

    @Override
    protected RecyclerAdapter<Book> initAdapter() {
        BookAdapter adapter = new BookAdapter(getContext());
        adapter.setOnItemClickListener(this);
        return null;
    }

    @Override
    protected BaseListContract.IPresenter initPresenter() {
        return null;
    }

    @Override
    public void onItemClick(Object item, int pos) {

    }
}
