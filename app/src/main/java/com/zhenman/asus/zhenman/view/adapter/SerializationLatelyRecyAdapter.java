package com.zhenman.asus.zhenman.view.adapter;

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
import com.zhenman.asus.zhenman.model.bean.SerializationLatelyBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;



public class SerializationLatelyRecyAdapter extends RecyclerView.Adapter<SerializationLatelyRecyAdapter.Holder> implements View.OnClickListener {
    private List<SerializationLatelyBean.DataBean.ResultBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    public SerializationLatelyRecyAdapter(List<SerializationLatelyBean.DataBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_serialization_latelyrecy, parent, false);
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
        SerializationLatelyBean.DataBean.ResultBean listBean = list.get(position);
        Glide.with(context).load(listBean.getImageUrl()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.Serialization_LatelyRecyImage);
        holder.Serialization_LatelyRecy_WorkName.setText(listBean.getTitle());
        holder.Serialization_LatelyRecy_WorkTag.setText(listBean.getTagName());
        holder.Serialization_LatelyRecyCatalogName.setText(listBean.getCatalogTitle());
        holder.itemView.setTag(position);
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
        private TextView Serialization_LatelyRecy_WorkName;
        //作品标签
        private TextView Serialization_LatelyRecy_WorkTag;
        //作品封面
        private ImageView Serialization_LatelyRecyImage;
        //作品更新时间
        private  TextView Serialization_LatelyRecyCatalogName;
        public Holder(View itemView) {
            super(itemView);
            Serialization_LatelyRecyImage = itemView.findViewById(R.id.Serialization_LatelyRecyImage);
            Serialization_LatelyRecy_WorkName = itemView.findViewById(R.id.Serialization_LatelyRecy_WorkName);
            Serialization_LatelyRecy_WorkTag = itemView.findViewById(R.id.Serialization_LatelyRecy_WorkTag);
            Serialization_LatelyRecyCatalogName = itemView.findViewById(R.id.Serialization_LatelyRecyCatalogName);
            AutoUtils.autoSize(itemView);
        }
    }
}
