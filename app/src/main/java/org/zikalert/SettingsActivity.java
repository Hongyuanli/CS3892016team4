package org.zikalert;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;


public class SettingsActivity extends AppCompatPreferenceActivity {

    private final static String TAG = "SettingsActivity";

    public SettingsActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment()).commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class SettingsFragment extends PreferenceFragment {

        private final static String TAG = "SettingsFragment";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "onCreate");
            addPreferencesFromResource(R.xml.pref_settings);
        }
    }
}