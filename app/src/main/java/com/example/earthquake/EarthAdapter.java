package com.example.earthquake;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class EarthAdapter extends ArrayAdapter<Earth> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthAdapter(Context context, ArrayList<Earth> arrayList){
        super(context,0,arrayList);
    }

    private String formatDate(Date dateObj){
     SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, \n yyyy");
        return     dateFormatter.format(dateObj);
    }

    private String formatTime(Date dateObj){
    SimpleDateFormat timeFormatter = new SimpleDateFormat("h:m a");
    return timeFormatter.format(dateObj);
    }

    private  int getMagnitudeColor(Double magnitude){
        int magnitudeColor;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
        return magnitudeColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentItemView = convertView;

        if(currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.word_list,parent,false);
        }
        Earth earthobj = getItem(position);

        TextView magnitude = currentItemView.findViewById(R.id.mag_text_view);
        DecimalFormat formatter = new DecimalFormat("0.0");
        Double mag = earthobj.getmMagnitude();

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(mag);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String output = formatter.format(mag);
        magnitude.setText(output);

        TextView LocationOfset_view = currentItemView.findViewById(R.id.LocationOfset_text_view);
        TextView primaryLocation_view = currentItemView.findViewById(R.id.primaryLocation_text_view);
        String location = earthobj.getmCity();
        String primary_location,locationOfset;

        if(location.contains(LOCATION_SEPARATOR)){
            String[] parts = location.split(LOCATION_SEPARATOR);
            locationOfset = parts[0] + LOCATION_SEPARATOR;
            primary_location = parts[1];
        }
        else {
            locationOfset = getContext().getString(R.string.near_the);
            primary_location = location;

        }
        LocationOfset_view.setText(locationOfset);
        primaryLocation_view.setText(primary_location);

        long timeLn =earthobj.getmtimeInMilliSec();
        Date dateObj = new Date(timeLn);

        TextView date = currentItemView.findViewById(R.id.date_text_view);
         String dateToDisplay = formatDate(dateObj);
         date.setText(dateToDisplay);

        TextView time = currentItemView.findViewById(R.id.time_text_view);
        String timeToDisplay =formatTime(dateObj) ;
        time.setText(timeToDisplay);
        return currentItemView;

    }
}
