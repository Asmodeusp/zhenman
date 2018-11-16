package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

//PGC连载页面章节
public class SerializationCatalogAdapter extends RecyclerView.Adapter<SerializationCatalogAdapter.Holder> implements View.OnClickListener {
    private List<SerializationCatalogBean.DataBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    private String CatalogId;
    public SerializationCatalogAdapter(List<SerializationCatalogBean.DataBean> list,String CatalogId) {
        this.list = list;
        this.CatalogId = CatalogId;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_details_catalog_recy, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }

    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        SerializationCatalogBean.DataBean listBean = list.get(position);
        //转换时间
        String s = SPUtils.transferLongToDate(Long.valueOf(listBean.getAddTime()));
        holder.ChapterDataText.setText(s);
        if (listBean.getCatalogId().equals(CatalogId)) {
            holder.ChapterText.setTextColor(context.getResources().getColor(R.color.c1) );
        }
        holder.ChapterText.setText(listBean.getTitle());
        if ((listBean.getCoinAmount() + "").equals("null")) {
            holder.ChapterNameText.setText("");
        }
        holder.itemView.setTag(position);
        //1 免费   2付费
        if (listBean.getIsFree()==1) {

        }
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        //章节更新时间
        private TextView ChapterDataText;
        //章节
        private TextView ChapterText;
        //章节名字
        private TextView ChapterNameText;

        public Holder(View itemView) {
            super(itemView);
            ChapterText = itemView.findViewById(R.id.ChapterText);
            ChapterNameText = itemView.findViewById(R.id.ChapterNameText);
            ChapterDataText = itemView.findViewById(R.id.ChapterDataText);
            AutoUtils.autoSize(itemView);

        }
    }
}
