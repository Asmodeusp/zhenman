package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ShelfCollectionContract;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.presenter.ShelfCollectionPresenter;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.ShelfCollectionAdapter;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelfCollectionFragment extends BaseFragment<ShelfCollectionPresenter> implements ShelfCollectionContract.ShelfCollectionInView {


    private RecyclerView shelfColl_recy;
    private SmartRefreshLayout shelfColl_SmartRefreshLayout;

    public ShelfCollectionFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collection;
    }

    @Override
    protected void init() {
        shelfColl_recy = getActivity().findViewById(R.id.shelfColl_recy);
        shelfColl_SmartRefreshLayout = getActivity().findViewById(R.id.shelfColl_SmartRefreshLayout);
        shelfColl_SmartRefreshLayout = getActivity().findViewById(R.id.shelfColl_SmartRefreshLayout);
        shelfColl_SmartRefreshLayout.autoRefresh(2000);
        shelfColl_SmartRefreshLayout.finishRefresh();
        shelfColl_SmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.sendShelfCollectionData("1", "20");
                shelfColl_SmartRefreshLayout.finishRefresh();
            }
        });
//        presenter.sendShelfCollectionData("1", "20");
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void showShelfCollection(final ShelfCollectionBean shelfCollectionBean) {
        if (shelfCollectionBean.getState() == 0) {
            Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
            List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList = shelfCollectionBean.getData().getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            shelfColl_recy.setLayoutManager(gridLayoutManager);
            final ShelfCollectionAdapter shelfCollectionAdapter = new ShelfCollectionAdapter(resultBeanList, getContext());
            shelfColl_recy.setAdapter(shelfCollectionAdapter);
            shelfCollectionAdapter.setOnShortCLickListener(new ShelfCollectionAdapter.OnShortCLickListener() {
                @Override
                public void myClick(View view, int position) {
                    int pgcId = shelfCollectionBean.getData().getResult().get(position).getPgcId();
                    SPUtils.put(getContext(), "pgcid", pgcId + "");
                    Intent intent = new Intent(getActivity(), WorkDetailsActivity.class);
                    intent.putExtra("pgcid", pgcId);
                    getActivity().startActivity(intent);
                }
            });
        } else {
            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {

    }
}
