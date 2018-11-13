package com.zhenman.asus.zhenman.view.adapter.message;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.ByLikeBean;
import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;
import com.zhenman.asus.zhenman.utils.DataUtils;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class ByRewardedAdapter extends RecyclerView.Adapter<ByRewardedAdapter.Holder> implements View.OnClickListener {
    List<Object> dataBeanList;
    ByRewardedBean byRewardedBean;
    Context context;
    private OnShortCLickListener myCLick;
    private ByRewardedCallback byRewardedCallback;


    public ByRewardedAdapter(List<Object> dataBeanList, Context context) {
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
        Object object = dataBeanList.get(i);

        if (object instanceof ByRewardedBean.DataBean){
            final ByRewardedBean.DataBean resultBean = (ByRewardedBean.DataBean) object;
            if (dataBeanList!=null) {
                Glide.with(context).load(resultBean.getHeadImg()).into(holder.itemByRewarded_avatar);
                if (resultBean.getFinalImg()==null) {
                    holder.itemByRewarded_chapter.setVisibility(View.INVISIBLE);
                }else{
                    holder.itemByRewarded_chapter.setVisibility(View.VISIBLE);
                    Glide.with(context).load(resultBean.getFinalImg()).into(holder.itemByRewarded_chapter);
                }
                holder.itemByRewarded_chapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        byRewardedCallback.showChapterList(resultBean.getCatalogId());
                    }
                });

                final ArrayList<Integer> integers = new ArrayList<>();
                for (int i1 = 0; i1 < resultBean.getTitleDto().getTextExtra().size(); i1++) {
                    integers.add(resultBean.getTitleDto().getTextExtra().get(i1).getTextType());
                }
                //        设置富文本显示
                SpannableStringBuilder spannable = new SpannableStringBuilder(resultBean.getTitleDto().getText());
                for (int i1 = 0; i1 < integers.size(); i1++) {
                    final int finalI = i1;
                    spannable.setSpan(new ClickableSpan() {
                        @Override
                        public void onClick(View widget) {
                            if (integers.get(finalI) == 1) {//用户
                                Intent intent = new Intent(context, HomepageActivity.class);
                                intent.putExtra("him_id",resultBean.getUserId()+"");
                                context.startActivity(intent);
                            }
                            if (integers.get(finalI)==0){
                                Toast.makeText(context, "234343434r", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void updateDrawState(TextPaint ds) {
                            super.updateDrawState(ds);
                            if (integers.get(finalI) == 1) {
                                ds.setColor(Color.parseColor("#000000")); // 设置文本颜色
                                // 去掉下划线
                                ds.setUnderlineText(false);
                            }else if (integers.get(finalI)==0){//B37FEB
                                ds.setColor(Color.parseColor("#B37FEB")); // 设置紫色文本颜色
                                // 去掉下划线
                                ds.setUnderlineText(false);
                            }
                        }
                    },resultBean.getTitleDto().getTextExtra().get(i1).getStart(),resultBean.getTitleDto().getTextExtra().get(i1).getStart()+resultBean.getTitleDto().getTextExtra().get(i1).getLength(),Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                }
                //这个一定要记得设置，不然点击不生效
                holder.itemByRewarded_introduction.setMovementMethod(LinkMovementMethod.getInstance());
                holder.itemByRewarded_introduction.setText(spannable);
//            时间转换
                Date date = new Date(Long.parseLong(resultBean.getAddTime()));
                SimpleDateFormat format = new SimpleDateFormat("MM-dd", Locale.getDefault());
                String format2 = format.format(date);
                holder.itemByRewarded_time.setText(format2);
            }
        }if (object instanceof ByLikeBean.DataBean){
            final ByLikeBean.DataBean resultBean = (ByLikeBean.DataBean) object;
            if (resultBean.getFinalImg()==null) {
                holder.itemByRewarded_chapter.setVisibility(View.INVISIBLE);
            }else{
                holder.itemByRewarded_chapter.setVisibility(View.VISIBLE);
                Glide.with(context).load(resultBean.getFinalImg()).into(holder.itemByRewarded_chapter);
            }
            Glide.with(context)
                    .load(resultBean.getHeadImg())
                    .centerCrop()
                    .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
                    .error(R.mipmap.common_portrait_m)
                    .placeholder(R.mipmap.common_portrait_m)
                    .into(holder.itemByRewarded_avatar);
            SpannableString s = new SpannableString(resultBean.getTitleDto().getText());
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), resultBean.getTitleDto().getTextExtra().get(0).getStart(), (resultBean.getTitleDto().getTextExtra().get(0).getStart() + resultBean.getTitleDto().getTextExtra().get(0).getLength()), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            holder.itemByRewarded_introduction.setText(s);
            //            时间转换
//           如果时间超过一个月的话就显示mm_yy
            String newChatTime = DataUtils.getNewChatTime(Long.parseLong(resultBean.getAddTime()));
            holder.itemByRewarded_time.setText(newChatTime);
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
        return dataBeanList.isEmpty() ? 0 : dataBeanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public CircleImageView itemByRewarded_avatar;
        public TextView itemByRewarded_introduction;
        public TextView itemByRewarded_time;
        public ImageView itemByRewarded_chapter;

        public Holder(@NonNull View rootView) {
            super(rootView);
            this.itemByRewarded_avatar = (CircleImageView) rootView.findViewById(R.id.itemByRewarded_avatar);
            this.itemByRewarded_introduction = (TextView) rootView.findViewById(R.id.itemByRewarded_introduction);
            this.itemByRewarded_time = (TextView) rootView.findViewById(R.id.itemByRewarded_time);
            this.itemByRewarded_chapter = (ImageView) rootView.findViewById(R.id.itemByRewarded_chapter);
        }
    }
}
