package com.zhenman.asus.zhenman.view.adapter.home;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class HomeHotRecy_RecyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<HomeHotBean.DataBean.PageDtoListBean> list;
    private Context context;
    //MyAdapter需要一个Context，通过Context获得Layout.inflater，然后通过inflater加载item的布局
    public HomeHotRecy_RecyAdapter(Context context, List<HomeHotBean.DataBean.PageDtoListBean> datas) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.list = datas;
    }
    //返回数据集的长度
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    //这个方法才是重点，我们要为它编写一个ViewHolder
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.home_recy_fillview, parent, false); //加载布局
            holder = new ViewHolder();
            holder.home_Recy_recy_Image = convertView.findViewById(R.id.home_Recy_recy_Image);
            AutoUtils.autoSize(convertView);

            convertView.setTag(holder);
        } else {   //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImageUrl()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.home_Recy_recy_Image);
        return convertView;
    }
    //这个ViewHolder只能服务于当前这个特定的adapter，因为ViewHolder里会指定item的控件，不同的ListView，item可能不同，所以ViewHolder写成一个私有的类
    private class ViewHolder {
        ImageView home_Recy_recy_Image;

    }

}



