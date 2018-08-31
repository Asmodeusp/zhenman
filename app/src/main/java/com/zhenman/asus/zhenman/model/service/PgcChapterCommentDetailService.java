package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentDetailBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface PgcChapterCommentDetailService {
    //Pgc作品下主评论下的列表
    @GET(Urls.PGC_CHAPTER_COMMENT_DETAIL)
    Observable<PgcChapterCommentDetailBean> getPgcChapterCommentDetailBean(@QueryMap Map<String, String> params);
    //PGC评论点赞
    @FormUrlEncoded
    @POST(Urls.PGCFABULOUS)
    Observable<PgcFabulousBean> GetPgcFabulousBean(@HeaderMap Map<String,String > Heards, @FieldMap Map<String, String> params);

}
