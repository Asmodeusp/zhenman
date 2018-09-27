package com.zhenman.asus.zhenman.view.adapter.home;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

import org.w3c.dom.Text;

import java.util.List;


public class HomeAttentionRecyAdapter extends RecyclerView.Adapter<HomeAttentionRecyAdapter.Holder> {
    private List<HomeAttentionBean.DataBean> list;
    private Context context;

    public HomeAttentionRecyAdapter(List<HomeAttentionBean.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_home_attentionrecy, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {


    }


    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        //头像
        private ImageView fill_Home_Attention_RecyHeadIew;
        //用户名
        private TextView fill_Home_Attention_RecyUserNameText;
        //发布时间
        private TextView fill_Home_Attention_RecyTimeText;
        //描述
        private TextView fill_Home_Attention_RecyDescriptionText;
        //作评图片
        private ImageView fill_Home_Attention_RecyImageView;
        //分享按钮
        private AutoLinearLayout fill_Home_Attention_RecyShareButton;
        //评论按钮
        private AutoLinearLayout fill_Home_Attention_RecyCommentButton;
        //点赞按钮
        private AutoLinearLayout fill_Home_Attention_RecyLikeButton;
        //分享数量
        private TextView fill_Home_Attention_RecyShareNumberText;

        public Holder(View itemView) {
            super(itemView);

            fill_Home_Attention_RecyHeadIew = itemView.findViewById(R.id.fill_Home_Attention_RecyHeadImageView);
            fill_Home_Attention_RecyUserNameText = itemView.findViewById(R.id.fill_Home_Attention_RecyUserNameText);
            fill_Home_Attention_RecyTimeText = itemView.findViewById(R.id.fill_Home_Attention_RecyTimeText);
            fill_Home_Attention_RecyDescriptionText = itemView.findViewById(R.id.fill_Home_Attention_RecyDescriptionText);
            fill_Home_Attention_RecyImageView = itemView.findViewById(R.id.fill_Home_Attention_RecyImageView);
            fill_Home_Attention_RecyShareButton = itemView.findViewById(R.id.fill_Home_Attention_RecyShareButton);
            fill_Home_Attention_RecyCommentButton = itemView.findViewById(R.id.fill_Home_Attention_RecyCommentButton);
            fill_Home_Attention_RecyLikeButton = itemView.findViewById(R.id.fill_Home_Attention_RecyLikeButton);
            fill_Home_Attention_RecyShareNumberText = itemView.findViewById(R.id.fill_Home_Attention_RecyShareNumberText);
            AutoUtils.autoSize(itemView);
        }
    }
}
