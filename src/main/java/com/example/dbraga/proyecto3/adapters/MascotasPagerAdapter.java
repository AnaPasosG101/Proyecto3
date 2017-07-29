package com.example.dbraga.proyecto3.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dbraga on 29/07/17.
 */

public class MascotasPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;

    public MascotasPagerAdapter(FragmentManager fm, List<Fragment>fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
