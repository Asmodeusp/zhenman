package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ShelfCollectionContract;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.presenter.ShelfCollectionPresenter;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.ShelfCollectionAdapter;
import com.zhenman.asus.zhenman.view.serializaion.BookshelfActivity;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelfCollectionFragment extends BaseFragment<ShelfCollectionPresenter> implements ShelfCollectionContract.ShelfCollectionInView, View.OnClickListener {


    private RecyclerView shelfColl_recy;
    private SmartRefreshLayout shelfColl_SmartRefreshLayout;
    private CheckBox shelfCollect_selectAll;
    private TextView shelfCollect_Delete;
    private AutoLinearLayout shelf_foot;
    private ShelfCollectionAdapter shelfCollectionAdapter;
    private List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList;

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
        shelfCollect_selectAll = getActivity().findViewById(R.id.shelfCollect_selectAll);
        shelfCollect_Delete = getActivity().findViewById(R.id.shelfCollect_Delete);
        shelf_foot = getActivity().findViewById(R.id.shelf_foot);
        shelfColl_SmartRefreshLayout.autoRefresh(2000);
        shelfColl_SmartRefreshLayout.finishRefresh();
        shelfColl_SmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.sendShelfCollectionData("1", "20");
                shelfColl_SmartRefreshLayout.finishRefresh();
            }
        });
        idListener();
//        presenter.sendShelfCollectionData("1", "20");
    }

    private void idListener() {
        shelfCollect_selectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (shelfCollect_selectAll.isChecked()) {
                    setCheck(shelfCollectionAdapter, false, resultBeanList);
                    shelfCollect_selectAll.setText("取消全选");
                } else {
                    setCheck(shelfCollectionAdapter, true, resultBeanList);
                    shelfCollect_selectAll.setText("全选");

                }
            }
        });
        BookshelfActivity.app_otherID.setOnClickListener(this);
        shelfCollect_Delete.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void showShelfCollection(final ShelfCollectionBean shelfCollectionBean) {
        if (shelfCollectionBean.getState() == 0) {
            Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
            resultBeanList = shelfCollectionBean.getData().getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            shelfColl_recy.setLayoutManager(gridLayoutManager);
            shelfCollectionAdapter = new ShelfCollectionAdapter(resultBeanList, getContext());
            shelfColl_recy.setAdapter(shelfCollectionAdapter);
            shelfCollectionAdapter.setOnShortCLickListener(new ShelfCollectionAdapter.OnShortCLickListener() {
                @Override
                public void myClick(View view, int position) {
                    if (ShelfCollectionAdapter.isDisplay.equals("显示")) {
//                        如果蒙板再的话就设置
                        shelfCollectionAdapter.setupAllChecked(position);
                    } else {
                        int pgcId = shelfCollectionBean.getData().getResult().get(position).getPgcId();
                        SPUtils.put(getContext(), "pgcid", pgcId + "");
                        Intent intent = new Intent(getActivity(), WorkDetailsActivity.class);
                        intent.putExtra("pgcid", pgcId);
                        getActivity().startActivity(intent);
//                    短按的时候隐藏底部布局
                        shelf_foot.setVisibility(View.GONE);
                    }
                }
            });
//            长按监听
            shelfCollectionAdapter.setOnLongListener(new ShelfCollectionAdapter.OnLongCLickListener() {
                @Override
                public void myLongClick(View view, int position) {
//                    显示底部布局
                    shelf_foot.setVisibility(View.VISIBLE);
//                    取消按钮显示
                    BookshelfActivity.app_otherID.setVisibility(View.VISIBLE);
                    BookshelfActivity.app_otherID.setText("取消");
//                    BookshelfActivity.app_otherID.setTextColor(Color.parseColor("b37feb"));
//                    显示蒙板
                    noto(shelfCollectionAdapter, true, resultBeanList);
//                    不全选
                    setCheck(shelfCollectionAdapter, false, resultBeanList);

                    int pgcId = shelfCollectionBean.getData().getResult().get(position).getPgcId();
                    SPUtils.put(getContext(), "pgcid", pgcId + "");
                    Intent intent = new Intent(getActivity(), WorkDetailsActivity.class);

                    startActivity(intent);


                }
            });
        } else {
            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }

    }

    //    设置蒙板显示
    private void noto(ShelfCollectionAdapter adapter, boolean ischeck, List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList) {

        for (int i = 0; i < resultBeanList.size(); i++) {
            ShelfCollectionBean.DataBean.ResultBean resultBean = resultBeanList.get(i);
            resultBean.setDisplay(ischeck);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String string) {

    }
//    批量删除
    @Override
    public void showDeleteCollection(VerificationCodeBean verificationCodeBean) {
            presenter.sendShelfCollectionData("1","20");
        shelfCollectionAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_otherID:
                //  隐藏蒙板
                noto(shelfCollectionAdapter, false, resultBeanList);
//                全选消失
                setCheck(shelfCollectionAdapter, false, resultBeanList);
                //  隐藏底部布局
                shelf_foot.setVisibility(View.GONE);
                break;
            case R.id.shelfCollect_Delete:
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < resultBeanList.size(); i++) {
                    arrayList.add(resultBeanList.get(i).getLid()+"");
                }
//                批量删除
                presenter.sendDeleteCollection(arrayList);
                break;
        }
    }

    //    设置全选
    private void setCheck(ShelfCollectionAdapter adapter, boolean ischeck, List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList) {

        for (int i = 0; i < resultBeanList.size(); i++) {
            ShelfCollectionBean.DataBean.ResultBean resultBean = resultBeanList.get(i);
            resultBean.setCheck(ischeck);
        }
        adapter.notifyDataSetChanged();
    }
}
