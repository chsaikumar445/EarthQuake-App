package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ArrayList<Earth> earthQuake = QueryUtils.extractEarthquakes();

        ListView earthQuakeView = (ListView) findViewById(R.id.list);

        EarthAdapter adapter = new EarthAdapter(this,earthQuake);

        earthQuakeView.setAdapter(adapter);
    }
}