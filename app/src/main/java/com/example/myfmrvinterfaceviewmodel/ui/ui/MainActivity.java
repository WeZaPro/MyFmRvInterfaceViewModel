package com.example.myfmrvinterfaceviewmodel.ui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

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

        /*FragmentB fragmentBToSendData = new FragmentB();
        Bundle b = new Bundle();
        b.putParcelable("key",myChildModel);
        fragmentBToSendData.setArguments(b);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer_bottom,fragmentBToSendData)
                .addToBackStack("")
                .commit();*/

        Toast.makeText(getApplicationContext(),"get data is "+myChildModel.getCountry(),
                Toast.LENGTH_SHORT).show();

    }
}
