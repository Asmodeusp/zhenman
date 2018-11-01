package com.zhenman.asus.zhenman.view.adapter.message;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;
import com.zhenman.asus.zhenman.utils.MyClickSpan;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ByRewardedAdapter extends RecyclerView.Adapter<ByRewardedAdapter.Holder> implements View.OnClickListener {
    List<ByRewardedBean.DataBean> dataBeanList;
    ByRewardedBean byRewardedBean;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_by_rewarded, viewGroup, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Glide.with(context).load(dataBeanList.get(i).getHeadImg()).into(holder.itemByRewarded_avatar);
        if (dataBeanList.get(i).getType() == 2) {//章节打赏
            /*if (dataBeanList.get(i).getTitleDto() != null) {

                MyClickSpan.setTextHighLightWithClick(holder.itemByRewarded_introduction, byRewardedBean.getData().get(i).getTitleDto().getText(), byRewardedBean.getData().get(i).getTitleDto().getTextExtra(), new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
//                    Toast.makeText(context, listBean.getTextDto().getTextExtra().get(0).getText(), Toast.LENGTH_SHORT).show();
                    }
                });
                SpannableString spannableString = MyClickSpan.matcherSearchTitle(Color.parseColor("#000000"), dataBeanList.get(i).getTitle(), dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getText());//黑色名字
                SpannableString spannableStringEnd = MyClickSpan.matcherSearchTitle(Color.parseColor("#B37FEB"), dataBeanList.get(i).getTitle(), dataBeanList.get(i).getTitleDto().getTextExtra().get(1).getText());//紫色茄子
                holder.itemByRewarded_introduction.setText(spannableString+"打赏了你"+spannableStringEnd);


            }*/
            SpannableString spannableString = MyClickSpan.matcherSearchTitle(Color.parseColor("#000000"), dataBeanList.get(i).getTitleDto().getText(), dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getText());//黑色名字
            SpannableString spannableStringEnd = MyClickSpan.matcherSearchTitle(Color.parseColor("#B37FEB"), dataBeanList.get(i).getTitleDto().getText(), dataBeanList.get(i).getTitleDto().getTextExtra().get(1).getText());//紫色茄子
            holder.itemByRewarded_introduction.setText(spannableString+"在《"+dataBeanList.get(i).getTitle()+"》中"+spannableStringEnd);
            Glide.with(context).load(dataBeanList.get(i).getFinalImg()).into(holder.itemByRewarded_chapter);

            /*if (dataBeanList.get(i).getEggplantType().equals("1")) {//1代表完整茄子
                String s = "<font color=\"#000000\">"+"@"+dataBeanList.get(i).getName()+"</font><font color=\"#999999\">"+"在《" + dataBeanList.get(i).getTitle() + "》" + "中打赏了你"+"</font><font color=\"#B37FEB\">"+dataBeanList.get(i).getCoinAmount() + "个茄子"+"</font>";
                holder.itemByRewarded_introduction.setText(Html.fromHtml(s));
            } else if (dataBeanList.get(i).getEggplantType().equals("2")) {//2是被咬了一口的茄子
                String s = "<font color=\"#000000\">"+"@"+dataBeanList.get(i).getName()+"</font><font color=\"#999999\">"+"在《" + dataBeanList.get(i).getTitle() + "》" + "中打赏了你"+"</font><font color=\"#B37FEB\">"+dataBeanList.get(i).getCoinAmount() + "个被咬了一口的茄子"+"</font>";
                holder.itemByRewarded_introduction.setText(Html.fromHtml(s));
            } else {//3是未成熟的茄子
                String s = "<font color=\"#000000\">"+"@"+dataBeanList.get(i).getName()+"</font><font color=\"#999999\">"+"在《" + dataBeanList.get(i).getTitle() + "》" + "中打赏了你"+"</font><font color=\"#B37FEB\">"+dataBeanList.get(i).getCoinAmount() + "个未成熟的茄子"+"</font>";
                holder.itemByRewarded_introduction.setText(Html.fromHtml(s));
            }*/
            holder.itemByRewarded_chapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    byRewardedCallback.showChapterList(dataBeanList.get(i).getCatalogId());
                }
            });
        } else if (dataBeanList.get(i).getType() == 3) {//个人主页打赏
            holder.itemByRewarded_chapter.setVisibility(View.INVISIBLE);
            /*if (dataBeanList.get(i).getEggplantType().equals("1")) {//1代表完整茄子
                String s = "<font color=\"#000000\">"+"@"+dataBeanList.get(i).getName()+"</font><font color=\"#999999\">"+"打赏了你"+"</font><font color=\"#B37FEB\">"+dataBeanList.get(i).getCoinAmount() + "个茄子"+"</font>";
                holder.itemByRewarded_introduction.setText(Html.fromHtml(s));
            } else if (dataBeanList.get(i).getEggplantType().equals("2")) {//2是被咬了一口的茄子
                String s = "<font color=\"#000000\">"+"@"+dataBeanList.get(i).getName()+"</font><font color=\"#999999\">"+"打赏了你"+"</font><font color=\"#B37FEB\">"+dataBeanList.get(i).getCoinAmount() + "个被咬了一口的茄子"+"</font>";
                holder.itemByRewarded_introduction.setText(Html.fromHtml(s));
            } else {//3是未成熟的茄子
                String s = "<font color=\"#000000\">"+"@"+dataBeanList.get(i).getName()+"</font><font color=\"#999999\">"+"打赏了你"+"</font><font color=\"#B37FEB\">"+dataBeanList.get(i).getCoinAmount() + "个未成熟的茄子"+"</font>";
                holder.itemByRewarded_introduction.setText(Html.fromHtml(s));
            }*/
            SpannableString spannableString = MyClickSpan.matcherSearchTitle(Color.parseColor("#000000"), dataBeanList.get(i).getTitleDto().getText(), dataBeanList.get(i).getTitleDto().getTextExtra().get(0).getText());//黑色名字
            SpannableString spannableStringEnd = MyClickSpan.matcherSearchTitle(Color.parseColor("#B37FEB"), dataBeanList.get(i).getTitleDto().getText(), dataBeanList.get(i).getTitleDto().getTextExtra().get(1).getText());//紫色茄子
            holder.itemByRewarded_introduction.setText(spannableString);
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
        public TextView itemByRewarded_introduction;
        public ImageView itemByRewarded_chapter;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemByRewarded_avatar = (CircleImageView) rootView.findViewById(R.id.itemByRewarded_avatar);
            this.itemByRewarded_introduction = (TextView) rootView.findViewById(R.id.itemByRewarded_introduction);
            this.itemByRewarded_chapter = (ImageView) rootView.findViewById(R.id.itemByRewarded_chapter);
        }
    }
}
