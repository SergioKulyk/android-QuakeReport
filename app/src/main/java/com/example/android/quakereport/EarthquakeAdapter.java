package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
        TextView magnitudeView = reportView.findViewById(R.id.magnitude);
        // Format the magnitude to show 1 decimal place.
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        // Display current magnitude of the earthquake.
        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        // Set background color for magnitude View.
        magnitudeView.setBackground(magnitudeCircle);

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
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return color of the background magnitude View.
     *
     * @param magnitude is magnitude of the current earthquake.
     */
    private int getMagnitudeColor(double magnitude) {
        // Background color of the magnitude
        int magnitudeColorResourceId;

        // Finding the closest integer less than the decimal value.
        // Switch doesn't support double elements checking.
        int magnitudeFloor = (int) Math.floor(magnitude);

        // Get background color according to the magnitude value.
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
        }

        // Return background color of the magnitude.
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
