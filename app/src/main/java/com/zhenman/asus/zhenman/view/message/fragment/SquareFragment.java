package com.zhenman.asus.zhenman.view.message.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ThemeFeaturedSquareContract;
import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;
import com.zhenman.asus.zhenman.presenter.ThemeFeaturedSquarePresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.message.FeaturedAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SquareFragment extends BaseFragment<ThemeFeaturedSquarePresenter> implements ThemeFeaturedSquareContract.ThemeFeaturedSquareInView {


    private RecyclerView squareRecy;
    private TextView square_none;

    public SquareFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_square;
    }

    @Override
    protected void init() {
        squareRecy = getActivity().findViewById(R.id.squareRecy);
        square_none = getActivity().findViewById(R.id.square_none);
        String subject_id = (String) SPUtils.get(getContext(), SPKey.SUBJECT_ID, "");

        presenter.sendThemeFeaturedSquareData(subject_id, "1", "20", "0");

    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showThemeFeaturedSquareData(ThemeFeaturedBean themeFeaturedBean) {
        if (themeFeaturedBean.getState() == 0) {

            ThemeFeaturedBean.DataBean data = themeFeaturedBean.getData();
            List<ThemeFeaturedBean.DataBean.ResultBean> resultBeanList = data.getResult();

            if (resultBeanList.size() == 0) {
                square_none.setVisibility(View.VISIBLE);
                squareRecy.setVisibility(View.GONE);
            } else {
                square_none.setVisibility(View.GONE);
                squareRecy.setVisibility(View.VISIBLE);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
                squareRecy.setLayoutManager(gridLayoutManager);
                FeaturedAdapter featuredAdapter = new FeaturedAdapter(resultBeanList, getContext());
                squareRecy.setAdapter(featuredAdapter);
            }
        } else {
            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {

    }
}
