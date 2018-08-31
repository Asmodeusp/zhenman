package com.zhenman.asus.zhenman.view.home;


import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;


public class HomeItemFragment extends BaseFragment {

    private HomeHotBean.DataBean hotItemBean;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_item;
    }

    @Override
    protected void init() {
        Bundle arguments = getArguments();
        hotItemBean = (HomeHotBean.DataBean) arguments.getSerializable("HotItem");
        initView();
        inithh();

    }

    private void inithh() {
    }

    private void initView() {

    }

    @Override
    protected void loadDate() {

    }

}
