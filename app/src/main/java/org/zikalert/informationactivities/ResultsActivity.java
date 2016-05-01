package org.zikalert.informationactivities;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.zikalert.informationactivities.QuizActivity;

import org.zikalert.R;
public class ResultsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this enable the left arrow in the actionbar so we can go back to the MainActivity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //The Default title is the name of the class, so we need to change it:
        getSupportActionBar().setTitle("Results");

        Intent Result = getIntent();
                String score = Result.getStringExtra("USER_SCORE");

        TextView results = (TextView) findViewById(R.id.textViewResults);
        results.setText(score);

    }

}
