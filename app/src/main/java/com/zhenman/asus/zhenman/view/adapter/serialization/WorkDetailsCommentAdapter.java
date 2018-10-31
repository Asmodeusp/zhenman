package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.presenter.WorkDetailsCommentPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.login.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class WorkDetailsCommentAdapter extends RecyclerView.Adapter<WorkDetailsCommentAdapter.Holder> implements View.OnClickListener {
    private List<CommentListBean.DataBean.CommentDtoListBeanX> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    private boolean followCount = true;


    public WorkDetailsCommentAdapter(List<CommentListBean.DataBean.CommentDtoListBeanX> list) {
        this.list = list;

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

    private goUserInfo clickGoUserInfo;

    public void setgoUserInfo(goUserInfo clickGoUserInfo) {
        this.clickGoUserInfo = clickGoUserInfo;
    }

    public interface goUserInfo {
        void go(String UserId);
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
        holder.itemView.setTag(position);
        final CommentListBean.DataBean.CommentDtoListBeanX listBean = list.get(position);
        GlideUtils.loadCircleImage(listBean.getImageUrl(), holder.work_commentRecy_headView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {

            }
        },R.mipmap.my_qiezi);

        Log.d("WorkDetailsCommentAdapt", listBean.getTextDto().getText());
        Log.d("WorkDetailsCommentAdapt", "listBean.getTextDto().getTextExtra().size():" + listBean.getTextDto().getTextExtra().size());
        MyClickSpan.setTextHighLightWithClick(holder.Work_commentRecy_Comment, listBean.getTextDto().getText(), listBean.getTextDto().getTextExtra(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listBean.getTextDto().getTextExtra().get(0).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.Work_commentRecy_UserName.setText(listBean.getName());
        holder.Work_commentRecy_LikeNumber.setText(listBean.getLikeNum()+"");
        holder.Work_commentRecy_Time.setText(SPUtils.transferLongToDate(Long.parseLong(listBean.getAddTime())));
        holder.Work_commentRecy_Like.setButtonDrawable(R.mipmap.home_like_off);
        holder.work_commentRecy_headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean ISlogin = (Boolean) SPUtils.get(context, SPKey.IS_LOGIN, false);
                if (!ISlogin) {
                    context.startActivity(new Intent(context, MainActivity.class));
                    ((Activity) context).finish();
                }else {
                    clickGoUserInfo.go(listBean.getUserId());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView work_commentRecy_headView;
        private TextView Work_commentRecy_UserName;
        private TextView Work_commentRecy_Comment;
        private TextView Work_commentRecy_Time;
        private CheckBox Work_commentRecy_Like;
        private TextView Work_commentRecy_LikeNumber;

        public Holder(View itemView) {
            super(itemView);
            work_commentRecy_headView = itemView.findViewById(R.id.Work_commentRecy_HeadView);
            Work_commentRecy_UserName = itemView.findViewById(R.id.Work_commentRecy_UserName);
            Work_commentRecy_Comment = itemView.findViewById(R.id.Work_commentRecy_Comment);
            Work_commentRecy_Time = itemView.findViewById(R.id.Work_commentRecy_Time);
            Work_commentRecy_Like = itemView.findViewById(R.id.Work_commentRecy_Like);
            Work_commentRecy_LikeNumber = itemView.findViewById(R.id.Work_commentRecy_LikeNumber);
        }
    }
}
