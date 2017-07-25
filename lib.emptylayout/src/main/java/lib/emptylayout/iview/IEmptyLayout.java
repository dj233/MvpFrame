package lib.emptylayout.iview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashSet;
import java.util.Set;

public abstract class IEmptyLayout extends LinearLayout {
    private static final String TAG = IEmptyLayout.class.getSimpleName();

    private LayoutInflater mInflater;
    private Set<View> childViews;

    private RelativeLayout mEmptyRelativeLayout;
    private ViewGroup mLoadingView;
    private ViewGroup mEmptyView;
    private ViewGroup mErrorView;

    private boolean mViewsAdded;
    private int mEmptyType = Type.Loading;

    public IEmptyLayout(Context context) {
        super(context);
        init();
    }


    public IEmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IEmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        childViews = new HashSet<>();
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initViewLayout();
    }

    public void setEmptyType(int type){
        if(type == Type.Data){
            mEmptyRelativeLayout.setVisibility(View.GONE);
            return;
        }
        mEmptyRelativeLayout.setVisibility(View.VISIBLE);
        mEmptyType = type;
        refreshEmptyType();
    }


    private void refreshEmptyType() {
        // change empty type
        mEmptyView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        View loadingIcon = mLoadingView.findViewById(loadingIconId());
        Animation anim = loadingIcon.getAnimation();
        switch (mEmptyType) {
            case Type.Empty:
                mEmptyView.setVisibility(View.VISIBLE);
                anim.cancel();
                break;
            case Type.Error:
                mErrorView.setVisibility(View.VISIBLE);
                anim.cancel();
                break;
            case Type.Loading:
                mLoadingView.setVisibility(View.VISIBLE);
                loadingIcon.startAnimation(getRotateAnimation());
                break;
            default:
                break;
        }
    }



    private void initViewLayout() {
        if (mEmptyView==null) {
            mEmptyView = (ViewGroup) mInflater.inflate(layoutId(Type.Empty), null);
            initViewLayout(mEmptyView,Type.Empty);
        }
        if (mLoadingView==null) {
            mLoadingView = (ViewGroup) mInflater.inflate(layoutId(Type.Loading), null);
            initViewLayout(mLoadingView,Type.Loading);
        }
        if (mErrorView==null) {
            mErrorView = (ViewGroup) mInflater.inflate(layoutId(Type.Error), null);
            initViewLayout(mErrorView,Type.Error);
        }

        // insert views in the root view
        if (!mViewsAdded) {
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            lp.addRule(RelativeLayout.CENTER_IN_PARENT);
            mEmptyRelativeLayout = new RelativeLayout(getContext());
            mEmptyRelativeLayout.setGravity(Gravity.CENTER);
            mEmptyRelativeLayout.setLayoutParams(lp);
            if (mEmptyView!=null) mEmptyRelativeLayout.addView(mEmptyView);
            if (mLoadingView!=null) mEmptyRelativeLayout.addView(mLoadingView);
            if (mErrorView!=null) mEmptyRelativeLayout.addView(mErrorView);
            mViewsAdded = true;
            mEmptyRelativeLayout.setVisibility(VISIBLE);
            addView(mEmptyRelativeLayout);
        }

        refreshEmptyType();
    }

    private void initViewLayout(View group, final int type){
        View btnView = group.findViewById(btnId(type));
        if(btnVisible(type)){
            btnView.setVisibility(View.VISIBLE);
        }else{
            btnView.setVisibility(View.GONE);
        }
        btnView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnClick(type);
            }
        });

    }

    protected abstract int layoutId(int type);

    protected abstract int loadingIconId();

    protected abstract int btnId(int type);

    protected abstract boolean btnVisible(int type);

    protected abstract void onBtnClick(int type);

    protected abstract Animation getRotateAnimation();

    public interface Type{
        int Empty = 1;
        int Loading = 2;
        int Error = 3;
        int Data = 4;
    }
}
