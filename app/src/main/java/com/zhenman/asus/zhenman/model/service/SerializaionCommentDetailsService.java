package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface SerializaionCommentDetailsService {

    //PGC评论点赞
    @FormUrlEncoded
    @POST(Urls.PGCFABULOUS)
    Observable<PgcFabulousBean> GetPgcFabulousBean( @FieldMap Map<String, String> params);
    //评论列表
    @GET(Urls.COMMENT_LIST)
    Observable<CommentItemListBean> getCommentListBean(@QueryMap Map<String, String> paramMap);
}
