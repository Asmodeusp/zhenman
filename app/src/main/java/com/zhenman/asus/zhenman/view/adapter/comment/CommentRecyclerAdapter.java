package com.zhenman.asus.zhenman.view.adapter.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.model.bean.CommentDtoListBean;
import com.zhenman.asus.zhenman.model.bean.TextExtraBean;
import com.zhenman.asus.zhenman.utils.GlideUtils;
import com.zhenman.asus.zhenman.utils.MyClickSpan;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhy.autolayout.AutoLinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.Holder> implements View.OnClickListener, View.OnLongClickListener {
    private List<CommentDtoListBean> list;
    private Context context;
    private RecyclerViewOnCLickListener myCLick;
    private RecyclerViewOnLongCLickListener myLongCLick;
    private String UgcOrPgcId ;
    private String Type;
    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }
    public void setRecyclerViewOnCLickListener(RecyclerViewOnCLickListener myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public boolean onLongClick(View v) {
        if (myLongCLick != null) {
            myLongCLick.myLongCLick(v, (int) v.getTag());
        }
        return true;
    }

    public void setRecyclerViewOnLongCLickListener(RecyclerViewOnLongCLickListener myLongCLick) {
        if (myLongCLick != null) {
            this.myLongCLick = myLongCLick;
        }

    }

    public interface RecyclerViewOnCLickListener {
        void myClick(View view, int position);
    }

    public interface RecyclerViewOnLongCLickListener {
        void myLongCLick(View view, int position);
    }

    public CommentRecyclerAdapter(List<CommentDtoListBean> commentDtoList,String Type,String UgcOrPgcId ) {
        this.list = commentDtoList;
        this.Type =Type;
        this.UgcOrPgcId =UgcOrPgcId;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.comment_fill, parent, false);
        Holder holder = new Holder(inflate);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        final CommentDtoListBean listBean = list.get(position);
        holder.itemView.setTag(position);
        //加载头像
        GlideUtils.loadCircleImage(listBean.getImageUrl(), holder.comment_fill_HeadView, new GlideUtils.ImageLoadListener<String, GlideDrawable>() {
            @Override
            public void onLoadingComplete(String uri, ImageView view, GlideDrawable resource) {

            }

            @Override
            public void onLoadingError(String source, Exception e) {
                Toast.makeText(context, source, Toast.LENGTH_SHORT).show();
            }
        }, R.mipmap.common_portrait_m);
        //加载富文本
        holder.comment_fill_AddTime.setText(SPUtils.transferLongToDate(Long.parseLong(listBean.getAddTime())));
        if (listBean.getTextDto() != null) {
            MyClickSpan.setTextHighLightWithClick(holder.comment_fill_conent, listBean.getTextDto().getText(), listBean.getTextDto().getTextExtra(), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, HomepageActivity.class);
                    intent.putExtra(SPKey.HIM_ID, listBean.getTextDto().getTextExtra().get(0).getId());
                    context.startActivity(intent);
                }
            });
        }
        if (listBean.getCommentDtoList() != null && listBean.getCommentDtoList().size() != 0) {
            if (listBean.getCommentDtoList().size() == 1) {
                holder.comment_fill_SeeMoreText.setVisibility(View.GONE);
                holder.Comment_fill_SecondItem.setVisibility(View.GONE);
                final ArrayList<TextExtraBean> oneTextExtralist = new ArrayList<>();
                List<TextExtraBean> textExtra = listBean.getCommentDtoList().get(0).getTextDto().getTextExtra();
                for (TextExtraBean textExtraBean : textExtra) {
                    oneTextExtralist.add(textExtraBean);
                }
                MyClickSpan.setTextHighLightWithClick(holder.Comment_fill_FirstItem, listBean.getCommentDtoList().get(0).getTextDto().getText(), oneTextExtralist, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomepageActivity.class);
                        intent.putExtra(SPKey.HIM_ID, oneTextExtralist.get(0).getId());
                        context.startActivity(intent);
                    }
                });
            } else {
                holder.comment_fill_SeeMoreText.setVisibility(View.VISIBLE);
                holder.Comment_fill_SecondItem.setVisibility(View.VISIBLE);
            }
            if (listBean.getCommentDtoList().size() == 2) {
                final ArrayList<TextExtraBean> oneTextExtralist = new ArrayList<>();
                List<TextExtraBean> textExtra = listBean.getCommentDtoList().get(0).getTextDto().getTextExtra();
                for (TextExtraBean textExtraBean : textExtra) {
                    oneTextExtralist.add(textExtraBean);
                }
                MyClickSpan.setTextHighLightWithClick(holder.Comment_fill_FirstItem, listBean.getCommentDtoList().get(0).getTextDto().getText(), oneTextExtralist, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomepageActivity.class);
                        intent.putExtra(SPKey.HIM_ID, oneTextExtralist.get(0).getId());
                        context.startActivity(intent);
                    }
                });
                final ArrayList<TextExtraBean> TwoTextExtralist = new ArrayList<>();
                List<TextExtraBean> textExtra1 = listBean.getCommentDtoList().get(1).getTextDto().getTextExtra();
                for (TextExtraBean textExtraBean : textExtra1) {
                    TwoTextExtralist.add(textExtraBean);
                }
                MyClickSpan.setTextHighLightWithClick(holder.Comment_fill_SecondItem, listBean.getCommentDtoList().get(1).getTextDto().getText(), TwoTextExtralist, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, HomepageActivity.class);
                        intent.putExtra(SPKey.HIM_ID, TwoTextExtralist.get(1).getId());
                        context.startActivity(intent);
                    }
                });
            } else {
                holder.comment_fill_SeeMoreText.setVisibility(View.VISIBLE);
            }

        } else {
            holder.comment_Two_ItemLinearLayout.setVisibility(View.GONE);
        }
        //加载用户名
        holder.comment_fill_UserName.setText(listBean.getName());
        //加载喜欢个数
        holder.comment_fill_likeNumberText.setText(listBean.getLikeNum() + "");
        //加载添加时间
        holder.comment_fill_AddTime.setText(SPUtils.transferLongToDate(Long.parseLong(listBean.getAddTime())));
        //设置共多少评论
        holder.comment_fill_SeeMoreText.setText("查看更多评论");
        holder.comment_fill_fromUserText.setVisibility(View.GONE);
        //点赞喜欢点击
        if (listBean.isLike()){
            holder.comment_fill_likeImg.setButtonDrawable(R.mipmap.my_like_on);
        }else{
            holder.comment_fill_likeImg.setButtonDrawable(R.mipmap.my_like_off);
        }

        holder.comment_fill_likeImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Boolean ISlogin = (Boolean) SPUtils.get(context, SPKey.IS_LOGIN, false);
                if (!ISlogin) {
                    context.startActivity(new Intent(context, MainActivity.class));
                    ((Activity) context).finish();
                } else {
                    if (listBean.isLike()) {
                        if (holder.comment_fill_likeImg.isChecked()) {
                            holder.comment_fill_likeImg.setButtonDrawable(R.mipmap.my_like_off);
                            CommentLike("0",listBean.getCommentId());
                            holder.comment_fill_likeNumberText.setText(listBean.getLikeNum() - 1 + "");
                        } else {
                            holder.comment_fill_likeImg.setButtonDrawable(R.mipmap.my_like_on);
                            holder.comment_fill_likeNumberText.setText(listBean.getLikeNum() + "");
                        }

                    } else {
                        if (holder.comment_fill_likeImg.isChecked()) {
                            holder.comment_fill_likeImg.setButtonDrawable(R.mipmap.my_like_on);
                            CommentLike("1",listBean.getCommentId());
                            holder.comment_fill_likeNumberText.setText(listBean.getLikeNum() + 1 + "");
                        } else {
                            holder.comment_fill_likeImg.setButtonDrawable(R.mipmap.my_like_off);
                            holder.comment_fill_likeNumberText.setText(listBean.getLikeNum() + "");
                        }
                    }
                }

            }
        });
    }
    private void CommentLike(String status,String commentId) {
        FormBody.Builder params = new FormBody.Builder();
        if (Integer.parseInt(Type) == 3) {
            this.Type = "3";
        }
        params.add("status",status);
        params.add("commentType", Type);
        params.add("commentId", commentId);
        params.add("commentSubType", "1");
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Urls.BASE_URL + "likesUgcCommentInfo/insertCommentLikes")
                .post(params.build())
                .addHeader("accessToken", ((String) SPUtils.get(App.context, SPKey.USER_TOKEN, "")))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        //头像
        private ImageView comment_fill_HeadView;
        //姓名
        private TextView comment_fill_UserName;
        //主评论内容
        private TextView comment_fill_conent;
        //喜欢按钮
        private AutoLinearLayout comment_fill_likeButton;
        //喜欢图片
        private CheckBox comment_fill_likeImg;
        //喜欢个数
        private TextView comment_fill_likeNumberText;
        //第一条评论
        private TextView Comment_fill_FirstItem;
        //第二条评论
        private TextView Comment_fill_SecondItem;
        //查看更多评论
        private TextView comment_fill_SeeMoreText;
        //添加时间
        private TextView comment_fill_AddTime;
        //来自谁的动态
        private TextView comment_fill_fromUserText;
        //两个
        private AutoLinearLayout comment_Two_ItemLinearLayout;

        public Holder(View itemView) {
            super(itemView);
            comment_fill_HeadView = itemView.findViewById(R.id.comment_fill_HeadView);
            comment_fill_UserName = itemView.findViewById(R.id.comment_fill_UserName);
            comment_fill_conent = itemView.findViewById(R.id.comment_fill_conent);
            comment_fill_likeButton = itemView.findViewById(R.id.comment_fill_likeButton);
            comment_fill_likeImg = itemView.findViewById(R.id.comment_fill_likeImg);
            comment_fill_likeNumberText = itemView.findViewById(R.id.comment_fill_likeNumberText);
            Comment_fill_FirstItem = itemView.findViewById(R.id.Comment_fill_FirstItem);
            Comment_fill_SecondItem = itemView.findViewById(R.id.Comment_fill_SecondItem);
            comment_fill_SeeMoreText = itemView.findViewById(R.id.comment_fill_SeeMoreText);
            comment_fill_AddTime = itemView.findViewById(R.id.comment_fill_AddTime);
            comment_fill_fromUserText = itemView.findViewById(R.id.comment_fill_fromUserText);
            comment_Two_ItemLinearLayout = itemView.findViewById(R.id.comment_Two_ItemLinearLayout);
            itemView.setOnClickListener(CommentRecyclerAdapter.this);
            itemView.setOnLongClickListener(CommentRecyclerAdapter.this);
        }
    }
}
