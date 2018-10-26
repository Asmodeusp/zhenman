package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;

public interface CommentAtContract {
    interface CommentAtView{
        //用户的关注
        void showMyAttentionUserData(MyAttentionUserBean attentionUserBean);
        //展示错误信息
        void showError(String string);
        //PGC详情
        void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean);

    }
    interface CommentAtPresenter extends BasePresenter<CommentAtContract.CommentAtView> {
        //用户的关注
        void sendMyAttentionUserData(String pageNum,String pageSize,String userId);
        //PGC详情
        void getSerializationDetailsBean(String PgcId);

    }
}
