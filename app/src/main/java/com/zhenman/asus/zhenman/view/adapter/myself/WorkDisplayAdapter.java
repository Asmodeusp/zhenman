package com.zhenman.asus.zhenman.view.adapter.myself;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.zhenman.asus.zhenman.model.bean.ResultBean;
import com.zhenman.asus.zhenman.presenter.WorkDisplayPresenter;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.utils.umeng.UMengHelp;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.ui.MyRecyclerView;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.MyLayoutMessage;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

public class WorkDisplayAdapter extends RecyclerView.Adapter<WorkDisplayAdapter.Holder> {
    private List<ResultBean> list;
    private Context context;
    private MyRecyclerView homeHot_list;
    private WorkDisplayPresenter workDisplayPresenter;
    private int position = -1;
    private boolean count = true;

    public WorkDisplayAdapter(List<ResultBean> list, Context context, MyRecyclerView homeHot_list, WorkDisplayPresenter workDisplayPresenter) {
        this.list = list;
        this.context = context;
        this.homeHot_list = homeHot_list;
        this.workDisplayPresenter = workDisplayPresenter;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_fill_recy, null);
        Holder holder = new Holder(inflate);
        return holder;

    }

    private goUserInfo clickZan;

    public interface goUserInfo {
        void go(String UserId);
    }

    public void setgoUserInfo(goUserInfo clickZan) {
        this.clickZan = clickZan;
    }

    private BouncingComment bouncingComment;

    public void setBouncingComment(BouncingComment comment) {
        this.bouncingComment = comment;
    }

    public interface BouncingComment {
        void getComment(String UgcId, int Type);
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        if (this.position != i) {
            holder.Home_Hot_Page_turningLinearLayout.setVisibility(View.VISIBLE);
            holder.Home_Hot_describeText.setVisibility(View.VISIBLE);
            holder.Home_Hot_UserNameText.setVisibility(View.VISIBLE);
            holder.Home_Hot_ThemLin.setVisibility(View.VISIBLE);
        }
        final ResultBean dataBean = list.get(i);
        double i1 = (double) dataBean.getHeight() / dataBean.getWidth();
        double InsideHight = i1 * (double) ScreenUtils.getScreenWidth(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenHeight(context));
        holder.home_fillView.setLayoutParams(layoutParams);
        final MyLayoutMessage myLayoutMessage = new MyLayoutMessage(context);
        List<ResultBean.PageDtoListBean> pageDtoList = dataBean.getPageDtoList();
        final WorkDisplayItemAdapter homeHotRecyItemAdapter = new WorkDisplayItemAdapter(pageDtoList);
        holder.home_Recy_fill_Recy.setLayoutManager(myLayoutMessage);
        holder.home_Recy_fill_Recy.setAdapter(homeHotRecyItemAdapter);
        homeHot_list.setInnerListView(holder.home_Recy_fill_Recy);
        homeHot_list.getItemAnimator().setAddDuration(0);
        homeHot_list.getItemAnimator().setChangeDuration(0);
        homeHot_list.getItemAnimator().setMoveDuration(0);
        homeHot_list.getItemAnimator().setRemoveDuration(0);
        ((SimpleItemAnimator) homeHot_list.getItemAnimator()).setSupportsChangeAnimations(false);
        ((SimpleItemAnimator) holder.home_Recy_fill_Recy.getItemAnimator()).setSupportsChangeAnimations(false);
        myLayoutMessage.setRecycleChildrenOnDetach(true);
        holder.Home_Hot_Page_turningLinearLayout.setVisibility(View.VISIBLE);
        holder.Home_Hot_describeText.setVisibility(View.VISIBLE);
        holder.Home_Hot_UserNameText.setVisibility(View.VISIBLE);
        holder.Home_Hot_ThemLin.setVisibility(View.VISIBLE);
        homeHotRecyItemAdapter.setRecyclerViewOnCLickListener(new WorkDisplayItemAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view) {
                if (count) {
                    holder.Home_Hot_Page_turningLinearLayout.setVisibility(View.INVISIBLE);
                    holder.Home_Hot_describeText.setVisibility(View.INVISIBLE);
                    holder.Home_Hot_UserNameText.setVisibility(View.INVISIBLE);
                    holder.Home_Hot_ThemLin.setVisibility(View.INVISIBLE);
                    count = false;
                } else {
                    holder.Home_Hot_Page_turningLinearLayout.setVisibility(View.VISIBLE);
                    holder.Home_Hot_describeText.setVisibility(View.VISIBLE);
                    holder.Home_Hot_UserNameText.setVisibility(View.VISIBLE);
                    holder.Home_Hot_ThemLin.setVisibility(View.VISIBLE);
                    count = true;
                }

            }
        });
        //内部滑动监听
        holder.home_Recy_fill_Recy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /*  newState 滑动状态
             * **/
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                switch (newState) {
                    //手指滑动
                    case SCROLL_STATE_DRAGGING:
                        count = false;
                        holder.Home_Hot_Page_turningLinearLayout.setVisibility(View.INVISIBLE);
                        holder.Home_Hot_describeText.setVisibility(View.INVISIBLE);
                        holder.Home_Hot_UserNameText.setVisibility(View.INVISIBLE);
                        holder.Home_Hot_ThemLin.setVisibility(View.INVISIBLE);
                        break;
                    //自由滑动
                    case SCROLL_STATE_SETTLING:
                        count = false;
                        holder.Home_Hot_Page_turningLinearLayout.setVisibility(View.INVISIBLE);
                        holder.Home_Hot_describeText.setVisibility(View.INVISIBLE);
                        holder.Home_Hot_UserNameText.setVisibility(View.INVISIBLE);
                        holder.Home_Hot_ThemLin.setVisibility(View.INVISIBLE);
                        break;
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        //加载头像圆形图片
        GlideUtils.loadCircleImage(dataBean.getHeadImg(), holder.Home_Hot_HeadImageView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {
            }

            @Override
            public void onLoadingError(String source, Exception e) {
            }
        }, R.mipmap.common_portrait_m);
        holder.Home_Hot_HeadImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickZan.go(dataBean.getUserId() + "");
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
            holder.Home_Hot_EditImageView.setImageResource(R.mipmap.home_edit);
        } else {
            holder.Home_Hot_EditImageView.setImageResource(R.mipmap.edit_filter_beautyoff);
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
                Boolean ISlogin = (Boolean) SPUtils.get(context, SPKey.IS_LOGIN, false);
                if (!ISlogin) {
                    context.startActivity(new Intent(context, MainActivity.class));
                    ((Activity) context).finish();
                } else {
                    if (dataBean.isLike()) {
                        if (holder.Home_Hot_IsLikeImageView.isChecked()) {
                            holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                            AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                            animationDrawable.start();
                            workDisplayPresenter.UgcFabulous(dataBean.getId(), "0");
                            holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(i).getLikeNum()) - 1 + "");
                        } else {
                            holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_like);
                            AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                            animationDrawable.start();
                            holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(i).getLikeNum()) + "");
                        }

                    } else {
                        if (holder.Home_Hot_IsLikeImageView.isChecked()) {
                            holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_like);
                            AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                            animationDrawable.start();
                            workDisplayPresenter.UgcFabulous(dataBean.getId(), "1");
                            holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(i).getLikeNum()) + 1 + "");
                        } else {
                            holder.Home_Hot_IsLikeImageView.setButtonDrawable(R.drawable.hot_guanzhu_unlike);
                            AnimationDrawable animationDrawable = (AnimationDrawable) holder.Home_Hot_IsLikeImageView.getButtonDrawable();
                            animationDrawable.start();
                            holder.Home_Hot_IsLikeNumberText.setText(Integer.parseInt(list.get(i).getLikeNum()) + "");
                        }
                    }
                }

            }
        });
        //评论点击事件
        holder.Home_Hot_CommentImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bouncingComment.getComment(dataBean.getId(), dataBean.getType());
            }
        });
        holder.Home_Hot_Page_turningLinearLayout.setOnGenericMotionListener(new View.OnGenericMotionListener() {
            @Override
            public boolean onGenericMotion(View v, MotionEvent event) {
                return false;
            }
        });
        //滑动跟换条目
        holder.Home_Hot_Page_turningLinearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int newY = 0;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("HomeHotRecyAdapter", "ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("HomeHotRecyAdapter", "ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("HomeHotRecyAdapter", "ACTION_UP");
                        break;

                }
                return false;
            }
        });

        //关注的按钮
        if (dataBean.isFollow()) {
            holder.Home_Hot_FollowCheckBox.setVisibility(View.GONE);
        } else {
            holder.Home_Hot_FollowCheckBox.setVisibility(View.VISIBLE);
            holder.Home_Hot_FollowCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.Home_Hot_FollowCheckBox.isChecked()) {
                        Boolean ISlogin = (Boolean) SPUtils.get(context, SPKey.IS_LOGIN, false);
                        if (!ISlogin) {
                            context.startActivity(new Intent(context, MainActivity.class));
                            ((Activity) context).finish();
                        } else {
                            workDisplayPresenter.FollowUser(dataBean.getUserId(), "1");
                            holder.Home_Hot_FollowCheckBox.setVisibility(View.GONE);
                        }
                    }
                }
            });
        }
        //分享
        holder.Home_Hot_ShareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataBean.getShareImg() != null) {
                    UMengHelp.shareImg((Activity) context, (String) dataBean.getShareImg(), true);
                } else {

                }
            }
        });
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
        private AutoRelativeLayout Home_Hot_Page_turningLinearLayout;
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
        private AutoRelativeLayout Home_Hot_ThemLin;

        public Holder(View itemView) {
            super(itemView);
            home_Recy_fill_Recy = itemView.findViewById(R.id.home_Recy_fill_Recy);
            Home_Hot_Page_turningLinearLayout = itemView.findViewById(R.id.Home_Hot_Page_turningLinearLayout);
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
