package com.example.earthquake;

public class Earth {
    private Double mMagnitude;
    private String mCity;
    private String mDate;

    public Earth(Double Magnitude, String City, String Date){
        mMagnitude = Magnitude;
        mCity = City;
        mDate = Date;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmDate() {
        return mDate;
    }
}
