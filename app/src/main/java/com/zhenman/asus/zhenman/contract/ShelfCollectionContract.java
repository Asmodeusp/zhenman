package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;

import java.util.ArrayList;

public interface ShelfCollectionContract {
    interface ShelfCollectionInView {
        //        展示书架收藏数据
        void showShelfCollection(ShelfCollectionBean shelfCollectionBean);

        //        展示错误数据
        void showError(String string);

        //        批量删除
        void showDeleteCollection(VerificationCodeBean verificationCodeBean);
    }

    interface ShelfCollectionInPresenter extends BasePresenter<ShelfCollectionInView> {
        //        展示书架收藏数据
        void sendShelfCollectionData(String pageNum, String pageSize);

        //批量删除收藏

        void sendDeleteCollection(ArrayList<String> lidList);
    }
}
