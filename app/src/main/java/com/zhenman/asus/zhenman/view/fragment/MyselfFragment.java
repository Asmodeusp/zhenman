package com.zhenman.asus.zhenman.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.myself.MySettingActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class MyselfFragment extends BaseFragment implements View.OnClickListener {


    private ImageView my_Avatar;
    private TextView my_Name;
    private ImageView my_Sex;
    private TextView my_WorksNumber;
    private TextView my_FansNumber;
    private TextView my_CareNumber;
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
        my_Resume = getActivity().findViewById(R.id.my_Resume);//简介
        my_PersonalHomePage = getActivity().findViewById(R.id.my_PersonalHomePage);//个人主页
        my_WalletPage = getActivity().findViewById(R.id.my_WalletPage);//个人钱包
        my_ShelfPage = getActivity().findViewById(R.id.my_ShelfPage);//个人书架
        my_DraftPage = getActivity().findViewById(R.id.my_DraftPage);//个人草稿
        my_AccountNumberPage = getActivity().findViewById(R.id.my_AccountNumberPage);//个人账号管理
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
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_setting:
                Intent intent = new Intent(getActivity(), MySettingActivity.class);
                startActivity(intent);
                break;
            case R.id.my_data:

                break;
            case R.id.my_PersonalHomePage:
                break;
            case R.id.my_WalletPage:

                break;
            case R.id.my_ShelfPage:
                break;
            case R.id.my_DraftPage:
                break;

            case R.id.my_AccountNumberPage:
                break;
        }
    }


}
