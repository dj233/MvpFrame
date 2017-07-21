package market.lib.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import market.lib.R;
import market.lib.ui.adapter.TabPageAdapter;
import market.lib.ui.presenter.BaseTabContract;
import market.lib.ui.widget.NoScrollViewPager;

public abstract class BaseTabPagerFragment<T> extends Fragment implements View.OnClickListener,BaseTabContract.IView<T>{

    private TabLayout tabs;
    private NoScrollViewPager viewPager;
    private TabPageAdapter<T> tabPagerAdapter;
    private FloatingActionButton fbShare;
    private BaseTabContract.IPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_pager,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabs = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
        fbShare = view.findViewById(R.id.fab_share);
        fbShare.setOnClickListener(this);
        bindTabPager();
        presenter = getPresenter();
        presenter.reqTabs();
    }

    private void bindTabPager(){
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPos = tab.getPosition();
                viewPager.setCurrentItem(tabPos,false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.fab_share){
            //TODO　
        }
    }

    public void setTabPagerAdapter(TabPageAdapter<T> tabPagerAdapter) {
        this.tabPagerAdapter = tabPagerAdapter;
        viewPager.setAdapter(tabPagerAdapter);
    }

    protected abstract BaseTabContract.IPresenter getPresenter();
    protected abstract TabPageAdapter<T> getTabPagerAdapter(List<T> tabs);

    @Override
    public void onTabLoad(List<T> tabs) {

    }


}
