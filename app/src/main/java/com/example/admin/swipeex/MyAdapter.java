package com.example.admin.swipeex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Admin on 11/29/2017.
 */

public class MyAdapter extends FragmentStatePagerAdapter {
    int tabcount;
    private String[] tabTitles = new String[]{"Tab1", "Tab2"};

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;

            case 1:
                return new Tab2();

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

}

