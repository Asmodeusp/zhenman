package com.zhenman.asus.zhenman.view.serializaion;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.view.adapter.serialization.BookshelfAdapter;
import com.zhenman.asus.zhenman.view.serializaion.fragment.ShelfCollectionFragment;
import com.zhenman.asus.zhenman.view.serializaion.fragment.ShelfHistoryFragment;

import java.util.ArrayList;

public class BookshelfActivity extends BaseActivity implements View.OnClickListener {

    private ImageView app_back;
    private TextView app_title;
    private TabLayout bookshelf_tab;
    private ViewPager bookshelf_page;
    private ArrayList<String> title_List;
    private ArrayList<Fragment> frag_List;
    private ShelfCollectionFragment shelfCollectionFragment;
    private ShelfHistoryFragment shelfHistoryFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bookshelf;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        bookshelf_tab = (TabLayout) findViewById(R.id.bookshelf_tab);
        bookshelf_page = (ViewPager) findViewById(R.id.bookshelf_page);
        title_List = new ArrayList<>();
        frag_List = new ArrayList<>();
        idListener();
        app_title.setText("书架");
        title_List.add("收藏");
        title_List.add("历史");
        shelfCollectionFragment = new ShelfCollectionFragment();
        shelfHistoryFragment = new ShelfHistoryFragment();
        frag_List.add(shelfCollectionFragment);
        frag_List.add(shelfHistoryFragment);
        initData();

    }

    private void initData() {
        bookshelf_tab.setupWithViewPager(bookshelf_page);
        BookshelfAdapter bookshelfAdapter = new BookshelfAdapter(getSupportFragmentManager(), title_List, frag_List);
        bookshelf_page.setAdapter(bookshelfAdapter);
    }

    private void idListener() {
        app_back.setOnClickListener(this);
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
        }
    }
}
