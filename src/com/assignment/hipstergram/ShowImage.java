package com.assignment.hipstergram;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowImage extends Activity {
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Intent intent=getIntent();

        setContentView(R.layout.showimage);
        ImageView view=(ImageView)findViewById(R.id.imageView);
        view.setImageURI(Uri.parse(intent.getStringExtra("path")));
    }

}
