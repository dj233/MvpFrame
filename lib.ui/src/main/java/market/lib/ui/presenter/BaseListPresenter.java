package market.lib.ui.presenter;

public abstract class BaseListPresenter implements BaseListContract.IPresenter {

    protected BaseListContract.IView view;

    public BaseListPresenter(BaseListContract.IView view) {
        this.view = view;
    }
}
