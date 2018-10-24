package com.zhenman.asus.zhenman.view.home;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.OnViewPagerListener;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;

import java.util.List;


public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView, HomeHotRecyAdapter.BouncingComment {
    private RecyclerView HomeHot_List;
    private ViewPagerLayoutManager linearLayoutManager;
    private HomeHotRecyAdapter homeHotRecyAdapter;
    private List<HomeHotBean.DataBean> data;


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

        initView();
    }

    private void initView() {
        HomeHot_List = getActivity().findViewById(R.id.HomeHot_List);
        linearLayoutManager = new ViewPagerLayoutManager(getContext(), LinearLayoutManager.VERTICAL) {
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
        presenter.getHomeHotBean(1 + "");
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showHotBean(HomeHotBean homeHotBean) {
        if (homeHotBean.getData().size() != 0) {
            data = homeHotBean.getData();
            homeHotRecyAdapter = new HomeHotRecyAdapter(data, linearLayoutManager, HomeHot_List, presenter);
            HomeHot_List.setAdapter(homeHotRecyAdapter);
            homeHotRecyAdapter.setgoUserInfo(new HomeHotRecyAdapter.goUserInfo() {
                @Override
                public void go(String UserId) {
                    Intent intent = new Intent(getContext(), HomepageActivity.class);
                    intent.putExtra(SPKey.HIM_ID, UserId);
                    getActivity().startActivity(intent);

                }
            });
            homeHotRecyAdapter.setBouncingComment(this);
        }
    }

    @Override
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {
        if (ugcFabulousBean.getMsg().equals("未登录")) {

        }


    }

    @Override
    public void showFollowBean(FollowBean followBean) {

    }

    @Override
    public void getComment(String UgcId,int Type) {

    }
}
