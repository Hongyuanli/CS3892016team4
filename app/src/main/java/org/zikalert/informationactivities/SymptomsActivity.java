package org.zikalert.informationactivities;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.zikalert.R;

public class SymptomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //OBS: when you create a new activity by new -> activity -> blank activity
        //it creates 2 layouts for a activity: the activity_name.xml that contains the toolbar
        //and the content_name.xml that contains the content itself.
        setContentView(R.layout.activity_symptoms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this enable the left arrow in the actionbar so we can go back to the MainActivity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //The Default title is the name of the class, so we need to change it:
        getSupportActionBar().setTitle("Symptoms, Diagnosis and Treatment");
    }

}