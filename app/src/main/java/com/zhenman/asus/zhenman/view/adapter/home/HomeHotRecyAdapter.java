package com.zhenman.asus.zhenman.view.adapter.home;


import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.view.ui.NotifyDataSetChangedForRv;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.MyLayoutMessage;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;

import java.util.List;

public class HomeHotRecyAdapter extends RecyclerView.Adapter<HomeHotRecyAdapter.Holder> {
    private List<HomeHotBean.DataBean> list;
    private Context context;
    ViewPagerLayoutManager linearLayoutManager;
    RecyclerView homeHot_list;
    NotifyDataSetChangedForRv mNotifyDataSetChangedForRv;

    public HomeHotRecyAdapter(List<HomeHotBean.DataBean> list, ViewPagerLayoutManager linearLayoutManager, RecyclerView homeHot_list, NotifyDataSetChangedForRv notifyDataSetChangedForRv) {
        this.list = list;
        this.linearLayoutManager = linearLayoutManager;
        this.homeHot_list = homeHot_list;
        this.mNotifyDataSetChangedForRv = notifyDataSetChangedForRv;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_fill_recy, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        final HomeHotBean.DataBean dataBean = list.get(position);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenHeight(context));
        holder.home_fillView.setLayoutParams(layoutParams);
        final MyLayoutMessage myLayoutMessage = new MyLayoutMessage(context);
        final HomeHotRecyItemAdapter homeHotRecyItemAdapter = new HomeHotRecyItemAdapter(dataBean.getPageDtoList());
        holder.home_Recy_fill_Recy.setAdapter(homeHotRecyItemAdapter);
        holder.home_Recy_fill_Recy.setLayoutManager(myLayoutMessage);
        //计算填充Recycler View高度
        double i = (double) dataBean.getHeight() / dataBean.getWidth();
        double InsideHight = i * (double) ScreenUtils.getScreenWidth(context);
        linearLayoutManager.setScrollEnabled(false);
        myLayoutMessage.setScrollEnabled(true);
        //内部滑动监听
        holder.home_Recy_fill_Recy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                //得到当前显示的第一个item的view
                View firstChildView = recyclerView.getLayoutManager().getChildAt(0);
                //得到firstChildView的Top坐标值
                int firstChildTop = firstChildView.getTop();
                //得到Recyclerview的顶坐标减去顶部padding值，也就是显示内容最顶部的坐标
                int recyclerTop = recyclerView.getTop() - recyclerView.getPaddingTop();
                //通过这个firstChildView得到这个view当前的position值
                int firstPosition = recyclerView.getLayoutManager().getPosition(firstChildView);
                /*
                 * home_Recy_fill_Recy(里面填充的RecyclerView)
                 * 向下滑动
                 *
                 * **/
                if (dy > 0) {
//                    linearLayoutManager.setScrollEnabled(false);
//                    myLayoutMessage.setScrollEnabled(true);
//                    Log.e("wai_nei", "false_true");
                }
                //得到当前显示的最后一个item的view
                View lastChildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                //得到lastChildView的bottom坐标值
                int lastChildBottom = lastChildView.getBottom();
                //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
                int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                //通过这个lastChildView得到这个view当前的position值
                int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);
//                if (lastChildBottom != recyclerBottom && lastPosition != recyclerView.getLayoutManager().getItemCount() - 1) {
//                    linearLayoutManager.setScrollEnabled(false);
//                }


                /*
                 *   当里面向上滑动时
                 *       开启里面滑动
                 *       关闭外层滑动
                 * **/
                if (dy < 0) {
                    linearLayoutManager.setScrollEnabled(false);
                    //myLayoutMessage.setScrollEnabled(true);
//                            Log.e("wai_nei","true_true");
                }
//
//                    /*
//                     *   当里面向下滑动时
//                     *       开启里面滑动
//                     *       关闭外层滑动
//                     * **/
                if (dy > 0) {
                    linearLayoutManager.setScrollEnabled(false);
//                        myLayoutMessage.setScrollEnabled(true);
//                        Log.e("wai_nei", "true_true");
//                        homeHot_list.setY(0);
                }


                if(dy == 0){
                    //linearLayoutManager.setScrollEnabled(true);
                }


                //如果两个条件都满足则说明是真正的滑动到了底部
                if (lastChildBottom == recyclerBottom && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1  && dy > 0) {


                    if(list.get(position).isOpenSwich){
//                       list.get(position).isOpenSwich = false;
//                       linearLayoutManager.setScrollEnabled(true);
                        // myLayoutMessage.setScrollEnabled(true);

                        if(null != mNotifyDataSetChangedForRv){
                            mNotifyDataSetChangedForRv.notifyDataSetChanged(position,false);
                        }
                        // holder.home_Recy_fill_Recy.getParent().requestDisallowInterceptTouchEvent(false);
                    }


                }

                //如果两个条件都满足则说明是真正的滑动到了顶部
                else if (firstChildTop == recyclerTop && firstPosition == 0 && dy < 0) {
//                    linearLayoutManager.setScrollEnabled(true);
                    if(list.get(position).isOpenSwich){
                        list.get(position).isOpenSwich = false;
//                    list.get(position).isOpenSwich = true;
                        if(null != mNotifyDataSetChangedForRv && position > 0){
                            mNotifyDataSetChangedForRv.notifyDataSetChanged(position,true);
                        }
                        // holder.home_Recy_fill_Recy.getParent().requestDisallowInterceptTouchEvent(false);
//                       linearLayoutManager.setScrollEnabled(true);
//                   linearLayoutManager.setScrollEnabled(true);
                        //myLayoutMessage.setScrollEnabled(false);
                    }

                }else{
                    if(!list.get(position).isOpenSwich){
                        list.get(position).isOpenSwich = true;
                        //linearLayoutManager.setScrollEnabled(false);
                        // holder.home_Recy_fill_Recy.getParent().requestDisallowInterceptTouchEvent(true);
                        //myLayoutMessage.setScrollEnabled(true);
                    }

//                   if( list.get(position).isOpenSwich){
//                       list.get(position).isOpenSwich = false;
//                       if(null != mNotifyDataSetChangedForRv){
//                           //mNotifyDataSetChangedForRv.notifyDataSetChanged(position);
//                       }
//                   }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        //ListView
        public RecyclerView home_Recy_fill_Recy;
        //整个布局ID
        private RelativeLayout home_fillView;

        public Holder(View itemView) {
            super(itemView);
            home_Recy_fill_Recy = itemView.findViewById(R.id.home_Recy_fill_Recy);
            home_fillView = itemView.findViewById(R.id.home_fillView);

        }
    }
}
