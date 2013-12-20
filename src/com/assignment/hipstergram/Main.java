package com.assignment.hipstergram;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void clickNewPic(View view) {
        Intent intent = new Intent(this, NewPic.class);
        startActivity(intent);
    }


    public void showClickedPics(View view) {
        Intent intent=new Intent(this,ListViewActivity.class);
        startActivity(intent);
    }
}
