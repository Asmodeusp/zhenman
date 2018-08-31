package com.zhenman.asus.zhenman.view.serializaion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.PgcChapterCommentDetailContract;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentDetailBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.PgcChapterCommentDetailPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class SerializaionCommentDetailsActivity extends BaseActivity<PgcChapterCommentDetailPresenterImp> implements PgcChapterCommentDetailContract.PgcChapterCommentDetailView, View.OnClickListener {

    private String commentId;
    private String PgcId;
    private ImageView SerializaionCommentDetails_return;
    private TextView SerializaionCommentDetails_CommentNumber;
    private ImageView SerializaionCommentDetails_HeadView;
    private TextView SerializaionCommentDetails_UserName;
    private TextView SerializaionCommentDetails_Comment;
    private TextView SerializaionCommentDetails_Time;
    private CheckBox SerializaionCommentDetails_Like;
    private TextView SerializaionCommentDetails_LikeNumber;
    private RecyclerView SerializaionCommentDetails_CommentRecy;
    private List<PgcChapterCommentDetailBean.DataBean.ResultBeanX> result = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_serializaion_comment_details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        commentId = intent.getStringExtra("CommentId");
        PgcId = intent.getStringExtra("PgcId");
        presenter.GetPgcChapterCommentDetailBean(PgcId, "1", "20", PgcId);
        initView();


    }

    private void initLogic() {
        GlideUtils.loadCircleImage(result.get(0).getImageUrl(),SerializaionCommentDetails_HeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
//                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        });

        SerializaionCommentDetails_Time.setText(SPUtils.transferLongToDate(Long.parseLong(result.get(0).getAddTime())));
        SerializaionCommentDetails_LikeNumber.setText(result.get(0).getLikeNum());
        if (result.get(0).isLike()) {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);

        } else {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
        }
        if (result.get(0).isLike()) {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
            SerializaionCommentDetails_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SerializaionCommentDetails_Like.isChecked()) {
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        presenter.PGCFabulous(PgcId, result.get(0).getCommentId(), "0", PgcId);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(result.get(0).getLikeNum()) - 1 + "");
                    } else {
                        presenter.PGCFabulous(PgcId, result.get(0).getCommentId(), "1", PgcId);
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(result.get(0).getLikeNum()) + "");
                    }
                }
            });
        } else {
            SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
            SerializaionCommentDetails_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SerializaionCommentDetails_Like.isChecked()) {
                        presenter.PGCFabulous(PgcId, result.get(0).getCommentId(), "1", PgcId);
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(result.get(0).getLikeNum()) + 1 + "");
                    } else {
                        presenter.PGCFabulous(PgcId, result.get(0).getCommentId(), "0", PgcId);
                        SerializaionCommentDetails_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        SerializaionCommentDetails_LikeNumber.setText(Integer.parseInt(result.get(0).getLikeNum()) + "");
                    }
                }
            });
        }
        SerializaionCommentDetails_UserName.setText(result.get(0).getName());
    }

    @Override
    protected void loadDate() {

    }

    private void initView() {
        SerializaionCommentDetails_return = (ImageView) findViewById(R.id.SerializaionCommentDetails_return);
        SerializaionCommentDetails_CommentNumber = (TextView) findViewById(R.id.SerializaionCommentDetails_CommentNumber);
        SerializaionCommentDetails_HeadView = (ImageView) findViewById(R.id.SerializaionCommentDetails_HeadView);
        SerializaionCommentDetails_UserName = (TextView) findViewById(R.id.SerializaionCommentDetails_UserName);
        SerializaionCommentDetails_Comment = (TextView) findViewById(R.id.SerializaionCommentDetails_Comment);
        SerializaionCommentDetails_Time = (TextView) findViewById(R.id.SerializaionCommentDetails_Time);
        SerializaionCommentDetails_Like = (CheckBox) findViewById(R.id.SerializaionCommentDetails_Like);
        SerializaionCommentDetails_LikeNumber = (TextView) findViewById(R.id.SerializaionCommentDetails_LikeNumber);
        SerializaionCommentDetails_CommentRecy = (RecyclerView) findViewById(R.id.SerializaionCommentDetails_CommentRecy);
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
    public void showPgcChapterCommentDetailBean(PgcChapterCommentDetailBean pgcChapterCommentDetailBean) {
        if (pgcChapterCommentDetailBean.getData().getResult()!=null) {
            result.addAll(pgcChapterCommentDetailBean.getData().getResult());
            initLogic();
        }

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
