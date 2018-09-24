package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class BookshelfAdapter extends FragmentPagerAdapter {
    private ArrayList<String> homePageTab_title;
    private ArrayList<Fragment> homePageTab_fragment;

    public BookshelfAdapter(FragmentManager fm, ArrayList<String> homePageTab_title, ArrayList<Fragment> homePageTab_fragment) {
        super(fm);
        this.homePageTab_title = homePageTab_title;
        this.homePageTab_fragment = homePageTab_fragment;
    }

    @Override
    public Fragment getItem(int i) {
        return homePageTab_fragment.get(i);
    }

    @Override
    public int getCount() {
        return homePageTab_fragment.isEmpty()?0:homePageTab_fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return homePageTab_title.get(position);
    }
}
