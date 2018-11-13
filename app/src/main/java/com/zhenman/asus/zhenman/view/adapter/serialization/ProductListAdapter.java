package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

//茄子适配器
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.Holder> implements View.OnClickListener {
    private List<ProductListBean.DataBean> listBeanData;
    private Context context;
    private ProductListCallback croductListCallback;
    private View lastView;
    private View lastBg;

    public ProductListAdapter(List<ProductListBean.DataBean> listBeanData, Context context) {
        this.listBeanData = listBeanData;
        this.context = context;
    }
    public interface ProductListCallback {
        void showProductList(int position, int amount);

    }
    public void ProductListCallback(ProductListCallback croductListCallback) {
        this.croductListCallback = croductListCallback;
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
        int productType = listBeanData.get(i).getProductType();
        if (productType == 1) {
            holder.itemProductList_bite.setImageResource(R.mipmap.my_qiezi_bite);
        } else {
            holder.itemProductList_bite.setImageResource(R.mipmap.my_coin_small);
        }
        holder.itemProductList_num.setText("X " + listBeanData.get(i).getShowPrice()*100 + "");
        holder.itemView.setTag(i);
        holder.itemProductList_money.setText("￥" + listBeanData.get(i).getPrice()*100 + ".00");
        holder.itemProductList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastView != null&&lastBg!= null) {
                    lastBg.setBackgroundColor(Color.parseColor("#cccccc"));
                    lastView.setBackgroundResource(R.drawable.comment_popubackgound);
                }
                holder.itemProductList_moneyBg.setBackgroundColor(Color.parseColor("#b37feb"));
                holder.itemProductList.setBackgroundResource(R.drawable.actor_shape);
                lastView = holder.itemProductList;
                lastBg=holder.itemProductList_moneyBg;
                croductListCallback.showProductList(listBeanData.get(i).getId(), listBeanData.get(i).getPrice());
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
        public TextView itemProductList_num;
        public AutoRelativeLayout itemProductList;
        public ImageView itemProductList_moneyBg;
        public ImageView itemProductList_bite;
        public TextView itemProductList_money;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.itemProductList = itemView.findViewById(R.id.itemProductList);
            this.itemProductList_num = (TextView) itemView.findViewById(R.id.itemProductList_num);
            this.itemProductList_moneyBg = (ImageView) itemView.findViewById(R.id.itemProductList_moneyBg);
            this.itemProductList_bite = (ImageView) itemView.findViewById(R.id.itemProductList_bite);
            this.itemProductList_money = (TextView) itemView.findViewById(R.id.itemProductList_money);

        }
    }
}
