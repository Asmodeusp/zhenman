package com.zhenman.asus.zhenman.view.home;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
import com.zhenman.asus.zhenman.view.login.MainActivity;

import butterknife.BindView;

public class AttentionFragment extends BaseFragment<HomeAttentionPresenterImp> implements HomeAttentionContract.HomeAttentionView {
    @BindView(R.id.Home_Attention_Recy)
    RecyclerView HomeAttentionRecy;
    @BindView(R.id.Home_Attention_SmartRefreshLayout)
    SmartRefreshLayout HomeAttentionSmartRefreshLayout;
    @BindView(R.id.Home_Attention_Recy_Tip)
    TextView Home_Attention_Recy_Tip;
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
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            Boolean ISlogin = (Boolean) SPUtils.get(getContext(), SPKey.IS_LOGIN, false);
            if (!ISlogin) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        }
    }
    @Override
    public void showHomeAttentionBean(HomeAttentionBean homeAttentionBean) {
        if (!homeAttentionBean.getMsg().equals("未登陆")) {
            HomeAttentionRecy.setVisibility(View.VISIBLE);
            Home_Attention_Recy_Tip.setVisibility(View.GONE);
            if (homeAttentionBean.getData().getResult()!=null) {
                HomeAttentionRecyAdapter homeAttentionRecyAdapter = new HomeAttentionRecyAdapter(homeAttentionBean.getData().getResult());
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
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }
}
