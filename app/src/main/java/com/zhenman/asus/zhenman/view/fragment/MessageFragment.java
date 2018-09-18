package com.zhenman.asus.zhenman.view.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.TheamBeanContract;
import com.zhenman.asus.zhenman.model.bean.TheamBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.presenter.TheamBeanPresenter;
import com.zhenman.asus.zhenman.view.adapter.message.ThemeAdapter;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.List;

public class MessageFragment extends BaseFragment<TheamBeanPresenter> implements View.OnClickListener, TheamBeanContract.TheamBeanInView, ThemeAdapter.ThemeCallback {


    private ImageView app_back;
    private TextView app_title;
    private TextView app_otherID;
    private AutoLinearLayout message_like;
    private AutoLinearLayout message_comment;
    private AutoLinearLayout message_fans;
    private AutoLinearLayout message_pay;
    private RecyclerView message_recy;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void init() {
        app_back = getActivity().findViewById(R.id.app_back);
        app_title = getActivity().findViewById(R.id.app_title);
        message_like = getActivity().findViewById(R.id.message_like);
        message_comment = getActivity().findViewById(R.id.message_comment);
        message_fans = getActivity().findViewById(R.id.message_fans);
        message_pay = getActivity().findViewById(R.id.message_pay);
        message_recy = getActivity().findViewById(R.id.message_recy);
        app_title.setText("消息");
        app_back.setVisibility(View.GONE);
        idListener();
//        获取主题信息
        presenter.sendTheamBean();

    }

    private void idListener() {

        message_like.setOnClickListener(this);
        message_comment.setOnClickListener(this);
        message_fans.setOnClickListener(this);
        message_pay.setOnClickListener(this);

    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.message_like:
                break;
            case R.id.message_comment:
                break;
            case R.id.message_fans:
                break;
            case R.id.message_pay:
                break;
        }
    }

    //    得到主题详情
    @Override
    public void showTheamBean(TheamBean theamBean) {
        if (theamBean.getState() == 0) {
            List<TheamBean.DataBean> dataBeanList = theamBean.getData();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            message_recy.setLayoutManager(linearLayoutManager);
            ThemeAdapter themeAdapter = new ThemeAdapter(dataBeanList, getContext());
            themeAdapter.ThemeCallback(this);
            message_recy.setAdapter(themeAdapter);
        } else {
            Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {

    }

    @Override
    public void showAttentionTheme(ThemeAttentionBean themeAttentionBean) {
        if (themeAttentionBean.getState() == 0) {
            Toast.makeText(getActivity(), themeAttentionBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    //    关注
    @Override
    public void makeAttention(String subjectId, int status) {
        presenter.sendAttentionThemeData(subjectId, status + "");
    }
}
