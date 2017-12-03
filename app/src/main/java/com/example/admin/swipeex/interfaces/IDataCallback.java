package com.example.admin.swipeex.interfaces;

import com.example.admin.swipeex.models.Tab1Model;
import com.example.admin.swipeex.models.Tab2Model;

import java.util.ArrayList;

/**
 * Created by Dell on 12/1/2017.
 */

public interface IDataCallback {
    void onFragmentCreate(ArrayList<Tab1Model> listData);
//    void onFragmentCreates(ArrayList<Tab2Model> dataList);
}
