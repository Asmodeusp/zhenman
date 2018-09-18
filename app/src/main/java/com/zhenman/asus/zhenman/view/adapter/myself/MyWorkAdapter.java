package com.zhenman.asus.zhenman.view.adapter.myself;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyWorkAdapter extends FragmentPagerAdapter {
    private ArrayList<String> ComicTab_title;
    private ArrayList<Fragment> ComicViewPage_fragment;

    public MyWorkAdapter(FragmentManager fm, ArrayList<String> comicTab_title, ArrayList<Fragment> comicViewPage_fragment) {
        super(fm);
        ComicTab_title = comicTab_title;
        ComicViewPage_fragment = comicViewPage_fragment;
    }

    @Override
    public Fragment getItem(int i) {
        return ComicViewPage_fragment.get(i);
    }

    @Override
    public int getCount() {
        return ComicViewPage_fragment.isEmpty()?0:ComicViewPage_fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ComicTab_title.get(position);
    }
}
