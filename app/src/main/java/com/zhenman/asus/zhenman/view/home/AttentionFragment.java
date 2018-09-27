package com.zhenman.asus.zhenman.view.home;




import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.contract.HomeAttentionContract;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.HomeAttentionPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import butterknife.BindView;

public class AttentionFragment extends BaseFragment<HomeAttentionPresenterImp> implements HomeAttentionContract.HomeAttentionView {
    @BindView(R.id.Home_Attention_Recy)
    RecyclerView HomeAttentionRecy;

    public AttentionFragment() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void init() {
        //设置RecyclerView的格式
        HomeAttentionRecy.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void loadDate() {
        presenter.getHomeAttentionBean("20");
    }


    @Override
    public void showError(String msg) {
        boolean isLogin = (boolean) SPUtils.get(getActivity(), SPKey.IS_LOGIN, true);
        if (isLogin) {

        }
    }

    @Override
    public void showHomeAttentionBean(HomeAttentionBean homeAttentionBean) {
        HomeAttentionRecy.setAdapter();

    }

    @Override
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }
}
