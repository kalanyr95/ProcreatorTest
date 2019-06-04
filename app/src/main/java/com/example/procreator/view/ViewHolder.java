package com.example.procreator.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.procreator.R;


//ViewHolder == CELLULE qui correspond à row_layout.xml
public class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView txtFirstLine;
    public TextView txtFooter;
    public View layout;
    public ImageView imgPortrait;

    public ViewHolder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        imgPortrait = (ImageView) v.findViewById(R.id.portrait);
    }
}