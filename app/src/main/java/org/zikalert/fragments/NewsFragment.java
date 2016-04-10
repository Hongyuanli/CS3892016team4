package org.zikalert.fragments;

/**
 * Created by Luiz Fernando on 3/18/2016.
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buzzilla.webhose.client.WebhoseClient;
import com.buzzilla.webhose.client.WebhosePost;
import com.buzzilla.webhose.client.WebhoseResponse;

import org.zikalert.R;

import java.io.IOException;

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new GetNews().execute();

    }

    class GetNews extends AsyncTask<Void,Void,WebhoseResponse>{
        @Override
        protected WebhoseResponse doInBackground(Void... params) {
            WebhoseResponse r = null;

            try {
                WebhoseClient client = new WebhoseClient("fefad8c8-e6e8-43f8-986e-c8b26946feee");
                r = client.search("zika");



            } catch (IOException e) {
                Log.d("NewsFragment", "onActivityCreated: " + e.getMessage());
            }

            return r;
        }

        @Override
        protected void onPostExecute(WebhoseResponse webhoseResponse) {
            if(webhoseResponse != null){
                WebhosePost p = webhoseResponse.posts.get(0);
                TextView title = (TextView) getView().findViewById(R.id.news_title);
                title.setText(p.title);
            }

        }
    }
}
