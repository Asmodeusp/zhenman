package com.zhenman.asus.zhenman.view.home;


import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;


public class HomeItemFragment extends BaseFragment {
    //ListView
    public RecyclerView home_Recy_fill_Recy;
    //头像
    private ImageView home_HeadImg;
    //关注
    private ImageView home_follow;
    //喜欢的Linearlayout
    private LinearLayout home_like;
    //喜欢的ImageView
    private CheckBox home_likeImg;
    //评论
    private LinearLayout home_comment;
    //分项
    private LinearLayout home_share;
    //在创作
    private LinearLayout home_edit;
    //再创作的ImageView
    private ImageView home_edit_Image;
    //挑战名字
    private TextView home_ChallengeText;
    //评论数量
    private TextView home_commentText;
    //UserName
    private TextView home_UserNameText;
    //作评描述
    private TextView home_describe;
    //喜欢数量
    private TextView home_likeText;
    //查看进度条
    private ProgressBar home_ProgressBar;
    //整个布局ID
    private RelativeLayout home_fillView;
    //底部灰色布局
    private RelativeLayout Home_footView;
    private HomeHotBean.DataBean hotItemBean;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_item;
    }

    @Override
    protected void init() {
        Bundle arguments = getArguments();
        hotItemBean = (HomeHotBean.DataBean) arguments.getSerializable("HotItem");
        initView();
        inithh();

    }

    private void inithh() {
        Glide.with(getContext()).load(hotItemBean.getHeadImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(home_HeadImg);
       home_likeText.setText(hotItemBean.getLikeNum());
        home_ChallengeText.setText(hotItemBean.getChallengeFlag());
         home_describe.setText(hotItemBean.getDescription());
         home_commentText.setText(hotItemBean.getCommentNum());
        //初始化热门页的RecylerView中的RecylerView
        HomeHotRecyAdapter homeHotRecyAdapter = new HomeHotRecyAdapter(hotItemBean.getPageDtoList());
        home_Recy_fill_Recy.setAdapter(homeHotRecyAdapter);
         home_UserNameText.setText("@ "+hotItemBean.getName());
        if (hotItemBean.isLike()) {
             home_likeImg.setButtonDrawable(R.mipmap.like_13);
        }else{
             home_likeImg.setButtonDrawable(R.mipmap.unlike_04);
        }
         home_likeImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (hotItemBean.isLike()) {
                    if ( home_likeImg.isChecked()) {
                         home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable)  home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    }else {
                         home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable)  home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    }

                }else{
                    if ( home_likeImg.isChecked()) {
                         home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable)  home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    }else {
                         home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable)  home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    }

                }
            }
        });
    }

    private void initView() {
        home_Recy_fill_Recy = getActivity().findViewById(R.id.home_Recy_fill_Recy);
        home_HeadImg = getActivity().findViewById(R.id.home_HeadImg);
        home_follow = getActivity().findViewById(R.id.home_follow);
        home_like = getActivity().findViewById(R.id.home_like);
        home_likeImg = getActivity().findViewById(R.id.home_likeImg);
        home_comment = getActivity().findViewById(R.id.home_comment);
        home_commentText = getActivity().findViewById(R.id.home_commentText);
        home_share = getActivity().findViewById(R.id.home_share);
        home_edit = getActivity().findViewById(R.id.home_edit);
        home_edit_Image = getActivity().findViewById(R.id.home_edit_Image);
        home_ChallengeText = getActivity().findViewById(R.id.home_ChallengeText);
        home_UserNameText = getActivity().findViewById(R.id.home_UserNameText);
        home_describe = getActivity().findViewById(R.id.home_describe);
        home_fillView = getActivity().findViewById(R.id.home_fillView);
//            home_ProgressBar = itemView.findViewById(R.id.home_ProgressBar);
        home_likeText = getActivity().findViewById(R.id.home_likeText);
        Home_footView = getActivity().findViewById(R.id.Home_footView);
    }

    @Override
    protected void loadDate() {

    }

}
