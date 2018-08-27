package com.zhenman.asus.zhenman.view.serializaion;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializationClassifyContract;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;
import com.zhenman.asus.zhenman.presenter.SerializationClassifyPresenterImp;

import java.util.ArrayList;

public class ClassifyActivity extends BaseActivity<SerializationClassifyPresenterImp> implements SerializationClassifyContract.SerializationClassifyView, View.OnClickListener {


    ArrayList<ClassifyTagBean.DataBean.BackgroundTagsBean> backgroundTagsBeans = new ArrayList<>();
    ArrayList<ClassifyTagBean.DataBean.StatusTagsBean> statusTagsBeans = new ArrayList<>();
    ArrayList<ClassifyTagBean.DataBean.SubjectTagsBean> subjectTagsBeans = new ArrayList<>();
    ArrayList<ClassifyTagBean.DataBean.TypeTagsBean> typeTagsBeans = new ArrayList<>();
    private ImageView Classify_returnImg;
    private RecyclerView Classify_backgroundTagsRecy;
    private RecyclerView Classify_StatusTagsRecy;
    private RecyclerView Classify_subjectTagsRecy;
    private RecyclerView Classify_TypeTagsRecy;
    private RecyclerView Classify_Product_Recy;
    private TextView Classify_backgroundTagsAll;
    private TextView Classify_StatusTagsAll;
    private TextView Classify_subjectTagsAll;
    private TextView Classify_TypeTagsAll;
    private String backgroundTag = null;
    private String statusTag = null;
    private String subjectTag = null;
    private String typeTag = null;
    private TextView lastView =null;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_classify;
    }

    @Override
    protected void init() {
        presenter.getClassifyTagBean();
        //返回
        Classify_returnImg = findViewById(R.id.Classify_returnImg);
        //背景标签Recy
        Classify_backgroundTagsRecy = findViewById(R.id.Classify_backgroundTagsRecy);
        //状态标签Recy
        Classify_StatusTagsRecy = findViewById(R.id.Classify_StatusTagsRecy);
        //主题标签Recy
        Classify_subjectTagsRecy = findViewById(R.id.Classify_subjectTagsRecy);
        //类型标签Recy
        Classify_TypeTagsRecy = findViewById(R.id.Classify_TypeTagsRecy);
        //作品Recy
        Classify_Product_Recy = findViewById(R.id.Classify_Product_Recy);
        //背景标签全部
        Classify_backgroundTagsAll = findViewById(R.id.Classify_backgroundTagsAll);
        //状态标签全部
        Classify_StatusTagsAll = findViewById(R.id.Classify_StatusTagsAll);
        //主题标签全部
        Classify_subjectTagsAll = findViewById(R.id.Classify_subjectTagsAll);
        //类型标签全部
        Classify_TypeTagsAll = findViewById(R.id.Classify_TypeTagsAll);
        //注册点击事件
        Classify_returnImg.setOnClickListener(this);
        Classify_backgroundTagsAll.setOnClickListener(this);
        Classify_StatusTagsAll.setOnClickListener(this);
        Classify_subjectTagsAll.setOnClickListener(this);
        Classify_TypeTagsAll.setOnClickListener(this);
        //设置Recy的格式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Classify_backgroundTagsRecy.setLayoutManager(linearLayoutManager);
        Classify_StatusTagsRecy.setLayoutManager(linearLayoutManager);
        Classify_subjectTagsRecy.setLayoutManager(linearLayoutManager);
        Classify_TypeTagsRecy.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        Classify_Product_Recy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showClassifyTagBean(ClassifyTagBean classifyTagBean) {
        if (classifyTagBean.getMsg().equals("成功")) {
            backgroundTagsBeans.addAll(classifyTagBean.getData().getBackgroundTags());
            statusTagsBeans.addAll(classifyTagBean.getData().getStatusTags());
            subjectTagsBeans.addAll(classifyTagBean.getData().getSubjectTags());
            typeTagsBeans.addAll(classifyTagBean.getData().getTypeTags());
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Classify_returnImg:
                finish();
                break;
            case R.id.Classify_backgroundTagsAll:
                backgroundTag =null;
                break;
            case R.id.Classify_StatusTagsAll:
                statusTag =null;
                break;
            case R.id.Classify_subjectTagsAll:
                subjectTag =null;
                break;
            case R.id.Classify_TypeTagsAll:
                typeTag=null;
                break;

        }
    }
}
