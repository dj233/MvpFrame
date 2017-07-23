package market.lib.ui.presenter;

public abstract class BaseSearchListPresenter implements BaseSearchListContract.IPresenter {

    protected BaseSearchListContract.IView view;

    public BaseSearchListPresenter(BaseSearchListContract.IView view) {
        this.view = view;
    }
}
