package com.zhenman.asus.zhenman.view.adapter.comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;


public class CommentItemRecyAdapter extends RecyclerView.Adapter<CommentItemRecyAdapter.Holder> implements View.OnClickListener {
    private List<CommentItemListBean.DataBean.CommentDtoListBean> list ;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    public CommentItemRecyAdapter(List<CommentItemListBean.DataBean.CommentDtoListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.comment_fill, parent, false);
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
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final CommentItemListBean.DataBean.CommentDtoListBean listBean = list.get(position);
        holder.itemView.setTag(position);
        //加载头像
        GlideUtils.loadCircleImage(listBean.getImageUrl(), holder.comment_fill_HeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        }, R.mipmap.my_qiezi);
        //加载富文本
        holder.comment_fill_AddTime.setText(SPUtils.transferLongToDate(Long.parseLong(listBean.getAddTime())));
        if (listBean.getTextDto() != null) {
            MyClickSpan.setTextHighLightWithClick(holder.comment_fill_conent, listBean.getTextDto().getText(), listBean.getTextDto().getTextExtra(), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, listBean.getTextDto().getTextExtra().get(0).getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }



        //加载用户名
        holder.comment_fill_UserName.setText(listBean.getName());
        //加载喜欢个数
        holder.comment_fill_likeNumberText.setText(listBean.getLikeNum() + "");
        //加载添加时间
        holder.comment_fill_AddTime.setText(SPUtils.transferLongToDate(Long.parseLong(listBean.getAddTime())));
        holder.comment_Two_ItemLinearLayout.setVisibility(View.GONE);
        holder.comment_fill_fromUserText.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        //头像
        private ImageView comment_fill_HeadView;
        //姓名
        private TextView comment_fill_UserName;
        //主评论内容
        private TextView comment_fill_conent;
        //喜欢按钮
        private AutoLinearLayout comment_fill_likeButton;
        //喜欢图片
        private CheckBox comment_fill_likeImg;
        //喜欢个数
        private TextView comment_fill_likeNumberText;
        //第一条评论
        private TextView Comment_fill_FirstItem;
        //第二条评论
        private TextView Comment_fill_SecondItem;
        //查看更多评论
        private TextView comment_fill_SeeMoreText;
        //添加时间
        private TextView comment_fill_AddTime;
        //来自谁的动态
        private TextView comment_fill_fromUserText;
        //两个
        private AutoLinearLayout comment_Two_ItemLinearLayout;

        public Holder(View itemView) {
            super(itemView);
            comment_fill_HeadView = itemView.findViewById(R.id.comment_fill_HeadView);
            comment_fill_UserName = itemView.findViewById(R.id.comment_fill_UserName);
            comment_fill_conent = itemView.findViewById(R.id.comment_fill_conent);
            comment_fill_likeButton = itemView.findViewById(R.id.comment_fill_likeButton);
            comment_fill_likeImg = itemView.findViewById(R.id.comment_fill_likeImg);
            comment_fill_likeNumberText = itemView.findViewById(R.id.comment_fill_likeNumberText);
            Comment_fill_FirstItem = itemView.findViewById(R.id.Comment_fill_FirstItem);
            Comment_fill_SecondItem = itemView.findViewById(R.id.Comment_fill_SecondItem);
            comment_fill_SeeMoreText = itemView.findViewById(R.id.comment_fill_SeeMoreText);
            comment_fill_AddTime = itemView.findViewById(R.id.comment_fill_AddTime);
            comment_fill_fromUserText = itemView.findViewById(R.id.comment_fill_fromUserText);
            comment_Two_ItemLinearLayout = itemView.findViewById(R.id.comment_Two_ItemLinearLayout);

        }
    }
}
