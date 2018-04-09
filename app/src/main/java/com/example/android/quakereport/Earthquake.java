package com.example.android.quakereport;

/**
 * A {@link Earthquake} object contains all information about the single earthquake.
 * which has been recently.
 */
public class Earthquake {

    /** Magnitude of the earthquake */
    private double mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    private String mUrl;

    /**
     * Create a new {@link Earthquake} object.
     *
     * @param magnitude          is the magnitude (size) the earthquake.
     * @param location           is the city location of the earthquake.
     * @param timeInMilliseconds is the date the earthquake happened.
     * @param url                is the website url of the earthquake.
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * Return the magnitude of the earthquake.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Return the location of the earthquake.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Return the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Return the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude=" + mMagnitude +
                ", mLocation='" + mLocation + '\'' +
                ", mTimeInMilliseconds=" + mTimeInMilliseconds +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}
