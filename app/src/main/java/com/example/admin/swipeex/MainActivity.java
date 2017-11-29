package com.example.admin.swipeex;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    TabLayout tabLayout;
    Toolbar toolbar;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sdfdsfds");
        setSupportActionBar(toolbar);
        vp = (ViewPager) findViewById(R.id.view1);
        tabLayout = (TabLayout) findViewById(R.id.tab1);
        adapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(getApplicationContext(), "help", Toast.LENGTH_LONG).show();
                break;

            case R.id.new_game:
                Toast.makeText(getApplicationContext(), "newgame", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
