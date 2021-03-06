package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface WorkDisplayService {
    //UGC点赞
    @FormUrlEncoded
    @POST(Urls.UGCFABULOUS)
    Observable<UgcFabulousBean> GetUgcFabulousBean(@FieldMap Map<String, String> params);

    //关注
    @FormUrlEncoded
    @POST(Urls.INSERT_USER_FOLLOW)
    Observable<FollowBean> GetFollowBean(@FieldMap Map<String, String> params);
    //得到评论列表
    @GET(Urls.COMMENT_LIST)
    Observable<CommentListBean> getCommentListBean(@QueryMap Map<String, String> paramMap);
}
