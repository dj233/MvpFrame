package market.lib.ui.presenter;

import java.util.List;

public class BaseListContract {

    public interface IView<T>{
        public void onAdd(List<T> data);
        public void onRefresh(List<T> data);
    }

    public interface IPresenter{
        public void refresh(int pageSize);
        public void add(int page, int pageSize);
    }
}
