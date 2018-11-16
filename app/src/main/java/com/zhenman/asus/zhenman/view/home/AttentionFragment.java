package com.zhenman.asus.zhenman.view.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeAttentionContract;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeAttentionPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.ContentActivity;
import com.zhenman.asus.zhenman.view.adapter.home.HomeAttentionRecyAdapter;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class AttentionFragment extends BaseFragment<HomeAttentionPresenterImp> implements HomeAttentionContract.HomeAttentionView {
    @BindView(R.id.Home_Attention_Recy)
    RecyclerView HomeAttentionRecy;
    @BindView(R.id.Home_Attention_SmartRefreshLayout)
    SmartRefreshLayout HomeAttentionSmartRefreshLayout;
    @BindView(R.id.Home_Attention_Recy_Tip)
    TextView Home_Attention_Recy_Tip;
    private TextView homeText;
    private TextView messageText;
    private TextView myselfText;
    private TextView serializationText;
    public AttentionFragment() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_attention;
    }
    @Override
    protected void init() {
        //设置RecyclerView的格式
        HomeAttentionRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        HomeAttentionSmartRefreshLayout.autoRefresh(2000);
        HomeAttentionSmartRefreshLayout.finishRefresh();
        HomeAttentionSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.getHomeAttentionBean("1");
                HomeAttentionSmartRefreshLayout.finishRefresh();
            }
        });
        homeText = ((ContentActivity) getActivity()).getHomeText();
        messageText = ((ContentActivity) getActivity()).getMessageText();
        myselfText = ((ContentActivity) getActivity()).getMyselfText();
        serializationText = ((ContentActivity) getActivity()).getSerializationText();
    }
    @Override
    protected void loadDate() {
        HomeAttentionSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.getHomeAttentionBean("1");
                HomeAttentionSmartRefreshLayout.finishRefresh();
            }
        });
    }
    @Override
    public void showError(String msg) {
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            Boolean ISlogin = (Boolean) SPUtils.get(getContext(), SPKey.IS_LOGIN, false);
            setTextColor("#000000");
            if (!ISlogin) {
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        }
    }
    @Override
    public void showHomeAttentionBean(HomeAttentionBean homeAttentionBean) {
        if (!homeAttentionBean.getMsg().equals("未登陆")) { 
            HomeAttentionRecy.setVisibility(View.VISIBLE);
            Home_Attention_Recy_Tip.setVisibility(View.GONE);
            if (homeAttentionBean.getData().getResult()!=null) {
                HomeAttentionRecyAdapter homeAttentionRecyAdapter = new HomeAttentionRecyAdapter(homeAttentionBean.getData().getResult(),presenter);
                HomeAttentionRecy.setAdapter(homeAttentionRecyAdapter);
                homeAttentionRecyAdapter.setClickShow(new HomeAttentionRecyAdapter.ClickShow() {
                    @Override
                    public void show(HomeAttentionBean.DataBean.ResultBean resultBean) {
                        Intent intent = new Intent(getActivity(), ShowPhotoActivity.class);
                        intent.putExtra("ResultBean",resultBean);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.activity_open,R.anim.activity_close);
                    }
                });
            }
            if (homeAttentionBean.getData().getResult().size()==0) {
                HomeAttentionRecy.setVisibility(View.GONE);
                Home_Attention_Recy_Tip.setVisibility(View.VISIBLE);
            }
        }



    }

    @Override
    public void showUgcFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }


    @Override
    public void showPgcCollectionBean(PgcCollectionBean pgcCollectionBean) {

    }

    @Override
    public void showAttentionTheme(ThemeAttentionBean themeAttentionBean) {

    }
    //设置字体颜色
    private void setTextColor(String color) {

        homeText.setTextColor(Color.parseColor(color));
        serializationText.setTextColor(Color.parseColor(color));
        messageText.setTextColor(Color.parseColor(color));
        myselfText.setTextColor(Color.parseColor(color));

    }
}
