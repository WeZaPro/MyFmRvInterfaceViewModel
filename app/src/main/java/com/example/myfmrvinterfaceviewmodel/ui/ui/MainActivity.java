package com.example.myfmrvinterfaceviewmodel.ui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myfmrvinterfaceviewmodel.R;
import com.example.myfmrvinterfaceviewmodel.ui.myInterface.MyListener;
import com.example.myfmrvinterfaceviewmodel.ui.myModel.MyChildModel;

public class MainActivity extends AppCompatActivity implements MyListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        if(savedInstanceState == null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_top,fragmentA)
                    .commit();


            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_bottom,fragmentB)
                    .commit();

        }

    }

    // get Listener from FmA and send to data FmB from listener
    @Override
    public void myCallBack(MyChildModel myChildModel) {

    }
}
