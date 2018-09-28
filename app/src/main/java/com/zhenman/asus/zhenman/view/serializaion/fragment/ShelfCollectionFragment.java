package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ShelfCollectionContract;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.presenter.ShelfCollectionPresenter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ShelfCollectionAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelfCollectionFragment extends BaseFragment<ShelfCollectionPresenter> implements ShelfCollectionContract.ShelfCollectionInView {


    private RecyclerView shelfColl_recy;

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
        presenter.sendShelfCollectionData("1", "20");
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void showShelfCollection(ShelfCollectionBean shelfCollectionBean) {
        if (shelfCollectionBean.getState() == 0) {
            Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
            List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList = shelfCollectionBean.getData().getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            shelfColl_recy.setLayoutManager(gridLayoutManager);
            ShelfCollectionAdapter shelfCollectionAdapter = new ShelfCollectionAdapter(resultBeanList, getContext());
            shelfColl_recy.setAdapter(shelfCollectionAdapter);
            Log.e("Sunny",shelfCollectionBean.getData().getResult().size()+"");
        } else {
            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {

    }
}
