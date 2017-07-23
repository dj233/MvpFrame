package market.lib.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import market.lib.R;

public abstract class BaseFragment extends Fragment {

    protected Activity activity;
    protected AppCompatActivity appCompatActivity;
    protected FrameLayout mEmptyRootView;

    public static final int STATE_LOADING                   = 0;
    public static final int STATE_SUCCESS                   = 1;
    public static final int STATE_EMPTY                     = 2;
    public static final int STATE_ERROR                     = 3;
    public static final int STATE_UNCONNECT_ERROR_FAKE_DATA = 4;
    public static final int STATE_CONNECT_ERROR_FAKE_DATA   = 5;
    public              int mCurState                       = STATE_LOADING;

    public View         mLoadingView;//加载中视图
    public View         mEmptyView;//空视图
    public View         mErrorView;//错误视图
    public View mSuccessView;//成功视图

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empty, container, false);
        mEmptyRootView = (FrameLayout) view.findViewById(R.id.emptyRootView);
        activity = getActivity();
        initRootView();
        return view;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.popshow_anim, R.anim.pophide_anim_static);
    }

    private void initRootView() {
        mSuccessView = View.inflate(getContext(), getLayoutId(), null);
        ButterKnife.bind(this, mSuccessView);
        mEmptyRootView.addView(mSuccessView);
//        initCommonView();
    }

    public abstract int getLayoutId();

    /**
     * @des 初始化3个常规视图(静态视图)
     */
    private void initCommonView() {
        //初始化Loading视图
        mLoadingView = getLoadingView();
        mEmptyRootView.addView(mLoadingView);

        //初始化Empty视图
        mEmptyView = getEmptyView();
        mEmptyRootView.addView(mEmptyView);

        //初始化Error视图
        mErrorView = getErrorView();
        mEmptyRootView.addView(mErrorView);
        mErrorView.findViewById(R.id.error_btn_retry).setOnClickListener(new View.OnClickListener
                () {
            @Override
            public void onClick(View v) {
                //重新的触发加载数据
                onRetryClick();
            }
        });

        TextView retry = (TextView) mErrorView.findViewById(R.id.error_btn_retry);
        retry.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新的触发加载数据
                onRetryClick();
            }
        });


        refreshViewByState();
    }

    public void onRetryClick(){
        setState(LoadedResult.LOADING);
    }

    public void setState(LoadedResult loadedResult) {
        mCurState = loadedResult.state;
        //根据当前的状态刷新样式
        refreshViewByState();
    }

    private void refreshViewByState() {

        //数据加载完成,假如数据加载又成功了,而且没有初始化过成功视图
        if (mCurState == STATE_SUCCESS) {
            mSuccessView.setVisibility(View.VISIBLE);
//            mEmptyView.setVisibility(View.GONE);
            mLoadingView.setVisibility(View.GONE);
            mSuccessView.setVisibility(View.GONE);
        } else {
            mSuccessView.setVisibility(View.GONE);
        }

        //控制Error视图的显示隐藏
        if (mCurState == STATE_ERROR) {
            mErrorView.setVisibility(View.VISIBLE);
            mEmptyView.setVisibility(View.GONE);
            mLoadingView.setVisibility(View.GONE);
            mSuccessView.setVisibility(View.GONE);
        } else {
            mErrorView.setVisibility(View.GONE);
        }
        //控制Loading视图的显示隐藏
        if (mCurState == STATE_LOADING) {
            mErrorView.setVisibility(View.GONE);
            mLoadingView.setVisibility(View.VISIBLE);
            mEmptyView.setVisibility(View.GONE);
            mSuccessView.setVisibility(View.GONE);
        } else {
            mLoadingView.setVisibility(View.GONE);
        }

        //控制Empty视图的显示隐藏
        if (mCurState == STATE_EMPTY) {
            mEmptyView.setVisibility(View.VISIBLE);
            mErrorView.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.GONE);
            mSuccessView.setVisibility(View.GONE);
        } else {
            mEmptyView.setVisibility(View.GONE);
        }




    }

    protected View getLoadingView() {
        return View.inflate(activity, R.layout.pager_loading, null);
    }

    protected View getErrorView() {
        return View.inflate(activity, R.layout.pager_error, null);
    }

    protected View getEmptyView() {
        return View.inflate(activity, R.layout.pager_empty, null);
    }

    public enum LoadedResult {
        SUCCESS(STATE_SUCCESS), ERROR(STATE_ERROR), EMPTY(STATE_EMPTY), LOADING(STATE_LOADING),
        CONNECT(STATE_CONNECT_ERROR_FAKE_DATA), UNCONNECT(STATE_UNCONNECT_ERROR_FAKE_DATA);
        int state;

        public int getState() {
            return state;
        }

        LoadedResult(int state) {
            this.state = state;
        }
    }

    protected Handler mHandler = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            dispatchMessage(msg);
        }
    };

    protected void dispatchHandlerMsg(Message msg){

    }

    protected void gone(View... views) {
        for (View v : views) {
            v.setVisibility(View.GONE);
        }
    }

    protected void visiable(View... views) {
        for (View v : views) {
            v.setVisibility(View.VISIBLE);
        }
    }

}
