package org.zikalert;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luiz Fernando on 4/29/2016.
 */
public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ViewHolder> {

    List<ChecklistItem> mItems;

    public void addItem(String text){
        mItems.add(new ChecklistItem(text));
//        this.notifyItemChanged(mItems.size() - 1);
        notifyDataSetChanged();
    }

    public ChecklistAdapter(){
        super();

        mItems = new ArrayList<ChecklistItem>();

        addItem("Clean flower vase tray");
        addItem("Check for standing water");
        addItem("Use repellent");
        addItem("Put a net on the windows");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_checklist_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        final ChecklistItem item = mItems.get(position);
        holder.editText.setText(item.getTitle());
        holder.editText.setEnabled(false);
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.editText.isEnabled()) {
                    holder.editText.setEnabled(false);
                } else {
                    holder.editText.setEnabled(true);
                }
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAt(position);
            }
        });

        holder.editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                item.setTitle(holder.editText.getText().toString());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public EditText editText;
        public ImageButton btnEdit;
        public ImageButton btnDelete;

        public ViewHolder(View itemView){
            super(itemView);
            editText = (EditText) itemView.findViewById(R.id.checklist_item);
            btnEdit = (ImageButton) itemView.findViewById(R.id.btn_edit_checklist_item);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete_checklist_item);
        }
    }

    public void removeAt(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mItems.size());
    }
}
