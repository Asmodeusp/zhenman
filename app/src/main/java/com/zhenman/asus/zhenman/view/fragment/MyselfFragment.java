package com.zhenman.asus.zhenman.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.MySelfContract;
import com.zhenman.asus.zhenman.model.bean.GetMyDataBean;
import com.zhenman.asus.zhenman.presenter.MySelfPresenter;
import com.zhenman.asus.zhenman.view.myself.AccountManagementActivity;
import com.zhenman.asus.zhenman.view.myself.MySettingActivity;
import com.zhenman.asus.zhenman.view.myself.MyWalletActivity;
import com.zhenman.asus.zhenman.view.myself.PersonalInformationActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class MyselfFragment extends BaseFragment<MySelfPresenter> implements View.OnClickListener, MySelfContract.MySelfInView {


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
//        accessToken   oauthId
        presenter.sendGetMyData("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzQ4MzYzOTAsInN1YiI6IntcInVzZXJJZFwiOjMwNixcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiQjUyNzI3NkIyODlFRjcyRTM5NzAxRUJDQjMyNzdFRUVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NjM3MjM5MH0.0nQECGVov3ZMpdbblKfBKThM7ogDtP-qJrOwT7bYHDs", "69");
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
            case R.id.my_data://完善个人资料
                startActivity(new Intent(getActivity(), PersonalInformationActivity.class));
                break;
            case R.id.my_PersonalHomePage:
                break;
            case R.id.my_WalletPage:
                startActivity(new Intent(getActivity(), MyWalletActivity.class));
                break;
            case R.id.my_ShelfPage:

                break;
            case R.id.my_DraftPage:
                break;

            case R.id.my_AccountNumberPage://账号管理
                startActivity(new Intent(getActivity(), AccountManagementActivity.class));
                break;
        }
    }


    @Override
    public void showGetMyData(GetMyDataBean getMyDataBean) {
        if (getMyDataBean.getData().getHeadImg()!=null) {
            Glide.with(getActivity()).load(getMyDataBean.getData().getHeadImg()).into(my_Avatar);
        }
        my_Name.setText(getMyDataBean.getData().getName());
        if ("1".equals(getMyDataBean.getData().getSex())) {
            my_Sex.setImageResource(R.mipmap.my_f);
//            my_Sex.setImageBitmap(getResources().getDrawable((R.mipmap.my_f)));

        } else {
//            my_Sex.setImageDrawable(getResources().getDrawable((R.drawable.my_m)));
            my_Sex.setImageResource(R.mipmap.my_m);

        }
        my_Resume.setText(getMyDataBean.getData().getIntroduction());

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.sendGetMyData("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzQ4MzYzOTAsInN1YiI6IntcInVzZXJJZFwiOjMwNixcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiQjUyNzI3NkIyODlFRjcyRTM5NzAxRUJDQjMyNzdFRUVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NjM3MjM5MH0.0nQECGVov3ZMpdbblKfBKThM7ogDtP-qJrOwT7bYHDs", "69");

    }
}
