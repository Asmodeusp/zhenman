package com.zhenman.asus.zhenman.view.message.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ThemeFeaturedSquareContract;
import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;
import com.zhenman.asus.zhenman.presenter.ThemeFeaturedSquarePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends BaseFragment<ThemeFeaturedSquarePresenter> implements ThemeFeaturedSquareContract.ThemeFeaturedSquareInView {


    private RecyclerView featuredRecy;
    private TextView featured_none;

    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_featured;
    }

    @Override
    protected void init() {
        featuredRecy=getActivity().findViewById(R.id.featuredRecy);
        featured_none=getActivity().findViewById(R.id.featured_none);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showThemeFeaturedSquareData(ThemeFeaturedBean themeFeaturedBean) {
        
    }

    @Override
    public void showError(String string) {

    }
}
