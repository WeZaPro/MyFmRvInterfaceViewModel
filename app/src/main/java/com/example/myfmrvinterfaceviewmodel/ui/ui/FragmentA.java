package com.example.myfmrvinterfaceviewmodel.ui.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfmrvinterfaceviewmodel.R;

public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_a, container, false);

        findView(v);

        if(v == null){

           setMyData();
           setMyLayout(v);
           setMyAdapter();

        }
        return v;
    }

    private void findView(View v) {

    }

    private void setMyData() {


    }

    private void setMyLayout(View v) {

    }

    private void setMyAdapter() {

    }

}
