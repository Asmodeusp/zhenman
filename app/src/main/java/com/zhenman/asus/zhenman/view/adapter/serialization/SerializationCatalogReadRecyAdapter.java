package com.zhenman.asus.zhenman.view.adapter.serialization;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import java.util.List;
//阅读的RecyclerView的适配器
public class SerializationCatalogReadRecyAdapter extends RecyclerView.Adapter<SerializationCatalogReadRecyAdapter.Holder> implements View.OnClickListener {
    private List<SerializationCatalogReadBean.DataBean.TransferBean> list;
    private Context context;
    public SerializationCatalogReadRecyAdapter(List<SerializationCatalogReadBean.DataBean.TransferBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_recy_fillview, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        SerializationCatalogReadBean.DataBean.TransferBean dataBean = list.get(position);

        Glide.with(context).load(dataBean.getImageUrl()).into(holder.home_Recy_recy_Image);
        holder.itemView.setTag(position);
    }
    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    private RecyclerViewOnCLickListener myCLick;

    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
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
        return list.isEmpty() ? 0 : list.size();
    }
    public class Holder extends RecyclerView.ViewHolder {
        private ImageView home_Recy_recy_Image;
        public Holder(View itemView) {
            super(itemView);
            home_Recy_recy_Image = itemView.findViewById(R.id.home_Recy_recy_Image);

        }
    }
}
