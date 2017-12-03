package com.example.admin.swipeex.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.swipeex.fragments.Tab1;
import com.example.admin.swipeex.fragments.Tab2;

/**
 * Created by Admin on 11/29/2017.
 */

public class MyAdapter extends FragmentStatePagerAdapter {

    Tab1 tab1;
    private String mSearchTerm;
    private String[] tabTitles = new String[]{"Tab1", "Tab2"};

    public MyAdapter(FragmentManager fm, String searchTerm) {
        super(fm);
        this.mSearchTerm = searchTerm;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                tab1 = new Tab1();
                tab1.newInstances(mSearchTerm);
                return tab1;

            case 1:
                Tab2 tab2 = new Tab2();
                tab2.newInstances(mSearchTerm);
                return tab2;
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    public void setTextQueryChanged(String newText) {
        mSearchTerm = newText;
    }

}

