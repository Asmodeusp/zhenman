package com.zhenman.asus.zhenman.view.adapter.message;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MessageAdapter extends FragmentPagerAdapter {
    private List<String> title_List;
    private List<Fragment> frag_List;

    public MessageAdapter(FragmentManager fm, List<String> title_List, List<Fragment> frag_List) {
        super(fm);
        this.title_List = title_List;
        this.frag_List = frag_List;
    }

    @Override
    public Fragment getItem(int i) {
        return frag_List.get(i);
    }

    @Override
    public int getCount() {
        return frag_List.isEmpty() ? 0 : frag_List.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title_List.get(position);
    }
}
