package com.example.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EarthAdapter extends ArrayAdapter<Earth> {

    public EarthAdapter(Context context, ArrayList<Earth> arrayList){
        super(context,0,arrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentItemView = convertView;

        if(currentItemView == null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.word_list,parent,false);
        }
        Earth earthobj = getItem(position);

        TextView magnitude = currentItemView.findViewById(R.id.mag_text_view);
        magnitude.setText(""+earthobj.getmMagnitude());

        TextView city = currentItemView.findViewById(R.id.city_text_view);
        city.setText(earthobj.getmCity());

        TextView date = currentItemView.findViewById(R.id.date_text_view);
        date.setText(earthobj.getmDate());

        return currentItemView;

    }
}
