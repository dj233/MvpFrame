package market.lib.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public abstract class TabPageAdapter<T> extends FragmentPagerAdapter {

    private List<T> mDataList;

    public TabPageAdapter(FragmentManager fm, List<T> dataList) {
        super(fm);
        this.mDataList = dataList;
    }

    @Override
    public Fragment getItem(int position) {
        return buildPage(position,mDataList.get(position));
    }

    protected abstract Fragment buildPage(int pos,T item);
    protected abstract String getTabName(int pos,T item);

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        T item = mDataList.get(position);
        return getTabName(position,item);
    }
}
