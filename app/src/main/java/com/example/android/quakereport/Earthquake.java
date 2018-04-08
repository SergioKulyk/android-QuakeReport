package com.example.android.quakereport;

/**
 * A {@link Earthquake} object contains all information about the single earthquake.
 * which has been recently.
 */
public class Earthquake {

    /** Magnitude of the earthquake */
    private String mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /**
     * Create a new {@link Earthquake} object.
     *
     * @param mMagnitude          is the magnitude (size) the earthquake.
     * @param mLocation           is the city location of the earthquake.
     * @param mTimeInMilliseconds is the date the earthquake happened.
     */
    public Earthquake(String mMagnitude, String mLocation, long mTimeInMilliseconds) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    /**
     * Return the magnitude of the earthquake.
     */
    public String getMagnitude() {
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
}
