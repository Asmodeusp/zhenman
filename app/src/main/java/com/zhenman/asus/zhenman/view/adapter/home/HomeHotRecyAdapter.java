package com.zhenman.asus.zhenman.view.adapter.home;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.presenter.HomeHotPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.ui.MyScrollView;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.MyLayoutMessage;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;
import com.zhy.autolayout.AutoLinearLayout;

import org.w3c.dom.Text;

import java.util.List;

public class HomeHotRecyAdapter extends RecyclerView.Adapter<HomeHotRecyAdapter.Holder> {
    private List<HomeHotBean.DataBean> list;
    private Context context;
    ViewPagerLayoutManager linearLayoutManager;
    RecyclerView homeHot_list;
    HomeHotPresenterImp presenter;
    public HomeHotRecyAdapter(List<HomeHotBean.DataBean> list, ViewPagerLayoutManager linearLayoutManager, RecyclerView homeHot_list, HomeHotPresenterImp presenter) {
        this.list = list;
        this.linearLayoutManager = linearLayoutManager;
        this.homeHot_list = homeHot_list;
        this.presenter = presenter;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_fill_recy, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        final HomeHotBean.DataBean dataBean = list.get(position);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenHeight(context));
//        holder.home_fillView.setLayoutParams(layoutParams);
        final MyLayoutMessage myLayoutMessage = new MyLayoutMessage(context);
        final HomeHotRecyItemAdapter homeHotRecyItemAdapter = new HomeHotRecyItemAdapter(dataBean.getPageDtoList());
        holder.home_Recy_fill_Recy.setLayoutManager(myLayoutMessage);
        holder.home_Recy_fill_Recy.setAdapter(homeHotRecyItemAdapter);
        //计算填充Recycler View高度
        double i = (double) dataBean.getHeight() / dataBean.getWidth();
        double InsideHight = i * (double) ScreenUtils.getScreenWidth(context);
        linearLayoutManager.setScrollEnabled(false);
//        //内部滑动监听
//        holder.home_Recy_fill_Recy.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                //得到当前显示的第一个item的view
//                View firstChildView = recyclerView.getLayoutManager().getChildAt(0);
//                //得到firstChildView的Top坐标值
//                int firstChildTop = firstChildView.getTop();
//                //得到Recyclerview的顶坐标减去顶部padding值，也就是显示内容最顶部的坐标
//                int recyclerTop = recyclerView.getTop() - recyclerView.getPaddingTop();
//                //通过这个firstChildView得到这个view当前的position值
//                int firstPosition = recyclerView.getLayoutManager().getPosition(firstChildView);
//                /*
//                 * home_Recy_fill_Recy(里面填充的RecyclerView)
//                 * 向下滑动
//                 *
//                 * **/
//                if (dy > 0) {
//                }
//                //得到当前显示的最后一个item的view
//                View lastChildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
//                //得到lastChildView的bottom坐标值
//                int lastChildBottom = lastChildView.getBottom();
//                //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
//                int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
//                //通过这个lastChildView得到这个view当前的position值
//                int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);
//                if (lastChildBottom != recyclerBottom && lastPosition != recyclerView.getLayoutManager().getItemCount() - 1) {
//                    linearLayoutManager.setScrollEnabled(false);
//                }
//
//
//                /*
//                 *   当里面向上滑动时
//                 *       开启里面滑动
//                 *       关闭外层滑动
//                 * **/
//                if (dy < 0) {
//                    linearLayoutManager.setScrollEnabled(false);
//                }
////
////                    /*
////                     *   当里面向下滑动时
////                     *       开启里面滑动
////                     *       关闭外层滑动
////                     * **/
//                if (dy > 0) {
//                    linearLayoutManager.setScrollEnabled(false);
//                }
//
//
//                if(dy == 0){
//                }
//
//
//                //如果两个条件都满足则说明是真正的滑动到了底部
//                if (lastChildBottom == recyclerBottom && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1  && dy > 0) {
//
//
//
//
//
//                }
//
//                //如果两个条件都满足则说明是真正的滑动到了顶部
//                else if (firstChildTop == recyclerTop && firstPosition == 0 && dy < 0) {
//
//
//                }else{
//                    if(!list.get(position).isOpenSwich){
//                        list.get(position).isOpenSwich = true;
//                    }
//
//                }
//            }
//        });
        //加载头像圆形图片
        GlideUtils.loadCircleImage(dataBean.getHeadImg(), holder.Home_Hot_HeadImageView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
//                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        });
        holder.Home_Hot_HeadImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomepageActivity.class);
                intent.putExtra("UserId",dataBean.getUserId());
                context.startActivity(intent);
            }
        });
        //设置喜欢点赞数量
        holder.Home_Hot_IsLikeNumberText.setText(dataBean.getLikeNum());
        //设置主题名称
        if (dataBean.getSubjectName() != null) {
            holder.Home_Hot_ThemText.setText("" + dataBean.getSubjectName());
        } else {
            holder.Home_Hot_ThemLin.setVisibility(View.GONE);
        }
        //设置描述文字
        holder.Home_Hot_describeText.setText(dataBean.getDescription());
        //设置评论数量
        holder.Home_Hot_CommentNumberText.setText(dataBean.getCommentNum());
        if (dataBean.getPageDtoList().size() == 1) {
            holder.home_Recy_fill_Recy.setVisibility(View.GONE);
            Glide.with(context).load(dataBean.getPageDtoList().get(0).getImageUrl()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.Home_Recy_OneImage);
            holder.Home_Recy_OneImage.setVisibility(View.VISIBLE);
        } else {
            holder.home_Recy_fill_Recy.setVisibility(View.VISIBLE);
            holder.Home_Recy_OneImage.setVisibility(View.GONE);
        }
        holder.home_Recy_fill_Recy.setAdapter(homeHotRecyItemAdapter);
        //设置用户名
        holder.Home_Hot_UserNameText.setText("@ " + dataBean.getName());
        //在创作
        if (dataBean.isReCreate()) {
            holder.Home_Hot_EditImageView.setImageResource(R.mipmap.edit_pen_off);
        } else {
            holder.Home_Hot_EditImageView.setImageResource(R.mipmap.edit_pen_on);
        }
        //喜欢点赞
        if (dataBean.isLike()) {
            holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.mipmap.like_13);
        } else {
            holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.mipmap.unlike_04);
        }
        //点赞喜欢点击
        holder.Home_Hot_IsLikeImageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (dataBean.isLike()) {
                    if (holder.Home_Hot_IsLikeImageView.isChecked()) {
                        holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                        animationDrawable.start();
                        presenter.UgcFabulous(dataBean.getId(),"0");
                        holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(position).getLikeNum()) - 1 + "");
                    } else {
                        holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                        animationDrawable.start();
                        holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(position).getLikeNum()) + "");
                    }

                } else {
                    if (holder.Home_Hot_IsLikeImageView.isChecked()) {
                        holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_like);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                        animationDrawable.start();
                        presenter.UgcFabulous(dataBean.getId(),"1");
                        holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(position).getLikeNum()) + 1 + "");
                    } else {
                        holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                        AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                        animationDrawable.start();
                        holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(position).getLikeNum()) + "");
                    }

                }
            }
        });
        //评论点击事件
        holder.Home_Hot_CommentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //滑动跟换条目
        holder.Home_Hot_Page_turningScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
        //关注的按钮

        if (dataBean.isFollow()) {
            holder.Home_Hot_FollowCheckBox.setVisibility(View.GONE);
        }else{
            holder.Home_Hot_FollowCheckBox.setVisibility(View.VISIBLE);
            holder.Home_Hot_FollowCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (holder.Home_Hot_FollowCheckBox.isChecked()) {
                        presenter.FollowUser(dataBean.getUserId(),"1");
                        holder.Home_Hot_FollowCheckBox.setVisibility(View.GONE);
                    }
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        //RecyclerView
        public RecyclerView home_Recy_fill_Recy;
        //整个布局ID
        private RelativeLayout home_fillView;
        //ScrollView
        private MyScrollView Home_Hot_Page_turningScrollView;
        //加载一张图片
        private ImageView Home_Recy_OneImage;
        //头像
        private ImageView Home_Hot_HeadImageView;
        //关注
        private CheckBox Home_Hot_FollowCheckBox;
        //喜欢点赞
        private CheckBox Home_Hot_IsLikeImageView;
        //喜欢点赞数
        private TextView Home_Hot_IsLikeNumberText;
        //评论
        private ImageView Home_Hot_CommentImageView;
        //评论数
        private TextView Home_Hot_CommentNumberText;
        //分享
        private ImageView Home_Hot_ShareImageView;
        //在创作
        private ImageView Home_Hot_EditImageView;
        //主题
        private TextView Home_Hot_ThemText;
        //用户名
        private TextView Home_Hot_UserNameText;
        //作评描述
        private TextView Home_Hot_describeText;
        //主题描述
        private AutoLinearLayout Home_Hot_ThemLin;

        public Holder(View itemView) {
            super(itemView);
            home_Recy_fill_Recy = itemView.findViewById(R.id.home_Recy_fill_Recy);
            Home_Hot_Page_turningScrollView = itemView.findViewById(R.id.Home_Hot_Page_turningScrollView);
            home_fillView = itemView.findViewById(R.id.home_fillView);
            Home_Recy_OneImage = itemView.findViewById(R.id.Home_Recy_OneImage);
            Home_Hot_HeadImageView = itemView.findViewById(R.id.Home_Hot_HeadImageView);
            Home_Hot_FollowCheckBox = itemView.findViewById(R.id.Home_Hot_FollowCheckBox);
            Home_Hot_IsLikeImageView = itemView.findViewById(R.id.Home_Hot_IsLikeImageView);
            Home_Hot_IsLikeNumberText = itemView.findViewById(R.id.Home_Hot_IsLikeNumberText);
            Home_Hot_CommentImageView = itemView.findViewById(R.id.Home_Hot_CommentImageView);
            Home_Hot_CommentNumberText = itemView.findViewById(R.id.Home_Hot_CommentNumberText);
            Home_Hot_ShareImageView = itemView.findViewById(R.id.Home_Hot_ShareImageView);
            Home_Hot_EditImageView = itemView.findViewById(R.id.Home_Hot_EditImageView);
            Home_Hot_ThemText = itemView.findViewById(R.id.Home_Hot_ThemText);
            Home_Hot_UserNameText = itemView.findViewById(R.id.Home_Hot_UserNameText);
            Home_Hot_describeText = itemView.findViewById(R.id.Home_Hot_describeText);
            Home_Hot_ThemLin = itemView.findViewById(R.id.Home_Hot_ThemLin);

        }
    }
}
