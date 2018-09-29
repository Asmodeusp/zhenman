package com.zhenman.asus.zhenman.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.MySelfContract;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.presenter.MySelfPresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.myself.AccountManagementActivity;
import com.zhenman.asus.zhenman.view.myself.AttentionThemeActivity;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.myself.MyAttentionActivity;
import com.zhenman.asus.zhenman.view.myself.MyDraftActivity;
import com.zhenman.asus.zhenman.view.myself.MyFansActivity;
import com.zhenman.asus.zhenman.view.myself.MySettingActivity;
import com.zhenman.asus.zhenman.view.myself.MyWalletActivity;
import com.zhenman.asus.zhenman.view.myself.PersonalInformationActivity;
import com.zhenman.asus.zhenman.view.serializaion.BookshelfActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyselfFragment extends BaseFragment<MySelfPresenter> implements View.OnClickListener, MySelfContract.MySelfInView {


    private CircleImageView my_Avatar;
    private TextView my_Name;
    private ImageView my_Sex;
    private TextView my_WorksNumber;
    private TextView my_FansNumber;
    private TextView my_CareNumber;
    private TextView my_themeNum;
    private TextView my_Resume;
    private ImageView my_Home;
    private TextView my_PersonalHomePageTv;
    private AutoRelativeLayout my_PersonalHomePage;
    private ImageView my_WalletPicture;
    private TextView my_WalletTx;
    private AutoRelativeLayout my_WalletPage;
    private ImageView my_BookPicture;
    private TextView my_ShelfTv;
    private AutoRelativeLayout my_ShelfPage;
    private ImageView my_DraftPicture;
    private TextView my_DraftTv;
    private AutoRelativeLayout my_DraftPage;
    private ImageView my_AccountNumberPicture;
    private TextView my_AccountNumber;
    private AutoRelativeLayout my_AccountNumberPage;
    private AutoRelativeLayout my_data;
    private ImageView my_setting;
    private AutoLinearLayout my_WorksNumberPage;
    private AutoLinearLayout my_FansPage;
    private AutoLinearLayout my_CarePage;
    private AutoLinearLayout my_themePage;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void init() {
        my_setting = getActivity().findViewById(R.id.my_setting);//       设置
        my_data = getActivity().findViewById(R.id.my_data);//       个人信息
        my_Avatar = getActivity().findViewById(R.id.my_Avatar);//        头像
        my_Name = getActivity().findViewById(R.id.my_Name);//        用户名
        my_Sex = getActivity().findViewById(R.id.my_Sex);//        性别
        my_WorksNumber = getActivity().findViewById(R.id.my_WorksNumber);//        作品数量
        my_FansNumber = getActivity().findViewById(R.id.my_FansNumber);//        粉丝数量
        my_CareNumber = getActivity().findViewById(R.id.my_CareNumber);//        关注数量
        my_themeNum = getActivity().findViewById(R.id.my_themeNum);//        主题数量
        my_Resume = getActivity().findViewById(R.id.my_Resume);//简介
        my_PersonalHomePage = getActivity().findViewById(R.id.my_PersonalHomePage);//个人主页
        my_WalletPage = getActivity().findViewById(R.id.my_WalletPage);//个人钱包
        my_ShelfPage = getActivity().findViewById(R.id.my_ShelfPage);//个人书架
        my_DraftPage = getActivity().findViewById(R.id.my_DraftPage);//个人草稿
        my_WorksNumberPage = getActivity().findViewById(R.id.my_WorksNumberPage);//作品
        my_FansPage = getActivity().findViewById(R.id.my_FansPage);//粉丝
        my_CarePage = getActivity().findViewById(R.id.my_CarePage);//关注
        my_themePage = getActivity().findViewById(R.id.my_themePage);//主题

        my_AccountNumberPage = getActivity().findViewById(R.id.my_AccountNumberPage);//个人账号管理
//        accessToken   oauthId
//        获取头部信息
        presenter.sendMyselfHeadData((String) SPUtils.get(getActivity(), SPKey.USER_ID, ""));
        String s = (String) SPUtils.get(App.context, (String) SPUtils.get(getActivity(), SPKey.USER_OAUTHID, ""), "");
//        presenter.sendGetMyData(s);
        idListener();

    }

    private void idListener() {
        my_data.setOnClickListener(this);
        my_PersonalHomePage.setOnClickListener(this);
        my_WalletPage.setOnClickListener(this);
        my_ShelfPage.setOnClickListener(this);
        my_DraftPage.setOnClickListener(this);
        my_AccountNumberPage.setOnClickListener(this);
        my_setting.setOnClickListener(this);
        my_WorksNumberPage.setOnClickListener(this);
        my_FansPage.setOnClickListener(this);
        my_CarePage.setOnClickListener(this);
        my_themePage.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_setting://主页
                Intent intent = new Intent(getActivity(), MySettingActivity.class);
                intent.putExtra("UserId","");
                startActivity(intent);
                break;
            case R.id.my_data://完善个人资料
                startActivity(new Intent(getActivity(), PersonalInformationActivity.class));
                break;
            case R.id.my_PersonalHomePage:
                String userID = (String) SPUtils.get(getActivity(), SPKey.USER_ID, "");
                if (userID.isEmpty()) {
                    startActivity(new Intent(getActivity(), MainActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), HomepageActivity.class));
                }
                break;
            case R.id.my_WalletPage:
//                钱包
                startActivity(new Intent(getActivity(), MyWalletActivity.class));
                break;
            case R.id.my_WorksNumberPage:
//                主页
                startActivity(new Intent(getActivity(), HomepageActivity.class));
                break;
            case R.id.my_FansPage:
//                粉丝
                startActivity(new Intent(getActivity(), MyFansActivity.class));
                break;
            case R.id.my_CarePage:
//                我的关注
                startActivity(new Intent(getActivity(), MyAttentionActivity.class));
                break;
            case R.id.my_themePage:
//                关注的主题
                startActivity(new Intent(getActivity(), AttentionThemeActivity.class));
                break;
            case R.id.my_ShelfPage:
//                书架
                startActivity(new Intent(getActivity(), BookshelfActivity.class));
                break;
            case R.id.my_DraftPage:
                startActivity(new Intent(getActivity(), MyDraftActivity.class));
                break;
            case R.id.my_AccountNumberPage://账号管理
                startActivity(new Intent(getActivity(), AccountManagementActivity.class));
                break;
        }
    }


    //    头部信息
    @Override
    public void showMySelfHead(HomePageHeadBean homePageHeadBean) {
        if (homePageHeadBean.getState() == 0) {
            my_FansNumber.setText(homePageHeadBean.getData().getFans() + "");
            my_CareNumber.setText(homePageHeadBean.getData().getFollows() + "");
            my_WorksNumber.setText(homePageHeadBean.getData().getWorks() + "");
            my_themeNum.setText(homePageHeadBean.getData().getFollowSubject() + "");
            if ("2".equals(homePageHeadBean.getData().getSex())) {
                my_Sex.setImageResource(R.mipmap.my_f);
            } else {
                my_Sex.setImageResource(R.mipmap.my_m);
            }
            if (homePageHeadBean.getData().getHeadImg() != null) {
                Glide.with(getActivity()).load(homePageHeadBean.getData().getHeadImg()).into(my_Avatar);
            }
            my_Name.setText(homePageHeadBean.getData().getName());
            if (homePageHeadBean.getData().getIntroduction() != null) {
                my_Resume.setText(homePageHeadBean.getData().getIntroduction());

            } else {
                my_Resume.setText("本宝宝暂时没有介绍哦");


            }
        } else {
            Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    //    已经刷新页面了
    @Override
    public void onResume() {
        super.onResume();
//        presenter.sendGetMyData((String) SPUtils.get(App.context, (String) SPUtils.get(getActivity(), SPKey.USER_OAUTHID, ""), ""));
        presenter.sendMyselfHeadData((String) SPUtils.get(getActivity(), SPKey.USER_ID, ""));

    }


}
