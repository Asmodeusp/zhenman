package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkDetailsCommentContract;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.WorkDetailsCommentPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.WorkDetailsActorRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.WorkDetailsCommentAdapter;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.List;

/**
 * 曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */

public class WorkDetailsFragment extends BaseFragment<WorkDetailsCommentPresenterImp> implements WorkDetailsCommentContract.WorkDetailsCommentView {
    private TextView Work_DescriptionText;
    private TextView Actor_RecyTips;
    private RecyclerView Actor_Recy;
    private RecyclerView Work_commentRecy;
    private TextView work_commentTips;
    private String pgcId;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_details;
    }

    @Override
    protected void init() {
        pgcId = ((String) SPUtils.get(getContext(), SPKey.PGC_ID, "1"));
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

        if (data != null) {
            if (data.getActorList().size() == 0 && data.getActorList() == null) {
                Actor_RecyTips.setVisibility(View.VISIBLE);
            }
            //设置作品描述
            Work_DescriptionText.setText(data.getIntroduction());
            //设置演员列表格式
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            Actor_Recy.setLayoutManager(linearLayoutManager);
            WorkDetailsActorRecyAdapter workDetailsActorRecyAdapter = new WorkDetailsActorRecyAdapter(data.getActorList(), presenter);
            //设置演员列表适配器
            Actor_Recy.setAdapter(workDetailsActorRecyAdapter);
            workDetailsActorRecyAdapter.setgoUserInfo(new WorkDetailsActorRecyAdapter.goUserInfo() {
                @Override
                public void go(String UserId) {
                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
                    getActivity().finish();
                }
            });
        }
        presenter.getCommentList(pgcId,"1","20","2","1");
//        work_commentTips.setVisibility(View.VISIBLE);
        //设置评论列表格式
        Work_commentRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showError(String msg) {
//        if (!msg.equals("成功")) {
//            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
//        }
    }



    @Override
    public void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean) {
        Toast.makeText(getContext(), pgcFabulousBean.getMsg(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFollowBean(FollowBean followBean) {

    }

    @Override
    public void showCommentListBean(CommentListBean commentListBean) {
        if (commentListBean!=null) {
            Log.e("123456", commentListBean.getMsg());
            if (commentListBean.getData().getCommentDtoList().size()==0) {
                work_commentTips.setVisibility(View.VISIBLE);
                Work_commentRecy.setVisibility(View.GONE);
            }else{
                work_commentTips.setVisibility(View.GONE);
                Work_commentRecy.setVisibility(View.VISIBLE);
                Work_commentRecy.setAdapter(new WorkDetailsCommentAdapter(commentListBean.getData().getCommentDtoList(),presenter));

            }
        }
    }
}
