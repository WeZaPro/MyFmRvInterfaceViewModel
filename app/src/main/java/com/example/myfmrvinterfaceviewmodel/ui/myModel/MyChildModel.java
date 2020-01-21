package com.example.myfmrvinterfaceviewmodel.ui.myModel;

public class MyChildModel extends MyParentModel{

    private double result;

    public MyChildModel() {
    }

    public MyChildModel(double rate, double inputValue) {
        super(rate);
        this.result = rate*inputValue;
    }


    public double getResult() {
        return result;
    }
}
