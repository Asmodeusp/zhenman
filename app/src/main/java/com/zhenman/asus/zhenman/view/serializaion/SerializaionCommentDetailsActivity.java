package com.zhenman.asus.zhenman.view.serializaion;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;
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
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializaionCommentDetailsContract;
import com.zhenman.asus.zhenman.model.bean.CommentDtoListBean;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.CommentReturnBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SendCommentBean;
import com.zhenman.asus.zhenman.model.bean.TextExtraBean;
import com.zhenman.asus.zhenman.presenter.SerializaionCommentDetailsPresenterImp;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentItemRecyAdapter;
import com.zhenman.asus.zhenman.view.comment.CommentAtUeserlistActivity;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.String.valueOf;

public class SerializaionCommentDetailsActivity extends BaseActivity<SerializaionCommentDetailsPresenterImp> implements SerializaionCommentDetailsContract.SerializaionCommentDetailsView, SpEditText.KeyReactListener {

    @BindView(R.id.SerializaionCommentDetails_return)
    AutoLinearLayout SerializaionCommentDetailsReturn;
    @BindView(R.id.SerializaionCommentDetails_CommentNumber)
    TextView SerializaionCommentDetailsCommentNumber;
    @BindView(R.id.SerializaionCommentDetails_HeadView)
    ImageView SerializaionCommentDetailsHeadView;
    @BindView(R.id.SerializaionCommentDetails_UserName)
    TextView SerializaionCommentDetailsUserName;
    @BindView(R.id.SerializaionCommentDetails_Comment)
    TextView SerializaionCommentDetailsComment;
    @BindView(R.id.SerializaionCommentDetails_Time)
    TextView SerializaionCommentDetailsTime;
    @BindView(R.id.SerializaionCommentDetails_Like)
    CheckBox SerializaionCommentDetailsLike;
    @BindView(R.id.SerializaionCommentDetails_LikeNumber)
    TextView SerializaionCommentDetailsLikeNumber;
    @BindView(R.id.SerializaionCommentDetails_AllCommentTip)
    AutoLinearLayout SerializaionCommentDetailsAllCommentTip;
    @BindView(R.id.SerializaionCommentDetails_CommentRecy)
    RecyclerView SerializaionCommentDetailsCommentRecy;
    @BindView(R.id.SerializaionCommentDetails_TextView)
    TextView SerializaionCommentDetailsTextView;
    @BindView(R.id.SerializaionCommentDetails_atRelativeLayout)
    AutoRelativeLayout SerializaionCommentDetailsAtRelativeLayout;
    @BindView(R.id.SerializaionCommentDetails_SendImage)
    ImageView SerializaionCommentDetailsSendImage;
    @BindView(R.id.SerializaionCommentDetails_SendButton)
    AutoRelativeLayout SerializaionCommentDetailsSendButton;
    @BindView(R.id.SerializaionCommentDetails_QUAN)
    AutoLinearLayout SerializaionCommentDetailsQuan;
    private String commentId;
    private String PgcId;
    private SpEditText commentPopu_edit_editText;
    private CommentItemListBean commentItemListBean;
    private List<CommentDtoListBean> commentDtoList = new ArrayList<>();
    private PopupWindow window;
    private AutoRelativeLayout commentPopu_edit_sendButton;
    private HashMap<String, String> maps = new HashMap<>();
    private String text;
    private ArrayList<TextExtraBean> list = new ArrayList<>();
    private String json;
    private String name = null;
    private CommentItemRecyAdapter commentItemRecyAdapter;
    private String Type ="2";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_serializaion_comment_details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        PgcId = intent.getStringExtra(SPKey.PGC_ID);
        commentId = intent.getStringExtra("CommentId");
    }

    private void initLogic() {
        if (commentItemListBean.getData().getCommentDtoList().size() != 0 && commentItemListBean.getData().getCommentDtoList() != null) {
            SerializaionCommentDetailsAllCommentTip.setVisibility(View.VISIBLE);
        } else {
            SerializaionCommentDetailsAllCommentTip.setVisibility(View.GONE);
        }
        GlideUtils.loadCircleImage(commentItemListBean.getData().getImageUrl(), SerializaionCommentDetailsHeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
            }
        });

        SerializaionCommentDetailsTime.setText(SPUtils.transferLongToDate(Long.parseLong(commentItemListBean.getData().getAddTime())));
        SerializaionCommentDetailsLikeNumber.setText(commentItemListBean.getData().getLikeNum() + "");
        if (commentItemListBean.getData().isLike()) {
            SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_on);

        } else {
            SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_off);
        }
        if (commentItemListBean.getData().isLike()) {
            SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_on);
            SerializaionCommentDetailsLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SerializaionCommentDetailsLike.isChecked()) {
                        SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "0", PgcId);
                        SerializaionCommentDetailsLikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") - 1 + "");
                    } else {
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "1", PgcId);
                        SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        SerializaionCommentDetailsLikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") + "");
                    }
                }
            });
        } else {
            SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_off);
            SerializaionCommentDetailsLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SerializaionCommentDetailsLike.isChecked()) {
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "1", PgcId);
                        SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_on);
                        SerializaionCommentDetailsLikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") + 1 + "");
                    } else {
                        presenter.PGCFabulous(PgcId, commentItemListBean.getData().getCommentId(), "0", PgcId);
                        SerializaionCommentDetailsLike.setButtonDrawable(R.mipmap.guanzhu_like_off);
                        SerializaionCommentDetailsLikeNumber.setText(Integer.parseInt(commentItemListBean.getData().getLikeNum() + "") + "");
                    }
                }
            });
        }
        SerializaionCommentDetailsUserName.setText(commentItemListBean.getData().getName());

        if (commentItemListBean.getData().getTextDto() != null) {

            List<TextExtraBean> textExtra = commentItemListBean.getData().getTextDto().getTextExtra();
            MyClickSpan.setTextHighLightWithClick(SerializaionCommentDetailsComment, commentItemListBean.getData().getTextDto().getText(), textExtra, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = commentItemListBean.getData().getTextDto().getTextExtra().get(0).getId();
                    Intent intent = new Intent(SerializaionCommentDetailsActivity.this, HomepageActivity.class);
                    intent.putExtra(SPKey.HIM_ID, id);
                    SerializaionCommentDetailsActivity.this.startActivity(intent);
                }
            });
        }
        SerializaionCommentDetailsCommentRecy.setLayoutManager(new LinearLayoutManager(this));
        commentDtoList = commentItemListBean.getData().getCommentDtoList();
        commentItemRecyAdapter = new CommentItemRecyAdapter(commentDtoList);
        SerializaionCommentDetailsCommentRecy.setAdapter(commentItemRecyAdapter);
        commentItemRecyAdapter.setRecyclerViewOnCLickListener(new CommentItemRecyAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                String MyuserId = (String) SPUtils.get(SerializaionCommentDetailsActivity.this, SPKey.USER_ID, "");
                if (commentDtoList.get(position).getUserId().equals(MyuserId)) {
                    initDeleteCommentPopu(position);
                } else {
                    Pull_upEdText(commentDtoList.get(position).getDetailId());
                }
            }
        });

    }

    private void Pull_upEdText(final String DetailId) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_edtext, null, false);
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
        Intent intent = new Intent(this, CommentAtUeserlistActivity.class);
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commentDtoList.add(0, data);

                        commentItemRecyAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }

    private void initDeleteCommentPopu(final int position) {
        // 用于PopupWindow的View
        View contentView = LayoutInflater.from(this).inflate(R.layout.comment_delete_popu, null, false);
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        window = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
        window.showAtLocation(SerializaionCommentDetailsQuan, Gravity.BOTTOM, 0, 0);
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commentDtoList.remove(position);
                        commentItemRecyAdapter.notifyDataSetChanged();
                        window.dismiss();
                    }
                });
            }
        });

    }

    @Override
    protected void loadDate() {
        Intent intent = getIntent();
        String commentId = intent.getStringExtra("CommentId");
        presenter.getCommentItemList(commentId, "1", "20", "2", "2");

    }


    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean) {

    }

    @Override
    public void showCommentItemList(CommentItemListBean commentItemListBean) {
        this.commentItemListBean = commentItemListBean;
        initLogic();
    }


    @OnClick({R.id.SerializaionCommentDetails_return, R.id.SerializaionCommentDetails_TextView, R.id.SerializaionCommentDetails_atRelativeLayout, R.id.SerializaionCommentDetails_SendButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SerializaionCommentDetails_return:
                finish();
                break;
            case R.id.SerializaionCommentDetails_TextView:
                Pull_upEdText("");
                break;
            case R.id.SerializaionCommentDetails_atRelativeLayout:
                Pull_upEdText("");
                break;
            case R.id.SerializaionCommentDetails_SendButton:
                Pull_upEdText("");
                break;
        }
    }

    @Override
    public void onKeyReact(String key) {

    }
}
