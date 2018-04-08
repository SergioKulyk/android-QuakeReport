package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * {@link EarthquakeAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Earthquake} objects.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Separator for separate location string "94km SSE of Taron, Papua New Guinea"
     * onto "94km SSE of Taron" and "Papua New Guinea"
     */
    private static final String LOCATION_SEPARATOR = " of ";

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
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml with ID magnitude.
        TextView magnitudeTextView = reportView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place.
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        // Display current magnitude of the earthquake.
        magnitudeTextView.setText(formattedMagnitude);

        // Get the location of the current earthquake.
        String originalLocation = currentEarthquake.getLocation();

        // Offset location of the current earthquake.
        String locationOffset;
        // Primary location of the current earthquake.
        String primaryLocation;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            // Split by "of" characters and create location array which contains 2 parts.
            // First item is responsible for length of kilometers between the city and current earthquake.
            // Second item is responsible for name of the city, nearest whom the earthquake happened.
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            // Set kilometers between city and earthquake.
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            // Set primary location of the earthquake.
            primaryLocation = parts[1];
        } else {
            // Set "Near to" position of earthquake,
            // because earthquake was in or near the city.
            locationOffset = getContext().getString(R.string.near_the);
            // Set primary location of the earthquake,
            // original location contains only city and country.
            primaryLocation = originalLocation;
        }

        // Find the TextView in the list_item.xml with ID location_offset.
        TextView locationOffsetView = reportView.findViewById(R.id.location_offset);
        // Display current location offset of the earthquake.
        locationOffsetView.setText(locationOffset);

        // Find the TextView in the list_item.xml with ID primary_location.
        TextView primaryLocationView = reportView.findViewById(R.id.primary_location);
        // Display current primary location of the earthquake.
        primaryLocationView.setText(primaryLocation);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView in the list_item.xml with ID date.
        TextView dateTextView = reportView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984").
        String formattedDate = formatDate(dateObject);
        // Display current date of the earthquake.
        dateTextView.setText(formattedDate);

        // Find the TextView in the list_item.xml with ID time.
        TextView timeTextView = reportView.findViewById(R.id.time);
        // Format the date string (i.e. "Mar 3, 1984").
        String formattedTime = formatTime(dateObject);
        // Display current date of the earthquake.
        timeTextView.setText(formattedTime);

        return reportView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.ENGLISH);
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:m a", Locale.ENGLISH);
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat ("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
