package com.zhenman.asus.zhenman.view.message;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.ByLikeContract;
import com.zhenman.asus.zhenman.model.bean.ByLikeBean;
import com.zhenman.asus.zhenman.presenter.ByLikePresenter;
import com.zhenman.asus.zhenman.view.adapter.message.ByRewardedAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ByLikeActivity extends BaseActivity<ByLikePresenter> implements ByLikeContract.ByLikeInView, ByRewardedAdapter.ByRewardedCallback {


    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.byLike_recy)
    RecyclerView byLikeRecy;
    @BindView(R.id.byLike_none)
    TextView byLikeNone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_by_like;
    }

    @Override
    protected void init() {
        appTitle.setText("赞");
        presenter.sendByLikeData("1", "20");
    }

    @Override
    protected void loadDate() {

    }


    @OnClick(R.id.app_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showByLikeData(ByLikeBean byLikeBean) {
        if (byLikeBean.getData().size() == 0) {
            Toast.makeText(this, "暂时没有数据", Toast.LENGTH_SHORT).show();
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            byLikeRecy.setLayoutManager(linearLayoutManager);
            List<ByLikeBean.DataBean> dataBeanList = byLikeBean.getData();
            List<Object> list1 = new ArrayList<>();
            list1.addAll(dataBeanList);
            ByRewardedAdapter byRewardedAdapter = new ByRewardedAdapter(list1, this);
            byLikeRecy.setAdapter(byRewardedAdapter);
            byRewardedAdapter.ByRewardedCallback(this);
            byRewardedAdapter.setOnShortCLickListener(new ByRewardedAdapter.OnShortCLickListener() {
                @Override
                public void myClick(View view, int position) {

                }
            });
        }
    }

    @Override
    public void showChapterList(int chapter) {
        //得到章节ID跳转到评论列表
    }
}
