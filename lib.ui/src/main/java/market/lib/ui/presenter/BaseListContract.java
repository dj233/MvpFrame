package market.lib.ui.presenter;

import java.util.List;

public class BaseListContract {

    public interface IView<T>{
        void onAdd(List<T> data);
        void onRefresh(List<T> data);
        void onError(Throwable e);
    }

    public interface IPresenter{
        void refresh(int pageSize);
        void add(int page, int pageSize);
    }
}
