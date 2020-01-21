package com.example.myfmrvinterfaceviewmodel.ui.myViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myfmrvinterfaceviewmodel.ui.myModel.MyChildModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<MyChildModel> value = new MutableLiveData<>();

    public void setValue(MyChildModel myChildModel) {
        value.setValue(myChildModel);
    }

    public LiveData<MyChildModel> getValue() {
        return value;
    }

}
