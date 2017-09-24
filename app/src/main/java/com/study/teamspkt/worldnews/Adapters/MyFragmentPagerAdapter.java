package com.study.teamspkt.worldnews.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Pon Long Bong on 3/24/2017.
 */
//Apdater tạo pager cho view pager
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList=fragmentList;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentList.size();
    }
}
