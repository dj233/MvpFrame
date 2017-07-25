package com.nabt.cook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.nabt.cook.fragment.TabPagerFragment;

public class CookActivity extends AppCompatActivity {

    private Fragment[] fragments;
    private int fragIndex;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navi_home:
                    switchFragment(0);
                    return true;
                case R.id.navi_search:
                    switchFragment(1);
                    return true;
                case R.id.navi_save:
                    switchFragment(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        initView();
    }

    private void initView(){
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragments();
    }

    private void switchFragment(int index){
        if(index == fragIndex){
            return;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!fragments[index].isAdded()){
            transaction.add(R.id.container,fragments[index]);
        }
        transaction.hide(fragments[fragIndex]);
        transaction.show(fragments[index]).commit();
        fragIndex = index;
    }

    private void initFragments(){
        fragments = getFragments();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container,fragments[0])
                .show(fragments[0])
                .commit();
        fragIndex = 0;
    }

    protected Fragment[] getFragments(){
        return new Fragment[]{new TabPagerFragment(),new TabPagerFragment(),new TabPagerFragment()};
    }

}
