package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * {@link EarthquakeAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Earthquake} objects.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Create a new {@link EarthquakeAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param reports is the list of {@link Earthquake}s to be displayed.
     */
    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> reports) {
        super(context, 0, reports);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view.
        View reportView = convertView;
        if (reportView == null) reportView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);

        // Get the {@link Report} object located at this position in the list.
        Earthquake earthquake = getItem(position);

        // Find the TextView in the list_item.xml with ID mag_text_view.
        TextView magTextView = reportView.findViewById(R.id.magnitude);
        // Display current magnitude of the earthquake.
        magTextView.setText(earthquake.getMagnitude());

        // Find the TextView in the list_item.xml with ID location_text_view.
        TextView placeTextView = reportView.findViewById(R.id.location);
        // Display current location of the earthquake.
        placeTextView.setText(earthquake.getLocation());

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(earthquake.getTimeInMilliseconds());

        // Find the TextView in the list_item.xml with ID date.
        TextView dateTextView = reportView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984").
        String formattedDate = formatDate(dateObject);
        // Display current date of the earthquake.
        dateTextView.setText(formattedDate);

        // Find the TextView in the list_item.xml with ID time.
        TextView timeTextView = reportView.findViewById(R.id.time);
        // Format the date string (i.e. "Mar 3, 1984").
        String formattedTime = formatterDate(dateObject);
        // Display current date of the earthquake.
        timeTextView.setText(formattedTime);

        return reportView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateFormat);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatterDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("H:m a");
        return dateFormat.format(dateFormat);
    }
}
