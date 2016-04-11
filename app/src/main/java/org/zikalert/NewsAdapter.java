package org.zikalert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buzzilla.webhose.client.WebhosePost;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Luiz Fernando on 4/10/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    List<WebhosePost> mPosts;
    Context mContext;

    public NewsAdapter(List<WebhosePost> posts){
        super();
        mPosts = posts;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_news, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        WebhosePost webhosePost = mPosts.get(position);

        holder.newsTitle.setText(webhosePost.title);
        holder.newsText.setText(webhosePost.text);
        holder.newsTimestamp.setText(webhosePost.published);

        //get image with Picasso and mContent
        holder.imgThumbnail.setImageResource(R.drawable.aboutzika);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView newsTitle;
        public TextView newsText;
        public TextView newsTimestamp;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.news_thumbnail);
            newsTitle = (TextView)itemView.findViewById(R.id.news_title);
            newsText = (TextView)itemView.findViewById(R.id.news_text);
            newsTimestamp = (TextView)itemView.findViewById(R.id.news_timestamp);
        }
    }
}
