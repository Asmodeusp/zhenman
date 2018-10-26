package com.zhenman.asus.zhenman.view.serializaion;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SerializationDetailsContract;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.presenter.SerializationDetailsPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.login.MainActivity;
import com.zhenman.asus.zhenman.view.serializaion.fragment.WorkCatalogFragment;
import com.zhenman.asus.zhenman.view.serializaion.fragment.WorkDetailsFragment;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class WorkDetailsActivity extends BaseActivity<SerializationDetailsPresenterImp> implements View.OnClickListener, SerializationDetailsContract.SerializationDetailsView {

    public SerializationDetailsBean.DataBean serializationDetailsBeandata;
    public List<SerializationCatalogBean.DataBean> serializationCatalogBeandata = new ArrayList<>();
    public SerializationCatalogBean serializationCatalogBean;
    private AutoRelativeLayout Work_Detaails_ReturnImg;
    private ImageView Work_Detaails_CoverImg;
    private TextView Work_Detaails_Tag;
    private CheckBox Work_Detaails_collectionImg;
    private TextView Work_Detaails_LookUpBtn;
    private View Work_Detaails_detailsLine;
    private LinearLayout Work_Detaails_detailsBtn;
    private View Work_Detaails_CatalogLine;
    private LinearLayout Work_Detaails_CatalogBtn;
    private FrameLayout Work_Detaails_FrameLayout;
    private TextView Work_Detaails_Name;
    private TextView work_detaails_catalogText;
    private TextView work_detaails_detailsText;

    public void setPgcid(String pgcid) {
        this.pgcid = pgcid;
    }

    private String pgcid;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_details;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadDate() {
        String pgcid = (String) SPUtils.get(this, SPKey.PGC_ID, "");
        this.pgcid = pgcid;
        presenter.getSerializationDetailsBean(this.pgcid);
        presenter.getSerializationCatalogBean(this.pgcid);
    }

    private void initView() {
        //返回
        Work_Detaails_ReturnImg = findViewById(R.id.Work_Detaails_ReturnImg);
        //封面
        Work_Detaails_CoverImg = findViewById(R.id.Work_Detaails_CoverImg);
        //标签
        Work_Detaails_Tag = findViewById(R.id.Work_Detaails_Tag);
        //收藏
        Work_Detaails_collectionImg = findViewById(R.id.Work_Detaails_collectionImg);
        //观看第一话
        Work_Detaails_LookUpBtn = findViewById(R.id.Work_Detaails_LookUpText);
        //详情线
        Work_Detaails_detailsLine = findViewById(R.id.Work_Detaails_detailsLine);
        //详情按钮
        Work_Detaails_detailsBtn = findViewById(R.id.Work_Detaails_detailsBtn);
        //详情文字
        work_detaails_detailsText = findViewById(R.id.Work_Detaails_detailsText);
        //目录线
        Work_Detaails_CatalogLine = findViewById(R.id.Work_Detaails_CatalogLine);
        //目录按钮
        Work_Detaails_CatalogBtn = findViewById(R.id.Work_Detaails_CatalogBtn);
        //目录文字
        work_detaails_catalogText = findViewById(R.id.Work_Detaails_CatalogText);
        //帧布局
        Work_Detaails_FrameLayout = findViewById(R.id.Work_Detaails_FrameLayout);
        //作品名字
        Work_Detaails_Name = findViewById(R.id.Work_Detaails_Name);
        //点击事件
        Work_Detaails_ReturnImg.setOnClickListener(this);
        Work_Detaails_detailsBtn.setOnClickListener(this);
        Work_Detaails_CatalogBtn.setOnClickListener(this);
        Work_Detaails_LookUpBtn.setOnClickListener(this);
        //收藏
        Work_Detaails_collectionImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Work_Detaails_ReturnImg:
                finish();
                break;
            //详情
            case R.id.Work_Detaails_detailsBtn:
                setDetaailsText();
                Work_Detaails_detailsLine.setVisibility(View.VISIBLE);
                Work_Detaails_CatalogLine.setVisibility(View.INVISIBLE);
                setContentView(R.id.Work_Detaails_FrameLayout, WorkDetailsFragment.class);
                break;
            //目录
            case R.id.Work_Detaails_CatalogBtn:
                setCatalogText();
                Work_Detaails_detailsLine.setVisibility(View.INVISIBLE);
                Work_Detaails_CatalogLine.setVisibility(View.VISIBLE);
                setContentView(R.id.Work_Detaails_FrameLayout, WorkCatalogFragment.class);
                break;
            //收藏
            case R.id.Work_Detaails_collectionImg:
                if (serializationDetailsBeandata!=null) {
                    Boolean ISlogin = (Boolean) SPUtils.get(this, SPKey.IS_LOGIN, false);
                    if (!ISlogin) {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    }
                    if (Work_Detaails_collectionImg.isChecked()) {
                        if (serializationDetailsBeandata.isCollect()) {
                            Work_Detaails_collectionImg.setButtonDrawable(R.mipmap.common_collection_off);
                            presenter.PgcCollection(pgcid, "0");
                        } else {
                            Work_Detaails_collectionImg.setButtonDrawable(R.mipmap.common_collection_on);
                            presenter.PgcCollection(pgcid, "1");
                        }
                    } else {
                        if (serializationDetailsBeandata.isCollect()) {
                            Work_Detaails_collectionImg.setButtonDrawable(R.mipmap.common_collection_on);
                            presenter.PgcCollection(pgcid, "1");
                        } else {
                            Work_Detaails_collectionImg.setButtonDrawable(R.mipmap.common_collection_off);
                            presenter.PgcCollection(pgcid, "0");
                        }
                    }
                }
                break;
            //观看第一话
            case R.id.Work_Detaails_LookUpText:
                Intent intent = new Intent(this, SerializationCatalogReadActivity.class);
                if (serializationCatalogBeandata == null && serializationCatalogBeandata.size() == 0) {
                    Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
                } else {
                    if (serializationCatalogBeandata.size() != 0) {
                        SPUtils.put(WorkDetailsActivity.this, SPKey.CATALOGID_ID,SPUtils.get(this,"FirstCatalogId",""));
                        SPUtils.put(WorkDetailsActivity.this, SPKey.PGC_ID, serializationCatalogBeandata.get(0).getPgcId());
                        startActivity(intent);
                    }
                }
                break;
        }
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean) {
        if (serializationDetailsBean == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            Glide.with(this).load(serializationDetailsBean.getData().getImageUrl()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(Work_Detaails_CoverImg);
            Work_Detaails_Name.setText(serializationDetailsBean.getData().getTitle());
            SPUtils.put(this, "DetailsName", serializationDetailsBean.getData().getTitle());
            Work_Detaails_Tag.setText(serializationDetailsBean.getData().getTag());
            serializationDetailsBeandata = serializationDetailsBean.getData();
            setContentView(R.id.Work_Detaails_FrameLayout, WorkDetailsFragment.class);
        }
        if (serializationDetailsBeandata.isCollect()) {
            Work_Detaails_collectionImg.setButtonDrawable(R.mipmap.common_collection_on);
        } else {
            Work_Detaails_collectionImg.setButtonDrawable(R.mipmap.common_collection_off);
        }
    }

    @Override
    public void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean) {
        if (serializationCatalogBean == null) {
            Toast.makeText(this, "无网络或网速过慢", Toast.LENGTH_SHORT).show();
        } else {
            this.serializationCatalogBean = serializationCatalogBean;
            serializationCatalogBeandata.addAll(serializationCatalogBean.getData());
            String catalogId = serializationCatalogBeandata.get(serializationCatalogBeandata.size()-1).getCatalogId();
            SPUtils.put(this,"FirstCatalogId",catalogId);
        }
    }
    @Override
    public void showPgcCollectionBean(PgcCollectionBean pgcCollectionBean) {
    }
    private void setCatalogText() {
        work_detaails_catalogText.setTextColor(Color.parseColor("#b37feb"));
        work_detaails_detailsText.setTextColor(Color.parseColor("#333333"));
    }
    private void setDetaailsText() {
        work_detaails_catalogText.setTextColor(Color.parseColor("#333333"));
        work_detaails_detailsText.setTextColor(Color.parseColor("#b37feb"));
    }
}
