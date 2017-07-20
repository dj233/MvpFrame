package market.lib.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentData(getIntent().getExtras());
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract int getLayoutId();

    protected void getIntentData(Bundle bundle){

    }

    protected void initView(){

    }

    protected void initData(){

    }

    protected void gone(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    protected void visible(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    protected void unCheck(CheckBox... views) {
        for (CheckBox cb : views) {
            cb.setChecked(false);
        }
    }

    protected void check(CheckBox... views) {
        for (CheckBox cb : views) {
            cb.setChecked(true);
        }
    }

    protected void goTo(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
