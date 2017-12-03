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
import com.example.admin.swipeex.adapters.Tab1Adapter;
import com.example.admin.swipeex.interfaces.IFragmentListener;
import com.example.admin.swipeex.interfaces.ISearch;
import com.example.admin.swipeex.models.Tab1Model;

import java.util.ArrayList;

/**
 * Created by Admin on 11/7/2017.
 */

public class Tab1 extends Fragment implements ISearch {
    RecyclerView rv;
    private static final String ARG_SEARCHTERM = "search_term";
    private String mSearchTerm = null;
    View view;
    ArrayList<Tab1Model> strings = new ArrayList<>();
    private IFragmentListener mIFragmentListener = null;
    Tab1Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

        for (int i = 0; i < 20; i++) {
            Tab1Model data = new Tab1Model();
            data.setItems("item" + i);
            strings.add(data);
        }
        adapter = new Tab1Adapter(strings);
        rv.setAdapter(adapter);

        MainActivity mainActivity = (MainActivity) getActivity();
//        mainActivity.getDataFromFragment_one(strings);
//        if (getArguments() != null) {
//            mSearchTerm = (String) getArguments().get(ARG_SEARCHTERM);
//        }

        return view;
    }


    public static Tab1 newInstances(String searchTerm) {
        Tab1 fragment = new Tab1();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SEARCHTERM, searchTerm);
        fragment.setArguments(bundle);
        return fragment;
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIFragmentListener = (IFragmentListener) context;
        mIFragmentListener.addiSearch(Tab1.this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (null != mIFragmentListener)
            mIFragmentListener.removeISearch(Tab1.this);
    }
}
