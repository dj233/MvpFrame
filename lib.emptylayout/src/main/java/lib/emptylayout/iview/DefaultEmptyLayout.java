package lib.emptylayout.iview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import lib.emptylayout.R;

public class DefaultEmptyLayout extends IEmptyLayout{

    public DefaultEmptyLayout(Context context) {
        super(context);
    }

    public DefaultEmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DefaultEmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected boolean emptyBtnVisibale(){
        return true;
    }

    protected boolean errorBtnVisible(){
        return false;
    }

    @Override
    public int layoutId(int type) {
        int layoutId = 0;
        switch (type){
            case Type.Empty:
                layoutId = R.layout.view_empty;
                break;
            case Type.Error:
                layoutId = R.layout.view_error;
                break;
            case Type.Loading:
                layoutId = R.layout.view_loading;
                break;
        }
        return layoutId;
    }

    @Override
    public int loadingIconId() {
        return R.id.iv_loading_icon;
    }


    @Override
    public int btnId(int type) {
        int viewId = 0;
        switch (type){
            case Type.Empty:
                viewId = R.id.btn_empty;
                break;
            case Type.Error:
                viewId = R.id.btn_error;
                break;
            case Type.Loading:
                viewId = R.id.btn_loading;
                break;
        }
        return viewId;
    }

    @Override
    public boolean btnVisible(int type) {
        boolean btnVisible = false;
        switch (type){
            case Type.Empty:
                btnVisible = emptyBtnVisibale();
                break;
            case Type.Error:
                btnVisible = errorBtnVisible();
                break;
            case Type.Loading:
                btnVisible = true;
                break;
        }
        return btnVisible;
    }

    @Override
    public void onBtnClick(int type) {
        if(!btnVisible(type)){
            return;
        }
        switch (type){
            case Type.Empty:
                onEmptyBtnClick();
                break;
            case Type.Error:
                onErrorBtnClick();
                break;
            case Type.Loading:
                onLoadingBtnClick();
                break;
        }
    }

    protected void onEmptyBtnClick(){

    }

    protected void onErrorBtnClick(){

    }

    protected void onLoadingBtnClick(){

    }

    @Override
    public Animation getRotateAnimation() {
        return getDefaultRotateAnimation();
    }

    private Animation getDefaultRotateAnimation() {
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        rotateAnimation.setDuration(800);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        return rotateAnimation;
    }
}
