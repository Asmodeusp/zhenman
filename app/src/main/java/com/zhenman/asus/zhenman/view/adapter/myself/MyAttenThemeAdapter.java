package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.MyAttenThemeBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAttenThemeAdapter extends RecyclerView.Adapter<MyAttenThemeAdapter.Holder> {
    private List<MyAttenThemeBean.DataBean.ResultBean> dataBeanList;
    private Context context;
    private MyAttenThemeCallback myAttenThemeCallback;

    public MyAttenThemeAdapter(List<MyAttenThemeBean.DataBean.ResultBean> dataBeanList, Context context) {
        this.dataBeanList = dataBeanList;
        this.context = context;
    }

    public interface MyAttenThemeCallback {
        void makeAttention(String subjectId, int status);

    }

    public void MyAttenThemeCallback(MyAttenThemeCallback myAttenThemeCallback) {
        this.myAttenThemeCallback = myAttenThemeCallback;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_atten_theme, viewGroup, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Glide.with(context).load(dataBeanList.get(i).getImage()).into(holder.itemMyAttenTheme_headImage);
        holder.itemMyAttenTheme_title.setText(dataBeanList.get(i).getName());
        holder.itemMyAttenTheme_decription.setText(dataBeanList.get(i).getDescription());
        holder.itemMyAttenTheme_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button but = new Button(context);
                boolean tag = false;
                if (tag == false) {
                    myAttenThemeCallback.makeAttention(dataBeanList.get(i).getSubjectId(), 1);
                    holder.itemMyAttenTheme_attention.setText("已关注");
                    holder.itemMyAttenTheme_attention.setBackgroundDrawable(new ColorDrawable(R.drawable.attention_no_btn));

                    tag = true;
                } else {
                    holder.itemMyAttenTheme_attention.setText("关注");
                    myAttenThemeCallback.makeAttention(dataBeanList.get(i).getSubjectId(), 0);
                    holder.itemMyAttenTheme_attention.setBackgroundDrawable(new ColorDrawable(R.drawable.attention_btn));
                    tag = false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeanList.isEmpty() ? 0 : dataBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CircleImageView itemMyAttenTheme_headImage;
        public TextView itemMyAttenTheme_title;
        public TextView itemMyAttenTheme_decription;
        public Button itemMyAttenTheme_attention;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemMyAttenTheme_headImage = (CircleImageView) rootView.findViewById(R.id.itemMyAttenTheme_headImage);
            this.itemMyAttenTheme_title = (TextView) rootView.findViewById(R.id.itemMyAttenTheme_title);
            this.itemMyAttenTheme_decription = (TextView) rootView.findViewById(R.id.itemMyAttenTheme_decription);
            this.itemMyAttenTheme_attention = (Button) rootView.findViewById(R.id.itemMyAttenTheme_attention);
        }
    }
}
