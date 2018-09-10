package com.zhenman.asus.zhenman.view.home;


import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyItemAdapter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import cn.youngkaaa.yviewpager.YViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WorksFragment extends Fragment implements View.OnClickListener {


    private YViewPager homeHot_VerticalViewpager;
    private HomeHotBean.DataBean data;
    private RecyclerView HomeHot_WorksDetailsRecy;
    private AutoRelativeLayout HomeHot_WorksDetails_FootView;
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
    private HomeHotPresenterImp presenter;

    public WorksFragment(YViewPager homeHot_VerticalViewpager, HomeHotPresenterImp presenter) {
        this.homeHot_VerticalViewpager = homeHot_VerticalViewpager;
        this.presenter = presenter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_works, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        data = (HomeHotBean.DataBean) arguments.getSerializable("data");
    }


    private void initView(View view) {

        //RecyClerView
        HomeHot_WorksDetailsRecy = (RecyclerView) view.findViewById(R.id.HomeHot_WorksDetailsRecy);
        HomeHot_WorksDetailsRecy.setOnClickListener(this);
        //低下阴影
        HomeHot_WorksDetails_FootView = (AutoRelativeLayout) view.findViewById(R.id.HomeHot_WorksDetails_FootView);
        HomeHot_WorksDetails_FootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        //主题
        HomeHot_WorksDetails_ChallengeText = (TextView) view.findViewById(R.id.HomeHot_WorksDetails_ChallengeText);
        HomeHot_WorksDetails_ChallengeText.setOnClickListener(this);
        //用户名
        HomeHot_WorksDetails_UserNameText = (TextView) view.findViewById(R.id.HomeHot_WorksDetails_UserNameText);
        HomeHot_WorksDetails_UserNameText.setOnClickListener(this);
        //作评描述
        HomeHot_WorksDetails_DescribeText = (TextView) view.findViewById(R.id.HomeHot_WorksDetails_DescribeText);
        HomeHot_WorksDetails_DescribeText.setOnClickListener(this);
        //头像
        HomeHot_WorksDetails_HeadImg = (ImageView) view.findViewById(R.id.HomeHot_WorksDetails_HeadImg);
        HomeHot_WorksDetails_HeadImg.setOnClickListener(this);
        //关注
        HomeHot_WorksDetails_follow = (ImageView) view.findViewById(R.id.HomeHot_WorksDetails_follow);
        HomeHot_WorksDetails_follow.setOnClickListener(this);
        //喜欢
        HomeHot_WorksDetails_likeImg = (CheckBox) view.findViewById(R.id.HomeHot_WorksDetails_likeImg);
        HomeHot_WorksDetails_likeImg.setOnClickListener(this);
        //喜欢个数
        HomeHot_WorksDetails_likeTextNumber = (TextView) view.findViewById(R.id.HomeHot_WorksDetails_likeTextNumber);
        HomeHot_WorksDetails_likeTextNumber.setOnClickListener(this);
        //喜欢AutoLinearLayout
        HomeHot_WorksDetails_like = (AutoLinearLayout) view.findViewById(R.id.HomeHot_WorksDetails_like);
        HomeHot_WorksDetails_like.setOnClickListener(this);
        //评论个数
        HomeHot_WorksDetails_commentText = (TextView) view.findViewById(R.id.HomeHot_WorksDetails_commentText);
        HomeHot_WorksDetails_commentText.setOnClickListener(this);
        //评论AutoLinearLayout
        HomeHot_WorksDetails_comment = (AutoLinearLayout) view.findViewById(R.id.HomeHot_WorksDetails_comment);
        HomeHot_WorksDetails_comment.setOnClickListener(this);
        //分享AutoLinearLayout
        HomeHot_WorksDetails_share = (AutoLinearLayout) view.findViewById(R.id.HomeHot_WorksDetails_share);
        HomeHot_WorksDetails_share.setOnClickListener(this);
        //再创作Img
        HomeHot_WorksDetails_ReEditImage = (ImageView) view.findViewById(R.id.HomeHot_WorksDetails_ReEditImage);
        HomeHot_WorksDetails_ReEditImage.setOnClickListener(this);
        //再创作AutoLinearLayout
        HomeHot_WorksDetails_ReEdit = (AutoLinearLayout) view.findViewById(R.id.HomeHot_WorksDetails_ReEdit);
        HomeHot_WorksDetails_ReEdit.setOnClickListener(this);
        //用户所有信息
        HomeHot_WorksDetails = (AutoLinearLayout) view.findViewById(R.id.HomeHot_WorksDetails);
        //单图
        homeHot_works_image = view.findViewById(R.id.HomeHot_Works_Image);
        HomeHot_WorksDetails.setOnClickListener(this);
        initLogic();
        HomeHot_WorksDetailsRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    private void initLogic() {
        Glide.with(getContext()).load(data.getHeadImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(HomeHot_WorksDetails_HeadImg);
        HomeHot_WorksDetails_likeTextNumber.setText(data.getLikeNum());
        HomeHot_WorksDetails_ChallengeText.setText(data.getSubjectName());
        HomeHot_WorksDetails_DescribeText.setText((CharSequence) data.getDescription());
        HomeHot_WorksDetails_commentText.setText(data.getCommentNum());
        //初始化热门页的RecylerView中的RecylerView
        HomeHotRecyItemAdapter homeHotRecyItemAdapter = new HomeHotRecyItemAdapter(data.getPageDtoList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HomeHot_WorksDetailsRecy.setLayoutManager(layoutManager);
        if (data.getPageDtoList().size() == 1) {
            HomeHot_WorksDetailsRecy.setVisibility(View.GONE);
            Glide.with(getContext()).load(data.getPageDtoList().get(0).getImageUrl()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(homeHot_works_image);
            homeHot_works_image.setVisibility(View.VISIBLE);
        } else {
            HomeHot_WorksDetailsRecy.setVisibility(View.VISIBLE);
            homeHot_works_image.setVisibility(View.GONE);
        }
        HomeHot_WorksDetailsRecy.setAdapter(homeHotRecyItemAdapter);
        HomeHot_WorksDetails_UserNameText.setText("@ " + data.getName());
        if (data.isLike()) {
            HomeHot_WorksDetails_likeImg.setButtonDrawable(R.mipmap.like_13);
        } else {
            HomeHot_WorksDetails_likeImg.setButtonDrawable(R.mipmap.unlike_04);
        }
        HomeHot_WorksDetails_likeImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (data.isLike()) {
                    if (HomeHot_WorksDetails_likeImg.isChecked()) {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenter.UgcFabulous(data.getId(), "0");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) - 1 + "");
                    } else {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenter.UgcFabulous(data.getId(), "1");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) + "");
                    }

                } else {
                    if (HomeHot_WorksDetails_likeImg.isChecked()) {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenter.UgcFabulous(data.getId(), "1");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) + 1 + "");
                    } else {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenter.UgcFabulous(data.getId(), "0");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) + "");
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.HomeHot_WorksDetails_comment:
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.homehot_comment_popu);
                bottomSheetDialog.show();
                break;

        }
    }
}
