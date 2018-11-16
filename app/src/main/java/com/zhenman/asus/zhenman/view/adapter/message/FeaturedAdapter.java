package com.zhenman.asus.zhenman.view.adapter.message;

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
import com.zhenman.asus.zhenman.model.bean.ResultBean;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.Holder> implements View.OnClickListener {
    private List<ResultBean> resultBeanList;
    private Context context;
    private OnShortCLickListener myCLick;

    public FeaturedAdapter(List<ResultBean> resultBeanList, Context context) {
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
        //        获取屏幕的宽
        int screenWidth = ScreenUtils.getScreenWidth(context);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.itemWorkShort_1.getLayoutParams();
        int imageWidth = (screenWidth - (12 * 2 + 8 * 2)) / 3;
        int imageHeight = imageWidth * 332 / 216;
        params.height = imageHeight;
        params.width = imageWidth;
        params.setMargins(0, 20, 8, 0);
        holder.itemWorkShort_1.setLayoutParams(params);
        Glide.with(context)
                .load(resultBeanList.get(i).getCoverImg())
                .centerCrop()
                .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
                .error(R.mipmap.common_qiezi)
                .placeholder(R.mipmap.common_placeimg)
                .into(holder.itemWorkShort_Img);
        holder.itemWorkShort_likeNum.setText(resultBeanList.get(i).getLikeNum() + "");
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
        public TextView itemWorkShort_likeNum;
        public AutoRelativeLayout itemWorkShort_1;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemWorkShort_Img = (ImageView) itemView.findViewById(R.id.itemWorkShort_Img);
            this.itemWorkShort_likeNum = (TextView) itemView.findViewById(R.id.itemWorkShort_likeNum);
            this.itemWorkShort_1 = (AutoRelativeLayout) itemView.findViewById(R.id.itemWorkShort_1);
        }
    }
}
