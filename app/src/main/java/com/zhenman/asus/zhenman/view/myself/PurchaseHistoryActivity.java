package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class PurchaseHistoryActivity extends BaseActivity<PurchaseHistoryPresenter> implements PurchaseHistoryContract.PurchaseHistoryInView{

    private ImageView app_back;
    private TextView app_title;
    private RecyclerView purchaseHistory_recy;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_purchase_history;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        purchaseHistory_recy = (RecyclerView) findViewById(R.id.purchaseHistory_recy);
        app_title.setText("历史纪录");

    }

    @Override
    protected void loadDate() {
        presenter.sendPurchaseHistory("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzQyNDU3OTMsInN1YiI6IntcInVzZXJJZFwiOjI5OSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNzA0NDgzOEQwQUFCRUREOURGRUY4RkM4QjE1RUQwQThcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NTc4MTc5M30.E7WGhefgoaQEXTsucV5ZtmmsyDeKeqiPXNuoraleQqo","1","20");

    }

    @Override
    public void showPurchaseHistory(PurchaseHistoryBean purchaseHistoryBean) {
        Log.e("Sunny",purchaseHistoryBean.getMsg()+purchaseHistoryBean.getData().getPageSize());
        if (purchaseHistoryBean.getMsg().equals(GetData.MSG_SUCCESS)){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            purchaseHistory_recy.setLayoutManager(linearLayoutManager);
            List<PurchaseHistoryBean.DataBean.ResultBean> result = purchaseHistoryBean.getData().getResult();
            PurchaseHistoryAdapter purchaseHistoryAdapter = new PurchaseHistoryAdapter(result, this);
            purchaseHistory_recy.setAdapter(purchaseHistoryAdapter);

        }
    }
}
