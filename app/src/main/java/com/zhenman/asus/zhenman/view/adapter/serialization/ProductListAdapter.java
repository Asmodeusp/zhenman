package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.Holder> implements View.OnClickListener {
    private List<ProductListBean.DataBean> listBeanData;
    private Context context;
    private ProductListCallback croductListCallback;
    private CheckBox lastBox;

    public ProductListAdapter(List<ProductListBean.DataBean> listBeanData, Context context) {
        this.listBeanData = listBeanData;
        this.context = context;
    }

    public void ProductListCallback(ProductListCallback croductListCallback) {
        this.croductListCallback = croductListCallback;
    }


    public interface ProductListCallback {
        void showProductList(int position);

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_productlist, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        holder.itemProductList_num.setText("  X " + listBeanData.get(i).getShowPrice() + "");
        holder.itemView.setTag(i);
        holder.itemProductList_num.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lastBox == null) {
                    lastBox = holder.itemProductList_num;
                } else {
                    lastBox.setChecked(false);
                    lastBox = holder.itemProductList_num;
                }
                croductListCallback.showProductList(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeanData.isEmpty() ? 0 : listBeanData.size();
    }

    private OnItemShortListener myCLick;

    public interface OnItemShortListener {
        void myClick(View view, int position);
    }

    public void setRecyclerViewOnCLickListener(OnItemShortListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CheckBox itemProductList_num;
        public AutoRelativeLayout itemProductList;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemProductList = itemView.findViewById(R.id.itemProductList);
            this.itemProductList_num = (CheckBox) itemView.findViewById(R.id.itemProductList_num);

        }
    }

}
