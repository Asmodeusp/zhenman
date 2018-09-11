package com.zhenman.asus.zhenman.view.fragment;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhy.autolayout.AutoLinearLayout;

public class MessageFragment extends BaseFragment implements View.OnClickListener {


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
}
