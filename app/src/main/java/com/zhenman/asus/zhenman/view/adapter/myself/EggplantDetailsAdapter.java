package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.EggplantDetailsBean;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.myself.SaleDetailsActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EggplantDetailsAdapter extends RecyclerView.Adapter<EggplantDetailsAdapter.Holder> {
    private List<EggplantDetailsBean.DataBean> dataBeanList;
    private Context context;
    private SpannableString spannableString;

    public EggplantDetailsAdapter(List<EggplantDetailsBean.DataBean> dataBeanList, Context context) {
        this.dataBeanList = dataBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_purchase_history, viewGroup, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.itemPurHis_use.setVisibility(View.GONE);
        holder.itemPurHis_introduction.setVisibility(View.GONE);
        holder.itemPurHis_introduction2.setVisibility(View.VISIBLE);
        if (dataBeanList.get(i).getTitleDto().getTextExtra() == null) {
            holder.itemPurHis_introduction2.setText(dataBeanList.get(i).getTitleDto().getText());
        } else {
            if (dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getTextType() == 0) {
                spannableString = new SpannableString(dataBeanList.get(i).getTitleDto().getText());
                spannableString.setSpan(new ClickableSpan() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(context, SaleDetailsActivity.class);
                        if (dataBeanList.get(i).getDetailDto() != null) {
                            List<EggplantDetailsBean.DataBean.DetailDtoBean> strings = new ArrayList<>();
                            EggplantDetailsBean.DataBean.DetailDtoBean detailDto = dataBeanList.get(i).getDetailDto();
                            strings.add(detailDto);
                            intent.putExtra("saleData", (Serializable) strings);
                            context.startActivity(intent);
                        } else {
                            Toast.makeText(context, "加载数据失败", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(Color.parseColor("#40A9FF"));       //设置文件颜色
                        ds.setUnderlineText(false);      //不设置下划线
                    }
                }, dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getStart(), dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getStart() + dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getLength(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            if (dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getTextType() == 1) {
                spannableString = new SpannableString(dataBeanList.get(i).getTitleDto().getText());
                spannableString.setSpan(new ClickableSpan() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(context, HomepageActivity.class);
                        intent.putExtra("him_id", dataBeanList.get(i).getUserId() + "");
                        context.startActivity(intent);
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(Color.parseColor("#40A9FF"));       //设置文件颜色
                        ds.setUnderlineText(false);      //不设置下划线
                    }
                }, dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getStart(), dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getStart() + dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getLength(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
//为了响应点击
            holder.itemPurHis_introduction2.setMovementMethod(LinkMovementMethod.getInstance());
            holder.itemPurHis_introduction2.setText(spannableString);
        }

        //            时间转换
        Date date = new Date(Long.parseLong(dataBeanList.get(i).getAddTime()));
        SimpleDateFormat format = new SimpleDateFormat("MM-dd", Locale.getDefault());
        String format2 = format.format(date);
        holder.itemPurHis_date.setText(format2);
//        根据返回的type值判断是射门茄子种类
//        1、茄子  2、被咬了一口的茄子  3、未成熟的茄子  4、卖出后的查看详情
        if (dataBeanList.get(i).getType() == 1) {
            holder.itemPurHis_eggplantSeeds.setImageResource(R.mipmap.my_qiezi);
            holder.itemPurHis_spend.setText("+" + dataBeanList.get(i).getAmount());
        } else if (dataBeanList.get(i).getType() == 21) {
            holder.itemPurHis_eggplantSeeds.setImageResource(R.mipmap.my_qiezi_bite);
            holder.itemPurHis_spend.setText("+" + dataBeanList.get(i).getAmount());
        } else if (dataBeanList.get(i).getType() == 22) {
            holder.itemPurHis_eggplantSeeds.setImageResource(R.mipmap.my_qiezi_green);
            holder.itemPurHis_spend.setText("-" + dataBeanList.get(i).getAmount());
        } else if (dataBeanList.get(i).getType() == 3) {
            holder.itemPurHis_eggplantSeeds.setImageResource(R.mipmap.my_qiezi_green);
            holder.itemPurHis_spend.setText("+" + dataBeanList.get(i).getAmount());
        } else if (dataBeanList.get(i).getType() == 4) {
            holder.itemPurHis_eggplantSeeds.setImageResource(R.mipmap.my_qiezi);
            holder.itemPurHis_spend.setText("-" + dataBeanList.get(i).getAmount());
        }
    }

    @Override
    public int getItemCount() {
        return dataBeanList.isEmpty() ? 0 : dataBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView itemPurHis_use;
        public ImageView itemPurHis_eggplantSeeds;
        public TextView itemPurHis_spend;
        public TextView itemPurHis_introduction;
        public TextView itemPurHis_introduction2;
        public TextView itemPurHis_date;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemPurHis_use = (TextView) rootView.findViewById(R.id.itemPurHis_use);
            this.itemPurHis_eggplantSeeds = (ImageView) rootView.findViewById(R.id.itemPurHis_eggplantSeeds);
            this.itemPurHis_spend = (TextView) rootView.findViewById(R.id.itemPurHis_spend);
            this.itemPurHis_introduction = (TextView) rootView.findViewById(R.id.itemPurHis_introduction);
            this.itemPurHis_introduction2 = (TextView) rootView.findViewById(R.id.itemPurHis_introduction2);
            this.itemPurHis_date = (TextView) rootView.findViewById(R.id.itemPurHis_date);
        }
    }
}
