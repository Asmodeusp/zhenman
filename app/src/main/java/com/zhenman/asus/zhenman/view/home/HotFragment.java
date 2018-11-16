package com.zhenman.asus.zhenman.view.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.ContentActivity;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;
import com.zhenman.asus.zhenman.view.comment.FullFragment;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.ui.MyRecyclerView;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.OnViewPagerListener;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


@SuppressLint("ValidFragment")
public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView, HomeHotRecyAdapter.BouncingComment {
    private MyRecyclerView HomeHot_List;
    private ViewPagerLayoutManager linearLayoutManager;
    private HomeHotRecyAdapter homeHotRecyAdapter;
    private List<HomeHotBean.DataBean> data =new ArrayList<>();
    private String ugcId;
    private AutoLinearLayout group;
    private AutoRelativeLayout home_tablayout;
    private SmartRefreshLayout HomeHot_SmartRefresh;
    private int pageNumber =1;


    @SuppressLint("ValidFragment")
    public HotFragment(AutoRelativeLayout home_tablayout) {
        super();
        this.home_tablayout = home_tablayout;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        //请求数据
        initView();
        group = ((ContentActivity) getActivity()).getGroup();

    }

    private void initView() {
        HomeHot_List = getActivity().findViewById(R.id.HomeHot_List);
        HomeHot_SmartRefresh = getActivity().findViewById(R.id.HomeHot_SmartRefresh);
        HomeHot_List.setItemViewCacheSize(1 );
        linearLayoutManager = new ViewPagerLayoutManager(getContext(), LinearLayoutManager.VERTICAL) {
        };
         HomeHot_SmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.getHomeHotBean( 1+ "");
                data.clear();
                homeHotRecyAdapter.notifyDataSetChanged();
                refreshLayout.finishRefresh(1000/*,false*/);//传入false表示刷新失败

            }
        });
        HomeHot_SmartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                pageNumber++;
                presenter.getHomeHotBean(pageNumber + "");
                homeHotRecyAdapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore(1000/*,false*/);//传入false表示刷新失败

            }
        });
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

        presenter.getHomeHotBean(pageNumber + "");
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
            if (pageNumber!=1){
                for (HomeHotBean.DataBean dataBean : homeHotBean.getData()) {
                    data.add(dataBean);
                }
                homeHotRecyAdapter.notifyDataSetChanged();
                HomeHot_List.scrollToPosition(data.size()-11);
            }else{
                data.addAll(homeHotBean.getData()) ;
            }
            homeHotRecyAdapter = new HomeHotRecyAdapter(data, HomeHot_List, presenter, group,home_tablayout);
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
    public void showCommentList(CommentListBean commentListBean) {
        FullFragment fullFragment = new FullFragment(commentListBean, Type + "", ugcId);
        fullFragment.show(getActivity().getSupportFragmentManager(), "dialog");
    }

    int Type;

    @Override
    public void getComment(String UgcId, int Type) {
        this.Type = Type;
        this.ugcId = UgcId;
        presenter.getCommentList(ugcId + "", "1", "20", Type + "", "1");
    }

}
