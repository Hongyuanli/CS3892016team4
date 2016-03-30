package org.zikalert.fragments;

/**
 * Created by Luiz Fernando on 3/18/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.zikalert.R;

/**
 * Fragment for News section.
 */
public class NewsFragment extends Fragment {

    public NewsFragment() { //Default blank constructor required.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        return rootView;
    }
}
