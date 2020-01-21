package com.example.myfmrvinterfaceviewmodel.ui.myModel;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    private double rate;
    private int image;
    private String country;

    public MyParentModel() {
    }

    public MyParentModel(double rate) {
        this.rate = rate;
    }

    public MyParentModel(double rate, int image, String country) {
        this.rate = rate;
        this.image = image;
        this.country = country;
    }

    protected MyParentModel(Parcel in) {
        rate = in.readDouble();
        image = in.readInt();
        country = in.readString();
    }

    public static final Creator<MyParentModel> CREATOR = new Creator<MyParentModel>() {
        @Override
        public MyParentModel createFromParcel(Parcel in) {
            return new MyParentModel(in);
        }

        @Override
        public MyParentModel[] newArray(int size) {
            return new MyParentModel[size];
        }
    };

    public double getRate() {
        return rate;
    }

    public int getImage() {
        return image;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(rate);
        dest.writeInt(image);
        dest.writeString(country);
    }
}
