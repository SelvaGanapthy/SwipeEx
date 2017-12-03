package com.example.admin.swipeex.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.swipeex.MainActivity;
import com.example.admin.swipeex.R;
import com.example.admin.swipeex.adapters.Tab2Adapter;
import com.example.admin.swipeex.interfaces.IDataCallback;
import com.example.admin.swipeex.interfaces.IFragmentListener;
import com.example.admin.swipeex.interfaces.ISearch;
import com.example.admin.swipeex.models.Tab1Model;
import com.example.admin.swipeex.models.Tab2Model;

import java.util.ArrayList;

/**
 * Created by Admin on 11/7/2017.
 */

public class Tab2 extends Fragment implements ISearch {
    private static final String ARG_SEARCHTERM = "search_term";
    private String mSearchTerm = null;
    ArrayList<Tab1Model> strings = new ArrayList<>();
    private IFragmentListener mIFragmentListener = null;
    Tab2Adapter adapter;
    RecyclerView rv;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab2, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
//        ((MainActivity) getActivity()).setiDataCallback(this);

        if (getArguments() != null) {
            mSearchTerm = (String) getArguments().get(ARG_SEARCHTERM);
        }
        for (int i = 0; i < 5; i++) {
            Tab1Model data = new Tab1Model();
            data.setItems("ss" + i);
            strings.add(data);
        }
        adapter = new Tab2Adapter(strings);
        rv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onTextQuery(String text) {
        adapter.getFilter().filter(text);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mSearchTerm) {
            onTextQuery(mSearchTerm);
        }
    }

    public static Tab2 newInstances(String searchTerm) {
        Tab2 fragment = new Tab2();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SEARCHTERM, searchTerm);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIFragmentListener = (IFragmentListener) context;
        mIFragmentListener.addiSearch(Tab2.this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (null != mIFragmentListener)
            mIFragmentListener.removeISearch(Tab2.this);
    }


//    @Override
//    public void onFragmentCreate(ArrayList<Tab1Model> listData) {
//        strings = listData;
//    }

//    @Override
//    public void onFragmentCreates(ArrayList<Tab2Model> dataList) {
//        strings = dataList;
//    }
}
