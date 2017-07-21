package market.lib.ui.presenter;

public abstract class BaseTabPresenter implements BaseTabContract.IPresenter {

    protected BaseTabContract.IView view;

    public BaseTabPresenter(BaseTabContract.IView view) {
        this.view = view;
    }
}
