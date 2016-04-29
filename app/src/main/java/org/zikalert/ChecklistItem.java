package org.zikalert;

import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Luiz Fernando on 4/29/2016.
 */
public class ChecklistItem {
    private String title;

    ChecklistItem(String title){
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
