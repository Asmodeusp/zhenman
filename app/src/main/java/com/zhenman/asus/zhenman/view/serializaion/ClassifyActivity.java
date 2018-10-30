package com.zhenman.asus.zhenman.view.serializaion;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializationClassifyContract;
import com.zhenman.asus.zhenman.model.bean.ClassifyBean;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;
import com.zhenman.asus.zhenman.presenter.SerializationClassifyPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.ClassifyBackgroundTagsRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ClassifyProductRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ClassifyStatusTagsRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ClassifySubjectTagsRecyAdapter;
import com.zhenman.asus.zhenman.view.adapter.serialization.ClassifyTypeTagsRecyAdapter;

import java.util.ArrayList;
import java.util.List;

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
    private CheckBox Classify_backgroundTagsAll;
    private CheckBox Classify_StatusTagsAll;
    private CheckBox Classify_subjectTagsAll;
    private CheckBox Classify_TypeTagsAll;
    private String backgroundTag = "";
    private String statusTag = "";
    private String subjectTag = "";
    private String typeTag = "";
    private CheckBox lastView =null;
    private List<ClassifyBean.DataBean.ResultBean> result =new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_classify;
    }

    @Override
    protected void init() {
        presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
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
        LinearLayoutManager backgroundlinearLayoutManager = new LinearLayoutManager(this);
        backgroundlinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Classify_backgroundTagsRecy.setLayoutManager(backgroundlinearLayoutManager);
        LinearLayoutManager StatuslinearLayoutManager = new LinearLayoutManager(this);
        StatuslinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Classify_StatusTagsRecy.setLayoutManager(StatuslinearLayoutManager);
        LinearLayoutManager subjectlinearLayoutManager = new LinearLayoutManager(this);
        subjectlinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Classify_subjectTagsRecy.setLayoutManager(subjectlinearLayoutManager);
        LinearLayoutManager TypelinearLayoutManager = new LinearLayoutManager(this);
        TypelinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Classify_TypeTagsRecy.setLayoutManager(TypelinearLayoutManager);
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
            initAdapter();

        }

    }

    @Override
    public void showClassifyBean(ClassifyBean classifyBean) {
        if (classifyBean.getMsg().equals("成功")) {
            result .addAll( classifyBean.getData().getResult());
            ClassifyProductRecyAdapter classifyProductRecyAdapter = new ClassifyProductRecyAdapter(result);
            Classify_Product_Recy.setAdapter(classifyProductRecyAdapter);
            classifyProductRecyAdapter.notifyDataSetChanged();
            classifyProductRecyAdapter.setRecyclerViewOnCLickListener(new ClassifyProductRecyAdapter.RecyclerViewOnCLickListener() {
                @Override
                public void myClick(View view, int position) {
                    Intent intent = new Intent(ClassifyActivity.this,SerializationCatalogReadActivity.class);
                    SPUtils.put(ClassifyActivity.this,SPKey.CATALOGID_ID,result.get(position).getCatalogId());
                    SPUtils.put(ClassifyActivity.this,SPKey.PGC_ID, result.get(position).getPgcId());
                    startActivity(intent);

                }
            });
        }

    }

    private void initAdapter() {
        //设置适配器
        ClassifyBackgroundTagsRecyAdapter classifyBackgroundTagsRecyAdapter = new ClassifyBackgroundTagsRecyAdapter(backgroundTagsBeans,Classify_backgroundTagsAll);
        Classify_backgroundTagsRecy.setAdapter(classifyBackgroundTagsRecyAdapter);
        classifyBackgroundTagsRecyAdapter.setRecyclerViewOnCLickListener(new ClassifyBackgroundTagsRecyAdapter.RecyclerViewOnCLickListener() {

            private CheckBox fill_classifyTags_recy;

            @Override
            public void myClick(View view, int position) {
                fill_classifyTags_recy = view.findViewById(R.id.fill_classifyTags_Recy);
                lastView =fill_classifyTags_recy;
                if(fill_classifyTags_recy==lastView){
                    fill_classifyTags_recy.setTextColor(Color.parseColor("#333333"));
                }
                if(fill_classifyTags_recy!=lastView){
                    fill_classifyTags_recy.setTextColor(Color.parseColor("#666666"));
                }
                backgroundTag = backgroundTagsBeans.get(position).getTagName();
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
            }
        });
        ClassifyStatusTagsRecyAdapter classifyStatusTagsRecyAdapter = new ClassifyStatusTagsRecyAdapter(statusTagsBeans,Classify_StatusTagsAll);
        Classify_StatusTagsRecy.setAdapter(classifyStatusTagsRecyAdapter);
        classifyStatusTagsRecyAdapter.setRecyclerViewOnCLickListener(new ClassifyStatusTagsRecyAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                statusTag = statusTagsBeans.get(position).getTagName();
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
            }
        });
        ClassifySubjectTagsRecyAdapter classifySubjectTagsRecyAdapter = new ClassifySubjectTagsRecyAdapter(subjectTagsBeans,Classify_subjectTagsAll);
        Classify_subjectTagsRecy.setAdapter(classifySubjectTagsRecyAdapter);
        classifySubjectTagsRecyAdapter.setRecyclerViewOnCLickListener(new ClassifySubjectTagsRecyAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                subjectTag = subjectTagsBeans.get(position).getTagName();
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
            }
        });
        ClassifyTypeTagsRecyAdapter classifyTypeTagsRecyAdapter = new ClassifyTypeTagsRecyAdapter(typeTagsBeans,Classify_TypeTagsAll);
        Classify_TypeTagsRecy.setAdapter(classifyTypeTagsRecyAdapter);
        classifyTypeTagsRecyAdapter.setRecyclerViewOnCLickListener(new ClassifyTypeTagsRecyAdapter.RecyclerViewOnCLickListener() {
            @Override
            public void myClick(View view, int position) {
                typeTag =typeTagsBeans.get(position).getTagName();
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Classify_returnImg:
                finish();
                break;
            case R.id.Classify_backgroundTagsAll:
                backgroundTag ="";
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
                Classify_backgroundTagsAll.setTextColor(Color.parseColor("#333333"));
                lastView.setTextColor(Color.parseColor("#666666"));
                break;
            case R.id.Classify_StatusTagsAll:
                statusTag ="";
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
                break;
            case R.id.Classify_subjectTagsAll:
                subjectTag ="";
                presenter.getClassifyBean("1","20",statusTag,subjectTag,backgroundTag,typeTag);
                break;
            case R.id.Classify_TypeTagsAll: 
                typeTag="";
                presenter.getClassifyBean("1", "20",statusTag,subjectTag,backgroundTag,typeTag);
                break;

        }
    }
}
