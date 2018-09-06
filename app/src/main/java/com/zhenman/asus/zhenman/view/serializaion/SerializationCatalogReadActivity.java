package com.zhenman.asus.zhenman.view.serializaion;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializationCatalogReadContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentListByOffSetBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.SerializationCatalogReadPresenterImp;
import com.zhenman.asus.zhenman.utils.alipay.AuthResult;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogFootviewCommentRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogReadActorAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.serializationCatalogReadRecyAdapter;
import com.zhenman.asus.zhenman.view.login.qqlogin.UMSharePlatform;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class SerializationCatalogReadActivity extends BaseActivity<SerializationCatalogReadPresenterImp> implements View.OnClickListener, SerializationCatalogReadContract.serializationCatalogReadView, CatalogReadActorAdapter.CatalogReadActorCallback {
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
    SerializationCatalogReadBean
            serializationCatalogReadBean;
    //章节更新时间
    private TextView ChapterDataText;
    //章节
    private TextView ChapterText;
    //章节名字
    private TextView ChapterNameText;

    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "2018060960348052";

    /**
     * 支付宝账户登录授权业务：入参pid值
     */
    public static final String PID = "2088131025795926";
    /**
     * 支付宝账户登录授权业务：入参target_id值
     */
    public static final String TARGET_ID = "";

    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /**
     * 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1
     */
    public static final String RSA2_PRIVATE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzB8Xr2vclEeuXreG7ZzYYaT9hZfFD4hbOIJFehG+UkbYPovwrd1b5dOW8bq4w+P9fQInbIqjKUXUBjtNkfoaESy5ijfLGqUXL3qnA2onkZ/K74hm6nWNRdiKcg28Zc9d+dDnq1PVnTf0eBVf1RK3VCI6MgYJ0+rc6fsu3Jms7KyFJ7J+NJpmHn4txDkw6+8MQkP5xvRjltaaO/khJHXz6C8Puhu7ioVHp2jtYEZjFnr7XlsxzXYbESkzn9irgm1wQvetHrjPVA0hXFmriXX9k1MBRo3L05da2cW32k5SQbjRcLogxzSH1h+TbJa8hEQe+xop46lMO0bXcBHfVvIhaQIDAQAB";
    public static final String RSA_PRIVATE = "";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            @SuppressWarnings("unchecked")
            AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
            String resultStatus = authResult.getResultStatus();

            // 判断resultStatus 为“9000”且result_code
            // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
            if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                // 获取alipay_open_id，调支付时作为参数extern_token 的value
                // 传入，则支付账户为该授权账户
                Toast.makeText(SerializationCatalogReadActivity.this,
                        "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                        .show();//单击一下
            } else {
                // 其他状态值则为授权失败
                Toast.makeText(SerializationCatalogReadActivity.this,
                        "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

            }
        }

        ;
    };
    private CatalogReadActorAdapter catalogReadActorAdapter;
    private String orderNumber;
    private RecyclerView commentPopu_recy;
    private TextView CommentPopu_CommentNumber;
    private ImageView CommentPopu_CommentCloseImg;
    private AutoRelativeLayout TopRela;
    private RecyclerView CommentPopu_Recy;
    private TextView CommentPopu_RecyTip;
    private EditText common_EdText;
    private Button common_sendEdText;
    private RecyclerView cataLog_footViewComment_recy;
    private TextView cataLog_footViewComment_recyTip;


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
        presenter.getPgcChapterCommentListByOffSetBean(StartcatalogId, "0", "300", "1");
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
        //评论列表
        cataLog_footViewComment_recy = footView.findViewById(R.id.CataLog_FootViewComment_Recy);
        //评论列表提示
        cataLog_footViewComment_recyTip = footView.findViewById(R.id.CataLog_FootViewComment_RecyTip);
        cataLog_footViewComment_recy.setLayoutManager(new LinearLayoutManager(this));

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
        if (serializationDetailsBean != null) {
            catalogReadActorAdapter = new CatalogReadActorAdapter(serializationDetailsBean.getData().getActorList());
            catalogReadActorAdapter.CatalogReadActorCallback(this);
            CataLog_FootViewActor_Recy.setAdapter(catalogReadActorAdapter);
        }

    }

    //章节实体类
    @Override
    public void showSerializationCatalogBean(SerializationCatalogBean
                                                     serializationCatalogBean) {
        if (serializationCatalogBean.getData() == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            data.addAll(serializationCatalogBean.getData());
        }
    }

    //阅读实体类
    @Override
    public void showserializationCatalogReadBean(SerializationCatalogReadBean
                                                         serializationCatalogReadBean) {

        if (serializationCatalogReadBean == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
            this.serializationCatalogReadBean = serializationCatalogReadBean;
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
        // 分享
        CataLog_FootViewShareBtn.setOnClickListener(this);
    }

    //消息弹出PopuWindow
    private void initCommentpopu() {
        //得到填充布局
        View contentView = LayoutInflater.from(this).inflate(R.layout.fill_comment_popu, null, false);
        //得到发送Edtext填充布局
        View sendView = LayoutInflater.from(this).inflate(R.layout.comment_popu_send, null);
        // 创建PopupWindow对象，其中：
        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 978, true);
        // 设置PopupWindow的背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);

        //设置摆放位置
        popupWindow.showAtLocation(SerializationRelativeLayout, Gravity.BOTTOM, 0, 0);
        //评论列表
        commentPopu_recy = contentView.findViewById(R.id.CommentPopu_Recy);
        //评论关闭Img
        CommentPopu_CommentCloseImg = contentView.findViewById(R.id.CommentPopu_CommentCloseImg);
        //评论数
        CommentPopu_CommentNumber = contentView.findViewById(R.id.CommentPopu_CommentNumber);
        View common_SendEdText = contentView.findViewById(R.id.common_SendEdText);
        if (serializationCatalogReadBean != null) {
            CommentPopu_CommentNumber.setText(String.valueOf(serializationCatalogReadBean.getData().getCount()));
        }
        //顶部Relativelayout
        TopRela = contentView.findViewById(R.id.TopRela);
        //评论列表提示
        CommentPopu_RecyTip = contentView.findViewById(R.id.CommentPopu_RecyTip);
        //评论输入框
        common_EdText = contentView.findViewById(R.id.common_EdText);
        //评论发送按钮
        common_sendEdText = contentView.findViewById(R.id.common_SendEdText);
        //geiRecyView设置格式
        commentPopu_recy.setLayoutManager(new LinearLayoutManager(this));
        //设置点击事件
        CommentPopu_CommentCloseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
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
        if (data.size() == 1) {
            CataLog_FootViewNexterText.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewNexterLine.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperText.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperLine.setTextColor(getResources().getColor(R.color.h4));
            CataLog_FootViewUpperBtn.setClickable(false);
            CataLog_FootViewNexterBtn.setClickable(false);
            weiwandaixuReLa.setVisibility(View.GONE);
        }
    }
    //创建订单的回调
    @Override
    public void makeOrder() {
        presenter.setMakeOrderData("1", "1", StartcatalogId, "262", "1", "支付");
    }
    //得到订单数据
    @Override
    public void getMakeOrderData(MakeOrderBean productListBean) {
        if (productListBean != null) {
            orderNumber = productListBean.getData().getOrderNumber();
            Log.e("Sunny", orderNumber + "++++++++++++");
            presenter.sendGetPayData(productListBean.getData().getOrderNumber());
        }
    }

    //    得到订单号,开始支付
    @Override
    public void showGetPayData(final GetPayDataBean getPayDataBean) {
        if (getPayDataBean.getData().getOrderSign() != null) {
            payV2(getPayDataBean.getData().getOrderSign());
        }

    }

    @Override
    public void showPgcChapterCommentListByOffSetBean(PgcChapterCommentListByOffSetBean pgcChapterCommentListByOffSetBean) {

        if (pgcChapterCommentListByOffSetBean != null) {
            if (pgcChapterCommentListByOffSetBean.getData().getResult().size() != 0) {
                cataLog_footViewComment_recy.setVisibility(View.VISIBLE);
                cataLog_footViewComment_recyTip.setVisibility(View.GONE);
                CatalogFootviewCommentRecyAdapter catalogFootviewCommentRecyAdapter = new CatalogFootviewCommentRecyAdapter(pgcChapterCommentListByOffSetBean.getData().getResult(), StartcatalogId, presenter);
                catalogFootviewCommentRecyAdapter.setClickZan(new CatalogFootviewCommentRecyAdapter.ClickZan() {
                    @Override
                    public void zan(String commentId, String status, String pgcId) {
                        presenter.PGCReadFabulous(StartcatalogId, commentId, status, pgcId);
                    }
                });
                cataLog_footViewComment_recy.setAdapter(catalogFootviewCommentRecyAdapter);
            } else {
                cataLog_footViewComment_recy.setVisibility(View.GONE);
                cataLog_footViewComment_recyTip.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void showPGCReadFabulousBean(PgcReadFabulousBean pgcReadFabulousBean) {
        Toast.makeText(this, pgcReadFabulousBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
    /**
     * 支付宝支付业务
     *
     * @param
     */
    public void payV2(final String orderSign) {
        Runnable authRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(SerializationCatalogReadActivity.this);
                Map<String, String> result = alipay.payV2(orderSign, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }
    /**
     * @throws
     * @MethodName:openInputMethod
     * @Description:打开系统软键盘
     */

    public void openInputMethod(final EditText editText) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            public void run() {

                InputMethodManager inputManager = (InputMethodManager) editText

                        .getContext().getSystemService(

                                Context.INPUT_METHOD_SERVICE);

                inputManager.showSoftInput(editText, 1);

            }

        }, 200);

    }
}