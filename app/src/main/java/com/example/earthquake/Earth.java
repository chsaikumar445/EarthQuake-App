package com.example.earthquake;

public class Earth {
    private String mMagnitude;
    private String mCity;
    private String mDate;

    public Earth(String Magnitude, String City, String Date){
        mMagnitude = Magnitude;
        mCity = City;
        mDate = Date;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmDate() {
        return mDate;
    }
}
