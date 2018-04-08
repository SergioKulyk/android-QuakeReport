/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        String mystring = "2018-04-07";
        Date thedate = null;
        try {
            thedate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(mystring);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Create a fake list of earthquake locations.
        ArrayList<Report> earthquakes = new ArrayList<>();
        earthquakes.add(new Report(7.2f, "San Francisco", thedate));
        earthquakes.add(new Report(6.1f, "London", thedate));
        earthquakes.add(new Report(3.9f, "Tokyo", thedate));
        earthquakes.add(new Report(5.4f, "Mexico City", thedate));
        earthquakes.add(new Report(2.8f, "Moscow", thedate));
        earthquakes.add(new Report(4.9f, "Rio de Janeiro", thedate));
        earthquakes.add(new Report(1.6f, "Paris", thedate));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        ReportAdapter adapter = new ReportAdapter(EarthquakeActivity.this, earthquakes);


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
