package com.zhenman.asus.zhenman.view.serializaion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
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
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializationCatalogReadContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentListByOffSetBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.SerializationCatalogReadPresenterImp;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.alipay.AuthResult;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogFootviewCommentRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogReadActorAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ProductListAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogReadRecyAdapter;
import com.zhenman.asus.zhenman.view.login.qqlogin.UMSharePlatform;
import com.zhenman.asus.zhenman.view.ui.MyRefreshAnimHeader;
import com.zhenman.asus.zhenman.view.ui.MyScrollView;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SerializationCatalogReadActivity extends BaseActivity<SerializationCatalogReadPresenterImp> implements View.OnClickListener, SerializationCatalogReadContract.serializationCatalogReadView, CatalogReadActorAdapter.CatalogReadActorCallback, ProductListAdapter.ProductListCallback {
    public String StartcatalogId;

    private ImageView serializationCatalogReadReturnImg;
    private TextView serializationCatalogReadText;
    private TextView serializationCatalogReadCommentNumber;
    private LinearLayout serializationCatalogReadHeadRel;
    private RelativeLayout SerializationRelativeLayout;
    private RecyclerView serializationCatalogReadRecy;
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
    private int catalogId;
    SerializationCatalogReadBean
            serializationCatalogReadBean;
    //章节更新时间
    private TextView ChapterDataText;
    //章节
    private TextView ChapterText;
    //章节名字
    private TextView ChapterNameText;

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    private PopupWindow popupWindow;
    private View popupView1;
    private RecyclerView ppwPay_productList;
    private RadioGroup ppwPay_radioGroup;
    private RadioButton ppwPay_zhifubaoBtn;
    private RadioButton ppwPay_weixinBtn;
    private Button ppwPay_payBtn;
    private TextView ppwPay_payMoney;
    private TextView ppwPay_qieziNum;
    private TextView ppwPay_num;
    private TextView ppwPay_userName;
    private CatalogReadActorAdapter catalogReadActorAdapter;
    private String orderNumber;
    private RecyclerView commentPopu_recy;
    private TextView CommentPopu_CommentNumber;
    private ImageView CommentPopu_CommentCloseImg;
    private AutoRelativeLayout TopRela;
    private TextView CommentPopu_RecyTip;
    private RecyclerView cataLog_footViewComment_recy;
    private TextView cataLog_footViewComment_recyTip;
    private CatalogFootviewCommentRecyAdapter catalogFootviewCommentRecyAdapter;
    private List<PgcChapterCommentListByOffSetBean.DataBean.ResultBeanX> result = new ArrayList<>();
    private EditText commentPopu_editText;
    private Button commonSend_button;
    private EditText commonSend_edText;
    private Button commentPopu_button;
    private PopupWindow commentpopupWindow;
    private View contentView;
    private RelativeLayout commentPopu_rela;
    private String paymentMethod;
    private int qieziId;
    private MyScrollView serializationMyScrollView;
    int PageNum = 1;
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
    private SmartRefreshLayout serializationCatalogReadSRL;
    private SerializationCatalogReadRecyAdapter serializationCatalogReadRecyAdapter;
    private MyRefreshAnimHeader myRefreshAnimHeader;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_serialization_catalog_read;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void init() {
        Intent intent = getIntent();
        StartcatalogId = intent.getStringExtra("catalogId");
        String PgcId = intent.getStringExtra("pgcId");
        //得到数据
        presenter.getSerializationCatalogReadBean(StartcatalogId);
        presenter.getSerializationCatalogBean(PgcId);
        presenter.getSerializationDetailsBean(PgcId);
        presenter.getPgcChapterCommentListByOffSetBean(StartcatalogId, "0", "300", "1");
        //返回
        serializationCatalogReadReturnImg = findViewById(R.id.serializationCatalogReadReturnImg);
        //刷新控件
        serializationCatalogReadSRL = findViewById(R.id.serializationCatalogReadSRL);
        //MyScrollView
        serializationMyScrollView = findViewById(R.id.SerializationMyScrollView);
        //整布局
        SerializationRelativeLayout = findViewById(R.id.SerializationRelativeLayout);
        //第几话
        serializationCatalogReadText = findViewById(R.id.serializationCatalogReadText);
        //头布局
        serializationCatalogReadHeadRel = findViewById(R.id.serializationCatalogReadHeadRel);
        //RecyclerView
        serializationCatalogReadRecy = findViewById(R.id.serializationCatalogReadRecy);
        //给RecyClerView设置格式
        serializationCatalogReadRecy.setLayoutManager(new LinearLayoutManager(this));
        //评论
        serializationCatalogReadCommentBtn = findViewById(R.id.serializationCatalogReadCommentBtn);
        //评论数量
        serializationCatalogReadCommentNumber = findViewById(R.id.CatalogReadCommentNumber);
        //目录
        serializationCatalogReadCatalogBtn = findViewById(R.id.serializationCatalogReadCatalogBtn);
        //底布局
        serializationCatalogReadFootLin = findViewById(R.id.serializationCatalogReadFootLin);
        //观看第一话
        SeeFirstBtn = findViewById(R.id.SeeFirstBtn);
        //收藏图片
        CataLog_FootViewCollectionImg = findViewById(R.id.CataLog_FootViewCollectionImg);
        //收藏点击按钮
        CataLog_FootViewCollectionBtn = findViewById(R.id.CataLog_FootViewCollectionBtn);
        //分享按钮
        CataLog_FootViewShareBtn = findViewById(R.id.CataLog_FootViewShareBtn);
        //上一话字体
        CataLog_FootViewUpperText = findViewById(R.id.CataLog_FootViewUpperText);
        CataLog_FootViewUpperLine = findViewById(R.id.CataLog_FootViewUpperLine);
        //上一话按钮
        CataLog_FootViewUpperBtn = findViewById(R.id.CataLog_FootViewUpperBtn);
        //下一话字体
        CataLog_FootViewNexterText = findViewById(R.id.CataLog_FootViewNexterText);
        CataLog_FootViewNexterLine = findViewById(R.id.CataLog_FootViewNexterLine);
        //下一话按钮
        CataLog_FootViewNexterBtn = findViewById(R.id.CataLog_FootViewNexterBtn);
        //演员列表
        CataLog_FootViewActor_Recy = findViewById(R.id.CataLog_FootViewActor_Recy);
        //未完待续布局
        weiwandaixuReLa = findViewById(R.id.weiwandaixuReLa);
        CataLog_FootViewUpperText.setText("<");
        CataLog_FootViewUpperBtn.setOnClickListener(this);
        CataLog_FootViewNexterBtn.setOnClickListener(this);
        SeeFirstBtn.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CataLog_FootViewActor_Recy.setLayoutManager(linearLayoutManager);
        //评论列表
        cataLog_footViewComment_recy = findViewById(R.id.CataLog_FootViewComment_Recy);
        //评论列表提示
        cataLog_footViewComment_recyTip = findViewById(R.id.CataLog_FootViewComment_RecyTip);
        cataLog_footViewComment_recy.setLayoutManager(new LinearLayoutManager( this));
        serializationCatalogReadSRL.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {

            }
        });
        if (result.size()==0) {
            cataLog_footViewComment_recy.setVisibility(View.GONE);
            cataLog_footViewComment_recyTip.setVisibility(View.VISIBLE);
        }
        //设置点击事件
        serializationCatalogReadReturnImg.setOnClickListener(this);//返回
        serializationCatalogReadCommentBtn.setOnClickListener(this);//消息
        serializationCatalogReadCatalogBtn.setOnClickListener(this);//目录
        serializationMyScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //触摸按下时操作
                        Log.e("ScrollView", "按下");
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
                        Log.e("ScrollView", "移动");
                        // 触摸移动时的操作
                        serializationCatalogReadHeadRel.setVisibility(View.GONE);
                        serializationCatalogReadFootLin.setVisibility(View.GONE);
                        count = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        // 触摸抬起时的操作
                        Log.e("ScrollView", "抬起");
                        break;
                }
                return false;
            }
        });

        myRefreshAnimHeader = new MyRefreshAnimHeader(this);
        myRefreshAnimHeader.setPrimaryColors(R.color.h1);

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
        serializationCatalogReadSRL.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                presenter.getSerializationCatalogReadBean(StartcatalogId);
                serializationCatalogReadRecyAdapter.notifyDataSetChanged();
                refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                serializationCatalogReadSRL.setRefreshHeader(myRefreshAnimHeader);
            }
        });
        if (serializationCatalogReadBean == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
            this.serializationCatalogReadBean = serializationCatalogReadBean;
        } else {

            serializationCatalogReadRecyAdapter = new SerializationCatalogReadRecyAdapter(serializationCatalogReadBean.getData().getList());
            serializationCatalogReadRecy.setAdapter(serializationCatalogReadRecyAdapter);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(SerializationCatalogReadActivity.this, R.anim.recy_item);
            serializationCatalogReadRecy.setLayoutAnimation(animation);
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
    @SuppressLint("WrongConstant")
    private void initCommentpopu() {
        contentView = LayoutInflater.from(this).inflate(R.layout.fill_comment_popu, null, false);

        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        commentpopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, 978, true);
        // 设置PopupWindow的背景
        commentpopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        commentpopupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        commentpopupWindow.setTouchable(true);
        //设置摆放位置
        commentpopupWindow.showAtLocation(SerializationRelativeLayout, Gravity.BOTTOM, 0, 0);
        //顶部Relativelayout
        TopRela = contentView.findViewById(R.id.TopRela);
        //评论关闭Img
        CommentPopu_CommentCloseImg = contentView.findViewById(R.id.CommentPopu_CommentCloseImg);
        //评论数
        CommentPopu_CommentNumber = contentView.findViewById(R.id.CommentPopu_CommentNumber);
        //全部布局
        commentPopu_rela = contentView.findViewById(R.id.CommentPopu_Rela);
        //评论列表提示
        CommentPopu_RecyTip = contentView.findViewById(R.id.CommentPopu_RecyTip);
        //评论列表
        commentPopu_recy = contentView.findViewById(R.id.CommentPopu_Recy);
        //geiRecyView设置格式
        commentPopu_recy.setLayoutManager(new LinearLayoutManager(this));
        if (result.size() != 0) {
            CommentPopu_RecyTip.setVisibility(View.VISIBLE);
            commentPopu_recy.setVisibility(View.GONE);
        } else {
            CommentPopu_RecyTip.setVisibility(View.GONE);
            commentPopu_recy.setVisibility(View.VISIBLE);
        }

        commentPopu_recy.setAdapter(catalogFootviewCommentRecyAdapter);
        //设置点击事件
        CommentPopu_CommentCloseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentpopupWindow.dismiss();
            }
        });

        if (serializationCatalogReadBean != null) {
            CommentPopu_CommentNumber.setText(String.valueOf(serializationCatalogReadBean.getData().getCount()) + "条评论");
        }
        commentPopu_editText = contentView.findViewById(R.id.CommentPopu_EdText);
        commentPopu_editText.setVisibility(View.GONE);
        commentPopu_button = contentView.findViewById(R.id.CommentPopu_Button);
        commentPopu_editText.setOnClickListener(this);
        commentPopu_button.setOnClickListener(this);

        commentpopupWindow.setSoftInputMode(WindowManager.LayoutParams.FLAG_LOCAL_FOCUS_MODE);
    }

    private void initSendCommentPopu() {
        //得到发送Edtext填充布局
        View sendView = LayoutInflater.from(this).inflate(R.layout.comment_popu_send, null);
        //获取屏幕宽高
        int weight = getResources().getDisplayMetrics().widthPixels;

        PopupWindow SendCommentpopupWindow = new PopupWindow(sendView, weight, 98, true);
        // 设置PopupWindow的背景
        SendCommentpopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        SendCommentpopupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        SendCommentpopupWindow.setTouchable(true);
        //评论输入框
        commonSend_edText = sendView.findViewById(R.id.commonSend_EdText);
        //评论发送按钮
        commonSend_button = sendView.findViewById(R.id.commonSend_Button);
        SendCommentpopupWindow.showAtLocation(SerializationRelativeLayout, Gravity.BOTTOM, 0, 0);

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
            case R.id.CommentPopu_EdText:
//                initSendCommentPopu();
                break;
            case R.id.CommentPopu_Button:
                initSendCommentPopu();
                break;
            //发送评论
            case R.id.commonSend_Button:
                break;
            //                分享
            case R.id.CataLog_FootViewShareBtn:
                UMSharePlatform.getImstance().shareImage(SerializationCatalogReadActivity.this);
                break;
            case R.id.ppwPay_payBtn:
                if (paymentMethod.equals("1")) {
                    presenter.setWxMakeOrderData(qieziId + "", "1", StartcatalogId, "262", "0.1", "支付");

                } else if (paymentMethod.equals("2")) {
                    presenter.setMakeOrderData(qieziId + "", "1", StartcatalogId, "262", "1", "支付");
                } else {
                    Toast.makeText(this, "请选择支付方式", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    private void SetTextColorRules() {

        if (data != null&&data.size()!=0) {
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

    }

    private void showPopueWindow() {
        popupView1 = LayoutInflater.from(this).inflate(R.layout.ppw_pay, null);

        ppwPay_productList = popupView1.findViewById(R.id.ppwPay_productList);
        ppwPay_radioGroup = popupView1.findViewById(R.id.ppwPay_radioGroup);
        ppwPay_zhifubaoBtn = popupView1.findViewById(R.id.ppwPay_zhifubaoBtn);
        ppwPay_weixinBtn = popupView1.findViewById(R.id.ppwPay_weixinBtn);
        ppwPay_payBtn = popupView1.findViewById(R.id.ppwPay_payBtn);
        ppwPay_payMoney = popupView1.findViewById(R.id.ppwPay_payMoney);
        ppwPay_qieziNum = popupView1.findViewById(R.id.ppwPay_qieziNum);
        ppwPay_num = popupView1.findViewById(R.id.ppwPay_num);
        ppwPay_userName = popupView1.findViewById(R.id.ppwPay_userName);

        //获取屏幕宽高
        int weight = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels * 1 / 2;

        popupWindow = new PopupWindow(popupView1, weight, height);
        // popupWindow.setAnimationStyle(R.style.anim_popup_dir);
        popupWindow.setFocusable(true);
        //点击外部popueWindow消失
        popupWindow.setOutsideTouchable(true);
        ppwPay_payBtn.setOnClickListener(this);
        ppwPay_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ppwPay_weixinBtn:
                        paymentMethod = "1";
                        break;
                    case R.id.ppwPay_zhifubaoBtn:
                        paymentMethod = "2";
                        break;
                }
            }
        });
        //popupWindow消失屏幕变为不透明
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
        popupWindow.showAtLocation(popupView1, Gravity.BOTTOM, 0, 0);

    }


    //得到订单数据
    @Override
    public void getMakeOrderData(MakeOrderBean productListBean) {
        if (productListBean.getData().getOrderNumber() != null) {
            orderNumber = productListBean.getData().getOrderNumber();
            presenter.sendGetPayData(orderNumber);
        }
    }

    //得到微信订单数据
    @Override
    public void getWxMakeOrderData(MakeOrderBean payWeChatBean) {
        if (payWeChatBean.getData().getOrderNumber() != null) {
            presenter.sendGetWxPayData(payWeChatBean.getData().getOrderNumber());
        }
    }

    //    得到订单号,开始支付
    @Override
    public void showGetPayData(final GetPayDataBean getPayDataBean) {
        if (getPayDataBean.getData().getOrderSign() != null) {
            payV2(getPayDataBean.getData().getOrderSign());
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    //得到微信支付数据
    @Override
    public void showGetWxPayData(PayWeChatBean payWeChatBean) {
        if (payWeChatBean.getData().getOrderSign() != null) {
            payV1(payWeChatBean.getData().getOrderSign());
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    //微信支付
    private void payV1(PayWeChatBean.DataBean.OrderSignBean orderSign) {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        IWXAPI api = WXAPIFactory.createWXAPI(this, "wx658d27e48aa3a824");
        // 将该app注册到微信
//        api.registerApp("wx658d27e48aa3a824");
        PayReq request = new PayReq();
        request.appId = orderSign.getAppid();
        request.partnerId = orderSign.getPartnerid();
        request.prepayId = orderSign.getPrepayid();
        request.packageValue = orderSign.getPackageX();
        request.nonceStr = orderSign.getNoncestr();
        request.timeStamp = orderSign.getTimestamp() + "";
        request.sign = orderSign.getSign();
        api.sendReq(request);
        popupWindow.dismiss();
    }
    @Override
    public void showPgcChapterCommentListByOffSetBean(PgcChapterCommentListByOffSetBean pgcChapterCommentListByOffSetBean) {

        if (pgcChapterCommentListByOffSetBean != null) {
            result.addAll(pgcChapterCommentListByOffSetBean.getData().getResult());
            if (result.size() != 0) {
                cataLog_footViewComment_recy.setVisibility(View.VISIBLE);
                cataLog_footViewComment_recyTip.setVisibility(View.GONE);
                catalogFootviewCommentRecyAdapter = new CatalogFootviewCommentRecyAdapter(pgcChapterCommentListByOffSetBean.getData().getResult(), StartcatalogId, presenter);
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

    @Override
    public void makeOrder(int position) {
//        章节ID
        catalogId = position;
//       获取产品列表数据
        presenter.sendProductListData();
        showPopueWindow();
    }

    @Override
    public void showProductListBean(ProductListBean productListBean) {
        if (productListBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            List<ProductListBean.DataBean> listBeanData = productListBean.getData();
            GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
            ppwPay_productList.setLayoutManager(linearLayoutManager);
            ProductListAdapter productListAdapter = new ProductListAdapter(listBeanData, this);
            ppwPay_productList.setAdapter(productListAdapter);
            productListAdapter.ProductListCallback(this);
        }

    }

    //子条目Ite m
    @Override
    public void showProductList(int position) {
//        赋值得到产品ID
        qieziId = position;
    }
}