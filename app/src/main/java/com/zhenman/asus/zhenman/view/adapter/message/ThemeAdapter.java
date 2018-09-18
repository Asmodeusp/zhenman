package com.zhenman.asus.zhenman.view.adapter.message;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.TheamBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.Holder> implements View.OnClickListener {
    private List<TheamBean.DataBean> dataBeanList;
    private Context context;
    private ThemeCallback themeCallback;

    public ThemeAdapter(List<TheamBean.DataBean> dataBeanList, Context context) {
        this.dataBeanList = dataBeanList;
        this.context = context;
    }

    public interface ThemeCallback {
        void makeAttention(String subjectId, int status);

    }

    public void ThemeCallback(ThemeCallback themeCallback) {
        this.themeCallback = themeCallback;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_theme, viewGroup, false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Glide.with(context).load(dataBeanList.get(i).getImage()).into(holder.itemTheme_headImage);
        holder.itemTheme_title.setText(dataBeanList.get(i).getName());
        holder.itemTheme_description.setText(dataBeanList.get(i).getDescription());
        List<String> list = dataBeanList.get(i).getList();
        if (list.size() == 0) {
            holder.itemTheme_coverImage1.setVisibility(View.INVISIBLE);
            holder.itemTheme_coverImage2.setVisibility(View.INVISIBLE);
            holder.itemTheme_coverImage3.setVisibility(View.INVISIBLE);
            holder.itemTheme_coverImage4.setVisibility(View.INVISIBLE);
        }
        if (list.size() == 1) {
            Glide.with(context).load(dataBeanList.get(i).getList().get(i)).into(holder.itemTheme_coverImage1);
            holder.itemTheme_coverImage2.setVisibility(View.INVISIBLE);
            holder.itemTheme_coverImage3.setVisibility(View.INVISIBLE);
            holder.itemTheme_coverImage4.setVisibility(View.INVISIBLE);
        }
        if (list.size() == 2) {
            Glide.with(context).load(dataBeanList.get(i).getList().get(0)).into(holder.itemTheme_coverImage1);
            Glide.with(context).load(dataBeanList.get(i).getList().get(1)).into(holder.itemTheme_coverImage2);

            holder.itemTheme_coverImage3.setVisibility(View.INVISIBLE);
            holder.itemTheme_coverImage4.setVisibility(View.INVISIBLE);
        }
        if (list.size() == 3) {
            Glide.with(context).load(dataBeanList.get(i).getList().get(0)).into(holder.itemTheme_coverImage1);
            Glide.with(context).load(dataBeanList.get(i).getList().get(1)).into(holder.itemTheme_coverImage2);
            Glide.with(context).load(dataBeanList.get(i).getList().get(2)).into(holder.itemTheme_coverImage3);
            holder.itemTheme_coverImage4.setVisibility(View.INVISIBLE);
        }
        if (list.size() == 4) {
            Glide.with(context).load(dataBeanList.get(i).getList().get(0)).into(holder.itemTheme_coverImage1);
            Glide.with(context).load(dataBeanList.get(i).getList().get(1)).into(holder.itemTheme_coverImage2);
            Glide.with(context).load(dataBeanList.get(i).getList().get(2)).into(holder.itemTheme_coverImage3);
            Glide.with(context).load(dataBeanList.get(i).getList().get(3)).into(holder.itemTheme_coverImage4);
        }
        holder.itemView.setTag(i);
        holder.itemTheme_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button but = new Button(context);
                boolean tag = false;
                if (tag == false) {
                    themeCallback.makeAttention(dataBeanList.get(i).getSubjectId(), 1);
                    holder.itemTheme_attention.setText("已关注");
                    holder.itemTheme_attention.setBackgroundDrawable(new ColorDrawable(R.drawable.attention_no_btn));

                    tag = true;
                } else {
                    holder.itemTheme_attention.setText("关注");
                    themeCallback.makeAttention(dataBeanList.get(i).getSubjectId(), 0);
                    holder.itemTheme_attention.setBackgroundDrawable(new ColorDrawable(R.drawable.attention_btn));

                    tag = false;
                }
               /* if (holder.itemTheme_attention.) {
                    holder.itemTheme_attention.setBackgroundDrawable(new ColorDrawable(R.drawable.attention_no_btn));
                    themeCallback.makeAttention(dataBeanList.get(i).getSubjectId(), 1);
                    holder.itemTheme_attention.setText("已关注");
                } else {
                    holder.itemTheme_attention.setBackgroundDrawable(new ColorDrawable(R.drawable.attention_btn));
                    holder.itemTheme_attention.setText("关注");
                    themeCallback.makeAttention(dataBeanList.get(i).getSubjectId(), 0);

                }
*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBeanList.isEmpty() ? 0 : dataBeanList.size();
    }

    //布局监听事件
    private OnShortListener myCLick;

    public interface OnShortListener {
        void myClick(View view, int position);
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CircleImageView itemTheme_headImage;
        public TextView itemTheme_title;
        public TextView itemTheme_description;
        public Button itemTheme_attention;
        public ImageView itemTheme_coverImage1;
        public ImageView itemTheme_coverImage2;
        public ImageView itemTheme_coverImage3;
        public ImageView itemTheme_coverImage4;
        public AutoRelativeLayout theme_details;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemTheme_headImage = (CircleImageView) rootView.findViewById(R.id.itemTheme_headImage);
            this.itemTheme_title = (TextView) rootView.findViewById(R.id.itemTheme_title);
            this.itemTheme_description = (TextView) rootView.findViewById(R.id.itemTheme_description);
            this.itemTheme_attention = (Button) rootView.findViewById(R.id.itemTheme_attention);
            this.itemTheme_coverImage1 = (ImageView) rootView.findViewById(R.id.itemTheme_coverImage1);
            this.itemTheme_coverImage2 = (ImageView) rootView.findViewById(R.id.itemTheme_coverImage2);
            this.itemTheme_coverImage3 = (ImageView) rootView.findViewById(R.id.itemTheme_coverImage3);
            this.itemTheme_coverImage4 = (ImageView) rootView.findViewById(R.id.itemTheme_coverImage4);
            this.theme_details = (AutoRelativeLayout) rootView.findViewById(R.id.theme_details);
        }
    }
}
