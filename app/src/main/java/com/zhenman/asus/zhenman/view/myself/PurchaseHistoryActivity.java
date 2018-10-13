package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.PurchaseHistoryContract;
import com.zhenman.asus.zhenman.model.bean.PurchaseHistoryBean;
import com.zhenman.asus.zhenman.presenter.PurchaseHistoryPresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.view.adapter.myself.PurchaseHistoryAdapter;

import java.util.List;

public class PurchaseHistoryActivity extends BaseActivity<PurchaseHistoryPresenter> implements PurchaseHistoryContract.PurchaseHistoryInView {

    private ImageView app_back;
    private TextView app_title;
    private RecyclerView purchaseHistory_recy;
    private TextView purchaseHistory_none;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_purchase_history;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        purchaseHistory_recy = (RecyclerView) findViewById(R.id.purchaseHistory_recy);
        purchaseHistory_none = (TextView) findViewById(R.id.purchaseHistory_none);
        app_title.setText("历史纪录");

    }

    @Override
    protected void loadDate() {
        presenter.sendPurchaseHistory("1", "20");

    }

    @Override
    public void showPurchaseHistory(PurchaseHistoryBean purchaseHistoryBean) {
        Log.e("Sunny", purchaseHistoryBean.getMsg() + purchaseHistoryBean.getData().getPageSize());
        if (purchaseHistoryBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            if (purchaseHistoryBean.getData().getResult().size() == 0) {
                purchaseHistory_none.setVisibility(View.VISIBLE);
                purchaseHistory_recy.setVisibility(View.GONE);
            } else {
                purchaseHistory_none.setVisibility(View.GONE);
                purchaseHistory_recy.setVisibility(View.VISIBLE);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                purchaseHistory_recy.setLayoutManager(linearLayoutManager);
                List<PurchaseHistoryBean.DataBean.ResultBean> result = purchaseHistoryBean.getData().getResult();
                PurchaseHistoryAdapter purchaseHistoryAdapter = new PurchaseHistoryAdapter(result, this);
                purchaseHistory_recy.setAdapter(purchaseHistoryAdapter);
            }


        }
    }
}
