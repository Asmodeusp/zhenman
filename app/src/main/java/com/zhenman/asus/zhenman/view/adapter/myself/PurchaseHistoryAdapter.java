package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.PurchaseHistoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryAdapter.Holder> implements View.OnClickListener {
    private List<PurchaseHistoryBean.DataBean.ResultBean> dataBeanArrayList;
    private Context context;

    public PurchaseHistoryAdapter(List<PurchaseHistoryBean.DataBean.ResultBean> dataBeanArrayList, Context context) {
        this.dataBeanArrayList = dataBeanArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_purchase_history, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        if (dataBeanArrayList.get(i).getTypeString().equals("打赏")) {
//            购买  章节
            holder.itemPurHis_chapter.setVisibility(View.GONE);
//            购买
            holder.itemPurHis_other03.setVisibility(View.GONE);
            holder.itemPurHis_other02.setVisibility(View.VISIBLE);
//            打赏的用户ID
            holder.itemPurHis_userId.setVisibility(View.VISIBLE);
            holder.itemPurHis_other01.setText("您在");
            holder.itemPurHis_use.setText(dataBeanArrayList.get(i).getTypeString());

            if (dataBeanArrayList.get(i).getTitle() != null) {
                holder.itemPurHis_chapter.setText(dataBeanArrayList.get(i).getTitle().toString());
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-DD");
            String format = simpleDateFormat.format(new Date(Long.parseLong(dataBeanArrayList.get(i).getAddTime())));
            holder.itemPurHis_date.setText(format);
            holder.itemPurHis_spend.setText("-"+dataBeanArrayList.get(i).getAmount());
            holder.itemPurHis_userId.setText(dataBeanArrayList.get(i).getName());
            holder.itemPurHis_other03.setText("打赏了" + dataBeanArrayList.get(i).getAmount() + "个茄子");
        } else if (dataBeanArrayList.get(i).getTypeString().equals("购买")) {
            //            购买  章节
            holder.itemPurHis_chapter.setVisibility(View.VISIBLE);
//            购买
            holder.itemPurHis_other03.setVisibility(View.VISIBLE);
            holder.itemPurHis_other02.setVisibility(View.GONE);
//            打赏的用户ID
            holder.itemPurHis_userId.setVisibility(View.GONE);
            holder.itemPurHis_other01.setText("您购买了");

            holder.itemPurHis_use.setText(dataBeanArrayList.get(i).getTypeString());
            if (dataBeanArrayList.get(i).getTitle() != null) {
                holder.itemPurHis_title.setText(dataBeanArrayList.get(i).getTitle().toString());

            }
        }
    }

    @Override
    public int getItemCount() {
        return dataBeanArrayList.isEmpty() ? 0 : dataBeanArrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView itemPurHis_use;
        public ImageView itemPurHis_other04;
        public TextView itemPurHis_other01;
        public TextView itemPurHis_title;
        public TextView itemPurHis_chapter;
        public TextView itemPurHis_other02;
        public TextView itemPurHis_userId;
        public TextView itemPurHis_other03;
        public LinearLayout itemPurHis_other05;
        public TextView itemPurHis_date;
        public TextView itemPurHis_spend;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemPurHis_use = (TextView) rootView.findViewById(R.id.itemPurHis_use);
            this.itemPurHis_other04 = (ImageView) rootView.findViewById(R.id.itemPurHis_other04);
            this.itemPurHis_other01 = (TextView) rootView.findViewById(R.id.itemPurHis_other01);
            this.itemPurHis_title = (TextView) rootView.findViewById(R.id.itemPurHis_title);
            this.itemPurHis_chapter = (TextView) rootView.findViewById(R.id.itemPurHis_chapter);
            this.itemPurHis_other02 = (TextView) rootView.findViewById(R.id.itemPurHis_other02);
            this.itemPurHis_userId = (TextView) rootView.findViewById(R.id.itemPurHis_userId);
            this.itemPurHis_other03 = (TextView) rootView.findViewById(R.id.itemPurHis_other03);
            this.itemPurHis_other05 = (LinearLayout) rootView.findViewById(R.id.itemPurHis_other05);
            this.itemPurHis_date = (TextView) rootView.findViewById(R.id.itemPurHis_date);
            this.itemPurHis_spend = (TextView) rootView.findViewById(R.id.itemPurHis_spend);
        }
    }
}
