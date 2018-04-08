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
import java.util.List;
import java.util.Locale;

/**
 * {@link ReportAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Report} objects.
 */
public class ReportAdapter extends ArrayAdapter<Report> {

    /**
     * Create a new {@link ReportAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param reports is the list of {@link Report}s to be displayed.
     */
    public ReportAdapter(@NonNull Context context, @NonNull List<Report> reports) {
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
        Report report = getItem(position);

        // Find the TextView in the list_item.xml with ID mag_text_view.
        TextView magTextView = reportView.findViewById(R.id.mag_text_view);
        // Get the current mag of the earthquake and set
        // it for the text view.
        magTextView.setText(String.valueOf(report.getMag()));

        // Find the TextView in the list_item.xml with ID place_text_view.
        TextView placeTextView = reportView.findViewById(R.id.place_text_view);
        // Get the current place of the earthquake and set
        // it for the text view.
        placeTextView.setText(report.getPlace());
        // Find the TextView in the list_item.xml with ID mag_text_view.

        // Pattern for create an output format.
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

        // Find the TextView in the list_item.xml with ID time_text_view.
        TextView timeTextView = reportView.findViewById(R.id.time_text_view);
        // Get the current place of the earthquake and set
        // it for the text view.
        timeTextView.setText(String.valueOf(dateFormat.format(report.getTime())));

        return reportView;
    }
}
