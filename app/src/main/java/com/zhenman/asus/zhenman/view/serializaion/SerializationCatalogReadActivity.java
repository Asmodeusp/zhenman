package com.zhenman.asus.zhenman.view.serializaion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.presenter.SerializationCatalogReadPresenterImp;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.ScreenUtils;
import com.zhenman.asus.zhenman.utils.alipay.AuthResult;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogFootviewCommentRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogReadActorAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ProductListAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogReadRecyAdapter;
import com.zhenman.asus.zhenman.view.ui.MyScrollView;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class SerializationCatalogReadActivity extends BaseActivity<SerializationCatalogReadPresenterImp> implements SerializationCatalogReadContract.serializationCatalogReadView, CatalogReadActorAdapter.CatalogReadActorCallback, ProductListAdapter.ProductListCallback {
    //整个章节阅读图的RecyclerView
    @BindView(R.id.serializationCatalogReadRecy)
    RecyclerView serializationCatalogReadRecy;
    @BindView(R.id.SerializationMyScrollView)
    MyScrollView SerializationMyScrollView;
    //从第一话开始观看
    @BindView(R.id.SeeFirstBtn)
    AutoLinearLayout SeeFirstBtn;
    //未完待续
    @BindView(R.id.weiwandaixuReLa)
    AutoRelativeLayout weiwandaixuReLa;
    //收藏图片
    @BindView(R.id.CataLog_FootViewCollectionImg)
    ImageView CataLogFootViewCollectionImg;
    //收藏按钮
    @BindView(R.id.CataLog_FootViewCollectionBtn)
    AutoLinearLayout CataLogFootViewCollectionBtn;
    //分享按钮
    @BindView(R.id.CataLog_FootViewShareBtn)
    AutoLinearLayout CataLogFootViewShareBtn;
    //上一章字体
    @BindView(R.id.CataLog_FootViewUpperText)
    TextView CataLogFootViewUpperText;
    //上一章线
    @BindView(R.id.CataLog_FootViewUpperLine)
    TextView CataLogFootViewUpperLine;
    //上一章按钮
    @BindView(R.id.CataLog_FootViewUpperBtn)
    AutoLinearLayout CataLogFootViewUpperBtn;
    //下一章字体
    @BindView(R.id.CataLog_FootViewNexterText)
    TextView CataLogFootViewNexterText;
    //下一章线
    @BindView(R.id.CataLog_FootViewNexterLine)
    TextView CataLogFootViewNexterLine;
    //下一章按钮
    @BindView(R.id.CataLog_FootViewNexterBtn)
    AutoLinearLayout CataLogFootViewNexterBtn;
    //演员RecyclerView
    @BindView(R.id.CataLog_FootViewActor_Recy)
    RecyclerView CataLogFootViewActorRecy;
    //底部评论的RecyclerView
    @BindView(R.id.CataLog_FootViewComment_Recy)
    RecyclerView CataLogFootViewCommentRecy;
    //底部评论的提示
    @BindView(R.id.CataLog_FootViewComment_RecyTip)
    TextView CataLogFootViewCommentRecyTip;
    //刷新控件
    @BindView(R.id.serializationCatalogReadSRL)
    SmartRefreshLayout serializationCatalogReadSRL;
    //评论数量
    @BindView(R.id.serializationCatalogReadCommentNumber)
    TextView serializationCatalogReadCommentNumber;
    //评论按钮
    @BindView(R.id.serializationCatalogReadCommentBtn)
    AutoLinearLayout serializationCatalogReadCommentBtn;
    // 章节按钮
    @BindView(R.id.serializationCatalogReadCatalogBtn)
    AutoLinearLayout serializationCatalogReadCatalogBtn;
    //底部布局
    @BindView(R.id.serializationCatalogReadFootLin)
    AutoRelativeLayout serializationCatalogReadFootLin;
    //返回按钮
    @BindView(R.id.serializationCatalogReadReturnImg)
    ImageView serializationCatalogReadReturnImg;
    //第几话
    @BindView(R.id.serializationCatalogReadText)
    TextView serializationCatalogReadText;
    //头布局
    @BindView(R.id.serializationCatalogReadHeadRel)
    AutoLinearLayout serializationCatalogReadHeadRel;
    //章节的标题（作评名字）
    @BindView(R.id.CataLog_PopuTitle)
    TextView CataLogPopuTitle;
    //章节的RecyclerView
    @BindView(R.id.CataLog_PopuRecy)
    RecyclerView CataLogPopuRecy;
    //章节的定位
    @BindView(R.id.CataLog_PopuPosition)
    ImageView CataLogPopuPosition;
    //章节的置底
    @BindView(R.id.CataLog_PopuDownload)
    ImageView CataLog_PopuDownload;
    //drawer_layout 章节的弹出View
    @BindView(R.id.mserializationCatalogReadCatalog_drawer_layout)
    AutoRelativeLayout mserializationCatalogReadCatalogDrawerLayout;
    //DrawerLayout
    @BindView(R.id.SerializationDrawerLayout)
    DrawerLayout SerializationDrawerLayout;
    TextView ppwPayUserName;
    TextView ppwPayNum;
    ImageView ppwPayQiezi;
    RecyclerView ppwPayProductList;
    RadioButton ppwPayZhifubaoBtn;
    RadioButton ppwPayWeixinBtn;
    RadioGroup ppwPayRadioGroup;
    Button ppwPayPayBtn;
    TextView ppwPayPayMoney;
    TextView ppwPayQieziNum;
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
    //抽屉菜单对象
    private ActionBarDrawerToggle drawerbar;
    //章节ID
    public String StartcatalogId;
    //支付popuwindow
    private PopupWindow paypopupWindow;
    private String paymentMethod;
    //章节演员的适配器
    private CatalogReadActorAdapter catalogReadActorAdapter;
    //章节Id
    private int catalogId;
    //支付产品Id
    private int qieziId;
    //章节实体类集合
    private List<SerializationCatalogBean.DataBean> data = new ArrayList<>();
    //章节列表适配器
    private SerializationCatalogAdapter serializationCatalogAdapter;
    //评论列表
    private List<PgcChapterCommentListByOffSetBean.DataBean.CommentDtoListBean> result = new ArrayList<>();
    //阅读图片适配器
    private SerializationCatalogReadRecyAdapter serializationCatalogReadRecyAdapter;
    //点击屏幕标记
    boolean Touch = true;
    //阅读图片的实体类
    SerializationCatalogReadBean serializationCatalogReadBean;
    //底部弹出消息框
    private BottomSheetDialog dialog;
    //填充布局
    private View contentView;
    //弹出评论的RecyclerView
    private RecyclerView commentPopu_recy;
    //标记章节索引
    private int i;
    //订单数量
    private String orderNumber;
    //支付标记
    private static final int SDK_PAY_FLAG = 1;
    //底部评论适配器
    private CatalogFootviewCommentRecyAdapter catalogFootviewCommentRecyAdapter;
    private String pgcId;
    private boolean isCollect;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_serialization_catalog_read;
    }

    @Override
    protected void init() {
        serializationCatalogReadRecy.setLayoutManager(new LinearLayoutManager(this));
        CataLogFootViewUpperText.setText("<");
        //设置演员列表
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CataLogFootViewActorRecy.setLayoutManager(linearLayoutManager);
        serializationCatalogReadSRL.setDragRate(0.5f);
        if (result.size() == 0) {
            CataLogFootViewCommentRecy.setVisibility(View.GONE);
            CataLogFootViewCommentRecyTip.setVisibility(View.VISIBLE);
        }

        initEvent();

    }

    private void initCatalog() {
        CataLogPopuTitle.setText((CharSequence) SPUtils.get(this, "DetaailsName", "海贼"));
        CataLogPopuPosition.setVisibility(View.GONE);
        CataLog_PopuDownload.setVisibility(View.GONE);
        CataLogPopuRecy.setLayoutManager(new LinearLayoutManager(this));
        serializationCatalogAdapter = new SerializationCatalogAdapter(data, StartcatalogId);
        CataLogPopuRecy.setAdapter(serializationCatalogAdapter);
        serializationCatalogAdapter.notifyDataSetChanged();
        serializationCatalogAdapter.setRecyclerViewOnCLickListener(new SerializationCatalogAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                StartcatalogId = data.get(position).getCatalogId();
                SPUtils.put(SerializationCatalogReadActivity.this,SPKey.CATALOGID_ID,StartcatalogId);
                refresh();
            }
        });

    }

    @Override
    protected void loadDate() {
        StartcatalogId = (String) SPUtils.get(this, SPKey.CATALOGID_ID, "");
        pgcId = (String) SPUtils.get(this, SPKey.PGC_ID, "");

        //得到数据
        //作品图片集合
        presenter.getSerializationCatalogReadBean(StartcatalogId);
        //作品章节集合
        presenter.getSerializationCatalogBean(pgcId);
        //作品详情集合
        presenter.getSerializationDetailsBean(pgcId);
        //作品评论集合
        presenter.getPgcChapterCommentListByOffSetBean(StartcatalogId, "0", "300", "1");
    }

    //设置开关监听
    private void initEvent() {
        drawerbar = new ActionBarDrawerToggle(this, SerializationDrawerLayout, null, R.string.open, R.string.close) {
            //菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        SerializationDrawerLayout.setDrawerListener(drawerbar);
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    // 右边菜单开关事件
    public void openRightLayout(View view) {
        if (SerializationDrawerLayout.isDrawerOpen(mserializationCatalogReadCatalogDrawerLayout)) {
            SerializationDrawerLayout.closeDrawer(mserializationCatalogReadCatalogDrawerLayout);
        } else {
            SerializationDrawerLayout.openDrawer(mserializationCatalogReadCatalogDrawerLayout);
        }
    }

    //获取详情
    @Override
    public void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean) {
        if (serializationDetailsBean != null) {
            catalogReadActorAdapter = new CatalogReadActorAdapter(serializationDetailsBean.getData().getActorList());
            catalogReadActorAdapter.CatalogReadActorCallback(this);
            CataLogFootViewActorRecy.setAdapter(catalogReadActorAdapter);
            isCollect = serializationDetailsBean.getData().isCollect();
            if (serializationDetailsBean.getData().isCollect()) {
                CataLogFootViewCollectionImg.setImageResource(R.mipmap.common_collection_on);
            } else {
                CataLogFootViewCollectionImg.setImageResource(R.mipmap.common_collection_off);
            }
            CataLogFootViewCollectionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isCollect) {
                        CataLogFootViewCollectionImg.setImageResource(R.mipmap.common_collection_off);
                        isCollect = false;
                        presenter.PgcCollection(pgcId, "0");
                    } else {
                        CataLogFootViewCollectionImg.setImageResource(R.mipmap.common_collection_on);
                        isCollect = true;
                        presenter.PgcCollection(pgcId, "1");
                    }
                }
            });
        }
    }

    private void refresh() {
        finish();
        startActivity(getIntent());
    }

    //章节实体类
    @Override
    public void showSerializationCatalogBean(SerializationCatalogBean
                                                     serializationCatalogBean) {
        if (serializationCatalogBean.getData() == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            data.addAll(serializationCatalogBean.getData());
            initCatalog();
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
                refreshLayout.finishRefresh(1000/*,false*/);//传入false表示刷新失败

            }
        });
        if (serializationCatalogReadBean == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
            this.serializationCatalogReadBean = serializationCatalogReadBean;
        } else {

            serializationCatalogReadRecyAdapter = new SerializationCatalogReadRecyAdapter(serializationCatalogReadBean.getData().getList());
            double i = (double) serializationCatalogReadBean.getData().getTotalHeight() / 800;
            double InsideHight = i * (double) ScreenUtils.getScreenWidth(this);
            serializationCatalogReadRecy.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) InsideHight));
            serializationCatalogReadRecy.setAdapter(serializationCatalogReadRecyAdapter);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(SerializationCatalogReadActivity.this, R.anim.recy_item);
            serializationCatalogReadRecy.setLayoutAnimation(animation);
            serializationCatalogReadText.setText(serializationCatalogReadBean.getData().getTitle());
            serializationCatalogReadRecyAdapter.notifyDataSetChanged();
            serializationCatalogReadCommentNumber.setText(String.valueOf(serializationCatalogReadBean.getData().getCount()));
            serializationCatalogReadRecyAdapter.setRecyclerViewOnCLickListener(new SerializationCatalogReadRecyAdapter.RecyclerViewOnCLickListener() {
                @Override
                public void myClick(View view, int position) {
                    if (Touch) {
                        serializationCatalogReadHeadRel.setVisibility(View.VISIBLE);
                        serializationCatalogReadFootLin.setVisibility(View.VISIBLE);
                        Touch = false;
                    } else {
                        serializationCatalogReadHeadRel.setVisibility(View.GONE);
                        serializationCatalogReadFootLin.setVisibility(View.GONE);
                        Touch = true;
                    }
                }
            });
        }
        SetTextColorRules();
    }

    //消息弹出BottomSheetDialog
    @SuppressLint("WrongConstant")
    private void initCommentpopu() {
        dialog = new BottomSheetDialog(this);
        contentView = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_dialog_layout, null, false);
        dialog.setContentView(contentView);
        //评论RecyclerView
        commentPopu_recy = contentView.findViewById(R.id.HomeHot_CommentPopu_Recy);
        //评论输入框
        EditText CommentPopu_EdText = contentView.findViewById(R.id.HomeHot_CommentPopu_EdText);
        //评论发送按钮
        Button CommentPopu_SendButton = contentView.findViewById(R.id.HomeHot_CommentPopu_SendButton);
        //评论提示字
        TextView CommentPopu_Tip = contentView.findViewById(R.id.HomeHot_CommentPopu_Tip);
        //设置RecyclerView的格式
        commentPopu_recy.setLayoutManager(new LinearLayoutManager(this));
        //展示评论popuwindow
        dialog.show();
        //得到评论内容
        String comment = CommentPopu_EdText.getText().toString().trim();
        CommentPopu_SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @OnClick({R.id.SeeFirstBtn,
            R.id.CataLog_FootViewUpperBtn,
            R.id.CataLog_FootViewNexterBtn,
            R.id.CataLog_PopuPosition,
            R.id.serializationCatalogReadCatalogBtn,
            R.id.CataLog_PopuDownload,
            R.id.serializationCatalogReadReturnImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //观看第一话
            case R.id.SeeFirstBtn:
                StartcatalogId = data.get(data.size() - 1).getCatalogId();
                SPUtils.put(this,SPKey.CATALOGID_ID,StartcatalogId);
//                presenter.getSerializationCatalogReadBean(StartcatalogId);
//                SetTextColorRules();
                refresh();
                break;
            //上一章
            case R.id.CataLog_FootViewUpperBtn:
                //得到现在章节的索引
                for (SerializationCatalogBean.DataBean datum : data) {
                    if (datum.getCatalogId().equals(StartcatalogId)) {
                        i = data.indexOf(datum);
                    }

                }
                if (data.size() != 0 && data != null) {
                    StartcatalogId = data.get(i + 1).getCatalogId();
//                    presenter.getSerializationCatalogReadBean(StartcatalogId);
                    SPUtils.put(this,SPKey.CATALOGID_ID,StartcatalogId);
                }

//                SetTextColorRules();
                //填充头布局
                serializationCatalogReadHeadRel.setVisibility(View.GONE);
                //填充底布局
                serializationCatalogReadFootLin.setVisibility(View.GONE);
                refresh();
                break;
            //评论
            case R.id.serializationCatalogReadCommentBtn:
                break;
            //下一章
            case R.id.CataLog_FootViewNexterBtn:
                if (data.size() != 0 && data != null) {
                    //得到现在章节的索引
                    for (SerializationCatalogBean.DataBean datum : data) {
                        if (datum.getCatalogId().equals(StartcatalogId)) {
                            i = data.indexOf(datum);
                        }
                    }
                    StartcatalogId = data.get(i - 1).getCatalogId();
                    SPUtils.put(this,SPKey.CATALOGID_ID,StartcatalogId);
//                    serializationCatalogReadRecy.scrollToPosition(0);
//                    serializationCatalogReadHeadRel.setVisibility(View.GONE);
//                    serializationCatalogReadFootLin.setVisibility(View.GONE);
//                    SetTextColorRules();
                    refresh();
                }
                break;
            //返回
            case R.id.serializationCatalogReadReturnImg:
                finish();
                break;
            //定位
            case R.id.CataLog_PopuPosition:
                break;
            //下载
            case R.id.CataLog_PopuDownload:
                break;
            //目录
            case R.id.serializationCatalogReadCatalogBtn:
                openRightLayout(mserializationCatalogReadCatalogDrawerLayout);
                break;
        }
    }

    private void SetTextColorRules() {
        if (data != null && data.size() != 0) {
            //第一话
            if (data.get(data.size() - 1).getCatalogId().equals(StartcatalogId)) {
                CataLogFootViewNexterText.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewNexterLine.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewUpperText.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewUpperLine.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewUpperBtn.setClickable(false);
                CataLogFootViewNexterBtn.setClickable(true);
                weiwandaixuReLa.setVisibility(View.GONE);
                //最后一话
            } else if (data.get(0).getCatalogId().equals(StartcatalogId)) {
                CataLogFootViewNexterText.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewNexterLine.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewUpperText.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewUpperLine.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewUpperBtn.setClickable(true);
                CataLogFootViewNexterBtn.setClickable(false);
                weiwandaixuReLa.setVisibility(View.VISIBLE);
                //其他
            } else {
                CataLogFootViewNexterText.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewNexterLine.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewUpperText.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewUpperLine.setTextColor(getResources().getColor(R.color.h2));
                CataLogFootViewUpperBtn.setClickable(true);
                CataLogFootViewNexterBtn.setClickable(true);
                weiwandaixuReLa.setVisibility(View.GONE);
            }
            if (data.size() == 1) {
                CataLogFootViewNexterText.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewNexterLine.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewUpperText.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewUpperLine.setTextColor(getResources().getColor(R.color.h4));
                CataLogFootViewUpperBtn.setClickable(false);
                CataLogFootViewNexterBtn.setClickable(false);
                weiwandaixuReLa.setVisibility(View.GONE);
            }
        }

    }

    //支付popuwindow
    private void ShowPaypopupView() {
        View PaypopupView = LayoutInflater.from(this).inflate(R.layout.ppw_pay, null);
        ppwPayProductList = PaypopupView.findViewById(R.id.ppwPay_productList);
        ppwPayRadioGroup = PaypopupView.findViewById(R.id.ppwPay_radioGroup);
        ppwPayZhifubaoBtn = PaypopupView.findViewById(R.id.ppwPay_zhifubaoBtn);
        ppwPayWeixinBtn = PaypopupView.findViewById(R.id.ppwPay_weixinBtn);
        ppwPayPayBtn = PaypopupView.findViewById(R.id.ppwPay_payBtn);
        ppwPayPayMoney = PaypopupView.findViewById(R.id.ppwPay_payMoney);
        ppwPayQieziNum = PaypopupView.findViewById(R.id.ppwPay_qieziNum);
        ppwPayNum = PaypopupView.findViewById(R.id.ppwPay_num);
        ppwPayUserName = PaypopupView.findViewById(R.id.ppwPay_userName);
        ppwPayPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentMethod.equals("1")) {
                    presenter.setWxMakeOrderData(qieziId + "", "1", StartcatalogId, "262", "0.1", "支付");
                } else if (paymentMethod.equals("2")) {
                    presenter.setMakeOrderData(qieziId + "", "1", StartcatalogId, "262", "1", "支付");
                } else {
                    Toast.makeText(SerializationCatalogReadActivity.this, "请选择支付方式", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //获取屏幕宽高
        int weight = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels * 1 / 2;

        paypopupWindow = new PopupWindow(PaypopupView, weight, height);
        paypopupWindow.setFocusable(true);
        //点击外部popueWindow消失
        paypopupWindow.setOutsideTouchable(true);

        ppwPayRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
        paypopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
        paypopupWindow.showAtLocation(PaypopupView, Gravity.BOTTOM, 0, 0);
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
            AliPay(getPayDataBean.getData().getOrderSign());
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    //得到微信支付数据
    @Override
    public void showGetWxPayData(PayWeChatBean payWeChatBean) {
        if (payWeChatBean.getData().getOrderSign() != null) {
            WeChatPay(payWeChatBean.getData().getOrderSign());
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showPgcCollectionBean(PgcCollectionBean collectionBean) {

    }

    //微信支付
    private void WeChatPay(PayWeChatBean.DataBean.OrderSignBean orderSign) {
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
        paypopupWindow.dismiss();
    }

    //评论列表
    @Override
    public void showPgcChapterCommentListByOffSetBean(PgcChapterCommentListByOffSetBean pgcChapterCommentListByOffSetBean) {
        if (pgcChapterCommentListByOffSetBean != null) {

            result.addAll(pgcChapterCommentListByOffSetBean.getData().getCommentDtoList());
            if (result != null) {
                if (result.size() != 0) {
                    CataLogFootViewCommentRecy.setVisibility(View.VISIBLE);
                    CataLogFootViewCommentRecyTip.setVisibility(View.GONE);
                    catalogFootviewCommentRecyAdapter = new CatalogFootviewCommentRecyAdapter(pgcChapterCommentListByOffSetBean.getData().getCommentDtoList(), StartcatalogId, presenter);
                    commentPopu_recy.setAdapter(catalogFootviewCommentRecyAdapter);
                    catalogFootviewCommentRecyAdapter.setClickZan(new CatalogFootviewCommentRecyAdapter.ClickZan() {
                        @Override
                        public void zan(String commentId, String status, String pgcId) {
                            presenter.PGCReadFabulous(StartcatalogId, commentId, status, pgcId);
                        }
                    });
                    CataLogFootViewCommentRecy.setAdapter(catalogFootviewCommentRecyAdapter);
                } else {
                    CataLogFootViewCommentRecy.setVisibility(View.GONE);
                    CataLogFootViewCommentRecyTip.setVisibility(View.VISIBLE);
                }
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
    public void AliPay(final String orderSign) {
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
        ShowPaypopupView();
    }

    @Override
    public void showProductListBean(ProductListBean productListBean) {
        if (productListBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            List<ProductListBean.DataBean> listBeanData = productListBean.getData();
            GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
            ppwPayProductList.setLayoutManager(linearLayoutManager);
            ProductListAdapter productListAdapter = new ProductListAdapter(listBeanData, this);
            ppwPayProductList.setAdapter(productListAdapter);
            productListAdapter.ProductListCallback(this);
        }
    }


    @Override
    public void showProductList(int position) {
        qieziId = position;
    }


}