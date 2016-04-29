package org.zikalert.informationactivities;

 import android.os.Bundle;

        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;

        import org.zikalert.R;
public class QuizActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_quiz);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            //this enable the left arrow in the actionbar so we can go back to the MainActivity.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            //The Default title is the name of the class, so we need to change it:
            getSupportActionBar().setTitle("Quiz");
        }


}