package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sunhapper.spedittool.view.SpEditText;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkDetailsCommentContract;
import com.zhenman.asus.zhenman.model.bean.CommentDtoListBean;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.CommentReturnBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SendCommentBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.model.bean.TextExtraBean;
import com.zhenman.asus.zhenman.presenter.WorkDetailsCommentPresenterImp;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.comment.CommentRecyclerAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.WorkDetailsActorRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.WorkDetailsCommentAdapter;
import com.zhenman.asus.zhenman.view.comment.CommentAtUeserlistActivity;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.serializaion.SerializaionCommentDetailsActivity;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;
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

/**
 * 曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */

public class WorkDetailsFragment extends BaseFragment<WorkDetailsCommentPresenterImp> implements WorkDetailsCommentContract.WorkDetailsCommentView, SpEditText.KeyReactListener {
    @BindView(R.id.Work_DescriptionText)
    TextView WorkDescriptionText;
    @BindView(R.id.Actor_Recy)
    RecyclerView ActorRecy;
    @BindView(R.id.Actor_RecyTips)
    TextView ActorRecyTips;
    @BindView(R.id.Work_commentTips)
    TextView WorkCommentTips;
    @BindView(R.id.Work_commentRecy)
    RecyclerView WorkCommentRecy;
    @BindView(R.id.Work_TextView)
    TextView WorkTextView;
    @BindView(R.id.Work_atRelativelayout)
    AutoRelativeLayout WorkAtRelativelayout;
    @BindView(R.id.Work_SendButton)
    AutoRelativeLayout WorkSendButton;

    @BindView(R.id.CommentPopu_SendImage)
    ImageView CommentPopuSendImage;
    private SpEditText commentPopu_edit_editText;
    private AutoRelativeLayout commentPopu_edit_sendButton;
    private String pgcId;
    private String text;
    private String json;
    private ArrayList<TextExtraBean> list = new ArrayList<>();
    private HashMap<String, String> maps = new HashMap<>();
    private String name = null;
    private String Type ="2";
    private List<CommentDtoListBean> commentDtoList;
    private WorkDetailsCommentAdapter workDetailsCommentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_details;
    }

    @Override
    protected void init() {
        pgcId = ((String) SPUtils.get(getContext(), SPKey.PGC_ID, "1"));

        //得到连载详情Bean
        SerializationDetailsBean.DataBean data = ((WorkDetailsActivity) getActivity()).serializationDetailsBeandata;

        if (data != null) {
            if (data.getActorList().size() == 0 && data.getActorList() == null) {
                ActorRecyTips.setVisibility(View.VISIBLE);
            }
            //设置作品描述
            WorkDescriptionText.setText(data.getIntroduction());
            //设置演员列表格式
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ActorRecy.setLayoutManager(linearLayoutManager);
            WorkDetailsActorRecyAdapter workDetailsActorRecyAdapter = new WorkDetailsActorRecyAdapter(data.getActorList(), presenter);
            //设置演员列表适配器
            ActorRecy.setAdapter(workDetailsActorRecyAdapter);
            workDetailsActorRecyAdapter.setgoUserInfo(new WorkDetailsActorRecyAdapter.goUserInfo() {
                @Override
                public void go(String UserId) {
                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
                    getActivity().finish();
                }
            });
        }
        presenter.getCommentList(pgcId, "1", "20", "2", "1");
//        work_commentTips.setVisibility(View.VISIBLE);
        //设置评论列表格式
        WorkCommentRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showError(String msg) {
//        if (!msg.equals("成功")) {
//            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
//        }
    }


    @Override
    public void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean) {
        Toast.makeText(getContext(), pgcFabulousBean.getMsg(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFollowBean(FollowBean followBean) {

    }

    @Override
    public void showCommentListBean(final CommentListBean commentListBean) {
        if (commentListBean != null) {
            if (commentListBean.getData().getCommentDtoList().size() == 0) {
                WorkCommentTips.setVisibility(View.VISIBLE);
                WorkCommentRecy.setVisibility(View.GONE);
            } else {
                WorkCommentTips.setVisibility(View.GONE);
                WorkCommentRecy.setVisibility(View.VISIBLE);
                commentDtoList = commentListBean.getData().getCommentDtoList();
                workDetailsCommentAdapter = new WorkDetailsCommentAdapter(commentDtoList);

                WorkCommentRecy.setAdapter(workDetailsCommentAdapter);
                workDetailsCommentAdapter.setRecyclerViewOnCLickListener(new WorkDetailsCommentAdapter.RecyclerViewOnCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        Intent intent = new Intent(getContext(), SerializaionCommentDetailsActivity.class);
                        intent.putExtra("CommentId", commentListBean.getData().getCommentDtoList().get(position).getCommentId());
                        startActivity(intent);
                    }
                });
                workDetailsCommentAdapter.setgoUserInfo(new WorkDetailsCommentAdapter.goUserInfo() {
                    @Override
                    public void go(String UserId) {
                        Intent intent = new Intent(getContext(), HomepageActivity.class);
                        intent.putExtra(SPKey.HIM_ID, UserId);
                        getActivity().startActivity(intent);
                    }
                });
            }
        }
    }


    @OnClick({R.id.Work_TextView, R.id.Work_atRelativelayout, R.id.Work_SendButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Work_TextView:
                Pull_upEdText();
                break;
            case R.id.Work_atRelativelayout:
                Pull_upEdText();
                break;
            case R.id.Work_SendButton:
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
    private void SendComment() {
        FormBody.Builder params = new FormBody.Builder();
        if (Integer.parseInt(Type) == 3) {
            this.Type = "3";
            params.add("id", (String) SPUtils.get(getContext(), SPKey.CATALOGID_ID, ""));
        } else {
            params.add("id", (String) SPUtils.get(getContext(), SPKey.PGC_ID, ""));
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
//                        workDetailsCommentAdapter = new WorkDetailsCommentAdapter(commentDtoList);
//                        WorkCommentRecy.setAdapter(workDetailsCommentAdapter);
                        workDetailsCommentAdapter.notifyDataSetChanged();
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

}
