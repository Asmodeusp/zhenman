package com.zhenman.asus.zhenman.view.adapter.comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.utils.GlideUtils;

import java.util.List;


public class CommentAtFollowRecyAdapter extends RecyclerView.Adapter<CommentAtFollowRecyAdapter.Holder> implements View.OnClickListener {
    private List<MyAttentionUserBean.DataBean.ResultBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    private boolean followCount = true;


    public CommentAtFollowRecyAdapter(List<MyAttentionUserBean.DataBean.ResultBean> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.comment_at_recy_fillitem, parent, false);
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
        final MyAttentionUserBean.DataBean.ResultBean listBean = list.get(position);
        holder.Comment_At_Item_headImage_title.setText(listBean.getName());
        holder.Comment_At_Item_headImage_title_decription.setText(listBean.getIntroduction());
        holder.itemView.setTag(position);

        GlideUtils.loadCircleImage(listBean.getImageUrl(), holder.Comment_At_Item_headImage, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        },R.mipmap.common_portrait_m);


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
        private ImageView Comment_At_Item_headImage;
        //姓名
        private TextView Comment_At_Item_headImage_title;
        //描述
        private TextView Comment_At_Item_headImage_title_decription;


        public Holder(View itemView) {
            super(itemView);
            Comment_At_Item_headImage = itemView.findViewById(R.id.Comment_At_Item_headImage);
            Comment_At_Item_headImage_title = itemView.findViewById(R.id.Comment_At_Item_headImage_title);
            Comment_At_Item_headImage_title_decription = itemView.findViewById(R.id.Comment_At_Item_headImage_title_decription);

        }
    }
}
