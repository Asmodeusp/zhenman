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
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;

import java.util.List;

public class ShelfCollectionAdapter extends RecyclerView.Adapter<ShelfCollectionAdapter.Holder> implements View.OnClickListener {
    private List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList;
    private Context context;
    private OnShortCLickListener myCLick;

    public ShelfCollectionAdapter(List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_shelf_collection, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Glide.with(context).load(resultBeanList.get(i).getImageUrl()).into(holder.itemShelfColl_iamge);
        holder.itemShelfColl_title.setText(resultBeanList.get(i).getTitle());
        holder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return resultBeanList.isEmpty() ? 0 : resultBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView itemShelfColl_iamge;
        public TextView itemShelfColl_title;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemShelfColl_iamge = (ImageView) itemView.findViewById(R.id.itemShelfColl_iamge);
            this.itemShelfColl_title = (TextView) itemView.findViewById(R.id.itemShelfColl_title);

        }
    }
    public void setOnShortCLickListener(OnShortCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }
    public interface OnShortCLickListener {
        void myClick(View view, int position);
    }



}
