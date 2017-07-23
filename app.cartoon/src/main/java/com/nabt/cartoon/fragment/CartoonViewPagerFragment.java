package com.nabt.cartoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.nabt.cartoon.R;
import com.nabt.cartoon.entity.Cartoon;
import com.nabt.cartoon.presenter.CartoonPageContract;
import com.nabt.cartoon.presenter.CartoonPagerPresenter;

import java.util.List;

import market.lib.ui.fragment.BaseFragment;

public class CartoonViewPagerFragment extends BaseFragment implements CartoonPageContract.IView {

    String bookName;
    int chapterId;
    ViewPager viewPager;
    CartoonPagerPresenter mPresenter;

    public static CartoonViewPagerFragment $(String bookName,int chapterId){
        Bundle bundle = new Bundle();
        bundle.putString("bookName",bookName);
        bundle.putInt("chapterId",chapterId);
        CartoonViewPagerFragment frag = new CartoonViewPagerFragment();
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        bookName = bundle.getString("bookName");
        chapterId = bundle.getInt("chapterId");
        mPresenter = new CartoonPagerPresenter(this);
        viewPager = view.findViewById(R.id.viewpager);
        mPresenter.reqCartoonList(bookName,chapterId);
    }

    @Override
    public void onCartoonListLoad(List<Cartoon> list) {
        viewPager.setAdapter(new CartoonFragmentPagerAdapter(getFragmentManager(),list));
    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_viewpager_cartoon;
    }

    class CartoonFragmentPagerAdapter extends FragmentPagerAdapter{
        List<Cartoon> mList;

        public CartoonFragmentPagerAdapter(FragmentManager fm, List<Cartoon> mList) {
            super(fm);
            this.mList = mList;
        }

        @Override
        public Fragment getItem(int position) {
            Cartoon cartoon = mList.get(position);
            return CartoonPageFragment.$(cartoon.getImageUrl());
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
