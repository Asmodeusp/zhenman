package com.zhenman.asus.zhenman.view.adapter.myself;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ByFansBean;
import com.zhenman.asus.zhenman.model.bean.MyAttenThemeBean;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.MyFansBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAttenThemeAdapter extends RecyclerView.Adapter<MyAttenThemeAdapter.Holder> implements View.OnClickListener {
    //    private List<MyAttenThemeBean.DataBean.ResultBean> dataBeanList;
    List<Object> resultBeanList;
    private Context context;
    private OnShortCLickListener myCLick;
    private MyAttenThemeCallback myAttenThemeCallback;
    private boolean tag = true;

    public MyAttenThemeAdapter(List<Object> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
    }

    public interface MyAttenThemeCallback {
        void makeAttention(String subjectId, String status);
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
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Object object = resultBeanList.get(i);
        if (object instanceof MyAttenThemeBean.DataBean.ResultBean) {
            final MyAttenThemeBean.DataBean.ResultBean resultBean = (MyAttenThemeBean.DataBean.ResultBean) object;
            Glide.with(context).load(resultBean.getImage()).into(holder.itemMyAttenTheme_headImage);
            holder.itemMyAttenTheme_title.setText(resultBean.getName());
            holder.itemMyAttenTheme_decription.setText(resultBean.getDescription());
            holder.itemMyAttenTheme_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //                关注的时候要发送网络请求，状态参数   0去关注   1取消关注
                    if (tag == false) {
                        tag = true;
                        holder.itemMyAttenTheme_attention.setText("已关注");
                        holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#40a9ff"));
                        holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.yiguanzhu);
                        myAttenThemeCallback.makeAttention(resultBean.getSubjectId(), 1 + "");
                    } else {
                        tag = false;
                        holder.itemMyAttenTheme_attention.setText("关注");
                        holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#ffffff"));
                        holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.guanzhuzhuti);
                        myAttenThemeCallback.makeAttention(resultBean.getSubjectId(), 0 + "");

                    }
                }
            });
        }
        if (object instanceof MyFansBean.DataBean.ResultBean) {//粉丝列表
            final MyFansBean.DataBean.ResultBean resultBean = (MyFansBean.DataBean.ResultBean) object;
            Glide.with(context).load(resultBean.getImageUrl()).into(holder.itemMyAttenTheme_headImage);
            holder.itemMyAttenTheme_title.setText("@" + resultBean.getName());
            if (resultBean.getFollow() == 1) {
                holder.itemMyAttenTheme_attention.setText("+关注");
                holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#ffffff"));
                holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.fans_attention_btn);
            } else if (resultBean.getFollow() == 3) {
                holder.itemMyAttenTheme_attention.setText("相互关注");
                holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#aaaaaa"));
                holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.comment_popubackgound);
            }
            if (resultBean.getIntroduction() != null) {
                holder.itemMyAttenTheme_decription.setText(resultBean.getIntroduction());
            } else {
                holder.itemMyAttenTheme_decription.setText("本宝宝暂时没有简介哦~");
            }
            holder.itemMyAttenTheme_decription.setText("");
            holder.itemMyAttenTheme_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.itemMyAttenTheme_attention.getText().toString().equals("+关注")) {
                        holder.itemMyAttenTheme_attention.setText("相互关注");
                        holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#aaaaaa"));
                        holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.comment_popubackgound);
                        myAttenThemeCallback.makeAttention(resultBean.getUserId(), 1 + "");//关注
                    } else if (holder.itemMyAttenTheme_attention.getText().toString().equals("相互关注")) {
                        holder.itemMyAttenTheme_attention.setText("+关注");
                        holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#ffffff"));
                        holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.fans_attention_btn);
                        myAttenThemeCallback.makeAttention(resultBean.getUserId(), 0 + "");//取消关注
                    }
                }
            });
        }//MyAttentionUserBean.DataBean.ResultBean
        if (object instanceof MyAttentionUserBean.DataBean.ResultBean) {//关注列表
            final MyAttentionUserBean.DataBean.ResultBean resultBean = (MyAttentionUserBean.DataBean.ResultBean) object;
            Glide.with(context).load(resultBean.getImageUrl()).into(holder.itemMyAttenTheme_headImage);
            holder.itemMyAttenTheme_title.setText(resultBean.getName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-DD");
            String format = simpleDateFormat.format(new Date(Long.parseLong(resultBean.getAddTime())));
            holder.itemMyAttenTheme_decription.setText(format);
            if (resultBean.getFollow() == 1) {
                holder.itemMyAttenTheme_attention.setText("已关注");
                holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#aaaaaa"));
                holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.comment_popubackgound);
            } else if (resultBean.getFollow() == 3) {
                holder.itemMyAttenTheme_attention.setText("相互关注");
                holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#aaaaaa"));
                holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.comment_popubackgound);
            }
            holder.itemMyAttenTheme_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#ffffff"));
                    holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.fans_attention_btn);
                    myAttenThemeCallback.makeAttention(resultBean.getUserId(), 0 + "");//取消关注
                    notifyDataSetChanged();
//                    }
                }
            });
        }
        if (object instanceof ByFansBean.DataBean) {
            final ByFansBean.DataBean resultBean = (ByFansBean.DataBean) object;
            Glide.with(context).load(resultBean.getHeadImg()).into(holder.itemMyAttenTheme_headImage);
            holder.itemMyAttenTheme_title.setText(resultBean.getName());
//           时间转换
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-DD");
            String format = simpleDateFormat.format(new Date(Long.parseLong(resultBean.getAddTime())));
            holder.itemMyAttenTheme_decription.setText(format);
            if (resultBean.getFollow() == 2) {
                holder.itemMyAttenTheme_attention.setText("+关注");
                holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#ffffff"));
                holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.fans_attention_btn);
            } else if (resultBean.getFollow() == 3) {
                holder.itemMyAttenTheme_attention.setText("相互关注");
                holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#aaaaaa"));
                holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.comment_popubackgound);
            }

            holder.itemMyAttenTheme_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.itemMyAttenTheme_attention.getText().toString().equals("+关注")) {
                        holder.itemMyAttenTheme_attention.setText("相互关注");
                        holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#aaaaaa"));
                        holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.comment_popubackgound);
                        myAttenThemeCallback.makeAttention(resultBean.getUserId(), 1 + "");//关注
                    } else if (holder.itemMyAttenTheme_attention.getText().toString().equals("相互关注")) {
                        holder.itemMyAttenTheme_attention.setText("+关注");
                        holder.itemMyAttenTheme_attention.setTextColor(Color.parseColor("#ffffff"));
                        holder.itemMyAttenTheme_attention.setBackgroundResource(R.drawable.fans_attention_btn);
                        myAttenThemeCallback.makeAttention(resultBean.getUserId(), 0 + "");//取消关注
                    }
                }
            });
            holder.itemView.setTag(i);
        }
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }

    public interface OnShortCLickListener {
        void myClick(View view, int position);
    }

    public void setOnShortCLickListener(OnShortCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public int getItemCount() {
        return resultBeanList.isEmpty() ? 0 : resultBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CircleImageView itemMyAttenTheme_headImage;
        public TextView itemMyAttenTheme_title;
        public TextView itemMyAttenTheme_decription;
        public TextView itemMyAttenTheme_attention;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemMyAttenTheme_headImage = (CircleImageView) rootView.findViewById(R.id.itemMyAttenTheme_headImage);
            this.itemMyAttenTheme_title = (TextView) rootView.findViewById(R.id.itemMyAttenTheme_title);
            this.itemMyAttenTheme_decription = (TextView) rootView.findViewById(R.id.itemMyAttenTheme_decription);
            this.itemMyAttenTheme_attention = (TextView) rootView.findViewById(R.id.itemMyAttenTheme_attention);
        }
    }
}
