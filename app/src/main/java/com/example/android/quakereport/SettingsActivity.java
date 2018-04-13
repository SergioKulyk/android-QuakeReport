package com.example.android.quakereport;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * A {@link SettingsActivity} contains all setting for adjust URI
 * for send correct request to the server.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    /**
     * Setting's item to save adjusting properties.
     */
    public static class EarthquakePreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            // Find preference by id "settings_min_magnitude_key".
            Preference minMagnitude = findPreference(getString(R.string.settings_min_magnitude_key));
            // Set minimum magnitude which user wants to see.
            bindPreferenceSummaryToValue(minMagnitude);

            // Find preference by id "settings_order_by_key".
            Preference orderBy = findPreference(getString(R.string.settings_order_by_key));
            // Set represent of earthquake view.
            bindPreferenceSummaryToValue(orderBy);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            // Get string value of current preference.
            String stringValue = value.toString();

            if (preference instanceof ListPreference) {
                // Contains one or more radio buttons.
                ListPreference listPreference = (ListPreference) preference;
                // Get index of preference which is default or was changed.
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                // There are 1 values at least.
                if (prefIndex >= 0) {
                    // Get array of different settings.
                    CharSequence[] labels = listPreference.getEntries();
                    // Store setting.
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                // Store setting of the value which was set.
                preference.setSummary(stringValue);
            }
            return true;
        }

        private void bindPreferenceSummaryToValue(Preference preference) {
            // Get current preference and set change listener for change value.
            preference.setOnPreferenceChangeListener(this);
            // The {@link SharedPreferences} helps change and store data of the current preference.
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());

            // Get preference value by key.
            String preferenceString = preferences.getString(preference.getKey(), "");
            // Store change of the current preference.
            onPreferenceChange(preference, preferenceString);
        }
    }
}
