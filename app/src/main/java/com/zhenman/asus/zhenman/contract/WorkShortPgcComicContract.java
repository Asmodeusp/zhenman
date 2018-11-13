package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.WorkShortPgcComicBean;

public interface WorkShortPgcComicContract {
    interface WorkShortPgcComicInView{
        //        我的作品   长漫画
        void showWorkPgcComic(WorkShortPgcComicBean workShortPgcComicBean);
        //        错误信息显示
        void showError(String string);
    }interface WorkShortPgcComicInPresenter extends BasePresenter<WorkShortPgcComicInView>{

        //        长漫画
        void sendWorkShortPgcComic(String userId,String type,String pageNum,String pageSize);
    }

}
