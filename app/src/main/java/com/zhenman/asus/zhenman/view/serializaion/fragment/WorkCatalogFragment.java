package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogAdapter;
import com.zhenman.asus.zhenman.view.serializaion.SerializationCatalogReadActivity;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkCatalogFragment extends BaseFragment implements View.OnClickListener {
    private TextView PositiveSequenceBtn;
    private TextView ReverseOrderBtn;
    private TextView All_chaptersText;
    private ImageView AutoRrepurchaseImg;
    private LinearLayout AutoRrepurchaseBtn;
    private RecyclerView Detaails_CatalogRecy;
    private List<SerializationCatalogBean.DataBean> serializationCatalogBeandata = new ArrayList<>();
    private List<SerializationCatalogBean.DataBean> PositiveDataBeans = new ArrayList<>();
    private List<SerializationCatalogBean.DataBean> ReverseDataBeans = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_catalog;
    }

    @Override
    protected void init() {
        //正序
        PositiveSequenceBtn = getActivity().findViewById(R.id.PositiveSequenceBtn);
        //倒序
        ReverseOrderBtn = getActivity().findViewById(R.id.ReverseOrderBtn);
        //自动续费图片
        AutoRrepurchaseImg = getActivity().findViewById(R.id.AutoRrepurchaseImg);
        //自动续费Button
        AutoRrepurchaseBtn = getActivity().findViewById(R.id.AutoRrepurchaseBtn);
        //全部章节
        All_chaptersText = getActivity().findViewById(R.id.All_chaptersText);
        //章节的RecyView
        Detaails_CatalogRecy = getActivity().findViewById(R.id.Detaails_CatalogRecy);
        //点击事件
        PositiveSequenceBtn.setOnClickListener(this);//正序
        ReverseOrderBtn.setOnClickListener(this);//倒序
        AutoRrepurchaseBtn.setOnClickListener(this);//自动续费
        serializationCatalogBeandata = ((WorkDetailsActivity) getActivity()).serializationCatalogBeandata;
        ReverseDataBeans.addAll(serializationCatalogBeandata);
        Collections.reverse(serializationCatalogBeandata);
        PositiveDataBeans.addAll(serializationCatalogBeandata);
        InitReverseAdapter();


    }

    private void InitReverseAdapter() {
        Detaails_CatalogRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        SerializationCatalogAdapter serializationCatalogAdapter = new SerializationCatalogAdapter(ReverseDataBeans);
        Detaails_CatalogRecy.setAdapter(serializationCatalogAdapter);
        All_chaptersText.setText("全部章节("+serializationCatalogBeandata.size()+")");
        serializationCatalogAdapter.notifyDataSetChanged();
        serializationCatalogAdapter.setRecyclerViewOnCLickListener(new SerializationCatalogAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                Intent intent = new Intent(getActivity(), SerializationCatalogReadActivity.class);
                intent.putExtra("catalogId",ReverseDataBeans.get(position).getCatalogId() );
                intent.putExtra("pgcId",PositiveDataBeans.get(position).getPgcId());
                startActivity(intent);
            }
        });
    }

    private void InitPositiveAdapter() {
        Detaails_CatalogRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        SerializationCatalogAdapter serializationCatalogAdapter = new SerializationCatalogAdapter(PositiveDataBeans);
        Detaails_CatalogRecy.setAdapter(serializationCatalogAdapter);
        All_chaptersText.setText("全部章节("+serializationCatalogBeandata.size()+")");
        serializationCatalogAdapter.notifyDataSetChanged();
        serializationCatalogAdapter.setRecyclerViewOnCLickListener(new SerializationCatalogAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                Intent intent = new Intent(getActivity(), SerializationCatalogReadActivity.class);
                intent.putExtra("catalogId",PositiveDataBeans.get(position).getCatalogId() );
                intent.putExtra("pgcId",PositiveDataBeans.get(position).getPgcId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.PositiveSequenceBtn:
                InitPositiveAdapter();
                setPositiveSequenceTextColor();
                break;
            case R.id.ReverseOrderBtn:
                InitReverseAdapter();
                setReverseOrderTexColort();
                break;
            case R.id.AutoRrepurchaseBtn:
                break;

        }
    }
    private void setPositiveSequenceTextColor() {
        PositiveSequenceBtn.setTextColor(Color.parseColor("#b37feb"));
        ReverseOrderBtn.setTextColor(Color.parseColor("#666666"));
    }
    private void setReverseOrderTexColort() {
        PositiveSequenceBtn.setTextColor(Color.parseColor("#666666"));
        ReverseOrderBtn.setTextColor(Color.parseColor("#b37feb"));

    }
}
