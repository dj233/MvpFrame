package com.nbt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.baidu.mobads.InterstitialAd;
import com.nbt.fragment.JokePicFragment;
import com.nbt.fragment.JokeTxtFragment;
import com.nbt.fragment.RandPicFragment;
import com.nbt.uitls.SpfUtils;
import com.qq.e.ads.interstitial.AbstractInterstitialADListener;
import com.qq.e.ads.interstitial.InterstitialAD;

public class HomeActivity extends FragmentActivity {

    private Fragment[] fragments;
    private int fragIndex;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(0);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(1);
                    return true;
                case R.id.navigation_notifications:
                    switchFragment(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showAd();
        initView();
    }

    private void initView(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
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
        return new Fragment[]{new RandPicFragment(),new JokePicFragment(),new JokeTxtFragment()};
    }



    InterstitialAD iad;
    private void showGDT(){
        getIAD().setADListener(new AbstractInterstitialADListener() {

            @Override
            public void onNoAD(int arg0) {
                Log.i("AD_DEMO", "LoadInterstitialAd Fail:" + arg0);
            }

            @Override
            public void onADReceive() {
                Log.i("AD_DEMO", "onADReceive");
                iad.show();
            }
        });
        iad.loadAD();
    }

    private InterstitialAD getIAD() {
        if (iad == null) {
            iad = new InterstitialAD(this, "1106126460", "4010323213762744");
        }
        return iad;
    }

    com.baidu.mobads.InterstitialAd interAd = null;
    private void showDuIn() {
        // 默认请求http广告，若需要请求https广告，请设置AdSettings.setSupportHttps为true
        // AdSettings.setSupportHttps(true);

        if (interAd == null) {
            String adPlaceId = "4139997"; // 重要：请填上您的广告位ID，代码位错误会导致无法请求到广告
            interAd = new com.baidu.mobads.InterstitialAd(this, adPlaceId);
            interAd.setListener(new com.baidu.mobads.InterstitialAdListener() {

                @Override
                public void onAdClick(InterstitialAd arg0) {
                    Log.i("InterstitialAd", "onAdClick");
                }

                @Override
                public void onAdDismissed() {
                    Log.i("InterstitialAd", "onAdDismissed");
                }

                @Override
                public void onAdFailed(String arg0) {
                    Log.i("InterstitialAd", "onAdFailed:" + arg0);
                }

                @Override
                public void onAdPresent() {
                    Log.i("InterstitialAd", "onAdPresent");
                }

                @Override
                public void onAdReady() {
                    Log.i("InterstitialAd", "onAdReady");
                    interAd.showAd(HomeActivity.this);
                }

            });
        }
        interAd.loadAd();

    }


    private void showAd(){
        boolean duTurn = SpfUtils.isDuTurn(this);
        if(duTurn){
            showDuIn();
        }else{
            showGDT();
        }
        SpfUtils.markDuTurn(this,!duTurn);

    }



}
