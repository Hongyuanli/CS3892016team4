package org.zikalert.fragments;

/**
 * Created by Luiz Fernando on 3/18/2016.
 */

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buzzilla.webhose.client.WebhoseClient;
import com.buzzilla.webhose.client.WebhosePost;
import com.buzzilla.webhose.client.WebhoseQuery;
import com.buzzilla.webhose.client.WebhoseResponse;
import com.squareup.picasso.Picasso;

import org.zikalert.NewsAdapter;
import org.zikalert.R;

import java.io.IOException;

/**
 * Fragment for News section.
 */
public class NewsFragment extends Fragment {

    private final String webhoseToken = "fefad8c8-e6e8-43f8-986e-c8b26946feee";

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    NewsAdapter mAdapter;

    public NewsFragment() { //Default blank constructor required.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mRecyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getView().getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


        new GetNews().execute();

    }

    class GetNews extends AsyncTask<Void,Void,WebhoseResponse>{

        ProgressDialog progress = new ProgressDialog(getContext());

        @Override
        protected WebhoseResponse doInBackground(Void... params) {

            progress.setTitle("Loading");
            progress.setMessage("Wait while loading...");

            WebhoseResponse r = null;

            try {
                WebhoseClient client = new WebhoseClient(webhoseToken);

                WebhoseQuery query = new WebhoseQuery();
                query.allTerms.add("zika virus");
                query.someTerms.add("aedes");
                query.someTerms.add("aegypti");
                query.someTerms.add("microcefalia");
                query.language.add("portuguese");
                r = client.search(query);



            } catch (IOException e) {
                Log.d("NewsFragment", "onActivityCreated: " + e.getMessage());
            }

            return r;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progress.show();
        }

        @Override
        protected void onPostExecute(WebhoseResponse webhoseResponse) {
            // To dismiss the dialog
            progress.dismiss();

            if(webhoseResponse != null){
                //TODO: see if this still works when reloaded
                mAdapter = new NewsAdapter(webhoseResponse.posts,getActivity(),getContext());
                mRecyclerView.setAdapter(mAdapter);

//                WebhosePost p = webhoseResponse.posts.get(0);
//
//                TextView title = (TextView) getView().findViewById(R.id.news_title);
//                title.setText(p.title);
//
//                TextView text = (TextView) getView().findViewById(R.id.news_text);
//                text.setText(p.text);
//
//                TextView timestamp = (TextView) getView().findViewById(R.id.news_timestamp);
//                timestamp.setText(p.published);
//
//
//                //not working, it enters in the loop anyway
////                if(p.thread.mainImage != ""){
////                    ImageView imageView = (ImageView) getView().findViewById(R.id.news_thumbnail);
////                    Picasso.with(getContext()).load(p.thread.mainImage).into(imageView);
////                }
            }

        }
    }
}
