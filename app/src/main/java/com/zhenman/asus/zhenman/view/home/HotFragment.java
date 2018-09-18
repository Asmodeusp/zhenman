package com.zhenman.asus.zhenman.view.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.ui.NotifyDataSetChangedForRv;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.OnViewPagerListener;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;


public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView, NotifyDataSetChangedForRv {
    private RecyclerView HomeHot_List;
    private ViewPagerLayoutManager linearLayoutManager;
    private HomeHotRecyAdapter homeHotRecyAdapter;
    //底部切换页面
    private AutoLinearLayout group;
    //头部视图
    private AutoRelativeLayout home_headView;


    public HotFragment() {
        super();
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
        HomeHot_List = getActivity().findViewById(R.id.HomeHot_List);
        linearLayoutManager = new ViewPagerLayoutManager(getContext(), LinearLayoutManager.VERTICAL) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ScreenUtils.getScreenHeight(getActivity()));
            }
        };
        linearLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext, int position) {

            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {


            }
        });
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HomeHot_List.setLayoutManager(linearLayoutManager);
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

    ArrayList<HomeHotBean.DataBean> dataBeans;

    @Override
    public void showHotBean(HomeHotBean homeHotBean) {
        dataBeans = new ArrayList<>();

        homeHotRecyAdapter = new HomeHotRecyAdapter(dataBeans, linearLayoutManager, HomeHot_List, this);
        HomeHot_List.setAdapter(homeHotRecyAdapter);


    }

    @Override
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }

    @Override
    public void notifyDataSetChanged(final int pos, final boolean isTop) {

        if (null == homeHotRecyAdapter) {
            return;
        }

        //linearLayoutManager.setScrollEnabled(true);

        //myLayoutMessage.setScrollEnabled(false);
        //homeHotRecyAdapter.notifyDataSetChanged();

        if (pos != -1 && pos < dataBeans.size()) {
            if (isTop) {
//                linearLayoutManager.setScrollEnabled(true);
                HomeHot_List.scrollToPosition(pos - 1);
                linearLayoutManager.scrollToPositionWithOffset(pos - 1, 0);
            } else {
                linearLayoutManager.setScrollEnabled(false);
                HomeHot_List.scrollToPosition(pos + 1);
                linearLayoutManager.scrollToPositionWithOffset(pos + 1, 0);
            }

        }

//        new Handler().post(new Runnable() {
//            @Override
//            public void run() {
//                // 刷新操作
//                linearLayoutManager.setScrollEnabled(true);
//
//                //myLayoutMessage.setScrollEnabled(false);
//                //homeHotRecyAdapter.notifyDataSetChanged();
//
//                if (pos != -1 && pos < dataBeans.size()) {
//                    HomeHot_List.scrollToPosition(pos + 1);
//                    LinearLayoutManager mLayoutManager =
//                            (LinearLayoutManager) HomeHot_List.getLayoutManager();
//                    mLayoutManager.scrollToPositionWithOffset(pos+1, 0);
//                }
//
//
//            }
//        });


    }

}
