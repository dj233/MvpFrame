package market.lib.ui.presenter;

import java.util.List;

public class BaseTabContract {

    public interface IView<T>{
        void onError(Throwable e);
        void onTabLoad(List<T> tabs);
    }

    public interface IPresenter{
        void reqTabs();
    }
}
