package market.lib.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sak.ultilviewlib.UltimateRefreshView;
import com.sak.ultilviewlib.interfaces.OnFooterRefreshListener;
import com.sak.ultilviewlib.interfaces.OnHeaderRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import market.lib.R;
import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.presenter.BaseListContract;

public abstract class BaseListActivity<T> extends BaseActivity implements BaseListContract.IView<T>,OnHeaderRefreshListener,
        OnFooterRefreshListener{

    protected UltimateRefreshView refreshView;
    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;
    private BaseListContract.IPresenter mPresenter;

    protected int page = 1;
    protected int pageSize = 30;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void getIntentData(Bundle bundle) {
        super.getIntentData(bundle);
    }

    @Override
    protected void initView() {
        refreshView = (UltimateRefreshView) findViewById(R.id.refresh_view);
        initRefreshAdapter();
        refreshView.setOnHeaderRefreshListener(this);
        refreshView.setOnFooterRefreshListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = initAdapter();
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(initLayoutManager());
        mPresenter = initPresenter();
        mPresenter.refresh(pageSize);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    protected abstract RecyclerAdapter<T> initAdapter();
    protected abstract BaseListContract.IPresenter initPresenter();

    protected RecyclerView.LayoutManager initLayoutManager(){
        return new LinearLayoutManager(this);
    }

    protected void initRefreshAdapter(){
        refreshView.setBaseHeaderAdapter();
        refreshView.setBaseFooterAdapter();
    }

    @Override
    public void onRefresh(List<T> data) {
        mAdapter.refresh(data);
        refreshView.onHeaderRefreshComplete();
    }

    @Override
    public void onAdd(List<T> data) {
        mAdapter.addAll(data);
        refreshView.onFooterRefreshComplete();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onFooterRefresh(UltimateRefreshView view) {
        page ++;
        mPresenter.add(page,pageSize);
    }

    @Override
    public void onHeaderRefresh(UltimateRefreshView view) {
        mPresenter.refresh(pageSize);
    }
}
