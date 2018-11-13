package com.zhenman.asus.zhenman.view.myself.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.adapter.myself.MyLikeAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageMyLikeFragment extends BaseFragment {


    @BindView(R.id.myLike_ComicTab)
    TabLayout myLikeComicTab;
    @BindView(R.id.myLike_ComicViewPage)
    ViewPager myLikeComicViewPage;
    private ArrayList<String> ComicTab_title;
    private ArrayList<Fragment> ComicViewPage_fragment;
    private MyLikeShortFragment workShortFragment = new MyLikeShortFragment();
    private MyLikeLongFragment workLongFragment = new MyLikeLongFragment();

    public HomePageMyLikeFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page_my_like;
    }

    @Override
    protected void init() {
        ComicTab_title = new ArrayList<>();
        ComicViewPage_fragment = new ArrayList<>();
        ComicTab_title.add("短漫画");
        ComicTab_title.add("长漫画");
        ComicViewPage_fragment.add(workShortFragment);
        ComicViewPage_fragment.add(workLongFragment);
        myLikeComicTab.setupWithViewPager(myLikeComicViewPage);
        MyLikeAdapter myLikeAdapter = new MyLikeAdapter(getActivity().getSupportFragmentManager(), ComicTab_title, ComicViewPage_fragment);
        myLikeComicViewPage.setAdapter(myLikeAdapter);

    }

    @Override
    protected void loadDate() {

    }


}
