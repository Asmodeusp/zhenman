package com.zhenman.asus.zhenman.view.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;

import com.zhenman.asus.zhenman.contract.WorkContract;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


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

    private BottomSheetBehavior mBehavior;
    private WorkContract.WorkPresenter presenter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bottom_sheet_dialog_layout, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

    private void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

                break;
            //发送按钮
            case R.id.CommentPopu_SendButton:

                break;
        }
    }

    private void Pull_upEdText() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_edtext, null, false);
        EditText CommentPopu_edit_EditText = view.findViewById(R.id.CommentPopu_edit_EditText);
        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        bottomSheetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        CommentPopu_edit_EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("@")) {
                    BouncingAtUser();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }

    private void BouncingAtUser() {

    }
}
