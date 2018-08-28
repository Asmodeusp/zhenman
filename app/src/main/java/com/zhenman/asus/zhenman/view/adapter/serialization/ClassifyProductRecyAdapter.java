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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ClassifyBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class ClassifyProductRecyAdapter extends RecyclerView.Adapter<ClassifyProductRecyAdapter.Holder> implements View.OnClickListener {
    private List<ClassifyBean.DataBean.ResultBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    public ClassifyProductRecyAdapter(List<ClassifyBean.DataBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_serialization_hotrecy, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        ClassifyBean.DataBean.ResultBean listBean = list.get(position);
        Glide.with(context).load(listBean.getImageUrl()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.Serialization_HotRecyImg);
        holder.Serialization_HotRecy_WorkName.setText(listBean.getTitle());
        holder.Serialization_HotRecy_WorkTag.setText(listBean.getTagName());
        holder.itemView.setTag(position);
    }

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
    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        //作品名字
        private TextView Serialization_HotRecy_WorkName;
        //作品标签
        private TextView Serialization_HotRecy_WorkTag;
        //作品封面
        private ImageView Serialization_HotRecyImg;
        public Holder(View itemView) {
            super(itemView);
            Serialization_HotRecyImg = itemView.findViewById(R.id.Serialization_HotRecyImg);
            Serialization_HotRecy_WorkName = itemView.findViewById(R.id.Serialization_HotRecy_WorkName);
            Serialization_HotRecy_WorkTag = itemView.findViewById(R.id.Serialization_HotRecy_WorkTag);
            AutoUtils.autoSize(itemView);
        }
    }
}
