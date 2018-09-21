package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;

public interface ShelfCollectionContract {
    interface ShelfCollectionInView {
        //        展示书架收藏数据
        void showShelfCollection(ShelfCollectionBean shelfCollectionBean);

        //        展示错误数据
        void showError(String string);
    }

    interface ShelfCollectionInPresenter extends BasePresenter<ShelfCollectionInView> {
        //        展示书架收藏数据
        void sendShelfCollectionData(String pageNum, String pageSize);
    }
}
