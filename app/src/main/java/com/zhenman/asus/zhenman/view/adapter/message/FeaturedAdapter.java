package com.zhenman.asus.zhenman.view.adapter.message;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.Holder> implements View.OnClickListener {
    private List<ThemeFeaturedBean.DataBean.ResultBean> resultBeanList;
    private Context context;
    private OnShortCLickListener myCLick;

    public FeaturedAdapter(List<ThemeFeaturedBean.DataBean.ResultBean> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_work_short, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Glide.with(context).load(resultBeanList.get(i).getCoverImg()).into(holder.itemWorkShort_Img);
        holder.itemView.setTag(i);
    }


    public interface OnShortCLickListener {
        void myClick(View view, int position);
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
    @Override
    public int getItemCount() {
        return resultBeanList.isEmpty() ? 0 : resultBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView itemWorkShort_Img;
        public ImageView itemWorkShort_CoverImg;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemWorkShort_Img = (ImageView) itemView.findViewById(R.id.itemWorkShort_Img);

        }
    }
}
