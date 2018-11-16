package com.zhenman.asus.zhenman.view.serializaion;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.bean.RenewBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.presenter.SerializationCatalogReadPresenterImp;
import com.zhenman.asus.zhenman.utils.ButtonUtils;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.alipay.AuthResult;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.CatalogReadActorAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ProductListAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.SerializationCatalogReadRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.WorkDetailsCommentAdapter;
import com.zhenman.asus.zhenman.view.comment.FullFragment;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.ui.MyScrollView;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    AutoRelativeLayout serializationCatalogReadReturnImg;
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
    DrawerLayout SerializationDrawerLayout; //DrawerLayout
    @BindView(R.id.CataLog_FootViewActor_RecyTip)
    TextView CataLog_FootViewActor_RecyTip;
    TextView ppwPayUserName;
    RecyclerView ppwPayProductList;
    CheckBox ppwPayZhifubaoBtn;
    CheckBox ppwPayWeixinBtn;
    Button ppwPayPayBtn;
    //过渡页的标题
    @BindView(R.id.TransitionTitle)
    TextView TransitionTitle;
    //过渡页本章节所需茄子籽数
    @BindView(R.id.TransitionCoinAmountNumber)
    TextView TransitionCoinAmountNumber;
    //自动续费按钮
    @BindView(R.id.TransitionAutoRrepurChaseImg)
    ImageView TransitionAutoRrepurChaseImg;
    //购买本章节按钮
    @BindView(R.id.TransitionPurchaseButton)
    Button TransitionPurchaseButton;
    //我的茄子籽数
    @BindView(R.id.TransitionMyAmountNumber)
    TextView TransitionMyAmountNumber;
    @BindView(R.id.serializationCatalogReadTransitionPage)
    AutoLinearLayout serializationCatalogReadTransitionPage;
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
    private String paymentMethod = "2";
    //章节演员的适配器
    private CatalogReadActorAdapter catalogReadActorAdapter;
    //章节Id
    private int catalogId;
    //支付产品Id
    private int qieziId;
    ImageView ppwQuestion;
    //    打赏价格
    private int qieziMoney;
    //章节实体类集合
    private List<SerializationCatalogBean.DataBean> data = new ArrayList<>();
    //章节列表适配器
    private SerializationCatalogAdapter serializationCatalogAdapter;
    //阅读图片适配器
    private SerializationCatalogReadRecyAdapter serializationCatalogReadRecyAdapter;
    //点击屏幕标记
    boolean Touch = true;
    //阅读图片的实体类
    SerializationCatalogReadBean serializationCatalogReadBean;
    //标记章节索引
    private int i;
    //订单数量
    private String orderNumber;
    //支付标记
    private static final int SDK_PAY_FLAG = 1;
    private String pgcId;
    private boolean isCollect;
    private CommentListBean commentListBean;
    private Boolean isOpenAuto;

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
        initEvent();
    }

    private void initCatalog() {
        CataLogPopuTitle.setText((CharSequence) SPUtils.get(this, "DetailsName", "海贼"));
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
                SPUtils.put(SerializationCatalogReadActivity.this, SPKey.CATALOGID_ID, StartcatalogId);
                refresh();
            }
        });

    }

    //得到数据
    @Override
    protected void loadDate() {
        StartcatalogId = (String) SPUtils.get(this, SPKey.CATALOGID_ID, "");
        pgcId = (String) SPUtils.get(this, SPKey.PGC_ID, "");
        //作品图片集合
        presenter.getSerializationCatalogReadBean(StartcatalogId);
        //作品章节集合
        presenter.getSerializationCatalogBean(pgcId);
        //作品评论集合
        presenter.getCommentList(StartcatalogId, "1", "50", "3", "1");
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

    }

    @Override
    public void showRenewBean(RenewBean renewBean) {

    }

    // 右边菜单开关事件
    public void openRightLayout(View view) {
        if (SerializationDrawerLayout.isDrawerOpen(mserializationCatalogReadCatalogDrawerLayout)) {
            SerializationDrawerLayout.closeDrawer(mserializationCatalogReadCatalogDrawerLayout);
        } else {
            SerializationDrawerLayout.openDrawer(mserializationCatalogReadCatalogDrawerLayout);
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
            //过渡页续购开关
            isOpenAuto =serializationCatalogReadBean.getData().getCatalogPayInfo().isOpenAuto();
            if (isOpenAuto) {
                TransitionAutoRrepurChaseImg.setImageResource(R.mipmap.edit_outline_button_on);
            }else{
                TransitionAutoRrepurChaseImg.setImageResource(R.mipmap.edit_outline_button_off);
            }
            //过渡页标题
            TransitionTitle.setText(serializationCatalogReadBean.getData().getCatalogPayInfo().getTitle());
            //过渡页本章需要茄子籽数量
            TransitionCoinAmountNumber.setText(serializationCatalogReadBean.getData().getCatalogPayInfo().getCoinAmount()+"个");
            //过渡页自己所剩茄子籽
            TransitionMyAmountNumber.setText("x"+serializationCatalogReadBean.getData().getCatalogPayInfo().getAmount());
            //阅读adapter
            serializationCatalogReadRecyAdapter = new SerializationCatalogReadRecyAdapter(serializationCatalogReadBean.getData().getTransfer());
            serializationCatalogReadRecy.setAdapter(serializationCatalogReadRecyAdapter);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(SerializationCatalogReadActivity.this, R.anim.recy_item);
            serializationCatalogReadRecy.setLayoutAnimation(animation);
            //标题
            serializationCatalogReadText.setText(serializationCatalogReadBean.getData().getCatalogPayInfo().getTitle());
            serializationCatalogReadRecyAdapter.notifyDataSetChanged();
            //评论数量
            serializationCatalogReadCommentNumber.setText(String.valueOf(serializationCatalogReadBean.getData().getCatalogPayInfo().getCommentNum()));
            //阅读页的点击事件
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
            //演员列表
            if (serializationCatalogReadBean.getData().getPgcChapterInfoDto().getActorList().size() == 0) {
                CataLog_FootViewActor_RecyTip.setVisibility(View.VISIBLE);
                CataLogFootViewActorRecy.setVisibility(View.GONE);
            } else {
                CataLog_FootViewActor_RecyTip.setVisibility(View.GONE);
                CataLogFootViewActorRecy.setVisibility(View.VISIBLE);
            }
            catalogReadActorAdapter = new CatalogReadActorAdapter(serializationCatalogReadBean.getData().getPgcChapterInfoDto().getActorList());
            catalogReadActorAdapter.CatalogReadActorCallback(this);
            CataLogFootViewActorRecy.setAdapter(catalogReadActorAdapter);
            isCollect = serializationCatalogReadBean.getData().getPgcChapterInfoDto().isCollect();
            //下方评论列表
            if (serializationCatalogReadBean.getData().getPgcCommentListByChapterId() == null) {
                CataLogFootViewCommentRecyTip.setVisibility(View.VISIBLE);
                CataLogFootViewCommentRecy.setVisibility(View.GONE);
            } else {
                CataLogFootViewCommentRecyTip.setVisibility(View.GONE);
                CataLogFootViewCommentRecy.setVisibility(View.VISIBLE);
                CataLogFootViewCommentRecy.setLayoutManager(new LinearLayoutManager(this));
                WorkDetailsCommentAdapter workDetailsCommentAdapter = new WorkDetailsCommentAdapter(serializationCatalogReadBean.getData().getPgcCommentListByChapterId());
                workDetailsCommentAdapter.setgoUserInfo(new WorkDetailsCommentAdapter.goUserInfo() {
                    @Override
                    public void go(String UserId) {
                        Intent intent = new Intent(SerializationCatalogReadActivity.this, HomepageActivity.class);
                        intent.putExtra(SPKey.HIM_ID, UserId);
                        startActivity(intent);
                    }
                });
                CataLogFootViewCommentRecy.setAdapter(workDetailsCommentAdapter);
            }
            SetTextColorRules();
        }

    }

    //消息弹出BottomSheetDialog
    private void initCommentpopu() {
        FullFragment fullFragment = new FullFragment(commentListBean, "3", pgcId);
        fullFragment.show(getSupportFragmentManager(), "dialog");

    }

    @OnClick({R.id.SeeFirstBtn,
            R.id.CataLog_FootViewUpperBtn,
            R.id.CataLog_FootViewNexterBtn,
            R.id.CataLog_PopuPosition,
            R.id.serializationCatalogReadCatalogBtn,
            R.id.CataLog_PopuDownload,
            R.id.TransitionAutoRrepurChaseImg, R.id.TransitionPurchaseButton,
            R.id.CataLog_FootViewCollectionBtn,
            R.id.serializationCatalogReadCommentBtn,
            R.id.serializationCatalogReadReturnImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //观看第一话
            case R.id.SeeFirstBtn:
                if (ButtonUtils.isFastDoubleClick(R.id.SeeFirstBtn)) {
                    StartcatalogId = data.get(data.size() - 1).getCatalogId();
                    SPUtils.put(this, SPKey.CATALOGID_ID, StartcatalogId);
                    refresh();
                }
                SetTextColorRules();
                StartcatalogId = data.get(data.size() - 1).getCatalogId();
                SPUtils.put(this, SPKey.CATALOGID_ID, StartcatalogId);
                refresh();
                break;
            //上一章
            case R.id.CataLog_FootViewUpperBtn:
                if (ButtonUtils.isFastDoubleClick(R.id.SeeFirstBtn)) {
                    //得到现在章节的索引
                    for (SerializationCatalogBean.DataBean datum : data) {
                        if (datum.getCatalogId().equals(StartcatalogId)) {
                            i = data.indexOf(datum);
                        }
                    }
                    if (data.size() != 0 && data != null) {
                        StartcatalogId = data.get(i + 1).getCatalogId();
                        SPUtils.put(this, SPKey.CATALOGID_ID, StartcatalogId);
                    }

                    //填充头布局
                    serializationCatalogReadHeadRel.setVisibility(View.GONE);
                    //填充底布局
                    serializationCatalogReadFootLin.setVisibility(View.GONE);
                    refresh();
                }
                //得到现在章节的索引
                for (SerializationCatalogBean.DataBean datum : data) {
                    if (datum.getCatalogId().equals(StartcatalogId)) {
                        i = data.indexOf(datum);
                    }
                }
                if (data.size() != 0 && data != null) {
                    StartcatalogId = data.get(i + 1).getCatalogId();
                    SPUtils.put(this, SPKey.CATALOGID_ID, StartcatalogId);
                }
                //填充头布局
                serializationCatalogReadHeadRel.setVisibility(View.GONE);
                //填充底布局
                serializationCatalogReadFootLin.setVisibility(View.GONE);
                refresh();
                break;
            //评论
            case R.id.serializationCatalogReadCommentBtn:
                //作品评论集合
                presenter.getCommentList(StartcatalogId, "1", "50", "3", "1");
                initCommentpopu();
                break;
            //下一章
            case R.id.CataLog_FootViewNexterBtn:
                if (ButtonUtils.isFastDoubleClick(R.id.SeeFirstBtn)) {
                    if (data.size() != 0 && data != null) {
                        //得到现在章节的索引
                        for (SerializationCatalogBean.DataBean datum : data) {
                            if (datum.getCatalogId().equals(StartcatalogId)) {
                                i = data.indexOf(datum);
                            }
                        }
                    }
                    StartcatalogId = data.get(i - 1).getCatalogId();
                    SPUtils.put(this, SPKey.CATALOGID_ID, StartcatalogId);
                    refresh();
                }
                if (data.size() != 0 && data != null) {
                    //得到现在章节的索引
                    for (SerializationCatalogBean.DataBean datum : data) {
                        if (datum.getCatalogId().equals(StartcatalogId)) {
                            i = data.indexOf(datum);
                        }
                    }
                    StartcatalogId = data.get(i - 1).getCatalogId();
                    SPUtils.put(this, SPKey.CATALOGID_ID, StartcatalogId);
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
            //收藏
            case R.id.CataLog_FootViewCollectionBtn:
                break;
            //目录
            case R.id.serializationCatalogReadCatalogBtn:
                openRightLayout(mserializationCatalogReadCatalogDrawerLayout);
                break;
            //自动续费ImageView
            case R.id.TransitionAutoRrepurChaseImg:
                if (isOpenAuto) {
                    TransitionAutoRrepurChaseImg.setImageResource(R.mipmap.edit_outline_button_off);
                    presenter.getRenewBean("0",pgcId);
                    isOpenAuto =false;
                }else{
                    TransitionAutoRrepurChaseImg.setImageResource(R.mipmap.edit_outline_button_on);
                    presenter.getRenewBean("1",pgcId);
                    isOpenAuto =true;
                }
                break;
            //购买本章Button
            case R.id.TransitionPurchaseButton:
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    //支付popuwindow
    private void ShowPaypopupView() {

        View PaypopupView = LayoutInflater.from(this).inflate(R.layout.ppw_pay, null);
        ppwPayProductList = PaypopupView.findViewById(R.id.ppwPay_productList);
        ppwPayZhifubaoBtn = PaypopupView.findViewById(R.id.ppwPay_zhifubaoBtn);
        ppwPayWeixinBtn = PaypopupView.findViewById(R.id.ppwPay_weixinBtn);
        ppwPayPayBtn = PaypopupView.findViewById(R.id.ppwPay_payBtn);
        ppwQuestion = PaypopupView.findViewById(R.id.ppw_question);

        ppwPayUserName = PaypopupView.findViewById(R.id.ppwPay_userName);
        ppwPayUserName.setText("Hi, " + (String) SPUtils.get(this, SPKey.UMeng_NAME, ""));
        paypopupWindow = new PopupWindow(PaypopupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        PaypopupView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // 允许点击外部消失
        paypopupWindow.setBackgroundDrawable(new BitmapDrawable());
        paypopupWindow.setOutsideTouchable(true);
        paypopupWindow.setFocusable(true);
        ppwPayPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentMethod.equals("1")) {
                    presenter.setWxMakeOrderData(qieziId + "", "2", StartcatalogId, qieziMoney + "", "打赏");
                } else if (paymentMethod.equals("2")) {
                    presenter.setMakeOrderData(qieziId + "", "2", StartcatalogId, qieziMoney + "", "打赏");
                } else {
                    Toast.makeText(SerializationCatalogReadActivity.this, "请选择支付方式", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //        支付宝
        ppwPayZhifubaoBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ppwPayZhifubaoBtn.isChecked()) {
                    paymentMethod = "2";
                    ppwPayWeixinBtn.setChecked(false);
                } else {
                    ppwPayWeixinBtn.setChecked(true);
                }
            }
        });
//        微信
        ppwPayWeixinBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ppwPayWeixinBtn.isChecked()) {
                    paymentMethod = "1";
                    ppwPayZhifubaoBtn.setChecked(false);
                } else {
                    ppwPayZhifubaoBtn.setChecked(true);
                }
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

    @Override
    public void showCommentListBean(CommentListBean commentListBean) {
        this.commentListBean = commentListBean;
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

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void makeOrder(int position) {
//        章节ID
        catalogId = position;
//       获取产品列表数据
        presenter.sendProductListData("1");
        ShowPaypopupView();
    }

    @Override
    public void showProductListBean(ProductListBean productListBean) {
        if (productListBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            List<ProductListBean.DataBean> listBeanData = productListBean.getData();
            GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
            ppwPayProductList.setLayoutManager(linearLayoutManager);
            ppwPayProductList.setNestedScrollingEnabled(false);//禁止滑动
            ProductListAdapter productListAdapter = new ProductListAdapter(listBeanData, this);
            ppwPayProductList.setAdapter(productListAdapter);
            productListAdapter.ProductListCallback(this);
        }
    }


    @Override
    public void showProductList(int position, int amount) {
        qieziId = position;
        qieziMoney = amount;
    }

}