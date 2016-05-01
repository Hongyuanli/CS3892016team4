package org.zikalert.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.zikalert.informationactivities.AboutActivity;
import org.zikalert.informationactivities.AreaActivity;
import org.zikalert.informationactivities.PregnantActivity;
import org.zikalert.informationactivities.PreventionActivity;
import org.zikalert.R;
import org.zikalert.informationactivities.QuizActivity;
import org.zikalert.informationactivities.SymptomsActivity;
import org.zikalert.informationactivities.TransmissionActivity;

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

        CardView card_view = (CardView) getView().findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //So we decided to create a new activity based on the type of information clicked
                //instead of changing the fragment.
                //This is how we call another activity by creating intents.
                //http://developer.android.com/training/basics/firstapp/starting-activity.html
                Intent intent = new Intent(getActivity(),AboutActivity.class);
                startActivity(intent);
            }
        });

       CardView card_view2 = (CardView) getView().findViewById(R.id.card_view2);
        card_view2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              Intent intent = new Intent(getActivity(),AreaActivity.class);
                startActivity(intent);
            }
        });

        CardView card_view3 = (CardView) getView().findViewById(R.id.card_view3);
        card_view3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SymptomsActivity.class);
                startActivity(intent);
            }
        });

        CardView card_view4 = (CardView) getView().findViewById(R.id.card_view4);
        card_view4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PreventionActivity.class);
                startActivity(intent);
            }
        });

        CardView card_view5 = (CardView) getView().findViewById(R.id.card_view5);
        card_view5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TransmissionActivity.class);
                startActivity(intent);
            }
        });

        CardView card_view6 = (CardView) getView().findViewById(R.id.card_view6);
        card_view6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PregnantActivity.class);
                startActivity(intent);
            }
        });

        CardView card_view7 = (CardView) getView().findViewById(R.id.card_view7);
        card_view7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);
            }
        });


    }
}