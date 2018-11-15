package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class WorkDisplayItemAdapter extends RecyclerView.Adapter<WorkDisplayItemAdapter.Holder> implements View.OnClickListener {
    List<WorkShortComicBean.DataBean.ResultBean.PageDtoListBean> pageDtoList;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    public WorkDisplayItemAdapter(List<WorkShortComicBean.DataBean.ResultBean.PageDtoListBean> pageDtoList) {
        this.pageDtoList = pageDtoList;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_recy_fillview, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Glide.with(context).load(pageDtoList.get(i).getImageUrl()).skipMemoryCache(true).error(R.mipmap.my_qiezi).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.home_Recy_recy_Image);

    }

    @Override
    public int getItemCount() {
        return pageDtoList.isEmpty() ? 0 : pageDtoList.size();
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v);
        }
    }
    public interface RecyclerViewOnCLickListener {
        void myClick(View view);
    }
    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView home_Recy_recy_Image;
        private LinearLayout hotfillView_fill;
        public Holder(View itemView) {
            super(itemView);

            home_Recy_recy_Image = itemView.findViewById(R.id.home_Recy_recy_Image);
            hotfillView_fill = itemView.findViewById(R.id.hotfillView_fill);
            AutoUtils.autoSize(itemView);
        }
    }
}
