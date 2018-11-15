package com.zhenman.asus.zhenman.view.myself.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkShortComicContract;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;
import com.zhenman.asus.zhenman.presenter.WorkShortComicPresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.myself.WorkShortAdapter;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.myself.WorkDisplayActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyLikeShortFragment extends BaseFragment<WorkShortComicPresenter> implements WorkShortComicContract.WorkShortComicInView {


    @BindView(R.id.likeShort_recy)
    RecyclerView likeShortRecy;
    @BindView(R.id.likeShort_noData)
    TextView likeShortNoData;
    Unbinder unbinder;

    public MyLikeShortFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_like_short;
    }

    @Override
    protected void init() {
        if (HomepageActivity.him_id.equals("myself")) {
            presenter.sendWorkShortComic((String) SPUtils.get(getContext(), SPKey.USER_ID, ""), "2", "1", "20");
        } else {
            presenter.sendWorkShortComic(HomepageActivity.him_id, "2", "1", "20");
        }
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showWorkShortComic(final WorkShortComicBean workShortComicBean) {
        if (workShortComicBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            if (workShortComicBean.getData().getResult().size() == 0) {
                likeShortNoData.setVisibility(View.VISIBLE);
                likeShortRecy.setVisibility(View.GONE);
            } else {
                likeShortNoData.setVisibility(View.VISIBLE);
                likeShortNoData.setVisibility(View.GONE);
                WorkShortComicBean.DataBean data = workShortComicBean.getData();
                List<WorkShortComicBean.DataBean.ResultBean> result = data.getResult();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                likeShortRecy.setLayoutManager(gridLayoutManager);
                List<Object> objects = new ArrayList<>();
                objects.addAll(result);
                WorkShortAdapter workShortAdapter = new WorkShortAdapter(objects, getContext());
                likeShortRecy.setAdapter(workShortAdapter);
                Toast.makeText(getContext(), result.size() + "", Toast.LENGTH_SHORT).show();
                workShortAdapter.setOnShortCLickListener(new WorkShortAdapter.OnShortCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        Intent intent = new Intent(getContext(), WorkDisplayActivity.class);
                        if (workShortComicBean.getData().getResult() != null) {
                            List<WorkShortComicBean.DataBean.ResultBean> resultBeanArrayList = workShortComicBean.getData().getResult();
                            intent.putExtra("workData", (Serializable) resultBeanArrayList);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "加载数据失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } else {
            Toast.makeText(getContext(), "加载数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show();

    }
}
