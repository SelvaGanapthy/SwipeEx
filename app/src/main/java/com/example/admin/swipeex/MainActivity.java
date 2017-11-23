package com.example.admin.swipeex;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements TabLayout.OnTabSelectedListener {
    ViewPager vp;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.view1);
        tabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        FragmentManager fragmentManager = getSupportFragmentManager();
        vp.setAdapter(new MyAdaper(fragmentManager, tabLayout.getTabCount()));
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(vp);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public class MyAdaper extends FragmentPagerAdapter {
        int tabcount;

        public MyAdaper(FragmentManager fm, int tabcount) {
            super(fm);
            this.tabcount = tabcount;
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
            return tabcount;
        }
    }

}
