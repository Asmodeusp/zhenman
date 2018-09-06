package com.zhenman.asus.zhenman.view.home;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.OnViewPagerListener;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;

import java.util.ArrayList;

public class HotFragment extends BaseFragment<HomeHotPresenterImp> implements HomeHotContract.HomeHotView {

    private RecyclerView Home_ListView;
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
        Home_ListView = getActivity().findViewById(R.id.HomeHot_List);
        Home_HotText = getActivity().findViewById(R.id.HomeHot_HotText);
        HomeHot_AttentionText = getActivity().findViewById(R.id.HomeHot_AttentionText);
        Home_search_Img = getActivity().findViewById(R.id.HomeHot_search_Img);
        Home_headView = getActivity().findViewById(R.id.HomeHot_HeadView);

        //ViewPagerLayoutManager layoutManager = new ViewPagerLayoutManager(getContext(),LinearLayoutManager.VERTICAL);
        ViewPagerLayoutManager layoutManager = new ViewPagerLayoutManager(getContext(), LinearLayoutManager.VERTICAL) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            }
        };
        layoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                Log.e("onPageRelease",""+isNext);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {

                if(!isBottom)
                Home_ListView.scrollToPosition(position);
            }
        });
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Home_ListView.setLayoutManager(layoutManager);

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
       ArrayList<HomeHotBean.DataBean>dataBeans =  new ArrayList<>();
        for (HomeHotBean.DataBean dataBean : homeHotBean.getData()) {
            if (dataBean.getPageDtoList().size()>=3) {
                dataBeans.add(dataBean);
            }
        }

        Home_ListView.setAdapter(new HomeHotRecyAdapter(dataBeans));

    }
}
