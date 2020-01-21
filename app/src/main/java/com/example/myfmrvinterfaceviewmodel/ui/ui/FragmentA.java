package com.example.myfmrvinterfaceviewmodel.ui.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfmrvinterfaceviewmodel.R;
import com.example.myfmrvinterfaceviewmodel.ui.myAdapter.MyAdapter;
import com.example.myfmrvinterfaceviewmodel.ui.myInterface.MyListener;
import com.example.myfmrvinterfaceviewmodel.ui.myModel.MyChildModel;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    RecyclerView _myRecyclerView;
    MyListener listener;
    MyAdapter myAdapter;
    ArrayList<MyChildModel> listData = new ArrayList<>();
    View v;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (v == null) {
            v = inflater.inflate(R.layout.fragment_a, container, false);

            setMyData();
            setMyLayout(v);
            setMyAdapter();
        }
        return v;
    }

    private void setMyData() {
        double rate[] = {100, 200, 300, 400, 500, 600, 700, 800, 900};
        int image[] = {R.drawable.brazil, R.drawable.ghana, R.drawable.island,
                R.drawable.japan, R.drawable.polynesia, R.drawable.southkorea,
                R.drawable.spain, R.drawable.unitedkingdom, R.drawable.usa};
        String country[] = {"brazil", "ghana", "island", "japan", "polynesia",
                "southkorea", "spain", "unitedkingdom", "usa"};

        int dataSize = rate.length;

        for (int i = 0; i < dataSize; i++) {
            MyChildModel myChildModel = new MyChildModel(rate[i], image[i], country[i]);
            listData.add(myChildModel);
        }
    }

    private void setMyLayout(View v) {
        _myRecyclerView = v.findViewById(R.id.myRecyclerView);
        _myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setMyAdapter() {
        myAdapter = new MyAdapter(getActivity(), listData, listener);
        _myRecyclerView.setAdapter(myAdapter);
    }

}
