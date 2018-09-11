package com.zhenman.asus.zhenman.view.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.View;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotVerticalVpAdapter;
import com.zhenman.asus.zhenman.view.ui.MyViewPager;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cn.youngkaaa.yviewpager.YViewPager;

public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView {

    //底部切换页面
    private AutoLinearLayout group;
    //头部视图
    private AutoRelativeLayout home_headView;
    ArrayList<Fragment> fragments = new ArrayList<>();
    private MyViewPager HomeHot_VerticalViewpager;

    public HotFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public HotFragment(AutoLinearLayout group, AutoRelativeLayout home_headView) {
        this.group = group;
        this.home_headView = home_headView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        //请求数据
        presenter.getHomeHotBean(1 + "");
        initView();
    }

    private void initView() {
        HomeHot_VerticalViewpager = getActivity().findViewById(R.id.HomeHot_VerticalViewpager);
    }


    @Override
    protected void loadDate() {

    }


    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showHotBean(HomeHotBean homeHotBean) {
        List<HomeHotBean.DataBean> data = homeHotBean.getData();
        for (int i = 0; i < data.size(); i++) {
            WorksFragment addFragment = new WorksFragment(HomeHot_VerticalViewpager,presenter);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data",data.get(i));
            addFragment.setArguments(bundle);
            fragments.add(addFragment);
        }
        HomeHotVerticalVpAdapter homeHotVerticalVpAdapter = new HomeHotVerticalVpAdapter(fragments, getActivity().getSupportFragmentManager());
        HomeHot_VerticalViewpager.setAdapter(homeHotVerticalVpAdapter);

    }

    @Override
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }


}
