package org.zikalert.informationactivities;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.zikalert.informationactivities.QuizActivity;

import org.zikalert.R;
public class ResultsActivity extends AppCompatActivity {

    private String score;

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
        score = Result.getStringExtra("USER_SCORE");

        TextView results = (TextView) findViewById(R.id.textViewResults);
        results.setText(score);

        Button share = (Button) findViewById(R.id.btn_quiz_share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String share = "I downloaded the ZikAlert app and got " +score+"/6 at the quiz! Download it now on Play Store!";
                intent.putExtra(Intent.EXTRA_TEXT,share);
                startActivity(Intent.createChooser(intent, "Share"));
            }
        });

    }

}
