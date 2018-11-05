package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ShelfHistoryListBean;

public interface ShelfHistoryContract {
    interface ShelfHistoryInView{
//        展示错误信息
        void showError(String string);
//        展示书架历史数据
        void showShelfHistoryData(ShelfHistoryListBean shelfHistoryListBean);
    }
    interface ShelfHistoryInPresenter extends BasePresenter<ShelfHistoryInView>{
//        书架历史数据
        void sendShelfHistoryData(String pageNum,String pageSize);
    }
}
