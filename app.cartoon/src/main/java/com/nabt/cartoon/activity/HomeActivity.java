package com.nabt.cartoon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nabt.cartoon.R;
import com.nabt.cartoon.fragment.FaviorFragment;
import com.nabt.cartoon.fragment.SearchFragment;
import com.nabt.cartoon.fragment.TabTypeFragment;

import lib.utils.AppUtils;
import lib.utils.IntentUtils;

public class HomeActivity extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private Fragment[] fragments;
    private int fragIndex;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.menu_home));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View naviHeadLayout = navigationView.getHeaderView(0);
        ImageView ivNavHead = naviHeadLayout.findViewById(R.id.iv_nav_head);
        Glide.with(this).load("http://www.hqlednews.com/file/Images/upload/2015-09-09/1e584238-4d65-4c9c-8e50-6b37ea67271b.gif").into(ivNavHead);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragments();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            navigation.setSelectedItemId(R.id.navigation_home);
        } else if (id == R.id.nav_favior) {
            navigation.setSelectedItemId(R.id.navigation_favior);
        } else if (id == R.id.nav_update) {
            IntentUtils.launchThisAppTencent(this);
        } else if (id == R.id.nav_share) {
            IntentUtils.shareImager(this,R.drawable.zxing_code,getString(R.string.app_intro_short));
        } else if (id == R.id.nav_about) {
            Toast.makeText(this, AppUtils.getLocalVersionName(this),Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle(getString(R.string.menu_home));
                    switchFragment(0);
                    return true;
                case R.id.navigation_search:
                    toolbar.setTitle(getString(R.string.menu_search));
                    switchFragment(1);
                    return true;
                case R.id.navigation_favior:
                    toolbar.setTitle(getString(R.string.menu_save));
                    switchFragment(2);
                    return true;
            }
            return false;
        }

    };

    protected Fragment[] getFragments(){
        return new Fragment[]{new TabTypeFragment(),new SearchFragment(),new FaviorFragment()};
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
}
