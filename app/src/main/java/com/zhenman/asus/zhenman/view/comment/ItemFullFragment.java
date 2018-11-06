package com.zhenman.asus.zhenman.view.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.google.gson.Gson;
import com.sunhapper.spedittool.view.SpEditText;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentDtoListBean;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.CommentReturnBean;
import com.zhenman.asus.zhenman.model.bean.SendCommentBean;
import com.zhenman.asus.zhenman.model.bean.TextExtraBean;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentItemRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentRecyclerAdapter;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

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

import static java.lang.String.valueOf;

@SuppressLint("ValidFragment")
public class ItemFullFragment extends BottomSheetDialogFragment implements SpEditText.KeyReactListener {
    Unbinder unbinder;
    @BindView(R.id.Item_comment_HeadView)
    ImageView ItemCommentHeadView;
    @BindView(R.id.Item_comment_UserName)
    TextView ItemCommentUserName;
    @BindView(R.id.Item_comment_conent)
    TextView ItemCommentConent;
    @BindView(R.id.Item_UserLinearLayout)
    AutoLinearLayout ItemUserLinearLayout;
    @BindView(R.id.Item_comment_likeImg)
    CheckBox ItemCommentLikeImg;
    @BindView(R.id.Item_comment_likeNumberText)
    TextView ItemCommentLikeNumberText;
    @BindView(R.id.Item_comment_likeButton)
    AutoLinearLayout ItemCommentLikeButton;
    @BindView(R.id.Item_comment_AddTime)
    TextView ItemCommentAddTime;
    @BindView(R.id.Item_comment_fromUserText)
    TextView ItemCommentFromUserText;
    @BindView(R.id.Item_comment_ItemRecy)
    RecyclerView ItemCommentItemRecy;
    @BindView(R.id.Item_comment_PopuTextView)
    TextView ItemCommentPopuTextView;
    @BindView(R.id.Item_comment_PopuCommon_at)
    AutoRelativeLayout ItemCommentPopuCommonAt;
    @BindView(R.id.Item_comment_Popu_SendImage)
    ImageView ItemCommentPopuSendImage;
    @BindView(R.id.Item_comment_Popu_SendButton)
    AutoRelativeLayout ItemCommentPopuSendButton;
    @BindView(R.id.Item_comment_SendRelativeLayout)
    AutoRelativeLayout Item_comment_SendRelativeLayout;
    @BindView(R.id.itemparent)
    AutoLinearLayout itemparent;
    @BindView(R.id.Item_comment_CommentNumber)
    TextView Item_comment_CommentNumber;
    @BindView(R.id.xian)
    AutoLinearLayout xian;
    Unbinder unbinder1;
    private BottomSheetBehavior mBehavior;
    private String commentId;
    private CommentItemListBean commentItemListBean;
    private String Type;
    private SpEditText commentPopu_edit_editText;
    private AutoRelativeLayout commentPopu_edit_sendButton;
    private String text;
    private HashMap<String, String> maps = new HashMap<>();
    private ArrayList<TextExtraBean> list = new ArrayList<>();
    private String json;
    private String name = null;
    private String ugcId;
    private CommentItemRecyAdapter commentItemRecyAdapter;
    List<CommentDtoListBean> commentDtoList = new ArrayList<>();
    private PopupWindow window;

    public ItemFullFragment(String commentId, String Type, String ugcId) {
        this.commentId = commentId;
        this.Type = Type;
        this.ugcId = ugcId;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_item_full, null);
        unbinder = ButterKnife.bind(this, view);
        LoadData();
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

    private void LoadData() {

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Urls.BASE_URL + Urls.COMMENT_LIST + "?id=" + commentId + "&pageNum=1&pageSize=50&commentType=" + Type + "&commentSubType=2")
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commentItemListBean = new Gson().fromJson(string, CommentItemListBean.class);
                        initData();
                    }
                });
            }
        });
    }

    private void initData() {
        //加载头像
        GlideUtils.loadCircleImage(commentItemListBean.getData().getImageUrl(), ItemCommentHeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {

            }
        }, R.mipmap.common_portrait_m);
        //加载富文本
        if (commentItemListBean.getData().getTextDto() != null) {
            MyClickSpan.setTextHighLightWithClick(ItemCommentConent, commentItemListBean.getData().getTextDto().getText(), commentItemListBean.getData().getTextDto().getTextExtra(), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = commentItemListBean.getData().getTextDto().getTextExtra().get(0).getId();
                    Intent intent = new Intent(getContext(), HomepageActivity.class);
                    intent.putExtra(SPKey.HIM_ID, id);
                    getActivity().startActivity(intent);
                }
            });
        }
        //加载用户名
        ItemCommentUserName.setText(commentItemListBean.getData().getName());
        //加载喜欢个数
        ItemCommentLikeNumberText.setText(commentItemListBean.getData().getLikeNum() + "");
        //加载添加时间
        ItemCommentAddTime.setText(SPUtils.transferLongToDate(Long.parseLong(commentItemListBean.getData().getAddTime())));
        //设置评论来自位置
        if (Type.equals("1")) {
            ItemCommentFromUserText.setVisibility(View.GONE);
        } else {
            ItemCommentFromUserText.setText(commentItemListBean.getData().getTitleDto().getText());
        }
        //设置共几条评论
        Item_comment_CommentNumber.setText("共" + commentItemListBean.getData().getCommentDtoList().size() + "条评论");
        //设置子评论样式
        ItemCommentItemRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        //创建适配器
        commentDtoList.addAll(commentItemListBean.getData().getCommentDtoList());
        commentItemRecyAdapter = new CommentItemRecyAdapter(commentDtoList);
        //设置适配器
        ItemCommentItemRecy.setAdapter(commentItemRecyAdapter);
        if (commentItemListBean.getData().getCommentDtoList().size() == 0) {
            xian.setVisibility(View.GONE);
        }
        commentItemRecyAdapter.setRecyclerViewOnCLickListener(new CommentItemRecyAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                String MyuserId = (String) SPUtils.get(getContext(), SPKey.USER_ID, "");
                if (commentDtoList.get(position).getUserId().equals(MyuserId)) {
                    initDeleteCommentPopu(position);
                }else{
                    Pull_upEdText(commentDtoList.get(position).getDetailId());
                }
            }
        });
    }

    private void initDeleteCommentPopu(final int position) {
        // 用于PopupWindow的View
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.comment_delete_popu, null, false);
        window = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
        window.showAtLocation(itemparent, Gravity.BOTTOM, 0, 0);
        final Button deleteCommentButton = contentView.findViewById(R.id.deleteCommentButton);
        Button cancelCommentButton = contentView.findViewById(R.id.cancelCommentButton);
        //删除监听事件
        deleteCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detailId = commentDtoList.get(position).getDetailId();

                deleteComment(detailId, position);
            }
        });
        cancelCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
    }

    private void deleteComment(String commentId, final int position) {
        FormBody.Builder params = new FormBody.Builder();
        if (Integer.parseInt(Type) == 3) {
            this.Type = "3";
        }
        params.add("commentType", Type);
        params.add("commentId", commentId);
        params.add("commentSubType", "2");
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Urls.BASE_URL + "ugcCommentInfo/deleteComment")
                .post(params.build())
                .addHeader("accessToken", ((String) SPUtils.get(App.context, SPKey.USER_TOKEN, "")))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commentDtoList.remove(position);
                        commentItemRecyAdapter = new CommentItemRecyAdapter(commentDtoList);
                        ItemCommentItemRecy.setAdapter(commentItemRecyAdapter);
                        commentItemRecyAdapter.notifyDataSetChanged();
                        window.dismiss();
                    }
                });
            }
        });

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.Item_comment_SendRelativeLayout)
    public void onViewClicked() {
        Pull_upEdText("");
    }

    private void Pull_upEdText(final String DetailId) {
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
                SendComment(DetailId);
                bottomSheetDialog.dismiss();
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
    public void onKeyReact(String key) {
        switch (key) {
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

    private void SendComment(String DetailId) {
        FormBody.Builder params = new FormBody.Builder();
        if (Integer.parseInt(Type) == 3) {
            this.Type = "3";
            params.add("id", commentId);
        } else {
            params.add("id", commentId);
        }
        params.add("content", text);
        params.add("json", json);
        params.add("commentType", Type);
        params.add("commentSubType", "2");
        params.add("commentId", DetailId);
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

                        commentItemRecyAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }

}
