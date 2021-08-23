package com.example.earthquake;

public class Earth {
    private Double  mMagnitude;
    private String mCity;
    private long mtimeInMilliSec;

    public Earth(Double Magnitude, String City, long timeInMilliSec){
        mMagnitude = Magnitude;
        mCity = City;
        mtimeInMilliSec = timeInMilliSec;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmCity() {
        return mCity;
    }

    public long getmtimeInMilliSec() {
        return mtimeInMilliSec;
    }
}
