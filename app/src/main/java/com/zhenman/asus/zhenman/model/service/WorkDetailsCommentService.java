package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface WorkDetailsCommentService {
    //作品下的评论列表
    @GET(Urls.WORKS_COMMENT)
    Observable<WorkDetailsCommentBean> GetWorkDetailsCommentBean(@HeaderMap Map<String, String> headers, @QueryMap Map<String,String> params);
    //PGC评论点赞
    @FormUrlEncoded
    @POST(Urls.PGCFABULOUS)
    Observable<PgcFabulousBean> GetPgcFabulousBean(@HeaderMap Map<String,String > Heards, @FieldMap Map<String, String> params);
}
