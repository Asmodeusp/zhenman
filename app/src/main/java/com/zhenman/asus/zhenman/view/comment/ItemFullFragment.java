package com.zhenman.asus.zhenman.view.comment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.google.gson.Gson;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentItemRecyAdapter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SuppressLint("ValidFragment")
public class ItemFullFragment extends BottomSheetDialogFragment {
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
    @BindView(R.id.Item_comment_CommentNumber)
    TextView Item_comment_CommentNumber;
    @BindView(R.id.xian)
    AutoLinearLayout xian;
    private BottomSheetBehavior mBehavior;
    private String commentId;
    private CommentItemListBean commentItemListBean;

    public ItemFullFragment(String commentId) {
        this.commentId = commentId;
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
                .url(Urls.BASE_URL + Urls.COMMENT_LIST + "?id=" + commentId + "&pageNum=1&pageSize=50&commentType=3&commentSubType=2")
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
        }, R.mipmap.my_qiezi);
        //加载富文本
        ArrayList<String> list = new ArrayList<>();
        if (commentItemListBean.getData().getTextDto() != null) {
            for (CommentItemListBean.DataBean.TextDtoBean.TextExtraBean textExtraBean : commentItemListBean.getData().getTextDto().getTextExtra()) {
                list.add(textExtraBean.getText());
            }
            String[] strings = new String[list.size()];
            list.toArray(strings);
            MyClickSpan.setTextHighLightWithClick(ItemCommentConent, commentItemListBean.getData().getTextDto().getText(), strings, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), commentItemListBean.getData().getTextDto().getTextExtra().get(0).getText(), Toast.LENGTH_SHORT).show();
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
        ItemCommentFromUserText.setText(commentItemListBean.getData().getTitleDto().getText());
        //设置共几条评论
        Item_comment_CommentNumber.setText("共" + commentItemListBean.getData().getCommentDtoList().size() + "条评论");
        //设置子评论样式
        ItemCommentItemRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        //创建适配器
        CommentItemRecyAdapter commentItemRecyAdapter = new CommentItemRecyAdapter(commentItemListBean.getData().getCommentDtoList());
        //设置适配器
        ItemCommentItemRecy.setAdapter(commentItemRecyAdapter);
        if (commentItemListBean.getData().getCommentDtoList().size()==0) {
            xian.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
