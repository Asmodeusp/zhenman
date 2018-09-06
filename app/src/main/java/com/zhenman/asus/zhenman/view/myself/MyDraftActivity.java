package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;

public class MyDraftActivity extends BaseActivity implements View.OnClickListener {

    private ImageView app_back;
    private TextView app_title;
    private RecyclerView myDraft_recy;
    private TextView app_otherID;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_draft;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        myDraft_recy = (RecyclerView) findViewById(R.id.myDraft_recy);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        app_title.setText("我的草稿");
        idListener();
    }

    private void idListener() {
        app_back.setOnClickListener(this);
        app_otherID.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.app_otherID:

                break;
        }

    }


}
