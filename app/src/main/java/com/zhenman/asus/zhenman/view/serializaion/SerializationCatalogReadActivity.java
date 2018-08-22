package com.zhenman.asus.zhenman.view.serializaion;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.serializationCatalogReadContract;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.SerializationCatalogReadPresenterImp;
import com.zhenman.asus.zhenman.utils.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.CatalogReadActorAdapter;
import com.zhenman.asus.zhenman.view.adapter.SerializationCatalogAdapter;
import com.zhenman.asus.zhenman.view.adapter.serializationCatalogReadRecyAdapter;
import com.zhenman.asus.zhenman.view.login.qqlogin.UMSharePlatform;

import java.util.ArrayList;
import java.util.List;

public class SerializationCatalogReadActivity extends BaseActivity<SerializationCatalogReadPresenterImp> implements View.OnClickListener, serializationCatalogReadContract.serializationCatalogReadView {
    public String StartcatalogId;
    private ImageView serializationCatalogReadReturnImg;
    private TextView serializationCatalogReadText;
    private TextView serializationCatalogReadCommentNumber;
    private LinearLayout serializationCatalogReadHeadRel;
    private RelativeLayout SerializationRelativeLayout;
    private ListView serializationCatalogReadRecy;
    private LinearLayout serializationCatalogReadCommentBtn;
    private LinearLayout serializationCatalogReadCatalogBtn;
    private RelativeLayout serializationCatalogReadFootLin;
    private boolean count = false;
    private LinearLayout SeeFirstBtn;
    private ImageView CataLog_FootViewCollectionImg;
    private LinearLayout CataLog_FootViewCollectionBtn;
    private LinearLayout CataLog_FootViewShareBtn;
    private TextView CataLog_FootViewUpperText;
    private TextView CataLog_FootViewUpperLine;
    private LinearLayout CataLog_FootViewUpperBtn;
    private TextView CataLog_FootViewNexterText;
    private TextView CataLog_FootViewNexterLine;
    private LinearLayout CataLog_FootViewNexterBtn;
    private RecyclerView CataLog_FootViewActor_Recy;
    private TextView CataLog_PopuTitle;
    private ImageView CataLog_PopuPosition;
    private ImageView CataLog_PopuBottom;
    private RecyclerView CataLog_PopuRecy;
    private List<SerializationCatalogBean.DataBean> data = new ArrayList<>();
    private SerializationCatalogAdapter serializationCatalogAdapter;
    private RelativeLayout weiwandaixuReLa;
    private int i;
    //章节更新时间
    private TextView ChapterDataText;
    //章节
    private TextView ChapterText;
    //章节名字
    private TextView ChapterNameText;

    public String getStartcatalogId() {
        return StartcatalogId;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_serialization_catalog_read;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        StartcatalogId = intent.getStringExtra("catalogId");
        String PgcId = intent.getStringExtra("pgcId");

        //返回
        serializationCatalogReadReturnImg = findViewById(R.id.serializationCatalogReadReturnImg);
        //整布局
        SerializationRelativeLayout = findViewById(R.id.SerializationRelativeLayout);
        //第几话
        serializationCatalogReadText = findViewById(R.id.serializationCatalogReadText);
        //头布局
        serializationCatalogReadHeadRel = findViewById(R.id.serializationCatalogReadHeadRel);
        //ListView
        serializationCatalogReadRecy = findViewById(R.id.serializationCatalogReadRecy);
        //评论
        serializationCatalogReadCommentBtn = findViewById(R.id.serializationCatalogReadCommentBtn);
        //评论数量
        serializationCatalogReadCommentNumber = findViewById(R.id.CatalogReadCommentNumber);
        //目录
        serializationCatalogReadCatalogBtn = findViewById(R.id.serializationCatalogReadCatalogBtn);
        //底布局
        serializationCatalogReadFootLin = findViewById(R.id.serializationCatalogReadFootLin);
        //得到数据
        presenter.getSerializationCatalogReadBean(StartcatalogId);
        presenter.getSerializationCatalogBean(PgcId);
        presenter.getSerializationDetailsBean(PgcId);
        //设置点击事件
        serializationCatalogReadReturnImg.setOnClickListener(this);//返回
        serializationCatalogReadCommentBtn.setOnClickListener(this);//消息
        serializationCatalogReadCatalogBtn.setOnClickListener(this);//目录

        serializationCatalogReadRecy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //触摸按下时操作
                        if (count == true) {
                            serializationCatalogReadHeadRel.setVisibility(View.GONE);
                            serializationCatalogReadFootLin.setVisibility(View.GONE);
                            count = false;
                        } else {
                            serializationCatalogReadHeadRel.setVisibility(View.VISIBLE);
                            serializationCatalogReadFootLin.setVisibility(View.VISIBLE);
                            count = true;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 触摸移动时的操作h
                        serializationCatalogReadHeadRel.setVisibility(View.GONE);
                        serializationCatalogReadFootLin.setVisibility(View.GONE);
                        count = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        // 触摸抬起时的操作

                        break;
                }
                return false;
            }
        });
        //滑动监听
        serializationCatalogReadRecy.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        //滑动停止
                        serializationCatalogReadHeadRel.setVisibility(View.GONE);
                        serializationCatalogReadFootLin.setVisibility(View.GONE);
                        count = true;
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        //正在滚动
                        serializationCatalogReadHeadRel.setVisibility(View.GONE);
                        serializationCatalogReadFootLin.setVisibility(View.GONE);
                        break;
                    case SCROLL_STATE_FLING:
                        //惯性继续滚动
                        serializationCatalogReadHeadRel.setVisibility(View.GONE);
                        serializationCatalogReadFootLin.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
        InitFootView();
    }

    //初始化底布局
    private void InitFootView() {
        View footView = LayoutInflater.from(this).inflate(R.layout.serializationcatalog_footview, null, false);
        //观看第一话
        SeeFirstBtn = footView.findViewById(R.id.SeeFirstBtn);
        //收藏图片
        CataLog_FootViewCollectionImg = footView.findViewById(R.id.CataLog_FootViewCollectionImg);
        //收藏点击按钮
        CataLog_FootViewCollectionBtn = footView.findViewById(R.id.CataLog_FootViewCollectionBtn);
        //分享按钮
        CataLog_FootViewShareBtn = footView.findViewById(R.id.CataLog_FootViewShareBtn);
        //上一话字体
        CataLog_FootViewUpperText = footView.findViewById(R.id.CataLog_FootViewUpperText);
        CataLog_FootViewUpperLine = footView.findViewById(R.id.CataLog_FootViewUpperLine);
        //上一话按钮
        CataLog_FootViewUpperBtn = footView.findViewById(R.id.CataLog_FootViewUpperBtn);
        //下一话字体
        CataLog_FootViewNexterText = footView.findViewById(R.id.CataLog_FootViewNexterText);
        CataLog_FootViewNexterLine = footView.findViewById(R.id.CataLog_FootViewNexterLine);
        //下一话按钮
        CataLog_FootViewNexterBtn = footView.findViewById(R.id.CataLog_FootViewNexterBtn);
        //演员列表
        CataLog_FootViewActor_Recy = footView.findViewById(R.id.CataLog_FootViewActor_Recy);
        //未完待续布局
        weiwandaixuReLa = footView.findViewById(R.id.weiwandaixuReLa);
        CataLog_FootViewUpperText.setText("<");
        //添加底布局
        serializationCatalogReadRecy.addFooterView(footView);
        CataLog_FootViewUpperBtn.setOnClickListener(this);
        CataLog_FootViewNexterBtn.setOnClickListener(this);
        SeeFirstBtn.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CataLog_FootViewActor_Recy.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
   //获取详情
    @Override
    public void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean) {
        if (serializationDetailsBean!=null) {
            CataLog_FootViewActor_Recy.setAdapter(new CatalogReadActorAdapter(serializationDetailsBean.getData().getActorList()));
        }
    }

    //章节实体类
    @Override
    public void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean) {
        if (serializationCatalogBean.getData() == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            data.addAll(serializationCatalogBean.getData());
        }
    }

    //阅读实体类
    @Override
    public void showserializationCatalogReadBean(SerializationCatalogReadBean serializationCatalogReadBean) {
        if (serializationCatalogReadBean == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            serializationCatalogReadRecyAdapter serializationCatalogReadRecyAdapter = new serializationCatalogReadRecyAdapter(this, serializationCatalogReadBean.getData().getList());
            serializationCatalogReadRecy.setAdapter(serializationCatalogReadRecyAdapter);
            serializationCatalogReadText.setText(serializationCatalogReadBean.getData().getTitle());
            serializationCatalogReadRecyAdapter.notifyDataSetChanged();
            serializationCatalogReadCommentNumber.setText(String.valueOf(serializationCatalogReadBean.getData().getCount()));
        }
        if (data != null) {
            SetTextColorRules();
        }
    }

    //章节弹出popuWindow
    private void initCataLogpopu() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.fill_catalog_popu, null, false);
        //书名
        CataLog_PopuTitle = contentView.findViewById(R.id.CataLog_PopuTitle);
        CataLog_PopuTitle.setText((CharSequence) SPUtils.get(this, "DetaailsName", "海贼"));
        //定位
        CataLog_PopuPosition = contentView.findViewById(R.id.CataLog_PopuPosition);
        CataLog_PopuPosition.setVisibility(View.GONE);
        //下载
        CataLog_PopuBottom = contentView.findViewById(R.id.CataLog_PopuBottom);
        CataLog_PopuBottom.setVisibility(View.GONE);
        //节目列表RecyView
        CataLog_PopuRecy = contentView.findViewById(R.id.CataLog_PopuRecy);
        CataLog_PopuRecy.setLayoutManager(new LinearLayoutManager(this));
        serializationCatalogAdapter = new SerializationCatalogAdapter(data);
        CataLog_PopuRecy.setAdapter(serializationCatalogAdapter);
        serializationCatalogAdapter.notifyDataSetChanged();
        serializationCatalogAdapter.setRecyclerViewOnCLickListener(new SerializationCatalogAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                String catalogId = data.get(position).getCatalogId();
                presenter.getSerializationCatalogReadBean(catalogId);

            }
        });
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        PopupWindow popupWindow = new PopupWindow(contentView, 560, ViewGroup.LayoutParams.MATCH_PARENT, true);
        // 设置PopupWindow的背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(SerializationRelativeLayout, Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        //设置PopupWindow中View的点击事件
        //定位
        CataLog_PopuPosition.setOnClickListener(this);
        //下载
        CataLog_PopuBottom.setOnClickListener(this);
//        分享
        CataLog_FootViewShareBtn.setOnClickListener(this);
    }

    //消息弹出PopuWindow
    private void initCommentpopu() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.fill_comment_popu, null, false);
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 978, true);
        // 设置PopupWindow的背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
        //设置摆放位置
        popupWindow.showAtLocation(SerializationRelativeLayout, Gravity.BOTTOM, 0, 0);
        //设置PopupWindow中View的点击事件

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回
            case R.id.serializationCatalogReadReturnImg:
                finish();
                break;
            //弹出评论
            case R.id.serializationCatalogReadCommentBtn:
                initCommentpopu();
                break;
            //弹出章节目录
            case R.id.serializationCatalogReadCatalogBtn:
                initCataLogpopu();
                break;
            //POPUWindow定位
            case R.id.CataLog_PopuPosition:

                break;
            //POPUWindow下载
            case R.id.CataLog_PopuBottom:

                break;
                //第一话
            case R.id.SeeFirstBtn:
                StartcatalogId = data.get(data.size() - 1).getCatalogId();
                presenter.getSerializationCatalogReadBean(StartcatalogId);
               SetTextColorRules();
                break;
            //上一话
            case R.id.CataLog_FootViewUpperBtn:
                //得到现在章节的索引
                for (SerializationCatalogBean.DataBean datum : data) {
                    if (datum.getCatalogId().equals(StartcatalogId)) {
                        i = data.indexOf(datum);
                    }
                }
                StartcatalogId = data.get(i + 1).getCatalogId();
                presenter.getSerializationCatalogReadBean(StartcatalogId);

                SetTextColorRules();
                //填充头布局
                serializationCatalogReadHeadRel.setVisibility(View.GONE);
                //填充底布局
                serializationCatalogReadFootLin.setVisibility(View.GONE);
                break;
            //下一话
            case R.id.CataLog_FootViewNexterBtn:
                //得到现在章节的索引
                for (SerializationCatalogBean.DataBean datum : data) {
                    if (datum.getCatalogId().equals(StartcatalogId)) {
                        i = data.indexOf(datum);
                    }
                }
                StartcatalogId = data.get(i - 1).getCatalogId();
                presenter.getSerializationCatalogReadBean(StartcatalogId);
                serializationCatalogReadHeadRel.setVisibility(View.GONE);
                serializationCatalogReadFootLin.setVisibility(View.GONE);
                SetTextColorRules();

                break;
//                分享
            case R.id.CataLog_FootViewShareBtn:
                UMSharePlatform.getImstance().shareImage(SerializationCatalogReadActivity.this);
                break;

        }
    }

    private void SetTextColorRules() {
        //第一话
        if (data.get(data.size() - 1).getCatalogId().equals(StartcatalogId)) {
            CataLog_FootViewNexterText.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewNexterLine.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewUpperText.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperLine.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperBtn.setClickable(false);
            CataLog_FootViewNexterBtn.setClickable(true);
            weiwandaixuReLa.setVisibility(View.GONE);
            //最后一话
        } else if (data.get(0).getCatalogId().equals(StartcatalogId)) {
            CataLog_FootViewNexterText.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewNexterLine.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperText.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewUpperLine.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewUpperBtn.setClickable(true);
            CataLog_FootViewNexterBtn.setClickable(false);
            weiwandaixuReLa.setVisibility(View.VISIBLE);
            //其他
        } else {
            CataLog_FootViewNexterText.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewNexterLine.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewUpperText.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewUpperLine.setTextColor(getResources().getColor(R.color.h2));
            CataLog_FootViewUpperBtn.setClickable(true);
            CataLog_FootViewNexterBtn.setClickable(true);
            weiwandaixuReLa.setVisibility(View.GONE);
        }
        if (data.size()==1) {
            CataLog_FootViewNexterText.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewNexterLine.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperText.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperLine.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperBtn.setClickable(false);
            CataLog_FootViewNexterBtn.setClickable(false);
            weiwandaixuReLa.setVisibility(View.GONE);
        }
    }

}
