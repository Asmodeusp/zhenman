package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;

public interface ByRewardedContract {
    interface ByRewardedInView{
//        被打赏列表
        void showByRewardedData(ByRewardedBean byRewardedBean);
//        错误信息
        void showError(String string);
    }
    interface ByRewardedInPresenter extends BasePresenter<ByRewardedInView> {
        void sendByRewardedData(String accessToken,String pageNum,String pageSize);
    }
}
