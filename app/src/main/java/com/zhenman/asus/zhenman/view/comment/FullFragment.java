package com.zhenman.asus.zhenman.view.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentRecyclerAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


@SuppressLint("ValidFragment")
public class FullFragment extends BottomSheetDialogFragment {
    //无评论时的提示字
    @BindView(R.id.CommentPopu_Tip)
    TextView CommentPopuTip;
    //评论的RecyclerView
    @BindView(R.id.CommentPopu_Recy)
    RecyclerView CommentPopuRecy;
    //评论时的输入框
    @BindView(R.id.CommentPopu_TextView)
    TextView CommentPopuTextView;
    //@按钮
    @BindView(R.id.CommentPopu_Common_at)
    AutoRelativeLayout CommentPopuCommonAt;
    //发送Imageview
    @BindView(R.id.CommentPopu_SendImage)
    ImageView CommentPopuSendImage;
    //发送按钮
    @BindView(R.id.CommentPopu_SendButton)
    AutoRelativeLayout CommentPopuSendButton;
    Unbinder unbinder;
    //评论数
    @BindView(R.id.CommentPopu_Number)
    TextView CommentPopuNumber;

    private BottomSheetBehavior mBehavior;

    private EditText commentPopu_edit_editText;
    private AutoRelativeLayout commentPopu_edit_common_at;
    private String name;
    CommentListBean commentListBean;

    public FullFragment(CommentListBean commentListBean) {
        this.commentListBean = commentListBean;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bottom_sheet_dialog_layout, null);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        initData();
        dialog.setContentView(view);

        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

    private void initData() {
        CommentPopuRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (commentListBean != null) {
            CommentPopuRecy.setVisibility(View.VISIBLE);
            CommentPopuTip.setVisibility(View.GONE);
            if (commentListBean.getData().getCommentDtoList().size() != 0) {
                CommentPopuNumber.setText(commentListBean.getData().getCommentDtoList().size()+"条评论");
                CommentRecyclerAdapter commentRecyclerAdapter = new CommentRecyclerAdapter(commentListBean.getData().getCommentDtoList());
                CommentPopuRecy.setAdapter(commentRecyclerAdapter);
            }
        } else {
            CommentPopuTip.setVisibility(View.VISIBLE);
            CommentPopuRecy.setVisibility(View.GONE);
        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void CommentListBean(CommentListBean commentListBean) {

//        CommentRecyclerAdapter commentRecyclerAdapter = new CommentRecyclerAdapter(commentListBean.getData().getCommentDtoList());
//        CommentPopuRecy.setAdapter(commentRecyclerAdapter);
    }


    @OnClick({R.id.CommentPopu_TextView, R.id.CommentPopu_Common_at, R.id.CommentPopu_SendButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //模拟输入框
            case R.id.CommentPopu_TextView:
                Pull_upEdText();
                break;
            //@按钮
            case R.id.CommentPopu_Common_at:
                startActivity(new Intent(getActivity(), CommentAtUeserlistActivity.class));
                break;
            //发送按钮
            case R.id.CommentPopu_SendButton:

                break;
        }
    }

    private void Pull_upEdText() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_edtext, null, false);
        commentPopu_edit_editText = view.findViewById(R.id.CommentPopu_edit_EditText);
        AutoRelativeLayout commentPopu_edit_common_at = view.findViewById(R.id.CommentPopu_edit_Common_at);
        commentPopu_edit_common_at.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BouncingAtUser();
            }
        });
        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        bottomSheetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        commentPopu_edit_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }

    private void BouncingAtUser() {
        Intent intent = new Intent(getActivity(), CommentAtUeserlistActivity.class);
        startActivityForResult(intent, 200);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200 && resultCode == 500) {
            name = data.getStringExtra("name");
            commentPopu_edit_editText.setText("@" + name);
            commentPopu_edit_editText.setSelection(("@" + name).length());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
