package market.lib.ui.presenter;

import java.util.List;

public class BaseSearchListContract {

    public interface IView<T>{
        void onAdd(List<T> data);
        void onRefresh(List<T> data);
        void onError(Throwable e);
    }

    public interface IPresenter{
        void refresh(String keyword,int pageSize);
        void add(String keyword,int page, int pageSize);
    }
}
