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

import java.util.List;


@SuppressLint("ValidFragment")
public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView, HomeHotRecyAdapter.BouncingComment {
    private MyRecyclerView HomeHot_List;
    private ViewPagerLayoutManager linearLayoutManager;
    private HomeHotRecyAdapter homeHotRecyAdapter;
    private List<HomeHotBean.DataBean> data;
    private String ugcId;
    private AutoLinearLayout group;
    private AutoRelativeLayout home_tablayout;
    private TextView homeText;
    private TextView messageText;
    private TextView myselfText;
    private TextView serializationText;

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
        HomeHot_List.setItemViewCacheSize(1 );
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
    //设置字体颜色
    private void setTextColor() {
        homeText.setTextColor(getResources().getColor(R.color.h9));
        serializationText.setTextColor(getResources().getColor(R.color.h9));
        messageText.setTextColor(getResources().getColor(R.color.h9));
        myselfText.setTextColor(getResources().getColor(R.color.h9));

    }
}
