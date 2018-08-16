package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WorkDetailsCommentService {
    //作品下的评论列表
    @GET(Urls.WORKS_COMMENT)
    Observable<WorkDetailsCommentBean> GetWorkDetailsCommentBean( @QueryMap Map<String,String> params);
}
