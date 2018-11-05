package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ShelfHistoryContract;
import com.zhenman.asus.zhenman.model.bean.ShelfHistoryListBean;
import com.zhenman.asus.zhenman.presenter.ShelfHistoryPresenter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ShelfCollectionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelfHistoryFragment extends BaseFragment<ShelfHistoryPresenter> implements ShelfHistoryContract.ShelfHistoryInView {


    @BindView(R.id.shelfHistory_recy)
    RecyclerView shelfHistoryRecy;
    private ShelfCollectionAdapter shelfCollectionAdapter;
    public ShelfHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shelf_history;
    }

    @Override
    protected void init() {
    presenter.sendShelfHistoryData("1","20");
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showError(String string) {

    }

    @Override
    public void showShelfHistoryData(ShelfHistoryListBean shelfHistoryListBean) {
        if (shelfHistoryListBean.getData().getResult().size()!=0){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            shelfHistoryRecy.setLayoutManager(gridLayoutManager);
            List<Object> list1 = new ArrayList<>();
            List<ShelfHistoryListBean.DataBean.ResultBean> result = shelfHistoryListBean.getData().getResult();
            list1.addAll(result);
            shelfCollectionAdapter = new ShelfCollectionAdapter(list1, getContext());
            shelfHistoryRecy.setAdapter(shelfCollectionAdapter);
        }
    }
}
