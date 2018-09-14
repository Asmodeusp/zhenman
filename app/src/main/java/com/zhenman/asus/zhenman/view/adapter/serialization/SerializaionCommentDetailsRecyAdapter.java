package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentDetailBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import org.w3c.dom.Text;

import java.util.List;


public class SerializaionCommentDetailsRecyAdapter extends RecyclerView.Adapter<SerializaionCommentDetailsRecyAdapter.Holder> implements View.OnClickListener {
    private List<PgcChapterCommentDetailBean.DataBean.ResultBeanX.PageBeanBean.ResultBean> list;
    private Context context;

    public SerializaionCommentDetailsRecyAdapter(List<PgcChapterCommentDetailBean.DataBean.ResultBeanX.PageBeanBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_serializaion_comment_details_recy, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        if (list.get(position).getReName()==null) {
            holder.fill_Serializaion_commentDetails_CommentReply.setVisibility(View.GONE);
            holder.fill_Serializaion_commentDetails_CommentReplyName.setVisibility(View.GONE);

        }else{
            holder.fill_Serializaion_commentDetails_CommentReply.setVisibility(View.VISIBLE);
            holder.fill_Serializaion_commentDetails_CommentReplyName.setVisibility(View.VISIBLE);
        }
        GlideUtils.loadCircleImage(list.get(position).getImageUrl(), holder.fill_serializaion_commentDetails_headView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
//                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        });
        holder.fill_Serializaion_commentDetails_Comment.setText(list.get(position).getContent());
        holder.fill_Serializaion_commentDetails_CommentReplyName.setText("@"+list.get(position).getReName());
        holder.fill_Serializaion_commentDetails_Time.setText(SPUtils.transferLongToDate(Long.parseLong(list.get(position).getAddTime())));
        holder.fill_Serializaion_commentDetails_UserName.setText(list.get(position).getName());
        holder.itemView.setTag(position);
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    private RecyclerViewOnCLickListener myCLick;

    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView fill_serializaion_commentDetails_headView;
        private TextView fill_Serializaion_commentDetails_UserName;
        private TextView fill_Serializaion_commentDetails_CommentReply;
        private TextView fill_Serializaion_commentDetails_CommentReplyName;
        private TextView fill_Serializaion_commentDetails_Comment;
        private TextView fill_Serializaion_commentDetails_Time;

        public Holder(View itemView) {
            super(itemView);
            fill_serializaion_commentDetails_headView = itemView.findViewById(R.id.fill_Serializaion_commentDetails_HeadView);
            fill_Serializaion_commentDetails_UserName = itemView.findViewById(R.id.fill_Serializaion_commentDetails_UserName);
            fill_Serializaion_commentDetails_CommentReply = itemView.findViewById(R.id.fill_Serializaion_commentDetails_CommentReply);
            fill_Serializaion_commentDetails_CommentReplyName = itemView.findViewById(R.id.fill_Serializaion_commentDetails_CommentReplyName);
            fill_Serializaion_commentDetails_Comment = itemView.findViewById(R.id.fill_Serializaion_commentDetails_Comment);
            fill_Serializaion_commentDetails_Time = itemView.findViewById(R.id.fill_Serializaion_commentDetails_Time);

        }
    }
}
