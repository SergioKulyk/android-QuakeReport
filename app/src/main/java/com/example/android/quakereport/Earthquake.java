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

    /** Date of the earthquake */
    private String mDate;

    /**
     * Create a new {@link Earthquake} object.
     *
     * @param mMagnitude is the magnitude (size) the earthquake.
     * @param mLocation  is the city location of the earthquake.
     * @param mDate      is the date the earthquake happened.
     */
    public Earthquake(String mMagnitude, String mLocation, String mDate) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mDate = mDate;
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
     * Return the date of the earthquake.
     */
    public String getDate() {
        return mDate;
    }
}
