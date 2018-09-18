package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;

public interface WorkShortComicContract {
    interface WorkShortComicInView{
        void showWorkShortComic(WorkShortComicBean workShortComicBean);
    }
    interface WorkShortComicInPresenter extends BasePresenter<WorkShortComicInView>{
        void sendWorkShortComic(String userId,String type,String pageNum,String pageSize);
    }
}
