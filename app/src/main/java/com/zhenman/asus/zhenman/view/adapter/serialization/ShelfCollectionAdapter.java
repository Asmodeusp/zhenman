package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;

import java.util.List;

public class ShelfCollectionAdapter extends RecyclerView.Adapter<ShelfCollectionAdapter.Holder> implements View.OnClickListener, View.OnLongClickListener {
    private List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList;
    private Context context;
    private OnShortCLickListener myCLick;
    private OnLongCLickListener myLongCLick;
    private Holder holder;
    public static String isDisplay="隐藏";

    public ShelfCollectionAdapter(List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_shelf_collection, viewGroup, false);
        holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        inflate.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {
        Glide.with(context).load(resultBeanList.get(i).getImageUrl()).into(holder.itemShelfColl_iamge);
        holder.itemShelfColl_title.setText(resultBeanList.get(i).getTitle());
//        holder.itemShelfColl_on.setVisibility(View.GONE);
//        是否显示蒙板
        if (resultBeanList.get(i).isDisplay()) {
            holder.itemShelfColl_mask.setVisibility(View.VISIBLE);
            holder.itemShelfColl_check.setVisibility(View.VISIBLE);
            holder.itemShelfColl_off.setVisibility(View.VISIBLE);
            holder.itemShelfColl_on.setVisibility(View.GONE);
            isDisplay = "显示";
        } else {
            holder.itemShelfColl_mask.setVisibility(View.GONE);
            holder.itemShelfColl_check.setVisibility(View.GONE);
            holder.itemShelfColl_off.setVisibility(View.GONE);
            holder.itemShelfColl_on.setVisibility(View.GONE);
            isDisplay = "隐藏";
        }
//        是否全选
        if (resultBeanList.get(i).isCheck()) {
            holder.itemShelfColl_check.setVisibility(View.VISIBLE);
            holder.itemShelfColl_check.setChecked(true);
            holder.itemShelfColl_check.setButtonDrawable(R.mipmap.cam_album_select);
            holder.itemShelfColl_off.setVisibility(View.VISIBLE);
            holder.itemShelfColl_on.setVisibility(View.GONE);
        } else {
            holder.itemShelfColl_check.setChecked(false);
            holder.itemShelfColl_check.setButtonDrawable(R.mipmap.home_follow_on);
            holder.itemShelfColl_off.setVisibility(View.GONE);
            if (isDisplay.equals("隐藏")) {
                holder.itemShelfColl_on.setVisibility(View.GONE);
            }
            holder.itemShelfColl_on.setVisibility(View.VISIBLE);

        }
        Log.e("12345", holder.itemShelfColl_check.isChecked() + "");
        if (holder.itemShelfColl_check.isChecked()) {
            holder.itemShelfColl_check.setButtonDrawable(R.mipmap.home_follow_on);
        } else {
            holder.itemShelfColl_check.setButtonDrawable(R.mipmap.cam_album_select);
        }
        holder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return resultBeanList.isEmpty() ? 0 : resultBeanList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        public ImageView itemShelfColl_iamge;
        public ImageView itemShelfColl_mask;
        public TextView itemShelfColl_title;
        public CheckBox itemShelfColl_check;
        public ImageView itemShelfColl_off;//选中
        public ImageView itemShelfColl_on;//未选中

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemShelfColl_iamge = (ImageView) itemView.findViewById(R.id.itemShelfColl_iamge);
            this.itemShelfColl_mask = (ImageView) itemView.findViewById(R.id.itemShelfColl_mask);
            this.itemShelfColl_title = (TextView) itemView.findViewById(R.id.itemShelfColl_title);
            this.itemShelfColl_check = (CheckBox) itemView.findViewById(R.id.itemShelfColl_check);
            this.itemShelfColl_off = (ImageView) itemView.findViewById(R.id.itemShelfColl_off);
            this.itemShelfColl_on = (ImageView) itemView.findViewById(R.id.itemShelfColl_on);
        }
    }

    public interface OnLongCLickListener {
        void myLongClick(View view, int position);

    }

    public void setOnLongListener(OnLongCLickListener onLongListener) {
        this.myLongCLick = onLongListener;
    }

    @Override
    public boolean onLongClick(View v) {
        if (myLongCLick != null) {
            myLongCLick.myLongClick(v, (int) v.getTag());
        }
        return true;
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

    //供全选按钮调用
    public void setupAllChecked(int position) {
        if (holder.itemShelfColl_check.isChecked()) {
            holder.itemShelfColl_check.setButtonDrawable(R.mipmap.home_follow_on);
        } else {
            holder.itemShelfColl_check.setButtonDrawable(R.mipmap.cam_album_select);
        }

    }

}
