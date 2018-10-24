package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SellEggplantAdapter extends RecyclerView.Adapter<SellEggplantAdapter.Holder> {

    private SellEggplantCallback sellEggplantCallback;
    private SellEggplantNoSelectCallback sellEggplantNoSelectCallback;
    List<SellEggplantBean.DataBean> resultList;
    Context context;

    public SellEggplantAdapter(List<SellEggplantBean.DataBean> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    public interface SellEggplantCallback {
        void sellEggplantCallback(int eggId, int amount);
    }

    public interface SellEggplantNoSelectCallback {
        void sellEggplantNoSelectCallback(int eggId, int amount);
    }

    public void SellEggplantNoSelectCallback(SellEggplantNoSelectCallback sellEggplantNoSelectCallback) {
        this.sellEggplantNoSelectCallback = sellEggplantNoSelectCallback;
    }

    public void SellEggplantCallback(SellEggplantCallback sellEggplantCallback) {
        this.sellEggplantCallback = sellEggplantCallback;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sell_eggplant_item, viewGroup, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        if (String.valueOf(resultList.get(i).getEggplantAmount()) != null) {
            holder.sellEggplantItem_kind.setText("茄子 : " + resultList.get(i).getEggplantAmount());
            holder.sellEggplantItem_img.setImageResource(R.mipmap.my_qiezi_small);
        } else if (String.valueOf(resultList.get(i).getBiteEggplantAmount()) != null) {
            holder.sellEggplantItem_kind.setText("被咬了一口的茄子 : " + resultList.get(i).getBiteEggplantAmount());
            holder.sellEggplantItem_img.setImageResource(R.mipmap.my_qiezi_bite);
        } else if (String.valueOf(resultList.get(i).getUnripeEggplantAmount()) != null) {
            holder.sellEggplantItem_kind.setText("未成熟的茄子 : " + resultList.get(i).getUnripeEggplantAmount());
            holder.sellEggplantItem_img.setImageResource(R.mipmap.my_qiezi_green);
        }
        holder.sellEggplantItem_isSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (holder.sellEggplantItem_isSelect.isChecked()) {
                    if (i == 0) {
                        sellEggplantCallback.sellEggplantCallback(1, resultList.get(i).getEggplantAmount());
                    }
                    if (i == 1) {
                        sellEggplantCallback.sellEggplantCallback(2, resultList.get(i).getBiteEggplantAmount());
                    }
                    if (i == 2) {
                        sellEggplantCallback.sellEggplantCallback(3, resultList.get(i).getUnripeEggplantAmount());
                    }
                } else {
                    if (i == 0) {
                        sellEggplantCallback.sellEggplantCallback(1, resultList.get(i).getEggplantAmount());
                    }
                    if (i == 1) {
                        sellEggplantCallback.sellEggplantCallback(2, resultList.get(i).getBiteEggplantAmount());
                    }
                    if (i == 2) {
                        sellEggplantCallback.sellEggplantCallback(3, resultList.get(i).getUnripeEggplantAmount());
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultList.isEmpty() ? 0 : resultList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CircleImageView sellEggplantItem_img;
        public TextView sellEggplantItem_num;
        public TextView sellEggplantItem_kind;
        public CheckBox sellEggplantItem_isSelect;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.sellEggplantItem_img = (CircleImageView) itemView.findViewById(R.id.sellEggplantItem_img);
            this.sellEggplantItem_num = (TextView) itemView.findViewById(R.id.sellEggplantItem_num);
            this.sellEggplantItem_kind = (TextView) itemView.findViewById(R.id.sellEggplantItem_kind);
            this.sellEggplantItem_isSelect = (CheckBox) itemView.findViewById(R.id.sellEggplantItem_isSelect);
        }
    }
}
