package com.zhenman.asus.zhenman.view.fragment;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.recker.flybanner.FlyBanner;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.SerializationContract;
import com.zhenman.asus.zhenman.model.bean.SerializationBean;
import com.zhenman.asus.zhenman.model.bean.SerializationLatelyBean;
import com.zhenman.asus.zhenman.presenter.SerializationPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.SerializationHotRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.SerializationLatelyRecyAdapter;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.ArrayList;

public class SerializationFragment extends BaseFragment<SerializationPresenterImp> implements SerializationContract.SerializationView, View.OnClickListener {
    ArrayList<String> urls = new ArrayList<>();
    private FlyBanner Serialization_FlyBanner;
    private ImageView Serialization_common_search;
    private RelativeLayout Serialization_serial_classButton;
    private RelativeLayout Serialization_serial_rankButton;
    private RelativeLayout Serialization_serial_starButton;
    private RelativeLayout Serialization_serial_collectionButton;
    private LinearLayout Serialization_Hot_moreButton;
    private LinearLayout Serialization_Lately_moreButton;
    private RecyclerView Serialization_LatelyRecy;
    private RecyclerView Serialization_HotRecy;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_serialization;
    }

    @Override
    protected void init() {
        Serialization_HotRecy = getActivity().findViewById(R.id.Serialization_HotRecy);
        Serialization_FlyBanner = getActivity().findViewById(R.id.Serialization_FlyBanner);
        Serialization_common_search = getActivity().findViewById(R.id.Serialization_common_search);
        Serialization_serial_classButton = getActivity().findViewById(R.id.Serialization_serial_classButton);
        Serialization_serial_rankButton = getActivity().findViewById(R.id.Serialization_serial_rankButton);
        Serialization_serial_starButton = getActivity().findViewById(R.id.Serialization_serial_starButton);
        Serialization_serial_collectionButton = getActivity().findViewById(R.id.Serialization_serial_collectionButton);
        Serialization_Hot_moreButton = getActivity().findViewById(R.id.Serialization_Hot_moreButton);
        Serialization_Lately_moreButton = getActivity().findViewById(R.id.Serialization_Lately_moreButton);
        Serialization_LatelyRecy = getActivity().findViewById(R.id.Serialization_LatelyRecy);
        Serialization_FlyBanner.setPoinstPosition(FlyBanner.RIGHT);
        Serialization_FlyBanner.setPointsIsVisible(true);
        Serialization_HotRecy.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        Serialization_LatelyRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        //分类
        Serialization_serial_classButton.setOnClickListener(this);
        //搜索
        Serialization_common_search.setOnClickListener(this);
        //排行榜
        Serialization_serial_rankButton.setOnClickListener(this);
        //达人榜
        Serialization_serial_starButton.setOnClickListener(this);
        //收藏
        Serialization_serial_collectionButton.setOnClickListener(this);
//        Serialization_FlyBanner.
    }

    @Override
    protected void loadDate() {
        presenter.getSerializationBean("11");
        presenter.getSerializationLatelyBean("1", "20");
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showSerializationBean(final SerializationBean SerializationBean) {
        if (SerializationBean == null) {
            Toast.makeText(getActivity(), "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            for (SerializationBean.DataBean.PgcSowingMapListBean pgcSowingMapListBean : SerializationBean.getData().getPgcSowingMapList()) {
                urls.add(pgcSowingMapListBean.getImageUrl());
            }
            Serialization_FlyBanner.setImagesUrl(urls);
            SerializationHotRecyAdapter serializationHotRecyAdapter = new SerializationHotRecyAdapter(SerializationBean.getData().getPgcHotRecommend());
            Serialization_HotRecy.setAdapter(serializationHotRecyAdapter);
            Serialization_HotRecy.setHasFixedSize(true);
            serializationHotRecyAdapter.setRecyclerViewOnCLickListener(new SerializationHotRecyAdapter.RecyclerViewOnCLickListener() {
                @Override
                public void myClick(View view, int position) {
                    com.zhenman.asus.zhenman.model.bean.SerializationBean.DataBean.PgcHotRecommendBean pgcHotRecommendBean = SerializationBean.getData().getPgcHotRecommend().get(position);
                    String pgcId = pgcHotRecommendBean.getPgcId();
                    Intent intent = new Intent(getActivity(), WorkDetailsActivity.class);
                    intent.putExtra("pgcid", pgcId);
                    getActivity().startActivity(intent);
                }
            });
        }

    }

    @Override
    public void showSerializationLatelyBean(final SerializationLatelyBean serializationLatelyBean) {
        if (serializationLatelyBean == null) {
            Toast.makeText(getActivity(), "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            SerializationLatelyRecyAdapter serializationLatelyRecyAdapter = new SerializationLatelyRecyAdapter(serializationLatelyBean.getData().getResult());
            Serialization_LatelyRecy.setAdapter(serializationLatelyRecyAdapter);
            Serialization_LatelyRecy.setHasFixedSize(true);
            serializationLatelyRecyAdapter.setRecyclerViewOnCLickListener(new SerializationLatelyRecyAdapter.RecyclerViewOnCLickListener() {
                @Override
                public void myClick(View view, int position) {
                    SerializationLatelyBean.DataBean.ResultBean resultBean = serializationLatelyBean.getData().getResult().get(position);
                    String pgcId = resultBean.getPgcId();
                    Intent intent = new Intent(getActivity(), WorkDetailsActivity.class);
                    intent.putExtra("pgcid", pgcId);
                    getActivity().startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //分类
            case R.id.Serialization_serial_classButton:

                break;
            //搜索
            case R.id.Serialization_common_search:

                break;
            //排行榜
            case R.id.Serialization_serial_rankButton:

                break;
            //达人榜
            case R.id.Serialization_serial_starButton:

                break;
            //收藏
            case R.id.Serialization_serial_collectionButton:

                break;
        }
    }
}
