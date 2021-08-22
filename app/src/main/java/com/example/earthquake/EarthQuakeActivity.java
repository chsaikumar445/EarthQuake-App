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

        ArrayList<Earth> earthQuake = new ArrayList<>();

        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));
        earthQuake.add(new Earth(7.2, "sanfransisco","feb 2,2021"));

        ListView earthQuakeView = (ListView) findViewById(R.id.list);

        EarthAdapter adapter = new EarthAdapter(this,earthQuake);

        earthQuakeView.setAdapter(adapter);
    }
}