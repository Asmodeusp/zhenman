package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


public class ClassifySubjectTagsRecyAdapter extends RecyclerView.Adapter<ClassifySubjectTagsRecyAdapter.Holder> implements View.OnClickListener {
    private List<ClassifyTagBean.DataBean.SubjectTagsBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;

    public ClassifySubjectTagsRecyAdapter(List<ClassifyTagBean.DataBean.SubjectTagsBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_classify_tag_recy, parent, false);
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
        holder.fill_classifyTags_Recy.setText(list.get(position).getTagName());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {

        //标签内容
        private TextView fill_classifyTags_Recy;

        public Holder(View itemView) {
            super(itemView);
            fill_classifyTags_Recy = itemView.findViewById(R.id.fill_classifyTags_Recy);
            AutoUtils.autoSize(itemView);

        }
    }
}
