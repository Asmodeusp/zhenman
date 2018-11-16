package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.WorkDisplayContract;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.ResultBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.presenter.WorkDisplayPresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.view.adapter.myself.WorkDisplayAdapter;
import com.zhenman.asus.zhenman.view.comment.FullFragment;
import com.zhenman.asus.zhenman.view.ui.MyRecyclerView;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.OnViewPagerListener;
import com.zhenman.asus.zhenman.view.ui.layoutmessage.ViewPagerLayoutManager;

import java.util.List;

import butterknife.BindView;

public class WorkDisplayActivity extends BaseActivity<WorkDisplayPresenter> implements WorkDisplayContract.workDisplayInView, WorkDisplayAdapter.BouncingComment {
    @BindView(R.id.WorkDisplay_List)
    MyRecyclerView WorkDisplayList;
    private ViewPagerLayoutManager linearLayoutManager;
    private String ugcId;

    private List<ResultBean> workDataList;
    private int position;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_display;
    }

    @Override
    protected void init() {
        linearLayoutManager = new ViewPagerLayoutManager(this, LinearLayoutManager.VERTICAL) {

        };

        linearLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext, int position) {

            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {

            }
        });
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        WorkDisplayList.setLayoutManager(linearLayoutManager);
        //       得到数据集合
        Intent intent = getIntent();

        workDataList = (List<ResultBean>) intent.getSerializableExtra("workData");
        List<ResultBean> squareData = (List<ResultBean>) intent.getSerializableExtra("squareData");


        position = intent.getIntExtra("position",0);
        initData();
    }

    private void initData() {
        if (workDataList.size() != 0) {
            WorkDisplayAdapter workDisplayAdapter = new WorkDisplayAdapter(workDataList, this, WorkDisplayList, presenter);
            WorkDisplayList.setAdapter(workDisplayAdapter);
            WorkDisplayList.scrollToPosition(position);
            workDisplayAdapter.setgoUserInfo(new WorkDisplayAdapter.goUserInfo() {
                @Override
                public void go(String UserId) {
                    Intent intent = new Intent(WorkDisplayActivity.this, HomepageActivity.class);
                    intent.putExtra(SPKey.HIM_ID, UserId);
                    startActivity(intent);
                }
            });
            workDisplayAdapter.setBouncingComment(WorkDisplayActivity.this);
        }
    }

    @Override
    protected void loadDate() {

    }

    //PGC 点赞
    @Override
    public void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean) {

    }

    //    关注
    @Override
    public void showFollowBean(FollowBean followBean) {

    }

    //    得到评论列表
    @Override
    public void showCommentList(CommentListBean commentListBean) {
        FullFragment fullFragment = new FullFragment(commentListBean, Type + "", ugcId);
        fullFragment.show(this.getSupportFragmentManager(), "dialog");
    }

    //    展示错误数据
    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    int Type;

    @Override
    public void getComment(String UgcId, int Type) {
        this.Type = Type;
        this.ugcId = UgcId;
        presenter.getCommentList(ugcId + "", "1", "20", Type + "", "1");
    }
}
