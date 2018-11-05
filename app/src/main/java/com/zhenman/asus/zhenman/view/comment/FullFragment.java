package com.zhenman.asus.zhenman.view.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sunhapper.spedittool.view.SpEditText;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentDtoListBean;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.CommentReturnBean;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.SendCommentBean;
import com.zhenman.asus.zhenman.model.bean.TextExtraBean;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentRecyclerAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.String.*;


@SuppressLint("ValidFragment")
public class FullFragment extends BottomSheetDialogFragment implements SpEditText.KeyReactListener {
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

    private SpEditText commentPopu_edit_editText;
    private AutoRelativeLayout commentPopu_edit_common_at;
    private String name = null;
    CommentListBean commentListBean;
    private String Type;
    private AutoRelativeLayout commentPopu_edit_sendButton;
    private ArrayList<TextExtraBean> list = new ArrayList<>();
    private HashMap<String, String> maps = new HashMap<>();
    private String json;
    private String text;
    private String ugcId;
    private List<CommentDtoListBean> commentDtoList = new ArrayList<>();
    private CommentRecyclerAdapter commentRecyclerAdapter;

    public FullFragment(CommentListBean commentListBean, String Type, String ugcId) {
        this.commentListBean = commentListBean;
        this.Type = Type;
        this.ugcId = ugcId;
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
                CommentPopuNumber.setText(commentListBean.getData().getCommentDtoList().size() + "条评论");
                commentDtoList.addAll(commentListBean.getData().getCommentDtoList());
                commentRecyclerAdapter = new CommentRecyclerAdapter(commentDtoList);
                CommentPopuRecy.setAdapter(commentRecyclerAdapter);
                commentRecyclerAdapter.setRecyclerViewOnCLickListener(new CommentRecyclerAdapter.RecyclerViewOnCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        ItemFullFragment fullFragment = new ItemFullFragment(commentListBean.getData().getCommentDtoList().get(position).getCommentId(), Type,ugcId);
                        fullFragment.show(getActivity().getSupportFragmentManager(), "dialog");
                    }
                });
            }
        } else {
            CommentPopuNumber.setText("0条评论");
            CommentPopuTip.setVisibility(View.VISIBLE);
            CommentPopuRecy.setVisibility(View.GONE);
        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getUserId(MyAttentionUserBean.DataBean.ResultBean resultBean) {

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
                Pull_upEdText();
                break;
            //发送按钮
            case R.id.CommentPopu_SendButton:
                Pull_upEdText();
                break;
        }
    }

    private void Pull_upEdText() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
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
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
        commentPopu_edit_editText.setKeyReactListener(this);
        //点击发送得到数据
        commentPopu_edit_sendButton = view.findViewById(R.id.CommentPopu_edit_SendButton);

        commentPopu_edit_sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = valueOf(commentPopu_edit_editText.getText());
                for (String in : maps.keySet()) {
                    //map.keySet()返回的是所有key的值
                    String id = maps.get(in);//得到每个key多对用value的值
                    Pattern p = Pattern.compile(in);
                    Matcher m = p.matcher(text);
                    while (m.find()) {
                        int start = m.start();
                        int end = m.end();
                        TextExtraBean textExtraBean = new TextExtraBean(start, end - start, id, in, 1, "");
                        list.add(textExtraBean);
                    }
                }
                SendCommentBean sendCommentBean = new SendCommentBean(text, list);
                json = new Gson().toJson(sendCommentBean);
                SendComment();
                bottomSheetDialog.dismiss();
            }
        });
    }

    private void SendComment() {
        FormBody.Builder params = new FormBody.Builder();
        if (Integer.parseInt(Type) == 3) {
            this.Type = "3";
            params.add("id", (String) SPUtils.get(getContext(), SPKey.CATALOGID_ID, ""));
        } else {
            params.add("id", ugcId);
        }
        params.add("content", text);
        params.add("json", json);
        params.add("commentType", Type);
        params.add("commentSubType", "1");
        params.add("commentId", "");
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Urls.BASE_URL + "ugcCommentInfo/saveComment")
                .post(params.build())
                .addHeader("accessToken", ((String) SPUtils.get(App.context, SPKey.USER_TOKEN, "")))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                CommentReturnBean commentReturnBean = new Gson().fromJson(response.body().string(), CommentReturnBean.class);
                final CommentDtoListBean data = commentReturnBean.getData();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commentDtoList.add(0, data);
                        commentRecyclerAdapter = new CommentRecyclerAdapter(commentDtoList);
                        CommentPopuRecy.setAdapter(commentRecyclerAdapter);
                        commentRecyclerAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }

    private void BouncingAtUser() {
        Intent intent = new Intent(getActivity(), CommentAtUeserlistActivity.class);
        startActivityForResult(intent, 200);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200 && resultCode == 500) {
            name = data.getStringExtra("name");
            String id = data.getStringExtra("id");
            if (name != null) {
                commentPopu_edit_editText
                        .insertSpecialStr("@" + name, false, 1, new ForegroundColorSpan(Color.parseColor("#B37FEB")));
                maps.put("@" + name, id);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onKeyReact(String s) {
        switch (s) {
            case "@":
                BouncingAtUser();
                break;
            case "#":
                break;
            case "%":
                break;
            case "*":
                break;
        }
    }
}
