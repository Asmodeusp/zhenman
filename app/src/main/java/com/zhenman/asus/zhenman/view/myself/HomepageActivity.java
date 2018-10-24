package com.zhenman.asus.zhenman.view.myself;


import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.HomePageContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.presenter.HomePagePresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.PayUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.myself.HomePageAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ProductListAdapter;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyLikeFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyWorkFragment;
import com.zhenman.asus.zhenman.view.ui.NoSrcollViewPage;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomepageActivity extends BaseActivity<HomePagePresenter> implements View.OnClickListener, HomePageContract.HomePageInView ,ProductListAdapter.ProductListCallback{

    private AutoRelativeLayout app_back;
    private TextView app_title;
    private TextView app_otherID;
    private CircleImageView homePage_Avatar;
    private TextView homePage_Name;
    private ImageView homePage_Sex;
    private TextView my_Resume;
    private TextView homePage_works;
    private TextView homePage_fans;
    private TextView homePage_attention;
    private TextView homePage_theme;
    private AutoLinearLayout homePage_other01;
    private AutoRelativeLayout my_data;
    private TabLayout homePage_himTab;
    private NoSrcollViewPage HomePage_Viewpager;
    private ArrayList<String> homePageTab_title;
    private ArrayList<Fragment> homePageTab_fragment;
    private HomePageMyWorkFragment homePageMyWorkFragment;//TA的作品
    private HomePageMyLikeFragment homePageMyLikeFragment;//喜欢
    private AutoLinearLayout homePage_worksPage;
    private AutoLinearLayout homePage_fansPage;
    private AutoLinearLayout homePage_attentionPage;
    private AutoLinearLayout homePage_themePage;
    private String fromMyself = "myself";
    private String fromHome = "home";
    private TextView homePage_rewardHe;
    private TextView homePage_attentionHe;
    //支付popuwindow
    private PopupWindow paypopupWindow;
    TextView ppwPayUserName;
    RecyclerView ppwPayProductList;
    CheckBox ppwPayZhifubaoBtn;
    CheckBox ppwPayWeixinBtn;
    Button ppwPayPayBtn;
    ImageView ppwQuestion;

    private String paymentMethod="2";
    private boolean tag = false;
    private AutoRelativeLayout homePage_aboutHim;
    public static String him_id;
    public static String tabSelect;//tabLayout选择的是TA的作品还是TA的喜欢

    protected int getLayoutId() {
        return R.layout.activity_homepage;
    }
    private int qieziId;
    private int qieziMoney;
    @Override
    protected void init() {

        app_back = (AutoRelativeLayout) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        homePage_Avatar = (CircleImageView) findViewById(R.id.homePage_Avatar);
        homePage_Name = (TextView) findViewById(R.id.homePage_Name);
        homePage_Sex = (ImageView) findViewById(R.id.homePage_Sex);
        my_Resume = (TextView) findViewById(R.id.my_Resume);
        homePage_works = (TextView) findViewById(R.id.homePage_works);
        homePage_fans = (TextView) findViewById(R.id.homePage_fans);
        homePage_attention = (TextView) findViewById(R.id.homePage_attention);
        homePage_theme = (TextView) findViewById(R.id.homePage_theme);
        homePage_worksPage = (AutoLinearLayout) findViewById(R.id.homePage_worksPage);
        homePage_fansPage = (AutoLinearLayout) findViewById(R.id.homePage_fansPage);
        homePage_attentionPage = (AutoLinearLayout) findViewById(R.id.homePage_attentionPage);
        homePage_themePage = (AutoLinearLayout) findViewById(R.id.homePage_themePage);
        my_data = (AutoRelativeLayout) findViewById(R.id.my_data);
        homePage_himTab = (TabLayout) findViewById(R.id.homePage_himTab);
        HomePage_Viewpager = (NoSrcollViewPage) findViewById(R.id.HomePage_Viewpager);
        homePage_rewardHe = (TextView) findViewById(R.id.homePage_rewardHe);
        homePage_attentionHe = (TextView) findViewById(R.id.homePage_attentionHe);
        homePage_aboutHim = (AutoRelativeLayout) findViewById(R.id.homePage_aboutHim);
        app_title.setVisibility(View.GONE);
        homePageTab_title = new ArrayList<>();
        homePageTab_fragment = new ArrayList<>();
        homePageMyWorkFragment = new HomePageMyWorkFragment();
        homePageMyLikeFragment = new HomePageMyLikeFragment();
        homePageTab_title.add("TA的作品");
        homePageTab_title.add("TA喜欢的");
        homePageTab_fragment.add(homePageMyWorkFragment);
        homePageTab_fragment.add(homePageMyLikeFragment);
        idListener();
        Intent intent = getIntent();
        him_id = intent.getStringExtra("him_id");
        if (him_id.equals("myself")) {
            homePage_aboutHim.setVisibility(View.GONE);
            presenter.sendHomePageHeadData((String) SPUtils.get(this, SPKey.USER_ID, ""));
        } else {
            homePage_aboutHim.setVisibility(View.VISIBLE);
            presenter.sendHomePageHeadData(him_id);
        }
        homePage_himTab.setupWithViewPager(HomePage_Viewpager);
        HomePageAdapter homePageAdapter = new HomePageAdapter(getSupportFragmentManager(), homePageTab_title, homePageTab_fragment);
        HomePage_Viewpager.setAdapter(homePageAdapter);

    }

    private void idListener() {
        app_back.setOnClickListener(this);
        homePage_themePage.setOnClickListener(this);
        homePage_attentionPage.setOnClickListener(this);
        homePage_fansPage.setOnClickListener(this);
        homePage_worksPage.setOnClickListener(this);
        homePage_rewardHe.setOnClickListener(this);
        homePage_attentionHe.setOnClickListener(this);
        homePage_himTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabSelect = "1";//作品的话是1
                        break;
                    case 1:
                        tabSelect = "2";//TA的喜欢  type是2
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void loadDate() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.homePage_attentionPage:
                startActivity(new Intent(HomepageActivity.this, MyAttentionActivity.class));
                break;
            case R.id.homePage_fansPage:
                startActivity(new Intent(HomepageActivity.this, MyFansActivity.class));
                break;
            case R.id.homePage_themePage:
                startActivity(new Intent(HomepageActivity.this, AttentionThemeActivity.class));
                break;
            case R.id.homePage_worksPage:
//                startActivity(new Intent(HomepageActivity.this, HomepageActivity.class));
                break;
            case R.id.homePage_rewardHe:
                ShowPaypopupView();
                break;
            case R.id.homePage_attentionHe:
                //                关注的时候要发送网络请求，状态参数   0去关注   1取消关注
                if (tag == false) {
                    tag = true;
                    homePage_attentionHe.setText("已关注");
                    homePage_attentionHe.setTextColor(Color.parseColor("#AAAAAA"));
                    homePage_attentionHe.setBackgroundResource(R.drawable.comment_popubackgound);
                    if (him_id.equals("myself")) {
                        homePage_aboutHim.setVisibility(View.GONE);
                        presenter.sendAttentionUserData((String) SPUtils.get(this, SPKey.USER_ID, ""), 1 + "");
                    } else {
                        homePage_aboutHim.setVisibility(View.VISIBLE);
                        presenter.sendAttentionUserData(him_id, 1 + "");
                    }
                } else {
                    tag = false;
                    homePage_attentionHe.setText("关注");
                    homePage_attentionHe.setTextColor(Color.parseColor("#b37feb"));

                    homePage_attentionHe.setBackgroundResource(R.drawable.actor_shape);
                    if (him_id.equals("myself")) {
                        homePage_aboutHim.setVisibility(View.GONE);
                        presenter.sendAttentionUserData((String) SPUtils.get(this, SPKey.USER_ID, ""), 0 + "");
                    } else {
                        homePage_aboutHim.setVisibility(View.VISIBLE);
                        presenter.sendAttentionUserData(him_id, 0 + "");
                    }
                }
                break;

        }
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
        ppwPayUserName.setText("Hi, " + him_id);
        //       获取产品列表数据
        presenter.sendProductListData("1");
        ppwPayPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentMethod.equals("1")) {
//                    presenter.setWxMakeOrderData(qieziId + "", "1", StartcatalogId, "262", "0.1", "支付");
//                    创建微信订单
                    presenter.setWxMakeOrderData(qieziId+"","3",him_id,"0.1","打赏");
                } else if (paymentMethod.equals("2")) {
//                    presenter.setMakeOrderData(qieziId + "", "1", StartcatalogId, "262", "1", "支付");
//                    创建支付宝订单
                    presenter.setMakeOrderData(qieziId+"","3",him_id,"0.1","打赏");

                } else {
                    Toast.makeText(HomepageActivity.this, "请选择支付方式", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //获取屏幕宽高
        int weight = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels * 3 / 4;

        paypopupWindow = new PopupWindow(PaypopupView, weight, height);
        paypopupWindow.setFocusable(true);
        //点击外部popueWindow消失
        paypopupWindow.setOutsideTouchable(true);
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

    @Override
    public void showHomePageHead(HomePageHeadBean homePageHeadBean) {
        if (homePageHeadBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            Glide.with(this).load(homePageHeadBean.getData().getHeadImg()).into(homePage_Avatar);
            homePage_Name.setText(homePageHeadBean.getData().getName());
            if ("2".equals(homePageHeadBean.getData().getSex())) {
                homePage_Sex.setImageResource(R.mipmap.my_f);
            } else {
                homePage_Sex.setImageResource(R.mipmap.my_m);
            }
            my_Resume.setText(homePageHeadBean.getData().getIntroduction());
            homePage_works.setText(homePageHeadBean.getData().getWorks() + "");
            homePage_fans.setText(homePageHeadBean.getData().getFans() + "");
            homePage_attention.setText(homePageHeadBean.getData().getFollows() - 1 + "");
            homePage_theme.setText(homePageHeadBean.getData().getFollowSubject() + "");
            if (homePageHeadBean.getData().getFollow() == 1) {
                homePage_attentionHe.setText("+关注");
                homePage_attentionHe.setTextColor(Color.parseColor("#ffffff"));
                homePage_attentionHe.setBackgroundResource(R.drawable.fans_attention_btn);
            } else if (homePageHeadBean.getData().getFollow() == 2) {
                homePage_attentionHe.setText("已关注");
                homePage_attentionHe.setTextColor(Color.parseColor("#aaaaaa"));
                homePage_attentionHe.setBackgroundResource(R.drawable.comment_popubackgound);
            }
        } else {
            Toast.makeText(this, "未获取到数据", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showAttentionUser(AttentionMyFansBean verificationCodeBean) {
        Toast.makeText(this, verificationCodeBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

    //得到产品列表
    @Override
    public void showProductListBean(ProductListBean productListBean) {
        if (productListBean.getData().size()!=0){
            List<ProductListBean.DataBean> listBeanData = productListBean.getData();
            GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
            ppwPayProductList.setLayoutManager(linearLayoutManager);
            ProductListAdapter productListAdapter = new ProductListAdapter(listBeanData, this);
            ppwPayProductList.setAdapter(productListAdapter);
            productListAdapter.ProductListCallback(this);
        }
    }

    //创建支付宝订单号
    @Override
    public void getMakeOrderData(MakeOrderBean productListBean) {
        if (productListBean.getData().getOrderNumber() != null) {
            String orderNumber = productListBean.getData().getOrderNumber();
            presenter.sendGetPayData(orderNumber);//发送支付宝支付
        }else {
            Toast.makeText(this, productListBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    //创建微信订单号
    @Override
    public void getWxMakeOrderData(MakeOrderBean productListBean) {
        if (productListBean.getData().getOrderNumber() != null) {
            String orderNumber = productListBean.getData().getOrderNumber();
            presenter.sendGetWxPayData(orderNumber);//发送微信支付
        }else {
            Toast.makeText(this, productListBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    //得到支付宝支付数据
    @Override
    public void showGetPayData(GetPayDataBean getPayDataBean) {
        if (getPayDataBean.getData().getOrderSign() != null) {
//            支付宝支付
//            PayUtils.getInstance().authV2(getPayDataBean.getData().getOrderSign(),this);
            PayUtils.getInstance().AliPay(getPayDataBean.getData().getOrderSign(),this);
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    //得到微信支付数据
    @Override
    public void showGetWxPayData(PayWeChatBean payWeChatBean) {
        if (payWeChatBean.getData().getOrderSign() != null) {
//            微信支付支付
            PayUtils.getInstance().WeChatPay(payWeChatBean.getData().getOrderSign());
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }
//    得到章节产品ID
    @Override
    public void showProductList(int position,int amount) {
        qieziId=position;
        qieziMoney=amount;

//        ShowPaypopupView();
    }

}
