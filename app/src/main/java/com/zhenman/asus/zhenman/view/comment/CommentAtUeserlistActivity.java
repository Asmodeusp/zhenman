package com.zhenman.asus.zhenman.view.comment;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.CommentAtContract;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.CommentAtPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentAtActorRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentAtFollowRecyAdapter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;


import butterknife.BindView;
import butterknife.OnClick;

public class CommentAtUeserlistActivity extends BaseActivity<CommentAtPresenterImp> implements CommentAtContract.CommentAtView {

    @BindView(R.id.Comment_At_BackButton)
    AutoRelativeLayout CommentAtBackButton;
    @BindView(R.id.Comment_At_ActoText)
    AutoLinearLayout CommentAtActoText;
    @BindView(R.id.Comment_At_ActorRecycler)
    RecyclerView CommentAtActorRecycler;
    @BindView(R.id.Comment_At_FollowUserText)
    AutoLinearLayout CommentAtFollowUserText;
    @BindView(R.id.Comment_At_FollowUserRecycler)
    RecyclerView CommentAtFollowUserRecycler;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_comment_at_ueserlist;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {
        String pgcId = (String) SPUtils.get(this, SPKey.PGC_ID, "");
        presenter.getSerializationDetailsBean(pgcId);
        String UserId = (String) SPUtils.get(this, SPKey.USER_ID, "");
        presenter.sendMyAttentionUserData("1", "20", UserId);
    }

    @Override
    public void showMyAttentionUserData(final MyAttentionUserBean attentionUserBean) {
        if (attentionUserBean != null&&attentionUserBean.getData().getResult().size()!=0) {
            CommentAtFollowUserRecycler.setLayoutManager(new LinearLayoutManager(this));
            if (attentionUserBean.getData().getResult().size() != 0) {
                CommentAtFollowUserRecycler.setVisibility(View.VISIBLE);
                CommentAtFollowUserText.setVisibility(View.VISIBLE);
                CommentAtFollowRecyAdapter commentAtFollowRecyAdapter = new CommentAtFollowRecyAdapter(attentionUserBean.getData().getResult());
                CommentAtFollowUserRecycler.setAdapter(commentAtFollowRecyAdapter);
                commentAtFollowRecyAdapter.setRecyclerViewOnCLickListener(new CommentAtFollowRecyAdapter.RecyclerViewOnCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        String name = attentionUserBean.getData().getResult().get(position).getName();
                        Intent intent = new Intent();
                        intent.putExtra("name", name);
                        intent.putExtra("id",attentionUserBean.getData().getResult().get(position).getUserId());
                        CommentAtUeserlistActivity.this.setResult(500, intent);
                        finish();

                    }
                });
            } else {
                CommentAtFollowUserRecycler.setVisibility(View.GONE);
                CommentAtFollowUserText.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public void showError(String string) {

    }

    @Override
    public void showSerializationDetailsBean(final SerializationDetailsBean serializationDetailsBean) {
        if (serializationDetailsBean != null&&serializationDetailsBean.getData().getActorList().size()!=0) {
            CommentAtActorRecycler.setLayoutManager(new LinearLayoutManager(this));
            if (serializationDetailsBean.getData().getActorList().size() != 0) {
                CommentAtActorRecycler.setVisibility(View.VISIBLE);
                CommentAtActoText.setVisibility(View.VISIBLE);
                CommentAtActorRecyAdapter commentAtActorRecyAdapter = new CommentAtActorRecyAdapter(serializationDetailsBean.getData().getActorList());
                CommentAtActorRecycler.setAdapter(commentAtActorRecyAdapter);
                commentAtActorRecyAdapter.setRecyclerViewOnCLickListener(new CommentAtActorRecyAdapter.RecyclerViewOnCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        String name = serializationDetailsBean.getData().getActorList().get(position).getName();
                        Intent intent = new Intent();
                        intent.putExtra("name", name);
                        intent.putExtra("id",serializationDetailsBean.getData().getActorList().get(position).getUserId());
                        setResult(500, intent);
                        finish();
                    }
                });
            } else {
                CommentAtActorRecycler.setVisibility(View.GONE);
                CommentAtActoText.setVisibility(View.GONE);
            }
        }
    }

    @OnClick({R.id.Comment_At_BackButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Comment_At_BackButton:
                finish();
                break;
        }
    }
}
