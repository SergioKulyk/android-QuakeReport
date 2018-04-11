package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Load a list of earthquake by using AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /**
     * Tag for log message.
     */
    private final static String LOG_TAG = EarthquakeLoader.class.getName();

    /**
     * Query Url.
     */
    private String mUrl;

    /**
     * Create a new {@link EarthquakeAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param url     is the query url.
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This method runs on a background thread and performs the network request.
     * We should not update the UI from a background thread, so we return a list of
     * {@link Earthquake}s as the result.
     */
    @Override
    public List<Earthquake> loadInBackground() {
        // Don't perform this this request if the URL is null.
        if (mUrl == null) return null;

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
