package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkDetailsCommentContract;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;
import com.zhenman.asus.zhenman.presenter.WorkDetailsCommentPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.WorkCommentRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.WorkDetailsActorRecyAdapter;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class WorkDetailsFragment extends BaseFragment<WorkDetailsCommentPresenterImp> implements WorkDetailsCommentContract.WorkDetailsCommentView {
    private TextView Work_DescriptionText;
    private TextView Actor_RecyTips;
    private RecyclerView Actor_Recy;
    private RecyclerView Work_commentRecy;
    private List<WorkDetailsCommentBean.DataBean.ResultBean> result = new ArrayList<>();
    private SerializationCatalogBean serializationCatalogBean;
    private TextView work_commentTips;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_details;
    }

    @Override
    protected void init() {
        //作品描述
        Work_DescriptionText = getActivity().findViewById(R.id.Work_DescriptionText);
        //演员列表
        Actor_Recy = getActivity().findViewById(R.id.Actor_Recy);
        //评论列表
        Work_commentRecy = getActivity().findViewById(R.id.Work_commentRecy);
        //提示文字
        Actor_RecyTips = getActivity().findViewById(R.id.Actor_RecyTips);
        //评论列表提示文字
        work_commentTips = getActivity().findViewById(R.id.Work_commentTips);
        //得到连载详情Bean
        SerializationDetailsBean.DataBean data = ((WorkDetailsActivity) getActivity()).serializationDetailsBeandata;
        serializationCatalogBean = ((WorkDetailsActivity) getActivity()).serializationCatalogBean;
        if (data.getActorList().size() == 0 && data.getActorList() == null) {
            Actor_RecyTips.setVisibility(View.VISIBLE);
        }
        if (serializationCatalogBean.getData() != null && serializationCatalogBean.getData().size() != 0) {
            presenter.getWorkDetailsCommentBean(serializationCatalogBean.getData().get(0).getPgcId(), "" + 1);
        }
        if (result.size() == 0) {
            work_commentTips.setVisibility(View.VISIBLE);
            Work_commentRecy.setVisibility(View.GONE);
        }
        //设置作品描述
        Work_DescriptionText.setText(data.getIntroduction());
        //设置演员列表格式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Actor_Recy.setLayoutManager(linearLayoutManager);
        //设置演员列表适配器
        Actor_Recy.setAdapter(new WorkDetailsActorRecyAdapter(data.getActorList()));
        //设置评论列表格式
        Work_commentRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
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
    public void showWorkDetailsCommentBean(WorkDetailsCommentBean workDetailsCommentBean) {

        result.addAll(workDetailsCommentBean.getData().getResult());
        if (result.size() == 0) {

        } else {
            work_commentTips.setVisibility(View.GONE);
            Work_commentRecy.setVisibility(View.VISIBLE);
            //设置评论列表适配器
            WorkCommentRecyAdapter workCommentRecyAdapter = new WorkCommentRecyAdapter(result, serializationCatalogBean.getData().get(0).getPgcId(),presenter);
            Work_commentRecy.setAdapter(workCommentRecyAdapter);
            workCommentRecyAdapter.setRecyclerViewOnCLickListener(new WorkCommentRecyAdapter.RecyclerViewOnCLickListener() {
                @Override
                public void myClick(View view, final int position) {
                    final CheckBox Work_commentRecy_Like = view.findViewById(R.id.Work_commentRecy_Like);
                    final TextView Work_commentRecy_LikeNumber = view.findViewById(R.id.Work_commentRecy_LikeNumber);

                }
            });
        }
    }

    @Override
    public void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean) {

    }
}
