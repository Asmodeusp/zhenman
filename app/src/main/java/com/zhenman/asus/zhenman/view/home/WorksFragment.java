package com.zhenman.asus.zhenman.view.home;


import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotUgcCommentBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.presenter.WorkPresenterImp;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyItemAdapter;
import com.zhenman.asus.zhenman.view.ui.MyViewPager;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import cn.youngkaaa.yviewpager.YViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WorksFragment extends BaseFragment<WorkPresenterImp> implements WorkContract.WorkView,View.OnClickListener {


    private MyViewPager homeHot_VerticalViewpager;
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
    private HomeHotPresenterImp presenters;
    private HomeHotRecyItemAdapter homeHotRecyItemAdapter;
    private RecyclerView homeHot_commentPopu_recy;
    private EditText homeHot_commentPopu_edText;

    public WorksFragment(MyViewPager homeHot_VerticalViewpager, HomeHotPresenterImp presenter) {
        this.homeHot_VerticalViewpager = homeHot_VerticalViewpager;
        this.presenters = presenter;
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
        initData();
        presenter.getHomeHotUgcCommentBean(data.getId(),"1","20",data.getType());
//        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    private void initData() {
        Bundle arguments = getArguments();
        data = (HomeHotBean.DataBean) arguments.getSerializable("data");
    }


    private void initView() {

        //RecyClerView
        HomeHot_WorksDetailsRecy = (RecyclerView) getActivity().findViewById(R.id.HomeHot_WorksDetailsRecy);
        HomeHot_WorksDetailsRecy.setOnClickListener(this);
        //低下阴影
        HomeHot_WorksDetails_FootView = (AutoRelativeLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_FootView);
        HomeHot_WorksDetails_FootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        //主题
        HomeHot_WorksDetails_ChallengeText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_ChallengeText);
        HomeHot_WorksDetails_ChallengeText.setOnClickListener(this);
        //用户名
        HomeHot_WorksDetails_UserNameText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_UserNameText);
        HomeHot_WorksDetails_UserNameText.setOnClickListener(this);
        //作评描述
        HomeHot_WorksDetails_DescribeText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_DescribeText);
        HomeHot_WorksDetails_DescribeText.setOnClickListener(this);
        //头像
        HomeHot_WorksDetails_HeadImg = (ImageView) getActivity().findViewById(R.id.HomeHot_WorksDetails_HeadImg);
        HomeHot_WorksDetails_HeadImg.setOnClickListener(this);
        //关注
        HomeHot_WorksDetails_follow = (ImageView) getActivity().findViewById(R.id.HomeHot_WorksDetails_follow);
        HomeHot_WorksDetails_follow.setOnClickListener(this);
        //喜欢
        HomeHot_WorksDetails_likeImg = (CheckBox) getActivity().findViewById(R.id.HomeHot_WorksDetails_likeImg);
        HomeHot_WorksDetails_likeImg.setOnClickListener(this);
        //喜欢个数
        HomeHot_WorksDetails_likeTextNumber = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_likeTextNumber);
        HomeHot_WorksDetails_likeTextNumber.setOnClickListener(this);
        //喜欢AutoLinearLayout
        HomeHot_WorksDetails_like = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_like);
        HomeHot_WorksDetails_like.setOnClickListener(this);
        //评论个数
        HomeHot_WorksDetails_commentText = (TextView) getActivity().findViewById(R.id.HomeHot_WorksDetails_commentText);
        HomeHot_WorksDetails_commentText.setOnClickListener(this);
        //评论AutoLinearLayout
        HomeHot_WorksDetails_comment = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_comment);
        HomeHot_WorksDetails_comment.setOnClickListener(this);
        //分享AutoLinearLayout
        HomeHot_WorksDetails_share = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_share);
        HomeHot_WorksDetails_share.setOnClickListener(this);
        //再创作Img
        HomeHot_WorksDetails_ReEditImage = (ImageView) getActivity().findViewById(R.id.HomeHot_WorksDetails_ReEditImage);
        HomeHot_WorksDetails_ReEditImage.setOnClickListener(this);
        //再创作AutoLinearLayout
        HomeHot_WorksDetails_ReEdit = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails_ReEdit);
        HomeHot_WorksDetails_ReEdit.setOnClickListener(this);
        //用户所有信息
        HomeHot_WorksDetails = (AutoLinearLayout) getActivity().findViewById(R.id.HomeHot_WorksDetails);
        //单图
        homeHot_works_image = getActivity().findViewById(R.id.HomeHot_Works_Image);
        HomeHot_WorksDetails.setOnClickListener(this);
        initLogic();
        homeHot_VerticalViewpager.setAllowScroll(false);
        HomeHot_WorksDetailsRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //得到当前显示的第一个item的view
                View firstChildView = recyclerView.getLayoutManager().getChildAt(0);
                //得到firstChildView的Top坐标值
                int firstChildTop = firstChildView.getTop();
                //得到Recyclerview的顶坐标减去顶部padding值，也就是显示内容最顶部的坐标
                int recyclerTop = recyclerView.getTop() - recyclerView.getPaddingTop();
                //通过这个firstChildView得到这个view当前的position值
                int firstPosition = recyclerView.getLayoutManager().getPosition(firstChildView);
                /*
                 *   当里面向上滑动时
                 *       开启里面滑动
                 *       关闭外层滑动
                 * **/
                if (dy < 0) {
                    homeHot_VerticalViewpager.setAllowScroll(true);
                }

                /*
                 *   当里面向下滑动时
                 *       开启里面滑动
                 *       关闭外层滑动
                 * **/
                if (dy > 0) {
                    homeHot_VerticalViewpager.setAllowScroll(true);
                }
                //得到当前显示的最后一个item的view
                View lastChildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                //得到lastChildView的bottom坐标值
                int lastChildBottom = lastChildView.getBottom();
                //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
                int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                //通过这个lastChildView得到这个view当前的position值
                int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);
                //如果两个条件都满足则说明是真正的滑动到了底部
                if (lastChildBottom == recyclerBottom && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {

                    homeHot_VerticalViewpager.setAllowScroll(true);

                }else {
                    homeHot_VerticalViewpager.setAllowScroll(false);
                }
                //如果两个条件都满足则说明是真正的滑动到了顶部
                if (firstChildTop == recyclerTop && firstPosition == 0) {
                    homeHot_VerticalViewpager.setAllowScroll(true);
//
                }else {
                    homeHot_VerticalViewpager.setAllowScroll(false);
                }
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
        homeHotRecyItemAdapter = new HomeHotRecyItemAdapter(data.getPageDtoList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HomeHot_WorksDetailsRecy.setLayoutManager(layoutManager);
        if (data.getPageDtoList().size() == 1) {
            HomeHot_WorksDetailsRecy.setVisibility(View.GONE);
            homeHot_VerticalViewpager.setAllowScroll(false);
            Glide.with(getContext()).load(data.getPageDtoList().get(0).getImageUrl()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(homeHot_works_image);
            homeHot_works_image.setVisibility(View.VISIBLE);

        } else {
            HomeHot_WorksDetailsRecy.setVisibility(View.VISIBLE);
            homeHot_works_image.setVisibility(View.GONE);
            homeHot_VerticalViewpager.setAllowScroll(false);
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
                        presenters.UgcFabulous(data.getId(), "0");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) - 1 + "");
                    } else {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenters.UgcFabulous(data.getId(), "1");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) + "");
                    }

                } else {
                    if (HomeHot_WorksDetails_likeImg.isChecked()) {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenters.UgcFabulous(data.getId(), "1");
                        HomeHot_WorksDetails_likeTextNumber.setText(Integer.parseInt(data.getLikeNum()) + 1 + "");
                    } else {
                        HomeHot_WorksDetails_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) HomeHot_WorksDetails_likeImg.getButtonDrawable();
                        animationDrawable.start();
                        presenters.UgcFabulous(data.getId(), "0");
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
                initBottomSheetDialog();
                break;

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


    }

    @Override
    public void showError(String msg) {

    }
}
