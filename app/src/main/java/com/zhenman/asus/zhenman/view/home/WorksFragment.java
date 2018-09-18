package com.zhenman.asus.zhenman.view.home;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotUgcCommentBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.presenter.WorkPresenterImp;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyItemAdapter;
import com.zhy.autolayout.AutoLinearLayout;

public class WorksFragment extends BaseFragment<WorkPresenterImp> implements WorkContract.WorkView,View.OnClickListener {


    private HomeHotBean.DataBean data;
    private TextView HomeHot_WorksDetails_ChallengeText;
    private TextView HomeHot_WorksDetails_UserNameText;
    private TextView HomeHot_WorksDetails_DescribeText;
    private ImageView HomeHot_WorksDetails_HeadImg;
    private ImageView HomeHot_WorksDetails_follow;
    private CheckBox HomeHot_WorksDetails_likeImg;
    private TextView HomeHot_WorksDetails_likeTextNumber;
    private AutoLinearLayout HomeHot_WorksDetails_like;
    private TextView HomeHot_WorksDetails_commentText;
    private AutoLinearLayout HomeHot_WorksDetails_comment;
    private AutoLinearLayout HomeHot_WorksDetails_share;
    private ImageView HomeHot_WorksDetails_ReEditImage;
    private AutoLinearLayout HomeHot_WorksDetails_ReEdit;
    private AutoLinearLayout HomeHot_WorksDetails;
    private ImageView homeHot_works_image;
    private HomeHotPresenterImp presenters;
    private HomeHotRecyItemAdapter homeHotRecyItemAdapter;
    private RecyclerView homeHot_commentPopu_recy;
    private EditText homeHot_commentPopu_edText;
    private ImageView image;
    private String id;
    private String name;
    private String catalogId;
    private String userId;
    private String headImg;
    private String finalImg;
    private String coverImg;
    private int type;
    private int height;
    private String description;
    private String likeNum;
    private String commentNum;
    private String shareNum;
    private String shareImg;
    private String subjectName;
    private int subjectId;
    private boolean follow;
    private boolean like;
    private boolean reCreate;

    public WorksFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_works;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadDate() {

        Bundle arguments = getArguments();
        id = arguments.getString("id");
        name = arguments.getString("name");
        catalogId = arguments.getString("catalogId");
        userId = arguments.getString("userId");
        headImg = arguments.getString("headImg");
        finalImg = arguments.getString("finalImg");
        coverImg = arguments.getString("coverImg");
        type = arguments.getInt("type");
        height = arguments.getInt("height");
        description = arguments.getString("description");
        likeNum = arguments.getString("likeNum");
        commentNum = arguments.getString("commentNum");
        shareNum = arguments.getString("shareNum");
        shareImg = arguments.getString("shareImg");
        subjectName = arguments.getString("subjectName");
        subjectId = arguments.getInt("subjectId");
        follow = arguments.getBoolean("follow");
        like = arguments.getBoolean("like");
        reCreate = arguments.getBoolean("reCreate");

    }




    private void initView() {


//        //主题
//        HomeHot_WorksDetails_ChallengeText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_ChallengeText);
//        HomeHot_WorksDetails_ChallengeText.setOnClickListener(this);
//        //用户名
//        HomeHot_WorksDetails_UserNameText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_UserNameText);
//        HomeHot_WorksDetails_UserNameText.setOnClickListener(this);
//        //作评描述
//        HomeHot_WorksDetails_DescribeText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_DescribeText);
//        HomeHot_WorksDetails_DescribeText.setOnClickListener(this);
//        //头像
//        HomeHot_WorksDetails_HeadImg = (ImageView) getActivity().findViewById(R.id.HomeHot_WorksDetails_HeadImg);
//        HomeHot_WorksDetails_HeadImg.setOnClickListener(this);
//        //关注
//        HomeHot_WorksDetails_follow = (ImageView) getActivity().findViewById(R.id.HomeHot_WorksDetails_follow);
//        HomeHot_WorksDetails_follow.setOnClickListener(this);
//        //喜欢
//        HomeHot_WorksDetails_likeImg = (CheckBox) getActivity().findViewById(R.id.HomeHot_WorksDetails_likeImg);
//        HomeHot_WorksDetails_likeImg.setOnClickListener(this);
//        //喜欢个数
//        HomeHot_WorksDetails_likeTextNumber = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_likeTextNumber);
//        HomeHot_WorksDetails_likeTextNumber.setOnClickListener(this);
//        //喜欢AutoLinearLayout
//        HomeHot_WorksDetails_like = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_like);
//        HomeHot_WorksDetails_like.setOnClickListener(this);
//        //评论个数
//        HomeHot_WorksDetails_commentText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_commentText);
//        HomeHot_WorksDetails_commentText.setOnClickListener(this);
//        //评论AutoLinearLayout
//        HomeHot_WorksDetails_comment = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_comment);
//        HomeHot_WorksDetails_comment.setOnClickListener(this);
//        //分享AutoLinearLayout
//        HomeHot_WorksDetails_share = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_share);
//        HomeHot_WorksDetails_share.setOnClickListener(this);
//        //再创作Img
//        HomeHot_WorksDetails_ReEditImage = (ImageView) getActivity().findViewById(R.id.HomeHot_WorksDetails_ReEditImage);
//        HomeHot_WorksDetails_ReEditImage.setOnClickListener(this);
//        //再创作AutoLinearLayout
//        HomeHot_WorksDetails_ReEdit = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_ReEdit);
//        HomeHot_WorksDetails_ReEdit.setOnClickListener(this);
//        //用户所有信息
//        HomeHot_WorksDetails = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails);
//        //单图
//        homeHot_works_image = getActivity().findViewById(R.id.HomeHot_Works_Image);
        image = getActivity().findViewById(R.id.fillimage);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
        image.setLayoutParams(layoutParams);
        Glide.with(getContext()).load(finalImg).into(image);
//        HomeHot_WorksDetails.setOnClickListener(this);
        //逻辑方法
        initLogic();
//        homeHot_VerticalViewpager.setAllowScroll(false);


    }

    private void initLogic() {
//        Glide.with(getContext()).load(headImg).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(HomeHot_WorksDetails_HeadImg);
//        HomeHot_WorksDetails_likeTextNumber.setText( likeNum);
//        HomeHot_WorksDetails_ChallengeText.setText( subjectName);
//        HomeHot_WorksDetails_DescribeText.setText(  description);
//        HomeHot_WorksDetails_commentText.setText( commentNum);


//        HomeHot_WorksDetails_UserNameText.setText("@ " +  name);
//        if ( like) {
//            HomeHot_WorksDetails_likeImg.setButtonDrawable(R.mipmap.like_13);
//        } else {
//            HomeHot_WorksDetails_likeImg.setButtonDrawable(R.mipmap.unlike_04);
//        }
//        HomeHot_WorksDetails_likeImg.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//                if ( like) {
//                    if (HomeHot_WorksDetails_likeImg.isChecked()) {
//                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
//                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
//                        animationDrawable.start();
//                        presenters.UgcFabulous( id, "0");
//                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt( likeNum) - 1 + "");
//                    } else {
//                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
//                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
//                        animationDrawable.start();
//                        presenters.UgcFabulous( id, "1");
//                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt( likeNum) + "");
//                    }
//
//                } else {
//                    if (HomeHot_WorksDetails_likeImg.isChecked()) {
//                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
//                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
//                        animationDrawable.start();
//                        presenters.UgcFabulous( id, "1");
//                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt( likeNum) + 1 + "");
//                    } else {
//                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
//                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
//                        animationDrawable.start();
//                        presenters.UgcFabulous(id, "0");
//                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(likeNum) + "");
//                    }
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.HomeHot_WorksDetails_comment:
//                initBottomSheetDialog();
//                break;

        }
    }

    private void initBottomSheetDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_sheet_dialog_layout, null, false);
        //评论列表
        homeHot_commentPopu_recy = view.findViewById(R.id.HomeHot_CommentPopu_Recy);
        //评论输入框
        homeHot_commentPopu_edText = view.findViewById(R.id.HomeHot_CommentPopu_EdText);
        dialog.setContentView(view);
        dialog.show();
    }

    @Override
    public void ShowHomeHotUgcCommentBean(HomeHotUgcCommentBean homeHotUgcCommentBean) {
        homeHot_commentPopu_recy.setLayoutManager(new LinearLayoutManager(getActivity()));

//        homeHot_commentPopu_recy.setAdapter();
    }

    @Override
    public void showError(String msg) {

    }
}
