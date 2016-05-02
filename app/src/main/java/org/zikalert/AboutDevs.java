package org.zikalert;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.zikalert.R;

public class AboutDevs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //OBS: when you create a new activity by new -> activity -> blank activity
        //it creates 2 layouts for a activity: the activity_name.xml that contains the toolbar
        //and the content_name.xml that contains the content itself.
        setContentView(R.layout.activity_aboutdevs);

        //this enable the left arrow in the actionbar so we can go back to the MainActivity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //The Default title is the name of the class, so we need to change it:
        getSupportActionBar().setTitle("About");

        ImageView iconGithub = (ImageView) findViewById(R.id.iconGithub);
        iconGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/paceuniversity/CS3892016team4";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        TextView references = (TextView) findViewById(R.id.textViewReferences);
        references.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://pastebin.com/K6NjBAbV";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

}