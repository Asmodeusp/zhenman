package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.WorkDetailsCommentPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.view.adapter.home.HomeHotRecyAdapter;

import java.util.List;

//圆形图片
public class WorkDetailsActorRecyAdapter extends RecyclerView.Adapter<WorkDetailsActorRecyAdapter.Holder> implements View.OnClickListener {
    private List<SerializationDetailsBean.DataBean.ActorListBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    private boolean followCount = true;
   private WorkDetailsCommentPresenterImp presenter;
    public WorkDetailsActorRecyAdapter(List<SerializationDetailsBean.DataBean.ActorListBean> list, WorkDetailsCommentPresenterImp presenter) {
        this.list = list;
        this.presenter =presenter;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.fill_actor_recy, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }
    private goUserInfo clickGoUserInfo;

    public void setgoUserInfo( goUserInfo clickGoUserInfo) {
        this.clickGoUserInfo = clickGoUserInfo;
    }

    public interface goUserInfo {
        void go(String UserId);
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
        final SerializationDetailsBean.DataBean.ActorListBean listBean = list.get(position);
        holder.Actor_Position.setText(listBean.getTagName());
        holder.Actor_Name.setText(listBean.getName());
        holder.itemView.setTag(position);
        holder.Actor_Money.setVisibility(View.GONE);
        GlideUtils.loadCircleImage(listBean.getHeadImg(), holder.Actor_HeadImgdImg, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        });
        followCount = listBean.isFollow();
        if (followCount) {
            holder.Actor_followImg.setImageResource(R.mipmap.home_follow_on);
        }else{
            holder.Actor_followImg.setImageResource(R.mipmap.home_follow_off);
        }
        holder.Actor_followImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (followCount) {
                    holder.Actor_followImg.setImageResource(R.mipmap.home_follow_off);
                    presenter.FollowUser(listBean.getUserId(),"0");
                    followCount = false;
                }else{
                    holder.Actor_followImg.setImageResource(R.mipmap.home_follow_on);
                    presenter.FollowUser(listBean.getUserId(),"1");
                    followCount =true;
                }
            }
        });
        //头像点击事件
        holder.Actor_HeadImgdImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickGoUserInfo.go(listBean.getUserId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        //演员头像
        private ImageView Actor_HeadImgdImg;
        //演员职位
        private TextView Actor_Position;
        //演员名字
        private TextView Actor_Name;
        //关注
        private ImageView Actor_followImg;
        //打赏
        private TextView Actor_Money;

        public Holder(View itemView) {
            super(itemView);
            Actor_Name = itemView.findViewById(R.id.Actor_Name);
            Actor_HeadImgdImg = itemView.findViewById(R.id.Actor_HeadImgdImg);
            Actor_Position = itemView.findViewById(R.id.Actor_Position);
            Actor_followImg = itemView.findViewById(R.id.Actor_followImg);
            Actor_Money = itemView.findViewById(R.id.Actor_Money);
        }
    }
}
