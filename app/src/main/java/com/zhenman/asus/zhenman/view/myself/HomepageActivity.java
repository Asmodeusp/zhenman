package com.zhenman.asus.zhenman.view.myself;


import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.HomePageContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.presenter.HomePagePresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.myself.HomePageAdapter;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyLikeFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyWorkFragment;
import com.zhenman.asus.zhenman.view.ui.NoSrcollViewPage;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomepageActivity extends BaseActivity<HomePagePresenter> implements View.OnClickListener, HomePageContract.HomePageInView {

    private ImageView app_back;
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
    private HomePageMyWorkFragment homePageMyWorkFragment;
    private HomePageMyLikeFragment homePageMyLikeFragment;
    private AutoLinearLayout homePage_worksPage;
    private AutoLinearLayout homePage_fansPage;
    private AutoLinearLayout homePage_attentionPage;
    private AutoLinearLayout homePage_themePage;
    private String fromMyself = "myself";
    private String fromHome = "home";
    private TextView homePage_rewardHe;
    private TextView homePage_attentionHe;
    private View popupView1;
    private RecyclerView ppwPay_productList;
    private RadioButton ppwPay_zhifubaoBtn;
    private RadioButton ppwPay_weixinBtn;
    private Button ppwPay_payBtn;
    private TextView ppwPay_payMoney;
    private TextView ppwPay_qieziNum;
    private RadioGroup ppwPay_radioGroup;
    private TextView ppwPay_num;
    private TextView ppwPay_userName;
    private PopupWindow popupWindow;
    private String paymentMethod;
    private boolean tag = false;
    private AutoRelativeLayout homePage_aboutHim;
    public static String him_id;

    protected int getLayoutId() {
        return R.layout.activity_homepage;
    }

    @Override
    protected void init() {

        app_back = (ImageView) findViewById(R.id.app_back);
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
        presenter.sendHomePageHeadData((String) SPUtils.get(this, SPKey.USER_ID, ""));
        idListener();
        Intent intent = getIntent();
        him_id = intent.getStringExtra("HIM_ID");
        if (him_id.equals("myself")){
            homePage_aboutHim.setVisibility(View.GONE);
            presenter.sendHomePageHeadData((String) SPUtils.get(this, SPKey.USER_ID, ""));
        }else {
            homePage_aboutHim.setVisibility(View.VISIBLE);
            presenter.sendHomePageHeadData(him_id);
        }
        /*String userId = (String) SPUtils.get(this, SPKey.USER_ID, "");
        String himeId = (String) SPUtils.get(this, SPKey.HIM_ID, "");
//        从Sp中获取他人ID，如果有的话就证明是从他人ID那里跳转过来的，如果没有的话证明是请求个人主页
        if (himeId.isEmpty()) {
            homePage_aboutHim.setVisibility(View.GONE);
            presenter.sendHomePageHeadData((String) SPUtils.get(this, SPKey.USER_ID, ""));
        } else {
            homePage_aboutHim.setVisibility(View.VISIBLE);
            presenter.sendHomePageHeadData(himeId);
        }*/
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
                showPopueWindow();
                break;
            case R.id.homePage_attentionHe:
                //                关注的时候要发送网络请求，状态参数   0去关注   1取消关注
                if (tag == false) {
                    tag = true;
                    homePage_attentionHe.setText("已关注");
                    homePage_attentionHe.setTextColor(Color.parseColor("#AAAAAA"));
                    homePage_attentionHe.setBackgroundResource(R.drawable.comment_popubackgound);
                    if (him_id.equals("myself")){
                        homePage_aboutHim.setVisibility(View.GONE);
                        presenter.sendAttentionUserData((String) SPUtils.get(this, SPKey.USER_ID, ""),1+"");
                    }else {
                        homePage_aboutHim.setVisibility(View.VISIBLE);
                        presenter.sendAttentionUserData(him_id,1+"");
                    }
                } else {
                    tag = false;
                    homePage_attentionHe.setText("关注");
                    homePage_attentionHe.setTextColor(Color.parseColor("#b37feb"));

                    homePage_attentionHe.setBackgroundResource(R.drawable.actor_shape);
                    if (him_id.equals("myself")){
                        homePage_aboutHim.setVisibility(View.GONE);
                        presenter.sendAttentionUserData((String) SPUtils.get(this, SPKey.USER_ID, ""),0+"");
                    }else {
                        homePage_aboutHim.setVisibility(View.VISIBLE);
                        presenter.sendAttentionUserData(him_id,0+"");
                    }
                }
                break;

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
            if (homePageHeadBean.getData().getFollow() == 2) {
                homePage_attentionHe.setText("+关注");
                homePage_attentionHe.setTextColor(Color.parseColor("#ffffff"));
                homePage_attentionHe.setBackgroundResource(R.drawable.fans_attention_btn);
            } else if (homePageHeadBean.getData().getFollow() == 1) {
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
}
