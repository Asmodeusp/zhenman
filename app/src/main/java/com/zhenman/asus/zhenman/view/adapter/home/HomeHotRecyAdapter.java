package com.zhenman.asus.zhenman.view.adapter.home;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class HomeHotRecyAdapter extends RecyclerView.Adapter<HomeHotRecyAdapter.Holder> {
    private List<HomeHotBean.DataBean.PageDtoListBean> list;
    private Context context;
    public HomeHotRecyAdapter(List<HomeHotBean.DataBean.PageDtoListBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_recy_fillview, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.home_Recy_recy_Image);

    }


    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView home_Recy_recy_Image;


        public Holder(View itemView) {
            super(itemView);
            home_Recy_recy_Image = itemView.findViewById(R.id.home_Recy_recy_Image);

            AutoUtils.autoSize(itemView);
        }
    }
}
