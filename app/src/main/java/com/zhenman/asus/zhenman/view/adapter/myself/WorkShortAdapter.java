package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;

import java.util.List;

public class WorkShortAdapter extends RecyclerView.Adapter<WorkShortAdapter.Holder> {
    private List<WorkShortComicBean.DataBean.ResultBean> result;

    public WorkShortAdapter(List<WorkShortComicBean.DataBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_work_short, viewGroup, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Glide.with(context).load(result.get(i).getCoverImg()).into(holder.itemWorkShort_Img);
    }

    @Override
    public int getItemCount() {
        return result.isEmpty() ? 0 : result.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView itemWorkShort_Img;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemWorkShort_Img = (ImageView) itemView.findViewById(R.id.itemWorkShort_Img);

        }
    }


}
