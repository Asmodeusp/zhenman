package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentListByOffSetBean;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;
import com.zhenman.asus.zhenman.presenter.SerializationCatalogReadPresenterImp;
import com.zhenman.asus.zhenman.presenter.WorkDetailsCommentPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


public class CatalogFootviewCommentRecyAdapter extends RecyclerView.Adapter<CatalogFootviewCommentRecyAdapter.Holder> implements View.OnClickListener {
    private List<PgcChapterCommentListByOffSetBean.DataBean.CommentDtoListBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    String productId;
    SerializationCatalogReadPresenterImp presenter;

    public CatalogFootviewCommentRecyAdapter(List<PgcChapterCommentListByOffSetBean.DataBean.CommentDtoListBean> list, String productId, SerializationCatalogReadPresenterImp presenter) {
        this.list = list;
        this.productId = productId;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_work_commentrecy_adapter, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }

    }

    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        holder.Work_commentRecy_Comment.setText(list.get(position).getContent());
        //设置头像
        holder.Work_commentRecy_HeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomepageActivity.class);
                SPUtils.put(context, SPKey.HIM_ID,list.get(position).getUserId());
                context.startActivity(intent);
            }
        });
        GlideUtils.loadCircleImage(list.get(position).getImageUrl(), holder.Work_commentRecy_HeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
            }
        });

        holder.Work_commentRecy_Time.setText(SPUtils.transferLongToDate(Long.parseLong(list.get(position).getAddTime())));
        holder.Work_commentRecy_LikeNumber.setText(list.get(position).getLikeNum());
        if (list.get(position).isLike()) {
            holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);

        } else {
            holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);

        }
        if (list.get(position).isLike()) {

            holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
            holder.Work_commentRecy_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.Work_commentRecy_Like.isChecked()) {
                        holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        if (clickZan != null) {
                            clickZan.zan(list.get(position).getCommentId(), "0", "");
//                        presenter.PGCReadFabulous(productId, list.get(position).getCommentId(), "0", "");
                        }
                        holder.Work_commentRecy_LikeNumber.setText(Integer.parseInt(list.get(position).getLikeNum()) - 1 + "");
                    } else {
                        if (clickZan != null) {
                            clickZan.zan(list.get(position).getCommentId(), "1", "");
                        }
//                        presenter.PGCReadFabulous(productId, list.get(position).getCommentId(), "1", "");
                        holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        holder.Work_commentRecy_LikeNumber.setText(Integer.parseInt(list.get(position).getLikeNum()) + "");
                    }
                }
            });
        } else {
            holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
            holder.Work_commentRecy_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.Work_commentRecy_Like.isChecked()) {
                        if (clickZan != null) {
                            clickZan.zan(list.get(position).getCommentId(), "1", "");
                        }
//                        presenter.PGCReadFabulous(productId, list.get(position).getCommentId(), "1", "");
                        holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        holder.Work_commentRecy_LikeNumber.setText(Integer.parseInt(list.get(position).getLikeNum()) + 1 + "");
                    } else {
//                        presenter.PGCReadFabulous(productId, list.get(position).getCommentId(), "0", "");
                        if (clickZan != null) {
                            clickZan.zan(list.get(position).getCommentId(), "0", "");
                        }
                        holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        holder.Work_commentRecy_LikeNumber.setText(Integer.parseInt(list.get(position).getLikeNum()) + "");
                    }
                }
            });
        }
        holder.Work_commentRecy_UserName.setText(list.get(position).getName());
        holder.itemView.setTag(position);
    }

    private ClickZan clickZan;

    public void setClickZan(ClickZan clickZan) {
        this.clickZan = clickZan;
    }

    public interface ClickZan {
        void zan(String commentId, String status, String pgcId);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        //用户名
        private TextView Work_commentRecy_UserName;
        //评论内容
        private TextView Work_commentRecy_Comment;
        //头像
        private ImageView Work_commentRecy_HeadView;
        //评论喜欢
        private CheckBox Work_commentRecy_Like;
        //评论时间
        private TextView Work_commentRecy_Time;
        //评论喜欢个数
        private TextView Work_commentRecy_LikeNumber;

        public Holder(View itemView) {
            super(itemView);
            Work_commentRecy_HeadView = itemView.findViewById(R.id.Work_commentRecy_HeadView);
            Work_commentRecy_UserName = itemView.findViewById(R.id.Work_commentRecy_UserName);
            Work_commentRecy_Comment = itemView.findViewById(R.id.Work_commentRecy_Comment);
            Work_commentRecy_Time = itemView.findViewById(R.id.Work_commentRecy_Time);
            Work_commentRecy_Like = itemView.findViewById(R.id.Work_commentRecy_Like);
            Work_commentRecy_LikeNumber = itemView.findViewById(R.id.Work_commentRecy_LikeNumber);
            AutoUtils.autoSize(itemView);
        }
    }
}
