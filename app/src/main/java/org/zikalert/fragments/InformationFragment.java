package org.zikalert.fragments;

/**
 * Created by Luiz Fernando on 3/18/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.zikalert.InformationAdapter;
import org.zikalert.NewsAdapter;
import org.zikalert.informationactivities.AboutActivity;
import org.zikalert.informationactivities.AreaActivity;
import org.zikalert.informationactivities.PregnantActivity;
import org.zikalert.informationactivities.PreventionActivity;
import org.zikalert.R;
import org.zikalert.informationactivities.SymptomsActivity;
import org.zikalert.informationactivities.TransmissionActivity;

/**
 * Fragment for Information section.
 */
public class InformationFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    InformationAdapter mAdapter;

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

        mRecyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view_information);
        mRecyclerView.setHasFixedSize(true);

        //code for horizontal scroll view
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getView().getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(linearLayoutManager);


        //code for default vertical scroll
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getView().getContext()));

        //code for GridLayout
        mRecyclerView.setLayoutManager(new GridLayoutManager(getView().getContext(),2));

        mAdapter = new InformationAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);



    }
}