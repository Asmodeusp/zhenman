package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;
import com.zhenman.asus.zhenman.model.bean.WorkShortPgcComicBean;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

public class WorkShortAdapter extends RecyclerView.Adapter<WorkShortAdapter.Holder> implements View.OnClickListener {
    private List<Object> result;
    private OnShortCLickListener myCLick;

    public WorkShortAdapter(List<Object> result, Context context) {
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
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Object object = result.get(i);


        if (object instanceof WorkShortComicBean.DataBean.ResultBean) {
            final WorkShortComicBean.DataBean.ResultBean resultBeanList = (WorkShortComicBean.DataBean.ResultBean) object;
            //        获取屏幕的宽
            int screenWidth = ScreenUtils.getScreenWidth(context);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.itemWorkShort_1.getLayoutParams();
            int imageWidth = (screenWidth - (12 * 2 + 8 * 2)) / 3;
            int imageHeight = imageWidth * 332 / 216;
            params.height = imageHeight;
            params.width = imageWidth;
            params.setMargins(0, 20, 8, 0);
            holder.itemWorkShort_1.setLayoutParams(params);
            Glide.with(context).load(resultBeanList.getCoverImg()).into(holder.itemWorkShort_Img);
            holder.itemWorkShort_likeNum.setText(resultBeanList.getLikeNum() + "");
            holder.itemView.setTag(i);

        }if (object instanceof WorkShortPgcComicBean.DataBean.ResultBean){
            WorkShortPgcComicBean.DataBean.ResultBean resultBean = (WorkShortPgcComicBean.DataBean.ResultBean) object;
            //        获取屏幕的宽
            int screenWidth = ScreenUtils.getScreenWidth(context);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.itemWorkShort_1.getLayoutParams();
            int imageWidth = (screenWidth - (12 * 2 + 8 * 2)) / 3;
            int imageHeight = imageWidth * 332 / 216;
            params.height = imageHeight;
            params.width = imageWidth;
            params.setMargins(0, 20, 8, 0);
            holder.itemWorkShort_1.setLayoutParams(params);
            Glide.with(context).load(resultBean.getCoverImg()).into(holder.itemWorkShort_Img);
//            holder.itemWorkShort_likeNum.setText(resultBean.get.getLikeNum() + "");
            holder.itemWorkShort_mask.setVisibility(View.GONE);
            holder.itemWorkShort_likeNum.setVisibility(View.GONE);
            holder.itemView.setTag(i);
        }
    }

    @Override
    public int getItemCount() {
        return result.isEmpty() ? 0 : result.size();
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

    public void setOnShortCLickListener(OnShortCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView itemWorkShort_Img;
        public ImageView itemWorkShort_mask;
        public AutoRelativeLayout itemWorkShort_1;
        public TextView itemWorkShort_likeNum;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemWorkShort_Img = (ImageView) itemView.findViewById(R.id.itemWorkShort_Img);
            this.itemWorkShort_mask = (ImageView) itemView.findViewById(R.id.itemWorkShort_mask);
            this.itemWorkShort_likeNum = (TextView) itemView.findViewById(R.id.itemWorkShort_likeNum);
            this.itemWorkShort_1 = (AutoRelativeLayout) itemView.findViewById(R.id.itemWorkShort_1);

        }
    }


}
