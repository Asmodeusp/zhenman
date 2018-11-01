package com.zhenman.asus.zhenman.view.message;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.ByRewardedContract;
import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;
import com.zhenman.asus.zhenman.presenter.ByRewardedPresenter;
import com.zhenman.asus.zhenman.view.adapter.message.ByRewardedAdapter;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ByRewardedActivity extends BaseActivity<ByRewardedPresenter> implements ByRewardedContract.ByRewardedInView ,ByRewardedAdapter.ByRewardedCallback{

    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.byRewarded_list)
    RecyclerView byRewardedList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_by_rewarded;

    }

    @Override
    protected void init() {
        appTitle.setText("打赏");
        presenter.sendByRewardedData("1","20");
    }

    @Override
    protected void loadDate() {

    }



    @OnClick({R.id.app_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;
        }
    }

    @Override
    public void showByRewardedData(ByRewardedBean byRewardedBean) {
        Log.e("Sunny",byRewardedBean.getData().size()+"");
        if (byRewardedBean.getData().size()==0){
            Toast.makeText(this, "暂时没有数据", Toast.LENGTH_SHORT).show();
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            byRewardedList.setLayoutManager(linearLayoutManager);
            List<ByRewardedBean.DataBean> dataBeanList = byRewardedBean.getData();
            ByRewardedAdapter byRewardedAdapter = new ByRewardedAdapter(dataBeanList, this);
            byRewardedList.setAdapter(byRewardedAdapter);
            byRewardedAdapter.ByRewardedCallback(this);
            byRewardedAdapter.setOnShortCLickListener(new ByRewardedAdapter.OnShortCLickListener() {
                @Override
                public void myClick(View view, int position) {

                }
            });
        }
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showChapterList(int chapter) {
        Intent intent = new Intent(this, WorkDetailsActivity.class);
        intent.putExtra("pgcid", chapter);
        startActivity(intent);
    }
}
