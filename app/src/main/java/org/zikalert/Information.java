package org.zikalert;

import android.app.Activity;

import org.zikalert.informationactivities.AboutActivity;

/**
 * Created by Luiz Fernando on 4/25/2016.
 */
public class Information {
    private String title;
    private int mThumbnail;
    private Class activity;

    Information(String title, int thumbnail, Class<?> activity){
        this.title = title;
        this.mThumbnail = thumbnail;
        this.activity = activity;
    }

    public Class getActivity() {
        return activity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}
