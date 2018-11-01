package com.zhenman.asus.zhenman.view.adapter.message;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ByRewardedAdapter extends RecyclerView.Adapter<ByRewardedAdapter.Holder> implements View.OnClickListener {
    List<ByRewardedBean.DataBean> dataBeanList;
    Context context;
    private OnShortCLickListener myCLick;
    private ByRewardedCallback byRewardedCallback;


    public ByRewardedAdapter(List<ByRewardedBean.DataBean> dataBeanList, Context context) {
        this.dataBeanList = dataBeanList;
        this.context = context;
    }
    public interface ByRewardedCallback {
        void showChapterList(int chapter);

    }
    public void ByRewardedCallback(ByRewardedCallback byRewardedCallback) {
        this.byRewardedCallback = byRewardedCallback;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_by_rewarded, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        Glide.with(context).load(dataBeanList.get(i).getHeadImg()).into(holder.itemByRewarded_avatar);
        holder.itemByRewarded_name.setText("@"+dataBeanList.get(i).getName());
        if (dataBeanList.get(i).getType() == 2) {//章节打赏
            Glide.with(context).load(dataBeanList.get(i).getFinalImg()).into(holder.itemByRewarded_chapter);
            if (dataBeanList.get(i).getEggplantType().equals("1")) {//1代表完整茄子
                holder.itemByRewarded_eggplantNum.setText(dataBeanList.get(i).getCoinAmount() + "个茄子");
            } else if (dataBeanList.get(i).getEggplantType().equals("2")) {//2是被咬了一口的茄子
                holder.itemByRewarded_eggplantNum.setText(dataBeanList.get(i).getCoinAmount() + "个被咬了一口的茄子");
            } else {//3是未成熟的茄子
                holder.itemByRewarded_eggplantNum.setText(dataBeanList.get(i).getCoinAmount() + "个未成熟的茄子");
            }

            holder.itemByRewarded_introduction.setText("在" + "《" + dataBeanList.get(i).getTitle() + "》" + "中打赏了你");
            holder.itemByRewarded_chapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    byRewardedCallback.showChapterList(dataBeanList.get(i).getCatalogId());
                }
            });
        } else if (dataBeanList.get(i).getType() == 3) {//个人主页打赏
            holder.itemByRewarded_avatar.setVisibility(View.INVISIBLE);
            holder.itemByRewarded_introduction.setText("打赏了你");
            if (dataBeanList.get(i).getEggplantType().equals("1")) {//1代表完整茄子
                holder.itemByRewarded_eggplantNum.setText(dataBeanList.get(i).getCoinAmount() + "个茄子");
            } else if (dataBeanList.get(i).getEggplantType().equals("2")) {//2是被咬了一口的茄子
                holder.itemByRewarded_eggplantNum.setText(dataBeanList.get(i).getCoinAmount() + "个被咬了一口的茄子");
            } else {//3是未成熟的茄子
                holder.itemByRewarded_eggplantNum.setText(dataBeanList.get(i).getCoinAmount() + "个未成熟的茄子");
            }
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
        return dataBeanList.isEmpty() ? 0 : dataBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CircleImageView itemByRewarded_avatar;
        public TextView itemByRewarded_name;
        public TextView itemByRewarded_introduction;
        public TextView itemByRewarded_eggplantNum;
        public ImageView itemByRewarded_chapter;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemByRewarded_avatar = (CircleImageView) rootView.findViewById(R.id.itemByRewarded_avatar);
            this.itemByRewarded_name = (TextView) rootView.findViewById(R.id.itemByRewarded_name);
            this.itemByRewarded_introduction = (TextView) rootView.findViewById(R.id.itemByRewarded_introduction);
            this.itemByRewarded_eggplantNum = (TextView) rootView.findViewById(R.id.itemByRewarded_eggplantNum);
            this.itemByRewarded_chapter = (ImageView) rootView.findViewById(R.id.itemByRewarded_chapter);
        }
    }
}
