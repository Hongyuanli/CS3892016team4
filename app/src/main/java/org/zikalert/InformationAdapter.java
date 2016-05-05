package org.zikalert;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import org.zikalert.informationactivities.AboutActivity;
import org.zikalert.informationactivities.AreaActivity;
import org.zikalert.informationactivities.PregnantActivity;
import org.zikalert.informationactivities.PreventionActivity;
import org.zikalert.informationactivities.SymptomsActivity;
import org.zikalert.informationactivities.TransmissionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luiz Fernando on 4/25/2016.
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {

    List<Information> list;
    Activity mActivity;

    public InformationAdapter(Activity activity){
        super();
        this.mActivity = activity;

        list = new ArrayList<Information>();


        list.add(new Information("Introduction", R.drawable.pb_hi, AboutActivity.class));
        list.add(new Information("Transmission", R.drawable.pb_mosquito, TransmissionActivity.class));
        list.add(new Information("Symptoms", R.drawable.pb_symptoms, SymptomsActivity.class));
        list.add(new Information("Prevention", R.drawable.pb_prevention, PreventionActivity.class));
        list.add(new Information("Contaminated Areas", R.drawable.pb_globe, AreaActivity.class));
        list.add(new Information("Pregnant Woman", R.drawable.pb_pregnant, PregnantActivity.class));

    }

    @Override
    public InformationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_information_horizontal,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InformationAdapter.ViewHolder viewHolder, int position) {
        final Information info = list.get(position);
        viewHolder.thumbnail.setImageResource(info.getThumbnail());
        viewHolder.title.setText(info.getTitle());

        viewHolder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, info.getActivity());
                mActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnail;
        public TextView title;

        public ViewHolder(View itemView){
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.information_thumbnail);
            title = (TextView) itemView.findViewById(R.id.information_title);
        }
    }
}
