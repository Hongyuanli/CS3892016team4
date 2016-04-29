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
import java.util.regex.Pattern;

/**
 * Created by Luiz Fernando on 4/10/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    Activity mActivity;
    List<WebhosePost> mPosts;
    Context mContext;

    public NewsAdapter(List<WebhosePost> posts, Activity activity, Context context){
        super();
        mPosts = posts;
        mActivity = activity;
        mContext = context;
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
        holder.newsTimestamp.setText(formatTimestamp(webhosePost.published));

        //get image with Picasso and mContent
        holder.imgThumbnail.setImageResource(R.drawable.aboutzika);

        if(!webhosePost.thread.mainImage.isEmpty()){
            Picasso.with(mContext).load(webhosePost.thread.mainImage).into(holder.imgThumbnail);
        }
        if(!webhosePost.externalLinks.isEmpty()){
            Picasso.with(mContext).load(webhosePost.externalLinks.get(0)).into(holder.imgThumbnail);
        }

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

    private String formatTimestamp(String time){
        //create a regex to split the timestamp
        // \p is for POSIX character classes
        // {Punct} is for punctuations, e.g. slash, double-points
        // {L} is for letters
        // {Sm} is for Math symbols
        // more info: http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        String[] split = time.split("\\p{Punct}|\\p{L}|\\p{Sm}");

        //sum hour with time zone
        int hour = Integer.parseInt(split[3]) + Integer.parseInt(split[7]);
        // MM/DD/YYYY HH:MM
        return split[1]+"/"+split[2]+"/"+split[0]+" "+Integer.toString(hour)+":"+split[4];
    }
}
