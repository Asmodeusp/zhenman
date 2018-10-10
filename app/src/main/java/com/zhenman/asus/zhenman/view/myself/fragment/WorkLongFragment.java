package com.zhenman.asus.zhenman.view.myself.fragment;


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

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkLongFragment extends BaseFragment<WorkShortComicPresenter> implements WorkShortComicContract.WorkShortComicInView {


    @BindView(R.id.workLong_recy)
    RecyclerView workLongRecy;
    @BindView(R.id.workLong_noData)
    TextView workLongNoData;

    public WorkLongFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_long;
    }

    @Override
    protected void init() {
        String himmeId = (String) SPUtils.get(getContext(), SPKey.HIM_ID, "");
        if (himmeId.isEmpty()) {
            presenter.sendWorkShortComic((String) SPUtils.get(getContext(), SPKey.USER_ID, ""), (String) SPUtils.get(getContext(), SPKey.LOGIN_TYPE, ""), "1", "20");
        } else {
            presenter.sendWorkShortComic(himmeId, (String) SPUtils.get(getContext(), SPKey.LOGIN_TYPE, ""), "1", "20");

        }
    }

    @Override
    protected void loadDate() {

    }
    @Override
    public void showWorkShortComic(WorkShortComicBean workShortComicBean) {
        if (workShortComicBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            if (workShortComicBean.getData().getResult().size() == 0) {
                workLongNoData.setVisibility(View.VISIBLE);
                workLongRecy.setVisibility(View.GONE);
            } else {
                workLongRecy.setVisibility(View.VISIBLE);
                workLongNoData.setVisibility(View.GONE);
                WorkShortComicBean.DataBean data = workShortComicBean.getData();
                List<WorkShortComicBean.DataBean.ResultBean> result = data.getResult();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                workLongRecy.setLayoutManager(gridLayoutManager);
                WorkShortAdapter workShortAdapter = new WorkShortAdapter(result, getContext());
                workLongRecy.setAdapter(workShortAdapter);
                Toast.makeText(getContext(), result.size() + "", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getContext(), "加载数据失败", Toast.LENGTH_SHORT).show();
        }
    }
}
