package com.zhenman.asus.zhenman.view.serializaion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhenman.asus.zhenman.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelfHistoryFragment extends Fragment {


    public ShelfHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shelf_history, container, false);
    }

}