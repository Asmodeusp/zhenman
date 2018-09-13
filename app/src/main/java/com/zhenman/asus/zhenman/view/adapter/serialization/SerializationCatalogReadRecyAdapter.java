package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;

import java.util.List;


public class SerializationCatalogReadRecyAdapter extends RecyclerView.Adapter<SerializationCatalogReadRecyAdapter.Holder> implements View.OnClickListener {
    private List<SerializationCatalogReadBean.DataBean.ListBean> list;
    private Context context;
    public SerializationCatalogReadRecyAdapter(List<SerializationCatalogReadBean.DataBean.ListBean> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_recy_fillview, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        SerializationCatalogReadBean.DataBean.ListBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getImageUrl()).into(holder.home_Recy_recy_Image);
        holder.itemView.setTag(position);
    }
    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    private RecyclerViewOnCLickListener myCLick;

    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }
    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }
    public class Holder extends RecyclerView.ViewHolder {

        private ImageView home_Recy_recy_Image;
        public Holder(View itemView) {
            super(itemView);
            home_Recy_recy_Image = itemView.findViewById(R.id.home_Recy_recy_Image);

        }
    }
}
//public class SerializationCatalogReadRecyAdapter extends BaseAdapter {
//    ImageView home_Recy_recy_Image;
//    private LayoutInflater mInflater;
//    private List<SerializationCatalogReadBean.DataBean.ListBean> list;
//    private Context context;
//    private Handler mHandler;
//
//    //MyAdapter需要一个Context，通过Context获得Layout.inflater，然后通过inflater加载item的布局
//    public SerializationCatalogReadRecyAdapter(Context context, List<SerializationCatalogReadBean.DataBean.ListBean> datas) {
//        this.context = context;
//        this.mInflater = LayoutInflater.from(context);
//        this.list = datas;
//        mHandler = new Handler();
//    }
//
//    //返回数据集的长度
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    //这个方法才是重点，我们要为它编写一个ViewHolder
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        ViewHolder holder = null;
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.home_recy_fillview, parent, false); //加载布局
//            home_Recy_recy_Image = convertView.findViewById(R.id.home_Recy_recy_Image);
//            holder = new ViewHolder();
//            holder.home_Recy_recy_Image = convertView.findViewById(R.id.home_Recy_recy_Image);
//            AutoUtils.autoSize(convertView);
//            convertView.setTag(holder);
//            holder.home_Recy_recy_Image.setTag(R.id.home_Recy_recy_Image, list.get(position).getImageUrl());
//            Log.d("serializationCatalogRea", list.get(position).getImageUrl());
//        } else {   //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
//            holder = (ViewHolder) convertView.getTag();
//
//        }
//
//        if (list.get(position).getImageUrl().equals(holder.home_Recy_recy_Image.getTag(R.id.home_Recy_recy_Image))) {
//            Glide.with(context).load(list.get(position).getImageUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).skipMemoryCache(true).into(home_Recy_recy_Image);
////            Log.d("serializationCatalogRea", list.get(position).getImageUrl());
//        } else {
//            // 如果不相同，就加载。现在在这里来改变闪烁的情况
//            Glide.with(context).load(list.get(position).getImageUrl()).into(holder.home_Recy_recy_Image);
//            //给加载图片的控件设置Tag
//            holder.home_Recy_recy_Image.setTag(R.id.home_Recy_recy_Image, list.get(position).getImageUrl());
//        }
////        Glide.with(context).load(list.get(position).getImageUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).skipMemoryCache(true).into(holder.home_Recy_recy_Image);
//
//        return convertView;
//    }
//
//    //这个ViewHolder只能服务于当前这个特定的adapter，因为ViewHolder里会指定item的控件，不同的ListView，item可能不同，所以ViewHolder写成一个私有的类
//    private class ViewHolder {
//        ImageView home_Recy_recy_Image;
//
//    }
//
//}



