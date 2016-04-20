package org.zikalert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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

    Activity mActivity;
    List<WebhosePost> mPosts;
    Context mContext;

    public NewsAdapter(List<WebhosePost> posts, Activity activity){
        super();
        mPosts = posts;
        mActivity = activity;
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
        final WebhosePost webhosePost = mPosts.get(position);

        holder.newsTitle.setText(webhosePost.title);
        holder.newsText.setText(webhosePost.text);
        holder.newsTimestamp.setText(webhosePost.published);

        //get image with Picasso and mContent
        holder.imgThumbnail.setImageResource(R.drawable.aboutzika);

        holder.newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webhosePost.url));
                mActivity.startActivity(browserIntent);
            }
        });

        holder.newsShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, webhosePost.title + ": "+ webhosePost.url);
                sendIntent.setType("text/plain");
                mActivity.startActivity(sendIntent);
            }
        });




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
        public ImageView newsShare;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.news_thumbnail);
            newsTitle = (TextView)itemView.findViewById(R.id.news_title);
            newsText = (TextView)itemView.findViewById(R.id.news_text);
            newsTimestamp = (TextView)itemView.findViewById(R.id.news_timestamp);
            newsShare = (ImageView) itemView.findViewById(R.id.news_share);
        }
    }
}
