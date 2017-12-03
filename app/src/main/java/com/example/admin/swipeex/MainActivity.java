package com.example.admin.swipeex;

import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.admin.swipeex.fragments.MyAdapter;
import com.example.admin.swipeex.interfaces.IDataCallback;
import com.example.admin.swipeex.interfaces.IFragmentListener;
import com.example.admin.swipeex.interfaces.ISearch;
import com.example.admin.swipeex.models.Tab1Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, IFragmentListener {
    ViewPager vp;
    TabLayout tabLayout;
    Toolbar toolbar;
    MyAdapter adapter;
    String nextText;
    private MenuItem searchMenuItem;
    ArrayList<Tab1Model> listData = new ArrayList<>();
    IDataCallback iDataCallback = null;
    ArrayList<ISearch> iSearch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sdfdsfds");
        setSupportActionBar(toolbar);
        vp = (ViewPager) findViewById(R.id.view1);
        tabLayout = (TabLayout) findViewById(R.id.tab1);
        adapter = new MyAdapter(getSupportFragmentManager(), nextText);
        vp.setAdapter(adapter);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(vp);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

//    public void getDataFromFragment_one(ArrayList<Tab1Model> listData) {
//        this.listData = listData;
////        Log.e("-->", "" + listData.toString());
//    }

    @Override
    public boolean onQueryTextChange(String newText) {
        this.nextText = newText;
        adapter.setTextQueryChanged(newText);
        for (ISearch iSearchLocal : this.iSearch)
            iSearchLocal.onTextQuery(newText);
        return true;
    }

    @Override
    public void addiSearch(ISearch iSearch) {
        this.iSearch.add(iSearch);
    }

    @Override
    public void removeISearch(ISearch iSearch) {
        this.iSearch.remove(iSearch);
    }

//    public void setiDataCallback(IDataCallback iDataCallback) {
//        this.iDataCallback = iDataCallback;
//        iDataCallback.onFragmentCreate(listData);
//    }
}
