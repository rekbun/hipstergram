package com.assignment.hipstergram;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        final int REQUIRED_SIZE=70;
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = false;
        o.inPreferredConfig = Bitmap.Config.RGB_565;
        o.inDither = true;
        int width_tmp=o.outWidth, height_tmp=o.outHeight;
        int scale=6;
        while(true){
            if(width_tmp/2<REQUIRED_SIZE || height_tmp/2<REQUIRED_SIZE)
            break;
            width_tmp/=2;
            height_tmp/=2;
            scale*=2;
        }

        //decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize=scale;
        o.inJustDecodeBounds = false;
        o.inPreferredConfig = Bitmap.Config.RGB_565;
        o.inDither = true;

        Bitmap bitmap = BitmapFactory.decodeFile(values.get(position).getPath(), o2);

        imageView.setImageBitmap(bitmap);
        return rowView;
    }
}
