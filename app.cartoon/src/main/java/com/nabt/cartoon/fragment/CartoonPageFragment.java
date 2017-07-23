package com.nabt.cartoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nabt.cartoon.R;

import butterknife.BindView;
import market.lib.ui.fragment.BaseFragment;

public class CartoonPageFragment extends BaseFragment {
    @BindView(R.id.iv_page_cartoon)
    ImageView ivPageCartoon;
    String picUrl;
    @Override
    public int getLayoutId() {
        return R.layout.frag_page_cartoon;
    }

    public static CartoonPageFragment $(String picUrl){
        CartoonPageFragment fragment = new CartoonPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("picUrl",picUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        picUrl = getArguments().getString("picUrl");
        Glide.with(getContext()).load(picUrl).into(ivPageCartoon);
    }

}
