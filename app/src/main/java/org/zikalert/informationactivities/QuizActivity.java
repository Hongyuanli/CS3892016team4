package org.zikalert.informationactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.zikalert.R;
public class QuizActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioGroup radioGroup6;
    private Button button;
    public int score = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //this enable the left arrow in the actionbar so we can go back to the MainActivity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //The Default title is the name of the class, so we need to change it:
        getSupportActionBar().setTitle("Quiz");

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.resultsBtn);
        button.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
                radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
                radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
                radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
                radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
                radioGroup6 = (RadioGroup) findViewById(R.id.radioGroup6);


                //QUESTION 1
                if (radioGroup.getCheckedRadioButtonId() == -1){

                    Toast.makeText(getApplicationContext(), "Question1 was not answered",
                            Toast.LENGTH_SHORT).show();

                } else {

                    switch (radioGroup.getCheckedRadioButtonId()){

                        case R.id.radioBtn1Grp1:
                            //wrong answer
                            break;
                        case R.id.radioBtn2Grp1:
                            score++;
                            break;
                    }
                }

                //QUESTION 2
                if (radioGroup2.getCheckedRadioButtonId() == -1){

                    Toast.makeText(getApplicationContext(), "Question2 was not answered",
                            Toast.LENGTH_SHORT).show();

                } else {

                    switch (radioGroup2.getCheckedRadioButtonId()){

                        case R.id.radioBtn1Grp2:
                            score++;
                            break;
                        case R.id.radioBtn2Grp2:
                            //wrong answer
                            break;
                    }
                }

                //QUESTION 3
                if (radioGroup3.getCheckedRadioButtonId() == -1){

                    Toast.makeText(getApplicationContext(), "Question3 was not answered",
                            Toast.LENGTH_SHORT).show();

                } else {

                    switch (radioGroup3.getCheckedRadioButtonId()){

                        case R.id.radioBtn1Grp3:
                            score++;
                            break;
                        case R.id.radioBtn2Grp3:
                            //wrong answer
                            break;
                    }
                }

                //QUESTION 4
                if (radioGroup4.getCheckedRadioButtonId() == -1){

                    Toast.makeText(getApplicationContext(), "Question4 was not answered",
                            Toast.LENGTH_SHORT).show();

                } else {

                    switch (radioGroup4.getCheckedRadioButtonId()){

                        case R.id.radioBtn1Grp4:
                            //wrong answer
                            break;
                        case R.id.radioBtn2Grp4:
                            score++;
                            break;
                    }
                }

                //QUESTION 5
                if (radioGroup5.getCheckedRadioButtonId() == -1){

                    Toast.makeText(getApplicationContext(), "Question5 was not answered",
                            Toast.LENGTH_SHORT).show();

                } else {

                    switch (radioGroup5.getCheckedRadioButtonId()){

                        case R.id.radioBtn1Grp5:
                            //wrong answer
                            break;
                        case R.id.radioBtn2Grp5:
                            score++;
                            break;
                    }
                }

                //QUESTION 6
                if (radioGroup6.getCheckedRadioButtonId() == -1){

                    Toast.makeText(getApplicationContext(), "Question6 was not answered",
                            Toast.LENGTH_SHORT).show();

                } else {

                    switch (radioGroup6.getCheckedRadioButtonId()){

                        case R.id.radioBtn1Grp6:
                            //wrong answer
                            break;
                        case R.id.radioBtn2Grp6:
                            score++;
                            break;
                    }
                }







                Intent startNewActivity = new Intent(QuizActivity.this, ResultsActivity.class);
                startNewActivity.putExtra("USER_SCORE", Integer.toString(score));


                startActivity(startNewActivity);

            }

        });

    }


}
