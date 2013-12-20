package com.assignment.hipstergram;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SimpleArrayAdapter extends ArrayAdapter<ImageBlock> {
    private final Context context;
    private final List<ImageBlock> values;


    public SimpleArrayAdapter(Context context, int resource, List<ImageBlock> objects) {
        super(context, resource, objects);
        this.context=context;
        this.values=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.fileName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView date=(TextView)rowView.findViewById(R.id.date);
        textView.setText(values.get(position).getTitle());
        date.setText(values.get(position).getDate());
        imageView.setImageURI(Uri.parse(values.get(position).getPath()));
        return rowView;
    }
}
