package org.zikalert.fragments;

/**
 * Created by Luiz Fernando on 3/18/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.zikalert.ChecklistAdapter;
import org.zikalert.R;

/**
 * Fragment for Checklist section.
 */
public class ChecklistFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ChecklistAdapter mAdapter;

    public ChecklistFragment() { //Default blank constructor required.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_checklist, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);

        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view_checklist);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getView().getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ChecklistAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_checklist, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_item){
            mAdapter.addItem("New Item");
            return true;
        }
        return false;
    }
}