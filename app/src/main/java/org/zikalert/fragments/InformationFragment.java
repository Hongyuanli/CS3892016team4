package org.zikalert.fragments;

/**
 * Created by Luiz Fernando on 3/18/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.zikalert.informationactivities.PreventionActivity;
import org.zikalert.R;

/**
 * Fragment for Information section.
 */
public class InformationFragment extends Fragment {


    public InformationFragment() { //Default blank constructor required.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_informations, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Get the button here and trigger the listener
        //In the future this is not going to be a button, but it will be a card.
        Button btnOpenActivity = (Button) getView().findViewById(R.id.btnOpenActivity);
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //So we decided to create a new activity based on the type of information clicked
                //instead of changing the fragment.
                //This is how we call another activity by creating intents.
                //http://developer.android.com/training/basics/firstapp/starting-activity.html
                Intent intent = new Intent(getActivity(),PreventionActivity.class);
                startActivity(intent);
            }
        });
    }
}