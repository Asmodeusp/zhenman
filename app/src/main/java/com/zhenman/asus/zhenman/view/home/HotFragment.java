package com.zhenman.asus.zhenman.view.home;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.layoutmessage.ViewPagerLayoutManager;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.HomeHotAdapter;

import java.util.ArrayList;

public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView {


    ArrayList<HomeHotBean.DataBean> mlist = new ArrayList<>();
    private RecyclerView Home_ListView;
    private View headview;
    private ImageView Home_search_Img;
    private RelativeLayout Home_headView;
    private TextView Home_HotText;
    private TextView Home_FollowText;
    private HomeHotAdapter homeHotAdapter;

    public HotFragment() {

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
        Home_ListView = getActivity().findViewById(R.id.Home_List);
        Home_HotText = getActivity().findViewById(R.id.Home_HotText);
        Home_FollowText = getActivity().findViewById(R.id.Home_FollowText);
        Home_search_Img = getActivity().findViewById(R.id.Home_search_Img);
        Home_headView = getActivity().findViewById(R.id.Home_headView);

        presenter.getHomeHotBean("1");
        initListView();
    }

    private void initListView() {
        ViewPagerLayoutManager viewPagerLayoutManager = new ViewPagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
        Home_ListView.setLayoutManager(viewPagerLayoutManager);
        homeHotAdapter = new HomeHotAdapter(mlist);

//        viewPagerLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
//            @Override
//            public void onInitComplete() {
//            }
//            @Override
//            public void onPageRelease(boolean isNext, int position) {
//                if (isNext) {
//                }
//            }
//            @Override
//            public void onPageSelected(int position, boolean isBottom) {
//            }
//        });
        Home_ListView.setAdapter(homeHotAdapter);
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
        if (homeHotBean==null) {
            Toast.makeText(getActivity(), "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        }else {
            mlist.addAll(homeHotBean.getData());
            homeHotAdapter.notifyDataSetChanged();
        }
    }
}
