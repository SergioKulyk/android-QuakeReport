package com.example.android.quakereport;

import java.util.Date;

/**
 * Contains all information about the earthquake
 * which has been recently.
 */
public class Report {

    /** How powerful the earthquake is */
    private float mag;

    /** Where the earthquake was */
    private String place;

    /** When the earthquake was */
    private Date time;

    /**
     * Create a new {@link Report} object.
     *
     * @param mag   is the mark from 0.0 for 10.0 of the earthquake.
     * @param place is the earthquake place in the world.
     * @param time  is time when the earthquake snake.
     */
    public Report(float mag, String place, Date time) {
        this.mag = mag;
        this.place = place;
        this.time = time;
    }

    /**
     * Get the mag mark of the earthquake.
     *
     * @return the mag mark.
     */
    public float getMag() {
        return mag;
    }

    /**
     * Get the earthquake place in the world.
     *
     * @return the mag mark.
     */
    public String getPlace() {
        return place;
    }

    /**
     * Get the time when the earthquake snake.
     *
     * @return the mag mark.
     */
    public Date getTime() {
        return time;
    }
}
