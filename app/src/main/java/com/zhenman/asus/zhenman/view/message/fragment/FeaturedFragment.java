package com.zhenman.asus.zhenman.view.message.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.ThemeFeaturedSquareContract;
import com.zhenman.asus.zhenman.model.bean.ResultBean;
import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;
import com.zhenman.asus.zhenman.presenter.ThemeFeaturedSquarePresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.message.FeaturedAdapter;
import com.zhenman.asus.zhenman.view.myself.WorkDisplayActivity;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends BaseFragment<ThemeFeaturedSquarePresenter> implements ThemeFeaturedSquareContract.ThemeFeaturedSquareInView {


    private RecyclerView featuredRecy;
    private TextView featured_none;
    private String subjectId;

    public FeaturedFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_featured;
    }

    @Override
    protected void init() {
        featuredRecy = getActivity().findViewById(R.id.featuredRecy);
        featured_none = getActivity().findViewById(R.id.featured_none);
        subjectId = (String) SPUtils.get(getContext(), SPKey.SUBJECT_ID, "");
//      请求
        presenter.sendThemeFeaturedSquareData(subjectId, "1", "20", "1");

    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showThemeFeaturedSquareData(final ThemeFeaturedBean themeFeaturedBean) {
        if (themeFeaturedBean.getState() == 0) {

            ThemeFeaturedBean.DataBean data = themeFeaturedBean.getData();
            final List<ResultBean> resultBeanList = data.getResult();
            if (resultBeanList.size() == 0) {
                featured_none.setVisibility(View.VISIBLE);
                featuredRecy.setVisibility(View.GONE);
            } else {
                featured_none.setVisibility(View.GONE);
                featuredRecy.setVisibility(View.VISIBLE);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
                featuredRecy.setLayoutManager(gridLayoutManager);
                FeaturedAdapter featuredAdapter = new FeaturedAdapter(resultBeanList, getContext());
                featuredRecy.setAdapter(featuredAdapter);
//                跳转到首页
                featuredAdapter.setOnShortCLickListener(new FeaturedAdapter.OnShortCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        //新开一个界面，跳转到作品展示页面
                        Intent intent = new Intent(getContext(), WorkDisplayActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("workData", (Serializable) resultBeanList);
                        startActivity(intent);


                    }
                });
            }
        } else {
            Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {

    }
}
