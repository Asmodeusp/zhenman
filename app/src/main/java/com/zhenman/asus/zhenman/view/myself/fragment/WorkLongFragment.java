package com.zhenman.asus.zhenman.view.myself.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.WorkShortPgcComicContract;
import com.zhenman.asus.zhenman.model.bean.WorkShortPgcComicBean;
import com.zhenman.asus.zhenman.presenter.WorkShortPgcComicPresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.myself.WorkLongPgcAdapter;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhenman.asus.zhenman.view.serializaion.WorkDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkLongFragment extends BaseFragment<WorkShortPgcComicPresenter> implements WorkShortPgcComicContract.WorkShortPgcComicInView {


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
        if (HomepageActivity.him_id.equals("myself")) {
            presenter.sendWorkShortPgcComic((String) SPUtils.get(getContext(), SPKey.USER_ID, ""), "1", "1", "20");
        } else {
            presenter.sendWorkShortPgcComic(HomepageActivity.him_id, "1", "1", "20");
        }
    }

    @Override
    protected void loadDate() {

    }


//    长漫画
    @Override
    public void showWorkPgcComic(WorkShortPgcComicBean workShortPgcComicBean) {
        Log.e("Sunny",workShortPgcComicBean.getData().getResult().size()+"");
        if (workShortPgcComicBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            if (workShortPgcComicBean.getData().getResult().size() == 0) {
                workLongNoData.setVisibility(View.VISIBLE);
                workLongRecy.setVisibility(View.GONE);
            } else {
                Toast.makeText(getContext(), workShortPgcComicBean.getData().getResult().size()+"", Toast.LENGTH_SHORT).show();
                workLongRecy.setVisibility(View.VISIBLE);
                workLongNoData.setVisibility(View.GONE);
//                WorkShortComicBean.DataBean data = workShortPgcComicBean.getData();
                WorkShortPgcComicBean.DataBean data = workShortPgcComicBean.getData();
                final List<WorkShortPgcComicBean.DataBean.ResultBean> result = data.getResult();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                workLongRecy.setLayoutManager(gridLayoutManager);
                List<Object> objects = new ArrayList<>();
                objects.addAll(result);
                WorkLongPgcAdapter workShortAdapter = new WorkLongPgcAdapter(result, getContext());
                workLongRecy.setAdapter(workShortAdapter);
                Toast.makeText(getContext(), result.size() + "", Toast.LENGTH_SHORT).show();
                workShortAdapter.setOnShortCLickListener(new WorkLongPgcAdapter.OnShortCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        String pgcId = result.get(position).getPgcId();
                        Intent intent = new Intent(getActivity(), WorkDetailsActivity.class);
                        SPUtils.put(getContext(), SPKey.PGC_ID,pgcId+"");
                        getActivity().startActivity(intent);
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
