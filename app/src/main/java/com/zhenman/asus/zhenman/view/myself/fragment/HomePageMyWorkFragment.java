package com.zhenman.asus.zhenman.view.myself.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.adapter.myself.MyWorkAdapter;

import java.util.ArrayList;


public class HomePageMyWorkFragment extends BaseFragment {

    private TabLayout myWork_ComicTab;
    private ViewPager myWork_ComicViewPage;
    private ArrayList<String> ComicTab_title;
    private ArrayList<Fragment> ComicViewPage_fragment;
    private WorkShortFragment workShortFragment;
    private WorkLongFragment workLongFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page_my_work;
    }

    @Override
    protected void init() {
        workShortFragment = new WorkShortFragment();
        workLongFragment = new WorkLongFragment();
        myWork_ComicTab = getActivity().findViewById(R.id.myWork_ComicTab);
        myWork_ComicViewPage = getActivity().findViewById(R.id.myWork_ComicViewPage);
        ComicTab_title=new ArrayList<>();
        ComicViewPage_fragment=new ArrayList<>();
        ComicTab_title.add("短漫画");
        ComicTab_title.add("长漫画");
        ComicViewPage_fragment.add(workShortFragment);
        ComicViewPage_fragment.add(workLongFragment);
        myWork_ComicTab.setupWithViewPager(myWork_ComicViewPage);
        MyWorkAdapter myWorkAdapter = new MyWorkAdapter(getActivity().getSupportFragmentManager(), ComicTab_title, ComicViewPage_fragment);
        myWork_ComicViewPage.setAdapter(myWorkAdapter);
    }

    @Override
    protected void loadDate() {

    }
}
