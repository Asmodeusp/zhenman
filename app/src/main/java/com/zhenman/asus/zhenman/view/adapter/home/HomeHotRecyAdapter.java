package com.zhenman.asus.zhenman.view.adapter.home;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class HomeHotRecyAdapter extends RecyclerView.Adapter<HomeHotRecyAdapter.Holder> {
    private List<HomeHotBean.DataBean> list;
    private Context context;

    public HomeHotRecyAdapter(List<HomeHotBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_fill_recy, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final HomeHotBean.DataBean dataBean = list.get(position);

        Glide.with(context).load(dataBean.getHeadImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.home_HeadImg);
        holder.home_likeText.setText(dataBean.getLikeNum());
        holder.home_ChallengeText.setText(dataBean.getChallengeFlag());
        holder.home_describe.setText(dataBean.getDescription());
        holder.home_commentText.setText(dataBean.getCommentNum());
        //初始化热门页的RecylerView中的RecylerView
        HomeHotRecyItemAdapter homeHotRecyItemAdapter = new HomeHotRecyItemAdapter(dataBean.getPageDtoList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.home_Recy_fill_Recy.setLayoutManager(layoutManager);
        if (dataBean.getPageDtoList().size() == 1) {
            holder.home_Recy_fill_Recy.setVisibility(View.GONE);
            Glide.with(context).load(dataBean.getPageDtoList().get(0).getImageUrl()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.home_recy_fill_recyImg);
            holder.home_recy_fill_recyImg.setVisibility(View.VISIBLE);
        } else {
            holder.home_Recy_fill_Recy.setVisibility(View.VISIBLE);
            holder.home_recy_fill_recyImg.setVisibility(View.GONE);
        }


        if (null != dataBean.getPageDtoList() && dataBean.getPageDtoList().size() > 2) {//dataBean.getHeight() > screenHeight
            double i = (double) dataBean.getHeight() / dataBean.getWidth();
            double a = i * (double) ScreenUtils.getScreenWidth(context);
            holder.home_fillView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ((int) a)));//如果图片list高度确定超过一屏幕高度
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            layoutParams.gravity = Gravity.CENTER_HORIZONTAN|Gravity.CENTER_VERTICAL;
            holder.home_fillView.setLayoutParams(layoutParams);

        }


        holder.home_Recy_fill_Recy.setAdapter(homeHotRecyItemAdapter);
        holder.home_UserNameText.setText("@ " + dataBean.getName());
        if (dataBean.isLike()) {
            holder.home_likeImg.setButtonDrawable(R.mipmap.like_13);
        } else {
            holder.home_likeImg.setButtonDrawable(R.mipmap.unlike_04);
        }
        holder.home_likeImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (dataBean.isLike()) {
                    if (holder.home_likeImg.isChecked()) {
                        holder.home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    } else {
                        holder.home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    }

                } else {
                    if (holder.home_likeImg.isChecked()) {
                        holder.home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    } else {
                        holder.home_likeImg.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.home_likeImg.getButtonDrawable();
                        animationDrawable.start();
                    }

                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
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
        private ImageView home_recy_fill_recyImg;


        public Holder(View itemView) {
            super(itemView);
            home_Recy_fill_Recy = itemView.findViewById(R.id.home_Recy_fill_Recy);
            home_HeadImg = itemView.findViewById(R.id.home_HeadImg);
            home_follow = itemView.findViewById(R.id.home_follow);
            home_like = itemView.findViewById(R.id.home_like);
            home_likeImg = itemView.findViewById(R.id.home_likeImg);
            home_comment = itemView.findViewById(R.id.home_comment);
            home_commentText = itemView.findViewById(R.id.home_commentText);
            home_share = itemView.findViewById(R.id.home_share);
            home_edit = itemView.findViewById(R.id.home_edit);
            home_edit_Image = itemView.findViewById(R.id.home_edit_Image);
            home_ChallengeText = itemView.findViewById(R.id.home_ChallengeText);
            home_UserNameText = itemView.findViewById(R.id.home_UserNameText);
            home_describe = itemView.findViewById(R.id.home_describe);
            home_fillView = itemView.findViewById(R.id.home_fillView);
//            home_ProgressBar = itemView.findViewById(R.id.home_ProgressBar);
            home_likeText = itemView.findViewById(R.id.home_likeText);
            Home_footView = itemView.findViewById(R.id.Home_footView);
            home_recy_fill_recyImg = itemView.findViewById(R.id.home_Recy_fill_RecyImg);
            AutoUtils.autoSize(itemView);
        }
    }
}
