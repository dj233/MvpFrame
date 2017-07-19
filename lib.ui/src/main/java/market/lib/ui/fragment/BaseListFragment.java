package market.lib.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sak.ultilviewlib.UltimateRefreshView;
import com.sak.ultilviewlib.interfaces.OnFooterRefreshListener;
import com.sak.ultilviewlib.interfaces.OnHeaderRefreshListener;

import java.util.List;

import market.lib.R;
import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.presenter.BaseListContract;


public abstract class BaseListFragment<T> extends Fragment implements BaseListContract.IView<T>,OnHeaderRefreshListener,
        OnFooterRefreshListener{
    protected UltimateRefreshView refreshView;
    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;
    private BaseListContract.IPresenter mPresenter;

    protected int page = 1;
    protected int pageSize = 30;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (RecyclerView) inflater.inflate(R.layout.fragment_list,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshView = (UltimateRefreshView) view.findViewById(R.id.refresh_view);
        initRefreshAdapter();
        refreshView.setOnHeaderRefreshListener(this);
        refreshView.setOnFooterRefreshListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = initAdapter();
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(initLayoutManager());
        mPresenter = initPresenter();
        mPresenter.refresh(pageSize);
    }

    protected abstract RecyclerAdapter<T> initAdapter();
    protected abstract BaseListContract.IPresenter initPresenter();

    protected RecyclerView.LayoutManager initLayoutManager(){
        return new LinearLayoutManager(getContext());
    }

    protected void initRefreshAdapter(){
        refreshView.setBaseHeaderAdapter();
        refreshView.setBaseFooterAdapter();
    }

    @Override
    public void onRefresh(List<T> data) {
        mAdapter.refresh(data);
    }

    @Override
    public void onAdd(List<T> data) {
        mAdapter.addAll(data);
    }

    @Override
    public void onFooterRefresh(UltimateRefreshView view) {
        mPresenter.add(page,pageSize);
    }

    @Override
    public void onHeaderRefresh(UltimateRefreshView view) {
        mPresenter.refresh(pageSize);
    }
}
