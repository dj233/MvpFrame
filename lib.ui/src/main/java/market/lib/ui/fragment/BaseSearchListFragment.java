package market.lib.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sak.ultilviewlib.UltimateRefreshView;
import com.sak.ultilviewlib.interfaces.OnFooterRefreshListener;
import com.sak.ultilviewlib.interfaces.OnHeaderRefreshListener;

import java.util.List;

import market.lib.R;
import market.lib.ui.adapter.RecyclerAdapter;
import market.lib.ui.presenter.BaseSearchListContract;


public abstract class BaseSearchListFragment<T> extends Fragment implements View.OnClickListener, BaseSearchListContract.IView<T>,OnHeaderRefreshListener,
        OnFooterRefreshListener{

    protected UltimateRefreshView refreshView;
    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;
    private EditText etSearch;
    private TextView tvSearch;

    private BaseSearchListContract.IPresenter mPresenter;

    protected int page = 1;
    protected int pageSize = 30;
    private String keyword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_search,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getIntentValue(getArguments());
        overrideParentValue();
        tvSearch = view.findViewById(R.id.tv_search);
        tvSearch.setOnClickListener(this);
        etSearch = view.findViewById(R.id.et_search);
        refreshView = (UltimateRefreshView) view.findViewById(R.id.refresh_view);
        initRefreshAdapter();
        refreshView.setOnHeaderRefreshListener(this);
        refreshView.setOnFooterRefreshListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = initAdapter();
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(initLayoutManager());
        mPresenter = initPresenter();
    }

    protected void overrideParentValue(){
//        page = 1;
//        pageSize = 30;
    }

    protected abstract void getIntentValue(Bundle bundle);
    protected abstract RecyclerAdapter<T> initAdapter();
    protected abstract BaseSearchListContract.IPresenter initPresenter();

    protected RecyclerView.LayoutManager initLayoutManager(){
        return new LinearLayoutManager(getContext());
    }

    protected void initRefreshAdapter(){
//        refreshView.setBaseHeaderAdapter();
        refreshView.setBaseFooterAdapter();
    }

    @Override
    public void onRefresh(List<T> data) {
//        setState(LoadedResult.SUCCESS);
        mAdapter.refresh(data);
        refreshView.onHeaderRefreshComplete();
    }

    @Override
    public void onAdd(List<T> data) {
//        setState(LoadedResult.SUCCESS);
        mAdapter.addAll(data);
        refreshView.onFooterRefreshComplete();
    }

    @Override
    public void onError(Throwable e) {
//        setState(LoadedResult.ERROR);
    }

    @Override
    public void onFooterRefresh(UltimateRefreshView view) {
        page ++;
        mPresenter.add(keyword,page,pageSize);
    }

    @Override
    public void onHeaderRefresh(UltimateRefreshView view) {
        mPresenter.refresh(keyword,pageSize);
    }
//
//    @Override
//    public void onRetryClick() {
//        super.onRetryClick();
//        setState(LoadedResult.LOADING);
//        if(page == 0){
//            mPresenter.refresh(pageSize);
//        }else{
//            mPresenter.add(page,pageSize);
//        }
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.fragment_list;
//    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.tv_search){
            String keywords = etSearch.getText().toString();
            mPresenter.refresh(keywords,pageSize);
        }
    }

}
