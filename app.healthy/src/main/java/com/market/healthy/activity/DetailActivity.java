package com.market.healthy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dao.wrapper.DbMaster;
import com.market.healthy.R;
import com.market.healthy.entity.Detail;
import com.market.healthy.presenter.detail.DetailContract;
import com.market.healthy.presenter.detail.DetailPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import market.lib.ui.activity.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailContract.IView,View.OnClickListener{
    private static final String KV_Info_Id = "Info_Id";
    private static final String KV_Detail_Obj = "Detail_Obj";

    @BindView(R.id.iv_info_detail)
    ImageView ivInfoDetail;
    @BindView(R.id.tv_info_title)
    TextView tvInfoTitle;
    @BindView(R.id.tv_info_description)
    TextView tvInfoDescription;
    WebView wvContent;

    Toolbar toolbar;

    FloatingActionButton fab;

    private String infoId;
    private Detail mDetail;
    private DetailContract.IPresenter presenter;

    @Override
    protected void getIntentData(Bundle bundle) {
        infoId = bundle.getString(KV_Info_Id,null);
        mDetail = (Detail) bundle.getSerializable(KV_Detail_Obj);
    }

    public static void toDetailPage(Context context, String infoId) {
        if(TextUtils.isEmpty(infoId)){
            return;
        }
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KV_Info_Id, infoId);
        context.startActivity(intent);
    }

    public static void toDetailPage(Context context,Detail detail){
        if(detail == null){
            return;
        }
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KV_Detail_Obj, detail);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_newsDetail);
        ivInfoDetail = (ImageView) findViewById(R.id.iv_info_detail);
        tvInfoTitle = (TextView) findViewById(R.id.tv_info_title);
        tvInfoDescription = (TextView) findViewById(R.id.tv_info_description);
        wvContent = (WebView) findViewById(R.id.wv_info_content);
        fab = (FloatingActionButton) findViewById(R.id.fab_add);
        fab.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if(mDetail == null) {
            presenter = new DetailPresenter(this);
            presenter.reqDetail(infoId);
        }else{
            onDataLoad(mDetail);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void onDataLoad(Detail detail) {
        mDetail = detail;
        Glide.with(this).load(detail.getImg()).into(ivInfoDetail);
        toolbar.setTitle(detail.getTitle());
        tvInfoTitle.setText(detail.getTitle());
        tvInfoDescription.setText(detail.getDescription());
        wvContent.getSettings().setDefaultTextEncodingName("UTF-8");
        wvContent.loadData(detail.getMessage(),"text/html; charset=UTF-8",null);
    }

    @OnClick({R.id.tv_info_title, R.id.fab_add})
    public void onViewClicked(View view) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_info_title:
                break;
            case R.id.fab_add:
                boolean isAdd = false;
                try {
                    isAdd = DbMaster.$().detailDao().add(mDetail);
                } catch (Exception e) {
                    Toast.makeText(this, "收藏失败，请重试", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(isAdd) {
                    Toast.makeText(this, "收藏文章：" + mDetail.getTitle(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "已收藏，请到收藏页阅读", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
