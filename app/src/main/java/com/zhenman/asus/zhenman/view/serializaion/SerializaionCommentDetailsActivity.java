package com.zhenman.asus.zhenman.view.serializaion;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializaionCommentDetailsContract;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.TextExtraBean;
import com.zhenman.asus.zhenman.presenter.SerializaionCommentDetailsPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentItemRecyAdapter;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SerializaionCommentDetailsActivity extends BaseActivity<SerializaionCommentDetailsPresenterImp> implements SerializaionCommentDetailsContract.SerializaionCommentDetailsView, View.OnClickListener {

    private String commentId;
    private String PgcId;
    private AutoLinearLayout SerializaionCommentDetails_return;
    private TextView SerializaionCommentDetails_CommentNumber;
    private ImageView SerializaionCommentDetails_HeadView;
    private TextView SerializaionCommentDetails_UserName;
    private TextView SerializaionCommentDetails_Comment;
    private TextView SerializaionCommentDetails_Time;
    private CheckBox SerializaionCommentDetails_Like;
    private TextView SerializaionCommentDetails_LikeNumber;
    private RecyclerView SerializaionCommentDetails_CommentRecy;
    private AutoLinearLayout SerializaionCommentDetails_AllCommentTip;
    private CommentItemListBean commentItemListBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_serializaion_comment_details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        PgcId = intent.getStringExtra(SPKey.PGC_ID);
        initView();

    }

    private void initLogic() {
        if (commentItemListBean.getData().getCommentDtoList().size()!=0&&commentItemListBean.getData().getCommentDtoList()!=null) {
            SerializaionCommentDetails_AllCommentTip.setVisibility(View.VISIBLE);
        }else {
            SerializaionCommentDetails_AllCommentTip.setVisibility(View.GONE);
        }
        GlideUtils.loadCircleImage(commentItemListBean.getData().getImageUrl(), SerializaionCommentDetails_HeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
            }
        });

        SerializaionCommentDetails_Time.setText(SPUtils.transferLongToDate(Long.parseLong(commentItemListBean.getData().getAddTime())));
        SerializaionCommentDetails_LikeNumber.setText(commentItemListBean.getData().getLikeNum()+"");
        if (commentItemListBean.getData().isLike()) {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);

        } else {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
        }
        if (commentItemListBean.getData().isLike()) {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
            SerializaionCommentDetails_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SerializaionCommentDetails_Like.isChecked()) {
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "0", PgcId);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") - 1 + "");
                    } else {
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "1", PgcId);
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") + "");
                    }
                }
            });
        } else {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
            SerializaionCommentDetails_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SerializaionCommentDetails_Like.isChecked()) {
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "1", PgcId);
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") + 1 + "");
                    } else {
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "0", PgcId);
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") + "");
                    }
                }
            });
        }
        SerializaionCommentDetails_UserName.setText(commentItemListBean.getData().getName());
        //设置富文本
        ArrayList<String> list = new ArrayList<>();
        if (commentItemListBean.getData().getTextDto() != null) {

            List<TextExtraBean> textExtra = commentItemListBean.getData().getTextDto().getTextExtra();
            MyClickSpan.setTextHighLightWithClick(SerializaionCommentDetails_Comment, commentItemListBean.getData().getTextDto().getText(), textExtra, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, listBean.getTextDto().getTextExtra().get(0).getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        SerializaionCommentDetails_CommentRecy.setLayoutManager(new LinearLayoutManager(this));
        CommentItemRecyAdapter commentItemRecyAdapter = new CommentItemRecyAdapter(commentItemListBean.getData().getCommentDtoList());
        SerializaionCommentDetails_CommentRecy.setAdapter(commentItemRecyAdapter);

    }

    @Override
    protected void loadDate() {
        Intent intent = getIntent();
        String commentId = intent.getStringExtra("CommentId");
        presenter.getCommentItemList(commentId, "1", "20", "2", "2");

    }

    private void initView() {
        SerializaionCommentDetails_return = (AutoLinearLayout) findViewById(R.id.SerializaionCommentDetails_return);
        SerializaionCommentDetails_CommentNumber = (TextView) findViewById(R.id.SerializaionCommentDetails_CommentNumber);
        SerializaionCommentDetails_HeadView = (ImageView) findViewById(R.id.SerializaionCommentDetails_HeadView);
        SerializaionCommentDetails_UserName = (TextView) findViewById(R.id.SerializaionCommentDetails_UserName);
        SerializaionCommentDetails_Comment = (TextView) findViewById(R.id.SerializaionCommentDetails_Comment);
        SerializaionCommentDetails_Time = (TextView) findViewById(R.id.SerializaionCommentDetails_Time);
        SerializaionCommentDetails_Like = (CheckBox) findViewById(R.id.SerializaionCommentDetails_Like);
        SerializaionCommentDetails_LikeNumber = (TextView) findViewById(R.id.SerializaionCommentDetails_LikeNumber);
        SerializaionCommentDetails_CommentRecy = (RecyclerView) findViewById(R.id.SerializaionCommentDetails_CommentRecy);
        SerializaionCommentDetails_AllCommentTip = (AutoLinearLayout) findViewById(R.id.SerializaionCommentDetails_AllCommentTip);
        SerializaionCommentDetails_return.setOnClickListener(this);

    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean) {

    }

    @Override
    public void showCommentItemList(CommentItemListBean commentItemListBean) {
        this.commentItemListBean = commentItemListBean;
        initLogic();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SerializaionCommentDetails_return:
                finish();
                break;
        }
    }
}
