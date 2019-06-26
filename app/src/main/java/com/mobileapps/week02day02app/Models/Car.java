package com.mobileapps.week02day02app.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable
{
    private String make;
    private String model;
    private String year;
    private String color;
    private String transmissionType;
    private String engineSize;

    public Car(String make, String model, String year, String color, String transmissionType, String engineSize) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.transmissionType = transmissionType;
        this.engineSize = engineSize;
    }

    public Car() {
    }

    protected Car(Parcel in) {
        make = in.readString();
        model = in.readString();
        year = in.readString();
        color = in.readString();
        transmissionType = in.readString();
        engineSize = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(year);
        dest.writeString(color);
        dest.writeString(transmissionType);
        dest.writeString(engineSize);
    }
}
