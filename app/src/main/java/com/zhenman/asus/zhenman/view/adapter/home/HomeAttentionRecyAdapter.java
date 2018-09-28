package com.zhenman.asus.zhenman.view.adapter.home;

import android.content.Context;
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
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;


public class HomeAttentionRecyAdapter extends RecyclerView.Adapter<HomeAttentionRecyAdapter.Holder> {
    private List<HomeAttentionBean.DataBean.ResultBean> list;
    private Context context;

    public HomeAttentionRecyAdapter(List<HomeAttentionBean.DataBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_home_attentionrecy, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        HomeAttentionBean.DataBean.ResultBean dataBean = list.get(position);
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
        if (dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()<=216/332) {
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxHeight*216/332,MaxHeight));
//            holder.fill_Home_Attention_RecyImageView.setScaleType(ImageView.ScaleType.FIT_START);
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            //超过一屏宽图
        }else if (dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()>=332/216) {
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth,dataBean.getThumbnailWidth()*332/216));
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            //大于216/332的长图
        }else  if(dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()<1){
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(((int) (dataBean.getThumbnailHeight()*dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight())),MaxHeight));
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
            //小于332/216的图
        }else if(dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()>1){
            holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth,((int)(dataBean.getThumbnailWidth()/dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()))));
            Glide.with(context).load(dataBean.getImgList().get(0).getThumbnailImg()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.fill_Home_Attention_RecyImageView);
        }else{

            if (dataBean.getThumbnailWidth()<MaxWidth*0.65) {
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams((int)(MaxWidth*0.65),(int)(MaxHeight*0.65)));
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth,((int)(dataBean.getThumbnailWidth()/dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()))));
            }else {
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth,MaxHeight));
                holder.fill_Home_Attention_RecyImageView.setLayoutParams(new LinearLayout.LayoutParams(MaxWidth,((int)(dataBean.getThumbnailWidth()/dataBean.getThumbnailWidth()/dataBean.getThumbnailHeight()))));
            }
        }
        //居中不缩放
//        holder.fill_Home_Attention_RecyImageViewImageView.setScaleType(ImageView.ScaleType.CENTER);
        //设置用户名
        holder.fill_Home_Attention_RecyUserNameText.setText(dataBean.getName());
        //设置发布时间
        holder.fill_Home_Attention_RecyTimeText.setText(SPUtils.transferLongToDate(Long.parseLong(dataBean.getAddTime())));
        //设置描述
        holder.fill_Home_Attention_RecyDescriptionText.setText(dataBean.getDescription());
        //设置分享数量
        holder.fill_Home_Attention_RecyShareNumberText.setText(dataBean.getShareNum()+"");
        //设置评论数量
        holder.fill_Home_Attention_RecyCommentNumberText.setText(dataBean.getCommentNum()+"");
        //设置喜欢数量
        holder.fill_Home_Attention_RecyLikeNumberText.setText(dataBean.getLikeNum()+"");
        //分享点击事件
        holder.fill_Home_Attention_RecyShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //消息点击事件
        holder.fill_Home_Attention_RecyCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //喜欢点击事件
        holder.fill_Home_Attention_RecyLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            AutoUtils.autoSize(itemView);
        }
    }
}
