package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.model.bean.ShelfHistoryListBean;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class ShelfCollectionAdapter extends RecyclerView.Adapter<ShelfCollectionAdapter.Holder> implements View.OnClickListener, View.OnLongClickListener {
    private List<Object> resultBeanList;
//    ShelfCollectionBean.DataBean.ResultBean
    private Context context;
    private OnShortCLickListener myCLick;
    private OnLongCLickListener myLongCLick;
    private Holder holder;
    public static String isDisplay="隐藏";
    public static String isSelectAll="全选";
    private boolean isClick=false;
    public static ArrayList<String> checkList=new ArrayList<>();
    public ShelfCollectionAdapter(List<Object> resultBeanList, Context context) {
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
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Object object = resultBeanList.get(i);
        if (object instanceof ShelfCollectionBean.DataBean.ResultBean) {
            final ShelfCollectionBean.DataBean.ResultBean resultBean = (ShelfCollectionBean.DataBean.ResultBean) object;
            Glide.with(context).load(resultBean.getImageUrl()).into(holder.itemShelfColl_iamge);
            holder.itemShelfColl_title.setText(resultBean.getTitle());
//        是否显示蒙板
            if (resultBean.isDisplay()) {//显示蒙板
                holder.itemShelfColl_mask.setVisibility(View.VISIBLE);//蒙板
                holder.itemShelfColl_check.setVisibility(View.VISIBLE);//选项  选项初始化是未选中
                holder.itemShelfColl_off.setVisibility(View.VISIBLE);
                holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_off);
                isDisplay = "显示";
                holder.itemShelfColl_iamge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isClick == false) {
                            isClick = true;
                            holder.itemShelfColl_check.setChecked(true);
                            holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_on);
                            checkList.add(resultBean.getLid() + "");
                        } else {
                            isClick = false;
                            holder.itemShelfColl_check.setChecked(false);
                            holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_off);
                            checkList.remove(resultBean.getLid() + "");
                        }
                    }
                });
                holder.itemShelfColl_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (holder.itemShelfColl_check.isChecked()) {
                            holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_on);
                            checkList.add(resultBean.getLid() + "");
                        } else {
                            holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_off);
                            checkList.remove(resultBean.getLid() + "");
                        }
                    }
                });

            } else {
                holder.itemShelfColl_mask.setVisibility(View.GONE);
                holder.itemShelfColl_check.setVisibility(View.GONE);
                holder.itemShelfColl_off.setVisibility(View.GONE);
                isDisplay = "隐藏";
            }
//        是否全选
            if (resultBean.isCheck()) {
                checkList.add(resultBean.getLid() + "");
                holder.itemShelfColl_check.setChecked(true);
                holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_on);
                holder.itemShelfColl_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (holder.itemShelfColl_check.isChecked()) {
                            checkList.add(resultBean.getLid() + "");
                            holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_on);
                            isSelectAll = "取消全选";
                        } else {
                            checkList.remove(resultBean.getLid() + "");
                            holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_off);
                            isSelectAll = "全选";
                        }
                    }
                });
            } else {
                holder.itemShelfColl_check.setChecked(false);
                holder.itemShelfColl_off.setImageResource(R.mipmap.serial_shelf_off);
            }
            holder.itemView.setTag(i);
        }
        if (object instanceof ShelfHistoryListBean.DataBean.ResultBean){
            final ShelfHistoryListBean.DataBean.ResultBean resultBean = (ShelfHistoryListBean.DataBean.ResultBean) object;
            Glide.with(context).load(resultBean.getImageUrl()).into(holder.itemShelfColl_iamge);
            holder.itemShelfColl_title.setText(resultBean.getTitle());
            holder.itemShelfColl_iamge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, WorkDetailsActivity.class);
                    SPUtils.put(context, SPKey.PGC_ID,resultBean.getPgcId()+"");
//                    intent.putExtra("pgcid", resultBean.getPgcId());
                    context.startActivity(intent);
                }
            });
        }
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
        public ImageView itemShelfColl_off;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemShelfColl_iamge = (ImageView) itemView.findViewById(R.id.itemShelfColl_iamge);
            this.itemShelfColl_mask = (ImageView) itemView.findViewById(R.id.itemShelfColl_mask);
            this.itemShelfColl_title = (TextView) itemView.findViewById(R.id.itemShelfColl_title);
            this.itemShelfColl_check = (CheckBox) itemView.findViewById(R.id.itemShelfColl_check);
            this.itemShelfColl_off = (ImageView) itemView.findViewById(R.id.itemShelfColl_off);
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
