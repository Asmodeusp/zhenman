package com.zhenman.asus.zhenman.view.home;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeAttentionContract;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeAttentionPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.home.HomeAttentionRecyAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AttentionFragment extends BaseFragment<HomeAttentionPresenterImp> implements HomeAttentionContract.HomeAttentionView {
    @BindView(R.id.Home_Attention_Recy)
    RecyclerView HomeAttentionRecy;
    @BindView(R.id.Home_Attention_SmartRefreshLayout)
    SmartRefreshLayout HomeAttentionSmartRefreshLayout;


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
        boolean isLogin = (boolean) SPUtils.get(getActivity(), SPKey.IS_LOGIN, true);
        if (isLogin) {

        }
    }

    @Override
    public void showHomeAttentionBean(HomeAttentionBean homeAttentionBean) {
        HomeAttentionRecyAdapter homeAttentionRecyAdapter = new HomeAttentionRecyAdapter(homeAttentionBean.getData().getResult());
        HomeAttentionRecy.setAdapter(homeAttentionRecyAdapter);

    }

    @Override
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }


}
