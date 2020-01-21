package com.example.myfmrvinterfaceviewmodel.ui.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfmrvinterfaceviewmodel.R;
import com.example.myfmrvinterfaceviewmodel.ui.myModel.MyChildModel;
import com.example.myfmrvinterfaceviewmodel.ui.myViewModel.MyViewModel;

public class FragmentB extends Fragment {

    MyViewModel myViewModel;
    ImageView imageView;
    TextView tvCountry,tvRates,tvCalRates;
    EditText edittext;
    Button button;
    MyChildModel myChildModel,myChildModel2;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create ViewModel
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        findView(v);
        return v;
    }

    private void findView(View v) {
        imageView = v.findViewById(R.id.imageView);
        tvCountry = v.findViewById(R.id.tvCountry);
        tvRates = v.findViewById(R.id.tvRates);
        tvCalRates = v.findViewById(R.id.tvCalRates);
        edittext = v.findViewById(R.id.edittext);
        button = v.findViewById(R.id.button);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // getArgument
        myChildModel = new MyChildModel();

        if(getArguments() != null){

            myChildModel = getArguments().getParcelable("key");

            imageView.setImageResource(myChildModel.getImage());
            tvCountry.setText(myChildModel.getCountry());
            tvRates.setText(""+myChildModel.getRate());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Protect Error Input
                    try {
                        double input = Double.parseDouble(edittext.getText().toString());

                        if(input > 0){

                            myChildModel2 = new MyChildModel(myChildModel.getRate(),input);

                            // setValue Viewmodel
                            myViewModel.setValue(myChildModel2);

                        }else {
                            tvCalRates.setText("Error from input => input > 0 Only");
                        }

                    }catch (NumberFormatException e){
                        tvCalRates.setText("Error from input => input number only");
                    }
                }
            });

        }
        // reStore value from ViewModel
        viewModelGetValue();
    }

    private void viewModelGetValue() {

        myViewModel.getValue().observe(getActivity(), new Observer<MyChildModel>() {
            @Override
            public void onChanged(MyChildModel myChildModel) {
                tvCalRates.setText(""+myChildModel.getResult());
            }
        });
    }
}
