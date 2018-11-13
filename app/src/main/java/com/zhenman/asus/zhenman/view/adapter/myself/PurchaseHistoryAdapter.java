package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.PurchaseHistoryBean;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryAdapter.Holder> implements View.OnClickListener {
    private List<PurchaseHistoryBean.DataBean> dataBeanArrayList;
    private Context context;

    public PurchaseHistoryAdapter(List<PurchaseHistoryBean.DataBean> dataBeanArrayList, Context context) {
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
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.itemPurHis_use.setText(dataBeanArrayList.get(i).getTypeString());
        if (dataBeanArrayList.get(i).getTypeString().equals("打赏")||dataBeanArrayList.get(i).getTypeString().equals("购买")){
            holder.itemPurHis_spend.setText("-"+dataBeanArrayList.get(i).getAmount());
        }else if (dataBeanArrayList.get(i).getTypeString().equals("充值")){
            holder.itemPurHis_spend.setText("-"+dataBeanArrayList.get(i).getAmount());
        }
        holder.itemPurHis_use.setText(dataBeanArrayList.get(i).getTypeString());
//        设置富文本显示
        SpannableStringBuilder spannable = new SpannableStringBuilder(dataBeanArrayList.get(i).getTitleDto().getText());
        final ArrayList<Integer> integers = new ArrayList<>();
        for (int i1 = 0; i1 < dataBeanArrayList.get(i).getTitleDto().getTextExtra().size(); i1++) {
            integers.add(dataBeanArrayList.get(i).getTitleDto().getTextExtra().get(i1).getTextType());
        }
        for (int i1 = 0; i1 < integers.size(); i1++) {
            final int finalI = i1;
            spannable.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    if (integers.get(finalI) == 2) {
                        Intent intent = new Intent(context, WorkDetailsActivity.class);
                        intent.putExtra("pgcId",dataBeanArrayList.get(i).getCatalogId()+"");
                        context.startActivity(intent);
                    }
                    if (integers.get(finalI) == 1) {//用户
                        Intent intent = new Intent(context, HomepageActivity.class);
                        intent.putExtra("him_id",dataBeanArrayList.get(i).getUserId()+"");
                        context.startActivity(intent);
                    }
                }
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(Color.parseColor("#40A9FF")); // 设置文本颜色
                    // 去掉下划线
                    ds.setUnderlineText(false);
                }
            }, dataBeanArrayList.get(i).getTitleDto().getTextExtra().get(i1).getStart(), dataBeanArrayList.get(i).getTitleDto().getTextExtra().get(i1).getStart() + dataBeanArrayList.get(i).getTitleDto().getTextExtra().get(i1).getLength(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        //这个一定要记得设置，不然点击不生效
        holder.itemPurHis_introduction.setMovementMethod(LinkMovementMethod.getInstance());
        holder.itemPurHis_introduction.setText(spannable);
        //            时间转换
        Date date = new Date(Long.parseLong(dataBeanArrayList.get(i).getAddTime()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        String format2 = format.format(date);
        holder.itemPurHis_date.setText(format2);
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
        public ImageView itemPurHis_eggplantSeeds;
        public TextView itemPurHis_spend;
        public TextView itemPurHis_introduction;
        public TextView itemPurHis_date;


        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemPurHis_use = (TextView) rootView.findViewById(R.id.itemPurHis_use);
            this.itemPurHis_eggplantSeeds = (ImageView) rootView.findViewById(R.id.itemPurHis_eggplantSeeds);
            this.itemPurHis_spend = (TextView) rootView.findViewById(R.id.itemPurHis_spend);
            this.itemPurHis_introduction = (TextView) rootView.findViewById(R.id.itemPurHis_introduction);
            this.itemPurHis_date = (TextView) rootView.findViewById(R.id.itemPurHis_date);
        }
    }


}
