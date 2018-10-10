package com.zhenman.asus.zhenman.view.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.presenter.HomeAttentionPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.message.ThemeDetailsActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


public class HomeAttentionRecyAdapter extends RecyclerView.Adapter<HomeAttentionRecyAdapter.Holder> {
    private List<HomeAttentionBean.DataBean.ResultBean> list;
    private Context context;
    private boolean count = true;
    private HomeAttentionPresenterImp presenter;

    public HomeAttentionRecyAdapter(List<HomeAttentionBean.DataBean.ResultBean> list, HomeAttentionPresenterImp presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_home_attentionrecy, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    private ClickShow clickShow;

    public void setClickShow(ClickShow clickShow) {
        this.clickShow = clickShow;
    }

    public interface ClickShow {
        void show(HomeAttentionBean.DataBean.ResultBean resultBean);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        final HomeAttentionBean.DataBean.ResultBean dataBean = list.get(position);

        //加载头像圆形图片
        GlideUtils.loadCircleImage(dataBean.getHeadImg(), holder.fill_Home_Attention_RecyHeadIew, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
            }
        });
        //图片加载最大宽度
        int MaxWidth = ScreenUtils.getScreenWidth(context) * 2 / 3;
        //图片加载最大高度
        int MaxHeight = MaxWidth;
        //超过一屏长图
        if (dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight() <= 216 / 332) {
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxHeight * 216 / 332, MaxHeight));
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            //超过一屏宽图
        } else if (dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight() >= 332 / 216) {
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth, dataBean.getThumbnailWidth() * 332 / 216));
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            //大于216/332的长图
        } else if (dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight() < 1) {
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(((int) (dataBean.getThumbnailHeight() * dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight())), MaxHeight));
            holder.fill_Home_Attention_RecyImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            //小于332/216的图
        } else if (dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight() > 1) {
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth, ((int) (dataBean.getThumbnailWidth() / dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight()))));
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
        } else {

            if (dataBean.getThumbnailWidth() < MaxWidth * 0.65) {
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams((int) (MaxWidth * 0.65), (int) (MaxHeight * 0.65)));
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth, ((int) (dataBean.getThumbnailWidth() / dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight()))));
                Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            } else {

                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth, MaxHeight));
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth, ((int) (dataBean.getThumbnailWidth() / dataBean.getThumbnailWidth() / dataBean.getThumbnailHeight()))));
                Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            }
        }

        //设置用户名
        holder.fill_Home_Attention_RecyUserNameText.setText(dataBean.getName());
        //设置发布时间
        holder.fill_Home_Attention_RecyTimeText.setText(SPUtils.transferLongToDate(Long.parseLong(dataBean.getAddTime())));
        //设置描述
        holder.fill_Home_Attention_RecyDescriptionText.setText(dataBean.getDescription());
        //设置分享数量
        holder.fill_Home_Attention_RecyShareNumberText.setText(dataBean.getShareNum() + "");
        //设置评论数量
        holder.fill_Home_Attention_RecyCommentNumberText.setText(dataBean.getCommentNum() + "");
        //设置喜欢数量
        holder.fill_Home_Attention_RecyLikeNumberText.setText(dataBean.getLikeNum() + "");
        //分享点击事件
        holder.fill_Home_Attention_RecyShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //加载作品图片
        holder.fill_Home_Attention_RecyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickShow.show(list.get(position));
            }
        });
        //消息点击事件
        holder.fill_Home_Attention_RecyCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //设置喜欢图片
        if (list.get(position).isLike()) {
            holder.fill_Home_Attention_RecyLikeImageView.setImageResource(R.mipmap.guanzhu_like_on);
            //喜欢点击事件
            holder.fill_Home_Attention_RecyLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count) {
                        holder.fill_Home_Attention_RecyLikeImageView.setImageResource(R.mipmap.guanzhu_like_off);
                        holder.fill_Home_Attention_RecyLikeNumberText.setText(dataBean.getLikeNum() - 1 + "");
                        if (list.get(position).getType() == 1) {
                            presenter.UgcFabulous(list.get(position).getUgcDynamicDto().getUgcId(), "0");
                        }
                        if (list.get(position).getType() == 2) {
                            presenter.PgcCollection(list.get(position).getPgcDynamicDto().getCatalogId(), "0");
                        }
                        count = false;
                    } else {
                        holder.fill_Home_Attention_RecyLikeImageView.setImageResource(R.mipmap.guanzhu_like_on);
                        holder.fill_Home_Attention_RecyLikeNumberText.setText(dataBean.getLikeNum() + "");
                        if (list.get(position).getType() == 1) {
                            presenter.UgcFabulous(list.get(position).getUgcDynamicDto().getUgcId(), "1");
                        }
                        if (list.get(position).getType() == 2) {
                            presenter.PgcCollection(list.get(position).getPgcDynamicDto().getCatalogId(), "1");
                        }
                        count = true;
                    }

                }
            });
        } else {
            holder.fill_Home_Attention_RecyLikeImageView.setImageResource(R.mipmap.guanzhu_like_off);
            //喜欢点击事件
            holder.fill_Home_Attention_RecyLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count) {
                        holder.fill_Home_Attention_RecyLikeImageView.setImageResource(R.mipmap.guanzhu_like_on);
                        holder.fill_Home_Attention_RecyLikeNumberText.setText(dataBean.getLikeNum() + 1 + "");
                        if (list.get(position).getType() == 1) {
                            presenter.UgcFabulous(list.get(position).getUgcDynamicDto().getUgcId(), "1");
                        }
                        if (list.get(position).getType() == 2) {
                            presenter.PgcCollection(list.get(position).getPgcDynamicDto().getCatalogId(), "1");
                        }
                        count = false;
                    } else {
                        holder.fill_Home_Attention_RecyLikeImageView.setImageResource(R.mipmap.guanzhu_like_off);
                        holder.fill_Home_Attention_RecyLikeNumberText.setText(dataBean.getLikeNum() + "");
                        if (list.get(position).getType() == 1) {
                            presenter.UgcFabulous(list.get(position).getUgcDynamicDto().getUgcId(), "0");
                        }
                        if (list.get(position).getType() == 2) {
                            presenter.PgcCollection(list.get(position).getPgcDynamicDto().getCatalogId(), "0");
                        }
                        count = true;
                    }

                }
            });

        }

        //设置主题是否显示
        if (list.get(position).getUgcDynamicDto().getSubjectId() == null) {
            holder.fill_Home_Attention_RecyThemLin.setVisibility(View.GONE);
        } else {
            holder.fill_Home_Attention_RecyThemLin.setVisibility(View.VISIBLE);
            holder.fill_Home_Attention_RecyThemText.setText(list.get(position).getUgcDynamicDto().getSubjectName());
        }
        //点击主题跳转主题页
        holder.fill_Home_Attention_RecyThemLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ThemeDetailsActivity.class);
                intent.putExtra("SubjectId", dataBean.getUgcDynamicDto().getSubjectId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        //头像
        private ImageView fill_Home_Attention_RecyHeadIew;
        //用户名
        private TextView fill_Home_Attention_RecyUserNameText;
        //发布时间
        private TextView fill_Home_Attention_RecyTimeText;
        //描述
        private TextView fill_Home_Attention_RecyDescriptionText;
        //作评图片
        private ImageView fill_Home_Attention_RecyImageView;
        //分享按钮
        private AutoLinearLayout fill_Home_Attention_RecyShareButton;
        //评论按钮
        private AutoLinearLayout fill_Home_Attention_RecyCommentButton;
        //点赞按钮
        private AutoLinearLayout fill_Home_Attention_RecyLikeButton;
        //分享数量
        private TextView fill_Home_Attention_RecyShareNumberText;
        //评论数量
        private TextView fill_Home_Attention_RecyCommentNumberText;
        //喜欢数量
        private TextView fill_Home_Attention_RecyLikeNumberText;
        //喜欢图片
        private ImageView fill_Home_Attention_RecyLikeImageView;
        //主题名字
        private TextView fill_Home_Attention_RecyThemText;
        //主题AutoRelativeLayout
        private AutoRelativeLayout fill_Home_Attention_RecyThemLin;

        public Holder(View itemView) {
            super(itemView);
            //头像
            fill_Home_Attention_RecyHeadIew = itemView.findViewById(R.id.fill_Home_Attention_RecyHeadImageView);
            //用户名
            fill_Home_Attention_RecyUserNameText = itemView.findViewById(R.id.fill_Home_Attention_RecyUserNameText);
            //发布时间
            fill_Home_Attention_RecyTimeText = itemView.findViewById(R.id.fill_Home_Attention_RecyTimeText);
            //描述
            fill_Home_Attention_RecyDescriptionText = itemView.findViewById(R.id.fill_Home_Attention_RecyDescriptionText);
            //作评图片
            fill_Home_Attention_RecyImageView = itemView.findViewById(R.id.fill_Home_Attention_RecyImageView);
            //分享按钮
            fill_Home_Attention_RecyShareButton = itemView.findViewById(R.id.fill_Home_Attention_RecyShareButton);
            //评论按钮
            fill_Home_Attention_RecyCommentButton = itemView.findViewById(R.id.fill_Home_Attention_RecyCommentButton);
            //点赞按钮
            fill_Home_Attention_RecyLikeButton = itemView.findViewById(R.id.fill_Home_Attention_RecyLikeButton);
            //分享数量
            fill_Home_Attention_RecyShareNumberText = itemView.findViewById(R.id.fill_Home_Attention_RecyShareNumberText);
            //评论数量
            fill_Home_Attention_RecyCommentNumberText = itemView.findViewById(R.id.fill_Home_Attention_RecyCommentNumberText);
            //喜欢数量
            fill_Home_Attention_RecyLikeNumberText = itemView.findViewById(R.id.fill_Home_Attention_RecyLikeNumberText);
            //喜欢图片
            fill_Home_Attention_RecyLikeImageView = itemView.findViewById(R.id.fill_Home_Attention_RecyLikeImageView);
            //主题名字
            fill_Home_Attention_RecyThemText = itemView.findViewById(R.id.fill_Home_Attention_RecyThemText);
            //主题AutoRelativeLayout
            fill_Home_Attention_RecyThemLin = itemView.findViewById(R.id.fill_Home_Attention_RecyThemLin);
            AutoUtils.autoSize(itemView);
        }
    }
}
