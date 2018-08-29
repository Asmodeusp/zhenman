package com.zhenman.asus.zhenman.view.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotVpAdapter;

import java.util.ArrayList;
import cn.youngkaaa.yviewpager.YViewPager;

public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView {


    ArrayList<HomeHotBean.DataBean> mlist = new ArrayList<>();
    private YViewPager Home_ListView;
    private View headview;
    private ImageView Home_search_Img;
    private RelativeLayout Home_headView;
    private TextView Home_HotText;
    private TextView HomeHot_AttentionText;

    ArrayList<Fragment> fragments = new ArrayList<>();

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
        presenter.getHomeHotBean("1");
        Home_ListView = getActivity().findViewById(R.id.HomeHot_List);
        Home_HotText = getActivity().findViewById(R.id.HomeHot_HotText);
        HomeHot_AttentionText = getActivity().findViewById(R.id.HomeHot_AttentionText);
        Home_search_Img = getActivity().findViewById(R.id.HomeHot_search_Img);
        Home_headView = getActivity().findViewById(R.id.HomeHot_HeadView);


        initListView();
    }

    private void initListView() {

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
        for (HomeHotBean.DataBean dataBean : homeHotBean.getData()) {
            HomeItemFragment homeItemFragment = new HomeItemFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("HotItem",dataBean);
            homeItemFragment.setArguments(bundle);
            fragments.add(homeItemFragment);

        }
        HomeHotVpAdapter homeHotVpAdapter = new HomeHotVpAdapter(getActivity().getSupportFragmentManager(), fragments);
        Home_ListView.setAdapter(homeHotVpAdapter);
        homeHotVpAdapter.notifyDataSetChanged();
    }
}
