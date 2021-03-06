package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;

public interface WorkShortComicContract {
    interface WorkShortComicInView{
//        展示我的作品    段漫画
        void showWorkShortComic(WorkShortComicBean workShortComicBean);
//        错误信息显示
        void showError(String string);
    }
    interface WorkShortComicInPresenter extends BasePresenter<WorkShortComicInView>{
//        短漫画
        void sendWorkShortComic(String userId,String type,String pageNum,String pageSize);

    }
}
